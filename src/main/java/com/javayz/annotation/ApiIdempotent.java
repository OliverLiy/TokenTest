package com.javayz.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author by: Liyu
 * @ClassName: ApiIdempotent
 * @Description: TODO 自定义token认证注解
 * @Date: 2020/11/9 11:34
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiIdempotent {
}
