package com.yangxq.monitor.web.controller;

import com.yangxq.monitor.common.api.BusinessProvider;
import com.yangxq.monitor.common.api.SysProvider;
import com.yangxq.monitor.common.po.Business;
import com.yangxq.monitor.common.po.Sys;
import com.yangxq.monitor.common.utils.StringUtil;
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

/**
 * Created by Yangxq on 2016/8/30.
 * 基本业务
 */
@RequestMapping("business")
@Controller
public class BusinessController {
    @Resource
    private BusinessProvider businessProvider;
    /**
     * 获取
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "list", method = RequestMethod.POST)
    public ApiResult get(HttpServletRequest request) {
        String sysIdStr = request.getParameter("id");
        if (StringUtil.isEmpty(sysIdStr)){
            return ApiResultUtil.failed("id 为空");
        }
        int sysId=Integer.parseInt(sysIdStr);
        List<Business> list = businessProvider.listBySysId(sysId);
        return ApiResultUtil.success().putData("business",list);
    }
}
