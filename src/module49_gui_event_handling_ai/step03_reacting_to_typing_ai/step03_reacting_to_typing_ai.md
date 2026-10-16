> [!info] AI-Generated

# Reacting to typing

A button's handler runs when the button is clicked. Often a window should react while the user types: show how many characters are left, say whether a name is free, switch a button on once a field is filled in. For that, a program listens to the text itself.

## The text as a property

A text field keeps its text in a **property**: an object that holds a value and tells others when the value changes. `field.textProperty()` returns it. Its method `addListener` takes a **ChangeListener**, an interface with one method, `changed`, which has three parameters: the property that changed, the old value and the new value. A lambda with three parameters needs parentheses around them, as module 37's lambdas with two did:

```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        TextField word = new TextField();
        word.textProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("\"" + oldValue + "\" to \"" + newValue + "\"");
        });

        stage.setScene(new Scene(new VBox(word)));
        stage.setTitle("Listening");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

```text
type TextField 1 "cat"
set TextField 1 "dog"
```

**Output**

```text
"" to "c"
"c" to "ca"
"ca" to "cat"
"cat" to "dog"
```

- Typing changes the text one character at a time, so typing `cat` calls the listener three times.
- The last event replaces the whole text at once, as pasting `dog` over `cat` would: that's one change, and one call.
- The listener hears every change of the text, whoever makes it: the user's typing, and the program's own `setText`, `appendText` and `clear`.
- It hears only real changes. `setText` with the text that's already there changes nothing, and the listener isn't called.
- The first parameter, here called `observable`, is the property itself. The listeners in this module don't need it, but the lambda must have it, since `changed` has three parameters.

## A sign that counts its characters

A sign maker prints shop signs of up to 20 characters. The window shows how many are left while the customer types:

```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        TextField text = new TextField();
        text.setPromptText("Text of the sign");
        Label left = new Label("20 characters left");
        text.textProperty().addListener((observable, oldValue, newValue) -> {
            left.setText((20 - newValue.length()) + " characters left");
        });

        stage.setScene(new Scene(new VBox(text, left)));
        stage.setTitle("Sign maker");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

```text
type TextField 1 "FRESH BREAD"
```

The label is set from `newValue`, the text after the change. `text.getText()` would give the same text inside the listener, since the change has already happened when the listener runs.

## Switching a button on and off

`setDisable(true)` disables a button: it's drawn pale, and clicking it does nothing. `setDisable(false)` enables it again. The sign maker's `Order` button should work only when there's a text, and one that fits. The button starts disabled, and the listener switches it on and off as the text changes:

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
        TextField text = new TextField();
        text.setPromptText("Text of the sign");
        Label left = new Label("20 characters left");
        Button order = new Button("Order");
        order.setDisable(true);
        text.textProperty().addListener((observable, oldValue, newValue) -> {
            left.setText((20 - newValue.length()) + " characters left");
            order.setDisable(newValue.isEmpty() || newValue.length() > 20);
        });
        order.setOnAction(event -> System.out.println("Ordered a sign: " + text.getText()));

        stage.setScene(new Scene(new VBox(text, left, order)));
        stage.setTitle("Sign maker");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

```text
click Button "Order"
type TextField 1 "OPEN LATE ON FRIDAYS!"
click Button "Order"
set TextField 1 "OPEN LATE FRIDAYS"
click Button "Order"
set TextField 1 ""
```

**Output**

```text
Ordered a sign: OPEN LATE FRIDAYS
```

The first click comes before any typing, while the button is disabled, so nothing happens. The 21 characters of the first text are one too many, so the second click does nothing either. After the shorter text, the button is enabled, and the third click orders the sign. The last event clears the text, so the button is disabled again: in "The window as text", it's marked `(disabled)`.

`setDisable` works on any part of a window: a disabled text field can't be typed in, and disabling a pane (a VBox, say) disables everything in it.

---

Source: [Reacting to typing](https://javaarena.com/learn/gui-events/reacting-to-typing/) in the module [GUI: event handling](https://javaarena.com/learn/gui-events/) on Java Arena.

This module follows sections [13.3 Event handling](https://java-programming.mooc.fi/part-13/3-event-handling), [13.4 Application's launch parameters](https://java-programming.mooc.fi/part-13/4-launch-parameters) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
