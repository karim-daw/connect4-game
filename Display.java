public class Display {

    public Display() {
        // do nothing
    }

    public static void displayBoard(Board board) {
        System.out.println(board.getPrintableBoard());
    }

    public static void displayStartMessage() {
        System.out.println("Welcome to Connect 4");
        System.out.println("There are 2 players red and yellow");
        System.out.println("Player 1 is Red, Player 2 is Yellow");
        System.out.println("To play the game type in the number of the column you want to drop you counter in");
        System.out.println("A player wins by connecting 4 counters in a row - vertically, horizontally or diagonally");
        System.out.println("");
    }

    public static void displayWinner(HumanPlayer player) {
        String str = "Congrations! " + player.getName() + " [" + player.getPrintableToken() + "]" + " wins!";
        System.out.println(str);
        System.out.println("");
    }

}
