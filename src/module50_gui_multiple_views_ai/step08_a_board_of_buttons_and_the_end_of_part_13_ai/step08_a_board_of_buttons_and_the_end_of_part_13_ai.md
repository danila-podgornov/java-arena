> [!info] AI-Generated

# A board of buttons, and the end of part 13

The last step of part 13 builds a small board game for two players, with a button for each cell of a grid, and then looks back at the whole part.

## A button for each cell

A grid of buttons is built with two nested loops, as module 47 went through a two-dimensional array, and `grid.add(button, column, row)` puts each button in its cell (module 48). Each button needs a handler that knows its cell. The first try uses the loop variables in the lambda:

```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        GridPane board = new GridPane();
        for (int row = 0; row < 2; row++) {
            for (int column = 0; column < 3; column++) {
                Button cell = new Button("?");
                cell.setOnAction(event -> System.out.println("Clicked row " + row + ", column " + column));
                board.add(cell, column, row);
            }
        }

        stage.setScene(new Scene(board));
        stage.setTitle("Board");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

**What javac prints**

```text
Main.java:15: error: local variables referenced from a lambda expression must be final or effectively final
                cell.setOnAction(event -> System.out.println("Clicked row " + row + ", column " + column));
                                                                              ^
Main.java:15: error: local variables referenced from a lambda expression must be final or effectively final
                cell.setOnAction(event -> System.out.println("Clicked row " + row + ", column " + column));
                                                                                                  ^
2 errors
```

It's the effectively final rule of module 49 again. `row` and `column` change at every round of their loops, so a lambda can't use them. The cure is a copy: inside the inner loop, `int r = row;` and `int c = column;` declare new variables in every round, and each of them keeps its value from then on. So each button's lambda gets the copies of its own round, which are its own cell:

```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        GridPane board = new GridPane();
        for (int row = 0; row < 2; row++) {
            for (int column = 0; column < 3; column++) {
                int r = row;
                int c = column;
                Button cell = new Button("?");
                cell.setOnAction(event -> System.out.println("Clicked row " + r + ", column " + c));
                board.add(cell, c, r);
            }
        }

        stage.setScene(new Scene(board));
        stage.setTitle("Board");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

```text
click Button 5
click Button 3
```

**Output**

```text
Clicked row 1, column 1
Clicked row 0, column 2
```

The clicks were on the fifth and the third button, counted row by row. The variable `cell` is new in every round too, so a handler may use it to change its own button. (The variable of a for-each loop is also new in every round, so a lambda can use it without a copy.)

## Number grab

The game: a board of numbers, and two players, Red and Blue, who take turns, Red first. A player clicks a number that nobody has taken yet, and it's theirs: it's added to their points, and the turn goes to the other player. A number that is taken already can't be taken again.

As in steps 5 to 7, the rules go in a class of their own. `NumberGrab` keeps the numbers in a two-dimensional array, and who took each one in a second array of the same size, `null` for a number nobody has taken. `take` checks the rules and returns whether the move happened. The window asks it at every click:

**Main.java**

```java
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        int[][] numbers = {{5, 2, 8, 3}, {1, 9, 4, 7}, {6, 3, 2, 8}};
        NumberGrab game = new NumberGrab(numbers);
        Label status = new Label("Red's turn");
        Label score = new Label("Red 0, Blue 0");

        GridPane board = new GridPane();
        board.setHgap(4);
        board.setVgap(4);
        board.setPadding(new Insets(10));
        for (int row = 0; row < numbers.length; row++) {
            for (int column = 0; column < numbers[row].length; column++) {
                int r = row;
                int c = column;
                Button cell = new Button("" + numbers[r][c]);
                cell.setOnAction(event -> {
                    if (game.take(r, c)) {
                        cell.setText(game.ownerAt(r, c) + " " + game.numberAt(r, c));
                        status.setText(game.turn() + "'s turn");
                        score.setText("Red " + game.score("Red") + ", Blue " + game.score("Blue"));
                    }
                });
                board.add(cell, c, r);
            }
        }

        BorderPane frame = new BorderPane();
        frame.setCenter(board);
        frame.setBottom(new VBox(4, status, score));

        stage.setScene(new Scene(frame));
        stage.setTitle("Number grab");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

**NumberGrab.java**

```java
public class NumberGrab {
    private int[][] numbers;
    private String[][] owners;
    private String turn;
    private int red;
    private int blue;

