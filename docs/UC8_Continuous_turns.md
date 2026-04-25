UC8: Continuous Turn-Based Game Loop
Goal

Control continuous gameplay by alternating turns until the game ends.

Actor

Game System

Flow of Execution
Game loop starts
Current player makes a move
Board is updated and displayed
System checks game status (win/draw)
Turn is switched
Loop continues until game over
Theoretical Concepts Used

1. While Loop

Used to run the game continuously

2. Game State Flags

isHumanTurn, gameOver control flow

3. Turn Switching

Alternates between player and computer
Key Requirements
Alternate turns correctly
Continue game until end condition
Integrate win/draw checks from other use cases