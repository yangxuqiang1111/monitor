package com.yangxq.monitor.web.common.exception;


import com.yangxq.monitor.common.exception.ParamException;
import com.yangxq.monitor.common.exception.UserAuthException;
import com.yangxq.monitor.common.exception.VisitLimitException;
import com.yangxq.monitor.web.common.utils.ApiResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 统一异常处理类
 */
public class MonitorExceptionResolver extends AbstractHandlerExceptionResolver {

    private final static Logger log = LoggerFactory.getLogger(MonitorExceptionResolver.class);

    @Resource
    private MappingJackson2HttpMessageConverter jsonConverter;


    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
                                              Exception ex) {
        // 记录异常日志.
        logException(request, ex);
        try {
            writeJsonResponse(ex, response);
        } catch (Exception e) {
            log.error("Error rendering json response!", e);
        }
        // ruturn Empty ModelAndView表示到此结束了。
        return new ModelAndView();
    }

    /**
     * 记录异常日志.
     *
     * @param request
     * @param ex
     */
    private void logException(HttpServletRequest request, Exception ex) {
//        // 请求总参数对象， CommonInterceptor中进行封装
//        ApiParams apiParams = (ApiParams) request.getAttribute(RequestUtil.API_PARAMS);
//        // 参数字符串
//        StringBuffer paramLog = new StringBuffer("[params]");
//        // 二者有一个成立，说明请求没进入到拦截器就报错了
//        if (null == apiParams) {
//            paramLog.append(" 没有参数信息，尚未请求到拦截器层.");
//        } else {
//            // 查询参数对象，CommonInterceptor中进行封装
//            Map<String, Object> queryParams = apiParams.getQuery();
//            if (null != queryParams) {
//
//                Set<Map.Entry<String, Object>> entries = queryParams.entrySet();
//                Iterator<Map.Entry<String, Object>> iterator = entries.iterator();
//                while (iterator.hasNext()) {
//                    Map.Entry<String, Object> next = iterator.next();
//                    paramLog.append(", " + next.getKey() + "=" + next.getValue());
//                }
//            }
//        }
//        // 路径
//        String path = request.getServletPath();
//        String logStr = "[" + path + "-----" + paramLog + "] " + ex.getMessage();
//        log.error(logStr, ex);
        log.error(ex.getMessage(),ex);

    }

    /**
     * 返回给调用方
     *
     * @param ex
     * @param response
     * @throws HttpMessageNotWritableException
     * @throws IOException
     */

    private void writeJsonResponse(Exception ex, HttpServletResponse response)
            throws HttpMessageNotWritableException, IOException {
        MediaType jsonMediaType = MediaType.APPLICATION_JSON;
        response.setContentType("application/json;charset=utf-8");

        if (ex instanceof ParamException) {
            jsonConverter.write(ApiResultUtil.failed(ex.getMessage(), ApiResultUtil.Status.PARAMETER_ERROR),
                    jsonMediaType, new ServletServerHttpResponse(response));
        } else if (ex instanceof UserAuthException) {
            jsonConverter.write(ApiResultUtil.failed("用户验证错误,请重新登录", ApiResultUtil.Status.USER_AUTH_ERROR),
                    jsonMediaType, new ServletServerHttpResponse(response));
        } else if (ex instanceof NullPointerException) {
            jsonConverter.write(ApiResultUtil.failed("服务器内部错误", ApiResultUtil.Status.SERVER_ERROR), jsonMediaType,
                    new ServletServerHttpResponse(response));
        } else if (ex instanceof VisitLimitException) {
            jsonConverter.write(ApiResultUtil.failed("您的操作太快了,请稍后再试", ApiResultUtil.Status.VISIT_LIMIT_ERROR),
                    jsonMediaType, new ServletServerHttpResponse(response));
        } else {
            jsonConverter.write(ApiResultUtil.failed("服务器生病了,请稍后再试O(∩_∩)O~~", ApiResultUtil.Status.SERVER_ERROR),
                    jsonMediaType, new ServletServerHttpResponse(response));
        }
    }
}
