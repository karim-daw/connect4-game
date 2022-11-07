package src;

import java.util.ArrayList;
import java.util.Random;

public class BotPlayer implements Player {

    // Fields

    private String token;
    private String name;
    private Random rand;
    private Board board;
    Move currentMove;

    // Constructor

    public BotPlayer(String token, String name, Board board) {
        this.token = token;
        this.name = name;
        this.board = board;
        rand = new Random();

        // add to player count and to playerlist of game
        GameLogic.addPlayerCount();
        GameLogic.addPlayerToPlayerList(this);
    }

    // Methods

    /*
     * gets user input and returns move object for player
     * 
     * return Move
     */
    public Move getMove() {
        int colNumber = getRandomColumn();
        Move move = new Move(colNumber);
        this.currentMove = move;
        return move;
    }

    // get current Move object of player
    public Move getCurrentMove() {
        return this.currentMove;
    }

    // get token
    public String getToken() {
        return token;
    }

    // get name
    public String getName() {
        return name;
    }

    // set name
    public void setName(String name) {
        this.name = name;
    }

    // get printable token, single char as String
    public String getPrintableToken() {
        String tokenStripped = token.strip();
        char tokenString = tokenStripped.charAt(tokenStripped.length() - 1);
        String printableToken = Character.toString(tokenString);
        return printableToken;
    }

    /**
     * method gets the available columns on the board
     * picks a random one and returns that column
     * 
     * @return choseColumn by bot
     */
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
