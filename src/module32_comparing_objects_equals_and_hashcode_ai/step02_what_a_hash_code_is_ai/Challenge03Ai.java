// AI-Generated
package module32_comparing_objects_equals_and_hashcode_ai.step02_what_a_hash_code_is_ai;

import java.util.HashMap;

public class Challenge03Ai {
    /**
     * Two different Strings can have the same hash code. What does this program print? The character codes are 65 for {@code A}, 66 for {@code B} and 97 for {@code a}.
     * Hints
     * 1. Use String's recipe: start from 0, and for each character, multiply by 31 and add the code. For {@code "Aa"}: 0 * 31 + 65 is 65, and 65 * 31 + 97 is 2112. Work out {@code "BB"} the same way.
     * 2. The hash codes are the same, but the Strings aren't equal. The map keeps both keys in the same bucket, and {@code equals} tells them apart, so nothing is lost.
     */
    public static void main(String[] args) {
        System.out.println("Aa".hashCode());
        System.out.println("BB".hashCode());
        System.out.println("Aa".equals("BB"));

        HashMap<String, Integer> points = new HashMap<>();
        points.put("Aa", 1);
        points.put("BB", 2);
        System.out.println(points.size());
        System.out.println(points.get("Aa"));
    }
}
