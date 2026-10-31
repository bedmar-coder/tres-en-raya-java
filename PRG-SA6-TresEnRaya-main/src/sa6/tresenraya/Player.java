/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sa6.tresenraya;

/**
 * A player, identified by the piece (O or X) they play with.
 *
 * @author batoi
 */
public class Player {

    private CellState ownPiece;

    /**
     * Creates a player.
     *
     * @param ownPiece the piece this player places on the board
     */
    public Player(CellState ownPiece) {
        this.ownPiece = ownPiece;
    }

    /**
     * Asks the player for a free cell and places their piece there.
     *
     * @param board the board where the piece is placed
     */
    public void placePiece(Board board) {
        Coordinate coor;
        do {
            coor = getCoordinate(board);
            if (board.isOccupied(coor)) {
                System.out.println("That position is already taken, choose another one");
            }
        } while (board.isOccupied(coor));
        board.placePiece(coor, ownPiece);

    }

    /**
     * Keeps asking for a cell until it's inside the board.
     *
     * @param board the board used to check the coordinate
     * @return the chosen coordinate
     */
    private Coordinate getCoordinate(Board board) {
        Coordinate chosenCoor = null;
        String choice;
        do {
            choice = IOManager.readLetterDashNumber("\nPlayer with " + ownPiece);
            chosenCoor = new Coordinate(IOManager.letterToNumber(choice.substring(0, 1)),
                    (Integer.parseInt(choice.substring(2)) - 1));

        } while (!board.isValidCoordinate(chosenCoor));
        return chosenCoor;
    }

    /**
     * Prints the winning message for this player.
     */
    public void announceVictory() {
        IOManager.showMessage("Player " + ownPiece + " is the winner!");
    }

}
