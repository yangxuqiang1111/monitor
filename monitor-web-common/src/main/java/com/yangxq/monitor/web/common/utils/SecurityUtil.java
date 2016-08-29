package com.yangxq.monitor.web.common.utils;



import com.yangxq.monitor.common.utils.MD5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 安全工具类
 */
public class SecurityUtil {

    private final static Logger log = LoggerFactory.getLogger(SecurityUtil.class);

    private static final String PUBLIC_KEY = "asfe993M9DJS9j9h89dewjlfUYH";// 客户端与服务器校验的公钥


    /**
     * 获取sign值
     *
     * @param client
     * @param query
     * @param timestamp
     * @return
     */
    public static String getSign(String client, String query, String timestamp) {
        String sum = client + query + timestamp + PUBLIC_KEY;
//        String sum1 = new String(Base64.decode(Base64.encodeObject(sum)), Charset.forName("utf-8"));
        //   log.info("sign sum:" + sum);
//        log.info("sign sum1:" + sum1);
        return MD5Util.getMD5(sum).toUpperCase();
    }


}
