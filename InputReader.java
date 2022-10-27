import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputReader {

    private BufferedReader input;

    public InputReader() {
        input = new BufferedReader(new InputStreamReader(System.in));
    }

    public int getInput() {
        try {
            return convertToInt(input.readLine());
        } catch (IOException e) {
            System.out.println(e);
            System.out.println("Error from user input, returning 0");
        }
        return 0;
    }

    private int convertToInt(String s) {
        return Integer.parseInt(s);
    }

}
