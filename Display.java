public class Display {

    // Constructor

    public Display() {
        // do nothing
    }

    // Methods

    public static void displayBoard(Board board) {
        System.out.println(board.getPrintableBoard());
    }

    public static void displayStartMessage() {
        System.out.println("\nWelcome again! this time to Connect " + Win.getWinNumber());
        System.out.println("There are " + GameLogic.getPlayerCount() + " players");
        displayPlayers();
        System.out.println("To play, type in the column number you want to drop a tile in");
        System.out.println("A player wins by connecting " + Win.getWinNumber()
                + " tiles in a row");
        System.out.println("Vertically, horizontally or diagonally");
        System.out.println("");
    }

    public static void displayWinner(Player player) {
        String str = "\nCongrations! " + player.getName() + " [" + player.getPrintableToken() + "]" + " wins!\n";
        System.out.println(str);
        System.out.println("");
    }

    public static void displayDraw() {
        String str = "Well poop... its a draw";
        System.out.println(str);
        System.out.println("");
    }

    public static void displayInValidMoveWarning() {
        System.out.println("\nCannot enter non-integer number...");
        System.out.println("Try again, this time, enter an integer\n");
    }

    public static void displayMoveOutOfBoundsWarning(int column) {
        System.out.println("\nthis is the input colum: " + column);
        System.out.println("this is the column amount: " + Board.getColumns());
        System.out.println("Try again, chosen column is out of bounds\n");
    }

    public static void displayColumnFullWarning(int column) {
        System.out.println("\nColumn " + column + " is full, pick another\n");
    }

    public static void displayBotMove(Player player, int column) {
        System.out.println("\n" + "the bot: " + player.getName() + " chose column: " + column + "\n");
    }

    public static void displayHumanMove(Player player, int column) {
        System.out.println("\n" + "You chose column: " + column + "\n");
    }

    public static void displayWelcomeMessage() {
        System.out.println("\n Welcome to ConnectN!, input the winner number...\n");
    }

    // loops through players and prints player info one by one
    public static void displayPlayers() {
        String s = "";
        for (Player player : GameLogic.getPlayers()) {
            s += player.getName();
            s += " has the token -> ";
            s += player.getToken();
            System.out.println(s);
            s = "";
        }
        s += "\n";

    }

}
