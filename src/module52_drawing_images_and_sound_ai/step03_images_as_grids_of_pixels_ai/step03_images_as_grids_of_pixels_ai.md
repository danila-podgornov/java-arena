> [!info] AI-Generated

# Images as grids of pixels

A picture on a screen is a grid of tiny squares, the **pixels**, each of one color. Module 47 kept a picture's brightness in a two-dimensional array. JavaFX reads real image files into such grids of colors, lets a program read and change every pixel, and shows the result in a window.

## An image from a file

The pictures in this module are small PNG files that Java Arena draws for its lessons with a program of its own, so that they're the same everywhere. A block like the one below shows the file a lesson's example gets in its folder, with its name and size. Here's `landscape.png`:

**The image landscape.png**

![landscape.png](landscape.png)

```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Image picture = new Image("file:landscape.png");
        System.out.println(picture.getWidth() + " x " + picture.getHeight());

        stage.setScene(new Scene(new Pane(new ImageView(picture))));
        stage.setTitle("Landscape");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

**Output**

```text
32.0 x 24.0
```

- `new Image("file:landscape.png")` reads the file `landscape.png` in the program's folder. The `file:` at the start says that it's a file. (Without it, JavaFX looks for the image among the files that come packed with the program's classes, its resources, instead of in its folder. In Java Arena that throws an IllegalArgumentException, so always write `file:` here.)
- `getWidth()` and `getHeight()` return the size in pixels. They're doubles, as sizes are everywhere in JavaFX: write `(int) picture.getWidth()` for an int to loop with.
- An **ImageView** is a node that shows an Image. The Image holds the pixels, and the view shows them in the window. The classes are in `javafx.scene.image`.

The page draws a small image several times larger with its pixels kept square and sharp, and says how much larger under it. In the window as text, this image view is the line `ImageView 32 x 24, pixels 6315e812`: its size, and then a checksum, a number worked out from every pixel's color. Change a single pixel and the number changes, so the challenges with images compare your picture with the model solution's **pixel by pixel**.

## Reading pixels

`tiny.png` is 6 pixels wide and 4 high, and Java Arena made each of its pixels a known color:

**The image tiny.png**

![tiny.png](tiny.png)

```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Image tiny = new Image("file:tiny.png");
        PixelReader reader = tiny.getPixelReader();
        Color corner = reader.getColor(0, 0);
        System.out.println(corner);
        System.out.println(corner.getRed() + " " + corner.getGreen() + " " + corner.getBlue());

        Color steel = reader.getColor(3, 3);
        System.out.println(steel);
        int red = (int) Math.round(steel.getRed() * 255);
        int green = (int) Math.round(steel.getGreen() * 255);
        int blue = (int) Math.round(steel.getBlue() * 255);
        System.out.println(red + " " + green + " " + blue);

        stage.setScene(new Scene(new Pane(new ImageView(tiny))));
        stage.setTitle("Tiny");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

**Output**

```text
0xff0000ff
1.0 0.0 0.0
0x336699ff
51 102 153
```

- `getPixelReader()` returns the image's **PixelReader**, and `getColor(x, y)` the color of one pixel. x is the column, counted from 0 at the left, and y the row, from 0 at the top, as on a canvas. Note the order: x first, unlike `grid[row][column]` in module 47. A pixel outside the image, such as x 6 here, throws an IndexOutOfBoundsException.
- The top left pixel is pure red: `0xff0000ff`.
- `getRed()`, `getGreen()` and `getBlue()` return the amounts as doubles from 0.0 to 1.0, not 0 to 255. Times 255 and rounded, they're the familiar whole numbers: the pixel at (3, 3) is 51, 102, 153, a steel blue.

## When the file can't be read

A missing file doesn't throw an exception. JavaFX gives an **error image** instead: `isError()` returns `true`, its size is 0 x 0, and `getException()` returns the exception that says what went wrong (for a missing file, a FileNotFoundException). So a program checks before it uses the picture:

```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Image picture = new Image("file:holiday.png");
        System.out.println(picture.isError() + " " + picture.getWidth());
        if (picture.isError()) {
            stage.setScene(new Scene(new Label("The picture couldn't be read.")));
        } else {
            stage.setScene(new Scene(new Pane(new ImageView(picture))));
        }
        stage.setTitle("Holiday");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

**Output**

```text
true 0.0
```

An error image has no pixels to read: its `getPixelReader()` returns `null`.

## Writing pixels

A **WritableImage** is an image whose pixels a program sets. `new WritableImage(width, height)` makes one in which every pixel is fully transparent at first, and its `getPixelWriter()` returns a **PixelWriter**, whose `setColor(x, y, color)` sets one pixel. A WritableImage is an Image too (the class extends Image), so an ImageView shows it.

A copy of the landscape with a one-pixel crimson frame around it: the loops go through every pixel, row by row as in module 47, and each pixel on the edge gets the frame's color, while the others get the original's:

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
        Image original = new Image("file:landscape.png");
        PixelReader reader = original.getPixelReader();
        int width = (int) original.getWidth();
        int height = (int) original.getHeight();

        WritableImage framed = new WritableImage(width, height);
        PixelWriter writer = framed.getPixelWriter();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (x == 0 || y == 0 || x == width - 1 || y == height - 1) {
                    writer.setColor(x, y, Color.CRIMSON);
                } else {
                    writer.setColor(x, y, reader.getColor(x, y));
                }
            }
        }

        stage.setScene(new Scene(new HBox(10, new ImageView(original), new ImageView(framed))));
        stage.setTitle("Frame");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

The original isn't changed: an Image read from a file can't be written to. The framed picture is a new image with pixels of its own.

A WritableImage doesn't need a file at all. Here every pixel's color is worked out from where it is, which makes a smooth blend of colors:

```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        WritableImage blend = new WritableImage(16, 16);
        PixelWriter writer = blend.getPixelWriter();
        for (int y = 0; y < 16; y++) {
            for (int x = 0; x < 16; x++) {
                writer.setColor(x, y, Color.rgb(x * 16, 100, y * 16));
            }
        }

        stage.setScene(new Scene(new Pane(new ImageView(blend))));
        stage.setTitle("Blend");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

Red grows from left to right (from 0 to 240) and blue from top to bottom.

## Clicking on an image

An image view takes the mouse as a canvas does. On an image view, `getX()` and `getY()` are in the image's own pixels, however large the page draws it, so `(int) event.getX()` is the column of the pixel that was clicked. A program that tells the color of the pixel you click:

**The image tiny.png**

![tiny.png](tiny.png)

```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Image tiny = new Image("file:tiny.png");
        PixelReader reader = tiny.getPixelReader();
        ImageView view = new ImageView(tiny);
        view.setOnMouseClicked(event -> {
            int x = (int) event.getX();
            int y = (int) event.getY();
            System.out.println("(" + x + ", " + y + ") is " + reader.getColor(x, y));
        });

        stage.setScene(new Scene(new Pane(view)));
        stage.setTitle("Tiny");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

```text
click ImageView 1 at 3 3
click ImageView 1 at 0 1
```

**Output**

```text
(3, 3) is 0x336699ff
(0, 1) is 0xffff00ff
```

---

Source: [Images as grids of pixels](https://javaarena.com/learn/drawing-and-images/pixels/) in the module [Drawing, images and sound](https://javaarena.com/learn/drawing-and-images/) on Java Arena.

This module follows section [14.2 Multimedia in programs](https://java-programming.mooc.fi/part-14/2-multimedia-in-programs) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
