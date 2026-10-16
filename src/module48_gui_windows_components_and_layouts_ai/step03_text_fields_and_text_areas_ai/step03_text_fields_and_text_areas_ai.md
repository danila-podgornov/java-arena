> [!info] AI-Generated

# Text fields and text areas

Labels and buttons show text that the program chose. For text that the user writes, JavaFX has **text fields** and **text areas**.

## TextField

A **TextField** is a box for one line of text. The catalog search of a library:

```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Label what = new Label("Find a book:");
        TextField search = new TextField();
        search.setPromptText("Title or author");
        Button go = new Button("Search");

        FlowPane bar = new FlowPane(what, search, go);
        stage.setScene(new Scene(bar));
        stage.setTitle("City Library");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

- `new TextField()` makes an empty field. `new TextField("Dune")` would start with the text Dune in it.
- `setPromptText("Title or author")` sets the field's **prompt text**: a hint, shown in gray while the field is empty (JavaFX's own look also hides it while the field has the keyboard focus). It isn't the field's text: `getText()` never returns it.
- In the window as text, a text field shows its text in quotes (here it's empty, `""`), and then its prompt text.

## Clicks and typing in examples

An example can have an `events` block after it: clicks and typing that Java Arena does after `start`, as if you had done them in the drawn window. The drawing then shows the window after them. Here, someone types The Hobbit into the search field:

```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Label what = new Label("Find a book:");
        TextField search = new TextField();
        search.setPromptText("Title or author");
        Button go = new Button("Search");

        FlowPane bar = new FlowPane(what, search, go);
        stage.setScene(new Scene(bar));
        stage.setTitle("City Library");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

```text
type TextField 1 "The Hobbit"
```

`type TextField 1 "The Hobbit"` means: type The Hobbit into the first text field of the window. Challenges use the same lines to click and type in your window, and the task card shows them in words: Type "The Hobbit" in text field 1.

## TextArea

A **TextArea** holds several lines of text. A `\n` in its text starts a new line, as it does in a String you print. `setWrapText(true)` makes a line that is too long for the area go on in the next line, instead of running past the area's edge:

```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Label about = new Label("A note for the librarian:");
        TextArea note = new TextArea("Page 112 is torn.\nThe cover is fine.");
        note.setWrapText(true);

        FlowPane form = new FlowPane(about, note);
        stage.setScene(new Scene(form));
        stage.setTitle("Return a book");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

In the window as text, the line breaks of a text are written `\n`, and `(wraps text)` marks the area that wraps.

## Reading and changing the text

Text fields and text areas share these methods:

| method | what it does |
| --- | --- |
| `getText()` | returns the text that's in it now |
| `setText(text)` | replaces the text |
| `appendText(text)` | adds to the end of the text |
| `clear()` | empties it |
| `getLength()` | returns the number of characters in the text |
| `setEditable(false)` | the user can read the text, but no longer change it |

A window for renewing a loan, with the program filling in what it already knows:

```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        TextField card = new TextField();
        card.setText("10442211");
        card.setEditable(false);
        System.out.println("The card number has " + card.getLength() + " digits");

        TextArea history = new TextArea("Borrowed on May 2");
        history.appendText("\nRenewed on May 23");
        System.out.println(history.getText());

        FlowPane form = new FlowPane(card, history);
        stage.setScene(new Scene(form));
        stage.setTitle("Renew a loan");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

**Output**

```text
The card number has 8 digits
Borrowed on May 2
Renewed on May 23
```

The card number can't be changed in the window: the window as text marks that field `(not editable)`.

## When to read what the user typed

`start` runs before the user does anything. So `getText()` in `start` returns the text that the program put into the field, never what the user types later:

```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        TextField name = new TextField();
        name.setPromptText("Your name");
        FlowPane form = new FlowPane(new Label("Name:"), name);
        System.out.println("In start, the field holds [" + name.getText() + "]");

        stage.setScene(new Scene(form));
        stage.setTitle("New member");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

```text
type TextField 1 "Grace"
```

**Output**

```text
In start, the field holds []
```

The window shows Grace in the field, but `start` printed an empty text: when it ran, nobody had typed yet. To use what the user typed, a program needs code that runs after the typing, for example when the user clicks a button. That's what module 49 is about. In this module, the windows show their fields, and you can type into them.

## PasswordField

A **PasswordField** is a TextField that shows a dot in place of each character typed, for passwords and PIN codes. It has the same methods, and `getText()` returns what was really typed. It's in `javafx.scene.control` with the others.

---

Source: [Text fields and text areas](https://javaarena.com/learn/gui-basics/text-input/) in the module [GUI: windows, components and layouts](https://javaarena.com/learn/gui-basics/) on Java Arena.

This module follows sections [13.1 Graphical user interfaces](https://java-programming.mooc.fi/part-13/1-graphical-user-interfaces), [13.2 UI components and their layout](https://java-programming.mooc.fi/part-13/2-UI-components-and-layout) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
