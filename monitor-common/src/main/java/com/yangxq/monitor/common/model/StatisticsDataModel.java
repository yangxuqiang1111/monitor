package com.yangxq.monitor.common.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Yangxq on 2016/8/29.
 */
public class StatisticsDataModel implements Serializable {


    private List<Integer> dataArr;
    private List<String>dateArr;

    private String title;

    private String subTitle;

    private String yTitle;

    private String xTitle;

    private String name;

    private int timeStart;

    public String getxTitle() {
        return xTitle;
    }

    public void setxTitle(String xTitle) {
        this.xTitle = xTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getyTitle() {
        return yTitle;
    }

    public void setyTitle(String yTitle) {
        this.yTitle = yTitle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(int timeStart) {
        this.timeStart = timeStart;
    }

    public List<Integer> getDataArr() {
        return dataArr;
    }

    public void setDataArr(List<Integer> dataArr) {
        this.dataArr = dataArr;
    }

    public List<String> getDateArr() {
        return dateArr;
    }

    public void setDateArr(List<String> dateArr) {
        this.dateArr = dateArr;
    }
}
