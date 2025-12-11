package tech.artefficiency.fluent_api.part_3.expression;

import java.util.stream.IntStream;

class Arithmetics {

    static int sum(int... values) {
        int result = values[0];

        for (int i = 1; i < values.length; i++) {
            result += values[i];
        }

        return result;
    }

    static int sum10(int a, int b, int c, int d, int e, int f, int g, int h, int i, int j) {
        return a + b + c + d + e + f + g + h + i + j;
    }

    static int sumStream(int... values) {
        return IntStream.of(values).sum();
    }
}