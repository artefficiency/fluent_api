package tech.artefficiency.fluent_api.part_3.sum;

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
public class SumBenchmark {

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(SumBenchmark.class.getSimpleName())
                .build();
        new Runner(opt).run();
    }

    private Sum sum;

    @Setup(Level.Trial)
    public void setUp() {
        sum = new Sum();
    }

    @State(Scope.Benchmark)
    public static class Params {

        public int a = 1;
        public int b = 2;
    }

    @Benchmark
    public void createNewObject(Blackhole blackhole) {
        blackhole.consume(new Object());
    }

    @Benchmark
    public void inlineSum(Blackhole blackhole, Params params) {
        blackhole.consume(params.a + params.b);
    }

    @Benchmark
    public void instanceMethod(Blackhole blackhole, Params params) {
        blackhole.consume(sum.instanceMethod(params.a, params.b));
    }

    @Benchmark
    public void staticMethod(Blackhole blackhole, Params params) {
        blackhole.consume(Sum.staticMethod(params.a, params.b));
    }

    @Benchmark
    public void instanceMethodLambda(Blackhole blackhole, Params params) {
        blackhole.consume(sum.instanceMethodLambda(params.a).and(params.b));
    }

    @Benchmark
    public void staticMethodLambda(Blackhole blackhole, Params params) {
        blackhole.consume(Sum.staticMethodLambda(params.a).and(params.b));
    }

    @Benchmark
    public void instanceMethodInstanceAdder(Blackhole blackhole, Params params) {
        blackhole.consume(sum.instanceMethodInstanceAdder(params.a).and(params.b));
    }

    @Benchmark
    public void instanceMethodStaticAdder(Blackhole blackhole, Params params) {
        blackhole.consume(sum.instanceMethodStaticAdder(params.a).and(params.b));
    }

    @Benchmark
    public void staticMethodStaticAdder(Blackhole blackhole, Params params) {
        blackhole.consume(Sum.staticMethodStaticAdder(params.a).and(params.b));
    }
}
