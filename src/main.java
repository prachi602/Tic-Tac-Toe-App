import java.util.Random;
import java.util.Scanner;

public class main {

    // Board
    static char[][] board = new char[3][3];

    // Players
    static String player = "Player 1";
    static String computer = "Computer";

    // Symbols
    static char playerSymbol;
    static char computerSymbol;

    // Game state
    static boolean isHumanTurn = true;
    static boolean gameOver = false;

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {

        initializeBoard();   // UC1
        tossAndAssign();     // UC2
        printBoard();

        // UC8: Game loop
        while (!gameOver) {

            if (isHumanTurn) {
                playerMove();
            } else {
                computerMove();
            }

            printBoard();

            // UC9 + UC10 (stub)
            if (checkWin() || checkDraw()) {
                gameOver = true;
                break;
            }

            isHumanTurn = !isHumanTurn;
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

        int toss = random.nextInt(2);

        if (toss == 0) {
            isHumanTurn = true;
            playerSymbol = 'X';
            computerSymbol = 'O';
        } else {
            isHumanTurn = false;
            computerSymbol = 'X';
            playerSymbol = 'O';
        }

        System.out.println((isHumanTurn ? player : computer) + " starts first!");
        System.out.println(player + " = " + playerSymbol);
        System.out.println(computer + " = " + computerSymbol);
    }

    /*
     * UC3–UC6: Player move
     */
    static void playerMove() {

        int slot = getUserInput();
        int row = getRowFromSlot(slot);
        int col = getColFromSlot(slot);

        if (isValidMove(slot, row, col)) {
            placeMove(row, col, playerSymbol);
        } else {
            System.out.println("Invalid move. Try again.");
            playerMove();
        }
    }

    /*
     * UC3: Input
     */
    static int getUserInput() {
        System.out.print(player + " (" + playerSymbol + "), enter slot (1-9): ");
        return scanner.nextInt();
    }

    /*
     * UC4: Slot mapping
     */
    static int getRowFromSlot(int slot) {
        return (slot - 1) / 3;
    }

    static int getColFromSlot(int slot) {
        return (slot - 1) % 3;
    }

    /*
     * UC5: Validation
     */
    static boolean isValidMove(int slot, int row, int col) {

        if (slot < 1 || slot > 9) return false;

        if (board[row][col] != '-') return false;

        return true;
    }

    /*
     * UC6: Place move
     */
    static void placeMove(int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    /*
     * UC7: Computer move
     */
    static void computerMove() {

        int slot, row, col;

        while (true) {
            slot = random.nextInt(9) + 1;

            row = getRowFromSlot(slot);
            col = getColFromSlot(slot);

            if (isValidMove(slot, row, col)) {
                System.out.println("Computer chooses slot: " + slot);
                placeMove(row, col, computerSymbol);
                break;
            }
        }
    }

    /*
     * UC9: Check Winning Condition
     */
    static boolean checkWin() {

        char symbol = isHumanTurn ? playerSymbol : computerSymbol;

        // Rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol &&
                    board[i][1] == symbol &&
                    board[i][2] == symbol) {

                System.out.println((isHumanTurn ? player : computer) + " wins!");
                return true;
            }
        }

        // Columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == symbol &&
                    board[1][i] == symbol &&
                    board[2][i] == symbol) {

                System.out.println((isHumanTurn ? player : computer) + " wins!");
                return true;
            }
        }

        // Diagonal 1
        if (board[0][0] == symbol &&
                board[1][1] == symbol &&
                board[2][2] == symbol) {

            System.out.println((isHumanTurn ? player : computer) + " wins!");
            return true;
        }

        // Diagonal 2
        if (board[0][2] == symbol &&
                board[1][1] == symbol &&
                board[2][0] == symbol) {

            System.out.println((isHumanTurn ? player : computer) + " wins!");
            return true;
        }

        return false;
    }

    /*
     * UC10 (stub for now)
     */
    static boolean checkDraw() {
        return false;
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