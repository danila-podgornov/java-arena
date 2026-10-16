// AI-Generated
package module32_comparing_objects_equals_and_hashcode_ai.step01_equals_again_ai.challenge01_ai;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    /**
     * A board game puts colored tokens on the squares of a grid, with names like {@code A1}: a column letter and a row number. {@code Square} has an {@code equals}, but no {@code hashCode}. What does this program print?
     * Hints
     * 1. The list compares with {@code equals}, and a new {@code Square("A", 1)} is equal to {@code corner}. {@code tokens.get(corner)} looks up the very object that was put in with {@code red}.
     * 2. Without a {@code hashCode} of its own, every new Square gets Java's default hash code, which in practice is different for every object. So to the map, each new A1 almost certainly looks like a different key: the {@code put} with a new A1 adds a second key instead of replacing {@code red}, and {@code containsKey} with a third new A1 finds nothing.
     */
    public static void main(String[] args) {
        Square corner = new Square("A", 1);
        ArrayList<Square> taken = new ArrayList<>();
        taken.add(corner);
        HashMap<Square, String> tokens = new HashMap<>();
        tokens.put(corner, "red");
        tokens.put(new Square("A", 1), "blue");

        System.out.println(taken.contains(new Square("A", 1)));
        System.out.println(tokens.get(corner));
        System.out.println(tokens.containsKey(new Square("A", 1)));
        System.out.println(tokens.size());
    }
}
