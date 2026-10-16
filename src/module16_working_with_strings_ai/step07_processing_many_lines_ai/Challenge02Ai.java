// AI-Generated
package module16_working_with_strings_ai.step07_processing_many_lines_ai;

public class Challenge02Ai {
    /**
     * Write a method {@code coldest(String[] lines)} that gets lines in the form {@code city,temperature} and returns the coldest city with its temperature in parentheses. The temperatures are whole numbers, and some can be below zero. The check runs this and expects the output below:
     * <pre>{@code
     * String[] lines = {"Lisbon,14", "Oslo,-3", "Rome,11"};
     * System.out.println(coldest(lines));
     * }</pre>
     * {@code Oslo (-3)}
     * Hints
     * 1. Keep the lowest temperature so far, and its city, in two variables. Start the temperature from a number no city will beat, such as 1000, so the first line always replaces it.
     * 2. For each line: split it, and {@code if (temperature < lowest) { lowest = temperature; city = parts[0]; }}. After the loop, return {@code city + " (" + lowest + ")"}.
     */
    public static void main(String[] args) {
        String[] lines = {"Lisbon,14", "Oslo,-3", "Rome,11"};
        System.out.println(coldest(lines));
    }

    // Write the coldest method here.
}
