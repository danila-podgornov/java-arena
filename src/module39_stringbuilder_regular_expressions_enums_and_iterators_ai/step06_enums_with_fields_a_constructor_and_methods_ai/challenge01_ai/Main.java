// AI-Generated
package module39_stringbuilder_regular_expressions_enums_and_iterators_ai.step06_enums_with_fields_a_constructor_and_methods_ai.challenge01_ai;

public class Main {
    /**
     * Here are the planets, in order from the sun. {@code Planet.java} lists the eight constants, each with its diameter at the equator in kilometers, but it doesn't compile yet: the enum has no constructor for those values. Add:
     * <ul>
     * <li>a private instance variable for the diameter, and a private constructor that sets it
     * <li>{@code getDiameter()}, which returns the diameter
     * <li>{@code positionFromSun()}, which returns 1 for Mercury, 2 for Venus, and so on (the constants are in that order)
     * </ul>
     * <p>The check runs:
     * <pre>{@code
     * System.out.println(Planet.EARTH.getDiameter());
     * System.out.println(Planet.MARS.positionFromSun());
     * for (Planet planet : Planet.values()) {
     *     if (planet.getDiameter() > 100000) {
     *         System.out.println(planet);
     *     }
     * }
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * 12756
     * 4
     * JUPITER
     * SATURN
     * }</pre>
     * Hints
     * 1. Like CupSize: {@code private int diameter;}, then {@code private Planet(int diameter) { this.diameter = diameter; }}, and a getter.
     * 2. {@code ordinal()} counts from 0 in the order of the constants, and Mercury comes first, so {@code positionFromSun()} returns {@code this.ordinal() + 1}.
     */
    public static void main(String[] args) {
        System.out.println(Planet.EARTH.getDiameter());
        System.out.println(Planet.MARS.positionFromSun());
        for (Planet planet : Planet.values()) {
            if (planet.getDiameter() > 100000) {
                System.out.println(planet);
            }
        }
    }
}
