package com.yangxq.monitor.web.controller;

import com.yangxq.monitor.common.api.SysProvider;
import com.yangxq.monitor.common.po.Sys;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Yangxq on 2016/8/30.
 */
@RequestMapping("sys")
@Controller
public class SysController {
    @Resource
    private SysProvider sysProvider;
    /**
     * 获取
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ModelAndView get(HttpServletRequest request, ModelAndView modelAndView) {
        List<Sys> list = sysProvider.list();
        modelAndView.addObject("sys",list);
        modelAndView.setViewName("test");
        return modelAndView;
    }
}
