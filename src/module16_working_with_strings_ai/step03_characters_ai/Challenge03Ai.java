// AI-Generated
package module16_working_with_strings_ai.step03_characters_ai;

public class Challenge03Ai {
    /**
     * What does this program print? The loop runs backwards.
     * Hints
     * 1. The loop starts at the last index, 5, and goes down to 0, adding one character in each round.
     * 2. {@code drawer} backwards is {@code reward}. On the last line, the {@code ""} in the middle makes {@code +} join the two chars instead of adding their codes.
     */
    public static void main(String[] args) {
        String word = "drawer";
        String result = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            result += word.charAt(i);
        }
        System.out.println(result);
        System.out.println(word.charAt(1) + "" + word.charAt(4));
    }
}
