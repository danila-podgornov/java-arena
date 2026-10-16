// AI-Generated
package module40_class_diagrams_ai.step06_inheritance_and_abstract_classes_ai.challenge02_ai;

import java.util.ArrayList;

public class Main {
    /**
     * A music festival's program has this diagram, but the code doesn't match it in two places, and {@code Main.java} doesn't compile:
     * <pre>{@code
     * abstract class Performer
     * - name: String
     * + Performer(name: String)
     * + getName(): String
     * + slotMinutes(): int {abstract}
     * + toString(): String
     *
     * class Band extends Performer
     * - members: int
     * + Band(name: String, members: int)
     * + slotMinutes(): int
     *
     * class Dj extends Performer
     * + Dj(name: String)
     * + slotMinutes(): int
     * }</pre>
     * <p>A band plays 30 minutes plus 5 for each member, and a DJ plays 60 minutes. Fix {@code Performer.java} and {@code Dj.java} so that they match the diagram, and leave {@code Main.java} and {@code Band.java} as they are. The program should print: see the expected output below.
     * Expected output
     * <pre>{@code
     * The Low Tides, 50 min
     * Kora, 60 min
     * 110 min in all
     * }</pre>
     * Hints
     * 1. Performer's name and {@code slotMinutes()} are in italics, under «abstract»: the class is abstract, and so is that method, a header that ends in a semicolon.
     * 2. The triangle from Dj points to Performer: {@code public class Dj extends Performer}. Dj's box has no fields, so the name belongs to Performer, and Dj's constructor passes it on with {@code super(name);}.
     */
    public static void main(String[] args) {
        ArrayList<Performer> lineup = new ArrayList<>();
        lineup.add(new Band("The Low Tides", 4));
        lineup.add(new Dj("Kora"));
        int minutes = 0;
        for (Performer performer : lineup) {
            System.out.println(performer);
            minutes += performer.slotMinutes();
        }
        System.out.println(minutes + " min in all");
    }
}
