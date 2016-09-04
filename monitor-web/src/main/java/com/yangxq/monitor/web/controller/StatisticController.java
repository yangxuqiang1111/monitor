package com.yangxq.monitor.web.controller;

import com.yangxq.monitor.common.api.StatisticProvider;
import com.yangxq.monitor.common.model.StatisticsDataModel;
import com.yangxq.monitor.common.utils.DateUtil;
import com.yangxq.monitor.common.utils.StringUtil;
import com.yangxq.monitor.web.common.controller.BaseController;
import com.yangxq.monitor.web.common.model.ApiResult;
import com.yangxq.monitor.web.common.utils.ApiResultUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Yangxq on 2016/8/29.
 */
@RequestMapping("statistic")
@Controller
public class StatisticController extends BaseController {
    @Resource
    private StatisticProvider statisticProvider;

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
        if (!StringUtil.isNumeric(idStr)) {
            log.error("id[" + idStr + "]不是数字");
            return ApiResultUtil.failed("id 不是数字");
        }
        int id = Integer.parseInt(idStr);
        String dateStr = request.getParameter("date");

        StatisticsDataModel statisticsDataModel = statisticProvider.listByTime(id, dateStr);

        if (statisticsDataModel == null) {
            return ApiResultUtil.failed("请求id[" + id + "]无统计数据");
        }

        return ApiResultUtil.success()
                .putData("title", statisticsDataModel.getTitle())
                .putData("subTitle", statisticsDataModel.getSubTitle())
                .putData("xTitle", statisticsDataModel.getxTitle())
                .putData("yTitle", statisticsDataModel.getyTitle())
                .putData("name", statisticsDataModel.getName())
                .putData("data", statisticsDataModel.getDataArr())
                .putData("timeStart", statisticsDataModel.getTimeStart());
    }


    /**
     * 获取
     *
     * @param request
     * @return
     * @return
     */
    @RequestMapping(value = "test", method = RequestMethod.GET)
    public ModelAndView test(HttpServletRequest request, ModelAndView modelAndView) {
        int end = DateUtil.getNowTimeStampRmS();
//        StatisticsDataModel statisticsDataModel = statisticProvider.listByTime(875,end);
//        modelAndView.addObject("date",statisticsDataModel.getDateArr());
//        modelAndView.addObject("data",statisticsDataModel.getDataArr());
//        modelAndView.addObject("end",end);
//        modelAndView.addObject("beg",DateUtil.getTodayBegTimeStamp());
        modelAndView.setViewName("test");
        return modelAndView;
    }


}
