// AI-Generated
package module25_separating_the_ui_from_program_logic_ai.step04_a_class_for_the_user_interface_ai.challenge01_ai;

import java.util.Scanner;

public class Main {
    /**
     * A rain barrel in a garden collects rain, and water can be taken from it to water the plants. The logic is ready in {@code RainBarrel.java}: {@code rain(int liters)} adds water, but never more than fits, {@code take(int liters)} returns {@code false} and changes nothing if there isn't that much water, and {@code getLiters()} returns how much water there is. {@code Main.java} is ready too. Write {@code UserInterface.java}: its constructor takes a {@code Scanner} and a {@code RainBarrel}, and {@code start()} reads commands, with the prompt {@code > } before each one:
     * <ul>
     * <li>{@code rain}: the next line is a number of liters. Add them to the barrel and print {@code Barrel: } and the liters in it, like {@code Barrel: 40 liters}.
     * <li>{@code water}: the next line is a number of liters. Take them from the barrel and print {@code Barrel: } and the liters left, or {@code Not enough water}.
     * <li>{@code level}: print {@code Barrel: } and the liters.
     * <li>{@code quit}: print {@code Bye!} and return.
     * <li>Anything else: print {@code Unknown command: } and the command.
     * </ul>
     * <p>For the input shown, the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * > Barrel: 40 liters
     * > Barrel: 25 liters
     * > Not enough water
     * > Barrel: 100 liters
     * > Barrel: 100 liters
     * > Bye!
     * }</pre>
     * Hints
     * 1. Two instance variables, {@code private Scanner scanner;} and {@code private RainBarrel barrel;}, set in the constructor {@code public UserInterface(Scanner scanner, RainBarrel barrel)}.
     * 2. {@code start()} is a {@code public void} method with the command loop in it, like the practice log's. Read with {@code this.scanner.nextLine()}, and read the liters with {@code Integer.valueOf(this.scanner.nextLine())}.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RainBarrel barrel = new RainBarrel(100);
        UserInterface ui = new UserInterface(scanner, barrel);
        ui.start();
    }
}
