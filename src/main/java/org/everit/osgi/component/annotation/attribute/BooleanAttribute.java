package org.everit.osgi.component.annotation.attribute;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.everit.osgi.component.annotation.Cardinality;

@Target({ ElementType.TYPE, ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface BooleanAttribute {

    /**
     * Cardinality of the attribute. In case the annotation is appended to a field or method, only those cardinalities
     * are allowed that meet the type of the setter/field.
     */
    Cardinality cardinality();

    /**
     * The default value(s) of the attribute. In case the annotation is appended to a field or method, the default
     * values come from the default value of the field.
     */
    boolean[] defaultValue() default {};

    /**
     * A descriptive text to provide the client in a form to configure this property. This name may be localized by
     * prepending a % sign to the name. Default value: %&lt;name&gt;.description
     */
    String description() default "";

    /**
     * If true, the property is re-set without restarting the component. Otherwise the component is restarted it the
     * configuration is updated in the way that the value of this attribute changes in the component instance.
     */
    boolean dynamic() default false;

    /**
     * The label to display in a form to configure this property. This name may be localized by prepending a % sign to
     * the name. Default value: %&lt;name&gt;.name
     */
    String label() default "";

    /**
     * The name of the attribute.
     */
    String name() default "";

    /**
     * Boolean flag defining whether the property should be listed in the MetatypeProvider or not.
     */
    boolean propertyPrivate() default false;

    /**
     * The setter method that should be used to inject the value of this property. If the annotation is defined on a
     * method, that method and it is not specified otherwise in the annotation, the method will be used as a setter. If
     * the annotation is attached to a field and the setter is not defined in the annotation, the field will be injected
     * via reflection.
     */
    String setter() default "";
}
