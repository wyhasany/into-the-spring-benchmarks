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
public class ProxyCreationBenchmark {

  @Benchmark
  public CreationRealWorker directCreation() {
    return new CreationRealWorker();
  }
  @Benchmark
  public CreationProxyWorker staticProxyCreation() {
    return new CreationProxyWorker();
  }
  @Benchmark
  public Worker dynamicProxyCreation() {
    CreationRealWorker realWorker = new CreationRealWorker();
    return Proxies.castProxyBoostOn(Worker.class,
        (proxy, method, args) ->
            method.invoke(realWorker, args));
  }
  @Benchmark
  public CreationCgLibWorker cglibProxyCreation() {
    CreationCgLibWorker creationCgLibWorker =
        new CreationCgLibWorker();
    return CglibProxies.castCglibProxy(CreationCgLibWorker.class,
        (proxy, method, args) ->
            method.invoke(creationCgLibWorker, args));
  }
}
// end::listing[]
