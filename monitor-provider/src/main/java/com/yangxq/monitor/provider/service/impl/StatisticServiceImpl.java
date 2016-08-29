package com.yangxq.monitor.provider.service.impl;

import com.yangxq.monitor.common.model.StatisticsDataModel;
import com.yangxq.monitor.common.po.Statistics;
import com.yangxq.monitor.common.utils.DateUtil;
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

    @Override
    public IBaseMapper<Statistics> getBaseMapper() {
        return this.statisticsMapper;
    }

    @Override
    public StatisticsDataModel list(int businessId, int endTime) {
        int beg = DateUtil.getTodayBegTime();
        List<Statistics> list = statisticsMapper.list(businessId, beg, endTime);
        int total = (endTime - beg) / 60;
        List<Integer> dataArr=  new ArrayList<>(total);
        List<String>dates=new ArrayList<>(total);
        while (beg < endTime) {
            Statistics statistics = null;
            for (int i = 0; i < list.size(); i++) {
                Statistics st = list.get(i);
                if (st.getTime().intValue() == beg) {
                    statistics = st;
                    break;
                }
            }
            if (statistics != null) {
                dataArr.add( statistics.getNum());
            } else {
                dataArr.add( 0);
            }
            dates.add(DateUtil.getFormDateString(beg));
            beg += 60;
        }
        StatisticsDataModel statisticsDataModel = new StatisticsDataModel();
        statisticsDataModel.setDataArr(dataArr);
        statisticsDataModel.setDateArr(dates);
        return statisticsDataModel;
    }
}
