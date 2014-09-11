package org.everit.osgi.component.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The <code>Dectivate</code> annotation defines the method which is used to deactivate the component.
 */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.CLASS)
@Documented
public @interface Deactivate {

}
