// AI-Generated
package module38_ordering_objects_comparable_and_comparator_ai.step01_comparable_a_natural_order_for_your_class_ai.challenge02_ai;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    /**
     * A hackathon's scoreboard shows the teams with the highest score first. Look closely at the order of the two values in {@code compareTo}. What does this program print?
     * Hints
     * 1. {@code Integer.compare(other.score, this.score)} has the two values swapped: it's negative when {@code this} has the *higher* score. So a higher score comes first.
     * 2. The order is 95, 88, 72, 72. Byte Club and Stack Stars tie at 72, and a tie keeps the list's order. Last, Stack Stars comes after Loop Troop, so its {@code compareTo} is positive.
     */
    public static void main(String[] args) {
        ArrayList<Entry> board = new ArrayList<>();
        board.add(new Entry("Byte Club", 72));
        board.add(new Entry("Null Pointers", 88));
        board.add(new Entry("Stack Stars", 72));
        board.add(new Entry("Loop Troop", 95));
        Collections.sort(board);
        for (Entry entry : board) {
            System.out.println(entry);
        }
        System.out.println(board.get(3).compareTo(board.get(0)) > 0);
    }
}
