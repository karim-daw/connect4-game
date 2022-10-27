public class Move {

    private int column;
    private boolean placed = false;

    public Move(int column) {
        this.column = column;
    }

    public int getColumn() {
        return column;
    }

    public boolean isAvailable() {
        if (!placed) {
            return true;
        }
        return false;
    }

    public boolean isValid() {
        return true;
    }

}
