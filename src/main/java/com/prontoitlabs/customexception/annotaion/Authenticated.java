package com.prontoitlabs.customexception.annotaion;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.prontoitlabs.customexception.domain.enums.Role;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Authenticated {

    Role forRole() default Role.USER;

    boolean required() default true;

}
