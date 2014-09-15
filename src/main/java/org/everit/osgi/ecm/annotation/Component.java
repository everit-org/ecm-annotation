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
    String configurationPid();

    /**
     * If true configuration is required to activate the component otherwise if there is no configuration, the component
     * will be activated anyway.
     */
    boolean configurationRequired() default false;

    /**
     * This is generally used as a description for the object described by the meta type. This name may be localized by
     * prepending a % sign to the name. Default value: %&lt;name&gt;.description
     */
    String description();

    /**
     * Resource path of the icon that is assigned to the component. The classloader of the component is used to find the
     * resource.
     */
    String icon();

    /**
     * This is generally used as a title for the object described by the meta type. This name may be localized by
     * prepending a % sign to the name. Default value: %&lt;name&gt;.name
     */
    String label();

    /**
     * Defines the Component name also used as the PID for the Configuration Admin Service. Default value: Fully
     * qualified name of the Java class.
     */
    String name();
}
