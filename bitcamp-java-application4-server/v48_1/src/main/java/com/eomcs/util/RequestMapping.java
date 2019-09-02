package com.eomcs.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 클래스를 로딩할 때 이 애노테이션의 정보로 로딩되어야 한다.
@Retention(RetentionPolicy.RUNTIME)
// 메서드에 붙이는 애노테이션으로 설정한다.
@Target(ElementType.METHOD)
public @interface RequestMapping {

}
