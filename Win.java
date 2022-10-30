
public class Win {

    private boolean hasWon = false;
    private static int winNumber;

    public Win() {

        // get winner number from user
        try {
            getUserWinNumber();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Setting winning number to 4");
            Win.winNumber = 4;
        }
    }

    public boolean checkWin(String token, Tile[][] board) {
        boolean win = false;
        if (isHorizontalWin(token, board)) {
            win = true;
        } else if (isVerticalWin(token, board)) {
            win = true;
        } else if (isDiagonalDownRightBottomWin(token, board)) {
            win = true;
        } else if (isDiagonalDownRightTopWin(token, board)) {
            win = true;
        } else if (isDiagonalUpRightBottomWin(token, board)) {
            win = true;
        } else if (isDiagonalUpRightTopWin(token, board)) {
            win = true;
        } else {
            win = false;
        }
        return win;
    }

    public static void getUserWinNumber() throws Exception {
        Display.displayWelcomeMessage();
        int winNumber = new InputReader().getNumberInput();
        if (winNumber <= Board.getSmallestBoardDimension() && winNumber >= 2)
            Win.winNumber = winNumber;
        else {
            throw new Exception("Win number is either smaller than 2 or too large for Board Dimnesions");
        }
    }

    public static int getWinNumber() {
        return winNumber;
    }

    public boolean isHorizontalWin(String token, Tile[][] board) {

        int count = 0;

        // check horizontal
        for (int i = 0; i < Board.getRows(); i++) {
            for (int j = 0; j < board[i].length; j++) {

                if (board[i][j].getToken() == token) {
                    count = count + 1;

                    if (count >= winNumber) {
                        hasWon = true;
                    }
                } else {
                    count = 0;
                }
            }
            count = 0;
        }
        return hasWon;
    }

    public boolean isVerticalWin(String token, Tile[][] board) {

        int count = 0;

        // check vertical
        for (int i = 0; i < Board.getColumns(); i++) {
            for (int j = 0; j < Board.getRows(); j++) {

                if (board[j][i].getToken() == token) {
                    count = count + 1;

                    if (count >= winNumber) {
                        hasWon = true;
                    }
                } else {
                    count = 0;
                }
            }
            count = 0;
        }
        return hasWon;
    }

    public boolean isDiagonalDownRightBottomWin(String token, Tile[][] board) {

        int count = 0;
        for (int i = 0; i < Board.getRows(); i++) {
            count = 0;
            for (int j = i, delta = 0; j < Board.getRows() && delta < Board.getColumns(); j++, delta++) {
                if (board[j][delta].getToken() == token) {
                    count = count + 1;
                    if (count >= winNumber) {
                        hasWon = true;
                    }
                } else {
                    count = 0;
                }
            }
        }
        return hasWon;
    }

    public boolean isDiagonalDownRightTopWin(String token, Tile[][] board) {

        int count = 0;
        for (int i = 1; i < Board.getRows(); i++) {
            count = 0;
            for (int j = 0, delta = i; j < Board.getRows() && delta < Board.getColumns(); j++, delta++) {
                if (board[j][delta].getToken() == token) {
                    count = count + 1;
                    if (count >= winNumber) {
                        hasWon = true;
                    }
                } else {
                    count = 0;
                }
            }
        }
        return hasWon;
    }

    public boolean isDiagonalUpRightBottomWin(String token, Tile[][] board) {

        int count = 0;
        for (int i = 0; i < Board.getColumns(); i++) {
            count = 0;
            for (int j = Board.getRows() - 1, delta = i; j >= 0 && delta < Board.getColumns(); j--, delta++) {
                if (board[j][delta].getToken() == token) {
                    count = count + 1;
                    if (count >= winNumber) {
                        hasWon = true;
                    }
                } else {
                    count = 0;
                }
            }
        }
        return hasWon;
    }

    public boolean isDiagonalUpRightTopWin(String token, Tile[][] board) {

        int count = 0;
        for (int i = Board.getRows() - 2; i >= 0; i--) {
            count = 0;
            for (int j = i, delta = 0; j >= 0 && delta < Board.getColumns(); j--, delta++) {
                if (board[j][delta].getToken() == token) {
                    count = count + 1;
                    if (count >= winNumber) {
                        hasWon = true;
                    }
                } else {
                    count = 0;
                }
            }
        }
        return hasWon;
    }

}
