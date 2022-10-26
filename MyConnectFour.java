import java.io.BufferedReader;
import java.io.InputStreamReader;

// testing branch

public class MyConnectFour {

    private BufferedReader input;
    private char[][] board;

    public MyConnectFour() {
        board = new char[6][7];
        input = new BufferedReader(new InputStreamReader(System.in));
        playGame();
    }

    private void playGame() {
        System.out.println("Welcome to Connect 4");
        System.out.println("There are 2 players red and yellow");
        System.out.println("Player 1 is Red, Player 2 is Yellow");
        System.out.println("To play the game type in the number of the column you want to drop you counter in");
        System.out.println("A player wins by connecting 4 counters in a row - vertically, horizontally or diagonally");
        System.out.println("");
        printBoard();

        boolean win = false;
        while (!win) {
            // player 1
            String userInput = getUserInput();
            int move = Integer.parseInt(userInput);
            placeCounter('r', move);
            boolean hasWon = false;
            int count = 0;
            // check horizontal
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == 'r') {
                        count = count + 1;
                        if (count >= 4) { // change to >=
                            hasWon = true;
                        }
                    } else {
                        count = 0;
                    }
                }

            }
            // check vertical
            count = 0;
            for (int i = 0; i < board[0].length; i++) {
                for (int j = 0; j < board.length; j++) {
                    if (board[j][i] == 'r') {
                        count = count + 1;
                        if (count >= 4) { // change to >=
                            hasWon = true;
                        }
                    } else {
                        count = 0;
                    }
                }
            }

            // check diagonal (down right)

            for (int i = 0; i < board.length; i++) {
                count = 0;
                int delta = 0;
                for (int j = i; j < board.length; j++) {

                    if (board[j][delta] == 'r') {

                        System.out.println("[" + (i) + "," + (j) + "]");
                        System.out.println("[" + (i + 1) + "," + (j + 1) + "]");
                        // System.out.println("count is " + count);
                        // System.out.println("mover is " + mover);

                        count = count + 1;
                        delta++;

                        // System.out.println(count);

                        if (count >= 4) {
                            hasWon = true;
                        }

                        System.out.println(count);
                    } else {
                        count = 0;
                        // mover = 0;
                    }

                }
            }

            // System.out.println(count);
            // TODO check diagonals left and right

            // System.out.println(hasWon);
            printBoard();
            if (hasWon) {
                win = true;
                System.out.println("You Have Won!!!"); // move to inside if statement

            } else {
                // player 2
                userInput = getUserInput();
                move = Integer.parseInt(userInput);
                placeCounter('y', move);
                hasWon = false;
                count = 0;
                // check horizontal
                for (int i = 0; i < board.length; i++) {
                    for (int j = 0; j < board[i].length; j++) {
                        if (board[i][j] == 'y') {
                            count = count + 1;
                            if (count >= 4) {
                                hasWon = true;
                            }
                        } else {
                            count = 0;
                        }
                    }
                    count = 0;
                }

                // check vertical
                count = 0;
                for (int i = 0; i < board[0].length; i++) {
                    for (int j = 0; j < board.length; j++) {
                        if (board[j][i] == 'y') {
                            count = count + 1;
                            if (count >= 4) {
                                hasWon = true;
                            }
                        } else {
                            count = 0;
                        }
                    }
                    count = 0;
                }

                // TODO check diagonals left and right

                printBoard();
                if (hasWon) {
                    win = true;
                    System.out.println("You Have Won!!!"); // move to inside if statement
                }
            }

        }

    }

    private String getUserInput() {
        String toReturn = null;
        try {
            toReturn = input.readLine();
        } catch (Exception e) {

        }
        return toReturn;
    }

    private void printBoard() {
        for (int i = 0; i < board.length; i++) // removed -1 to print full board

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

    private void placeCounter(char player, int position) {
        boolean placed = false;
        if (player == 'r') {
            for (int i = board.length - 1; i >= 0; i--) { // changed this to decrement. TODO check this
                if (!placed) {
                    if (board[i][position - 1] == 'y') {
                        // skip
                    } else if (board[i][position - 1] != 'r') {
                        board[i][position - 1] = 'r';
                        // System.out.println((i - 1) + " " + (position - 1));
                        placed = true;
                    }
                }
            }
        } else {
            for (int i = board.length - 1; i >= 0; i--) {
                if (!placed) {
                    if (board[i][position - 1] == 'r') {
                        // skip
                    } else if (board[i][position - 1] != 'y') {
                        board[i][position - 1] = 'y';
                        // System.out.println((i - 1) + " " + (position - 1));
                        placed = true;
                    }
                }
            }
        }
    }
}
