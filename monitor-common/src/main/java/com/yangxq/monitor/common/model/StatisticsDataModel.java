package com.yangxq.monitor.common.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Yangxq on 2016/8/29.
 */
public class StatisticsDataModel implements Serializable {


    private List<Integer> dataArr;
    private List<String>dateArr;

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
