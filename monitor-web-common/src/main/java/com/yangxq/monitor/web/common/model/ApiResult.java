package com.yangxq.monitor.web.common.model;



import com.yangxq.monitor.common.utils.JsonAdapter;

import java.util.HashMap;
import java.util.Map;

/**
 * API标准返回值
 */
public class ApiResult {

    private int status;// 0 成功; 其他为错误码

    private String info;// 错误描述

    private Map<String, Object> data;// 数据


    public ApiResult putData(String key, Object value) {
        if (data == null)
            data = new HashMap<String, Object>();
        data.put(key, value);
        return this;
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return JsonAdapter.object2string(this);
    }
}
