import java.util.ArrayList;
import java.util.Random;

public class BotPlayer implements Player {

    private String token;
    private String name;
    private Random rand;
    private Board board;
    Move currentMove;

    public BotPlayer(String token, String name, Board board) {
        this.token = token;
        this.name = name;
        this.board = board;
        rand = new Random();

        // add to player count
        GameLogic.addPlayerCount();
        GameLogic.addPlayerToPlayerList(this);
    }

    public Move getMove() {
        int colNumber = getRandomColumn();
        Move move = new Move(colNumber);
        this.currentMove = move;
        return move;
    }

    public Move getCurrentMove() {
        return this.currentMove;
    }

    public String getToken() {
        return token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrintableToken() {
        String tokenStripped = token.strip();
        char tokenString = tokenStripped.charAt(tokenStripped.length() - 1);
        String printableToken = Character.toString(tokenString);
        return printableToken;
    }

    // Function for the computer to play
    private int getRandomColumn() {

        // get available columns
        ArrayList<Integer> availableColumns = board.getAvailableColumns();

        // get a random choice of column
        int random = rand.nextInt(availableColumns.size());
        int chosenColumn = availableColumns.get(random);
        Display.displayBotMove(this, chosenColumn);

        return chosenColumn;

    }

}
