> [!info] AI-Generated

# Scene, layout and components

Step 1's window held one label. A window usually holds more: some text, a few buttons, a field to type in. JavaFX builds a window from parts inside parts:

- The **Stage** is the window itself, with its frame and its title bar.
- The stage shows a **Scene**: everything inside the frame.
- The scene has one **root**, usually a **layout**. A layout holds other parts and decides where they go.
- The layout holds the **components**: labels, buttons, text fields. JavaFX calls them **controls**.

Everything that can be in a scene is a **node** (the class `Node`), layouts and controls alike. A scene's root must be a **Parent**, a node that can hold others, and every layout is one. JavaFX counts labels as Parents too, so step 1 could make a label the root, but a label can't hold your other components. For several components, the root is a layout.

## FlowPane

The simplest layout is **FlowPane**. A café prints a slip for each order, with buttons for the size of the cup:

```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Label order = new Label("Order 17: oat latte");
        Button small = new Button("Small");
        Button medium = new Button("Medium");
        Button large = new Button("Large");

        FlowPane slip = new FlowPane();
        slip.getChildren().add(order);
        slip.getChildren().add(small);
        slip.getChildren().add(medium);
        slip.getChildren().add(large);

        Scene scene = new Scene(slip);
        stage.setScene(scene);
        stage.setTitle("Order slip");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

- `new Button("Small")` is a **button** with the text Small. The user can click it, but for now nothing happens when they do: module 49 makes a click run code.
- A FlowPane puts its children side by side, from left to right, and goes on in a new row when the window is too narrow for them, the way words flow in a paragraph.
- `slip.getChildren()` is the pane's list of children. It's a `List<Node>`, so `add`, `size`, `get`, `remove` and the others work as they do on an ArrayList. (Its type is `ObservableList<Node>`: a list that tells JavaFX when it changes, so the window can change with it.)
- The order of the list is the order in the window. The label is first because it was added first.

Layouts come from the package `javafx.scene.layout`, and controls from `javafx.scene.control`.

## The window as text

Under each drawn window, "The window as text" lists everything in the window, a line for each part, indented under the part that holds it. For the order slip:

```text
Window "Order slip"
  FlowPane
    Label "Order 17: oat latte"
    Button "Small"
    Button "Medium"
    Button "Large"
```

The first line is the window with its title. Then come the nodes, each with its class and its text. The challenges of part 13 compare exactly this with the window of the model solution: the classes, their order, what holds what, and every text. A window that looks the same but is built from other layouts doesn't pass, so the tasks always say which layouts to use.

## Shorter ways to add

`slip.getChildren().addAll(order, small, medium, large);` adds the four nodes in one call, in the order given. A FlowPane can also take its children in its constructor: `new FlowPane(order, small, medium, large)` makes the same slip.

Since the children are a list, a loop can fill it too. The café's milks, from an array:

```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        String[] milks = {"Whole", "Oat", "Soy", "None"};
        FlowPane slip = new FlowPane();
        slip.getChildren().add(new Label("Milk:"));
        for (String milk : milks) {
            slip.getChildren().add(new Button(milk));
        }

        stage.setScene(new Scene(slip));
        stage.setTitle("Order slip");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

Each round of the loop creates a new Button, and that matters: a node can be in **one place** in a window at a time. Adding a node to a second pane takes it out of the first, and adding the same node to one pane twice stops the program with an IllegalArgumentException. Four buttons in a window are four Button objects.

## A window from a file

The café keeps its milks in a file, so that the slip changes when the file does. `Files.readAllLines` (module 42) reads the file's lines into a list:

**The file milks.txt**

```text
Whole
Oat
Soy
Almond
```

```java
import java.nio.file.Files;
import java.nio.file.Paths;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FlowPane slip = new FlowPane();
        slip.getChildren().add(new Label("Milk:"));
        for (String milk : Files.readAllLines(Paths.get("milks.txt"))) {
            slip.getChildren().add(new Button(milk));
        }

        stage.setScene(new Scene(slip));
        stage.setTitle("Order slip");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

`readAllLines` can throw an IOException, which is a checked exception. Application declares its `start` with `throws Exception`, so yours may say the same, and then reading needs no `try`. If the file can't be read, `start` stops with the exception, and the program ends with an error, as it does when an exception isn't caught.

## The window's size

`new Scene(slip, 360, 120)` gives the scene a width and a height, in pixels. Without them, JavaFX makes the window just big enough for what it holds. The challenges don't check sizes, so they leave them out.

---

Source: [Scene, layout and components](https://javaarena.com/learn/gui-basics/scene-and-layout/) in the module [GUI: windows, components and layouts](https://javaarena.com/learn/gui-basics/) on Java Arena.

This module follows sections [13.1 Graphical user interfaces](https://java-programming.mooc.fi/part-13/1-graphical-user-interfaces), [13.2 UI components and their layout](https://java-programming.mooc.fi/part-13/2-UI-components-and-layout) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
