// AI-Generated
package module39_stringbuilder_regular_expressions_enums_and_iterators_ai.step03_regular_expressions_matches_and_groups_ai;

public class Challenge02Ai {
    /**
     * What does this program print?
     * Hints
     * 1. Without parentheses, {@code |} splits the whole regex: {@code cat|dog food} means {@code cat}, or {@code dog food}.
     * 2. {@code dog} and {@code cat food} are neither of those two. In the fourth line, the capital G doesn't match the regex's small g.
     */
    public static void main(String[] args) {
        System.out.println("dog".matches("cat|dog food"));
        System.out.println("dog food".matches("(cat|dog) food"));
        System.out.println("grey".matches("gr(a|e)y"));
        System.out.println("Gray".matches("gr(a|e)y"));
        System.out.println("cat food".matches("cat|dog food"));
    }
}
