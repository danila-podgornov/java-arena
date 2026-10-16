// AI-Generated
package module16_working_with_strings_ai.step06_data_in_a_fixed_format_ai;

public class Challenge03Ai {
    /**
     * What does this program print? Watch when the parts are text and when they're numbers.
     * Hints
     * 1. Two semicolons cut the line into three parts: {@code Ana}, {@code 3} and {@code 4}.
     * 2. {@code parts[1] + parts[2]} joins two Strings. Only after {@code Integer.valueOf} are they numbers that {@code +} adds up.
     */
    public static void main(String[] args) {
        String line = "Ana;3;4";
        String[] parts = line.split(";");
        System.out.println(parts.length);
        System.out.println(parts[1] + parts[2]);
        int sum = Integer.valueOf(parts[1]) + Integer.valueOf(parts[2]);
        System.out.println(parts[0] + " " + sum);
    }
}
