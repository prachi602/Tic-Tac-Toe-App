import java.util.Random;
import java.util.Scanner;

public class main {

    // 2D array representing the Tic-Tac-Toe board
    static char[][] board = new char[3][3];

    // Player names
    static String player1 = "Player 1";
    static String player2 = "Player 2";

    // Stores current player
    static String currentPlayer;

    // Symbols for players
    static char player1Symbol;
    static char player2Symbol;

    /*
     * Main method - executes UC1, UC2, UC3
     */
    public static void main(String[] args) {

        initializeBoard();   // UC1
        tossAndAssign();     // UC2
        printBoard();        // display empty board

        int slot = getUserInput();   // UC3

        System.out.println("You selected slot: " + slot);
    }

    /*
     * UC1: Initialize board with '-'
     */
    static void initializeBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = '-';
            }
        }
    }

    /*
     * UC2: Random toss and symbol assignment
     */
    static void tossAndAssign() {

        Random random = new Random();
        int toss = random.nextInt(2); // 0 or 1

        if (toss == 0) {
            currentPlayer = player1;
            player1Symbol = 'X';
            player2Symbol = 'O';
        } else {
            currentPlayer = player2;
            player2Symbol = 'X';
            player1Symbol = 'O';
        }

        System.out.println("Toss Result:");
        System.out.println(currentPlayer + " starts first!");
        System.out.println(player1 + " = " + player1Symbol);
        System.out.println(player2 + " = " + player2Symbol);
    }

    /*
     * UC3: Accept User Slot Input (1–9)
     * Reads input and returns slot number
     */
    static int getUserInput() {

        Scanner scanner = new Scanner(System.in);

        // Determine current player's symbol
        char symbol = (currentPlayer.equals(player1)) ? player1Symbol : player2Symbol;

        System.out.print(currentPlayer + " (" + symbol + "), enter slot (1-9): ");

        int slot = scanner.nextInt();   // read integer input

        return slot;   // return to main/game logic
    }

    /*
     * Print board in formatted grid
     */
    static void printBoard() {
        System.out.println("-------------");

        for (int row = 0; row < 3; row++) {

            System.out.print("| ");

            for (int col = 0; col < 3; col++) {
                System.out.print(board[row][col] + " | ");
            }

            System.out.println();
            System.out.println("-------------");
        }
    }
}