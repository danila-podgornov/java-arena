// AI-Generated
package module39_stringbuilder_regular_expressions_enums_and_iterators_ai.step02_stringbuilder_building_a_text_piece_by_piece_ai;

public class Challenge03Ai {
    /**
     * Big numbers are easier to read with a comma between every three digits, counted from the right: 1,234,567. Write the method {@code withCommas(int number)}, which returns the number written that way, for any number from 0 up. Put the digits in a StringBuilder, and insert the commas with a {@code for} loop that goes backwards from the end, three digits at a time. The check runs:
     * <pre>{@code
     * System.out.println(withCommas(1234567));
     * System.out.println(withCommas(950));
     * System.out.println(withCommas(20000));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * 1,234,567
     * 950
     * 20,000
     * }</pre>
     * Hints
     * 1. {@code new StringBuilder().append(number)} holds the digits ({@code new StringBuilder(number)} would only set its starting room and stay empty). The first comma goes in front of the last three digits, at index {@code length() - 3}, and each comma after that three places further left.
     * 2. Loop with {@code for (int i = digits.length() - 3; i > 0; i -= 3)} and {@code digits.insert(i, ",")}. Going from the right, the commas already added are all to the right of {@code i}, so they don't move the digits still to come. {@code i > 0} stops a comma from going in front of the first digit.
     */
    public static void main(String[] args) {
        System.out.println(withCommas(1234567));
        System.out.println(withCommas(950));
        System.out.println(withCommas(20000));
    }

    public static String withCommas(int number) {
        return "" + number;
    }
}
