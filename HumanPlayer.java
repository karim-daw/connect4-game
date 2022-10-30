
public class HumanPlayer implements Player {

    private String token;
    private String name;
    Move currentMove;

    public HumanPlayer(String token, String name) {
        this.token = token;
        this.name = name;

        // add to player count and arrayList
        GameLogic.addPlayerCount();
        GameLogic.addPlayerToPlayerList(this);
    }

    /*
     * getter that consumes input from user
     * and instanciates a Move object with the input number
     * as the column
     * 
     * @return numberInput
     */
    public Move getMove() {
        int colNumber = new InputReader().getNumberInput();
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

    // sets name
    public void setName(String name) {
        this.name = name;
    }

    /*
     * constructs a string with a single char representing
     * the token of the this player
     * 
     * returns printableToken
     */
    public String getPrintableToken() {
        String tokenStripped = token.strip();
        char tokenString = tokenStripped.charAt(tokenStripped.length() - 1);
        String printableToken = Character.toString(tokenString);
        return printableToken;
    }

}
