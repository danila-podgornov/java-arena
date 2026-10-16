// AI-Generated
package module39_stringbuilder_regular_expressions_enums_and_iterators_ai.step05_enums_a_fixed_set_of_values_ai.challenge02_ai;

public class Main {
    /**
     * What does this program print?
     * Hints
     * 1. {@code values()} gives the constants in the order the enum lists them, so the last one is GREEN, at position 2.
     * 2. There's only one RED, so both variables refer to it. The names RED, YELLOW and GREEN have 3, 6 and 5 letters.
     */
    public static void main(String[] args) {
        Light[] lights = Light.values();
        Light last = lights[lights.length - 1];
        System.out.println(last + " " + last.ordinal());
        Light first = Light.RED;
        Light same = Light.RED;
        System.out.println(first == same);
        int letters = 0;
        for (Light light : lights) {
            letters += light.name().length();
        }
        System.out.println(letters);
    }
}
