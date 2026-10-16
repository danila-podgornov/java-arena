// AI-Generated
package module18_getters_tostring_and_bigger_classes_ai.step03_tostring_ai.challenge01_ai;

public class Main {
    /**
     * Add a {@code toString} to the {@code Guitar} class, so a guitar prints as its model, with its number of strings in parentheses. The check creates {@code new Guitar("Lark", 6)} and prints it: see the expected output below.
     * Expected output
     * {@code Lark (6 strings)}
     * Hints
     * 1. The header is <code>public String toString() {</code>, and the method returns the text instead of printing it.
     * 2. {@code return this.model + " (" + this.strings + " strings)";}
     */
    public static void main(String[] args) {
        Guitar guitar = new Guitar("Lark", 6);
        System.out.println(guitar);
    }
}
