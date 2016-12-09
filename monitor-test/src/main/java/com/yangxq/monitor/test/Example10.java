package com.yangxq.monitor.test;

/**
 * Created by Yangxq on 2016/11/22.
 */
public class Example10 {
    public static void main(String[] args) {

    }
}

interface IBaseCache {
    /**
     * master
     *
     * @return
     */
    String getMaster();

    /**
     * slaver
     *
     * @return
     */
    String getSlaver();

    /**
     * queue
     *
     * @return
     */
    String getQueue();

    void setMaster(int type);
}

abstract class BaseCache implements IBaseCache {
    public String getMaster() {
         setMaster(1);
        return "1";
    }

    public String getSlaver() {
        return getMaster();
    }

    public String getQueue() {
        return getQueue();
    }

}

class BusinessRedis extends BaseCache implements IBaseMemcache {
    public void setMaster(int type) {
        System.out.println("type" + type);
    }

    public String getMemcache() {
        return "memcache";
    }
}
interface IBaseMemcache extends IBaseCache{
    String getMemcache();
}