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

/**
 * The class is an ECM Component.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Component {

  /**
   * Defines the Component id. Default value: Fully qualified name of the Java class.
   */
  String componentId() default "";

  /**
   * The configuration pid. The default value for this is the name of the component.
   */
  String configurationPid() default "";

  /**
   * If true configuration is required to activate the component otherwise if there is no
   * configuration, the component will be activated anyway.
   */
  ConfigurationPolicy configurationPolicy() default ConfigurationPolicy.OPTIONAL;

  /**
   * This is generally used as a description for the object described by the meta type. This name
   * may be localized by prepending a % sign to the name. Default value: %&lt;name&gt;.description
   */
  String description() default "";

  /**
   * One or more icon that should be shown for the component on a management screen.
   */
  Icon[] icons() default {};

  /**
   * This is generally used as a title for the object described by the meta type. This name may be
   * localized by prepending a % sign to the name. Default value: %&lt;name&gt;.name
   */
  String label() default "";

  /**
   * The base name of the place of the localized texts.
   */
  String localizationBase() default "OSGI-INF/metatype/metatype";

  /**
   * If true, MetatypeProvider OSGi service will be registered for the component.
   */
  boolean metatype() default true;
}
