package com.yangxq.monitor.web.controller;

import com.yangxq.monitor.common.api.BusinessProvider;
import com.yangxq.monitor.common.api.StatisticProvider;
import com.yangxq.monitor.common.model.StatisticsDataModel;
import com.yangxq.monitor.common.po.Business;
import com.yangxq.monitor.common.utils.DateUtil;
import com.yangxq.monitor.common.utils.Global;
import com.yangxq.monitor.common.utils.StringUtil;
import com.yangxq.monitor.web.common.controller.BaseController;
import com.yangxq.monitor.web.common.model.ApiParams;
import com.yangxq.monitor.web.common.model.ApiResult;
import com.yangxq.monitor.web.common.utils.ApiResultUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by Yangxq on 2016/8/29.
 */
@RequestMapping("statistic")
@Controller
public class StatisticController extends BaseController {

    @Resource
    private StatisticProvider statisticProvider;

    @Resource
    private BusinessProvider businessProvider;

    /**
     * 获取
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "get", method = RequestMethod.POST)
    public ApiResult get(HttpServletRequest request) {
        String idStr = request.getParameter("id");
        int id = 0;
        if (!StringUtil.isEmpty(idStr)) {
            id = Integer.parseInt(idStr);
        }
        String typeStr = request.getParameter("type");
        int type = 0;
        if (!StringUtil.isEmpty(typeStr)) {
            type = Integer.parseInt(typeStr);
        }
        String dateStr = request.getParameter("date");
        int date = 0;
        if (!StringUtil.isEmpty(dateStr)) {
            date = Integer.parseInt(dateStr);
        }
        Business business = businessProvider.get(id);
        if (business == null) {
            log.error("id["+id+"]不存在business");
            return ApiResultUtil.failed("");
        }
        StatisticsDataModel statisticsDataModel = statisticProvider.listByTime(875, type, DateUtil.getNowMinute());

        List<Integer> dataArr = statisticsDataModel.getDataArr();

        String subtitle = null;
        if (business.getType() == Global.BusinessType.DELAY.value) {
            subtitle = Global.getSubTitle(business.getType());
        } else if (business.getType() == Global.BusinessType.TRANSFER.value) {
            int sum = 0;
            for (int i = 0; i < dataArr.size(); i++) {
                sum += dataArr.get(i);
            }
            subtitle = Global.getSubTitle(business.getType()) + sum;
        }
        return ApiResultUtil.success()
                .putData("title", business.getTitle() + "(" + DateUtil.getFormatDateStr() + ")")
                .putData("subtitle", subtitle)
                .putData("ytitle", Global.getYtitle(business.getType()))
                .putData("name", Global.getName(business.getType()))
                .putData("data", statisticsDataModel.getDataArr())
                .putData("timeStart", DateUtil.getTodayEight());
    }


    /**
     * 获取
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "test", method = RequestMethod.GET)
    public ModelAndView test(HttpServletRequest request, ModelAndView modelAndView) {
        int end = DateUtil.getNowMinute();
//        StatisticsDataModel statisticsDataModel = statisticProvider.listByTime(875,end);
//        modelAndView.addObject("date",statisticsDataModel.getDateArr());
//        modelAndView.addObject("data",statisticsDataModel.getDataArr());
//        modelAndView.addObject("end",end);
//        modelAndView.addObject("beg",DateUtil.getTodayBegTime());
        modelAndView.setViewName("test");
        return modelAndView;
    }


}
