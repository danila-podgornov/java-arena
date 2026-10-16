// AI-Generated
package module21_designing_classes_and_overloading_ai.step03_several_constructors_ai.challenge02_ai;

public class Main {
    /**
     * A snowman has a number of snowballs and a nose. Write three constructors for the {@code Snowman} class:
     * <ul>
     * <li>{@code Snowman()} makes the classic snowman: 3 balls and a {@code carrot} nose.
     * <li>{@code Snowman(int balls)} has that many balls, and a {@code carrot} nose.
     * <li>{@code Snowman(int balls, String nose)} has the balls and the nose given.
     * </ul>
     * <p>The instance variables and {@code toString} are ready. The check prints {@code new Snowman()}, {@code new Snowman(4)} and {@code new Snowman(2, "pine cone")}: see the expected output below.
     * Expected output
     * <pre>{@code
     * 3 balls, carrot nose
     * 4 balls, carrot nose
     * 2 balls, pine cone nose
     * }</pre>
     * Hints
     * 1. Three constructors, all called {@code Snowman}, with different parameters: {@code public Snowman()}, {@code public Snowman(int balls)} and {@code public Snowman(int balls, String nose)}.
     * 2. Each one sets both instance variables. Where a value isn't given, it uses the default: 3 for the balls, {@code "carrot"} for the nose.
     */
    public static void main(String[] args) {
        System.out.println(new Snowman());
        System.out.println(new Snowman(4));
        System.out.println(new Snowman(2, "pine cone"));
    }
}
