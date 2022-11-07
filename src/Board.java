package src;

import java.util.ArrayList;

public class Board {

    // Fields

    private Tile[][] board;
    private static int rows;
    private static int columns;
    private boolean win = false;
    private boolean draw = false;

    // Constructor

    public Board(int rows, int columns) {
        Board.rows = rows;
        Board.columns = columns;
        board = new Tile[rows][columns];
        setStartingBoard();
    }

    // get rows
    public static int getRows() {
        return rows;
    }

    // get columns
    public static int getColumns() {
        return columns;
    }

    /**
     * @return smallest board dimension (row or column)
     */
    public static int getSmallestBoardDimension() {
        if (Board.rows < Board.columns) {
            return Board.rows;
        } else {
            return Board.columns;
        }
    }

    // get board of tiles
    public Tile[][] getBoard() {
        return board;
    }

    // getter for win boolean
    public boolean hasWin() {
        return win;
    }

    // check for win boolean
    public void isWin() {
        win = true;
    }

    // getter for draw
    public boolean hasDraw() {
        return draw;
    }

    // sets draw to true if column is full and returns draw
    public boolean isDraw() {
        if (getAvailableColumns().size() == 0) {
            draw = true;
        }
        return draw;
    }

    /**
     * creates a string representation of board of tiles
     * 
     * @return board as a String
     */
    public String getPrintableBoard() {
        String boardString = "";
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                boardString += board[i][j].getToken();
            }
            boardString += "|";
            boardString += "\n";
        }
        boardString += getPrintableColumnFooters();
        return boardString;
    }

    /**
     * sets the starting board with no tokens
     */
    private void setStartingBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = new Tile(i, j);

                // add empty token
                board[i][j].setToken("|   ");
            }
        }
    }

    /**
     * returns string represetnation of column numbers in footer of board
     * 
     * @return string of footer numbers
     */
    private String getPrintableColumnFooters() {
        String footer = "";
        String space = "   ";
        String halfSpace = "  ";
        String column;

        // add first half space
        footer += halfSpace;

        for (int i = 0; i < columns; i++) {

            // for readable column numbers
            column = String.valueOf(i + 1);
            footer += column;
            footer += space;
        }
        footer += halfSpace;
        return footer;
    }

    /**
     * loops through columns and if column is not full
     * addes column number to a an ArrayList and returns it
     * 
     * @return availableColumns as an ArrayList
     */
    public ArrayList<Integer> getAvailableColumns() {

        ArrayList<Integer> availableColumns = new ArrayList<Integer>();

        for (int col = columns; col > 0; col--) {
            if (!Move.isColumnFull(col, board)) {
                availableColumns.add(col);
            }
        }
        return availableColumns;
    }

    /**
     * places a token on the board from the currentPlayers move
     * 
     * @param player
     */
    public void placeToken(Player player) {

        // get move from player
        Move move = player.getMove();

        // get col number
        int col = move.getColumn();

        // check if move is valid, in bounds and if chosen column is not full
        if (move.isValidMove() && move.isMoveInBounds()) {
            if (!Move.isColumnFull(col, board)) {

                // get player token
                String playerToken = player.getToken();

                for (int i = Board.rows - 1; i >= 0; i--) {

                    // get tile of board
                    Tile tile = board[i][col - 1];

                    // check if tile is available
                    if (tile.isAvailable()) {

                        tile.setToken(playerToken);
                        tile.setToOccupied();

                        // put tile on board
                        board[i][col - 1] = tile;
                        break;
                    }
                }
                // else if column is full and the player is a human, display a warning
                // to the human indicating that they need to choose another column
            } else if (Move.isColumnFull(col, board) && player instanceof HumanPlayer) {
                Display.displayColumnFullWarning(col);
            }
            // if the move is not valid show invalid move warning
        } else if (!move.isValidMove()) {
            Display.displayInValidMoveWarning();
            // if move is out of bounds show move out of bounds warning
        } else if (!move.isMoveInBounds()) {
            Display.displayMoveOutOfBoundsWarning(col);
        }
    }

}
