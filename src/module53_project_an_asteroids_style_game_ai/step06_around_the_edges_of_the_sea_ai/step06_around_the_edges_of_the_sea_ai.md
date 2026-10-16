> [!info] AI-Generated

# Around the edges of the sea

So far, the submarine and the jellyfish drift out of the window and never come back. In games like this one, the edges **wrap around**: something that leaves on the right comes back on the left, and something that sinks out at the bottom comes back at the top.

## The window's size, in one place

Wrapping needs the window's width and height, and not only `Main` needs them: Mover's `move` does too. So they become **constants** of `Main`: variables that belong to the class itself rather than to an object (`static`, like the static methods of the first modules) and that can never change (`final`: assigning to one doesn't compile). By custom, a constant's name is in capital letters, like an enum's constants:

```java
public class Main extends Application {
    public static final int WIDTH = 360;
    public static final int HEIGHT = 240;
    ...
        pane.setPrefSize(WIDTH, HEIGHT);
```

Any class can now read `Main.WIDTH` and `Main.HEIGHT`, and a bigger sea is a change in one place.

## Wrapping a number

Wrapping x into the width 360 means: 370 becomes 10, -10 becomes 350, and 100 stays 100. The remainder operator `%` does most of it, but in Java a remainder has the **sign of the number divided**, so a negative x gives a negative remainder:

```java
System.out.println(370 % 360);
System.out.println(-10 % 360);
System.out.println(-10.5 % 360);
System.out.println(-10.5 % 360 + 360);
System.out.println(370.5 % 360);
```

**Output**

```text
10
-10
-10.5
349.5
10.5
```

`%` works for doubles too. `value % size` is between `-size` and `size`: a value that was positive gives a remainder from 0 up to `size`, which is already right, and only a negative remainder needs `size` added to it. So this method wraps a value, positive or negative, into the sea (a value already inside stays exactly as it is):

```java
public static double wrap(double value, double size) {
    double result = value % size;
    if (result < 0) {
        result = result + size;
    }
    return result;
}
```

For whole numbers Java has `Math.floorMod(-10, 360)`, which gives 350; it takes `int` and `long` values, and a game's positions are doubles, so `wrap` does it by hand.

## Wrapping in move

Every Mover moves in `move`, so that's the one place to wrap, and the submarine, the jellyfish and later the bubbles all wrap at once:

```java
public void move() {
    shape.setTranslateX(Main.wrap(shape.getTranslateX() + velocity.getX(), Main.WIDTH));
    shape.setTranslateY(Main.wrap(shape.getTranslateY() + velocity.getY(), Main.HEIGHT));
}
```

**Main.java**

```java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {
    public static final int WIDTH = 360;
    public static final int HEIGHT = 240;

    private Map<KeyCode, Boolean> held = new HashMap<>();

    @Override
    public void start(Stage stage) {
        Pane pane = new Pane();
        pane.setPrefSize(WIDTH, HEIGHT);
        pane.getChildren().add(new Rectangle(WIDTH, HEIGHT, Color.MIDNIGHTBLUE));

        Sub sub = new Sub(180, 120);
        pane.getChildren().add(sub.getShape());
        List<Jellyfish> jellyfish = new ArrayList<>();
        jellyfish.add(new Jellyfish(30, 200, 135));
        jellyfish.add(new Jellyfish(330, 30, -60));
        jellyfish.forEach(j -> pane.getChildren().add(j.getShape()));

        Scene scene = new Scene(pane);
        scene.setOnKeyPressed(event -> held.put(event.getCode(), true));
        scene.setOnKeyReleased(event -> held.put(event.getCode(), false));

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (held.getOrDefault(KeyCode.LEFT, false)) {
                    sub.turn(-4);
                }
                if (held.getOrDefault(KeyCode.RIGHT, false)) {
                    sub.turn(4);
                }
                if (held.getOrDefault(KeyCode.UP, false)) {
                    sub.accelerate(0.125);
                }
                sub.move();
                jellyfish.forEach(j -> j.move());
            }
        }.start();

        stage.setScene(scene);
        stage.setTitle("Around the edges");
        stage.show();
    }

    public static double wrap(double value, double size) {
        double result = value % size;
        if (result < 0) {
            result = result + size;
        }
        return result;
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

**Mover.java**

```java
import javafx.geometry.Point2D;
import javafx.scene.shape.Shape;

public abstract class Mover {
    private Shape shape;
    private Point2D velocity;

    public Mover(Shape shape, double x, double y) {
        this.shape = shape;
        this.shape.setTranslateX(x);
        this.shape.setTranslateY(y);
        this.velocity = new Point2D(0, 0);
    }

    public Shape getShape() {
        return shape;
    }

    public void turn(double degrees) {
        shape.setRotate(shape.getRotate() + degrees);
    }

    public void accelerate(double amount) {
        double angle = Math.toRadians(shape.getRotate());
        velocity = velocity.add(Math.cos(angle) * amount, Math.sin(angle) * amount);
    }

    public void move() {
        shape.setTranslateX(Main.wrap(shape.getTranslateX() + velocity.getX(), Main.WIDTH));
        shape.setTranslateY(Main.wrap(shape.getTranslateY() + velocity.getY(), Main.HEIGHT));
    }

    public boolean collides(Mover other) {
        Shape overlap = Shape.intersect(shape, other.getShape());
        return overlap.getBoundsInLocal().getWidth() != -1;
    }
}
```

**Sub.java**

```java
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class Sub extends Mover {

    public Sub(double x, double y) {
        super(new Polygon(-15, -6, 9, -6, 15, 0, 9, 6, -15, 6), x, y);
        getShape().setFill(Color.GOLD);
    }
}
```

**Jellyfish.java**

```java
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class Jellyfish extends Mover {

    public Jellyfish(double x, double y, double heading) {
        super(new Polygon(-10, 0, -6, -8, 0, -10, 6, -8, 10, 0, 7, 10, 3, 2, 0, 10, -3, 2, -7, 10), x, y);
        getShape().setFill(Color.ORCHID);
        turn(heading);
        accelerate(0.5);
    }

    @Override
    public void move() {
        super.move();
        turn(1);
    }
}
```

```text
press key LEFT
frames 45
release key LEFT
press key UP
frames 24
release key UP
frames 60
```

The submarine turns around to -180 degrees (pointing left), speeds up to 3 pixels a frame and leaves on the left: its x passes 0 and goes on from 360, so it ends at (322.5, 120). The jellyfish leave at the bottom left and the top right and come back on the other sides. What's wrapped is the translate, the shape's center, so a shape is cut in half at an edge for a moment before it jumps over; the MOOC's game does the same, and it's barely visible at 60 frames a second. On a phone the sea is wider than the screen: scroll the window sideways to see its right edge, where the shapes come back.

---

Source: [Around the edges of the sea](https://javaarena.com/learn/asteroids/edges/) in the module [Project: an Asteroids-style game](https://javaarena.com/learn/asteroids/) on Java Arena.

This module follows section [14.3 Larger application: Asteroids](https://java-programming.mooc.fi/part-14/3-larger-application-asteroids) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
