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
            System.out.println("Try again, this time, enter an integer");
            return false;
        } else {
            return true;
        }
    }

    public boolean isMoveInBounds() {
        if (column > Board.getColumns() || column < 1) {
            System.out.println("this is the input colum: " + column);
            System.out.println("this is the column amount: " + Board.getRows());
            System.out.println("Try again, chosen column is out of bounds ");
            return false;
        } else {
            return true;
        }
    }

}
