package com.yangxq.monitor.common.utils;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class JacksonUtil {

    /**
     * 日志输出类
     */
    private static Logger Log = Logger.getLogger(JacksonUtil.class.getName());
    private static ThreadLocal<ObjectMapper> objMapperLocal = new ThreadLocal<ObjectMapper>() {
        @Override
        public ObjectMapper initialValue() {
            ObjectMapper OBJECT_MAPPER = new ObjectMapper();
            OBJECT_MAPPER.setSerializationInclusion(Include.NON_NULL);// 如果属性为null，不序列化成string
            OBJECT_MAPPER.configure(
                    DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);// 当json有多余属性时，过滤掉此属性
            return OBJECT_MAPPER;
        }
    };


    public static <T> List<T> json2List(String jsonString, Class<T> clazz) throws IOException {
        JavaType javaType = objMapperLocal.get().getTypeFactory().constructParametricType(ArrayList.class, clazz);
        List<T> lst = (List<T>) objMapperLocal.get().readValue(jsonString, javaType);
        return lst;
    }

    public static <T> List<T> json2LinkedList(String jsonString, Class<T> clazz) throws IOException {
        JavaType javaType = objMapperLocal.get().getTypeFactory().constructParametricType(LinkedList.class, clazz);
        List<T> lst = (List<T>) objMapperLocal.get().readValue(jsonString, javaType);
        return lst;
    }

    /**
     * JSON转成对象
     *
     * @param jsonString
     * @param clazz
     * @return
     */
    public static <T> T json2Object(String jsonString, Class<T> clazz) throws IOException {
        if (jsonString == null || "".equals(jsonString)) {
            return null;
        }
        return objMapperLocal.get().readValue(jsonString, clazz);
    }

    /**
     * 将对象转化成JSON
     *
     * @param ob
     * @return
     */
    public static String object2string(Object ob) {
        String str = "";
        try {
            // str = OBJECT_MAPPER.writeValueAsString(ob);
            str = objMapperLocal.get().writeValueAsString(ob);
        } catch (Exception e) {
            Log.error(e.getMessage(), e);
        }
        return str;
    }

    /**
     * JSON转成对象
     *
     * @param obj
     * @param clazz
     * @return
     */
    public static <T> T object2Object(Object obj, Class<T> clazz) {
        try {
            String str = objMapperLocal.get().writeValueAsString(obj);
            return objMapperLocal.get().readValue(str, clazz);
        } catch (Exception e) {
            Log.error(e.getMessage(), e);
        }
        return null;
    }
}
