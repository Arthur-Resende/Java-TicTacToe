import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Provides methods for obtaining and validating user input.
 */
public class Input {
    static Scanner scanner = new Scanner(System.in);
    static final int boardStart = 1;
    static final int boardEnd = 3;

    /**
     * Checks whether the provided input is within the valid range specified by boardStart and boardEnd.
     *
     * @param input The input value to be validated.
     * @return true if the input is within the valid range; otherwise, false.
     */
    protected boolean isValid(int input) {
        return input >= boardStart && input <= boardEnd;
    }

    /**
     * Prompts the user for input and ensures it falls within the valid range.
     * If the input is not within the valid range, the user is repeatedly prompted until a valid input is provided.
     *
     * @param prompt The message to display as the input prompt.
     * @return The validated input within the valid range (input - 1) as an integer.
     */
    protected int getInput(String prompt) {
        String errorPrompt = "Invalid value.\nPlease provide a number between " + boardStart + " and " + boardEnd + ": ";
        int input = -1;

        System.out.print(prompt);

        while (!isValid(input)) {
            try {
                input = scanner.nextInt();
            }
            catch (InputMismatchException exception) {
                scanner.nextLine();
            }
            if (!isValid(input)) {
                System.out.print(errorPrompt);
            }
        }
        return input - 1;
    }
}
