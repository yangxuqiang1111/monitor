package com.yangxq.monitor.common.utils;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * spring管理器
 */
public class SpringManager {
    /**
     * 日志输出类
     */
    private static Logger log = Logger.getLogger(SpringManager.class);

    // 静态内部类
    private SpringManager() {
    }

    private static class SingletonHolder {
        private static SpringManager instance = new SpringManager();
    }

    public static SpringManager getInstance() {
        return SingletonHolder.instance;
    }


    private ApplicationContext applicationContext = null;

    public void init() {
        try {
            // 加载spring
            applicationContext = new ClassPathXmlApplicationContext(
                    "applicationContext.xml");
        } catch (Exception e) {
            log.error("spring初始化失败", e);
        }
    }

    /**
     * 获取bean
     *
     * @param beanName
     * @return
     */
    public Object getBean(String beanName) {
        if (applicationContext != null) {
            return applicationContext.getBean(beanName);
        }
        return null;
    }

    public <T> T getBean(Class<T> t) {
        if (applicationContext != null) {
            return applicationContext.getBean(t);
        }
        return null;
    }

    public ApplicationContext getContext() {
        return applicationContext;
    }
}
