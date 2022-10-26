public class Board {

    private char[][] board;
    private int row;
    private int col;

    public Board(int row, int col) {
        this.row = row;
        this.col = col;
        board = new char[row][col];
    }

    private void printBoard() {
        for (int i = 0; i < board.length; i++)

        {
            for (int j = 0; j < board[i].length; j++) { // removed -1 to print full board
                if (board[i][j] == 'r') { // switched iterators
                    System.out.print("| r ");
                } else if (board[i][j] == 'y') { // switched iterators
                    System.out.print("| y ");
                } else {
                    System.out.print("|   ");
                }
            }
            System.out.println("|");
        }
        System.out.println("  1   2   3   4   5   6   7");
    }

}
