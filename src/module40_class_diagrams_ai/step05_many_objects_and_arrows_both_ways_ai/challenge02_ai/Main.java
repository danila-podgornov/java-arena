// AI-Generated
package module40_class_diagrams_ai.step05_many_objects_and_arrows_both_ways_ai.challenge02_ai;

public class Main {
    /**
     * The festival moves The Low Tides from the Blue Tent to the Main Field. Stage and Act are the classes of the lesson's connection both ways, and Stage has one more method, {@code count()}, which returns the number of acts in its list:
     * <pre>{@code
     * class Stage
     * - name: String
     * + Stage(name: String)
     * + add(act: Act): void
     * + getName(): String
     * + count(): int
     *
     * class Act
     * - name: String
     * - minutes: int
     * + Act(name: String, minutes: int)
     * + setStage(stage: Stage): void
     * + toString(): String
     *
     * Stage 0..1 -- * Act
     * }</pre>
     * <p>What does this program print?
     * Hints
     * 1. {@code add} does two things: it puts the act in the stage's list, and it tells the act its stage with {@code setStage(this)}.
     * 2. The second {@code add} sets the act's stage to the Main Field, but nothing takes the act out of the Blue Tent's list. Both lists have it, while the act knows only its last stage: the two sides disagree.
     */
    public static void main(String[] args) {
        Stage tent = new Stage("Blue Tent");
        Stage field = new Stage("Main Field");
        Act tides = new Act("The Low Tides", 45);
        tent.add(tides);
        field.add(tides);
        System.out.println(tent.count() + " " + field.count());
        System.out.println(tides);
    }
}
