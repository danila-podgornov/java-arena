// AI-Generated
package module39_stringbuilder_regular_expressions_enums_and_iterators_ai.step03_regular_expressions_matches_and_groups_ai;

public class Challenge01Ai {
    /**
     * An ice cream stand sells four things: {@code single cone}, {@code single cup}, {@code double cone} and {@code double cup}. Fill in the regex, with two groups, so that it describes exactly those four. The program then prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * single cone: true
     * double cup: true
     * single cup: true
     * double cone: true
     * triple cone: false
     * double: false
     * single cones: false
     * }</pre>
     * Hints
     * 1. Like the ferry's tickets: a group with the two sizes, a space, and a group with the two ways to serve it.
     * 2. {@code (single|double) (cone|cup)}
     */
    public static void main(String[] args) {
        String menu = "___";
        String[] orders = {"single cone", "double cup", "single cup", "double cone", "triple cone", "double", "single cones"};
        for (String order : orders) {
            System.out.println(order + ": " + order.matches(menu));
        }
    }
}
