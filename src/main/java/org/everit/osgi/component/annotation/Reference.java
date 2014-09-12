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
package org.everit.osgi.component.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.everit.osgi.component.annotation.attribute.ReferenceType;

@Target({ ElementType.TYPE, ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Reference {

    ReferenceType attributeType() default ReferenceType.DEFAULT;

    /**
     * The bind method that should be used to bind the reference. If the annotation is defined on a method, that method
     * and it is not specified otherwise in the annotation, the method will be used as a bind method. If the annotation
     * is attached to a field and the bind method is not defined in the annotation and there is method that has the same
     * name as the field but prefixed with "bind" that method will be used as a bind method. In case there is no bind
     * method but there is a setter for the field, it will be used to set the property.
     */
    String bind() default "";

    /**
     * Cardinality of the reference. In case the annotation is appended to a field or method, only those cardinalities
     * are allowed that meet the type of the method/field.
     */
    Cardinality cardinality();

    /**
     * The default clause(s) or OSGi filter(s) of the reference.
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
     * The label to display in a form to configure this property. This name may be localized by prepending a % sign to
     * the name. Default value: %&lt;name&gt;.name
     */
    String label() default "";

    /**
     * The name of the reference.
     */
    String name() default "";

    /**
     * Boolean flag defining whether the property should be listed in the MetatypeProvider or not.
     */
    boolean propertyPrivate() default false;

    /**
     * The bind method that should be used to bind the reference. In case the unbind method is not specified but there
     * is a method starting with "un" and ending with the name of the bind method, that method will be used to unbind
     * the reference.
     */
    String unbind() default "";
}
