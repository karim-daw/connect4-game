import java.util.ArrayList;
import java.util.Random;

public class BotPlayer implements Player {

    private String token;
    private String name;
    private Random rand;
    private Board board;

    public BotPlayer(String token, String name, Board board) {
        this.token = token;
        this.name = name;
        this.board = board;
        rand = new Random();

    }

    public Move getMove() {
        int colNumber = getRandomColumn();
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

    // Function for the computer to play
    private int getRandomColumn() {

        board.setAvailableColumns();

        // get available columns
        ArrayList<Integer> availableColumns = board.getAvailableColumns();

        // get a random choice of column
        int random = rand.nextInt(availableColumns.size());
        int chosenColumn = availableColumns.get(random);

        System.out.println("\n" + "the computer chose column: " + chosenColumn + "\n");

        return chosenColumn;

    }

}
