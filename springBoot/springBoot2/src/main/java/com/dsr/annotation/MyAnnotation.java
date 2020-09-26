package com.dsr.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

    public String name() default "";
    public int age() default 0;
    public Class<?> type() ;
    public Class<?>[] types() default {};
}
