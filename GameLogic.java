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
        Display.displayBoard(board);
    }

}
