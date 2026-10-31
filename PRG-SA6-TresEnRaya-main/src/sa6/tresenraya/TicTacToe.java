/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sa6.tresenraya;

/**
 * Main game class: sets up the board and the two players and runs the turns.
 *
 * @author batoi
 */
public class TicTacToe {

    private Board board;
    private Player[] players = new Player[2];
    private final int MIN_DIMENSION = 3;
    private final int MAX_DIMENSION = 8;
    private final String DIMENSION_CONFIRMATION
            = "Do you want to set a new board size? (Default 3)[S/n]";
    private final String DIMENSION_QUESTION = "Enter the board size •[3-8]";
    private final String DRAW = "It's a draw!";
    private static final String PLAY_AGAIN = "Do you want to play again?[s/n]";
    private final static String GOODBYE = "Closing game... See you next time!";

    /**
     * Starts the program and keeps creating new games while the players want to continue.
     *
     * @param args the command line arguments (not used)
     */
    public static void main(String[] args) {
        boolean playAgain = false;
        do {
            TicTacToe ticTacToe = new TicTacToe();
            ticTacToe.play();
            playAgain = IOManager.askForConfirmation(PLAY_AGAIN);
        } while (playAgain);
        System.out.println(GOODBYE);
    }

    /**
     * Creates a new game, asking for the board size, and sets up the two players.
     */
    public TicTacToe() {
        if (IOManager.askForConfirmation(DIMENSION_CONFIRMATION)) {
            int dimension = IOManager.readInteger(DIMENSION_QUESTION);
            this.board = new Board(dimension);

        } else {
            this.board = new Board(MIN_DIMENSION);
        }
        this.players[0] = new Player(CellState.PIECE_O);
        this.players[1] = new Player(CellState.PIECE_X);
    }

    /**
     * Runs the turns until someone wins or the board is full.
     */
    public void play() {
        do {
            board.show();
            this.players[0].placePiece(board);
            if (board.hasThreeInARow()) {
                this.players[0].announceVictory();
                return;
            }
            board.show();
            this.players[1].placePiece(board);
            if (board.hasThreeInARow()) {
                this.players[1].announceVictory();
                return;
            }
        } while (!board.isFull());
        System.out.println(DRAW);
    }

}
