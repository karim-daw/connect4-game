import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Player {

    private String token;
    private BufferedReader input;

    public Player(String token) {
        this.token = token;
        input = new BufferedReader(new InputStreamReader(System.in));
    }

    public Move getMove() {
        try {
            String col = input.readLine();
            int colNumber = Integer.parseInt(col);
            return new Move(colNumber);

        } catch (IOException e) {
            System.out.println(e);
        }
        return null;
    }

    public String getToken() {
        return token;
    }
}
