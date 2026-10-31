/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package sa6.tresenraya;

/**
 * The possible states of a board cell: an O piece, an X piece or empty.
 *
 * @author batoi
 */
public enum CellState {
    PIECE_O,
    PIECE_X,
    EMPTY;

    /**
     * Returns the symbol that is drawn on the board for this state.
     *
     * @return "0", "X" or a blank space
     */
    public String toString() {
        return switch (this) {
            case PIECE_O -> "0";
            case PIECE_X -> "X";
            case EMPTY -> " ";
        };
    }

}
