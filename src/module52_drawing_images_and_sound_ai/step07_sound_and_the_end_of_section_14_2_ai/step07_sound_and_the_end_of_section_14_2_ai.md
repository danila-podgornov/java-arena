> [!info] AI-Generated

# Sound, and the end of section 14.2

The last kind of multimedia in this module is sound: a click when a button is pressed, a chime when a message arrives, a cheer when a game is won.

## Sound in JavaFX

JavaFX plays short sounds with the class **AudioClip**, from the package `javafx.scene.media`. On your own computer, a window with a button that plays a chime looks like this:

```java
import java.nio.file.Paths;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        AudioClip chime = new AudioClip(Paths.get("chime.wav").toUri().toString());
        Button ring = new Button("Ring the chime");
        ring.setOnAction(event -> chime.play());

        stage.setScene(new Scene(new VBox(ring)));
        stage.setTitle("Door chime");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

- `new AudioClip(...)` takes the address of the sound file. `Paths.get("chime.wav").toUri().toString()` turns the file's name into its full address, which starts with `file:`, such as `file:///home/ada/chime/chime.wav`.
- The clip reads the whole sound when it's made, so `play()` starts at once. Calling `play()` again while it still plays starts the sound once more, over the first one.
- `stop()` stops it, `setVolume(0.5)` makes it play at half the volume (from 0.0 for silence to 1.0, the default), and `setCycleCount(3)` makes each `play()` play it three times in a row.
- For long sounds, such as music, JavaFX has `Media` and `MediaPlayer`, which play a file little by little instead of reading it all first.
- The sound classes are a part of JavaFX of their own, `javafx.media`, which a project needs next to the `javafx.controls` of the windows.

## Sound in Java Arena

This page can't play sound. Java Arena's practice JavaFX has no `javafx.scene.media`, and the Java engine that runs your programs inside the page can't play sound. So here, javac stops at the import:

```java
import javafx.scene.media.AudioClip;

public class Main {
    public static void main(String[] args) {
        AudioClip chime = new AudioClip("file:chime.wav");
        chime.play();
    }
}
```

**What javac prints**

```text
Main.java:1: error: package javafx.scene.media does not exist
import javafx.scene.media.AudioClip;
                         ^
Main.java:5: error: cannot find symbol
        AudioClip chime = new AudioClip("file:chime.wav");
        ^
  symbol:   class AudioClip
  location: class Main
Main.java:5: error: cannot find symbol
        AudioClip chime = new AudioClip("file:chime.wav");
                              ^
  symbol:   class AudioClip
  location: class Main
3 errors
```

This step is for reading. The MOOC's exercise with sound, a button that plays a sound file, needs your own computer with JavaFX installed (module 48 links to the MOOC's instructions for that).

## Deciding what to play

What a program **decides** about sound can still be written and checked here: which sound to play, and when. As in module 50, that decision goes in a plain class, and the window's handlers only carry it out. A quiz show's buzzer plays `right.wav` for a right answer and `wrong.wav` for a wrong one, except that the third wrong answer in a row plays `out.wav` and starts the count again. Here the handler prints the name of the clip where your computer would play it:

**Main.java**

```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Buzzer buzzer = new Buzzer();
        Label last = new Label("No answers yet");
        Button right = new Button("Right");
        Button wrong = new Button("Wrong");
        right.setOnAction(event -> {
            String clip = buzzer.clipFor(true);
            System.out.println("play " + clip);
            last.setText("Last sound: " + clip);
        });
        wrong.setOnAction(event -> {
            String clip = buzzer.clipFor(false);
            System.out.println("play " + clip);
            last.setText("Last sound: " + clip);
        });

        stage.setScene(new Scene(new VBox(10, new HBox(5, right, wrong), last)));
        stage.setTitle("Quiz buzzer");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

**Buzzer.java**

```java
public class Buzzer {
    private int wrongInARow;

    public String clipFor(boolean correct) {
        if (correct) {
            this.wrongInARow = 0;
            return "right.wav";
        }
        this.wrongInARow++;
        if (this.wrongInARow == 3) {
            this.wrongInARow = 0;
            return "out.wav";
        }
        return "wrong.wav";
    }
}
```

```text
click Button "Wrong"
click Button "Wrong"
click Button "Right"
click Button "Wrong"
```

**Output**

```text
play wrong.wav
play wrong.wav
play right.wav
play wrong.wav
```

On your own computer, the handler would make an AudioClip for each of the three files in `start`, keep them in a map from the file's name to its clip, and call `clips.get(clip).play()` where this one prints. Buzzer stays the same, and every case of it can be tried by calling `clipFor`, with no sound at all.

## Part 14 so far

Section 14.1 (module 51) and section 14.2 (this module) were about showing more than text:

- **Charts** (module 51): rows of data read from files into numbers, lists and maps; line charts with `NumberAxis`, `XYChart.Series` and `XYChart.Data`; several series from a map, and series from a formula; a `Slider` whose listener redraws a chart; bar charts with a `CategoryAxis`; and charts that are honest about their numbers.
- **Drawing** (steps 1 and 2): a `Canvas` and its `GraphicsContext`, with fill and stroke colors and a line width; rectangles, ovals given by the rectangle around them, lines and polygons, where later drawing covers earlier; colors by name, by `Color.rgb` and by `Color.web`; and the mouse, with its pressed, dragged, released and clicked events and the point in `getX()` and `getY()`.
- **Images** (steps 3 to 6): an `Image` read from a file (or an error image when it can't be), its `PixelReader`, a `WritableImage` written through its `PixelWriter`, and an `ImageView` that shows it; smaller copies that keep every second (or every f-th) pixel; copies placed into bigger images; tiles with `%`, mirrored tiles; and filters: the negative, two kinds of gray, a threshold and tints.
- **Sound** (this step): `AudioClip`, for your own computer.

Section 14.3 builds a larger program with a window: a game in the style of Asteroids, with shapes that move and the keyboard to steer, in the next module.

---

Source: [Sound, and the end of section 14.2](https://javaarena.com/learn/drawing-and-images/sound/) in the module [Drawing, images and sound](https://javaarena.com/learn/drawing-and-images/) on Java Arena.

This module follows section [14.2 Multimedia in programs](https://java-programming.mooc.fi/part-14/2-multimedia-in-programs) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
