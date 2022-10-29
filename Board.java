import java.util.ArrayList;

public class Board {

    private Tile[][] board;
    private static int rows;
    private static int columns;
    private boolean win = false;
    private boolean draw = false;

    public Board(int rows, int columns) {
        Board.rows = rows;
        Board.columns = columns;
        board = new Tile[rows][columns];
        setStartingBoard();
    }

    public static int getRows() {
        return rows;
    }

    public static int getColumns() {
        return columns;
    }

    public Tile[][] getBoard() {
        return board;
    }

    public boolean hasWin() {
        return win;
    }

    public void isWin() {
        win = true;
    }

    public boolean hasDraw() {
        return draw;
    }

    public boolean isDraw() {
        if (getAvailableColumns().size() == 0) {
            draw = true;
        }
        return draw;
    }

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

    private void setStartingBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = new Tile(i, j);
                board[i][j].setToken("|   ");
            }
        }
    }

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

    public boolean isColumnFull(int col) {

        int counter = 0;
        boolean isfull = false;

        for (int i = rows - 1; i >= 0; i--) {
            Tile tile = board[i][col - 1];

            // check if position is occupied
            if (!tile.isAvailable()) {
                counter++;
                if (counter == rows) {
                    isfull = true;

                }
            }
        }
        return isfull;
    }

    public ArrayList<Integer> getAvailableColumns() {

        ArrayList<Integer> availableColumns = new ArrayList<Integer>();

        for (int col = columns; col > 0; col--) {
            if (!Move.TESTisColumnFull(col, board)) {
                availableColumns.add(col);
            }
        }
        return availableColumns;
    }

    public void placeToken(Player player) {

        // get move from player and check if valid
        Move move = player.getMove();

        // get position
        int col = move.getColumn();

        if (move.isValidMove() && move.isMoveInBounds()) {
            if (!Move.TESTisColumnFull(col, board)) {

                // get player token
                String playerToken = player.getToken();

                for (int i = Board.rows - 1; i >= 0; i--) {

                    Tile tile = board[i][col - 1];

                    // check if position is occupied
                    if (!tile.isAvailable()) {

                    } else {
                        tile.setToken(playerToken);
                        tile.setToOccupied();

                        // put tile on board
                        board[i][col - 1] = tile;
                        break;
                    }
                }
            } else if (Move.TESTisColumnFull(col, board) && player instanceof HumanPlayer) {
                Display.displayColumnFullWarning(col);
            }
        } else if (!move.isValidMove()) {
            Display.displayInValidMoveWarning();
        } else if (!move.isMoveInBounds()) {
            Display.displayMoveOutOfBoundsWarning(col);
        }
    }

}
