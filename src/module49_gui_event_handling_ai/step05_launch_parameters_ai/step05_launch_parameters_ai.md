> [!info] AI-Generated

# Launch parameters

A program started from a terminal can be given **command-line arguments**: words after the class's name, as in `java Main --name=Noor --candles=30`. They arrive in `main`'s parameter, `String[] args`, which every `main` has had since module 1. Here `args` would hold two Strings, `--name=Noor` and `--candles=30`. Programs use them for settings that change from one run to the next: a name, a size, a file to open.

## From main to start

A JavaFX program hands its arguments on to the application: `launch(Main.class, args)`. After the class, `launch` takes any number of Strings (its parameter is written `String... args`): an array of them, as here, Strings written one after another, as in `launch(Main.class, "--name=Noor", "--candles=30")`, or none at all, as in `launch(Main.class)`.

In `start`, `getParameters()`, a method that Main inherits from Application, returns them as a `Parameters` object with three methods:

| Method | Returns |
| --- | --- |
| `getRaw()` | every argument, in order, as a `List<String>` |
| `getNamed()` | the arguments written `--key=value`, as a `Map<String, String>` from each key to its value |
| `getUnnamed()` | the other arguments, in order, as a `List<String>` |

An argument is named when it starts with two dashes, then a key that begins with a letter (or `_`), then `=`: `--name=Noor` is the key `name` with the value `Noor`. `-name=Noor` (one dash), `--quiet` (no `=`) and `--3d=yes` (the key starts with a digit) are unnamed. A key given twice keeps its last value.

A party has a banner that shows whose birthday it is. To try it without a terminal, this `main` gives `launch` the arguments itself:

```java
import java.util.Map;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Map<String, String> named = getParameters().getNamed();
        Label banner = new Label("Happy birthday, " + named.get("name") + "!");
        banner.setFont(Font.font("Serif", 28));
        Label cake = new Label("Candles: " + named.get("candles"));
        System.out.println(getParameters().getRaw());
        System.out.println(getParameters().getUnnamed());

        stage.setScene(new Scene(new VBox(banner, cake)));
        stage.setTitle("Party");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class, "--name=Noor", "--candles=30", "balloons");
    }
}
```

**Output**

```text
[--name=Noor, --candles=30, balloons]
[balloons]
```

`getNamed()` is a Map, so `get("name")` finds the value by its key (module 31). The values are Strings, even `30`: for a number to calculate with, convert it, as with input, `Integer.valueOf(named.get("candles"))`.

## A default for a missing argument

`get` returns `null` for a key that isn't there. Started without arguments, the banner would say `Happy birthday, null!`. `getOrDefault` (module 31) gives a value of your own instead. This version passes on `main`'s own arguments, as a real program does, and on this page it runs without any:

```java
import java.util.Map;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Map<String, String> named = getParameters().getNamed();
        Label banner = new Label("Happy birthday, " + named.getOrDefault("name", "friend") + "!");
        banner.setFont(Font.font("Serif", 28));
        Label cake = new Label("Candles: " + named.getOrDefault("candles", "plenty"));

        stage.setScene(new Scene(new VBox(banner, cake)));
        stage.setTitle("Party");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class, args);
    }
}
```

## The application in a class of its own

The class with `main` doesn't have to be the application. `Main` can stay a plain class whose `main` starts another class, one that extends Application. Here `main` also gives only one of the two arguments:

**Main.java**

```java
import javafx.application.Application;

public class Main {
    public static void main(String[] args) {
        Application.launch(PartyBanner.class, "--name=Kai");
    }
}
```

**PartyBanner.java**

```java
import java.util.Map;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class PartyBanner extends Application {

    @Override
    public void start(Stage stage) {
        Map<String, String> named = getParameters().getNamed();
        Label banner = new Label("Happy birthday, " + named.getOrDefault("name", "friend") + "!");
        banner.setFont(Font.font("Serif", 28));
        Label cake = new Label("Candles: " + named.getOrDefault("candles", "plenty"));

        stage.setScene(new Scene(new VBox(banner, cake)));
        stage.setTitle("Party");
        stage.show();
    }
}
```

- `launch` is a static method of Application. Inside a class that extends Application it can be called by its name alone; anywhere else it's called with the class's name, `Application.launch(...)`, as `Math.max(...)` is.
- JavaFX makes the PartyBanner object itself, so PartyBanner must be `public`, with a constructor that takes no parameters, as module 48 said of Main.

## Arguments here and on your computer

- On your own computer, the arguments go after the class's name in the command that starts the program, or in your editor's settings for running it.
- In Java Arena, the checks of a challenge give the arguments, and the task card shows them under "Command-line arguments". "Run with my input" starts your program without arguments, so it shows what your program does when they're missing.

---

Source: [Launch parameters](https://javaarena.com/learn/gui-events/launch-parameters/) in the module [GUI: event handling](https://javaarena.com/learn/gui-events/) on Java Arena.

This module follows sections [13.3 Event handling](https://java-programming.mooc.fi/part-13/3-event-handling), [13.4 Application's launch parameters](https://java-programming.mooc.fi/part-13/4-launch-parameters) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
