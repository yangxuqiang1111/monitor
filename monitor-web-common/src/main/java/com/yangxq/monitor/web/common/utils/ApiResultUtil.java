package com.yangxq.monitor.web.common.utils;





import com.yangxq.monitor.web.common.model.ApiResult;

import java.util.HashMap;
import java.util.Map;

public class ApiResultUtil {

    public static class Status {

        public static final int SUCCESS = 0;//成功
        public static final int UNKNOWN_ERROR = 1;// 未知错误
        public static final int PARAMETER_ERROR = 2;// 参数不正确
        public static final int SERVER_ERROR = 3;// 系统内部错误
        public static final int USER_AUTH_ERROR = 4; // 用户验证失败
        public static final int INNER_API_ERROR = 5;  // 内部接口错误
        public static final int OPERATE_ERROR = 6;// 操作失败
        public static final int VISIT_LIMIT_ERROR = 7;// 访问控制错误

    }


    private static ApiResult getResult(int status, String info, Map<String, Object> data) {
        ApiResult result = new ApiResult();
        result.setStatus(status);
        result.setInfo(info == null ? "" : info);
        result.setData(data == null ? new HashMap<String, Object>() : data);
        return result;
    }


    /**
     * 成功
     *
     * @param data 数据
     * @param info
     * @return
     */
    public static ApiResult success(Map<String, Object> data, String info) {
        return getResult(Status.SUCCESS, info, data);
    }

    /**
     * 成功
     *
     * @param data
     * @return
     */
    public static ApiResult success(Map<String, Object> data) {
        return success(data, "");
    }


    public static ApiResult success() {
        return success(null, "");
    }


    /**
     * 错误
     *
     * @param info
     * @param status
     * @param data
     * @return
     */
    public static ApiResult failed(String info, int status, Map<String, Object> data) {
        return getResult(status, info, data);
    }

    /**
     * 错误
     *
     * @param status
     * @param info
     * @return
     */
    public static ApiResult failed(String info, int status) {
        return failed(info, status, null);
    }

    /**
     * 错误
     *
     * @param info
     * @return
     */
    public static ApiResult failed(String info) {
        return failed(info, Status.UNKNOWN_ERROR, null);
    }


    /**
     * 参数错误
     *
     * @param info
     * @return
     */
    public static ApiResult failedWithParamError(String info) {
        return failed(info, Status.PARAMETER_ERROR, null);
    }


    /**
     * 用户登录错误
     *
     * @param info
     * @return
     */
    public static ApiResult failedWithUserAuth(String info) {
        return failed(info, Status.USER_AUTH_ERROR, null);
    }


}
