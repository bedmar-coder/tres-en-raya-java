/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sa6.tresenraya;

/**
 * The game board: a square grid of cells.
 *
 * @author batoi
 */
public class Board {

    private int dimension;
    private CellState[][] cells;
    private String separator = "|";
    private char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
        'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    /**
     * Creates an empty board.
     *
     * @param dimension the number of rows and columns
     */
    public Board(int dimension) {
        this.dimension = dimension;
        this.cells = new CellState[dimension][dimension];
        clear();
    }

    /**
     * Sets every cell to empty.
     */
    public void clear() {
        for (int i = 0; i < this.cells.length; i++) {
            for (int j = 0; j < this.cells[i].length; j++) {
                this.cells[i][j] = CellState.EMPTY;
            }
        }
    }

    /**
     * Checks whether a coordinate is inside the board.
     *
     * @param coordinate the coordinate to check
     * @return true if it fits inside the board
     */
    public boolean isValidCoordinate(Coordinate coordinate) {
        return coordinate.isValid(dimension);
    }

    /**
     * Prints the board with its column numbers and row letters.
     */
    public void show() {
        System.out.print(separator + " " + separator);
        for (int i = 0; i < dimension; i++) {
            System.out.print((i + 1) + separator);
        }
        for (int i = 0; i < dimension; i++) {
            System.out.print("\n" + separator + letters[i] + separator);
            for (CellState elem : this.cells[i]) {
                System.out.print(elem + separator);

            }

        }
    }

    /**
     * Places a piece in the given cell.
     *
     * @param coordinate the cell where the piece goes
     * @param pieceType the piece to place
     */
    public void placePiece(Coordinate coordinate, CellState pieceType) {
        this.cells[coordinate.getRow()][coordinate.getColumn()] = pieceType;
    }

    /**
     * Checks whether a cell already has a piece.
     *
     * @param coordinate the cell to check
     * @return true if the cell isn't empty
     */
    public boolean isOccupied(Coordinate coordinate) {
        return !this.cells[coordinate.getRow()][coordinate.getColumn()].equals(CellState.EMPTY);
    }

    /**
     * Checks whether there are no empty cells left.
     *
     * @return true if the board is full
     */
    public boolean isFull() {

        for (int i = 0; i < this.cells.length; i++) {
            for (int j = 0; j < this.cells[i].length; j++) {
                Coordinate coor = new Coordinate(i + 1, j + 1);
                if (!isOccupied(coor)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Checks whether either player has completed a line.
     *
     * @return true if there's a winning line of O or X
     */
    public boolean hasThreeInARow() {
        if (hasThreeInARow(CellState.PIECE_O) || hasThreeInARow(CellState.PIECE_X)) {
            return true;
        }
        return false;

    }

    /**
     * Checks whether the given piece has completed a row, column or diagonal.
     *
     * @param pieceType the piece to check
     * @return true if that piece has a winning line
     */
    private boolean hasThreeInARow(CellState pieceType) {
        if (hasThreeInColumn(pieceType) || hasThreeInDiagonal(pieceType)
                || hasThreeInRow(pieceType) || hasThreeInOtherDiagonal(pieceType)) {
            return true;
        }
        return false;

    }

    /**
     * Checks whether any row is completely filled with the given piece.
     *
     * @param pieceType the piece to check
     * @return true if a full row is found
     */
    private boolean hasThreeInRow(CellState pieceType) {
        for (int i = 0; i < this.cells.length; i++) {
            int count = 0;
            for (int j = 0; j < this.cells[i].length; j++) {
                if (this.cells[i][j].equals(pieceType)) {
                    count++;
                    if (count == this.dimension) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Checks whether any column is completely filled with the given piece.
     *
     * @param pieceType the piece to check
     * @return true if a full column is found
     */
    private boolean hasThreeInColumn(CellState pieceType) {
        for (int i = 0; i < this.cells.length; i++) {
            int count = 0;
            for (int j = 0; j < this.cells.length; j++) {
                if (this.cells[j][i].equals(pieceType)) {
                    count++;
                    if (count == this.dimension) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Checks the main diagonal (top-left to bottom-right).
     *
     * @param pieceType the piece to check
     * @return true if the whole diagonal has that piece
     */
    private boolean hasThreeInDiagonal(CellState pieceType) {
        int auxColumn = 0;
        for (int i = 0; i < this.dimension; i++) {
            if (!this.cells[i][auxColumn].equals(pieceType)) {
                return false;
            }
            auxColumn++;
        }
        return true;
    }

    /**
     * Checks the other diagonal (bottom-left to top-right).
     *
     * @param pieceType the piece to check
     * @return true if the whole diagonal has that piece
     */
    private boolean hasThreeInOtherDiagonal(CellState pieceType) {
        int auxColumn = 0;
        for (int i = (this.dimension - 1); i >= 0; i--) {
            if (!this.cells[i][auxColumn].equals(pieceType)) {
                return false;
            }
        }
        return true;

    }

}
