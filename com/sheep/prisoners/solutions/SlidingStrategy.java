package com.sheep.prisoners.solutions;

import com.sheep.prisoners.Config;
import com.sheep.prisoners.PrisonerRound;
import com.sheep.prisoners.Room;
import com.sheep.prisoners.TeamStrategy;

/**
 * Open the box from your own number, then open the box next to it and so on.
 * Rotate to 0 when you hit the end.
 */
public class SlidingStrategy implements TeamStrategy {
    @Override
    public PrisonerRound startPrisonerRound(Room room, int prisoner) {
        return new PrisonerRound() {
            int next = prisoner;
            @Override
            public Room.Box openNextBox() {
                Room.Box result = room.getBox(next++);
                next %= Config.PRISONERS;
                return result;
            }
        };
    }
}
