package de.mirko_werner.serenity.api;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
@Documented
public @interface EndPoint {

    String value() default "";
}
