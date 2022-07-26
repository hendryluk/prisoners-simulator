package com.sheep.prisoners.solutions;

import com.sheep.prisoners.PrisonerRound;
import com.sheep.prisoners.Room;
import com.sheep.prisoners.TeamStrategy;

/**
 * As described in https://youtu.be/iSNsgj1OCLA
 * I.e. open the box with your own number, then follow the number inside it to open the next box.
 */
public class ChainStrategy implements TeamStrategy {
    @Override
    public PrisonerRound startPrisonerRound(Room room, int prisoner) {
        return new PrisonerRound() {
            int nextBox = prisoner;

            @Override
            public Room.Box openNextBox() {
                Room.Box result = room.getBox(nextBox);
                nextBox = result.getValue();
                return result;
            }
        };
    }
}
