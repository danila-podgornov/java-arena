// AI-Generated
package module51_data_visualization_ai.step01_from_text_rows_to_numbers_ai;

import java.util.ArrayList;

public class Challenge03Ai {
    /**
     * A coffee machine in an office logs the cups it made each day. Some rows have a {@code -}, and one row lost its value altogether. What does this program print?
     * Hints
     * 1. The loop starts at index 1, so the header {@code day,cups} isn't one of the rows it reads. A row with {@code -} is skipped.
     * 2. {@code "Thu,".split(",")} drops the empty value at the end, so its array has only one element, and {@code parts.length < 2} is true. The last line splits the header, which has two values.
     */
    public static void main(String[] args) {
        String[] rows = {"day,cups", "Mon,4", "Tue,-", "Wed,6", "Thu,", "Fri,5"};
        ArrayList<Integer> cups = new ArrayList<>();
        int skipped = 0;
        for (int i = 1; i < rows.length; i++) {
            String[] parts = rows[i].split(",");
            if (parts.length < 2 || parts[1].equals("-")) {
                skipped++;
            } else {
                cups.add(Integer.valueOf(parts[1]));
            }
        }
        System.out.println(cups);
        System.out.println(skipped + " skipped");
        System.out.println(rows[0].split(",").length);
    }
}
