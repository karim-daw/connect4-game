public class GameLogic {

    private Board board;

    public GameLogic() {
        board = new Board(6, 7);
    }

    public void displayBoard() {
        board.printBoard();
    }
}
