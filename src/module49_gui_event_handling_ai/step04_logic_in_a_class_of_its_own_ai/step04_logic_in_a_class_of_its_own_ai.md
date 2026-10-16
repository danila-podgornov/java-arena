> [!info] AI-Generated

# Logic in a class of its own

The handlers so far did small things. In a bigger program, a handler that works everything out by itself gets long, and the only way to try what it computes is to click through the window. A better shape, common in programs of every size: a plain class does the work and knows nothing about windows, and the handlers only read the window, call the class, and show what it answers.

## A color mixer

A paint shop's window mixes the three primary colors. The mixing is in `ColorMixer`, a class without a single import from JavaFX:

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
        ColorMixer mixer = new ColorMixer();
        Label mix = new Label("Mix: nothing yet");
        Button red = new Button("Red");
        Button yellow = new Button("Yellow");
        Button blue = new Button("Blue");
        Button clear = new Button("Clear");
        red.setOnAction(event -> {
            mixer.add("red");
            mix.setText("Mix: " + mixer.result());
        });
        yellow.setOnAction(event -> {
            mixer.add("yellow");
            mix.setText("Mix: " + mixer.result());
        });
        blue.setOnAction(event -> {
            mixer.add("blue");
            mix.setText("Mix: " + mixer.result());
        });
        clear.setOnAction(event -> {
            mixer.clear();
            mix.setText("Mix: " + mixer.result());
        });

        stage.setScene(new Scene(new VBox(10, new HBox(5, red, yellow, blue), clear, mix)));
        stage.setTitle("Color mixer");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

**ColorMixer.java**

```java
public class ColorMixer {
    private boolean red;
    private boolean yellow;
    private boolean blue;

    public void add(String color) {
        if (color.equals("red")) {
            this.red = true;
        } else if (color.equals("yellow")) {
            this.yellow = true;
        } else if (color.equals("blue")) {
            this.blue = true;
        }
    }

    public void clear() {
        this.red = false;
        this.yellow = false;
        this.blue = false;
    }

    public String result() {
        if (this.red && this.yellow && this.blue) {
            return "brown";
        }
        if (this.red && this.yellow) {
            return "orange";
        }
        if (this.yellow && this.blue) {
            return "green";
        }
        if (this.red && this.blue) {
            return "purple";
        }
        if (this.red) {
            return "red";
        }
        if (this.yellow) {
            return "yellow";
        }
        if (this.blue) {
            return "blue";
        }
        return "nothing yet";
    }
}
```

```text
click Button "Red"
click Button "Yellow"
```

- `start` makes one ColorMixer, and every handler uses it. `mixer` never changes, so the lambdas may use it (step 2); the mixer object's own variables change.
- Each handler does the same two things: it tells the mixer what happened, and it shows the mixer's answer in the label. None of them knows how colors mix.
- ColorMixer knows nothing about buttons or labels. It takes a color's name and answers with a name.

## Logic you can check without a window

Since ColorMixer doesn't need a window, a program can use it without one:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        ColorMixer mixer = new ColorMixer();
        System.out.println(mixer.result());
        mixer.add("blue");
        mixer.add("yellow");
        System.out.println(mixer.result());
        mixer.add("red");
        System.out.println(mixer.result());
    }
}
```

**ColorMixer.java**

```java
public class ColorMixer {
    private boolean red;
    private boolean yellow;
    private boolean blue;

    public void add(String color) {
        if (color.equals("red")) {
            this.red = true;
        } else if (color.equals("yellow")) {
            this.yellow = true;
        } else if (color.equals("blue")) {
            this.blue = true;
        }
    }

    public void clear() {
        this.red = false;
        this.yellow = false;
        this.blue = false;
    }

    public String result() {
        if (this.red && this.yellow && this.blue) {
            return "brown";
        }
        if (this.red && this.yellow) {
            return "orange";
        }
        if (this.yellow && this.blue) {
            return "green";
        }
        if (this.red && this.blue) {
            return "purple";
        }
        if (this.red) {
            return "red";
        }
        if (this.yellow) {
            return "yellow";
        }
        if (this.blue) {
            return "blue";
        }
        return "nothing yet";
    }
}
```

**Output**

```text
nothing yet
green
brown
```

That's what makes the shape worth it. Every case of the mixing can be tried by calling methods, as the checks of the next challenge do, or with JUnit tests (module 26), with no clicking. The window then needs only a few clicks to show that its handlers call the right methods. And the same ColorMixer could serve a text user interface (module 25) or a different window, unchanged.

## One handler for several buttons

The three color buttons do the same thing with a different color. A handler is an object, so one handler can be kept in a variable and given to all three. The event tells which button was clicked: `event.getSource()` returns it. Its type is Object, so the handler casts it to a Button (module 36):

```java
EventHandler<ActionEvent> addColor = event -> {
    Button clicked = (Button) event.getSource();
    mixer.add(clicked.getText().toLowerCase());
    mix.setText("Mix: " + mixer.result());
};
red.setOnAction(addColor);
yellow.setOnAction(addColor);
blue.setOnAction(addColor);
```

Naming the handler's type, `EventHandler<ActionEvent>`, needs two more imports: `javafx.event.ActionEvent` and `javafx.event.EventHandler`. The buttons' texts `Red`, `Yellow` and `Blue` turn into the mixer's names with `toLowerCase()`.

---

Source: [Logic in a class of its own](https://javaarena.com/learn/gui-events/logic-in-a-class/) in the module [GUI: event handling](https://javaarena.com/learn/gui-events/) on Java Arena.

This module follows sections [13.3 Event handling](https://java-programming.mooc.fi/part-13/3-event-handling), [13.4 Application's launch parameters](https://java-programming.mooc.fi/part-13/4-launch-parameters) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
