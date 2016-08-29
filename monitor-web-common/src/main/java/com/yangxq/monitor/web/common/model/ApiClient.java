package com.yangxq.monitor.web.common.model;




import com.yangxq.monitor.common.utils.JsonAdapter;

import java.io.Serializable;

/**
 * 公共参数模型
 */
public class ApiClient implements Serializable {

    private String ageGroup;

    private String channel;

    private String deviceId;

    private String gender;

    private String imei;

    private String net;

    private String packageName;

    private String platform;

    private String screen;

    private String sdkVersion;

    private String sessionId;

    private String imToken;

    private String userId;

    private String shopToken;

    private String version;

    private String xingeToken;

    // 额外添加
    private String ip;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getGender() {
        return gender;
    }

    public String getGenderEn() {
        if ("1".equals(this.gender)) return "male";
        else if ("0".equals(this.gender)) return "female";
        else return "other";
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getNet() {
        return net;
    }

    public void setNet(String net) {
        this.net = net;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getSdkVersion() {
        return sdkVersion;
    }

    public void setSdkVersion(String sdkVersion) {
        this.sdkVersion = sdkVersion;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getImToken() {
        return imToken;
    }

    public void setImToken(String imToken) {
        this.imToken = imToken;
    }

    public String getShopToken() {
        return shopToken;
    }

    public void setShopToken(String shopToken) {
        this.shopToken = shopToken;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getXingeToken() {
        return xingeToken;
    }

    public void setXingeToken(String xingeToken) {
        this.xingeToken = xingeToken;
    }

    @Override
    public String toString() {
        return JsonAdapter.object2string(this);
    }
}
