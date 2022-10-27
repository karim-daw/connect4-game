
public class Player {

    private String token;

    public Player(String token) {
        this.token = token;
    }

    public Move getMove() {
        int colNumber = new InputReader().getInput();
        return new Move(colNumber);
    }

    public String getToken() {
        return token;
    }
}
