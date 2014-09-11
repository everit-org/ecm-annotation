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
public @interface LongAttribute {

    /**
     * Cardinality of the attribute. In case the annotation is appended to a field or method, only those cardinalities
     * are allowed that meet the type of the setter/field.
     */
    Cardinality cardinality();

    /**
     * The default value(s) of the attribute. In case the annotation is appended to a field or method, the default
     * values come from the default value of the field.
     */
    long[] defaultValue() default {};

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
     * Some properties may only be set to a set of possible values. To support user interfaces which provide a selection
     * list of values or a list of checkboxes the option values and labels may be defined as parameters to the
     * {@link FloatAttribute} annotation. All parameters in the form of name-value pairs are used to build the list of
     * available value options. The parameter name is used as the value while the parameter value is used as the label
     * in the user interface. This label may be prepended with a % sign to localize the string.
     */
    LongAttributeOption[] options() default {};

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
