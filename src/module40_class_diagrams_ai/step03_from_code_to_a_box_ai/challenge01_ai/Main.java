// AI-Generated
package module40_class_diagrams_ai.step03_from_code_to_a_box_ai.challenge01_ai;

public class Main {
    /**
     * The pickups of step 1 have grown methods. Here's their box now:
     * <pre>{@code
     * class Pickup
     * - address: String
     * - kilos: double
     * - done: boolean
     * + Pickup(address: String, kilos: double)
     * + getAddress(): String
     * + getKilos(): double
     * + isDone(): boolean
     * + markDone(): void
     * + toString(): String
     * }</pre>
     * <p>Fill in the blanks in {@code main} from the box: the types of the two variables, and the name of the method that marks a pickup as done. The program should print: see the expected output below.
     * Expected output
     * {@code 35.5 true}
     * Hints
     * 1. The type after the colon is what a method gives back: {@code getKilos(): double} gives a double, so the variable that holds it is a {@code double}.
     * 2. {@code isDone(): boolean} gives a {@code boolean}, and the method that marks the pickup is {@code markDone}, which returns nothing ({@code void}).
     */
    public static void main(String[] args) {
        Pickup pickup = new Pickup("12 Mill Road", 35.5);
        ___ kilos = pickup.getKilos();
        pickup.___();
        ___ done = pickup.isDone();
        System.out.println(kilos + " " + done);
    }
}
