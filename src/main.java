import java.util.Random;
import java.util.Scanner;

public class main {

    // Board (3x3)
    static char[][] board = new char[3][3];

    // Players
    static String player1 = "Player 1";
    static String player2 = "Player 2";

    // Game state
    static String currentPlayer;
    static char player1Symbol;
    static char player2Symbol;

    /*
     * Main method - runs UC1 to UC4
     */
    public static void main(String[] args) {

        initializeBoard();   // UC1
        tossAndAssign();     // UC2
        printBoard();

        int slot = getUserInput();   // UC3

        // UC4: Convert slot to row & column
        int row = getRowFromSlot(slot);
        int col = getColFromSlot(slot);

        System.out.println("Row: " + row);
        System.out.println("Column: " + col);
    }

    /*
     * UC1: Initialize board
     */
    static void initializeBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = '-';
            }
        }
    }

    /*
     * UC2: Toss and assign symbols
     */
    static void tossAndAssign() {

        Random random = new Random();
        int toss = random.nextInt(2);

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
     * UC3: Get user input (1–9)
     */
    static int getUserInput() {

        Scanner scanner = new Scanner(System.in);

        char symbol = (currentPlayer.equals(player1)) ? player1Symbol : player2Symbol;

        System.out.print(currentPlayer + " (" + symbol + "), enter slot (1-9): ");

        int slot = scanner.nextInt();

        return slot;
    }

    /*
     * UC4: Convert slot to row index
     */
    static int getRowFromSlot(int slot) {
        return (slot - 1) / 3;
    }

    /*
     * UC4: Convert slot to column index
     */
    static int getColFromSlot(int slot) {
        return (slot - 1) % 3;
    }

    /*
     * Print board
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