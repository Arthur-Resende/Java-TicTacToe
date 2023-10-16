public class Board {

    int[] tiles = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    final int playerX = 1;
    final int playerO = 4;
    
    /**
     * Add a player O's symbol to the board at the specified coordinates.
     * 
     * @param x The x-coordinate.
     * @param y The y-coordinate.
     */
    protected void addO(int x, int y) {
        int tileIndex = x + (3 * y);
        tiles[tileIndex] = playerO;
    }

    /**
     * Add a player X's symbol to the board at the specified coordinates.
     * 
     * @param x
     * @param y
     */
    protected void addX(int x, int y) {
        int tileIndex = x + (3 * y);
        tiles[tileIndex] = playerX;
    }

    /**
     * Checks if the tile at the specified coordinates is empty.
     * 
     * @param x
     * @param y
     * @return True if the tile is empty (legal), false otherwise.
     */
    protected boolean tileIsLegal(int x, int y) {
        int index = x + (3 * y);
        try {
            return tiles[index] == 0;
        } catch (ArrayIndexOutOfBoundsException error) {
            return false;
        }
    }

    /**
     * Prints current state of the game to the console.
     */
    protected void printBoard() {
        final int rowLength = 3;
        final int empty = 0;
        final String emptySquare = "[ ]";
        final String xSquare = "[X]";
        final String oSquare = "[O]";

        for (int i=0; i<tiles.length; i++) {

            if (i > 0 && i % rowLength == 0) {
                System.out.print("\n");
            }

            if (tiles[i] == empty) {
                System.out.print(emptySquare);
            }
            else if (tiles[i] == playerO) {
                System.out.print(oSquare);
            }
            else if (tiles[i] == playerX) {
                System.out.print(xSquare);
            }
        }
        System.out.print("\n");
    }
    
    /**
     * Checks if a player has symbols in all specified tiles, indicating a win in the game.
     * 
     * @param tiles An array representing the tiles to be checked for a winning combination.
     * @return 4 if the symbol X is present in all specified tiles, 1 if the symbol O is present, or 0 if neither player has won.
     */
    private int tilesWinner(int[] tiles) {
        int tilesValue = 0;
        final int xWinValue = playerX * tiles.length;
        final int oWinValue = playerO * tiles.length;

        for (int i=0; i<tiles.length; i++) {
            tilesValue += tiles[i];
        }

        if (tilesValue == xWinValue) {
            return playerX;
        }
        else if (tilesValue == oWinValue) {
            return playerO;
        }
        
        return 0;
    }

    /**
     * Check for a winner in the horizontal row of tiles on the game board.
     * 
     * @return 4 if player X has won the row, 1 if player O has won the row, or 0 if there's no winner in this row.
     */
    private int horizontalWinner() {
        int[] row = {tiles[0], tiles[1], tiles[2]};
        return tilesWinner(row);
    }

    /**
     * Check for a winner in the vertical column of tiles on the game board.
     * 
     * @return 4 if player X has won the column, 1 if player O has won the column, or 0 if there's no winner in this column.
     */
    private int verticalWinner() {
        int[] column = {tiles[0], tiles[3], tiles[6]};
        return tilesWinner(column);
    }

    /**
     * Check for a winner in the main diagonal of tiles on the game board.
     * [x][ ][ ]
     * [ ][x][ ]
     * [ ][ ][x]
     * 
     * @return 4 if player X has won the diagonal, 1 if player O has won the diagonal, or 0 if there's no winner in this diagonal.
     */
    private int diagonalAWinner() {
        int[] diagonalA = {tiles[0], tiles[4], tiles[8]};
        return tilesWinner(diagonalA);
    }
    
    /**
     * Check for a winner in the secondary diagonal of tiles on the game board.
     * [ ][ ][x]
     * [ ][x][ ]
     * [x][ ][ ]
     * 
     * @return 4 if player X has won the diagonal, 1 if player O has won the diagonal, or 0 if there's no winner in this diagonal.
     */
    private int diagonalBWinner() {
        int[] diagonalB = {tiles[2], tiles[4], tiles[6]};
        return tilesWinner(diagonalB);
    }

    /**
     * Check for the game's winner by examining horizontal, vertical, and diagonal lines on the game board.
     * 
     * This method checks for a winning player (X or O) by analyzing the state of the game board in horizontal, vertical,
     * and diagonal directions. If a player has symbols in a winning configuration, they are declared as the winner.
     * If there's no winner, the method returns 0.
     * 
     * @return 4 if player X has won, 1 if player O has won, or 0 if there's no winner.
     */
    protected int winner() {

        final int noWinner = 0;

        if (
            horizontalWinner() == playerX ||
            verticalWinner() == playerX ||
            diagonalAWinner() == playerX ||
            diagonalBWinner() == playerX
        ) {
            return playerX;
        }
        else if (
            horizontalWinner() == playerO ||
            verticalWinner() == playerO ||
            diagonalAWinner() == playerO ||
            diagonalBWinner() == playerO
        ) {
            return playerO;
        }

        return noWinner;
    }

}