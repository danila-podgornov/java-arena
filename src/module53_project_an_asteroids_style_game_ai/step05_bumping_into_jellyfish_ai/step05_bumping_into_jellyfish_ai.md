> [!info] AI-Generated

# Bumping into jellyfish

A jellyfish that drifts through the submarine should end the dive. So the game needs to know when two shapes **overlap**, and then the sea needs more than two jellyfish.

## Shape.intersect

The class Shape has a static method for this: `Shape.intersect(a, b)` returns a new shape, the area that `a` and `b` share, with each one where its translate and rotate put it. Shapes that don't overlap share nothing, and then the box around that empty area, `getBoundsInLocal()`, has the width -1. So two shapes overlap when that width isn't -1:

```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Pane pane = new Pane();
        pane.setPrefSize(360, 240);
        pane.getChildren().add(new Rectangle(360, 240, Color.MIDNIGHTBLUE));

        Polygon sub = new Polygon(-15, -6, 9, -6, 15, 0, 9, 6, -15, 6);
        sub.setFill(Color.GOLD);
        sub.setTranslateX(180);
        sub.setTranslateY(100);
        Polygon near = new Polygon(-10, 0, -6, -8, 0, -10, 6, -8, 10, 0, 7, 10, 3, 2, 0, 10, -3, 2, -7, 10);
        near.setFill(Color.ORCHID);
        near.setTranslateX(192);
        near.setTranslateY(108);
        Polygon far = new Polygon(-10, 0, -6, -8, 0, -10, 6, -8, 10, 0, 7, 10, 3, 2, 0, 10, -3, 2, -7, 10);
        far.setFill(Color.ORCHID);
        far.setTranslateX(240);
        far.setTranslateY(60);
        Rectangle rock = new Rectangle(20, 200, 100, 40);
        rock.setFill(Color.DIMGRAY);
        Rectangle reef = new Rectangle(120, 180, 60, 60);
        reef.setFill(Color.CORAL);
        pane.getChildren().addAll(sub, near, far, rock, reef);

        Shape shared = Shape.intersect(sub, near);
        System.out.println("sub and near: " + shared.getBoundsInLocal().getWidth());
        System.out.println("sub and far: " + Shape.intersect(sub, far).getBoundsInLocal().getWidth());
        System.out.println("rock and reef: " + Shape.intersect(rock, reef).getBoundsInLocal().getWidth());

        stage.setScene(new Scene(pane));
        stage.setTitle("Overlaps");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

**Output**

```text
sub and near: 12.0
sub and far: -1.0
rock and reef: -1.0
```

- The submarine and the near jellyfish overlap: their shared area is 12 pixels wide.
- The far jellyfish shares nothing with the submarine: -1.
- The rock and the reef **touch**: the rock ends at x 120, where the reef starts. Touching isn't overlapping, since they share a line but no area, so that's -1 too.

The shapes must be in the same pane, as they are in a game. `intersect` works for polygons, circles and rectangles, turned and moved: the jellyfish's tentacles and the gaps between them count exactly, not only the box around them.

So the class Mover gets one more method:

```java
public boolean collides(Mover other) {
    Shape overlap = Shape.intersect(shape, other.getShape());
    return overlap.getBoundsInLocal().getWidth() != -1;
}
```

## Circles, with a ruler

For two circles there's a simpler test, which needs no JavaFX: they overlap when the distance between their centers is less than the sum of their radii. If it's exactly equal, they only touch. The distance between (x1, y1) and (x2, y2) is, by Pythagoras, the square root of dx² + dy², where dx and dy are the differences of the x and y values: `Math.sqrt(dx * dx + dy * dy)`, as `Point2D`'s `distance` method computes it. The first challenge below uses this rule.

## Many jellyfish, from a seeded Random

A sea with a handful of jellyfish in random places is more fun than two placed by hand. Module 46 made random numbers with `Random`, and said why a **seed** matters: `new Random(8)` gives the same numbers on every run. Here that's not a choice. The page runs your program again **from the start** for every new key or `frames` line, so an unseeded Random would put the jellyfish somewhere else on every run, and the game would jump around under your eyes. (The check also compares your window with the model solution's, which needs the same jellyfish.) So every game in these lessons gives its Random a seed.

## Stopping the game

When the submarine bumps into a jellyfish, the game is over: the submarine turns red, and the timer **stops**. `stop()` is AnimationTimer's method, and inside `handle` it can be called as just `stop()`, since `handle` belongs to the timer. A stopped timer's `handle` isn't called again, so nothing moves in the frames after it, though they still run and count.

**Main.java**

```java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {
    private Map<KeyCode, Boolean> held = new HashMap<>();
    private Random random = new Random(8);
    private int frame = 0;

    @Override
    public void start(Stage stage) {
        Pane pane = new Pane();
        pane.setPrefSize(360, 240);
        pane.getChildren().add(new Rectangle(360, 240, Color.MIDNIGHTBLUE));

        Sub sub = new Sub(180, 200);
        pane.getChildren().add(sub.getShape());
        List<Jellyfish> jellyfish = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Jellyfish j = new Jellyfish(random.nextInt(360), random.nextInt(100), random.nextInt(360));
            jellyfish.add(j);
            pane.getChildren().add(j.getShape());
        }

        Scene scene = new Scene(pane);
        scene.setOnKeyPressed(event -> held.put(event.getCode(), true));
        scene.setOnKeyReleased(event -> held.put(event.getCode(), false));

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                frame++;
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
                for (Jellyfish j : jellyfish) {
                    if (sub.collides(j)) {
                        sub.getShape().setFill(Color.RED);
                        System.out.println("Bump after " + frame + " frames");
                        stop();
                        break;
                    }
                }
            }
        }.start();

        stage.setScene(scene);
        stage.setTitle("Jellyfish");
        stage.show();
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
        shape.setTranslateX(shape.getTranslateX() + velocity.getX());
        shape.setTranslateY(shape.getTranslateY() + velocity.getY());
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
frames 22
release key LEFT
press key UP
frames 10
release key UP
frames 150
```

**Output**

```text
Bump after 116 frames
```

The field `frame` counts the frames, as step 2 said a game should. The submarine turns 88 degrees to the left, points almost straight up, speeds up for 10 frames, and after 116 frames in all it meets a jellyfish. `break` leaves the loop over the jellyfish, so the bump is printed once even if two jellyfish touch the submarine in the same frame. The jellyfish drift out of the window: step 6 brings them back.

---

Source: [Bumping into jellyfish](https://javaarena.com/learn/asteroids/collisions/) in the module [Project: an Asteroids-style game](https://javaarena.com/learn/asteroids/) on Java Arena.

This module follows section [14.3 Larger application: Asteroids](https://java-programming.mooc.fi/part-14/3-larger-application-asteroids) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
