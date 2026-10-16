> [!info] AI-Generated

# Views as classes

With a few views, `start` grows long, and the nodes and handlers of every view get mixed together. The cure is the one you used for long programs before: classes. Each view gets a class of its own, with a method that returns the view's root, ready to be put in a window. These lessons call that method `getView()`. The Application creates the view objects and switches between them.

## The castle guide, in classes

The guide gets a page of history and a page for booking a tour. Each view is a class in its own file, and `Main` only builds the frame:

**Main.java**

```java
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        HistoryView history = new HistoryView();
        ToursView tours = new ToursView(12);

        Button toHistory = new Button("History");
        Button toTours = new Button("Tours");
        HBox menu = new HBox(10, toHistory, toTours);
        menu.setPadding(new Insets(10));

        BorderPane frame = new BorderPane();
        frame.setTop(menu);
        frame.setCenter(history.getView());
        toHistory.setOnAction(event -> frame.setCenter(history.getView()));
        toTours.setOnAction(event -> frame.setCenter(tours.getView()));

        stage.setScene(new Scene(frame));
        stage.setTitle("Castle guide");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

**HistoryView.java**

```java
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class HistoryView {

    public Parent getView() {
        VBox view = new VBox(6);
        view.setPadding(new Insets(10));
        view.getChildren().add(new Label("1350: the first stone walls"));
        view.getChildren().add(new Label("1622: a fire, and a new north tower"));
        view.getChildren().add(new Label("1954: the castle opens to visitors"));
        return view;
    }
}
```

**ToursView.java**

```java
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class ToursView {
    private int placesLeft;
    private VBox view;

    public ToursView(int places) {
        this.placesLeft = places;
        Label left = new Label("Places left on the afternoon tour: " + places);
        TextField name = new TextField();
        name.setPromptText("Your name");
        Button book = new Button("Book a place");
        Label message = new Label("");
        book.setOnAction(event -> {
            if (this.placesLeft == 0) {
                message.setText("Sorry, the tour is full.");
            } else {
                this.placesLeft--;
                left.setText("Places left on the afternoon tour: " + this.placesLeft);
                message.setText("Booked a place for " + name.getText() + ".");
            }
        });
        this.view = new VBox(8, left, name, book, message);
        this.view.setPadding(new Insets(10));
    }

    public Parent getView() {
        return this.view;
    }
}
```

```text
click Button "Tours"
type TextField 1 "Ada"
click Button "History"
click Button "Tours"
click Button "Book a place"
```

- The view classes are ordinary classes: they don't extend Application, and each file has its own imports.
- `getView()` returns a **Parent**. Parent is the class of every node that can hold others, every layout among them (module 48), so the method can return a VBox, a GridPane or a BorderPane, and the code that calls it doesn't need to know which. `setCenter` takes any node, and a Parent is one. (`new Scene(...)` wants a Parent too.)
- `Main` creates each view object once, at the start, and its handlers only choose which view goes in the center.

## Two ways to build a view

Look at where each class makes its nodes.

- **HistoryView** makes new nodes at every call of `getView()`. Each visit to the history page gets a fresh VBox with fresh labels. That's fine, since the page has nothing to remember.
- **ToursView** makes its nodes once, in its constructor, and keeps the layout in an instance variable. `getView()` returns the same VBox every time. So the view keeps what happens in it: in the example, `Ada` was typed, the user went to the history page and back, and the name was still in the field when Book was clicked.

ToursView's handler is a lambda in the constructor. It changes `this.placesLeft`, an instance variable of the view object, which the effectively final rule allows (module 49), and it uses the local variables `left`, `name` and `message`, which never change.

A view that builds new nodes in `getView()` can still show data that lasts, if it reads that data from an object that keeps it. Step 5 does that.

## Views with setScene

View classes work with `setScene` too. Make each scene once, at the start, such as `Scene toursScene = new Scene(tours.getView());`, and switch with `stage.setScene(toursScene)`. A handler that calls `new Scene(tours.getView())` at every click fails at the second click, when getView returns the same layout: a root can't be in two scenes (step 1).

---

Source: [Views as classes](https://javaarena.com/learn/gui-views/views-as-classes/) in the module [GUI: multiple views](https://javaarena.com/learn/gui-views/) on Java Arena.

This module follows sections [13.5 Multiple views](https://java-programming.mooc.fi/part-13/5-multiple-views), [13.6 Summary](https://java-programming.mooc.fi/part-13/6-summary) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
