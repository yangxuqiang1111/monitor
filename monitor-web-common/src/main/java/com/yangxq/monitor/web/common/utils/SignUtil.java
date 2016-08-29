package com.yangxq.monitor.web.common.utils;


import com.yangxq.monitor.web.common.model.ApiParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;

/**
 * 签名工具类
 */
public class SignUtil {

    private final static Logger log = LoggerFactory.getLogger(SignUtil.class);

    /**
     * 签名是否正确
     *
     * @param clientSign 客户端签名
     * @param clientStr  客户端公共参数
     * @param queryStr   客户端接口参数
     * @param apiParams  客户端参数
     * @param timestamp  时间戳
     * @return
     */
    public static boolean isSignOK(String clientSign, String clientStr, String queryStr, String timestamp, ApiParams apiParams) throws UnsupportedEncodingException {

        if (queryStr == null) {
            queryStr = "";
        }
        if (timestamp == null || "".equals(timestamp)) {
            log.error("timestamp非法[" + timestamp + "]:" + apiParams);
            return false;
        }
        String serverSign = SecurityUtil.getSign(clientStr, queryStr, timestamp);
//        if (!serverSign.equals(clientSign)) {
//            StringBuffer stringBuffer = new StringBuffer();
//            stringBuffer.append("\r\n==================sign校验================");
//            if (apiParams.getApiClient() != null) {
//                stringBuffer.append("\r\n客户端信息[userId:" + apiParams.getApiClient().getUserId() + "][imToken:" + apiParams
//                        .getApiClient().getImToken() + "][shopToken:" + apiParams.getApiClient().getShopToken() + "][platform:" + apiParams.getApiClient().getPlatform() +
//                        "][devideId:" + apiParams.getApiClient().getDeviceId() + "]");
//            }
//            stringBuffer.append("\r\n客户端sign:" + clientSign);
//            stringBuffer.append("\r\n服务器sign:" + serverSign);
//            stringBuffer.append("\r\n==================sign校验================");
//            log.error("sign校验失败:" + stringBuffer.toString());
//            return false;
//        }
        return true;

    }
}
