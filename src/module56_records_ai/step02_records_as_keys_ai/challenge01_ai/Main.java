// AI-Generated
package module56_records_ai.step02_records_as_keys_ai.challenge01_ai;

import java.util.ArrayList;

public class Main {
    /**
     * A city's buses take travel passes, each with the holder's name and a pass number. {@code TravelPass} is a record. What does this program print?
     * Hints
     * 1. {@code ==} is true only for the very same object: {@code same} is {@code mine} itself, but {@code copy} was made with its own {@code new}. {@code equals} compares the components.
     * 2. The names are compared with String's {@code equals}, which tells small letters from capitals. A list's {@code contains} uses {@code equals} too.
     */
    public static void main(String[] args) {
        TravelPass mine = new TravelPass("Mira Holm", 4021);
        TravelPass copy = new TravelPass("Mira Holm", 4021);
        TravelPass same = mine;
        TravelPass other = new TravelPass("mira holm", 4021);
        System.out.println(mine == copy);
        System.out.println(mine.equals(copy));
        System.out.println(mine == same);
        System.out.println(mine.equals(other));
        ArrayList<TravelPass> lost = new ArrayList<>();
        lost.add(copy);
        System.out.println(lost.contains(mine));
    }
}
