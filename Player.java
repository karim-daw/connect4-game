
public class Player {

    private String token;
    private String name;

    public Player(String token, String name) {
        this.token = token;
        this.name = name;
    }

    public Move getMove() {
        int colNumber = new InputReader().getNumberInput();
        return new Move(colNumber);
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
}
