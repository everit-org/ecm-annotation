/**
 * This file is part of Everit - Component Annotations.
 *
 * Everit - Component Annotations is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Everit - Component Annotations is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Everit - Component Annotations.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.everit.osgi.ecm.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ServiceRef {

    /**
     * The id of the attribute of the reference. If not provided the default value is defined based on the value of
     * {@link #configurationType()}:
     *
     * <ul>
     * <li>{@link ReferenceConfigurationType#FILTER}: The default value will be "{@link #referenceId()}" + ".target".</li>
     * <li>{@link ReferenceConfigurationType#CLAUSE}: The default value will be "{@link #referenceId()}" + ".clause".</li>
     * </ul>
     */
    String attributeId() default "";

    ReferenceConfigurationType configurationType() default ReferenceConfigurationType.FILTER;

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
     * If true, the reference is re-binded without restarting the component in case of a service switch. The component
     * also does not stop if the configuration is updated behind in the way that the reference can remain satisfied
     * after the actualization of the clause(s) or filter(s).
     */
    boolean dynamic() default false;

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
     * Multiplicity. See the documentation of {@link ThreeStateBoolean}.
     */
    ThreeStateBoolean multiple() default ThreeStateBoolean.DEFAULT;

    /**
     * Whether at least one reference should be configured or not.
     */
    boolean optional() default false;

    /**
     * The id of the reference. If not specified and the annotation is defined on a field, the id of the reference will
     * be the name of the field.
     */
    String referenceId() default "";

    /**
     * The name of the service interface. This name is used by the Service Component Runtime to access the service on
     * behalf of the component. If the annotation is declared on class level, this parameter is required. If the
     * annotation is declared for a field, the default value for the interface parameter is the type of the field.
     */
    Class<?> referenceInterface() default AutoDetect.class;

    /**
     * The setter method that should be used to setter the reference. If the annotation is defined on a method, that
     * method and it is not specified otherwise in the annotation, the method will be used as a bind method. If the
     * annotation is attached to a field and the bind method is not defined in the annotation and there is method that
     * has the same name as the field but prefixed with "bind" that method will be used as a bind method. In case there
     * is no bind method but there is a setter for the field, it will be used to set the property.
     */
    String setter() default "";

}
