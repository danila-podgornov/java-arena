// AI-Generated
package module21_designing_classes_and_overloading_ai.step04_one_constructor_calling_another_ai.challenge02_ai;

public class Main {
    /**
     * Here's the {@code Snowman} from step 3, with three constructors that each store both values. Rewrite the first two so that only {@code Snowman(int balls, String nose)} stores anything: {@code Snowman(int balls)} calls it with a carrot nose, and {@code Snowman()} calls one of the other constructors for 3 balls. The output stays the same: see the expected output below.
     * Expected output
     * <pre>{@code
     * 3 balls, carrot nose
     * 4 balls, carrot nose
     * 2 balls, pine cone nose
     * }</pre>
     * Hints
     * 1. {@code Snowman(int balls)} becomes one line: {@code this(balls, "carrot");}.
     * 2. {@code Snowman()} becomes one line too: {@code this(3);} runs {@code Snowman(int balls)}, which runs the two-parameter constructor. ({@code this(3, "carrot");} works as well.)
     */
    public static void main(String[] args) {
        System.out.println(new Snowman());
        System.out.println(new Snowman(4));
        System.out.println(new Snowman(2, "pine cone"));
    }
}
