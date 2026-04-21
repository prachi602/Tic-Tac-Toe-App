Goal

Convert the user-entered slot number into corresponding row and column indices.

Actor

Human Player

Flow of Execution
User enters a slot number (1–9)
System receives the slot value
System converts slot into row index
System converts slot into column index
Row and column values are returned to game logic
Theoretical Concepts Used
1. Zero-based Indexing
   Arrays start from index 0
   Board indices range from 0 to 2
2. Mathematical Mapping
   Slot numbers (1–9) are mapped to 2D positions
3. Division and Modulo
   Row = (slot - 1) / 3
   Column = (slot - 1) % 3
4. Utility Methods
   Separate methods used for conversion:
   getRowFromSlot()
   getColFromSlot()
   Key Requirements
   Convert slot (1–9) into valid row and column indices
   Use division and modulo operations
   Return calculated indices
   Output Example
   Input Slot: 7  
   Row: 2  
   Column: 0  