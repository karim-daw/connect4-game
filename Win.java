
public class Win {

    // Fields

    private boolean hasWon = false;
    private static int winNumber;

    // Constructor

    public Win() {

        // get winNumber from user input
        // if exception thrown, make default winNumber = 4
        try {
            getUserWinNumber();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Setting winning number to 4");
            Win.winNumber = 4;
        }
    }

    // Methods

    /**
     * wrapper function that checks if any winning condition is met
     * on the current state of the board
     * 
     * @param token
     * @param board
     * @return win - boolean of whether board contains a winning sequence
     */
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

    /**
     * handles user input for getting the winNumber of the game
     * checks if input number is between 2 and the smallest
     * board dimension,
     * 
     * @throws Exception
     */
    public static void getUserWinNumber() throws Exception {

        // display welcome message connectN, prompt user to choose winNumber
        Display.displayWelcomeMessage();

        // consume win number and check if in valid bounds, else throw Exception
        int winNumber = new InputReader().getNumberInput();
        if (winNumber <= Board.getSmallestBoardDimension() && winNumber >= 2)
            Win.winNumber = winNumber;
        else {
            throw new Exception(
                    "Win number is either smaller than 2 or too large for Board Dimnesions");
        }
    }

    // get winNumber
    public static int getWinNumber() {
        return winNumber;
    }

    /**
     * check if board contains a horizontal win
     * 
     * @param token
     * @param board
     * @return boolean hasWon
     */
    public boolean isHorizontalWin(String token, Tile[][] board) {

        // start counter and loop through rows
        int count = 0;
        for (int i = 0; i < Board.getRows(); i++) {

            // loop through each column
            for (int j = 0; j < board[i].length; j++) {

                count = incrementAndCheckWin(token, board, count, j, i);
            }
            // explicit reset for the next row
            count = 0;
        }
        return hasWon;
    }

    /**
     * check if board contains a vertical win
     * 
     * @param token
     * @param board
     * @return boolean hasWon
     */
    public boolean isVerticalWin(String token, Tile[][] board) {

        // start counter and loop through columns
        int count = 0;

        // loop through each column
        for (int i = 0; i < Board.getColumns(); i++) {

            // loop through each row
            for (int j = 0; j < Board.getRows(); j++) {

                // call method to increment count and check if win
                count = incrementAndCheckWin(token, board, count, i, j);
            }
            // explicit reset for the next column
            count = 0;
        }
        return hasWon;
    }

    // the diagonal algorythms are broken up into several sub methods checking
    // the various corner starting points of the board
    // the logic is based off of this diagram
    // https://stackoverflow.com/questions/32770321/connect-4-check-for-a-win-algorithm/32771681#32771681

    /**
     * the algorythm consists of a variation of the basic logic i have outlined
     * below
     * there will be variations of the "pivot" or "starting" point but the basic
     * logic is still the same, two nested forloops with three variables
     * i,j,delta, where j and delta increment and i is the pivot or start point
     * 
     * the algo;
     * start counter from inside loop to use row as pivot point
     * loop through rows and columns
     * check if index is between row and col bounds
     * while i is contant in the nested loop i.e:
     * init delta variable (substituting row index) that
     * increments and j (column index) also increments
     * or decrements depending is its checking diagonals
     * going up (decrements j) or down (increments j)
     * 
     * loop through rows
     * start counter
     * (in nested loop)
     * i = 0
     * j = 0
     * delta = 0
     * counter++
     * check if counter above winNumber
     * 
     * i = 0
     * j = 1
     * delta = 1
     * counter++
     * check if counter above winNumber
     * 
     * i = 0
     * j = 2
     * delta = 2
     * counter++
     * check if counter above winNumber
     */

    /**
     * check if board contains a diagonal win going downwards and to the right
     * starting at bottom half of board
     * 
     * @param token
     * @param board
     * @return boolean hasWon
     */
    public boolean isDiagonalDownRightBottomWin(String token, Tile[][] board) {

        // loop through each row
        for (int i = 0; i < Board.getRows(); i++) {

            /**
             * start counter from inside loop to use row as pivot point
             * loop through rows and columns
             */
            int count = 0;
            for (int j = i, delta = 0; j < Board.getRows() && delta < Board.getColumns(); j++, delta++) {

                // call method to increment count and check if win
                count = incrementAndCheckWin(token, board, count, delta, j);
            }
        }
        return hasWon;
    }

    /**
     * check if board contains a diagonal win going downwards and to the right
     * starting at top half board
     * 
     * @param token
     * @param board
     * @return boolean hasWon
     */
    public boolean isDiagonalDownRightTopWin(String token, Tile[][] board) {

        // loop through each row
        for (int i = 1; i < Board.getRows(); i++) {

            /**
             * start counter from inside loop to use row as pivot point
             * loop through rows and columns
             */
            int count = 0;
            for (int j = 0, delta = i; j < Board.getRows() && delta < Board.getColumns(); j++, delta++) {

                // call method to increment count and check if win
                count = incrementAndCheckWin(token, board, count, delta, j);
            }
        }
        return hasWon;
    }

    /**
     * check if board contains a diagonal win going upwards and to the right
     * starting at bottom half board
     * 
     * @param token
     * @param board
     * @return boolean hasWon
     */
    public boolean isDiagonalUpRightBottomWin(String token, Tile[][] board) {

        // loop through each column
        for (int i = 0; i < Board.getColumns(); i++) {

            /**
             * start counter from inside loop to use row as pivot point
             * loop through rows and columns
             */
            int count = 0;
            for (int j = Board.getRows() - 1, delta = i; j >= 0 && delta < Board.getColumns(); j--, delta++) {

                // call method to increment count and check if win
                count = incrementAndCheckWin(token, board, count, delta, j);
            }
        }
        return hasWon;
    }

    public boolean isDiagonalUpRightTopWin(String token, Tile[][] board) {

        // loop through each row
        int count = 0;
        for (int i = Board.getRows() - 2; i >= 0; i--) {

            /**
             * start counter from inside loop to use row as pivot point
             * loop through rows and columns
             */
            count = 0;
            for (int j = i, delta = 0; j >= 0 && delta < Board.getColumns(); j--, delta++) {

                // call method to increment count and check if win
                count = incrementAndCheckWin(token, board, count, delta, j);
            }
        }
        return hasWon;
    }

    /**
     * helper function that accumulates tokens in a row and
     * checks if the acculated sum of tokens is equal to or
     * larger than the winNumber
     * 
     * @param token
     * @param board
     * @param count
     * @param row
     * @param column
     * @return count - incremented number or 0
     */
    private int incrementAndCheckWin(String token, Tile[][] board, int count, int row, int column) {
        // if tile.token is equal to the input token, increment count
        // else set count back to 0 for rest
        if (board[column][row].getToken() == token) {
            count = count + 1;

            if (count >= winNumber) {
                hasWon = true;
            }
        } else {
            count = 0;
        }
        return count;
    }

}
