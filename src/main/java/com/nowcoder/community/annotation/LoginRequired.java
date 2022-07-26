package com.nowcoder.community.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)  // 注解作用类型（方法）
@Retention(RetentionPolicy.RUNTIME)  // 注解作用时间（运行时）
public @interface LoginRequired {
}
