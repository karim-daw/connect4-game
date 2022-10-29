import java.util.ArrayList;

public class GameLogic {

    private Board board;
    private Player player1;
    private Player player2;
    private Player player3;
    private Player currentPlayer;
    private Win win;
    private static int playerCount = 0;
    private static ArrayList<Player> players = new ArrayList<Player>();

    public GameLogic(int winNumber) {
        board = new Board(6, 7);
        // TODO error checking to make sure board is big enough for winNumber

        player1 = new HumanPlayer("| R ", "Player 1");
        player2 = new BotPlayer("| Y ", "Player 2", board);
        player3 = new BotPlayer("| G ", "Player 3", board);
        win = new Win(winNumber);

        // show welcome message
        Display.displayStartMessage();
    }

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
            } else if (Move.TESTisColumnFull(currentPlayer.getCurrentMove().getColumn(), board.getBoard())) {
                //

                // otherwise change player
            } else {
                changePlayer();
            }

        }

    }

    public void changePlayer() {

        if (currentPlayer.equals(player1) &&
                currentPlayer.getCurrentMove().isValidMove() &&
                currentPlayer.getCurrentMove().isMoveInBounds()) {
            currentPlayer = player2;
        } else if (currentPlayer.equals(player2) &&
                currentPlayer.getCurrentMove().isValidMove() &&
                currentPlayer.getCurrentMove().isMoveInBounds()) {
            currentPlayer = player3;
        } else if (currentPlayer.equals(player3) &&
                currentPlayer.getCurrentMove().isValidMove() &&
                currentPlayer.getCurrentMove().isMoveInBounds()) {
            currentPlayer = player1;
        } else {
            //
        }
    }

    public static ArrayList<Player> getPlayers() {
        return players;
    }

    public static void addPlayerToPlayerList(Player player) {
        GameLogic.players.add(player);
    }

    public static int getPlayerCount() {
        return playerCount;
    }

    public static void addPlayerCount() {
        GameLogic.playerCount++;
    }

}
