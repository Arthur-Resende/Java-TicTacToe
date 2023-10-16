public class TicTacToe {

    boolean turnO = true;
    Board board = new Board();

    /**
     * Prints the winning player of the game. If either playerX or playerO won.
     */
    private void declareWinner() {
        if (board.winner() == board.playerX) {
            System.out.println("player X won the game!");
        }
        else if (board.winner() == board.playerO) {
            System.out.println("player O won the game!");
        }
    }

    /**
     * Starts the game and keeps the loop while there is no winner, gets user input,
     * updates the board based on the user input, changes the turn and then prints the board.
     * When someone wins, declares the winner.
     */
    public void gameLoop() {
        while(!gameHasWinner()) {
            int[] cords = getCords();
            updateBoard(cords);
            changeTurn();
            board.printBoard();
        }
        declareWinner();
    }

    /**
     * Updates the state of the board based on the cords provided and the current turn.
     * If its the playerX's turn, it'll add an 'X' to the coordinates, otherwise, adds an 'O.'
     * @param cords - An int array, determines the coordinates to be updated.
     */
    private void updateBoard(int[] cords) {
        if (turnO) {
            board.addO(cords[0], cords[1]);
        } else {
            board.addX(cords[0], cords[1]);
        }
    }

    /**
     * Toggles the turn between playerX and playerO. If it's currently playerX's turn, 
     * it changes the turn to playerO, and vice versa.
     */
    private void changeTurn() {
        turnO = !turnO;
    }

    /**
     * Checks if there is a winner in the game.
     * Returns true if there is a winner (playerX or playerO), otherwise false.
     */
    private boolean gameHasWinner() {
        int noWinner = 0;
        return board.winner() != noWinner;
    }

    /**
     * Obtains user input for row and column coordinates and ensures the selected tile is legal.
     * Keeps prompting the user until valid coordinates are provided.
     * 
     * @return An int array containing the validated row and column coordinates.
     */
    private int[] getCords() {
        Input input = new Input();
        int x = -1;
        int y = -1;

        while (!board.tileIsLegal(x, y)) {
            y = input.getInput("row: ");
            x = input.getInput("column: ");
            if (!board.tileIsLegal(x, y)) {
                System.out.print("This tile has already been selected, please choose another one.\n");
            }
        }
        return new int[] {x, y};
    }
}