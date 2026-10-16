// AI-Generated
package module39_stringbuilder_regular_expressions_enums_and_iterators_ai.step05_enums_a_fixed_set_of_values_ai.challenge01_ai;

public class Main {
    /**
     * A traffic light in the US goes from green to yellow, from yellow to red, and from red back to green. That's the cycle of module 17's TrafficLight, this time with an enum in place of Strings. {@code Light.java} is ready. In {@code Main.java}, write the method {@code next(Light light)}, which returns the light that comes after the one it's given. Compare the constants with {@code ==}. The check runs:
     * <pre>{@code
     * System.out.println(next(Light.GREEN));
     * System.out.println(next(Light.YELLOW));
     * System.out.println(next(Light.RED));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * YELLOW
     * RED
     * GREEN
     * }</pre>
     * Hints
     * 1. Check which light the method got with {@code if (light == Light.GREEN)}, and return the one after it, such as {@code return Light.YELLOW;}.
     * 2. Two checks are enough: green gives yellow, yellow gives red, and the only light left, red, gives green.
     */
    public static void main(String[] args) {
        System.out.println(next(Light.GREEN));
        System.out.println(next(Light.YELLOW));
        System.out.println(next(Light.RED));
    }

    public static Light next(Light light) {
        return light;
    }
}
