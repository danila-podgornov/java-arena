// AI-Generated
package module39_stringbuilder_regular_expressions_enums_and_iterators_ai.step07_iterators_removing_while_going_through_ai;

import java.util.ArrayList;
import java.util.Iterator;

public class Challenge01Ai {
    /**
     * A playlist should lose its short tracks, the ones under 60 seconds. Fill in the blanks: get an iterator from the list, go on while it has elements, take the next one, and remove it when it's short. The program prints: see the expected output below.
     * Expected output
     * {@code [214, 187, 302]}
     * Hints
     * 1. The four blanks are, in order: the list's method that gives an iterator, and the iterator's methods that ask whether there's more, take the next element, and remove it.
     * 2. {@code tracks.iterator()}, {@code iterator.hasNext()}, {@code iterator.next()} and {@code iterator.remove()}.
     */
    public static void main(String[] args) {
        ArrayList<Integer> tracks = new ArrayList<>();
        tracks.add(214);
        tracks.add(45);
        tracks.add(187);
        tracks.add(30);
        tracks.add(302);

        Iterator<Integer> iterator = tracks.___();
        while (iterator.___()) {
            int seconds = iterator.___();
            if (seconds < 60) {
                iterator.___();
            }
        }
        System.out.println(tracks);
    }
}
