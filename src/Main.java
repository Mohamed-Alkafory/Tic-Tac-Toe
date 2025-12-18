import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int countX = 0, countY = 0;
        char ans = ' ';
        do {
            char[][] board = new char[3][3];
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < 3; col++) {
                    board[row][col] = ' ';
                }
            }
            char player = 'X';
            boolean gameOver = false;
            Scanner in = new Scanner(System.in);
            while (!gameOver) {
                printBoard(board);
                System.out.println("Player " + player + " enter: ");
                int row = in.nextInt();
                int col = in.nextInt();
                if (board[row][col] == ' ') {
                    board[row][col] = player;
                    gameOver = CheckWinner(board, player);
                    if (gameOver) {
                        System.out.println("Player( " + player + " )has won:  ");
                        if (player == 'X') countX++;
                            else countY++;
                    } else {
                        player = (player == 'X') ? 'O' : 'X';
                    }
                } else {
                    System.out.println("Invalid move.try again");
                }
            }
            printBoard(board);

            System.out.println("Do you Want to play again!(y|n)");
            ans = in.next().charAt(0);
        } while (ans == 'Y' || ans == 'y');

        System.out.println("Game over!");
        System.out.println("Player X won " + countX + " time(s).");
        System.out.println("Player O won " + countY + " time(s).");
    }

    public static boolean CheckWinner(char[][] board, char player) {
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }
        }

        for (int col = 0; col < board.length; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }

    public static void printBoard(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }
    }
}