// AI-Generated
package module52_drawing_images_and_sound_ai.step06_color_filters_ai.challenge02_ai;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class Main {
    /**
     * In {@code Filters.java}, write two filters, each returning a new image of the source's size:
     * <ul>
     * <li>{@code public static WritableImage negative(Image source)}: each pixel's red, green and blue become 255 minus themselves (or use {@code invert()}, which gives the same pixels)
     * <li>{@code public static WritableImage threshold(Image source, int limit)}: a pixel becomes white ({@code Color.WHITE}) when the average of its red, green and blue, as whole numbers from 0 to 255 and with whole-number division, is at least {@code limit}, and black ({@code Color.BLACK}) otherwise
     * </ul>
     * <p>{@code Main.java} has {@code sample(width, height)} and {@code describe(image)} from the challenges before. The check calls:
     * <pre>{@code
     * describe(Filters.negative(sample(3, 1)));
     * describe(Filters.threshold(sample(4, 2), 30));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * 3 x 1
     * 0xffffffff 0xe1ffffff 0xc3ffffff
     * 4 x 2
     * 0x000000ff 0x000000ff 0x000000ff 0xffffffff
     * 0x000000ff 0xffffffff 0xffffffff 0xffffffff
     * }</pre>
     * Hints
     * 1. Both methods have the same shape as {@code shrink} and {@code tile}: a new WritableImage of the source's size, two loops, and a {@code return} at the end. Only the color written for each pixel differs.
     * 2. The negative writes {@code reader.getColor(x, y).invert()}. The threshold works out {@code (red + green + blue) / 3} with whole numbers and writes {@code Color.WHITE} when it's {@code >= limit}, else {@code Color.BLACK}.
     */
    public static void main(String[] args) {
        describe(Filters.negative(sample(3, 1)));
        describe(Filters.threshold(sample(4, 2), 30));
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
