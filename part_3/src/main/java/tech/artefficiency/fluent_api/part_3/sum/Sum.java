package tech.artefficiency.fluent_api.part_3.sum;

public class Sum {

    final InstanceAdder instanceAdder = new InstanceAdder();

    int instanceMethod(int a, int b) {
        return a + b;
    }

    static int staticMethod(int a, int b) {
        return a + b;
    }

    Adder instanceMethodLambda(int a) {
        return b -> a + b;
    }

    static Adder staticMethodLambda(int a) {
        return b -> a + b;
    }

    Adder instanceMethodInstanceAdder(int a) {
        return instanceAdder.initialize(a);
    }

    Adder instanceMethodStaticAdder(int a) {
        return new StaticAdder(a);
    }

    static Adder staticMethodStaticAdder(int a) {
        return new StaticAdder(a);
    }

    interface Adder {
        int and(int b);
    }

    record StaticAdder(int a) implements Adder {

        @Override
        public int and(int b) {
            return a + b;
        }
    }

    class InstanceAdder implements Adder {

        private int a;

        InstanceAdder initialize(int a) {
            this.a = a;
            return this;
        }

        @Override
        public int and(int b) {
            return a + b;
        }
    }
}