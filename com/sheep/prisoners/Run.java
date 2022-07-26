package com.sheep.prisoners;

import java.util.Random;

public class Run {

    private final TeamStrategy strategy;

    private final Room room;

    public Run(final TeamStrategy strategy, final Random random) {
        this.strategy = strategy;
        this.room = new Room(random);
    }

    public Outcome run() {
        int success = 0;
        for (int p = 0; p < Config.PRISONERS; p++) {
            if (runPrisoner(p)) {
                success++;
            }
        }
        return new Outcome(success);
    }

    private boolean runPrisoner(int prisoner) {
        PrisonerRound round = strategy.startPrisonerRound(room, prisoner);
        for (int attempt = 0; attempt < Config.ATTEMPTS; attempt++) {
            Room.Box box = round.openNextBox();
            if (box.matches(prisoner)) {
                return true;
            }
        }
        return false;
    }

    public static class Outcome {
        private int successPrisoners;

        public Outcome(int successPrisoners) {
            this.successPrisoners = successPrisoners;
        }

        public int getSuccessPrisoners() {
            return successPrisoners;
        }

        public boolean isAllSuccess() {
            return successPrisoners == Config.PRISONERS;
        }
    }
}

