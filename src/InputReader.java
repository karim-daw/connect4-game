package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputReader {

    // Fields

    private BufferedReader input;
    private String userInput;
    private int numberInput;

    // Constructor

    public InputReader() {
        input = new BufferedReader(new InputStreamReader(System.in));
    }

    // Methods

    /**
     * getter that returns integer from user input
     * 
     * @return numberInput
     */
    public int getNumberInput() {
        getUserInput();
        return numberInput;
    }

    /**
     * Gets the user input from the buffered reader
     * converts to converts to integer
     */
    private void getUserInput() {
        try {
            userInput = input.readLine();
            if (userInput == null) {
                System.exit(0);
            } else {
                convertToInt();
            }

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    /**
     * Parse input from buffered reader to integer value
     */
    private void convertToInt() {
        try {
            numberInput = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            numberInput = -1;
        }
    }

}
