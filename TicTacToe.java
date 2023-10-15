import java.util.Scanner;

public class TicTacToe {

    static boolean turnO = true;
    static Board board = new Board();

    public static void main(String[] args) {
        while(!isWon()) {
            gameCycle();
        }
    }

    private static void gameCycle() {
        int[] cords = getCords();

        if (turnO) {
            System.out.println();
            board.addO(cords[0], cords[1]);
            board.printBoard();
            if (isWon()) {
                System.out.println("O won the game");
            }
            turnO = false;
        } else {
            System.out.println();
            board.addX(cords[0], cords[1]);
            board.printBoard();
            if (isWon()) {
                System.out.println("X won the game");
            }
            turnO = true;
        }
    }

    private static boolean isWon() {
        return (board.checkRows() || board.checkColumns() || board.checkDiagonals());
    }

    private static int[] getCords() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Add x cord: ");
        int x = scanner.nextInt();

        System.out.print("Add y cord: ");
        int y = scanner.nextInt();

        return new int[] {x, y};
    }
}