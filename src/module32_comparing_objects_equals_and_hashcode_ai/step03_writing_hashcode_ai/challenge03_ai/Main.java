// AI-Generated
package module32_comparing_objects_equals_and_hashcode_ai.step03_writing_hashcode_ai.challenge03_ai;

import java.util.HashMap;

public class Main {
    /**
     * A stamp has a country, a year and a condition, such as {@code mint} or {@code used}. {@code Stamp}'s {@code equals} says two stamps are equal when the country and the year match, whatever their condition. But its {@code hashCode} uses the condition too. What does this program print?
     * Hints
     * 1. {@code equals} ignores the condition, so the used stamp is equal to the mint one. But the condition is part of the hash code, so their hash codes differ, and the map looks for the used stamp with the wrong hash code.
     * 2. A new mint Chile 1970 stamp has the same values as the key, so the same hash code, and the map finds it. The 1971 stamp isn't equal to any key.
     */
    public static void main(String[] args) {
        HashMap<Stamp, String> album = new HashMap<>();
        album.put(new Stamp("Chile", 1970, "mint"), "page 4");

        Stamp used = new Stamp("Chile", 1970, "used");
        System.out.println(used.equals(new Stamp("Chile", 1970, "mint")));
        System.out.println(album.get(used));
        System.out.println(album.get(new Stamp("Chile", 1970, "mint")));
        System.out.println(album.containsKey(new Stamp("Chile", 1971, "mint")));
    }
}
