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

package eu.javaspecialists.books.dynamicproxies.benchmarks;

import eu.javaspecialists.books.dynamicproxies.*;
import eu.javaspecialists.books.dynamicproxies.benchmarks.*;
import eu.javaspecialists.books.dynamicproxies.cglib.*;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.annotations.Scope;
import org.springframework.beans.*;
import org.springframework.beans.factory.config.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.web.reactive.context.*;
import org.springframework.context.*;

import java.lang.reflect.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;

/*
 -Deu.javaspecialists.books.dynamicproxies.util.MethodTurboBooster.disabled=false
*/

// tag::listing[]
@Fork(value = 3, jvmArgsAppend = "-XX:+UseParallelGC")
@Warmup(iterations = 5, time = 3)
@Measurement(iterations = 10, time = 3)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
public class BeanRetrievalBenchmark {

  @SpringBootApplication
  static class MicroApplication {}
  private ConfigurableApplicationContext context;
  private List<String> beanNames;

  private List<Class<?>> beanClasses;

  private Map<String, Object> beanMap;

  private static int i = 0;

  {
    context = SpringApplication.run(MicroApplication.class);
    beanNames = Arrays.asList(context.getBeanDefinitionNames());
    Collections.shuffle(beanNames);
    beanClasses = beanNames.stream()
        .map(beanName -> context.getBean(beanName).getClass())
        .collect(Collectors.toList());
    beanMap = Arrays.stream(context.getBeanDefinitionNames())
        .collect(Collectors.toConcurrentMap(
            beanName -> beanName,
            beanName -> context.getBean(beanName)));
  }

  public static void main(String[] args) {
    new BeanRetrievalBenchmark();
  }


  @Benchmark
  public Object mapRetrieve() {
    int nextElement = i++ % beanNames.size();
    return beanMap.get(beanNames.get(nextElement));
  }
  @Benchmark
  public Object contextGetBeanByName() {
    int nextElement = i++ % beanNames.size();
    return context.getBean(beanNames.get(nextElement));
  }
  @Benchmark
  public Object contextGetBeanByClass() {
    int nextElement = i++ % beanClasses.size();
    try {
      return context.getBean(beanClasses.get(nextElement));
    } catch (Exception e) {
      beanClasses.remove(beanClasses.get(nextElement));
      return null;
    }
  }
}
// end::listing[]
