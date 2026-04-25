UC9: Check Winning Condition
Goal

Detect if a player has won the game.

Actor

Game System

Flow of Execution
After each move
System checks all rows
System checks all columns
System checks both diagonals
If three matching symbols are found → winner is declared
Theoretical Concepts Used

1. Pattern Matching

Identifies three identical symbols in a line

2. Logical Conditions

Compares board positions for equality

3. Loop-Based Checks

Iterates through rows and columns
Key Requirements
Check all rows, columns, and diagonals
Detect three same symbols
Return true when a win is found