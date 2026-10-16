> [!info] AI-Generated

# Drawing with the mouse

A canvas can react to the mouse, as a button reacts to clicks. That turns it into something to draw on.

## Mouse events

A node has four methods for the mouse, each taking an event handler, usually a lambda as in module 49:

| method | its handler runs when |
| --- | --- |
| `setOnMousePressed` | a mouse button goes down on the node |
| `setOnMouseDragged` | the mouse moves while its button is down |
| `setOnMouseReleased` | the button comes up again |
| `setOnMouseClicked` | the button went down and came up on the node: a click |

The handler gets a **MouseEvent** (from `javafx.scene.input`), and `event.getX()` and `event.getY()` say where the mouse was, in the canvas's own coordinates: (0, 0) is the canvas's top left corner, wherever the canvas is in the window. Both are doubles. A test pad that prints every event:

```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Canvas canvas = new Canvas(200, 120);
        canvas.setOnMousePressed(event -> System.out.println("pressed at (" + event.getX() + ", " + event.getY() + ")"));
        canvas.setOnMouseDragged(event -> System.out.println("dragged to (" + event.getX() + ", " + event.getY() + ")"));
        canvas.setOnMouseReleased(event -> System.out.println("released at (" + event.getX() + ", " + event.getY() + ")"));
        canvas.setOnMouseClicked(event -> System.out.println("clicked at (" + event.getX() + ", " + event.getY() + ")"));

        stage.setScene(new Scene(new Pane(canvas)));
        stage.setTitle("Test pad");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

```text
click Canvas 1 at 40 30
press Canvas 1 at 100 60
drag Canvas 1 to 120 70
drag Canvas 1 to 140 80
release Canvas 1 at 140 80
```

**Output**

```text
pressed at (40.0, 30.0)
released at (40.0, 30.0)
clicked at (40.0, 30.0)
pressed at (100.0, 60.0)
dragged to (120.0, 70.0)
dragged to (140.0, 80.0)
released at (140.0, 80.0)
clicked at (140.0, 80.0)
```

The event lines work like part 13's clicks and typing, with a point added. `click Canvas 1 at 40 30` clicks the first canvas of the window at (40, 30). `press`, `drag ... to` and `release` move the mouse one step at a time: here it's pressed at (100, 60), moved with its button down to (120, 70) and then (140, 80), and let go there.

- A click is three events, in this order: pressed, released, clicked.
- A drag runs the dragged handler once for each point the mouse moves to. On a real screen that's every few pixels, so a handler for drags runs often.
- After the drag, JavaFX still counts a **click**: the button went down and came up on the same node. A program that draws on clicks and on drags must keep that in mind.

## Drawing where the mouse is

A game's level editor plants a flower in a meadow at each click: a gold circle 16 pixels across with its center at the mouse, and a small brown center in it. `start` draws the grass first:

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
        Canvas canvas = new Canvas(200, 120);
        GraphicsContext pen = canvas.getGraphicsContext2D();
        pen.setFill(Color.YELLOWGREEN);
        pen.fillRect(0, 0, 200, 120);
        canvas.setOnMouseClicked(event -> {
            double x = event.getX();
            double y = event.getY();
            pen.setFill(Color.GOLD);
            pen.fillOval(x - 8, y - 8, 16, 16);
            pen.setFill(Color.SADDLEBROWN);
            pen.fillOval(x - 3, y - 3, 6, 6);
        });

        stage.setScene(new Scene(new Pane(canvas)));
        stage.setTitle("Meadow");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

```text
click Canvas 1 at 40 30
click Canvas 1 at 100 80
click Canvas 1 at 160 45
```

The handler draws on the same `pen` that `start` used: a canvas keeps everything drawn on it, so each flower is added to the grass and the flowers before it. To center a circle 16 across on the mouse, its square starts 8 pixels to the left of the mouse and 8 above it. In the window as text, the grass's call comes first, then two calls for each click, in the order of the clicks.

## Lines that follow the mouse

To draw a line as the mouse moves, the program joins each point to the one before it with a short line. So it has to remember the last point, from one event to the next. The handlers are lambdas, which can't change a local variable of `start` (module 49), so the point goes in two instance variables. A doodle pad, with buttons for the color and one to wipe it clean:

```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    private double lastX;
    private double lastY;

    @Override
    public void start(Stage stage) {
        Canvas canvas = new Canvas(240, 140);
        GraphicsContext pen = canvas.getGraphicsContext2D();
        pen.setLineWidth(3);
        canvas.setOnMousePressed(event -> {
            this.lastX = event.getX();
            this.lastY = event.getY();
        });
        canvas.setOnMouseDragged(event -> {
            pen.strokeLine(this.lastX, this.lastY, event.getX(), event.getY());
            this.lastX = event.getX();
            this.lastY = event.getY();
        });

        Button black = new Button("Black");
        black.setOnAction(event -> pen.setStroke(Color.BLACK));
        Button red = new Button("Red");
        red.setOnAction(event -> pen.setStroke(Color.RED));
        Button clear = new Button("Clear");
        clear.setOnAction(event -> pen.clearRect(0, 0, canvas.getWidth(), canvas.getHeight()));

        stage.setScene(new Scene(new VBox(new HBox(5, black, red, clear), canvas)));
        stage.setTitle("Doodle pad");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

```text
press Canvas 1 at 20 100
drag Canvas 1 to 60 40
drag Canvas 1 to 100 100
release Canvas 1 at 100 100
click Button "Red"
press Canvas 1 at 140 70
drag Canvas 1 to 180 40
drag Canvas 1 to 220 70
release Canvas 1 at 220 70
```

- Pressing only remembers where the line starts. Each drag draws from the remembered point to the new one, and then remembers the new one, so the short lines join up.
- The color buttons just call `pen.setStroke(...)`. The GraphicsContext keeps its stroke color, so every line drawn after a click on Red is red, until another button changes it.
- `clearRect(x, y, width, height)` wipes a rectangle clean: the canvas there is empty again, as at the start (the window shows through). With the canvas's own size, it wipes everything. In the window as text, a wiped canvas still lists what was drawn before it, followed by the `clearRect` line: the list is the canvas's whole history, in order.

## Drawing yourself

The windows drawn in a lesson show the events listed with them, and can't be clicked. When you run a challenge's code with "Run with my input", or a program in the Playground, you can use its window: on a canvas that has mouse handlers, draw with the mouse or a finger. The page collects the whole movement (the press, a drag every few pixels and the release) and runs your program once with all of it, so the drawing updates when you lift your finger. A tap without moving is a click. With the keyboard, the arrow keys move a point, Enter clicks there, and Space presses there and, after the arrow keys have moved the point, lets go.

---

Source: [Drawing with the mouse](https://javaarena.com/learn/drawing-and-images/mouse/) in the module [Drawing, images and sound](https://javaarena.com/learn/drawing-and-images/) on Java Arena.

This module follows section [14.2 Multimedia in programs](https://java-programming.mooc.fi/part-14/2-multimedia-in-programs) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
