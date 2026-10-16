// AI-Generated
package module18_getters_tostring_and_bigger_classes_ai.step05_calling_the_objects_own_methods_ai.challenge01_ai;

public class Main {
    /**
     * A {@code Flashlight} knows the charge of its battery in percent, and {@code isLow()} tells whether it's below 20. Add a {@code toString} that returns the charge with a {@code %} sign, followed by {@code  (low)} when the charge is low. Use {@code isLow()} for that, instead of comparing the charge again. The check prints a flashlight at 30 percent, uses 15 and prints it again: see the expected output below.
     * Expected output
     * <pre>{@code
     * 30%
     * 15% (low)
     * }</pre>
     * Hints
     * 1. Inside the class, {@code this.isLow()} calls the method on the same flashlight. It returns a boolean, so it can be the condition of an {@code if}.
     * 2. {@code if (this.isLow()) { return this.charge + "% (low)"; }}, and after it {@code return this.charge + "%";}
     */
    public static void main(String[] args) {
        Flashlight light = new Flashlight(30);
        System.out.println(light);
        light.use(15);
        System.out.println(light);
    }
}
