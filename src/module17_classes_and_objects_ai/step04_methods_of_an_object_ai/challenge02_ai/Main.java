// AI-Generated
package module17_classes_and_objects_ai.step04_methods_of_an_object_ai.challenge02_ai;

public class Main {
    /**
     * Write the method {@code printCrossing(int tons)} for {@code Bridge}. It tells whether a vehicle that weighs {@code tons} may cross: a vehicle up to the bridge's limit may, a heavier one may not. The check runs:
     * <pre>{@code
     * Bridge bridge = new Bridge("Stone Bridge", 20);
     * bridge.printCrossing(12);
     * bridge.printCrossing(35);
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * 12 tons: may cross Stone Bridge
     * 35 tons: too heavy for Stone Bridge
     * }</pre>
     * Hints
     * 1. The method takes a parameter: <code>public void printCrossing(int tons) {</code>. It compares the parameter with the bridge's own limit, {@code this.maxTons}.
     * 2. A vehicle that weighs exactly the limit may cross: {@code if (tons <= this.maxTons)}.
     */
    public static void main(String[] args) {
        Bridge bridge = new Bridge("Stone Bridge", 20);
        bridge.printCrossing(12);
        bridge.printCrossing(35);
    }
}
