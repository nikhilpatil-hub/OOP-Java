import java.util.Scanner;

public class OthelloGame {

    private int[][] board;
    private static final int PLAYER1 = 1;
    private static final int PLAYER2 = 2;

    public OthelloGame() {
        board = new int[8][8];
     
        board[3][3] = PLAYER1;
        board[3][4] = PLAYER2;
        board[4][3] = PLAYER2;
        board[4][4] = PLAYER1;
    }

    public void printBoard() {
        System.out.println("\n   0 1 2 3 4 5 6 7");
        for (int i = 0; i < 8; i++) {
            System.out.print(i + "  ");
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == PLAYER1) System.out.print("B ");
                else if (board[i][j] == PLAYER2) System.out.print("W ");
                else System.out.print(". ");
            }
            System.out.println();
        }
    }

    public boolean move(int symbol, int x, int y) {
        if (x < 0 || y < 0 || x >= 8 || y >= 8 || board[x][y] != 0) {
            return false;
        }

        int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
        int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};

        boolean validMove = false;

        for (int d = 0; d < 8; d++) {
            int i = x + dx[d];
            int j = y + dy[d];
            int count = 0;

            while (i >= 0 && j >= 0 && i < 8 && j < 8 && board[i][j] != 0 && board[i][j] != symbol) {
                i += dx[d];
                j += dy[d];
                count++;
            }

            if (count > 0 && i >= 0 && j >= 0 && i < 8 && j < 8 && board[i][j] == symbol) {
                i = x + dx[d];
                j = y + dy[d];
                while (board[i][j] != symbol) {
                    board[i][j] = symbol;
                    i += dx[d];
                    j += dy[d];
                }
                validMove = true;
            }
        }

        if (validMove) {
            board[x][y] = symbol;
        }

        return validMove;
    }

    public void countWinner() {
        int p1 = 0, p2 = 0;
        for (int[] row : board) {
            for (int cell : row) {
                if (cell == PLAYER1) p1++;
                else if (cell == PLAYER2) p2++;
            }
        }

        System.out.println("\n Final Score:");
        System.out.println("Player 1 (Black - B): " + p1);
        System.out.println("Player 2 (White - W): " + p2);

        if (p1 > p2) System.out.println(" Player 1 (Black - B) Wins!");
        else if (p2 > p1) System.out.println(" Player 2 (White - W) Wins!");
        else System.out.println(" It's a Draw!");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        OthelloGame game = new OthelloGame();

        System.out.println(" Welcome to Othello Game (Console Version)");
        System.out.println("How many total moves you want to play?");
        System.out.print(" Enter number of valid moves to play: ");
        int totalMoves = sc.nextInt();

        boolean isPlayer1Turn = true;

        while (totalMoves > 0) {
            game.printBoard();

            System.out.println("\n It's " + (isPlayer1Turn ? "Player 1 (Black - B)" : "Player 2 (White - W)") + "'s turn.");
            System.out.print(" Enter row (0-7): ");
            int x = sc.nextInt();
            System.out.print(" Enter column (0-7): ");
            int y = sc.nextInt();

            boolean valid = game.move(isPlayer1Turn ? PLAYER1 : PLAYER2, x, y);
            if (valid) {
                isPlayer1Turn = !isPlayer1Turn;
                totalMoves--;
            } else {
                System.out.println("Invalid move! Either cell is occupied or no disks to flip. Try again.");
            }
        }

        System.out.println("\n Game Over!");
        game.printBoard();
        game.countWinner();
    }
}
