> [!info] AI-Generated

# Firing bubbles

The submarine fights back: Space fires a **bubble** from its nose, and a bubble that hits a jellyfish pops it. Both disappear from the sea. This step needs things to be **removed** from the game, which takes a little care.

## The class Bubble

A bubble is one more Mover: a small circle that starts where the submarine is, heads where its nose points, and goes fast, 2.5 pixels a frame:

```java
public class Bubble extends Mover {

    public Bubble(double x, double y, double heading) {
        super(new Circle(3, Color.LIGHTCYAN), x, y);
        turn(heading);
        accelerate(2.5);
    }
}
```

A circle looks the same however it's turned, but its rotate still says where `accelerate` pushes it. The submarine's own speed isn't added: a bubble always leaves at 2.5 pixels a frame.

## Firing on a key press

Turning and speeding up use the held keys in the game loop. Firing is different: **one press, one bubble** (on your own computer a held Space counts as many presses, as step 8 says). So the bubble is made in the pressed handler, and only for Space. The event line `key SPACE` presses and releases Space with no frame in between, so the game loop would never even see Space held; the pressed handler sees every press. To keep the sea from filling up, the submarine fires only while fewer than 4 bubbles are out:

```java
scene.setOnKeyPressed(event -> {
    held.put(event.getCode(), true);
    if (event.getCode() == KeyCode.SPACE && bubbles.size() < 4) {
        Bubble bubble = new Bubble(sub.getShape().getTranslateX(), sub.getShape().getTranslateY(), sub.getShape().getRotate());
        bubbles.add(bubble);
        pane.getChildren().add(bubble.getShape());
    }
});
```

## Alive or not

When a bubble hits a jellyfish, both should go. Removing them from their lists **while a for-each loop goes through those lists** throws a ConcurrentModificationException (module 14 showed it); in the game loop, JavaFX prints it and goes on with the next frame, and the rest of that frame's loop never runs. So the game does it in two passes: first it only **marks** them, with a flag that every Mover now has, and after the loops it removes everything that's marked. Mover gets a field `alive`, `true` at the start, with `isAlive()` and `setAlive(boolean)`.

Removing has two parts. The shape must leave the pane's children, or it stays on the screen; and the Mover must leave its list, or it keeps moving and colliding unseen. Module 37's streams do both:

```java
bubbles.stream()
        .filter(b -> !b.isAlive())
        .forEach(b -> pane.getChildren().remove(b.getShape()));
bubbles = bubbles.stream()
        .filter(b -> b.isAlive())
        .collect(Collectors.toList());
```

The first statement removes the shape of every bubble that isn't alive from the pane. The second keeps the bubbles that are alive in a **new** list and puts it in the field `bubbles`. That's why `bubbles` and `jellyfish` are now fields of `Main` and not local variables of `start`: the code of the timer can assign a field, but not a local variable.

**Main.java**

```java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
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
    private Random random = new Random(16);
    private List<Jellyfish> jellyfish = new ArrayList<>();
    private List<Bubble> bubbles = new ArrayList<>();

    @Override
    public void start(Stage stage) {
        Pane pane = new Pane();
        pane.setPrefSize(WIDTH, HEIGHT);
        pane.getChildren().add(new Rectangle(WIDTH, HEIGHT, Color.MIDNIGHTBLUE));

        Sub sub = new Sub(WIDTH / 2, HEIGHT / 2);
        pane.getChildren().add(sub.getShape());
        for (int i = 0; i < 4; i++) {
            Jellyfish j = new Jellyfish(random.nextInt(WIDTH), random.nextInt(60), random.nextInt(360));
            jellyfish.add(j);
            pane.getChildren().add(j.getShape());
        }

        Scene scene = new Scene(pane);
        scene.setOnKeyPressed(event -> {
            held.put(event.getCode(), true);
            if (event.getCode() == KeyCode.SPACE && bubbles.size() < 4) {
                Bubble bubble = new Bubble(sub.getShape().getTranslateX(), sub.getShape().getTranslateY(), sub.getShape().getRotate());
                bubbles.add(bubble);
                pane.getChildren().add(bubble.getShape());
            }
        });
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
                bubbles.forEach(b -> b.move());

                for (Bubble b : bubbles) {
                    for (Jellyfish j : jellyfish) {
                        if (b.collides(j)) {
                            b.setAlive(false);
                            j.setAlive(false);
                            System.out.println("Pop!");
                        }
                    }
                }
                bubbles.stream()
                        .filter(b -> !b.isAlive())
                        .forEach(b -> pane.getChildren().remove(b.getShape()));
                jellyfish.stream()
                        .filter(j -> !j.isAlive())
                        .forEach(j -> pane.getChildren().remove(j.getShape()));
                bubbles = bubbles.stream()
                        .filter(b -> b.isAlive())
                        .collect(Collectors.toList());
                jellyfish = jellyfish.stream()
                        .filter(j -> j.isAlive())
                        .collect(Collectors.toList());

                for (Jellyfish j : jellyfish) {
                    if (sub.collides(j)) {
                        sub.getShape().setFill(Color.RED);
                        System.out.println("Bump!");
                        stop();
                        break;
                    }
                }
            }
        }.start();

        stage.setScene(scene);
        stage.setTitle("Bubbles");
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
    private boolean alive;

    public Mover(Shape shape, double x, double y) {
        this.shape = shape;
        this.shape.setTranslateX(x);
        this.shape.setTranslateY(y);
        this.velocity = new Point2D(0, 0);
        this.alive = true;
    }

    public Shape getShape() {
        return shape;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
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

**Bubble.java**

```java
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Bubble extends Mover {

    public Bubble(double x, double y, double heading) {
        super(new Circle(3, Color.LIGHTCYAN), x, y);
        turn(heading);
        accelerate(2.5);
    }
}
```

```text
press key LEFT
frames 20
release key LEFT
key SPACE
frames 10
key SPACE
frames 10
key SPACE
frames 30
press key RIGHT
frames 30
release key RIGHT
key SPACE
frames 40
```

**Output**

```text
Pop!
Pop!
```

The submarine turns up and fires three bubbles: two of them pop a jellyfish each, and the other one flies on, wrapping around the sea. Then the submarine turns to 40 degrees and fires a fourth bubble. A bubble that never hits anything flies forever here, and four of them would keep the submarine from ever firing again: the second challenge below gives bubbles a lifetime.

---

Source: [Firing bubbles](https://javaarena.com/learn/asteroids/bubbles/) in the module [Project: an Asteroids-style game](https://javaarena.com/learn/asteroids/) on Java Arena.

This module follows section [14.3 Larger application: Asteroids](https://java-programming.mooc.fi/part-14/3-larger-application-asteroids) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
