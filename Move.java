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

}
