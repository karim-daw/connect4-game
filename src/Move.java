public class Move {

    // Fields
    private int column;

    // Constructor

    public Move(int column) {
        this.column = column;
    }

    public int getColumn() {
        return column;
    }

    // Methods

    /**
     * checks if move is valid i.e if -1 was received from InputReader
     * 
     * @return boolean
     */
    public boolean isValidMove() {
        if (column == -1) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * checks if move is in bounds, i.e >1 and < column number
     * 
     * @return boolean
     */
    public boolean isMoveInBounds() {
        if (column > Board.getColumns() || column < 1) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * checks if input column is full on baord
     * 
     * @param col
     * @param board
     * @return boolean indicated if column is full
     */
    public static boolean isColumnFull(int col, Tile[][] board) {

        int counter = 0;
        boolean isfull = false;

        for (int i = Board.getRows() - 1; i >= 0; i--) {
            Tile tile = board[i][col - 1];

            // if tile is occupied, increment counter
            // check if counter is equal to rowCount
            // if it is, that means the column is full
            if (!tile.isAvailable()) {
                counter++;
                if (counter == Board.getRows()) {
                    isfull = true;
                }
            }
        }
        return isfull;
    }

}
