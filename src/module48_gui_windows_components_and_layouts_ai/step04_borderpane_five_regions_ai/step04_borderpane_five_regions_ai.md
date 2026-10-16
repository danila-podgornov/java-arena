> [!info] AI-Generated

# BorderPane: five regions

A FlowPane lets its children flow. Many windows have a fixed frame instead: a title or a toolbar along the top, a line of status at the bottom, a menu on one side, and the main thing in the middle. **BorderPane** is that frame. It has five regions: **top**, **right**, **bottom**, **left** and **center**.

## A recipe card

```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        BorderPane card = new BorderPane();
        card.setTop(new Label("Lentil soup"));
        card.setLeft(new Label("Serves 4"));
        card.setCenter(new TextArea("Fry the onion.\nAdd the lentils and the stock.\nSimmer for 25 minutes."));
        card.setRight(new Label("45 min"));
        card.setBottom(new Button("Print"));

        stage.setScene(new Scene(card));
        stage.setTitle("Recipe card");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

- `setTop`, `setRight`, `setBottom`, `setLeft` and `setCenter` each put one node into a region. A region holds one node at most (step 6 puts a layout full of nodes there).
- The top and bottom regions run across the whole width. The left and right regions sit between them, at the sides, and the center gets all the room that's left.
- In the window as text, each node of a BorderPane starts with its region: `top: Label "Lentil soup"`. The regions are always listed in the same order, top, left, center, right, bottom, whatever order the code set them in.

`new BorderPane(node)` makes a BorderPane with that node in the center.

## Empty regions

A region that is never set stays empty, and an empty region takes no room. A card with only a title and the method:

```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        BorderPane card = new BorderPane();
        card.setTop(new Label("Toast"));
        card.setCenter(new TextArea("Toast the bread.\nButter it while it's hot."));

        stage.setScene(new Scene(card));
        stage.setTitle("Recipe card");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

The window as text lists only the regions that hold something.

## Replacing what's in a region

Setting a region again replaces its node: the old node leaves the window. `setCenter(null)` empties the center. `getTop()`, `getCenter()` and the others return the node in a region, as a `Node` (or `null` for an empty region), and `card.getChildren()` is the list of the nodes in all the regions together:

```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        BorderPane card = new BorderPane();
        Label draft = new Label("Pea soup");
        card.setTop(draft);
        card.setCenter(new TextArea("Boil the peas."));
        card.setTop(new Label("Pea and mint soup"));
        System.out.println("The draft title is in the window: " + (draft.getParent() != null));
        System.out.println("Nodes in the card: " + card.getChildren().size());

        stage.setScene(new Scene(card));
        stage.setTitle("Recipe card");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

**Output**

```text
The draft title is in the window: false
Nodes in the card: 2
```

`getParent()` returns the node that holds a node, or `null` for a node that isn't in any. The draft title has none any more: the second `setTop` replaced it, so the card holds two nodes, the new title and the method.

## Fonts

A label's text can be bigger, or in another kind of letters. `setFont` takes a **Font**, from the package `javafx.scene.text`: `Font.font("Serif", 22)` is the Serif family, 22 points high. Every computer that runs JavaFX has its four own families: `System` (the one JavaFX uses unless told otherwise), `Serif`, `SansSerif` and `Monospaced`. Other family names, such as `Arial`, work only on computers that have that family, so this course uses only these four.

```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Label dish = new Label("Lentil soup");
        dish.setFont(Font.font("Serif", 22));
        Label time = new Label("45 min");
        time.setFont(Font.font("Monospaced", 13));

        BorderPane card = new BorderPane();
        card.setTop(dish);
        card.setCenter(new TextArea("Fry the onion.\nAdd the lentils and the stock."));
        card.setRight(time);

        stage.setScene(new Scene(card));
        stage.setTitle("Recipe card");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

The window as text shows a font only when it isn't the normal one: `font Serif 22`. Buttons, text fields and text areas have `setFont` too.

---

Source: [BorderPane: five regions](https://javaarena.com/learn/gui-basics/border-pane/) in the module [GUI: windows, components and layouts](https://javaarena.com/learn/gui-basics/) on Java Arena.

This module follows sections [13.1 Graphical user interfaces](https://java-programming.mooc.fi/part-13/1-graphical-user-interfaces), [13.2 UI components and their layout](https://java-programming.mooc.fi/part-13/2-UI-components-and-layout) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
