package tech.artefficiency.fluent_api.part_3.builder;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@Fork(value = 3, warmups = 3)
@Warmup(iterations = 5, time = 3, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 3, timeUnit = TimeUnit.SECONDS)
public class EntityBenchmark {

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(EntityBenchmark.class.getSimpleName())
                .build();
        new Runner(opt).run();
    }

    @State(Scope.Benchmark)
    public static class Params {
        public int           id        = 34;
        public String        name      = "entity";
        public LocalDateTime timestamp = LocalDateTime.now();
        public boolean       active    = true;
    }

    @Benchmark
    public void constructor(Blackhole blackhole, Params params) {
        blackhole.consume(new Entity(params.id, params.name, params.timestamp, params.active));
    }

    @Benchmark
    public void builder(Blackhole blackhole, Params params) {
        blackhole.consume(Entity.builder().id(params.id).name(params.name).timestamp(params.timestamp).active(params.active).build());
    }
}