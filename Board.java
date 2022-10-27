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

    // public void placeToken(int row, int column, Move move, String token) {
    // Tile tile = this.board[row][column];
    // tile.setToken(token);
    // }

    public void printBoard() {
        System.out.println(getPrintableBoard());
    }

    private String getPrintableBoard() {
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

    public boolean hasWon() {
        return win;
    }

    public void placeToken(Player player) {

        // get position
        int position = player.getMove().getColumn();

        // get player token
        String playerToken = player.getToken();

        for (int i = Board.rows - 1; i >= 0; i--) {

            Tile tile = board[i][position - 1];

            // check if position is occupied
            if (!tile.isAvailable()) {
                // skip
            } else {
                tile.setToken(playerToken);
                tile.setToOccupied();

                // put tile on board
                board[i][position - 1] = tile;
            }
        }

        // boolean placed = false;
        // if (player == 'r') {
        // for (int i = board.length - 1; i >= 0; i--) { // changed this to decrement.
        // if (!placed) {
        // if (board[i][position - 1] == 'y') {
        // // skip
        // } else if (board[i][position - 1] != 'r') {
        // board[i][position - 1] = 'r';
        // // System.out.println((i - 1) + " " + (position - 1));
        // placed = true;
        // }
        // }
        // }
        // } else {
        // for (int i = board.length - 1; i >= 0; i--) {
        // if (!placed) {
        // if (board[i][position - 1] == 'r') {
        // // skip
        // } else if (board[i][position - 1] != 'y') {
        // board[i][position - 1] = 'y';
        // // System.out.println((i - 1) + " " + (position - 1));
        // placed = true;
        // }
        // }
        // }
        // }
    }

}
