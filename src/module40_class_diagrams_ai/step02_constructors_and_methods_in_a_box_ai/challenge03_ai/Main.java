// AI-Generated
package module40_class_diagrams_ai.step02_constructors_and_methods_in_a_box_ai.challenge03_ai;

public class Main {
    /**
     * A board-game café lends games to its guests, and pieces go missing. Write the class {@code GameBox} in {@code GameBox.java}, as this box shows:
     * <pre>{@code
     * class GameBox
     * - title: String
     * - pieces: int
     * - missing: int
     * + GameBox(title: String, pieces: int)
     * + lose(count: int): void
     * + find(count: int): void
     * + isComplete(): boolean
     * + toString(): String
     * - present(): int
     * }</pre>
     * <ul>
     * <li>A new box has all its pieces: none are missing.
     * <li>{@code lose} adds to the missing pieces. {@code find} takes found pieces off them, but never below 0.
     * <li>{@code isComplete} says whether no pieces are missing.
     * <li>{@code present} is a private helper that returns how many pieces are in the box. {@code toString} uses it, and returns {@code Harbor Lights: 80 of 84 pieces}, with the box's own title and numbers.
     * </ul>
     * <p>The check runs:
     * <pre>{@code
     * GameBox box = new GameBox("Harbor Lights", 84);
     * box.lose(5);
     * box.find(1);
     * System.out.println(box + " " + box.isComplete());
     * box.find(10);
     * System.out.println(box + " " + box.isComplete());
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * Harbor Lights: 80 of 84 pieces false
     * Harbor Lights: 84 of 84 pieces true
     * }</pre>
     * Hints
     * 1. Three instance variables, a constructor that sets {@code missing} to 0, and a method for each line of the box. The {@code -} in front of {@code present} makes it {@code private int present()}.
     * 2. {@code find} subtracts, then sets {@code missing} back to 0 if it went below. {@code present()} returns the pieces minus the missing ones, and {@code toString} calls {@code this.present()}.
     */
    public static void main(String[] args) {
        GameBox box = new GameBox("Harbor Lights", 84);
        box.lose(5);
        box.find(1);
        System.out.println(box + " " + box.isComplete());
        box.find(10);
        System.out.println(box + " " + box.isComplete());
    }
}
