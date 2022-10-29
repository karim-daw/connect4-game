public class Move {

    private int column;

    public Move(int column) {
        this.column = column;
    }

    public int getColumn() {
        return column;
    }

    public boolean isValidMove() {
        if (column == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isMoveInBounds() {
        if (column > Board.getColumns() || column < 1) {
            return false;
        } else {
            return true;
        }
    }

    // TODO maybe put checkCOlumn is full here
    public static boolean TESTisColumnFull(int col, Tile[][] board) {

        int counter = 0;
        boolean isfull = false;

        for (int i = Board.getRows() - 1; i >= 0; i--) {
            Tile tile = board[i][col - 1];

            // check if position is occupied
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
