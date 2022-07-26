package com.sheep.prisoners;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

import static java.lang.String.format;

public class StatsCollector {
    private AtomicInteger success = new AtomicInteger(0);
    private AtomicInteger total = new AtomicInteger(0);

    private final AtomicIntegerArray distribution = new AtomicIntegerArray(Config.PRISONERS + 1);

    public void collect(Run.Outcome outcome) {
        int currentTotal = total.incrementAndGet();
        if (outcome.isAllSuccess()) {
            success.getAndIncrement();
        }
        distribution.getAndIncrement(outcome.getSuccessPrisoners());

        if (currentTotal % 10_000 == 0) {
            System.out.println(format("... progress: %,d", currentTotal));
        }
    }

    public void print() {
        System.out.println("================= RESULT =================");
        System.out.println(format("Total: %,d", total.get()));
        System.out.println(format("Success: %,d", success.get()));
        System.out.println(format("Success rate: %e", (double) success.get() / total.get()));
        System.out.println("--------------- Distribution -------------");

        for (int i = 0; i < distribution.length(); i++) {
            System.out.println(format("%s: %f", i, (float) distribution.get(i) / total.get()));
        }
    }
}