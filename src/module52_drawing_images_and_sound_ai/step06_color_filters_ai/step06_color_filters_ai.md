> [!info] AI-Generated

# Color filters

The filters of a photo app change the colors of a picture: black and white, a warm old-photo look, a negative. Each one is a rule that takes a pixel's color and gives a new color, and the program applies it to every pixel, with the same two loops as a copy.

## The negative

In a photo's **negative**, light becomes dark and each color becomes its opposite: each of red, green and blue becomes 255 minus itself. Black (0, 0, 0) turns white (255, 255, 255), and red (255, 0, 0) turns cyan (0, 255, 255). Color has a method for it: `invert()` returns the color whose amounts are 1.0 minus the color's own. That's the same rule with amounts from 0.0 to 1.0, and it gives the same pixels. The sunset and its negative:

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
        PixelReader reader = photo.getPixelReader();
        int width = (int) photo.getWidth();
        int height = (int) photo.getHeight();

        WritableImage negative = new WritableImage(width, height);
        PixelWriter writer = negative.getPixelWriter();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                writer.setColor(x, y, reader.getColor(x, y).invert());
            }
        }

        stage.setScene(new Scene(new HBox(10, new ImageView(photo), new ImageView(negative))));
        stage.setTitle("Negative");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

The orange sky turns blue, and the dark hills light.

## Two kinds of gray

A pixel is gray when its red, green and blue are equal: (0, 0, 0) is black, (128, 128, 128) a middle gray, and (255, 255, 255) white. To turn a color into a gray, the program picks one number for all three, and there are two common ways:

- The **average** of the three: `(red + green + blue) / 3`.
- The way JavaFX's `grayscale()` does it: 21% of the red, 71% of the green and 7% of the blue. People see green as much brighter than blue, so a pure green should become a light gray and a pure blue a dark one.

They don't agree, and pure green shows it best:

```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Color green = Color.rgb(0, 255, 0);
        int red = (int) Math.round(green.getRed() * 255);
        int greenAmount = (int) Math.round(green.getGreen() * 255);
        int blue = (int) Math.round(green.getBlue() * 255);
        int average = (red + greenAmount + blue) / 3;
        System.out.println("average: " + Color.rgb(average, average, average));
        System.out.println("grayscale(): " + green.grayscale());

        stage.setScene(new Scene(new Label("Two kinds of gray")));
        stage.setTitle("Gray");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

**Output**

```text
average: 0x555555ff
grayscale(): 0xb5b5b5ff
```

The average makes it 85 (`55` in hexadecimal), a dark gray, while `grayscale()` makes it 181 (`b5`), a light one. Neither is wrong, but a picture comes out differently, so the challenges always say which one to use. Here are the colored squares of `blocks.png`, by the average and then by `grayscale()`:

**The image blocks.png**

![blocks.png](blocks.png)

```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Image blocks = new Image("file:blocks.png");
        PixelReader reader = blocks.getPixelReader();
        int width = (int) blocks.getWidth();
        int height = (int) blocks.getHeight();

        WritableImage byAverage = new WritableImage(width, height);
        WritableImage byGrayscale = new WritableImage(width, height);
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color color = reader.getColor(x, y);
                byAverage.getPixelWriter().setColor(x, y, average(color));
                byGrayscale.getPixelWriter().setColor(x, y, color.grayscale());
            }
        }

        stage.setScene(new Scene(new HBox(10, new ImageView(byAverage), new ImageView(byGrayscale))));
        stage.setTitle("Grays");
        stage.show();
    }

    public static Color average(Color color) {
        int red = (int) Math.round(color.getRed() * 255);
        int green = (int) Math.round(color.getGreen() * 255);
        int blue = (int) Math.round(color.getBlue() * 255);
        int gray = (red + green + blue) / 3;
        return Color.rgb(gray, gray, gray);
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

A rule for one color fits well in a method of its own, like `average` here: the loops stay the same for every filter, and only the method changes. The rule works with whole numbers from 0 to 255, and the division `/ 3` is a whole-number division. Look at the top row: by the average, the green square (64) comes out darker than the blue one (106), while by `grayscale()` the green (136) is much lighter than the blue (63), as your eyes see them.

## Black and white

A **threshold** turns every pixel either black or white: a pixel whose average is at least some limit becomes white, and every other pixel black. With a limit of 128, the landscape becomes a stencil:

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
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Image landscape = new Image("file:landscape.png");
        PixelReader reader = landscape.getPixelReader();
        int width = (int) landscape.getWidth();
        int height = (int) landscape.getHeight();

        WritableImage stencil = new WritableImage(width, height);
        PixelWriter writer = stencil.getPixelWriter();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color color = reader.getColor(x, y);
                int red = (int) Math.round(color.getRed() * 255);
                int green = (int) Math.round(color.getGreen() * 255);
                int blue = (int) Math.round(color.getBlue() * 255);
                if ((red + green + blue) / 3 >= 128) {
                    writer.setColor(x, y, Color.WHITE);
                } else {
                    writer.setColor(x, y, Color.BLACK);
                }
            }
        }

        stage.setScene(new Scene(new HBox(10, new ImageView(landscape), new ImageView(stencil))));
        stage.setTitle("Stencil");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

A lower limit makes more of the picture white, and a higher one more of it black.

## Tints

A **tint** shows a picture's grays in one color. Take the gray amount `g` of each pixel and use it for some of the color's amounts and not others: `Color.rgb(g, 0, 0)` shows the picture in shades of red, from black where it's dark to bright red where it's light. An old-photo brown is `Color.rgb(g, g * 3 / 4, g / 2)`: all the red, three quarters of the green and half the blue. A gray of 200 becomes (200, 150, 100).

---

Source: [Color filters](https://javaarena.com/learn/drawing-and-images/color-filters/) in the module [Drawing, images and sound](https://javaarena.com/learn/drawing-and-images/) on Java Arena.

This module follows section [14.2 Multimedia in programs](https://java-programming.mooc.fi/part-14/2-multimedia-in-programs) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
