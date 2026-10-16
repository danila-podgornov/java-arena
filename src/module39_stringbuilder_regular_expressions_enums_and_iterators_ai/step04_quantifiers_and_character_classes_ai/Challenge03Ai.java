// AI-Generated
package module39_stringbuilder_regular_expressions_enums_and_iterators_ai.step04_quantifiers_and_character_classes_ai;

public class Challenge03Ai {
    /**
     * In the Netherlands, a postcode is four digits, the first of which isn't 0, then a space and two capital letters, like {@code 1012 AB}. A web shop accepts them with or without the space. Write the method {@code isPostcode(String text)}, which returns whether a string is a postcode of that form, with one call to {@code matches}. The check runs:
     * <pre>{@code
     * System.out.println(isPostcode("1012 AB"));
     * System.out.println(isPostcode("1012AB"));
     * System.out.println(isPostcode("0123 AB"));
     * System.out.println(isPostcode("1012 ab"));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * true
     * true
     * false
     * false
     * }</pre>
     * Hints
     * 1. The first digit is a class of its own, {@code [1-9]}, and the three other digits are {@code [0-9]{3}}. The letters are {@code [A-Z]{2}}.
     * 2. A {@code ?} after the space makes the space optional: {@code [1-9][0-9]{3} ?[A-Z]{2}}.
     */
    public static void main(String[] args) {
        System.out.println(isPostcode("1012 AB"));
        System.out.println(isPostcode("1012AB"));
        System.out.println(isPostcode("0123 AB"));
        System.out.println(isPostcode("1012 ab"));
    }

    public static boolean isPostcode(String text) {
        return false;
    }
}
