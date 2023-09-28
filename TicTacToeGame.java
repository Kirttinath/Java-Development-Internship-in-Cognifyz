import java.util.Scanner;

public class TicTacToeGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            char[][] board = initializeBoard();
            char currentPlayer = 'X';
            boolean gameWon = false;
            int moves = 0;

            System.out.println("Tic-Tac-Toe Game");

            while (!gameWon && moves < 9) {
                displayBoard(board);
                int[] move = getPlayerMove(scanner, currentPlayer);
                int row = move[0];
                int col = move[1];

                if (isValidMove(board, row, col)) {
                    board[row][col] = currentPlayer;
                    gameWon = checkForWin(board, currentPlayer);
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                    moves++;
                } else {
                    System.out.println("Invalid move. Try again.");
                }
            }

            displayBoard(board);

            if (gameWon) {
                System.out.println("Player " + currentPlayer + " wins!");
            } else {
                System.out.println("It's a draw!");
            }

            System.out.print("Play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            playAgain = playAgainInput.equals("yes");
        }

        System.out.println("Thanks for playing Tic-Tac-Toe!");
        scanner.close();
    }

    private static char[][] initializeBoard() {
        char[][] board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
        return board;
    }

    private static void displayBoard(char[][] board) {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    private static int[] getPlayerMove(Scanner scanner, char currentPlayer) {
        int[] move = new int[2];
        System.out.print("Player " + currentPlayer + ", enter your move (row and column): ");
        move[0] = scanner.nextInt();
        move[1] = scanner.nextInt();
        return move;
    }

    private static boolean isValidMove(char[][] board, int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ';
    }

    private static boolean checkForWin(char[][] board, char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true; // Check rows
            }
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true; // Check columns
            }
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true; // Check diagonal (top-left to bottom-right)
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true; // Check diagonal (top-right to bottom-left)
        }
        return false;
    }
}
