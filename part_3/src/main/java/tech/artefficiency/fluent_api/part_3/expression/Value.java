package tech.artefficiency.fluent_api.part_3.expression;

public class Value {
    private final int value;

    private Value(int value) {
        this.value = value;
    }

    int get() {
        return value;
    }

    Value plus(int value) {
        return new Value(this.value + value);
    }

    static Value of(int value) {
        return new Value(value);
    }
}