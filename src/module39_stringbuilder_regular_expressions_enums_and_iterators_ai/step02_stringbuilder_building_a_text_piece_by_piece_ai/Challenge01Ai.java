// AI-Generated
package module39_stringbuilder_regular_expressions_enums_and_iterators_ai.step02_stringbuilder_building_a_text_piece_by_piece_ai;

import java.util.ArrayList;

public class Challenge01Ai {
    /**
     * Write the method {@code guestList(ArrayList<String> names)}, which returns the text {@code Guests: } followed by the names with a comma and a space between them. For an empty list it returns {@code Guests: none}. Build the text with a StringBuilder and {@code append}. The check runs:
     * <pre>{@code
     * ArrayList<String> names = new ArrayList<>();
     * names.add("Ada");
     * names.add("Ben");
     * names.add("Cy");
     * System.out.println(guestList(names));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * {@code Guests: Ada, Ben, Cy}
     * Hints
     * 1. Handle the empty list first, with {@code isEmpty()}. Otherwise start with {@code new StringBuilder("Guests: ")} and append the names in a loop.
     * 2. The comma goes *between* names: append {@code ", "} before every name except the first, which an index loop can tell by {@code i > 0}. Return {@code list.toString()} at the end.
     */
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("Ada");
        names.add("Ben");
        names.add("Cy");
        System.out.println(guestList(names));
    }

    public static String guestList(ArrayList<String> names) {
        return "";
    }
}
