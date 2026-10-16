// AI-Generated
package module20_reading_files_ai.step04_when_the_file_is_missing_ai;

public class Challenge03Ai {
    /**
     * What does this program print? Follow it into the {@code catch} block, and out again.
     * Hints
     * 1. {@code Integer.valueOf("x")} throws a {@code NumberFormatException} with the message {@code For input string: "x"}. The loop and the rest of the {@code try} block stop there.
     * 2. {@code 3} is never added, and {@code All added} is skipped. After the {@code catch} block, the last line prints the sum as it was.
     */
    public static void main(String[] args) {
        String[] values = {"12", "7", "x", "3"};
        int sum = 0;
        try {
            for (String value : values) {
                sum += Integer.valueOf(value);
                System.out.println("Sum so far: " + sum);
            }
            System.out.println("All added");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Total: " + sum);
    }
}
