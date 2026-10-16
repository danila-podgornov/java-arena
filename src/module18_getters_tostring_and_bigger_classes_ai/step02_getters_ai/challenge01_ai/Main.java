// AI-Generated
package module18_getters_tostring_and_bigger_classes_ai.step02_getters_ai.challenge01_ai;

public class Main {
    /**
     * A {@code Planet} has a name and a number of moons. Add two getters, {@code getName()} and {@code getMoons()}, and a method {@code hasMoons()} that returns {@code true} when the planet has at least one moon. It isn't stored in a variable of its own: work it out from {@code moons}. The check creates {@code new Planet("Mars", 2)} and prints what the three methods return: see the expected output below.
     * Expected output
     * <pre>{@code
     * Mars
     * 2
     * true
     * }</pre>
     * Hints
     * 1. {@code getName} returns a String, {@code getMoons} an int and {@code hasMoons} a boolean. None of them has parameters.
     * 2. {@code public String getName() { return this.name; }}, the same way for the moons, and {@code hasMoons()} returns the comparison {@code this.moons > 0}.
     */
    public static void main(String[] args) {
        Planet planet = new Planet("Mars", 2);
        if (planet.hasMoons()) {
            System.out.println(planet.getName() + " has " + planet.getMoons() + " moons");
        }
    }
}
