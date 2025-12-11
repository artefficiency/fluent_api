package tech.artefficiency.fluent_api.part_3.expression;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@Fork(value = 3, warmups = 3)
@Warmup(iterations = 5, time = 3, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 3, timeUnit = TimeUnit.SECONDS)
public class ArithmeticsBenchmark {

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(ArithmeticsBenchmark.class.getSimpleName())
                .build();
        new Runner(opt).run();
    }

    @State(Scope.Benchmark)
    public static class Params {

        public int a = 1;
        public int b = 2;
        public int c = 3;
        public int d = 4;
        public int e = 5;
        public int f = 6;
        public int g = 7;
        public int h = 8;
        public int i = 9;
        public int j = 10;
    }

    @Benchmark
    public void inlineSum(Blackhole blackhole, Params params) {
        blackhole.consume(params.a + params.b + params.c + params.d + params.e + params.f + params.g + params.h + params.i + params.j);
    }

    @Benchmark
    public void arithmeticsSum(Blackhole blackhole, Params params) {
        blackhole.consume(Arithmetics.sum(params.a, params.b, params.c, params.d, params.e, params.f, params.g, params.h, params.i, params.j));
    }

    @Benchmark
    public void arithmeticsSumStream(Blackhole blackhole, Params params) {
        blackhole.consume(Arithmetics.sumStream(params.a, params.b, params.c, params.d, params.e, params.f, params.g, params.h, params.i, params.j));
    }

    @Benchmark
    public void arithmeticsSum10(Blackhole blackhole, Params params) {
        blackhole.consume(Arithmetics.sum10(params.a, params.b, params.c, params.d, params.e, params.f, params.g, params.h, params.i, params.j));
    }

    @Benchmark
    public void value(Blackhole blackhole, Params params) {
        blackhole.consume(Value.of(params.a).plus(params.b).plus(params.c).plus(params.d).plus(params.e).plus(params.f).plus(params.g).plus(params.h).plus(params.i).plus(params.j).get());
    }
}