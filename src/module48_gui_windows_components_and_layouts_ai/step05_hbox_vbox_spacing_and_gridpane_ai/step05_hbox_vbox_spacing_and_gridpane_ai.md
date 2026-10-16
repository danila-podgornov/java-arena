> [!info] AI-Generated

# HBox, VBox, spacing and GridPane

A FlowPane wraps its children however the width allows. Often you want to decide yourself: these in a row, those in a column, everything in a grid. This step has the three layouts for that, and the settings that space things out.

## HBox and VBox

An **HBox** puts its children in one row, from left to right, and a **VBox** in one column, from top to bottom. Neither wraps. A scoreboard for a football match:

```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Label home = new Label("Harbor Rovers 2");
        Label away = new Label("Mill Town 1");
        Label time = new Label("67 minutes played");
        VBox board = new VBox(home, away, time);

        stage.setScene(new Scene(board));
        stage.setTitle("Scoreboard");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

An HBox is made the same way, `new HBox(home, away, time)`, and it would show the three labels side by side. Both have `getChildren()`, as FlowPane has.

## Spacing

Without anything more, the children touch each other. **Spacing** is the room between two children, in pixels: `new VBox(10, home, away, time)` (the spacing comes first), or `board.setSpacing(10)` later. In the window as text it reads `VBox spacing 10`.

## Padding

**Padding** is room inside a pane, between its edge and its children. `setPadding` takes an **Insets** object, from `javafx.geometry`:

- `new Insets(12)`: 12 pixels on all four sides
- `new Insets(4, 12, 8, 12)`: top, right, bottom, left, in that order: clockwise, starting at the top

The window as text shows `padding 12` for the same padding on every side, and the four values, `padding 4 12 8 12`, otherwise. Every layout has `setPadding`.

## Alignment

When a pane has more room than its children need, **alignment** says where in it they sit. `setAlignment` takes one of the constants of **Pos**, also from `javafx.geometry`. The names say the place, up and down first, then across: `TOP_LEFT` (where HBox, VBox, FlowPane and GridPane put things unless told otherwise), `TOP_CENTER`, `TOP_RIGHT`, `CENTER_LEFT`, `CENTER`, `CENTER_RIGHT`, `BOTTOM_LEFT`, `BOTTOM_CENTER` and `BOTTOM_RIGHT`. (Three more, `BASELINE_LEFT`, `BASELINE_CENTER` and `BASELINE_RIGHT`, line up texts by the line their letters stand on.)

The scoreboard with all three:

```java
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Label home = new Label("Harbor Rovers 2");
        Label away = new Label("Mill Town 1");
        Label time = new Label("67 minutes played");
        VBox board = new VBox(10, home, away, time);
        board.setPadding(new Insets(12));
        board.setAlignment(Pos.CENTER);

        stage.setScene(new Scene(board, 240, 140));
        stage.setTitle("Scoreboard");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

The scene here is bigger than the labels need, so the alignment shows: the labels sit in the middle.

## GridPane

A **GridPane** puts its children into the cells of a grid of rows and columns. `add(node, column, row)` puts a node into a cell. The **column comes first**, then the row, as x before y, and both count from 0. The grid has as many rows and columns as its cells need. `setHgap` sets the room between columns, and `setVgap` between rows.

A phone's dial pad is a grid of buttons, and two nested loops make the digits 1 to 9:

```java
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        GridPane keypad = new GridPane();
        keypad.setHgap(4);
        keypad.setVgap(4);
        keypad.setPadding(new Insets(8));

        TextField number = new TextField();
        number.setPromptText("Number");
        keypad.add(number, 0, 0, 3, 1);

        for (int row = 1; row <= 3; row++) {
            for (int column = 0; column < 3; column++) {
                int digit = (row - 1) * 3 + column + 1;
                keypad.add(new Button("" + digit), column, row);
            }
        }
        keypad.add(new Button("0"), 1, 4);

        stage.setScene(new Scene(keypad));
        stage.setTitle("Phone");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

- `keypad.add(number, 0, 0, 3, 1)` puts the field into column 0 of row 0, and lets it **span** 3 columns and 1 row: it's as wide as the three columns of buttons below it.
- The outer loop goes through rows 1 to 3, and the inner loop through the columns of each row. In row 1 the digits are 1, 2 and 3, in row 2 they are 4, 5 and 6, and so on: `(row - 1) * 3 + column + 1`.
- `"" + digit` turns the number into a String for the button's text.
- The 0 sits alone in row 4, in the middle column. Cells that nothing is added to stay empty.

In the window as text, each node of a grid starts with its cell, column first, as in `add`: `(1, 4) Button "0"`. The cells are listed row by row, and a node that spans more than one cell says so: `(0, 0) span 3x1 TextField ""` is 3 columns wide and 1 row high. `GridPane.getColumnIndex(node)` and `GridPane.getRowIndex(node)` return the column and the row a node was added to.

---

Source: [HBox, VBox, spacing and GridPane](https://javaarena.com/learn/gui-basics/boxes-and-grids/) in the module [GUI: windows, components and layouts](https://javaarena.com/learn/gui-basics/) on Java Arena.

This module follows sections [13.1 Graphical user interfaces](https://java-programming.mooc.fi/part-13/1-graphical-user-interfaces), [13.2 UI components and their layout](https://java-programming.mooc.fi/part-13/2-UI-components-and-layout) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
