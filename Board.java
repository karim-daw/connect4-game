public class Board {

    private char[][] board;
    private static int rows;
    private static int columns;

    public Board(int rows, int columns) {
        Board.rows = rows;
        Board.columns = columns;
        board = new char[rows][columns];
    }

    public static int getRows() {
        return rows;
    }

    public static int getColumns() {
        return columns;
    }

    public void printBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {

                if (board[i][j] == 'r') {
                    System.out.print("| r ");
                } else if (board[i][j] == 'y') {
                    System.out.print("| y ");
                } else {
                    System.out.print("|   ");
                }
            }
            System.out.println("|");
        }
        System.out.println(getColumnFooters());
    }

    public String getColumnFooters() {
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

}
