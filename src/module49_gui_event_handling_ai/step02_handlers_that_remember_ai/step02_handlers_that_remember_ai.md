> [!info] AI-Generated

# Handlers that remember

A pomodoro is 25 minutes of focused work, then a short break. A window counts the pomodoros finished today: a label with the count, and a button to add one. The first try keeps the count in a variable of `start`:

```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Label done = new Label("Pomodoros today: 0");
        Button finish = new Button("Finished one");
        int count = 0;
        finish.setOnAction(event -> {
            count++;
            done.setText("Pomodoros today: " + count);
        });

        stage.setScene(new Scene(new VBox(done, finish)));
        stage.setTitle("Pomodoros");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

**What javac prints**

```text
Main.java:16: error: local variables referenced from a lambda expression must be final or effectively final
            count++;
            ^
Main.java:17: error: local variables referenced from a lambda expression must be final or effectively final
            done.setText("Pomodoros today: " + count);
                                               ^
2 errors
```

javac complains twice: once where the lambda changes `count`, and once where it reads it. Module 37 met this message: a lambda may use the local variables of its method (and its parameters) only when they are **effectively final**, which means never changed after they get their value. `count++` changes `count`.

Here's why Java has the rule. `start` runs once and returns before anyone clicks, and its local variables are gone after that. So a lambda doesn't keep the variable itself: it keeps a copy of its value, made when the lambda was made. If the variable could change later, the copy and the variable would disagree. A variable that never changes has a copy that is always right.

The lambda uses `done` too, and javac doesn't mind: `done` never changes, since it always refers to the same Label. The label's text changes, but that's a change inside the Label object, not a change of the variable.

A count that changes needs a place that outlives `start`. There are three usual ones.

## An instance variable

An instance variable belongs to the Main object, which JavaFX made before it called `start`, and which lives as long as the program does. The rule about effectively final variables is only for local variables and parameters, so a lambda can change an instance variable:

```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    private int pomodoros;

    @Override
    public void start(Stage stage) {
        Label done = new Label("Pomodoros today: 0");
        Button finish = new Button("Finished one");
        Button reset = new Button("Reset");
        finish.setOnAction(event -> {
            this.pomodoros++;
            done.setText("Pomodoros today: " + this.pomodoros);
        });
        reset.setOnAction(event -> {
            this.pomodoros = 0;
            done.setText("Pomodoros today: 0");
        });

        stage.setScene(new Scene(new VBox(done, new HBox(finish, reset))));
        stage.setTitle("Pomodoros");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

```text
click Button "Finished one"
click Button "Finished one"
click Button "Finished one"
```

The lambdas are written inside `start`, so `this` in them is the object whose `start` is running: the Main object. `this.pomodoros` is the same variable at every click, and it keeps its value between them.

## An object that counts

An object can hold the count instead. `PomodoroLog` is a small class of its own, and `start` makes one:

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
        PomodoroLog log = new PomodoroLog();
        Label done = new Label("Pomodoros today: 0");
        Button finish = new Button("Finished one");
        Button reset = new Button("Reset");
        finish.setOnAction(event -> {
            log.finishOne();
            done.setText("Pomodoros today: " + log.count());
        });
        reset.setOnAction(event -> {
            log.reset();
            done.setText("Pomodoros today: " + log.count());
        });

        stage.setScene(new Scene(new VBox(done, new HBox(finish, reset))));
        stage.setTitle("Pomodoros");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

**PomodoroLog.java**

```java
public class PomodoroLog {
    private int count;

    public void finishOne() {
        this.count++;
    }

    public void reset() {
        this.count = 0;
    }

    public int count() {
        return this.count;
    }
}
```

```text
click Button "Finished one"
click Button "Finished one"
click Button "Reset"
click Button "Finished one"
```

`log` is a local variable, but an effectively final one: it refers to the same PomodoroLog object all the time. What changes is the object's instance variable, as with the label's text. Step 4 builds on this: a class of its own that does the work, and handlers that only call it.

## The window itself

When a label shows nothing but the number, the handler can read the number back from the label:

```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Label visitors = new Label("0");
        Button plus = new Button("+1");
        plus.setOnAction(event -> {
            int now = Integer.valueOf(visitors.getText());
            visitors.setText("" + (now + 1));
        });

        stage.setScene(new Scene(new HBox(10, plus, visitors)));
        stage.setTitle("Door counter");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

```text
click Button "+1"
click Button "+1"
click Button "+1"
click Button "+1"
```

That's fine for a small window like this one. When the label says more than the number, or several handlers share the count, an instance variable or an object is clearer.

## A value read too early

A lambda's copy of a variable has the value the variable had when the lambda was made. That matters when the value comes from the window. A hotel's wake-up call service:

```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        TextField room = new TextField();
        room.setPromptText("Room number");
        Button book = new Button("Wake me at 7");
        Label booked = new Label("");
        String number = room.getText();
        book.setOnAction(event -> booked.setText("Wake-up call at 7 for room " + number));

        stage.setScene(new Scene(new VBox(booked, room, book)));
        stage.setTitle("Wake-up calls");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

```text
type TextField 1 "214"
click Button "Wake me at 7"
```

The room number is missing. `number` got its value once, when `start` ran, and the field was empty then. To use what the user typed, read the field inside the handler: `booked.setText("Wake-up call at 7 for room " + room.getText())`.

---

Source: [Handlers that remember](https://javaarena.com/learn/gui-events/effectively-final/) in the module [GUI: event handling](https://javaarena.com/learn/gui-events/) on Java Arena.

This module follows sections [13.3 Event handling](https://java-programming.mooc.fi/part-13/3-event-handling), [13.4 Application's launch parameters](https://java-programming.mooc.fi/part-13/4-launch-parameters) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
