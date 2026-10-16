> [!info] AI-Generated

# Buttons that do something

The windows of module 48 looked right, but their buttons did nothing when clicked. This module makes windows react: a click runs code that you write, and so can typing. As in module 48, each click or bit of typing on this page runs your program again from the start, with everything you did before it, and the code is ordinary JavaFX code.

## An event handler

When the user clicks a button, JavaFX makes an **event**: an object that describes what happened. It hands the event to the button's **event handler**, if the button has one. A handler is given to a button with `setOnAction`. A town's drawbridge gets a control panel:

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
        Label status = new Label("The bridge is down.");
        Button raise = new Button("Raise the bridge");
        raise.setOnAction(event -> status.setText("The bridge is up."));

        stage.setScene(new Scene(new VBox(status, raise)));
        stage.setTitle("Drawbridge");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

```text
click Button "Raise the bridge"
```

The window is drawn as it is after the clicks listed with it: here, one click on the button.

- `setOnAction` takes an `EventHandler<ActionEvent>`. **EventHandler** is an interface of JavaFX with one method, `handle`, and a click on a button is an **ActionEvent**, so here the method is `void handle(ActionEvent event)`. An interface with one method can be implemented with a lambda (module 37), so the handler here is `event -> status.setText("The bridge is up.")`: the lambda's body is what `handle` does.
- The parameter `event` is the ActionEvent. This handler doesn't need it, but it must be there, since `handle` has that parameter. The name is yours to choose; `e` is common too.
- Writing a lambda needs no import for EventHandler or ActionEvent: Java works out the lambda's type from `setOnAction`.
- `start` runs once and builds the window. The line with `setOnAction` doesn't change the label: it only gives the button its handler, and the handler's code runs later, each time the button is clicked.
- The lambda uses `status`, a variable of `start`. Step 2 looks at which variables a lambda can use.

## A handler runs at every click

The front desk of a hotel gets a bell. Its handler prints, and so does `start`:

```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Button bell = new Button("Ring the bell");
        bell.setOnAction(event -> System.out.println("Ding!"));

        stage.setScene(new Scene(new VBox(bell)));
        stage.setTitle("Front desk");
        stage.show();
        System.out.println("start is done");
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

```text
click Button "Ring the bell"
click Button "Ring the bell"
```

**Output**

```text
start is done
Ding!
Ding!
```

`start is done` comes first: `start` sets up the window and returns. Only then can the user click, and each click runs the handler once more.

## Reading a text field in a handler

A handler can use the other parts of the window: read a text field, set a label. A converter for a kitchen timer turns seconds into minutes:

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
        TextField seconds = new TextField();
        seconds.setPromptText("Seconds");
        Button convert = new Button("Convert");
        Label result = new Label("");
        convert.setOnAction(event -> {
            int total = Integer.valueOf(seconds.getText());
            result.setText(total / 60 + " min " + total % 60 + " s");
        });

        stage.setScene(new Scene(new VBox(8, seconds, convert, result)));
        stage.setTitle("Timer");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

```text
type TextField 1 "135"
click Button "Convert"
```

- A handler of several statements has its body in braces, as a lambda in module 37 can.
- `seconds.getText()` runs when the button is clicked, so it reads what the user has typed by then. Type another number and click again, and the handler reads the new one.
- With the field empty, `Integer.valueOf("")` throws a NumberFormatException. An exception in a handler doesn't end the program: JavaFX prints it (`Exception in thread "JavaFX Application Thread"` and the stack trace), and the window stays open for the next click. The checks in this module always type a number before they click.

## Clicking from code

A program can click its own buttons: `button.fire()` runs the button's handler, as a click does. Some programs in this module use it, so that you can see what their handlers do without clicking.

---

Source: [Buttons that do something](https://javaarena.com/learn/gui-events/button-actions/) in the module [GUI: event handling](https://javaarena.com/learn/gui-events/) on Java Arena.

This module follows sections [13.3 Event handling](https://java-programming.mooc.fi/part-13/3-event-handling), [13.4 Application's launch parameters](https://java-programming.mooc.fi/part-13/4-launch-parameters) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
