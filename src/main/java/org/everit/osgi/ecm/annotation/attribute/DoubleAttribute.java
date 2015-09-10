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
package org.everit.osgi.ecm.annotation.attribute;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.everit.osgi.ecm.annotation.ThreeStateBoolean;

/**
 * Annotation of the {@link Double} attribute of a component.
 */
@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DoubleAttribute {

  /**
   * The id of the attribute. If the annotation is defined on a field, the default id of the
   * attribute will be the name of the field. If the annotation is defined on a method and the name
   * of the method starts with "set", the default value will be the name of the method after the
   * "set" word starting with a lowercase letter.
   */
  String attributeId() default "";

  /**
   * The default value(s) of the attribute. In case the annotation is appended to a field or method,
   * the default values come from the default value of the field.
   */
  double[]defaultValue() default {};

  /**
   * A descriptive text to provide the client in a form to configure this property. This name may be
   * localized by prepending a % sign to the name. Default value: %&lt;name&gt;.description
   */
  String description() default "";

  /**
   * If true, the property is re-set without restarting the component. Otherwise the component is
   * restarted it the configuration is updated in the way that the value of this attribute changes
   * in the component instance.
   */
  boolean dynamic() default false;

  /**
   * The label to display in a form to configure this property. This name may be localized by
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
   * Whether the attribute is optional or not.
   */
  boolean optional() default false;

  /**
   * Some properties may only be set to a set of possible values. To support user interfaces which
   * provide a selection list of values or a list of checkboxes the option values and labels may be
   * defined as parameters to the {@link DoubleAttribute} annotation. All parameters in the form of
   * name-value pairs are used to build the list of available value options. The parameter name is
   * used as the value while the parameter value is used as the label in the user interface. This
   * label may be prepended with a % sign to localize the string.
   */
  DoubleAttributeOption[]options() default {};

  /**
   * The priority of the attribute. Smaller number means higher priority. The attributes with higher
   * priority will be rendered first on the configuration screen.
   */
  float priority() default AttributePriority.DEFAULT_ATTRIBUTE_PRIORITY;

  /**
   * The setter method that should be used to inject the value of this property. If the annotation
   * is defined on a method, that method and it is not specified otherwise in the annotation, the
   * method will be used as a setter. If the annotation is attached to a field and the setter is not
   * defined in the annotation, the field will be injected via reflection.
   */
  String setter() default "";
}
