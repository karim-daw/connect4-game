
public class Win {

    private boolean hasWon = false;
    private static int winNumber;

    public Win(int winNumber) {
        Win.winNumber = winNumber;
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

    public static int getWinNumber() {
        return winNumber;
    }

    public boolean isHorizontalWin(String token, Tile[][] board) {

        int count = 0;

        // check horizontal
        for (int i = 0; i < board.length; i++) {
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
        }
        return hasWon;
    }

    public boolean isVerticalWin(String token, Tile[][] board) {

        int count = 0;

        // check vertical
        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board.length; j++) {

                if (board[j][i].getToken() == token) {
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

    public boolean isDiagonalDownRightBottomWin(String token, Tile[][] board) {

        int count = 0;
        for (int i = 0; i < board.length; i++) {
            count = 0;
            for (int j = i, delta = 0; j < board.length && delta < board[0].length; j++, delta++) {
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
        for (int i = 1; i < board.length; i++) {
            count = 0;
            for (int j = 0, delta = i; j < board.length && delta < board[0].length; j++, delta++) {
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
        for (int i = 0; i < board[0].length; i++) {
            count = 0;
            for (int j = board.length - 1, delta = i; j >= 0 && delta < board[0].length; j--, delta++) {
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
        for (int i = board.length - 2; i >= 0; i--) {
            count = 0;
            for (int j = i, delta = 0; j >= 0 && delta < board[0].length; j--, delta++) {
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
