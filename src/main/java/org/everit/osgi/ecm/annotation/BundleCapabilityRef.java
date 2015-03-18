/*
 * Copyright (C) 2011 Everit Kft. (http://www.everit.org)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.everit.osgi.ecm.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.osgi.framework.Bundle;

/**
 * The annotation identifies a Bundle Capability reference. The reference will be satisfied if the
 * bundle capability is provided by a bundle that has the necessary {@link #stateMask()}.
 *
 * <p>
 * The annotation can be defined on variables, setter methods or within the
 * {@link BundleCapabilityRefs} annotation on top of the class.
 */
@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface BundleCapabilityRef {

  /**
   * The id of the attribute of the reference. If not provided the default value is defined based on
   * the value of {@link #configurationType()}:
   *
   * <ul>
   * <li>{@link ReferenceConfigurationType#FILTER}: The default value will be "
   * {@link #referenceId()}" + ".target".</li>
   * <li>{@link ReferenceConfigurationType#CLAUSE}: The default value will be "
   * {@link #referenceId()}" + ".clause".</li>
   * </ul>
   */
  String attributeId() default "";

  /**
   * Type of configuration that is either a clause or a filter.
   */
  ReferenceConfigurationType configurationType() default ReferenceConfigurationType.FILTER;

  /**
   * The default value(s) of the attribute. In case the annotation is appended to a field or method,
   * the default values come from the default value of the field. In case the reference is not
   * optional, the component does not need configuration and the default value is not defined, a one
   * element array will be used with an empty String.
   */
  String[] defaultValue() default {};

  /**
   * A descriptive text to provide the client in a form to configure this property. This name may be
   * localized by prepending a % sign to the name. Default value: %&lt;name&gt;.description
   */
  String description() default "";

  /**
   * If true, the reference is re-binded without restarting the component in case of a service
   * switch. The component also does not stop if the configuration is updated behind in the way that
   * the reference can remain satisfied after the actualization of the clause(s) or filter(s).
   */
  boolean dynamic() default false;

  /**
   * The label to display in a form to configure this attribute. This name may be localized by
   * prepending a % sign to the name. Default value: %&lt;name&gt;.name
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
   * Namespace of the bundle capability.
   */
  String namespace();

  /**
   * Whether at least one reference should be configured or not.
   */
  boolean optional() default false;

  /**
   * The id of the reference. If not specified and the annotation is defined on a field, the id of
   * the reference will be the name of the field.
   */
  String referenceId() default "";

  /**
   * The setter method that should be used to set the reference. If the annotation is defined on a
   * method, that method and it is not specified otherwise in the annotation, the method will be
   * used as a bind method. If the annotation is attached to a field and the bind method is not
   * defined in the annotation and there is method that has the same name as the field but prefixed
   * with "bind" that method will be used as a bind method. In case there is no bind method but
   * there is a setter for the field, it will be used to set the property.
   */
  String setter() default "";

  /**
   * State mask of the bundle that can provide the necessary capability.
   */
  int stateMask() default Bundle.ACTIVE;
}
