// AI-Generated
package module44_type_parameters_generics_ai.step05_putting_it_together_what_the_compiler_checks_ai.challenge03_ai;

public class Main {
    /**
     * A game's difficulty level must stay from 1 to 5, and a nickname must have at least 3 letters. Module 42's Oven refused a bad setting in its constructor and in {@code setDegrees}; one generic class can do that for any type, with a rule from step 4. {@code Rule.java}, {@code Between.java} and {@code MinLength.java} are ready. In {@code Guarded.java}, write the class {@code Guarded<T>} with:
     * <ul>
     * <li>a constructor {@code Guarded(T start, Rule<T> rule)}. The start value must pass the rule too: if it doesn't, the constructor throws an IllegalArgumentException with the message {@code Not allowed: } followed by the value, like {@code Not allowed: 9}.
     * <li>{@code get()}, which returns the value
     * <li>{@code set(T value)}, which changes the value if the rule allows it. If not, it throws an IllegalArgumentException with the same kind of message, and the old value stays.
     * </ul>
     * <p>The check runs:
     * <pre>{@code
     * Guarded<Integer> difficulty = new Guarded<>(3, new Between(1, 5));
     * difficulty.set(4);
     * try {
     *     difficulty.set(9);
     * } catch (IllegalArgumentException e) {
     *     System.out.println(e.getMessage());
     * }
     * System.out.println(difficulty.get());
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * Not allowed: 9
     * 4
     * }</pre>
     * Hints
     * 1. The header is {@code public class Guarded<T>}, with two instance variables: {@code private T value;} and {@code private Rule<T> rule;}. The rule's type argument is the same T, so a {@code Guarded<Integer>} takes a {@code Rule<Integer>}.
     * 2. {@code set} checks first, {@code if (!this.rule.allows(value))}, and throws {@code new IllegalArgumentException("Not allowed: " + value)}; only after the check does it set {@code this.value}. The constructor can store the rule and then call {@code this.set(start)}, so the start value gets the same check.
     */
    public static void main(String[] args) {
        Guarded<Integer> difficulty = new Guarded<>(3, new Between(1, 5));
        difficulty.set(4);
        try {
            difficulty.set(9);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(difficulty.get());
    }
}
