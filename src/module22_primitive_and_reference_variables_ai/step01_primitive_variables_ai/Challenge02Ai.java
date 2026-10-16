// AI-Generated
package module22_primitive_and_reference_variables_ai.step01_primitive_variables_ai;

import java.util.Scanner;

public class Challenge02Ai {
    /**
     * In a game, the player starts with some lives. The program reads the starting number, then one event per line until {@code end}: {@code hit} takes a life and {@code heart} gives one. The first line and the two prints at the end are ready. Declare {@code lives} as a copy of {@code start}, and change only {@code lives} in the loop, so that {@code start} still holds the starting number at the end. For the input {@code 3}, {@code hit}, {@code hit}, {@code heart}, {@code hit} and {@code end}, one per line, the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Lives at the start: 3
     * Lives now: 1
     * }</pre>
     * Hints
     * 1. {@code int lives = start;} copies the starting number. From then on the two variables are separate, so changing {@code lives} leaves {@code start} as it was.
     * 2. In a {@code while (true)} loop, read a line and {@code break} at {@code end}. For {@code hit} do {@code lives--;}, for {@code heart} do {@code lives++;}.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start = Integer.valueOf(scanner.nextLine());
        // Declare lives here, then read the events.

        System.out.println("Lives at the start: " + start);
        System.out.println("Lives now: " + lives);
    }
}
