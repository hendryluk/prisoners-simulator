## What
Simulate problems described in https://youtu.be/iSNsgj1OCLA

## How to run
Requirement: JDK (I use v20)

Run: [com.sheep.prisoners.MainApp](com/sheep/prisoners/MainApp.java).

Uncomment the relevant lines to try out different strategies.

## Solutions (i.e. strategies)
See [solutions](com/sheep/prisoners/solutions) package and see the Javadoc of all the implementations.

There are currently 3 implementations:
- [ChainStrategy](com/sheep/prisoners/solutions/ChainStrategy.java) (success rate 31%)
- [RandomStrategy](com/sheep/prisoners/solutions/RandomStrategy.java) (success rate 0.0000%)
- [SlidingStrategy](com/sheep/prisoners/solutions/SlidingStrategy.java) (success rate 0.0000%)

The idea is to try out implement new strategies that can fare better than 0.00000%. :P

## Tweaks
See com.sheep.prisoners.Config to tweak simulation variables (e.g. # runs, # prisoners, random seeds, etc).
