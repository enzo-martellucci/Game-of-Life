# Game of Life

## What is it ?
The Game of Life is a cellular automaton imagined by John Conway in 1970.

A cellular automaton is not a real game, it's just a grid composed of cells that can have
several states. At each iteration, the state of each cell change according to its neighbors.

In the Game of Life, 2 states are possible :
- dead
- alive

The rules to determine the state of a cell at next iteration are :
- if a cell is dead, and have exactly 3 alive neighbors, she comes to life, otherwise, she stays dead.
- if the cell is alive, and have between 2 and 3 alive neighbors, she stays alive, otherwise, she die.

## Launch
To play the Game of Life, download the "application" directory and execute the jar file with:
java -jar GameOfLife.jar

## NB
The game is still in development, available functionalities for now are :
- Play / Pause
- Step by Step (forward and backward)
- Restart
- Loading from a .cells file
- Save a configuration
- Random grid generation (simple, symmetric, double symmetric)
- Modify delay between each iteration