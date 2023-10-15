/*
 * todo
 * 
 * add checker if value is bigger than 2
 * add checker if value is int
 * add checker for who won the game
 */
public class Board {

    int[] tiles = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    private final static int playerX = 1;
    private final static int playerO = 4;
    final int xWinValue = playerX * 3;
    final int oWinValue = playerO * 3;
    

    protected void addO(int x, int y) {
        int tileIndex = x + (3 * y);
        tiles[tileIndex] = playerO;
    }

    protected void addX(int x, int y) {
        int tileIndex = x + (3 * y);
        tiles[tileIndex] = playerX;
    }

    protected void printBoard() {
        int rowLength = 3;
        String emptySquare = "[ ]";
        String xSquare = "[X]";
        String oSquare = "[O]";

        for (int i=0; i<tiles.length; i++) {
            if (i % rowLength == 0) {
                System.out.print("\n");
            }

            if (tiles[i] == 0) {
                System.out.print(emptySquare);
                continue;
            } else if (tiles[i] == playerO) {
                System.out.print(oSquare);
                continue;
            }

            System.out.print(xSquare);
        }
        System.out.println();
    }
    
    protected int checkHorizontalWinner() {
        final int rowLength = 3;
        final int xWinValue = playerX * 3;
        final int oWinValue = playerO * 3;

        for (int i=0; i<rowLength; i++) {
            int rowValue = tiles[i] + tiles[i+1] + tiles[i+2];

            if (rowValue == xWinValue) {
                return playerX;
            }

            if (rowValue == oWinValue) {
                return playerO;
            }
        }
        
        return 0;

    }

    protected int checkVerticalWinner() {
        final int columnLength = 3;
        final int xWinValue = playerX * 3;
        final int oWinValue = playerO * 3;

        for (int i=0; i<columnLength; i++) {
            int columnValue = tiles[i] + tiles[i+3] + tiles[i+6];

            if (columnValue == xWinValue) {
                return playerX;
            }

            if (columnValue == oWinValue) {
                return playerO;
            }
        }

        return 0;

    }

    protected int checkDiagonalWinner() {
        final int[] diagonals = {tiles[0] + tiles[4] + tiles[8], tiles[2] + tiles[4] + tiles[6]};
        final int xWinValue = playerX * 3;
        final int oWinValue = playerO * 3;

        for (int i=0; i<diagonals.length; i++) {
            int diagonalValue = diagonals[i];

            if (diagonalValue == xWinValue) {
                return playerX;
            }

            if (diagonalValue == oWinValue) {
                return playerO;
            }
        }
        
        return 0;

    }

}