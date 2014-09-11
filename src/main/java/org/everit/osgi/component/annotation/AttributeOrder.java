package org.everit.osgi.component.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The order of attributes how they should be shown on a form. If not defined, the attributes are shown in the order how
 * they are defined on the class and its fields / methods.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AttributeOrder {

    /**
     * The name of the attributes.
     */
    String[] value() default {};
}
