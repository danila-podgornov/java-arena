> [!info] AI-Generated

# Points, new jellyfish and the end of the dive

The last step makes it a game: points for every jellyfish popped, new jellyfish drifting in from the surface, and a proper end when the submarine bumps into one.

## The score in a Text

A **Text** (from `javafx.scene.text`) is a shape that shows a line of text: `new Text(12, 24, "Score: 0")` puts it with its baseline starting at (12, 24), near the top left corner. Like the other shapes, it's filled black unless told otherwise, so on the dark sea it gets `setFill(Color.WHITE)`. `setText` changes what it says:

```java
Text score = new Text(12, 24, "Score: 0");
score.setFill(Color.WHITE);
pane.getChildren().add(score);
```

The points themselves are a field, `points`, which the timer's code can change (a local variable of `start` couldn't be changed there, which is why the MOOC's version uses an `AtomicInteger` instead). Each popped jellyfish is worth 10 points. One detail matters now: two bubbles can hit the same jellyfish in the same frame, and that jellyfish should count once. So a hit counts only when the bubble and the jellyfish are **both still alive**:

```java
if (b.isAlive() && j.isAlive() && b.collides(j)) {
    b.setAlive(false);
    j.setAlive(false);
    points += 10;
    score.setText("Score: " + points);
    System.out.println("Score: " + points);
}
```

In the window as text, a Text's line is `Text "Score: 20" at (12, 24), fill #ffffff`.

## New jellyfish

A sea that only empties isn't much of a game. So in each frame, a new jellyfish appears with a small **chance**: `random.nextDouble()` is a double from 0.0 up to (not including) 1.0, and it's below 0.02 in about 2% of the frames, so a new jellyfish comes about every 50 frames, a little more than once a second at 60 frames a second. It starts at a random x on the top edge, heading in a random direction. But a jellyfish that appears right on the submarine would end the game unfairly, so it's added only if it doesn't collide with the submarine:

```java
if (random.nextDouble() < 0.02) {
    Jellyfish newcomer = new Jellyfish(random.nextInt(WIDTH), 0, random.nextInt(360));
    if (!newcomer.collides(sub)) {
        jellyfish.add(newcomer);
        pane.getChildren().add(newcomer.getShape());
    }
}
```

The Random is the same seeded one that placed the first jellyfish, so this is the same on every run too. Note that `random.nextDouble()` is called in **every** frame: the numbers that come after it depend on how many frames ran.

## Game over

When the submarine bumps into a jellyfish, the game is over: the timer stops, the Text says `Game over! Score: 20`, and the keys do nothing any more. A field `over` remembers it, and the pressed handler returns at once when it's `true`, so Space can't fire bubbles from a sunken submarine.

