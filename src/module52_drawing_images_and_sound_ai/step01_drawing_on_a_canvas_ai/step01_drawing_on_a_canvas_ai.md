> [!info] AI-Generated

# Drawing on a canvas

Module 51 drew charts, and JavaFX decided where each line and bar went. This module draws by itself. A **canvas** is an empty area of a window that a program draws on: rectangles, ovals and lines, wherever it wants them and in the colors it picks. Then come **images**: pictures from files, read and changed one pixel at a time. Sound comes at the end.

## Drawings and images in Java Arena

As with the windows of part 13 (module 48 explained it) and the charts of module 51, Java Arena's JavaFX is a practice version written for this site, and the page draws the window from what your program told JavaFX. A canvas here keeps a list of what the program drew on it, in order and with the colors, and the page draws that list for you, approximately: real JavaFX smooths the edges of shapes in its own way. Under each drawing, "The window as text" lists every call, and that list is what the challenges compare. The check that runs every model solution on real JavaFX (module 48) also draws each canvas's recorded calls again on real JavaFX and compares the result with the real canvas, pixel by pixel, and it compares every pixel of each image. What it doesn't check is how this page draws the list.

Images are different: they're read and written **pixel by pixel, exactly**, and the challenges compare every pixel. The images that this module's programs read are small pictures that Java Arena makes for its lessons. Sound can't play on this page at all: step 7 shows sound code to read, and the MOOC's exercise with sound needs your own computer.

## A canvas and its pen

A rowing club (made up for this lesson) wants its flag on a screen:

```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Canvas canvas = new Canvas(150, 100);
        GraphicsContext pen = canvas.getGraphicsContext2D();
        pen.setFill(Color.NAVY);
        pen.fillRect(0, 0, 150, 100);
        pen.setFill(Color.WHITE);
        pen.fillRect(0, 40, 150, 20);
        pen.setFill(Color.GOLD);
        pen.fillOval(55, 30, 40, 40);

        stage.setScene(new Scene(new Pane(canvas)));
        stage.setTitle("Rowing club");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

- `new Canvas(150, 100)` is a canvas 150 pixels wide and 100 pixels high. It's a node, like a label, so it goes into a layout. `Pane` (from `javafx.scene.layout`) is the plainest layout: it shows its children and doesn't arrange them, and a canvas needs nothing more.
- `canvas.getGraphicsContext2D()` returns the canvas's **GraphicsContext**: the object that draws on it, so the code calls it `pen`. Each canvas has one, and the method always returns the same object.
- `setFill(Color.NAVY)` picks the color for the drawing that follows. The pen keeps it until the next `setFill`.
- `fillRect(x, y, width, height)` fills a rectangle whose top left corner is at (x, y).
- `fillOval(x, y, width, height)` fills the oval that just fits inside that same rectangle. A width equal to the height gives a circle: here one 40 pixels across.

## Where the pixels are

Every point of the canvas has an **x** and a **y**, counted in pixels from the **top left corner**, which is (0, 0). x grows to the right, as in a math class, but y grows **down**: (0, 40) is 40 pixels below the corner. So the white stripe starts 40 pixels from the top and is 20 high, and the flag's last row of pixels is at y 99.

An oval is given by its rectangle, not by its center. A circle with its center at (75, 50) and a radius of 20 fits in the square from (55, 30), 40 wide and 40 high: `fillOval(75 - 20, 50 - 20, 40, 40)`. That's the gold circle, in the middle of the flag.

**Order matters.** Each call draws over what's already there, like paint. The navy rectangle comes first and covers the whole canvas, the stripe goes over it, and the circle over the stripe. With the navy rectangle drawn last, the flag would be all navy.

## The window as text

For a canvas, "The window as text" lists every drawing call, in order, with its numbers and the color it used:

```text
Window "Rowing club"
  Pane
    Canvas 150 x 100
      fillRect 0 0 150 100, fill #000080
      fillRect 0 40 150 20, fill #ffffff
      fillOval 55 30 40 40, fill #ffd700
