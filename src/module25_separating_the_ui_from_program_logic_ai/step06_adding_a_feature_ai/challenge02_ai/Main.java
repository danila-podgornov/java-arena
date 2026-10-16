// AI-Generated
package module25_separating_the_ui_from_program_logic_ai.step06_adding_a_feature_ai.challenge02_ai;

import java.util.Scanner;

public class Main {
    /**
     * A model railway program builds a train behind its engine. {@code Train} and {@code UserInterface} know the commands {@code attach}, which is followed by a line with the kind of car to add at the end, {@code detach}, which takes off the last car, and {@code quit}. Add the command {@code count}: the next line is a kind of car, and the program prints how many cars of that kind the train has, like {@code sleeper cars: 2}. A car counts when its kind is spelled exactly the same, capitals included.
     * <ul>
     * <li>In {@code Train.java}, add the method {@code countOf(String kind)}, which returns the number.
     * <li>In {@code UserInterface.java}, add the command.
     * </ul>
     * <p>For the input shown, the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * > [engine]-[seats]
     * > [engine]-[seats]-[sleeper]
     * > [engine]-[seats]-[sleeper]-[dining]
     * > [engine]-[seats]-[sleeper]-[dining]-[sleeper]
     * > sleeper cars: 2
     * > cargo cars: 0
     * > [engine]-[seats]-[sleeper]-[dining]
     * > sleeper cars: 1
     * > End of the line
     * }</pre>
     * Hints
     * 1. {@code countOf} goes through {@code this.cars} with a for-each loop and counts the cars that {@code equals} the kind it was given. It returns the count and prints nothing.
     * 2. The {@code count} command reads the kind with {@code this.scanner.nextLine()}, keeps it in a variable, and prints it with {@code " cars: "} and {@code this.train.countOf(kind)}.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Train train = new Train();
        UserInterface ui = new UserInterface(scanner, train);
        ui.start();
    }
}
