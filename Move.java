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
            System.out.println("Try again, this time enter an integer");
            return false;
        } else {
            return true;
        }
    }

}
