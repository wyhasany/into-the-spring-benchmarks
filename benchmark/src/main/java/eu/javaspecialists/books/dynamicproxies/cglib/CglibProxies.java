/*
 * Copyright (C) 2020 Heinz Max Kabutz
 *
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.  Heinz Max Kabutz
 * licenses this file to you under the Apache License, Version
 * 2.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the
 * License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied.  See the License for the specific
 * language governing permissions and limitations under the
 * License.
 */

package eu.javaspecialists.books.dynamicproxies.cglib;

import eu.javaspecialists.books.dynamicproxies.handlers.*;
import eu.javaspecialists.books.dynamicproxies.util.*;
import net.sf.cglib.proxy.*;

import java.util.*;

public class CglibProxies {

  /**
   * @param clazz    The class of object
   * @param handler InvocationHandler for all methods
   */
  @SuppressWarnings("unchecked")
  public static <S> S castCglibProxy(Class<S> intf,
                                     InvocationHandler handler) {
    Objects.requireNonNull(intf, "intf==null");
    Objects.requireNonNull(handler, "handler==null");
    return MethodTurboBooster.boost(
        (S) Enhancer.create(intf, handler));
  }

  /**
   * @param clazz    The class of object
   * @param handler InvocationHandler for all methods
   */
  @SuppressWarnings("unchecked")
  public static <S> S castCglibProxyBoostOn(Class<S> intf,
                                     InvocationHandler handler) {
    Objects.requireNonNull(intf, "intf==null");
    Objects.requireNonNull(handler, "handler==null");
    return MethodTurboBooster.boostOn(
        (S) Enhancer.create(intf, handler));
  }

  /**
   * @param clazz    The class of object
   * @param handler InvocationHandler for all methods
   */
  @SuppressWarnings("unchecked")
  public static <S> S castCglibProxyBoostOf(Class<S> intf,
                                     InvocationHandler handler) {
    Objects.requireNonNull(intf, "intf==null");
    Objects.requireNonNull(handler, "handler==null");
    return MethodTurboBooster.boostOff(
        (S) Enhancer.create(intf, handler));
  }

}
