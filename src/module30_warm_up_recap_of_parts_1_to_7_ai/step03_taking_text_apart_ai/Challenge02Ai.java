// AI-Generated
package module30_warm_up_recap_of_parts_1_to_7_ai.step03_taking_text_apart_ai;

public class Challenge02Ai {
    /**
     * A woodworking student writes down each piece to cut: its name, its length and its width in centimeters. What does this program print?
     * Hints
     * 1. The parts are Strings. {@code +} between two Strings joins them, and {@code +} between two ints adds them up.
     * 2. {@code parts[0].length()} is the number of letters in {@code shelf}, and {@code parts.length} the number of parts. Two ints are added up, but a String followed by an int joins them.
     */
    public static void main(String[] args) {
        String line = "shelf,40,25";
        String[] parts = line.split(",");
        System.out.println(parts[1] + parts[2]);
        System.out.println(Integer.valueOf(parts[1]) + Integer.valueOf(parts[2]));
        System.out.println(parts[0].length() + parts.length);
        System.out.println(parts[0] + parts.length);
    }
}
