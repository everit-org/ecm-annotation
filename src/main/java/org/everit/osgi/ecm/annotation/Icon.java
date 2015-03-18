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

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * An optional icon that can be set for the {@link Component} to have a nicer look on the
 * configuration screen.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Icon {

  /**
   * Resource path of the icon that is assigned to the component. The classloader of the component
   * is used to find the resource.
   */
  String path();

  /**
   * Size of an icon, e.g. a 16x16 pixels icon then size = 16
   */
  int size();
}
