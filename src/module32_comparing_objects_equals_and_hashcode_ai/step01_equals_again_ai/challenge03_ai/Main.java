// AI-Generated
package module32_comparing_objects_equals_and_hashcode_ai.step01_equals_again_ai.challenge03_ai;

import java.util.ArrayList;

public class Main {
    /**
     * A drawing program keeps the color of every pixel of a small picture in a list. A color is three numbers from 0 to 255: how much red, green and blue it has. In {@code Color.java}, write {@code equals}: two colors are equal when all three numbers are the same. Then, in {@code Main.java}, write the method {@code countColors(ArrayList<Color> pixels)}, which returns how many different colors the picture uses. Keep a second list of the colors seen so far, and add a pixel's color to it only when an equal color isn't there yet. The check runs:
     * <pre>{@code
     * ArrayList<Color> pixels = new ArrayList<>();
     * pixels.add(new Color(255, 0, 0));
     * pixels.add(new Color(0, 0, 255));
     * pixels.add(new Color(255, 0, 0));
     * pixels.add(new Color(255, 255, 255));
     * pixels.add(new Color(0, 0, 255));
     * System.out.println(countColors(pixels));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * {@code 3}
     * Hints
     * 1. Color's {@code equals} is the classic one, with Color in place of Seat. All three values are ints, so the last line is {@code return this.red == other.red && this.green == other.green && this.blue == other.blue;}.
     * 2. In {@code countColors}, make an {@code ArrayList<Color> seen}, go through the pixels with a for-each loop, and add a pixel to {@code seen} when {@code !seen.contains(pixel)}. The answer is {@code seen.size()}. Without {@code equals}, {@code contains} finds nothing, and every pixel counts as a new color.
     */
    public static void main(String[] args) {
        ArrayList<Color> pixels = new ArrayList<>();
        pixels.add(new Color(255, 0, 0));
        pixels.add(new Color(0, 0, 255));
        pixels.add(new Color(255, 0, 0));
        pixels.add(new Color(255, 255, 255));
        pixels.add(new Color(0, 0, 255));
        System.out.println(countColors(pixels));
    }

    // Write the method countColors here.
}
