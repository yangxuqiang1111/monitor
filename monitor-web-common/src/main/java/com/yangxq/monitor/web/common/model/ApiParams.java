package com.yangxq.monitor.web.common.model;




import com.yangxq.monitor.common.utils.JsonAdapter;

import java.util.Map;

/**
 * API参数模型
 * Created by jacklin on 16/3/1.
 */
public class ApiParams {

    private ApiClient apiClient;// 公共参数

    private Map<String, Object> query;// 接口参数

    private Map<String, Object> misc;// 其他参数

    private String data;// 文件传输专用

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Map<String, Object> getMisc() {
        return misc;
    }

    public void setMisc(Map<String, Object> misc) {
        this.misc = misc;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }


    public Map<String, Object> getQuery() {
        return query;
    }

    public void setQuery(Map<String, Object> query) {
        this.query = query;
    }

    @Override
    public String toString() {
        return JsonAdapter.object2string(this);
    }
}
