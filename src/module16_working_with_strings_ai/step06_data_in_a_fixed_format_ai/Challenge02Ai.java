// AI-Generated
package module16_working_with_strings_ai.step06_data_in_a_fixed_format_ai;

public class Challenge02Ai {
    /**
     * Write a method {@code toMinutes(String time)} that turns a length of time written as hours and minutes, such as {@code 2:45}, into minutes. There may be spaces around the numbers, as in {@code 1 : 15}. The check runs {@code System.out.println(toMinutes("2:45"));} and expects: see the expected output below.
     * Expected output
     * {@code 165}
     * Hints
     * 1. Split at the colon: {@code String[] parts = time.split(":");}. Then {@code parts[0]} holds the hours and {@code parts[1]} the minutes.
     * 2. Trim each part before turning it into a number, {@code Integer.valueOf(parts[0].trim())}, and return {@code hours * 60 + minutes}.
     */
    public static void main(String[] args) {
        System.out.println(toMinutes("2:45"));
    }

    // Write the toMinutes method here.
}
