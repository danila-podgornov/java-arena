// AI-Generated
package module17_classes_and_objects_ai.step03_constructors_ai.challenge02_ai;

public class Main {
    /**
     * A new water bottle comes full. {@code WaterBottle.java} has two instance variables, {@code capacity} and {@code milliliters} (how much water is in it), and a method {@code printInfo()}. Write the constructor {@code WaterBottle(int capacity)}: it stores the capacity and fills the bottle, so {@code milliliters} starts at the same value. The check runs:
     * <pre>{@code
     * WaterBottle bottle = new WaterBottle(750);
     * bottle.printInfo();
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * {@code 750/750 ml}
     * Hints
     * 1. The constructor has one parameter: <code>public WaterBottle(int capacity) {</code>.
     * 2. Store the capacity with {@code this.capacity = capacity;}. The bottle starts full, so {@code this.milliliters = capacity;} too.
     */
    public static void main(String[] args) {
        WaterBottle bottle = new WaterBottle(750);
        bottle.printInfo();
    }
}
