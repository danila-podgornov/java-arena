// AI-Generated
package module39_stringbuilder_regular_expressions_enums_and_iterators_ai.step08_putting_it_together_and_the_end_of_part_10_ai.challenge01_ai;

public class Main {
    /**
     * A music festival sells three kinds of passes. {@code Pass.java} is ready, with a price for each. A ticket's code is the first letter of its pass's name, a dash and four digits: {@code D-0412} is a day pass, {@code W-1001} a weekend pass and {@code B-0007} a backstage pass. In {@code Main.java}, write the method {@code passFor(String code)}, which returns the Pass that a code stands for, or {@code null} when the code doesn't have that form. Check the form with {@code matches}, and find the pass by going through {@code Pass.values()}. The check runs:
     * <pre>{@code
     * System.out.println(passFor("W-1001"));
     * System.out.println(passFor("B-0007"));
     * System.out.println(passFor("D-412"));
     * System.out.println(passFor("X-1234"));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * WEEKEND
     * BACKSTAGE
     * null
     * null
     * }</pre>
     * Hints
     * 1. The form is one of the letters D, W or B, a dash, and four digits: {@code [DWB]-[0-9]{4}}. When the code doesn't match, return {@code null} at once.
     * 2. Then go through {@code Pass.values()}, and return the pass whose {@code name().charAt(0)} equals the code's {@code charAt(0)}. Both are chars, so compare them with {@code ==}.
     */
    public static void main(String[] args) {
        System.out.println(passFor("W-1001"));
        System.out.println(passFor("B-0007"));
        System.out.println(passFor("D-412"));
        System.out.println(passFor("X-1234"));
    }

    public static Pass passFor(String code) {
        return null;
    }
}
