package com.yangxq.monitor.provider.test;

import com.yangxq.monitor.common.api.EmailProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by Yangxq on 2017/1/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class EmailTest {
    @Resource
    private EmailProvider emailProvider;

    @Test
    public void test1() {
        String[] str = {"574702818@qq.com"};
        emailProvider.senderTextMail("test", str, "test");
    }
}
