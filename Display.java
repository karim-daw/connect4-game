public class Display {

    public Display() {
        // do nothing
    }

    public static void displayBoard(Board board) {
        System.out.println(board.getPrintableBoard());
    }

    public static void displayStartMessage() {
        System.out.println("\nWelcome to Connect 4");
        System.out.println("There are 2 players red and yellow");
        System.out.println("Player 1 is Red, Player 2 is Yellow");
        System.out.println("To play the game type in the number of the column you want to drop you counter in");
        System.out.println("A player wins by connecting 4 counters in a row - vertically, horizontally or diagonally");
        System.out.println("");
    }

    public static void displayWinner(Player player) {
        String str = "\nCongrations! " + player.getName() + " [" + player.getPrintableToken() + "]" + " wins!\n";
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

}
