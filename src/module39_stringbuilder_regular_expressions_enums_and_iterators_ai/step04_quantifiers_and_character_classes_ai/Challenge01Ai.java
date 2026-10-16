// AI-Generated
package module39_stringbuilder_regular_expressions_enums_and_iterators_ai.step04_quantifiers_and_character_classes_ai;

public class Challenge01Ai {
    /**
     * A hotel's booking codes are three capital letters, a dash and four digits, like {@code KTX-0415}. Write the method {@code isBookingCode(String code)}, which returns whether a string has that form, with a regex and {@code matches}. The check runs:
     * <pre>{@code
     * System.out.println(isBookingCode("KTX-0415"));
     * System.out.println(isBookingCode("ktx-0415"));
     * System.out.println(isBookingCode("KT-0415"));
     * System.out.println(isBookingCode("KTX-04155"));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * true
     * false
     * false
     * false
     * }</pre>
     * Hints
     * 1. A capital letter is {@code [A-Z]} and a digit {@code [0-9]}. A quantifier in curly braces says how many of them come in a row.
     * 2. {@code return code.matches("[A-Z]{3}-[0-9]{4}");}
     */
    public static void main(String[] args) {
        System.out.println(isBookingCode("KTX-0415"));
        System.out.println(isBookingCode("ktx-0415"));
        System.out.println(isBookingCode("KT-0415"));
        System.out.println(isBookingCode("KTX-04155"));
    }

    public static boolean isBookingCode(String code) {
        return false;
    }
}
