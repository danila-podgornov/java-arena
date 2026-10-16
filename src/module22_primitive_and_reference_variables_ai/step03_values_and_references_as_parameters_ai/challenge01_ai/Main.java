// AI-Generated
package module22_primitive_and_reference_variables_ai.step03_values_and_references_as_parameters_ai.challenge01_ai;

public class Main {
    /**
     * {@code Jug.java} is ready. In {@code Main}, write a method {@code pourAll(Jug from, Jug to)} that pours all the water from one jug into the other: {@code to} gets everything {@code from} had, and {@code from} ends up empty. It returns nothing, since it changes the two jugs themselves. The check runs:
     * <pre>{@code
     * Jug big = new Jug(300);
     * Jug small = new Jug(150);
     * pourAll(small, big);
     * System.out.println(big + " and " + small);
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * {@code 450 ml and 0 ml}
     * Hints
     * 1. The method changes the jugs through their methods, so it returns nothing: <code>public static void pourAll(Jug from, Jug to) {</code>.
     * 2. Order matters: first {@code to.add(from.getMilliliters());}, and only then {@code from.empty();}. Emptying first would pour 0 ml.
     */
    public static void main(String[] args) {
        Jug big = new Jug(300);
        Jug small = new Jug(150);
        pourAll(small, big);
        System.out.println(big + " and " + small);
    }

    // Write the pourAll method here.
}
