// AI-Generated
package module32_comparing_objects_equals_and_hashcode_ai.step05_objects_as_keys_in_practice_ai.challenge02_ai;

import java.util.HashMap;

public class Main {
    /**
     * Here {@code Coin}'s {@code hashCode} uses only the country, so every Italian coin has the same hash code. Does the map still work? What does this program print?
     * Hints
     * 1. The rule only asks equal coins to have equal hash codes, and equal coins have the same country. So this {@code hashCode} follows it: the Italian coins all share one bucket, and {@code equals} tells them apart there.
     * 2. The third {@code put} replaces box 1 with box 3, and {@code remove} takes the 1999 coin out. No 2002 coin worth 20 cents was ever put in.
     */
    public static void main(String[] args) {
        HashMap<Coin, String> places = new HashMap<>();
        places.put(new Coin("Italy", 2002, 50), "box 1");
        places.put(new Coin("Italy", 1999, 20), "box 2");
        places.put(new Coin("Italy", 2002, 50), "box 3");
        places.remove(new Coin("Italy", 1999, 20));

        System.out.println(places.size());
        System.out.println(places.get(new Coin("Italy", 2002, 50)));
        System.out.println(places.containsKey(new Coin("Italy", 1999, 20)));
        System.out.println(places.get(new Coin("Italy", 2002, 20)));
    }
}
