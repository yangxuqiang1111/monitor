package com.yangxq.monitor.web.controller;

import com.yangxq.monitor.common.api.StatisticProvider;
import com.yangxq.monitor.common.model.StatisticsDataModel;
import com.yangxq.monitor.common.utils.DateUtil;
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
import java.util.Map;

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
    @RequestMapping(value = "get", method = {RequestMethod.GET})
    public ApiResult get(HttpServletRequest request) {
        ApiParams apiParams = getApiParams(request);
        Map<String, Object> query = apiParams.getQuery();
        if (!StringUtil.isNumeric(query.get("userId"))) {
            return ApiResultUtil.failedWithParamError("userId为空或不是数字");
        }
        int toUserId = StringUtil.obj2Int(query.get("userId"));
        int fromUserId = getUserId(request);
        return ApiResultUtil.success();
    }


    /**
     * 获取
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "test", method = RequestMethod.GET)
    public ModelAndView test(HttpServletRequest request,ModelAndView modelAndView) {
        int end = DateUtil.getNowMinute();
        StatisticsDataModel statisticsDataModel = statisticProvider.listByTime(875,end);
//        modelAndView.addObject("date",statisticsDataModel.getDateArr());
        modelAndView.addObject("data",statisticsDataModel.getDataArr());
        modelAndView.addObject("end",end);
        modelAndView.addObject("beg",DateUtil.getTodayBegTime());
        modelAndView.setViewName("test");
        return modelAndView;
    }


}
