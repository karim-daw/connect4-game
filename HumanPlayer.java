
public class HumanPlayer implements Player {

    private String token;
    private String name;

    public HumanPlayer(String token, String name) {
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

    public void placeToken(Board board) {

        // get move from player and check if valid
        Move move = getMove();

        if (move.isValidMove() && move.isMoveInBounds()) {

            // get position
            int col = getMove().getColumn();

            if (!board.isColumnFull(col)) {

                // get player token
                String playerToken = getToken();

                for (int i = Board.getRows() - 1; i >= 0; i--) {

                    Tile tile = board.getBoard()[i][col - 1];

                    // check if position is occupied
                    if (!tile.isAvailable()) {

                    } else {
                        tile.setToken(playerToken);
                        tile.setToOccupied();

                        // put tile on board
                        board.getBoard()[i][col - 1] = tile;
                        break;
                    }
                }
            }
        }
    }

}
