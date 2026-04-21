# UC2 – Player Toss and Symbol Assignment

## Goal
Randomly decide which player starts and assign symbols (X or O).

## Actor
Game System

## Flow of Execution
1. Game starts
2. System performs a random toss
3. One player is selected to start first
4. Symbols (X and O) are assigned
5. Current player and symbols are stored

## Theoretical Concepts Used

### 1. Random Number Generation
Used to simulate a toss:
- 0 → Player 1 starts
- 1 → Player 2 starts

### 2. Conditional Logic
- If Player 1 starts → Player 1 = X
- Else → Player 2 = X

### 3. Game State Variables
- currentPlayer
- player1Symbol
- player2Symbol

## Output Example
Toss Result:
Player 1 starts first!
Player 1 = X
Player 2 = O