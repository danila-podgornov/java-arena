// AI-Generated
package module20_reading_files_ai.step09_objects_from_a_file_ai.challenge02_ai;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    /**
     * {@code Recipe.java} is ready. Write a method {@code readRecipes(String fileName, ArrayList<Recipe> recipes)} that reads a file of lines such as {@code pancakes,20} (a recipe and the minutes it takes) and adds a {@code Recipe} for each of them to the list it's given. Some lines are notes with no comma, such as {@code ask Grandma about the pie}: skip them. The method returns how many lines it skipped. If the file can't be read, it prints {@code Error: } and the error's message, and returns 0.
     * <p>The check makes an empty list and calls {@code readRecipes("recipes.txt", recipes)} with the file shown below. It prints what the method returned, the list's size and its first recipe: see the expected output below.
     * Expected output
     * <pre>{@code
     * 1
     * 3
     * pancakes (20 min)
     * }</pre>
     * Hints
     * 1. The method starts <code>public static int readRecipes(String fileName, ArrayList&lt;Recipe&gt; recipes) {</code>. It adds to the caller's list, as in module 14, so it doesn't make a list of its own.
     * 2. A note has no comma, so it splits into one part: {@code if (parts.length < 2) { skipped++; continue; }}. Return {@code skipped} after the {@code try}/{@code catch}, and 0 from the {@code catch} block.
     */
    public static void main(String[] args) {
        ArrayList<Recipe> recipes = new ArrayList<>();
        int skipped = readRecipes("recipes.txt", recipes);
        System.out.println("Skipped lines: " + skipped);
        for (Recipe recipe : recipes) {
            System.out.println(recipe);
        }
    }

    // Write the readRecipes method here.
}
