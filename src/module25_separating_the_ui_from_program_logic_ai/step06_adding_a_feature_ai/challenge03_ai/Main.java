// AI-Generated
package module25_separating_the_ui_from_program_logic_ai.step06_adding_a_feature_ai.challenge03_ai;

import java.util.Scanner;

public class Main {
    /**
     * An elevator goes between the floors 0 and 9. {@code Elevator} and {@code UserInterface} know the commands {@code go}, which is followed by a line with a floor number, {@code where} and {@code quit}. Add the command {@code traveled}, which prints how many floors the elevator has moved in all, like {@code Floors traveled: 8}. Going from floor 5 to floor 2 is 3 floors, and going up counts just like going down.
     * <p>The elevator doesn't remember that yet, so the feature needs a new instance variable in {@code Elevator}, updated whenever it moves, and a method {@code getTraveled()} that returns it. A trip to a floor that doesn't exist doesn't move the elevator. Then add the command to {@code UserInterface}. For the input shown, the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * > Floor 5
     * > Floor 2
     * > Floor 2
     * > No floor 12
     * > Floors traveled: 8
     * > Floor 0
     * > Floors traveled: 10
     * > Out of service
     * }</pre>
     * Hints
     * 1. Add {@code private int traveled;}, set to 0 in the constructor, and {@code public int getTraveled()} that returns it. The distance of one trip is {@code Math.abs(target - this.floor)}: the difference without its minus sign.
     * 2. In {@code goTo}, add the distance after the check for a floor that doesn't exist, and before {@code this.floor = target;}: after that line, the old floor is gone.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Elevator elevator = new Elevator(9);
        UserInterface ui = new UserInterface(scanner, elevator);
        ui.start();
    }
}
