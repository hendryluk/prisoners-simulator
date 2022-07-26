package com.sheep.prisoners;

import com.sheep.prisoners.solutions.ChainStrategy;
import com.sheep.prisoners.solutions.RandomStrategy;
import com.sheep.prisoners.solutions.SlidingStrategy;

public class MainApp {
    public static void main(String[] args) {
        TeamStrategy strategy =
                new ChainStrategy();
//                new RandomStrategy();
//                new SlidingStrategy();
        new Simulator(strategy).simulate();
    }
}
