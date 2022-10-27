public class GameLogic {

    private Board board;
    Player player1;
    Player player2;

    public GameLogic() {
        board = new Board(6, 7);
        player1 = new Player("R");
        player2 = new Player("B");
    }

    public void playGame() {
        // start by showing empty board
        Display.displayBoard(board);

        // play a round, whhere player 1 places token

    }

}