    public NumberGrab(int[][] numbers) {
        this.numbers = numbers;
        this.owners = new String[numbers.length][numbers[0].length];
        this.turn = "Red";
    }

    public int numberAt(int row, int column) {
        return this.numbers[row][column];
    }

    public String ownerAt(int row, int column) {
        return this.owners[row][column];
    }

    public String turn() {
        return this.turn;
    }

    public int score(String player) {
        if (player.equals("Red")) {
            return this.red;
        }
        return this.blue;
    }

    public boolean take(int row, int column) {
        if (this.owners[row][column] != null) {
            return false;
        }
        this.owners[row][column] = this.turn;
        if (this.turn.equals("Red")) {
            this.red += this.numbers[row][column];
            this.turn = "Blue";
        } else {
            this.blue += this.numbers[row][column];
            this.turn = "Red";
        }
        return true;
    }
}
```

```text
click Button "9"
click Button "8"
click Button "Red 9"
click Button "7"
```

- Red took the 9, Blue the first 8, and Red the 7. The click on `Red 9`, a number that was taken already, changed nothing: `take` returned `false`, so the handler did nothing either. The handler doesn't know the rules; it forwards the click and shows what the game says.
- A taken button shows who took it, like `Red 9`, and the label under the board says whose turn it is, above the score.
- `numbers[r][c]` is an int, and `"" + numbers[r][c]` makes it the button's text.

## When the game ends

All the numbers together make the board's total, 58 on this board. A player who has more than half of the total has won, since the other player can't catch up any more, and the game ends right there, even with numbers left on the board. If every number is taken and neither player has more than half, they have exactly half each: a draw. Once the game is over, no number can be taken.

That's a rule, so it belongs in NumberGrab too. The task below writes it.

## This module at a glance

| You want | Write |
| --- | --- |
| the window to show another scene | `stage.setScene(otherScene)`, with each scene made once |
| a menu that stays, and content that changes | a BorderPane with the menu on top, and `frame.setCenter(view)` |
| a view in a class of its own | a class with `public Parent getView()` |
| a view that keeps what happens in it | make its nodes in the constructor, and return the same root from `getView()` |
| a view that always shows the latest data | build it anew in `getView()`, from the logic objects |
| data and rules that several views share | a class without JavaFX, and one object of it given to each view |
| a button for each cell of a grid | nested loops, `grid.add(button, column, row)`, and copies such as `int r = row;` for the lambda |

## The end of part 13

This step ends the material of the MOOC's thirteenth part, about graphical user interfaces. Module 48 built windows with JavaFX: an Application whose `start` method gets the window, a Stage, and gives it a Scene, the controls Label, Button, TextField and TextArea, and the layouts FlowPane, BorderPane, HBox, VBox and GridPane, with spacing, padding and alignment, and layouts inside layouts. Module 49 made the windows react: event handlers given with `setOnAction` as lambdas, handlers that read and change the window, the effectively final rule and the places where a changing value can live instead, listeners that hear every change of a text field, buttons switched on and off, the work done in a plain class, and launch parameters. This module had applications with several views: scenes that replace each other, a frame whose center changes, views as classes, the logic apart from the views, and a larger app built in two parts. Part 14 comes next, with charts, drawing, images and sound, a larger game, and libraries. Part 13 ends with [the MOOC's summary page](https://java-programming.mooc.fi/part-13/6-summary) on its own site.

---

Source: [A board of buttons, and the end of part 13](https://javaarena.com/learn/gui-views/end-of-part-13/) in the module [GUI: multiple views](https://javaarena.com/learn/gui-views/) on Java Arena.

This module follows sections [13.5 Multiple views](https://java-programming.mooc.fi/part-13/5-multiple-views), [13.6 Summary](https://java-programming.mooc.fi/part-13/6-summary) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
