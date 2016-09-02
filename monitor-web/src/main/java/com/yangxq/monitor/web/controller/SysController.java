package com.yangxq.monitor.web.controller;

import com.yangxq.monitor.common.api.BusinessProvider;
import com.yangxq.monitor.common.api.SysProvider;
import com.yangxq.monitor.common.po.Business;
import com.yangxq.monitor.common.po.Sys;
import com.yangxq.monitor.common.utils.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Yangxq on 2016/8/30.
 * 业务系统
 */
@RequestMapping("sys")
@Controller
public class SysController {
    @Resource
    private SysProvider sysProvider;

    @Resource
    private BusinessProvider businessProvider;

    /**
     * 获取
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ModelAndView get(HttpServletRequest request, ModelAndView modelAndView) {
        List<Sys> sysList = sysProvider.list();
        modelAndView.addObject("sys", sysList);

        int sysId = 0;
        if (sysList.size() > 0) {
            sysId = sysList.get(0).getId();
        }
        String sysIdStr = request.getParameter("sysId");
        if (StringUtil.isNumeric(sysIdStr)) {
            sysId = Integer.parseInt(sysIdStr);
        }

        List<Business> businessList = businessProvider.listBySysId(sysId);
        modelAndView.addObject("business", businessList);

        modelAndView.addObject("sysId",sysId);
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
