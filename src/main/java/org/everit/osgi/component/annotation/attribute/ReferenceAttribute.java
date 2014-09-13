package org.everit.osgi.component.annotation.attribute;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.ANNOTATION_TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ReferenceAttribute {

    ReferenceAttributeType attributeType() default ReferenceAttributeType.FILTER;

    /**
     * The default value(s) of the attribute. In case the annotation is appended to a field or method, the default
     * values come from the default value of the field. In case the reference is not optional, the component does not
     * need configuration and the default value is not defined, a one element array will be used with an empty String.
     */
    String[] defaultValue() default {};

    /**
     * A descriptive text to provide the client in a form to configure this property. This name may be localized by
     * prepending a % sign to the name. Default value: %&lt;name&gt;.description
     */
    String description() default "";

    /**
     * The label to display in a form to configure this attribute. This name may be localized by prepending a % sign to
     * the name. Default value: %&lt;name&gt;.name
     */
    String label() default "";

    /**
     * Boolean flag defining whether the attribute should be listed in the MetatypeProvider or not.
     */
    boolean metatype() default true;

    /**
     * The name of the reference. If not provided the default value is defined based on the value of
     * {@link #attributeType()}:
     *
     * <ul>
     * <li>{@link ReferenceAttributeType#FILTER}: The default value will be "{@link #name()}" + ".target".</li>
     * <li>{@link ReferenceAttributeType#CLAUSE}: The default value will be "{@link #name()}" + ".clause".</li>
     * </ul>
     */
    String name() default "";
}
