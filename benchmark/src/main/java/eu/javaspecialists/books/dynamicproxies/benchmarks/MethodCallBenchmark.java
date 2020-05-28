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
import eu.javaspecialists.books.dynamicproxies.cglib.*;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.*;

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
public class MethodCallBenchmark {
//  // direct call to RealWorker
//  private final RealWorker realWorker = new RealWorker();
//  // direct call to CgLibWorker
//  private final CgLibWorker cgLibWorker = new CgLibWorker();
//
//  // static proxies
//  private final Worker staticProxy = new ProxyWorker();
//
//  //   dynamic proxies
//  private final Worker dynamicProxyDirectCallIncrement =
//      Proxies.castProxy(Worker.class,
//          (proxy, method, args) -> realWorker.increment());
//  private final Worker dynamicProxyDirectCallConsumeCPU =
//      Proxies.castProxy(Worker.class,
//          (proxy, method, args) -> {
//            realWorker.consumeCPU();
//            return null;
//          });
//  private final Worker dynamicProxyReflectiveCallBoostOff =
//      Proxies.castProxyBoostOff(Worker.class,
//          (proxy, method, args) ->
//              method.invoke(realWorker, args));
//  private final Worker dynamicProxyReflectiveCallBoostOn =
//      Proxies.castProxyBoostOn(Worker.class,
//          (proxy, method, args) ->
//              method.invoke(realWorker, args));
//  private final CgLibWorker cgligProxyReflectiveCallBoostOff =
//      CglibProxies.castCglibProxy(CgLibWorker.class,
//          (proxy, method, args) ->
//              method.invoke(cgLibWorker, args));
//  private final CgLibWorker cgligProxyReflectiveCallBoostOn =
//      CglibProxies.castCglibProxy(CgLibWorker.class,
//          (proxy, method, args) ->
//              method.invoke(cgLibWorker, args));

//  @Benchmark
//  public long directCallIncrement() {
//    return realWorker.increment();
//  }
//  @Benchmark
//  public long staticProxyIncrement() {
//    return staticProxy.increment();
//  }
//  @Benchmark
//  public long dynamicProxyDirectCallIncrement() {
//    return dynamicProxyDirectCallIncrement.increment();
//  }
//  @Benchmark
//  public long dynamicProxyReflectiveCallIncrementBoostOff() {
//    return dynamicProxyReflectiveCallBoostOff.increment();
//  }
//  @Benchmark
//  public long dynamicProxyReflectiveCallIncrementBoostOn() {
//    return dynamicProxyReflectiveCallBoostOn.increment();
//  }
//  @Benchmark
//  public long cgligProxyReflectiveCallReflectiveCallIncrementBoostOff() {
//    return cgligProxyReflectiveCallBoostOff.increment();
//  }
//  @Benchmark
//  public long cgligProxyReflectiveCallReflectiveCallIncrementBoostOn() {
//    return cgligProxyReflectiveCallBoostOn.increment();
//  }
//
//  @Benchmark
//  public void directCallConsumeCPU() {
//    realWorker.consumeCPU();
//  }
//  @Benchmark
//  public void staticProxyConsumeCPU() {
//    staticProxy.consumeCPU();
//  }
//  @Benchmark
//  public void dynamicProxyDirectCallConsumeCPU() {
//    dynamicProxyDirectCallConsumeCPU.consumeCPU();
//  }
//  @Benchmark
//  public void dynamicProxyReflectiveCallConsumeCPUBoostOff() {
//    dynamicProxyReflectiveCallBoostOff.consumeCPU();
//  }
//  @Benchmark
//  public void dynamicProxyReflectiveCallConsumeCPUBoostOn() {
//    dynamicProxyReflectiveCallBoostOn.consumeCPU();
//  }
//  @Benchmark
//  public void cgligProxyReflectiveCallReflectiveCallConsumeCPUBoostOff() {
//    cgligProxyReflectiveCallBoostOff.consumeCPU();
//  }
//  @Benchmark
//  public void cgligProxyReflectiveCallReflectiveCallConsumeCPUBoostOn() {
//    cgligProxyReflectiveCallBoostOn.consumeCPU();
//  }
}
// end::listing[]
