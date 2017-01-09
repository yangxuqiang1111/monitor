package com.yangxq.monitor.spi.annotations;

import java.lang.annotation.*;

/**
 * Created by Yangxq on 2017/1/9.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface Adaptive {
    String[] value() default {};
}
