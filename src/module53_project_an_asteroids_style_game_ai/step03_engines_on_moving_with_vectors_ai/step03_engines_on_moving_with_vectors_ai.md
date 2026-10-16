> [!info] AI-Generated

# Engines on: moving with vectors

The submarine turns. Now it needs to move: forward in the direction its nose points, faster while Up is held, and on by itself when Up is let go, the way things drift in water (and fly in space, in the MOOC's game).

## Point2D

A position is two numbers, an x and a y, and so is a movement: "2 pixels right and 1 up in every frame". JavaFX has a class for such pairs, **Point2D** (from `javafx.geometry`). A Point2D is **immutable**, like a String: its methods return a new point and leave the old one as it was.

```java
import javafx.geometry.Point2D;

public class Main {
    public static void main(String[] args) {
        Point2D place = new Point2D(100, 50);
        Point2D velocity = new Point2D(3, -4);

        place.add(velocity);
        System.out.println(place);

        place = place.add(velocity);
        System.out.println(place);
        System.out.println(place.getX() + " and " + place.getY());

        System.out.println(velocity.magnitude());
        System.out.println(velocity.multiply(2));
    }
}
```

**Output**

```text
Point2D [x = 100.0, y = 50.0]
Point2D [x = 103.0, y = 46.0]
103.0 and 46.0
5.0
Point2D [x = 6.0, y = -8.0]
```

- `add(other)` returns a new point with the x values added and the y values added. The first `place.add(velocity)` changes nothing: its result is thrown away. To keep it, assign it: `place = place.add(velocity)`. There's also `add(x, y)` with two numbers.
- `getX()` and `getY()` return the two numbers, as doubles.
- `magnitude()` is the length of the arrow from (0, 0) to the point: the speed, for a velocity. (3, -4) is 5 long, by Pythagoras.
- `multiply(factor)` returns the point with both numbers multiplied.

Point2D is a plain class: as here, a program can use it without a window.

## A velocity, added every frame

A **velocity** says how far something moves in one frame: (1.5, -0.5) is 1.5 pixels right and half a pixel up per frame. In each frame, the game adds the velocity to the position:

```java
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {
    private Point2D velocity = new Point2D(1.5, -0.5);

    @Override
    public void start(Stage stage) {
        Pane pane = new Pane();
        pane.setPrefSize(360, 240);
        Polygon sub = new Polygon(-15, -6, 9, -6, 15, 0, 9, 6, -15, 6);
        sub.setFill(Color.GOLD);
        sub.setTranslateX(100);
        sub.setTranslateY(160);
        pane.getChildren().addAll(new Rectangle(360, 240, Color.MIDNIGHTBLUE), sub);

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                sub.setTranslateX(sub.getTranslateX() + velocity.getX());
                sub.setTranslateY(sub.getTranslateY() + velocity.getY());
            }
        }.start();

        stage.setScene(new Scene(pane));
        stage.setTitle("Drifting");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

```text
frames 80
```

After 80 frames the submarine has moved 80 times 1.5 = 120 pixels right and 40 up, to (220, 120). It drifts sideways, though: it points right but moves up as well. Its velocity should come from where it points.

## Speeding up where the nose points

A submarine turned by an angle `a` points in the direction (cos a, sin a): one step of length 1 that way goes `Math.cos(a)` across and `Math.sin(a)` down. At 0 degrees that's (1, 0), right; at 90 degrees (0, 1), down, since angles grow clockwise on the screen; at 180 degrees (-1, 0), left; and at -90 degrees (0, -1), up. Java's `Math.cos` and `Math.sin` take the angle in **radians**, not degrees, and `Math.toRadians(degrees)` converts it.

So to **accelerate**, a game adds a small step in that direction to the velocity:

```java
double angle = Math.toRadians(sub.getRotate());
velocity = velocity.add(Math.cos(angle) * 0.125, Math.sin(angle) * 0.125);
```

Each frame with Up held adds 0.125 pixels a frame to the speed, in the direction the submarine points. Let go of Up, and the velocity stays: the submarine keeps going. Turning changes only where the next push goes, so a turned submarine curves slowly into its new direction, as in the MOOC's game.

```java
import java.util.HashMap;
import java.util.Map;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {
    private Map<KeyCode, Boolean> held = new HashMap<>();
    private Point2D velocity = new Point2D(0, 0);

    @Override
    public void start(Stage stage) {
        Pane pane = new Pane();
        pane.setPrefSize(360, 240);
        Polygon sub = new Polygon(-15, -6, 9, -6, 15, 0, 9, 6, -15, 6);
        sub.setFill(Color.GOLD);
        sub.setTranslateX(60);
        sub.setTranslateY(120);
        pane.getChildren().addAll(new Rectangle(360, 240, Color.MIDNIGHTBLUE), sub);

        Scene scene = new Scene(pane);
        scene.setOnKeyPressed(event -> held.put(event.getCode(), true));
        scene.setOnKeyReleased(event -> held.put(event.getCode(), false));

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (held.getOrDefault(KeyCode.LEFT, false)) {
                    sub.setRotate(sub.getRotate() - 4);
                }
                if (held.getOrDefault(KeyCode.RIGHT, false)) {
                    sub.setRotate(sub.getRotate() + 4);
                }
                if (held.getOrDefault(KeyCode.UP, false)) {
                    double angle = Math.toRadians(sub.getRotate());
                    velocity = velocity.add(Math.cos(angle) * 0.125, Math.sin(angle) * 0.125);
                }
                sub.setTranslateX(sub.getTranslateX() + velocity.getX());
                sub.setTranslateY(sub.getTranslateY() + velocity.getY());
            }
        }.start();

        stage.setScene(scene);
        stage.setTitle("Engines");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

```text
press key UP
frames 12
release key UP
frames 20
press key RIGHT
frames 15
release key RIGHT
press key UP
frames 10
release key UP
frames 40
```

The submarine speeds up to the right for 12 frames (to 1.5 pixels a frame), coasts for 20, turns 60 degrees clockwise, and pushes for 10 frames that way: the velocity becomes the old one plus the new pushes, so it heads down and to the right, but less steeply than its nose. Let it run longer and it leaves the window: step 6 brings it back from the other side.

The numbers in the window as text get long, such as the y of `at (225.6875, 169.2551948402401)` above: cos and sin of most angles have endless decimals. That's fine, since the same calculation in the same order always gives exactly the same number. It's also why the tasks say exactly how to calculate: `Math.toRadians` and the order in which things are added. (`Math.cos(Math.toRadians(90))` isn't exactly 0 either, but a tiny number of about 0.00000000000000006, because the angle in radians can't be stored exactly.)

---

Source: [Engines on: moving with vectors](https://javaarena.com/learn/asteroids/vectors/) in the module [Project: an Asteroids-style game](https://javaarena.com/learn/asteroids/) on Java Arena.

This module follows section [14.3 Larger application: Asteroids](https://java-programming.mooc.fi/part-14/3-larger-application-asteroids) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
