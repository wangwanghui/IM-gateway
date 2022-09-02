package com.octv.im.constant;


import com.octv.im.test.Person;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface EventNode {
    String[] basePackages() default {};

    String component() default "test";
}
