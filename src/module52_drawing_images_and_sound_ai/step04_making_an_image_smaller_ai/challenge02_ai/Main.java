// AI-Generated
package module52_drawing_images_and_sound_ai.step04_making_an_image_smaller_ai.challenge02_ai;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class Main {
    /**
     * In {@code Thumbnails.java}, write the method {@code public static WritableImage shrink(Image source, int factor)}: it returns a new image {@code factor} times smaller, {@code width / factor} by {@code height / factor} (whole-number division), whose pixel (x, y) is the source's pixel (x * factor, y * factor). The factor is at least 1, and never more than the source's width or height.
     * <p>{@code Main.java} has two methods to try it with: {@code sample(width, height)} makes an image whose pixel (x, y) has red {@code x * 30} and green {@code y * 60}, and {@code describe(image)} prints an image's size and then the colors of its pixels, a row on each line. Don't change them. The check calls:
     * {@code describe(Thumbnails.shrink(sample(7, 4), 3));}
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * 2 x 1
     * 0x000000ff 0x5a0000ff
     * }</pre>
     * Hints
     * 1. The new size is {@code (int) source.getWidth() / factor} by {@code (int) source.getHeight() / factor}. Make a WritableImage of that size and get its PixelWriter.
     * 2. For every pixel (x, y) of the new image, {@code writer.setColor(x, y, reader.getColor(x * factor, y * factor));}, and at the end {@code return} the new image.
     */
    public static void main(String[] args) {
        describe(Thumbnails.shrink(sample(7, 4), 3));
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
