UC5: Validate User Move
Goal

Ensure the move is within bounds and the selected cell is empty.

Actor

Game System

Flow of Execution
Row and column are received
System checks if slot is within valid range
System checks if cell is empty
If valid → move is accepted
If invalid → move is rejected
Theoretical Concepts Used

1.Conditional Logic

Used to check validity of move

2.Boundary Checking

Ensures slot is between 1–9

3.Defensive Programming

Prevents invalid or illegal moves
Key Requirements
Row and column must be within range (0–2)
Cell must be empty
Reject invalid moves
Output Example
Invalid slot! Choose between 1 and 9.