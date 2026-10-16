// AI-Generated
package module40_class_diagrams_ai.step04_arrows_between_classes_ai.challenge02_ai;

public class Main {
    /**
     * The theater's director cuts some scenes, and the play gets shorter. Here are the Play and Performance of the lesson, with one more method in Play:
     * <pre>{@code
     * class Play
     * - title: String
     * - minutes: int
     * + Play(title: String, minutes: int)
     * + getTitle(): String
     * + getMinutes(): int
     * + cut(minutes: int): void
     *
     * class Performance
     * - date: String
     * - seatsSold: int
     * + Performance(play: Play, date: String)
     * + sell(seats: int): void
     * + toString(): String
     *
     * Performance --> 1 Play : play
     * }</pre>
     * <p>What does this program print?
     * Hints
     * 1. {@code opening} and {@code second} get the same Play object, {@code macbeth}: the arrow is a reference, not a copy. {@code cut} changes that one object, and both performances see it, whenever they print.
     * 2. {@code tour} has a Play object of its own, made with {@code new}, which {@code cut} never touches.
     */
    public static void main(String[] args) {
        Play macbeth = new Play("Macbeth", 150);
        Performance opening = new Performance(macbeth, "June 1");
        Performance second = new Performance(macbeth, "June 2");
        Performance tour = new Performance(new Play("Macbeth", 150), "June 3");
        opening.sell(80);
        macbeth.cut(15);
        second.sell(200);
        System.out.println(opening);
        System.out.println(second);
        System.out.println(tour);
    }
}
