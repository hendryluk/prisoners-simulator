package com.sheep.prisoners;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Room {
    private final List<Box> boxes;

    public Room(Random random) {
        final List<Integer> numbers = shuffleNumbers(random);
        boxes = IntStream.range(0, numbers.size())
                .mapToObj(i -> new Box(i, numbers.get(i)))
                .toList();
    }

    private static List<Integer> shuffleNumbers(Random random) {
        List<Integer> numbers = IntStream.range(0, Config.PRISONERS)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(numbers, random);
        return numbers;
    }

    public Box getBox(int index) {
        return boxes.get(index);
    }

    public static class Box {
        private final int index;
        private final int value;

        private Box(int index, int value) {
            this.index = index;
            this.value = value;
        }

        public int getIndex() {
            return index;
        }

        public int getValue() {
            return value;
        }

        public boolean matches(int expectedValue) {
            return value == expectedValue;
        }
    }
}
