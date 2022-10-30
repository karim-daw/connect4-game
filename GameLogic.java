import java.util.ArrayList;

public class GameLogic {

    // Fields

    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Win win;

    private static int playerCount = 0;
    private static ArrayList<Player> players = new ArrayList<Player>();

    // Constructor

    public GameLogic() {
        board = new Board(6, 7);

        player1 = new HumanPlayer("| R ", "Player 1");
        player2 = new BotPlayer("| Y ", "Player 2", board);

        // init Win to get winning numbere
        win = new Win();

        // show welcome message
        Display.displayStartMessage();
    }

    // Methods

    /**
     * main gameplay sequence
     */
    public void playGame() {

        // show starting board
        Display.displayBoard(board);

        // set current player
        currentPlayer = player1;

        // if game hasnt won
        while (!board.hasWin() && !board.hasDraw()) {

            // place token
            board.placeToken(currentPlayer);

            // show state of board
            Display.displayBoard(board);

            // check if there is a winner
            if (win.checkWin(currentPlayer.getToken(), board.getBoard())) {
                board.isWin();
                Display.displayWinner(currentPlayer);
                // check if there is a draw
            } else if (board.isDraw()) {
                Display.displayDraw();
                // check if human tried column that is full
            } else if (currentPlayer.getCurrentMove().isValidMove() &&
                    currentPlayer.getCurrentMove().isMoveInBounds() &&
                    checkIsColumnFull()) {
                // do nothing and go back
                ;
                // otherwise change player
            } else {
                changePlayer();
            }
        }
    }

    /**
     * method that automatically changes currentPlayer at the end of each round
     * if all moves were valid and in bounds
     * else the current player stays the same and goes again
     */
    public void changePlayer() {

        if (currentPlayer.equals(player1) &&
                currentPlayer.getCurrentMove().isValidMove() &&
                currentPlayer.getCurrentMove().isMoveInBounds()) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
            // do nothing
        }
    }

    /**
     * wrapper method to check if current player chose a full column or not
     * 
     * @return boolean - whether column is full or not
     */
    private boolean checkIsColumnFull() {
        Move currentMove = currentPlayer.getCurrentMove();
        int currentCol = currentMove.getColumn();
        return Move.isColumnFull(currentCol, board.getBoard()); // returns true if full
    }

    // get arrayList of players
    public static ArrayList<Player> getPlayers() {
        return players;
    }

    // adds player to player list
    public static void addPlayerToPlayerList(Player player) {
        GameLogic.players.add(player);
    }

    // get player count
    public static int getPlayerCount() {
        return playerCount;
    }

    // increments player count
    public static void addPlayerCount() {
        GameLogic.playerCount++;
    }

}
