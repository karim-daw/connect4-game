
public class Player {

    private String token;

    public Player(String token) {
        this.token = token;
    }

    public Move getMove() {
        int colNumber = new InputReader().getNumberInput();
        return new Move(colNumber);
    }

    public String getToken() {
        return token;
    }
}
