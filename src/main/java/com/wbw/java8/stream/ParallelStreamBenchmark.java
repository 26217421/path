package com.wbw.java8.stream;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * @author wbw
 * @date 2022-7-9 20:11
 */
@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 2, jvmArgs={"-Xms4G", "-Xmx4G"})
public class ParallelStreamBenchmark {
    private static final long N= 10_000_000L;
    @Benchmark
    public long sequentialSum() {
        return Stream.iterate(1L, i -> i + 1).limit(N)
                .reduce( 0L, Long::sum);
    }

    @Benchmark
    public long iterativeSum() {
        long result = 0;
        for (long i = 1L; i <= N; i++) {
            result += i;
        }
        return result;
    }

    @Benchmark
    public long parallelSum() {
        return Stream.iterate(1L, i -> i + 1).limit(N)
                .parallel()
                .reduce( 0L, Long::sum);
    }

    @TearDown(Level.Invocation)
    public void tearDown() {
        System.gc();
    }
}