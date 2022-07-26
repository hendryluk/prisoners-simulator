package com.sheep.prisoners;

import java.util.Random;
import java.util.stream.IntStream;

public class Simulator {
    private final TeamStrategy strategy;
    private final Random random = new Random(Config.RANDOM_SEED);

    private final StatsCollector stats = new StatsCollector();

    public Simulator(TeamStrategy strategy) {
        this.strategy = strategy;
    }

    public void simulate() {
        IntStream.range(0, Config.RUNS)
                .parallel()
                .forEach(this::runOnce);

        stats.print();
    }

    private void runOnce(int index) {
        stats.collect(new Run(strategy, random).run());
    }
}
