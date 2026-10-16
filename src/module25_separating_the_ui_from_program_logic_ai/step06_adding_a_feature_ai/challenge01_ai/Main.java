// AI-Generated
package module25_separating_the_ui_from_program_logic_ai.step06_adding_a_feature_ai.challenge01_ai;

import java.util.Scanner;

public class Main {
    /**
     * A water log helps a person drink enough during the day, and the goal is 2000 ml. {@code WaterLog} and {@code UserInterface} know the commands {@code drink}, {@code total} and {@code quit}. Add a feature, the command {@code goal}:
     * <ul>
     * <li>In {@code WaterLog.java}, add the method {@code mlToGoal()}. It returns how many milliliters are still missing, or 0 when the goal is reached.
     * <li>In {@code UserInterface.java}, add the command {@code goal}. It prints {@code Goal reached!} when {@code mlToGoal()} is 0, and otherwise the missing milliliters, like {@code 750 ml to go}.
     * </ul>
     * <p>For the input shown, the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * > Total: 500 ml
     * > 1500 ml to go
     * > Total: 1250 ml
     * > 750 ml to go
     * > Total: 2100 ml
     * > Goal reached!
     * > Cheers!
     * }</pre>
     * Hints
     * 1. {@code mlToGoal()} compares two instance variables that WaterLog already has, the total and the goal. It returns a number and prints nothing: the words belong to the user interface, in one more {@code else if}.
     * 2. {@code if (this.total >= this.goal) { return 0; }}, and otherwise {@code return this.goal - this.total;}. In {@code start()}, add {@code else if (command.equals("goal"))} before the last {@code else}, keep {@code this.log.mlToGoal()} in a variable, and print one of the two messages depending on whether it's 0.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WaterLog log = new WaterLog(2000);
        UserInterface ui = new UserInterface(scanner, log);
        ui.start();
    }
}
