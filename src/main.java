import java.util.Random;
import java.util.Scanner;

public class main {

    // Board
    static char[][] board = new char[3][3];

    // Players
    static String player1 = "Player 1";
    static String player2 = "Player 2";

    // Game state
    static String currentPlayer;
    static char player1Symbol;
    static char player2Symbol;

    public static void main(String[] args) {

        initializeBoard();   // UC1
        tossAndAssign();     // UC2
        printBoard();

        int slot = getUserInput();   // UC3

        int row = getRowFromSlot(slot);   // UC4
        int col = getColFromSlot(slot);
        System.out.println("Row: " + (row+1));
        System.out.println("Column: " + (col+1));


        // UC5: Validate
        if (isValidMove(slot, row, col)) {

            // Determine symbol of current player
            char symbol = (currentPlayer.equals(player1)) ? player1Symbol : player2Symbol;

            // UC6: Place move
            placeMove(row, col, symbol);

            printBoard();

        } else {
            System.out.println("Move rejected. Try again.");
        }
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
     * UC3: Get user input
     */
    static int getUserInput() {

        Scanner scanner = new Scanner(System.in);

        char symbol = (currentPlayer.equals(player1)) ? player1Symbol : player2Symbol;

        System.out.print(currentPlayer + " (" + symbol + "), enter slot (1-9): ");

        return scanner.nextInt();
    }

    /*
     * UC4: Slot to row
     */
    static int getRowFromSlot(int slot) {
        return (slot - 1) / 3;
    }

    /*
     * UC4: Slot to column
     */
    static int getColFromSlot(int slot) {
        return (slot - 1) % 3;
    }

    /*
     * UC5: Validate move
     */
    static boolean isValidMove(int slot, int row, int col) {

        if (slot < 1 || slot > 9) {
            System.out.println("Invalid slot! Choose between 1 and 9.");
            return false;
        }

        if (board[row][col] != '-') {
            System.out.println("Cell already occupied!");
            return false;
        }

        return true;
    }

    /*
     * UC6: Place move on board
     */
    static void placeMove(int row, int col, char symbol) {
        board[row][col] = symbol;
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