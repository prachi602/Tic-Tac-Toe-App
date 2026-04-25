import java.util.Random;
import java.util.Scanner;

public class main {

    // Board
    static char[][] board = new char[3][3];

    // Players
    static String player1 = "Player 1";
    static String computer = "Computer";

    // Game state
    static String currentPlayer;
    static char player1Symbol;
    static char computerSymbol;

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {

        initializeBoard();   // UC1
        tossAndAssign();     // UC2
        printBoard();

        // One round: Player → Computer
        playerMove();// Human move

        printBoard();

        computerMove();      // UC7
        printBoard();
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
            currentPlayer = player1;
            player1Symbol = 'X';
            computerSymbol = 'O';
        } else {
            currentPlayer = computer;
            computerSymbol = 'X';
            player1Symbol = 'O';
        }

        System.out.println("Toss Result:");
        System.out.println(currentPlayer + " starts first!");
        System.out.println(player1 + " = " + player1Symbol);
        System.out.println(computer + " = " + computerSymbol);
    }

    /*
     * UC3 + UC4 + UC5 + UC6: Player Move
     */
    static void playerMove() {

        int slot = getUserInput();

        int row = getRowFromSlot(slot);
        int col = getColFromSlot(slot);
        System.out.println("Placement for the player's move:");
        System.out.println("Row:"+(row+1));
        System.out.println("Coloumn:"+(col+1));



        if (isValidMove(slot, row, col)) {
            placeMove(row, col, player1Symbol);
        } else {
            System.out.println("Invalid move. Try again.");
            playerMove(); // retry
        }
    }

    /*
     * UC3: Input
     */
    static int getUserInput() {

        System.out.print(player1 + " (" + player1Symbol + "), enter slot (1-9): ");
        return scanner.nextInt();
    }

    /*
     * UC4: Slot → Row
     */
    static int getRowFromSlot(int slot) {
        return (slot - 1) / 3;
    }

    /*
     * UC4: Slot → Column
     */
    static int getColFromSlot(int slot) {
        return (slot - 1) % 3;
    }

    /*
     * UC5: Validate
     */
    static boolean isValidMove(int slot, int row, int col) {

        if (slot < 1 || slot > 9) {
            return false;
        }

        if (board[row][col] != '-') {
            return false;
        }

        return true;
    }

    /*
     * UC6: Place move
     */
    static void placeMove(int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    /*
     * UC7: Computer Move
     */
    static void computerMove() {

        int slot, row, col;

        while (true) {

            slot = random.nextInt(9) + 1;

            row = getRowFromSlot(slot);
            col = getColFromSlot(slot);
            System.out.println("Placement for the computer's move:");


            if (isValidMove(slot, row, col)) {

                System.out.println("Computer chooses slot: " + slot);
                System.out.println("Row:"+(row+1));
                System.out.println("Coloumn:"+(col+1));

                placeMove(row, col, computerSymbol);
                break;
            }
        }
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