```

Colors are written as `#` and six hexadecimal digits: two for red, two for green and two for blue, from `00` (none) to `ff` (all). `#000080` is navy: no red, no green, half the blue. The challenges compare these lines exactly, so a picture that looks the same but is drawn with other calls doesn't pass: a task always says which shapes to draw, where, in which colors and in what order.

## Colors

The class `Color` (from `javafx.scene.paint`) gives colors in four ways:

- By name: `Color.RED`, `Color.NAVY`, `Color.GOLD`, `Color.DARKGREEN`. JavaFX has 147 of the color names that web pages use, plus `Color.TRANSPARENT`.
- By their amounts of red, green and blue, each from 0 to 255: `Color.rgb(255, 128, 0)` is orange (all the red, half the green, no blue). Screens mix light, so `Color.rgb(255, 255, 0)` is yellow, `Color.rgb(0, 0, 0)` black and `Color.rgb(255, 255, 255)` white.
- By the code that web pages use: `Color.web("#e63946")`.
- With `new Color(red, green, blue, opacity)`, each amount a double from 0.0 to 1.0: `new Color(1.0, 0.5, 0.0, 1.0)` is orange too. An amount outside that range throws an IllegalArgumentException.

Printing a color shows its code with its **opacity** at the end: `System.out.println(Color.rgb(255, 128, 0))` prints `0xff8000ff`, where the last `ff` means fully opaque.

## Lines and outlines

Next to the fill color, the pen has a **stroke** color for lines and outlines, and a line width. A cottage with a window:

```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Canvas canvas = new Canvas(160, 140);
        GraphicsContext pen = canvas.getGraphicsContext2D();
        pen.setFill(Color.BURLYWOOD);
        pen.fillRect(30, 60, 100, 70);
        pen.setFill(Color.FIREBRICK);
        double[] roofX = {20, 80, 140};
        double[] roofY = {60, 15, 60};
        pen.fillPolygon(roofX, roofY, 3);
        pen.setFill(Color.SADDLEBROWN);
        pen.fillRect(90, 90, 20, 40);

        pen.setStroke(Color.BLACK);
        pen.setLineWidth(2);
        pen.strokeRect(45, 75, 24, 24);
        pen.strokeLine(57, 75, 57, 99);
        pen.strokeLine(45, 87, 69, 87);

        stage.setScene(new Scene(new Pane(canvas)));
        stage.setTitle("Cottage");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

- `setStroke(Color.BLACK)` and `setLineWidth(2)` set the color and the width (in pixels) of what the stroke methods draw. A new pen strokes in black, 1 pixel wide, and fills in black too.
- `strokeRect(x, y, width, height)` draws only the outline of a rectangle, and `strokeOval` the outline of an oval.
- `strokeLine(x1, y1, x2, y2)` draws a line from (x1, y1) to (x2, y2). The two lines here make the cross of the window.
- `fillPolygon(xs, ys, count)` fills a shape with corners: the first `count` values of the array `xs` are the corners' x values, and those of `ys` their y values, in the same order. The roof is a triangle with corners (20, 60), (80, 15) and (140, 60). `strokePolygon` draws its outline.

In the window as text, a stroke call shows its stroke color and width (`strokeLine 57 75 57 99, stroke #000000, width 2`), and the polygon its corners.

## Shapes in a loop

The numbers can be computed, so a loop can draw a row of shapes. A weather map shows a scale of six squares, from yellow for warm to red for hot:

```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Canvas canvas = new Canvas(180, 30);
        GraphicsContext pen = canvas.getGraphicsContext2D();
        for (int i = 0; i < 6; i++) {
            pen.setFill(Color.rgb(255, 220 - i * 40, 0));
            pen.fillRect(i * 30, 0, 30, 30);
        }

        stage.setScene(new Scene(new Pane(canvas)));
        stage.setTitle("Heat scale");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

Square `i` starts at x `i * 30`, right where the one before it ends, and each square has 40 less green than the one before, which turns yellow into red step by step.

---

Source: [Drawing on a canvas](https://javaarena.com/learn/drawing-and-images/canvas/) in the module [Drawing, images and sound](https://javaarena.com/learn/drawing-and-images/) on Java Arena.

This module follows section [14.2 Multimedia in programs](https://java-programming.mooc.fi/part-14/2-multimedia-in-programs) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
