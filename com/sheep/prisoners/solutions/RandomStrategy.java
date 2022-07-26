package com.sheep.prisoners.solutions;

import com.sheep.prisoners.Config;
import com.sheep.prisoners.PrisonerRound;
import com.sheep.prisoners.Room;
import com.sheep.prisoners.TeamStrategy;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Open boxes randomly.
 * Cached for performance reason (i.e. each prisoner will follow the same random route for all runs).
 */
public class RandomStrategy implements TeamStrategy {
    static final Random random = new Random(62432352423342L);
    static final List<List<Integer>> cachedPrisoners = new ArrayList<>();

    static {
        for (int i = 0; i < Config.PRISONERS; i++) {
            final List<Integer> boxes = IntStream.range(0, Config.PRISONERS)
                    .boxed()
                    .collect(Collectors.toList());
            Collections.shuffle(boxes, random);
            cachedPrisoners.add(boxes);
        }
    }

    @Override
    public PrisonerRound startPrisonerRound(Room room, int prisoner) {
        Iterator<Integer> boxIndexes = cachedPrisoners.get(prisoner).iterator();
        return () -> room.getBox(boxIndexes.next());
    }
}
