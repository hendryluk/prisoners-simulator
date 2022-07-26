package com.sheep.prisoners;

/**
 * Describes what a prisoner would do when he's inside the room. Poor dude.
 */
public interface PrisonerRound {
    /**
     * Instruct the prisoner to open the next box.
     * @return the box he's opened
     */
    Room.Box openNextBox();
}
