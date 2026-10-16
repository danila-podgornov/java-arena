> [!info] AI-Generated

# Layouts inside layouts

Each layout so far was the root of its window, holding controls. But a layout is a node too, so it can be a child of another layout. Real windows are built like that: a BorderPane for the frame, with an HBox of buttons at the bottom, a VBox down one side, a GridPane in the middle.

## A scoreboard, nested

```java
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        HBox score = new HBox(20, new Label("Harbor Rovers"), new Label("2 : 1"), new Label("Mill Town"));
        score.setPadding(new Insets(10));
        score.setAlignment(Pos.CENTER);

        VBox goals = new VBox(4, new Label("12' Okafor"), new Label("40' Lindqvist"), new Label("77' Mbeki"));
        goals.setPadding(new Insets(10));

        HBox buttons = new HBox(8, new Button("Previous match"), new Button("Next match"));
        buttons.setPadding(new Insets(10));
        buttons.setAlignment(Pos.CENTER_RIGHT);

        BorderPane board = new BorderPane();
        board.setTop(score);
        board.setCenter(goals);
        board.setBottom(buttons);

        stage.setScene(new Scene(board));
        stage.setTitle("Scoreboard");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

Look at the window as text: the HBox is in the top region, and its three labels are indented under it, one level deeper. Each layout looks after its own children only. The BorderPane decides where the HBox goes, and the HBox decides where its labels go inside it.

## Building parts in helper methods

A window like this makes `start` long, and the parts get mixed up. Methods help, as they did in every program before: a method can build one part of the window and return it. Its return type is the class of the part (`HBox`, `VBox`, `GridPane`), or a more general one, such as `Parent` or `Node`. The same scoreboard:

```java
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        String[] scorers = {"12' Okafor", "40' Lindqvist", "77' Mbeki"};
        BorderPane board = new BorderPane();
        board.setTop(score("Harbor Rovers", 2, 1, "Mill Town"));
        board.setCenter(goals(scorers));
        board.setBottom(buttons());

        stage.setScene(new Scene(board));
        stage.setTitle("Scoreboard");
        stage.show();
    }

    private HBox score(String home, int homeGoals, int awayGoals, String away) {
        HBox score = new HBox(20, new Label(home), new Label(homeGoals + " : " + awayGoals), new Label(away));
        score.setPadding(new Insets(10));
        score.setAlignment(Pos.CENTER);
        return score;
    }

    private VBox goals(String[] scorers) {
        VBox goals = new VBox(4);
        goals.setPadding(new Insets(10));
        for (String scorer : scorers) {
            goals.getChildren().add(new Label(scorer));
        }
        return goals;
    }

    private HBox buttons() {
        HBox buttons = new HBox(8, new Button("Previous match"), new Button("Next match"));
        buttons.setPadding(new Insets(10));
        buttons.setAlignment(Pos.CENTER_RIGHT);
        return buttons;
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

- `start` now reads like a summary of the window: a score on top, the goals in the middle, buttons at the bottom.
- The methods aren't `static`: they are methods of the Main object that JavaFX created, as `start` is.
- `score` takes the teams and the goals as parameters, so the same method could build the line of any match.
- `goals` takes an array of the scorers and makes a label for each, so it works for a match of any number of goals.

Each call of a helper method makes new nodes. That's what you want: since a node can be in one place at a time, a method that returned the same Label object on every call would move it from place to place, and the window would show it only once.

## A form in a grid

A form is a grid: labels in the first column, fields in the second. With the form in the center of a BorderPane and the buttons in an HBox at the bottom, it's the shape of many windows. The **Your turn** below builds one.

---

Source: [Layouts inside layouts](https://javaarena.com/learn/gui-basics/nesting-layouts/) in the module [GUI: windows, components and layouts](https://javaarena.com/learn/gui-basics/) on Java Arena.

This module follows sections [13.1 Graphical user interfaces](https://java-programming.mooc.fi/part-13/1-graphical-user-interfaces), [13.2 UI components and their layout](https://java-programming.mooc.fi/part-13/2-UI-components-and-layout) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