## The whole game

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
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
    public static final int WIDTH = 360;
    public static final int HEIGHT = 240;

    private Map<KeyCode, Boolean> held = new HashMap<>();
    private Random random = new Random(16);
    private List<Jellyfish> jellyfish = new ArrayList<>();
    private List<Bubble> bubbles = new ArrayList<>();
    private int points = 0;
    private boolean over = false;

    @Override
    public void start(Stage stage) {
        Pane pane = new Pane();
        pane.setPrefSize(WIDTH, HEIGHT);
        pane.getChildren().add(new Rectangle(WIDTH, HEIGHT, Color.MIDNIGHTBLUE));
        Text score = new Text(12, 24, "Score: 0");
        score.setFill(Color.WHITE);
        pane.getChildren().add(score);

        Sub sub = new Sub(WIDTH / 2, HEIGHT / 2);
        pane.getChildren().add(sub.getShape());
        for (int i = 0; i < 4; i++) {
            Jellyfish j = new Jellyfish(random.nextInt(WIDTH), random.nextInt(60), random.nextInt(360));
            jellyfish.add(j);
            pane.getChildren().add(j.getShape());
        }

        Scene scene = new Scene(pane);
        scene.setOnKeyPressed(event -> {
            if (over) {
                return;
            }
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
                        if (b.isAlive() && j.isAlive() && b.collides(j)) {
                            b.setAlive(false);
                            j.setAlive(false);
                            points += 10;
                            score.setText("Score: " + points);
                            System.out.println("Score: " + points);
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

                if (random.nextDouble() < 0.02) {
                    Jellyfish newcomer = new Jellyfish(random.nextInt(WIDTH), 0, random.nextInt(360));
                    if (!newcomer.collides(sub)) {
                        jellyfish.add(newcomer);
                        pane.getChildren().add(newcomer.getShape());
                    }
                }

                for (Jellyfish j : jellyfish) {
                    if (sub.collides(j)) {
                        over = true;
                        sub.getShape().setFill(Color.RED);
                        score.setText("Game over! Score: " + points);
                        System.out.println("Game over! Score: " + points);
                        stop();
                        break;
                    }
                }
            }
        }.start();

        stage.setScene(scene);
        stage.setTitle("Deep dive");
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
    private int age;

    public Bubble(double x, double y, double heading) {
        super(new Circle(3, Color.LIGHTCYAN), x, y);
        turn(heading);
        accelerate(2.5);
        age = 0;
    }

    @Override
    public void move() {
        super.move();
        age++;
        if (age == 50) {
            setAlive(false);
        }
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
frames 25
release key RIGHT
key SPACE
frames 20
press key UP
frames 10
release key UP
frames 140
key SPACE
frames 5
```

**Output**

```text
Score: 10
Score: 20
Game over! Score: 20
```

Two pops, new jellyfish from the surface, and a bump. The `key SPACE` after the game over fires nothing. In a challenge below, "Run with my input" runs your own game: choose which keys are held and how many frames run, and see where the submarine ends up.

## What section 14.3 covered

This module built the MOOC's larger application of section 14.3 in its own theme, one idea per step:

- a **Pane** of a fixed size with **shapes** in it: `Polygon`, `Circle`, `Rectangle` and `Text`, moved with `setTranslateX` and `setTranslateY` and turned with `setRotate`
- **key events** on the scene, the held keys in a `Map<KeyCode, Boolean>`, and a **game loop**, an `AnimationTimer` whose `handle` runs once a frame
- movement with **Point2D**: a velocity added in every frame, and speeding up where the nose points with `Math.cos` and `Math.sin`
- one **abstract class** for everything that moves, with subclasses that override `move`
- **collisions** with `Shape.intersect`, many jellyfish from a **seeded** Random, and stopping the timer
- **wrapping** at the edges with `%`, using the window's size as constants
- **bubbles** fired on a key press, marked as not alive and removed with streams, from the list and from the pane
- **points** in a Text, new jellyfish with a chance in every frame, and a **game over**

The same structure carries over to many small games: a list of things that move, a loop that moves them and checks what touches what, and keys kept in a map.

## Running it on your own computer

On your own computer, the same code runs with the real JavaFX, live: about 60 frames a second, with the keys you press while it runs, and the real clock behind `now`. Installing JavaFX is a separate step: the MOOC's exercise templates bring it in through Maven (module 54 names the dependency), and the MOOC's [section 13.1](https://java-programming.mooc.fi/part-13/1-graphical-user-interfaces) has a note for Linux machines. There, holding a key repeats its press after a moment. Turning and speeding up don't notice, since the timer reads them from the map. Firing does: the pressed handler makes the bubble, so on a computer a held Space fires again on every repeat (after a short pause, about 30 a second) while fewer than 4 bubbles are out. Here a held Space fires once, so use `key SPACE` for each shot. If you like, take the game further there: a seed that changes on every run (`new Random()`), sounds (module 52 showed what they need), or levels that get harder. The MOOC's own version of the game is in [its section 14.3](https://java-programming.mooc.fi/part-14/3-larger-application-asteroids). The next module is about libraries, Maven and databases, and ends the course.

---

Source: [Points, new jellyfish and the end of the dive](https://javaarena.com/learn/asteroids/points-and-the-end/) in the module [Project: an Asteroids-style game](https://javaarena.com/learn/asteroids/) on Java Arena.

This module follows section [14.3 Larger application: Asteroids](https://java-programming.mooc.fi/part-14/3-larger-application-asteroids) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
