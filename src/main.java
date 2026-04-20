public class main {

    // 3x3 Tic-Tac-Toe board
    static char[][] board = new char[3][3];

    /*
     * UC1: Display Empty Tic-Tac-Toe Board
     * Goal: Initialize and display an empty board*/
    public static void main(String[] args) {
        initializeBoard();
        printBoard();
    }

    /*
     * Initializes the board with '-' (empty cells)
     */
    static void initializeBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = '-';
            }
        }
    }

    /*
     * Prints the board in formatted structure
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