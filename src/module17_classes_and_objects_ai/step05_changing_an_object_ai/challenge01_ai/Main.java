// AI-Generated
package module17_classes_and_objects_ai.step05_changing_an_object_ai.challenge01_ai;

public class Main {
    /**
     * The {@code WaterBottle} from step 3 comes full and has a {@code printInfo()} method. Add a method {@code drink(int amount)} that takes {@code amount} milliliters out of the bottle. A bottle can't hold less than nothing: when the amount is more than what's left, the bottle becomes empty (0 ml). The check runs:
     * <pre>{@code
     * WaterBottle bottle = new WaterBottle(750);
     * bottle.drink(200);
     * bottle.printInfo();
     * bottle.drink(600);
     * bottle.printInfo();
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * 550/750 ml
     * 0/750 ml
     * }</pre>
     * Hints
     * 1. {@code drink} changes the bottle's own variable: {@code this.milliliters = this.milliliters - amount;}.
     * 2. Then, like {@code cut} in the example, an {@code if} sets it to 0 when it went below 0.
     */
    public static void main(String[] args) {
        WaterBottle bottle = new WaterBottle(750);
        bottle.drink(200);
        bottle.printInfo();
        bottle.drink(600);
        bottle.printInfo();
    }
}
