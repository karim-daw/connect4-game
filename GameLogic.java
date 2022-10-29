public class GameLogic {

    private Board board;
    Player player1;
    Player player2;
    Player currentPlayer;
    Win win = new Win();

    public GameLogic() {
        board = new Board(6, 7);
        player1 = new HumanPlayer("| R ", "Player 1");
        player2 = new BotPlayer("| Y ", "Player 2", board);
    }

    // show board
    // set current player
    //

    public void playGame() {

        // show welcome message
        Display.displayStartMessage();

        // show starting board
        Display.displayBoard(board);

        // set current player
        currentPlayer = player1;

        // if game hasnt won
        while (!board.hasWin()) {

            // place token
            board.placeToken(currentPlayer);

            // show state of board
            Display.displayBoard(board);

            // check if there is a winner
            if (win.checkWin(currentPlayer.getToken(), board.getBoard())) {
                board.isWin();
                Display.displayWinner(currentPlayer);
            } else {
                // change player
                changePlayer();
            }
        }

    }

    public void changePlayer() {
        if (currentPlayer.equals(player1)) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

}
