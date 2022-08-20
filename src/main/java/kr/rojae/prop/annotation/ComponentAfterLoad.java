package kr.rojae.prop.annotation;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Component
@DependsOn("propLoadConfig")
@Retention(RetentionPolicy.RUNTIME)
public @interface ComponentAfterLoad {
    String value() default "";
}
