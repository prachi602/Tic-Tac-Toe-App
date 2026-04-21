import java.util.Random;

public class main {

    // 2D array representing the Tic-Tac-Toe board
    // 3 rows and 3 columns
    static char[][] board = new char[3][3];

    // Player names
    static String player1 = "Player 1";
    static String player2 = "Player 2";

    // Stores which player is currently playing
    static String currentPlayer;

    // Symbols assigned to players (X or O)
    static char player1Symbol;
    static char player2Symbol;

    /*
     * Main method - entry point of the program
     * Executes UC1 and UC2:
     * 1. Initializes the board
     * 2. Performs toss and assigns symbols
     * 3. Displays the empty board
     */
    public static void main(String[] args) {
        initializeBoard();   // UC1: create empty board
        tossAndAssign();     // UC2: decide starting player and symbols
        printBoard();        // display board
    }

    /*
     * UC1: Initialize Board
     * Fills all positions of the board with '-' to represent empty cells
     * Uses nested loops to traverse rows and columns
     */
    static void initializeBoard() {
        for (int row = 0; row < 3; row++) {          // loop through rows
            for (int col = 0; col < 3; col++) {      // loop through columns
                board[row][col] = '-';               // assign empty symbol
            }
        }
    }

    /*
     * UC2: Toss and Symbol Assignment
     * Simulates a coin toss using Random class
     * Based on result:
     * - Decides which player starts first
     * - Assigns symbols (X or O)
     */
    static void tossAndAssign() {

        // Create Random object
        Random random = new Random();

        // Generate random number (0 or 1)
        // 0 → Player 1 starts
        // 1 → Player 2 starts
        int toss = random.nextInt(2);

        // Conditional logic based on toss result
        if (toss == 0) {
            currentPlayer = player1;   // Player 1 starts first

            player1Symbol = 'X';       // First player gets X
            player2Symbol = 'O';       // Second player gets O

        } else {
            currentPlayer = player2;   // Player 2 starts first

            player2Symbol = 'X';       // First player gets X
            player1Symbol = 'O';       // Second player gets O
        }

        // Display toss result and symbol assignment
        System.out.println("Toss Result:");
        System.out.println(currentPlayer + " starts first!");
        System.out.println(player1 + " = " + player1Symbol);
        System.out.println(player2 + " = " + player2Symbol);
    }

    /*
     * Prints the Tic-Tac-Toe board in a formatted grid
     * Uses separators for better readability
     */
    static void printBoard() {
        System.out.println("-------------");   // top border

        for (int row = 0; row < 3; row++) {

            System.out.print("| ");            // left border

            for (int col = 0; col < 3; col++) {
                System.out.print(board[row][col] + " | ");  // print each cell
            }

            System.out.println();              // move to next line
            System.out.println("-------------"); // row separator
        }
    }
}