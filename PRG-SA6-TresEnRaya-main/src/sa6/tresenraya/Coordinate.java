/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sa6.tresenraya;

/**
 * A position on the board, made of a row and a column.
 *
 * @author batoi
 */
public class Coordinate {

    private int row;
    private int column;

    /**
     * Creates a coordinate.
     *
     * @param row the row index
     * @param column the column index
     */
    public Coordinate(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    /**
     * Checks whether this coordinate fits inside a board of the given size.
     *
     * @param dimension the size of the board
     * @return true if both the row and the column are smaller than the dimension
     */
    public boolean isValid(int dimension) {
        return row < dimension && column < dimension;
    }

}
