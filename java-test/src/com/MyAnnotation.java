package com;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by lawrence on 2016/12/27.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    public String name();
    public String value();
}
