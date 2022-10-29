public class Board {

    private Tile[][] board;
    private static int rows;
    private static int columns;
    private boolean win = false;

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

    private boolean isColumnFull(int col) {

        int counter = 0;
        boolean full = false;

        for (int i = Board.rows - 1; i >= 0; i--) {
            Tile tile = board[i][col - 1];

            // check if position is occupied
            if (!tile.isAvailable()) {
                counter++;
                if (counter == rows) {
                    full = true;
                    System.out.println("Chosen column is full, pick another\n");
                }
            }
        }
        return full;
    }

    public void placeToken(Player player) {

        // get move from player and check if valid
        Move move = player.getMove();
        if (move.isValidMove() && move.isMoveInBounds()) {

            // get position
            int col = move.getColumn();
            if (!isColumnFull(col)) {

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
            }
        }
    }

}
