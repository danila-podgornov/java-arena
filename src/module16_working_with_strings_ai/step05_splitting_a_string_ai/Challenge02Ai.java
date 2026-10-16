// AI-Generated
package module16_working_with_strings_ai.step05_splitting_a_string_ai;

public class Challenge02Ai {
    /**
     * Write a method {@code fileName(String path)} that returns the last part of a path: the part after the last {@code /}. A path without any {@code /} is a file name already. The check runs {@code System.out.println(fileName("photos/2025/beach.jpg"));} and expects: see the expected output below.
     * Expected output
     * {@code beach.jpg}
     * Hints
     * 1. {@code String[] parts = path.split("/");} cuts the path at every slash.
     * 2. The last part has the index {@code parts.length - 1}. A path without a slash splits into one part, which is then the last one too.
     */
    public static void main(String[] args) {
        System.out.println(fileName("photos/2025/beach.jpg"));
    }

    // Write the fileName method here.
}
