import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputReader {

    private BufferedReader input;
    private String userInput;
    private int numberInput;

    public InputReader() {
        input = new BufferedReader(new InputStreamReader(System.in));
    }

    public int getNumberInput() {
        getUserInput();
        return numberInput;
    }

    public void getUserInput() {
        try {
            userInput = input.readLine();
            convertToInt();

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private void convertToInt() {
        try {
            numberInput = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            System.out.println("cannot enter non-integer number");
            System.out.println(e);
            numberInput = -1;
        }
    }

}
