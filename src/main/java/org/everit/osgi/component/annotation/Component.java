package org.everit.osgi.component.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Component {

    /**
     * Set the metatype factory pid property.
     */
    boolean configurationFactory() default false;

    /**
     * The configuration pid. The default value for this is the name of the component.
     */
    String[] configurationPid() default "";

    /**
     * If true configuration is required to activate the component otherwise if there is no configuration, the component
     * will be activated anyway.
     */
    boolean configurationRequired() default false;

    /**
     * This is generally used as a description for the object described by the meta type. This name may be localized by
     * prepending a % sign to the name. Default value: %&lt;name&gt;.description
     */
    String description() default "";

    /**
     * Resource path of the icon that is assigned to the component. The classloader of the component is used to find the
     * resource.
     */
    String icon();

    /**
     * This is generally used as a title for the object described by the meta type. This name may be localized by
     * prepending a % sign to the name. Default value: %&lt;name&gt;.name
     */
    String label() default "";

    /**
     * Defines the Component name also used as the PID for the Configuration Admin Service. Default value: Fully
     * qualified name of the Java class.
     */
    String name() default "";
}
