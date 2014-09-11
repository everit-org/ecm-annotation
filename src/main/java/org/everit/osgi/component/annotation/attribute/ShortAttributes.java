package org.everit.osgi.component.annotation.attribute;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Allows to define multiple {@link ShortAttribute} annotations for one type.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.CLASS)
@Documented
public @interface ShortAttributes {

    /**
     * List of {@link ShortAttribute} annotations.
     */
    ShortAttribute[] value();

}
