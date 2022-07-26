package com.sheep.prisoners;

/**
 * The implementation of this interface defines the team strategy that the team agrees upfront before entering the room.
 */
public interface TeamStrategy {
    /**
     * Prisoner is now entering the room. Good luck buddy!
     *
     * @param room
     * @param prisoner
     * @return the prisoner's round while being in the room.
     */
    PrisonerRound startPrisonerRound(Room room, int prisoner);
}
