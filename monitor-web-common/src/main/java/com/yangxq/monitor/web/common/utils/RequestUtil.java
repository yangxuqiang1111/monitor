package com.yangxq.monitor.web.common.utils;



import com.yangxq.monitor.common.utils.JsonAdapter;
import com.yangxq.monitor.common.utils.StringUtil;
import com.yangxq.monitor.web.common.model.ApiClient;
import com.yangxq.monitor.web.common.model.ApiParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * HTTP请求工具类
 */
public class RequestUtil {

    private final static Logger log = LoggerFactory.getLogger(RequestUtil.class);

    public static final String API_PARAMS = "API_PARAMS";// 请求参数标签

    public static final String START_TIME = "START_TIME";// 请求开始时间标签

    public static final String UID = "UID";// 商城用户id


    /**
     * 获取请求参数
     *
     * @param request
     * @return
     */
    public static ApiParams getParams(HttpServletRequest request) {
        ApiParams params = (ApiParams) request.getAttribute(API_PARAMS);
        return params;
    }

    public static ApiParams packParams(HttpServletRequest request) throws IOException {
        // 组装参数
        ApiParams apiParams = new ApiParams();
        String queryStr, clientStr;// 接口参数
        queryStr = request.getParameter("query");
        Map<String, Object> query;
        if (StringUtil.isEmpty(queryStr))
            query = new HashMap<String, Object>();
        else
            query = JsonAdapter.json2Object(queryStr, HashMap.class);

        clientStr = request.getParameter("client");
        ApiClient apiClient;
        if (StringUtil.isEmpty(clientStr))
            apiClient = new ApiClient();
        else
            apiClient = JsonAdapter.json2Object(clientStr, ApiClient.class);
        apiParams.setQuery(query);
        apiParams.setApiClient(apiClient);
        return apiParams;
    }

    /**
     * 获取用户id
     *
     * @param request
     * @return
     */
    public static int getUserId(HttpServletRequest request) {
        Object obj = request.getAttribute(UID);
        if (obj == null) {
            return 0;
        }
        return StringUtil.obj2Int(obj);
    }
}
