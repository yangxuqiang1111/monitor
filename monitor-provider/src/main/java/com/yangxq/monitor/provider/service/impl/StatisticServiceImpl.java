package com.yangxq.monitor.provider.service.impl;

import com.yangxq.monitor.common.model.StatisticsDataModel;
import com.yangxq.monitor.common.po.Business;
import com.yangxq.monitor.common.po.Statistics;
import com.yangxq.monitor.common.utils.DateUtil;
import com.yangxq.monitor.common.utils.Global;
import com.yangxq.monitor.common.utils.StringUtil;
import com.yangxq.monitor.dao.mysql.mapper.BusinessMapper;
import com.yangxq.monitor.dao.mysql.mapper.IBaseMapper;
import com.yangxq.monitor.dao.mysql.mapper.StatisticsMapper;
import com.yangxq.monitor.provider.service.StatisticService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yangxq on 2016/8/29.
 */
@Service
public class StatisticServiceImpl extends BaseServiceImpl<Statistics> implements StatisticService<Statistics> {
    @Resource
    private StatisticsMapper statisticsMapper;

    @Resource
    private BusinessMapper businessMapper;

    @Override
    public IBaseMapper<Statistics> getBaseMapper() {
        return this.statisticsMapper;
    }

    @Override
    public StatisticsDataModel list(int businessId, String dateStr) {
        // 判断开始和结束时间
        int begTime = DateUtil.getTodayBegTimeStamp();
        int endTime = DateUtil.getNowTimeStampRmS();
        int timeStart = DateUtil.getTodayEightOclock();
        String xTitle = DateUtil.getFormatDateStr();
        if (!StringUtil.isEmpty(dateStr)) {
            begTime = DateUtil.getDayBegTimeStamp(dateStr);
            endTime = DateUtil.getDayEndTimeStamp(dateStr);
            timeStart = DateUtil.getDayEightOclock(dateStr);
            xTitle = dateStr;
        }
        // 判断business类型
        Business business = businessMapper.selectByPrimaryKey(businessId);
        if (business == null) {
            log.error("id[" + businessId + "]不存在business");
            return null;
        }
        // 查询数据
        List<Statistics> list = statisticsMapper.list(businessId, begTime, endTime);
        if (list.size() == 0) return null;

        // 数据做汇聚
        int total = (endTime - begTime) / 60;
        List<Integer> dataArr = new ArrayList<>(total);
        while (begTime <= endTime) {
            Statistics statistics = null;
            for (int i = 0; i < list.size(); i++) {
                Statistics st = list.get(i);
                if (st.getTime().intValue() == begTime) {
                    statistics = st;
                    break;
                }
            }
            if (statistics != null) {
                dataArr.add(statistics.getNum());
            } else {
                dataArr.add(0);
            }
            begTime += 60;
        }
        // 获取子标题
        String subtitle = null;
        if (business.getType() == Global.BusinessType.DELAY.value) {
            subtitle = Global.getSubTitle(business.getType());
        } else if (business.getType() == Global.BusinessType.TRANSFER.value || business.getType() == Global.BusinessType.ERROR.value) {
            long sum = 0;
            for (int i = 0; i < dataArr.size(); i++) {
                sum += dataArr.get(i);
            }
            subtitle = Global.getSubTitle(business.getType()) + sum;
        }
        // 封装数据
        StatisticsDataModel statisticsDataModel = new StatisticsDataModel();
        statisticsDataModel.setDataArr(dataArr);
        statisticsDataModel.setxTitle(xTitle);
        statisticsDataModel.setTitle(business.getTitle() + "(" + xTitle + ")");
        statisticsDataModel.setName(Global.getName(business.getType()));
        statisticsDataModel.setSubTitle(subtitle);
        statisticsDataModel.setyTitle(Global.getYtitle(business.getType()));
        statisticsDataModel.setTimeStart(timeStart);
        return statisticsDataModel;
    }
}
