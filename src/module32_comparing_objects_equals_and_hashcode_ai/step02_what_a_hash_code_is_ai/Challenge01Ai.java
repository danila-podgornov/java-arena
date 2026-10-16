// AI-Generated
package module32_comparing_objects_equals_and_hashcode_ai.step02_what_a_hash_code_is_ai;

import java.util.HashMap;

public class Challenge01Ai {
    /**
     * A ticket machine keeps the fare to each station, in cents, in a {@code HashMap<String, Integer>}. What does this program print?
     * Hints
     * 1. {@code typed} is made while the program runs, so it's a different object from the {@code "Oakdale"} in the code, and {@code ==} says false. But its characters are the same, so {@code equals} says true.
     * 2. Equal Strings always have equal hash codes, so the map finds the key and gives its value. An Integer's hash code is its own value.
     */
    public static void main(String[] args) {
        HashMap<String, Integer> fares = new HashMap<>();
        fares.put("Oakdale", 450);

        String first = "Oak";
        String typed = first + "dale";
        System.out.println(typed == "Oakdale");
        System.out.println(typed.equals("Oakdale"));
        System.out.println(typed.hashCode() == "Oakdale".hashCode());
        System.out.println(fares.get(typed));
        System.out.println(Integer.valueOf(450).hashCode());
    }
}
