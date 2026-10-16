// AI-Generated
package module52_drawing_images_and_sound_ai.step05_tiling_an_image_ai.challenge02_ai;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class Main {
    /**
     * In {@code Tiles.java}, write the method {@code public static WritableImage tile(Image source, int across, int down)}: it returns a new image with the source repeated {@code across} times side by side and {@code down} times one under another. Both are at least 1.
     * <p>{@code Main.java} has the methods of step 4's challenge to try it with: {@code sample(width, height)} makes an image whose pixel (x, y) has red {@code x * 30} and green {@code y * 60}, and {@code describe(image)} prints the size and the colors. The check calls:
     * {@code describe(Tiles.tile(sample(3, 2), 2, 1));}
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * 6 x 2
     * 0x000000ff 0x1e0000ff 0x3c0000ff 0x000000ff 0x1e0000ff 0x3c0000ff
     * 0x003c00ff 0x1e3c00ff 0x3c3c00ff 0x003c00ff 0x1e3c00ff 0x3c3c00ff
     * }</pre>
     * Hints
     * 1. The result is {@code across * w} wide and {@code down * h} high, where {@code w} and {@code h} are the source's size as ints.
     * 2. For each pixel (x, y) of the result, the color is the source's {@code reader.getColor(x % w, y % h)}. Return the new image at the end.
     */
    public static void main(String[] args) {
        describe(Tiles.tile(sample(3, 2), 2, 1));
    }

    // An image to try things on: pixel (x, y) has red x * 30 and green y * 60.
    public static WritableImage sample(int width, int height) {
        WritableImage image = new WritableImage(width, height);
        PixelWriter writer = image.getPixelWriter();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                writer.setColor(x, y, Color.rgb(x * 30, y * 60, 0));
            }
        }
        return image;
    }

    // Prints the size, then the color of every pixel, a row on each line.
    public static void describe(Image image) {
        int width = (int) image.getWidth();
        int height = (int) image.getHeight();
        System.out.println(width + " x " + height);
        PixelReader reader = image.getPixelReader();
        for (int y = 0; y < height; y++) {
            String row = "";
            for (int x = 0; x < width; x++) {
                row += " " + reader.getColor(x, y);
            }
            System.out.println(row.trim());
        }
    }
}
