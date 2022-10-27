public class GameLogic {

    private Board board;
    Player player1;
    Player player2;
    Player currentPlayer;

    public GameLogic() {
        board = new Board(6, 7);
        player1 = new Player("R");
        player2 = new Player("B");
    }

    public void playGame() {

        // show starting board
        Display.displayBoard(board);

        // set current player
        Player currentPlayer = player1;

        // if game hasnt won
        while (!board.hasWon()) {

            // place token
            board.placeToken(currentPlayer);

            // show state of board
            Display.displayBoard(board);

            changePlayer();

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
