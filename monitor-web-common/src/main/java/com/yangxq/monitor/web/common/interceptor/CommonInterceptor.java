package com.yangxq.monitor.web.common.interceptor;


import com.yangxq.monitor.common.utils.DateUtil;
import com.yangxq.monitor.common.utils.StringUtil;
import com.yangxq.monitor.web.common.model.ApiParams;
import com.yangxq.monitor.web.common.utils.RequestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 通用拦截器
 */
public class CommonInterceptor extends HandlerInterceptorAdapter {

    private final static Logger log = LoggerFactory.getLogger(CommonInterceptor.class);

//    @Resource
//    private UserProvider userProvider;


    /**
     * 预处理(调用Controller之前执行),进行参数检查,登录认证,编码等操作
     *
     * @param request
     * @param response
     * @param handler
     * @return true继续, false失败
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String clientStr;// 公共参数
        String queryStr;// 接口参数
        String timestamp;// 时间戳


        ApiParams apiParams = RequestUtil.packParams(request);
        String clientSign = request.getParameter("sign");
        clientStr = request.getParameter("client");
        queryStr = request.getParameter("query");
        timestamp = request.getParameter("timestamp");

//        boolean local = commonConfig.isLocal();
//        if (!local) {
//            boolean isSignOK = SignUtil.isSignOK(clientSign, clientStr, queryStr, timestamp, apiParams);
//            if (!isSignOK) {
//                ExFactory.exception("sign 延签失败");
//                return false;
//            }
//        }


        // 设置用户信息
        String token = apiParams.getApiClient().getShopToken();
        /**
         * TODO 判断token是否为空
         */
//        UserModel userModel = userRpc.getUserByToken(token);
//        log.info("鉴权前,用户token[" + token + "]");
//        UserModel userModel = userProvider.getUserByToken(token);
//        if (userModel != null) {
//            request.setAttribute(RequestUtil.UID, userModel.getUserId());
//        } else {
//            try {
//                userId = userProvider.getUserIdByToken(token);
//            }catch (Exception e){
//                log.error("拉取用户信息异常[getUserIdByToken],token["+token+"],msg:["+e.getMessage()+"]");
//            }
//            request.setAttribute(RequestUtil.UID, userId);
//        }

//        log.info("鉴权前,用户token[" + token + "]");
//        int userId = 0;
//        if (StringUtil.isEmpty(token)) {
//            // 游客
//            request.setAttribute(RequestUtil.UID, userId);
//        } else {
//            try {
//                UserModel userModel = userRpc.getUserByToken(token);
//                if (userModel != null) {
//                    request.setAttribute(RequestUtil.UID, userModel.getUserId());
//                } else {
//                    request.setAttribute(RequestUtil.UID, userId);
//                }
//            } catch (Exception e) {
//                log.error("拉取用户信息异常[getUserIdByToken],token[" + token + "],msg:[" + e.getMessage() + "]");
//            }
//        }


        // 设置客户端传参
        request.setAttribute(RequestUtil.API_PARAMS, apiParams);

        // 设置开始处理时间戳
        request.setAttribute(RequestUtil.START_TIME, DateUtil.getNowTime());
        return true;
    }

    /**
     * 后处理(调用Controller之后,返回结果或者展示模型之前),可以对返回结果进行修改
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    /**
     * 整个请求完毕的回调,即在视图渲染完毕时回调
     * 性能监控中我们可以在此记录结束时间并输出消耗时间，还可以进行一些资源清理，类似于try-catch-finally中的finally
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        long startTime = (Long) request.getAttribute(RequestUtil.START_TIME);
        long takeTime = DateUtil.getNowTime() - startTime;

        String path = request.getServletPath();
        log.info("[" + path + "]处理总耗时[" + takeTime + "]ms");
        super.afterCompletion(request, response, handler, ex);
    }


}
