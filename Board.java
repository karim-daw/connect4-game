public class Board {

    private String[][] board;
    private static int rows;
    private static int columns;
    private boolean win;

    public Board(int rows, int columns) {
        Board.rows = rows;
        Board.columns = columns;
        board = new String[rows][columns];
    }

    public void placeToken(int row, int column, String token) {
        board[row][column] = token;
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
        System.out.println(getPrintableColumnFooters());
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

}
