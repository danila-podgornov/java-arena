> [!info] AI-Generated

# Steering with the keys

A game reacts to the keyboard, and it keeps moving while nobody touches it. This step adds both: key events, and a **game loop** that runs many times a second.

## Key events

In part 13 a button had `setOnAction`. For the keyboard, the **Scene** has `setOnKeyPressed` and `setOnKeyReleased`, each taking a handler, usually a lambda. The handler gets a **KeyEvent** (from `javafx.scene.input`), and `event.getCode()` says which key it was, as a **KeyCode**: an enum with a constant for every key, such as `KeyCode.LEFT`, `KeyCode.UP`, `KeyCode.SPACE` and `KeyCode.A`.

```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Pane pane = new Pane();
        pane.setPrefSize(360, 240);
        Polygon sub = new Polygon(-15, -6, 9, -6, 15, 0, 9, 6, -15, 6);
        sub.setFill(Color.GOLD);
        sub.setTranslateX(180);
        sub.setTranslateY(120);
        pane.getChildren().addAll(new Rectangle(360, 240, Color.MIDNIGHTBLUE), sub);

        Scene scene = new Scene(pane);
        scene.setOnKeyPressed(event -> System.out.println("pressed " + event.getCode()));
        scene.setOnKeyReleased(event -> System.out.println("released " + event.getCode()));

        stage.setScene(scene);
        stage.setTitle("Keys");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

```text
key SPACE
press key LEFT
release key LEFT
key A
```

**Output**

```text
pressed SPACE
released SPACE
pressed LEFT
released LEFT
pressed A
released A
```

The key handlers go on the **scene**, not on a node: the scene gets the keys of its whole window. The event lines are the page's way of pressing keys: `press key LEFT` presses the left arrow key and holds it, `release key LEFT` lets go of it, and `key SPACE` presses and releases Space at once. The keys are named as KeyCode names them (`LEFT`, `RIGHT`, `UP`, `DOWN`, `SPACE`, `A`), and the task cards say them in words: "Hold Left", "let go of Left", "press and release Space".

## Holding a key

A game needs to know which keys are **held right now**, not only when one goes down. So it keeps them in a map, `Map<KeyCode, Boolean>`: the pressed handler puts `true` for its key, the released handler `false`, and the rest of the game asks the map with `held.getOrDefault(KeyCode.LEFT, false)`, which is `false` for a key that was never pressed.

This matters for one more reason. On a computer, holding a key down makes the system repeat its press, about 30 times a second after a short pause, so a handler that turned the submarine on each press would turn it in jerks. Here a held key isn't repeated at all: it gets one press. A game that keeps the held keys in a map and does its work in the game loop behaves the same either way, which is why the MOOC's game does it too.

## The game loop: AnimationTimer

A game redraws its world many times a second. Each of those pictures is a **frame**, and JavaFX shows about 60 frames a second. An **AnimationTimer** (from `javafx.animation`) runs code once for every frame: its method `handle` is called once a frame, for as long as the timer runs. `AnimationTimer` is an abstract class, so a game makes a class of its own that extends it, usually right where it's needed:

```java
new AnimationTimer() {
    @Override
    public void handle(long now) {
        // runs once every frame
    }
}.start();
```

`new AnimationTimer() { ... }` is an **anonymous class**: a class without a name that extends AnimationTimer, written and used in one place. Its body overrides `handle`, and `.start()` starts the new timer at once. Like a lambda (module 49), its code can use the local variables of `start` that never change, such as `sub` below, and the fields of `Main`.

`handle` gets a number, `now`: the time of the frame in nanoseconds. On a computer it comes from the computer's clock; here it's a made-up clock, so a game in these lessons never uses it. To know how many frames have passed, count them in a field.

On this page, frames run only when you ask for them: the event line `frames 20` runs 20 frames, calling `handle` 20 times, and the page records each one. The submarine turns 4 degrees each frame while Left or Right is held:

```java
import java.util.HashMap;
import java.util.Map;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {
    private Map<KeyCode, Boolean> held = new HashMap<>();

    @Override
    public void start(Stage stage) {
        Pane pane = new Pane();
        pane.setPrefSize(360, 240);
        Polygon sub = new Polygon(-15, -6, 9, -6, 15, 0, 9, 6, -15, 6);
        sub.setFill(Color.GOLD);
        sub.setTranslateX(180);
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
            }
        }.start();

        stage.setScene(scene);
        stage.setTitle("Steering");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

```text
press key RIGHT
frames 20
release key RIGHT
press key LEFT
frames 5
release key LEFT
frames 10
```

Right is held for 20 frames (20 times 4 degrees, 80 clockwise), then Left for 5 (20 back), and then 10 frames run with no key held, which change nothing: the submarine ends at 60 degrees. The page shows those 35 frames as an animation. In the window as text, the last line counts them, `frames run: 35`; the challenges compare the window after the last event and that count, not the frames on the way.

Between the `frames` lines, nothing moves: a key line only runs the key handlers. On a computer with the real JavaFX, the frames run by themselves and you press the keys while they do.

---

Source: [Steering with the keys](https://javaarena.com/learn/asteroids/keys-and-loop/) in the module [Project: an Asteroids-style game](https://javaarena.com/learn/asteroids/) on Java Arena.

This module follows section [14.3 Larger application: Asteroids](https://java-programming.mooc.fi/part-14/3-larger-application-asteroids) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
