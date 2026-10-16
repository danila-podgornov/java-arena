> [!info] AI-Generated

# Making an image smaller

A photo gallery shows small copies of its photos, **thumbnails**, so that many fit on a screen. This step makes them, pixel by pixel.

## Every second pixel

The simplest way to make an image half as wide and half as high: keep every second pixel of every second row, and drop the rest. Pixel (x, y) of the small image is pixel (2x, 2y) of the big one:

| x in the small image | 0 | 1 | 2 | 3 |
| --- | --- | --- | --- | --- |
| x in the big image | 0 | 2 | 4 | 6 |

The same goes for y. So the loops go through the pixels of the **small** image, and each one reads its color from the big one:

**The image landscape.png**

![landscape.png](landscape.png)

```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Image original = new Image("file:landscape.png");
        PixelReader reader = original.getPixelReader();
        int width = (int) original.getWidth() / 2;
        int height = (int) original.getHeight() / 2;

        WritableImage half = new WritableImage(width, height);
        PixelWriter writer = half.getPixelWriter();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                writer.setColor(x, y, reader.getColor(2 * x, 2 * y));
            }
        }

        stage.setScene(new Scene(new HBox(10, new ImageView(original), new ImageView(half))));
        stage.setTitle("Half size");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

- `(int) original.getWidth() / 2`: the cast comes first, so this is 32 / 2, which is 16. The thumbnail is 16 x 12.
- Each pixel of the thumbnail is set exactly once. Going through the big image's pixels instead would need a check for the ones to keep.
- The page draws the small image more times larger than the big one, so on the page they can look about the same size. The window as text gives their real sizes.

Dropping pixels loses detail: a thin line one pixel wide can vanish from the thumbnail. Photo editors usually work out each small pixel from the colors of all the pixels it replaces (their average, for example), which looks smoother. Keeping every second pixel is the simplest way, and the one these lessons use.

## A method that makes the thumbnail

Making a thumbnail is a job of its own, so it fits in a method, in a class without anything about windows: the image goes in, and a new image comes out. A WritableImage is an Image, so the method can be given either kind:

```java
public static WritableImage half(Image source) {
    PixelReader reader = source.getPixelReader();
    int width = (int) source.getWidth() / 2;
    int height = (int) source.getHeight() / 2;
    WritableImage small = new WritableImage(width, height);
    PixelWriter writer = small.getPixelWriter();
    for (int y = 0; y < height; y++) {
        for (int x = 0; x < width; x++) {
            writer.setColor(x, y, reader.getColor(2 * x, 2 * y));
        }
    }
    return small;
}
```

A WritableImage can be made without any window, so a plain program can try the method on a tiny image whose colors it knows, and check what comes out. Here a 4 x 2 image gets shades of red in its first row and shades of green in its second:

**Main.java**

```java
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class Main {
    public static void main(String[] args) {
        WritableImage strip = new WritableImage(4, 2);
        PixelWriter writer = strip.getPixelWriter();
        for (int x = 0; x < 4; x++) {
            writer.setColor(x, 0, Color.rgb(x * 50, 0, 0));
            writer.setColor(x, 1, Color.rgb(0, x * 50, 0));
        }

        WritableImage small = Thumbnail.half(strip);
        System.out.println(small.getWidth() + " x " + small.getHeight());
        System.out.println(small.getPixelReader().getColor(0, 0));
        System.out.println(small.getPixelReader().getColor(1, 0));
    }
}
```

**Thumbnail.java**

```java
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;

public class Thumbnail {

    public static WritableImage half(Image source) {
        PixelReader reader = source.getPixelReader();
        int width = (int) source.getWidth() / 2;
        int height = (int) source.getHeight() / 2;
        WritableImage small = new WritableImage(width, height);
        PixelWriter writer = small.getPixelWriter();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                writer.setColor(x, y, reader.getColor(2 * x, 2 * y));
            }
        }
        return small;
    }
}
```

**Output**

```text
2.0 x 1.0
0x000000ff
0x640000ff
```

The thumbnail kept the first row only, and from it the pixels at x 0 and x 2: red 0 and red 100 (`64` in hexadecimal). The challenges with methods check them like this, without a window.

## Smaller by any whole number

Every third pixel makes a thumbnail a third of the size, and every fourth a quarter. With a **factor** `f`, the small image is `width / f` by `height / f`, and its pixel (x, y) is the big one's (x * f, y * f). The division is a whole-number division: the 32 x 24 landscape with a factor of 3 gives 10 x 8. Its 32 columns make 10 groups of 3 with 2 left over, and the leftover columns 30 and 31 are simply dropped. The sunset of `photo.png`, 64 x 48, at a half, a quarter and an eighth of its size:

**The image photo.png**

![photo.png](photo.png)

```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Image photo = new Image("file:photo.png");
        HBox row = new HBox(10);
        for (int factor = 2; factor <= 8; factor *= 2) {
            row.getChildren().add(new ImageView(shrink(photo, factor)));
        }

        stage.setScene(new Scene(row));
        stage.setTitle("Thumbnails");
        stage.show();
    }

    public static WritableImage shrink(Image source, int factor) {
        PixelReader reader = source.getPixelReader();
        int width = (int) source.getWidth() / factor;
        int height = (int) source.getHeight() / factor;
        WritableImage small = new WritableImage(width, height);
        PixelWriter writer = small.getPixelWriter();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                writer.setColor(x, y, reader.getColor(x * factor, y * factor));
            }
        }
        return small;
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

The window as text lists the three image views, 32 x 24, 16 x 12 and 8 x 6. The page draws each of them larger, so compare their pixels: the smaller the copy, the blockier the sunset.

## Into a bigger image

A small copy can also go **inside** another image. A frame shop puts a picture on a mat: a white card as big as the original, with the half-size copy in the middle. The card is a WritableImage painted white, pixel by pixel. Then the copy is written into it shifted: the small image's pixel (x, y) goes to (x + left, y + top), where `left` is a quarter of the width and `top` a quarter of the height, which centers it:

**The image landscape.png**

![landscape.png](landscape.png)

```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Image original = new Image("file:landscape.png");
        PixelReader reader = original.getPixelReader();
        int width = (int) original.getWidth();
        int height = (int) original.getHeight();

        WritableImage card = new WritableImage(width, height);
        PixelWriter writer = card.getPixelWriter();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                writer.setColor(x, y, Color.WHITE);
            }
        }
        int left = width / 4;
        int top = height / 4;
        for (int y = 0; y < height / 2; y++) {
            for (int x = 0; x < width / 2; x++) {
                writer.setColor(x + left, y + top, reader.getColor(2 * x, 2 * y));
            }
        }

        stage.setScene(new Scene(new Pane(new ImageView(card))));
        stage.setTitle("On a mat");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

Writing a pixel a second time replaces its color, as drawing over a canvas does: the white pixels in the middle are overwritten by the picture.

One more way to start: `new WritableImage(reader, width, height)` makes a WritableImage that is already a copy of the image the reader reads (of its top left corner, `width` x `height` pixels). A program that changes a part of a picture starts with such a copy, and writes over the part it changes.

---

Source: [Making an image smaller](https://javaarena.com/learn/drawing-and-images/scaling-down/) in the module [Drawing, images and sound](https://javaarena.com/learn/drawing-and-images/) on Java Arena.

This module follows section [14.2 Multimedia in programs](https://java-programming.mooc.fi/part-14/2-multimedia-in-programs) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
