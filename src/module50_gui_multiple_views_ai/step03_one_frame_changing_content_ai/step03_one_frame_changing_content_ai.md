> [!info] AI-Generated

# One frame, changing content

`setScene` swaps everything in the window. Many applications keep part of the window in place instead, such as a menu along the top, and change only the area under it. A BorderPane (module 48) fits that well: the menu goes in the top region, the content in the center, and a handler swaps the center with `setCenter`.

## A guide with a menu

A castle's visitor guide has three pages, chosen from a menu:

```java
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Label hall = new Label("The great hall seats 200 guests under an oak roof.");
        Label tower = new Label("The north tower has 147 steps and a view over the river.");
        Label kitchens = new Label("The kitchens once baked bread for the whole village.");

        Button toHall = new Button("Great hall");
        Button toTower = new Button("Tower");
        Button toKitchens = new Button("Kitchens");
        HBox menu = new HBox(10, toHall, toTower, toKitchens);
        menu.setPadding(new Insets(10));

        BorderPane frame = new BorderPane();
        frame.setTop(menu);
        frame.setCenter(hall);

        toHall.setOnAction(event -> frame.setCenter(hall));
        toTower.setOnAction(event -> frame.setCenter(tower));
        toKitchens.setOnAction(event -> frame.setCenter(kitchens));

        stage.setScene(new Scene(frame));
        stage.setTitle("Castle guide");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

```text
click Button "Tower"
```

- The three pages are made at the start and kept in variables. Only one of them is in the window at a time: the center region holds one node, and `setCenter` puts another one in its place.
- The page that is taken out isn't destroyed. The variable still refers to it, and the next click on its button puts it back.
- `start` calls `frame.setCenter(hall)` before the window shows, so the guide opens on a page and not on an empty middle. A view the user sees first is the **default** view.
- The menu, the scene and the stage stay the same the whole time. Only the center changes.

## Pages with more in them

A page can be any node, so it can be a whole layout with its own buttons and handlers. The front desk of the castle uses the guide to sell tickets too. Its pages are built by helper methods (module 48), once each:

```java
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    private int tickets;

    @Override
    public void start(Stage stage) {
        VBox hall = hallPage();
        VBox sales = ticketPage();

        Button toHall = new Button("Great hall");
        Button toTickets = new Button("Tickets");
        HBox menu = new HBox(10, toHall, toTickets);
        menu.setPadding(new Insets(10));

        BorderPane frame = new BorderPane();
        frame.setTop(menu);
        frame.setCenter(hall);
        toHall.setOnAction(event -> frame.setCenter(hall));
        toTickets.setOnAction(event -> frame.setCenter(sales));

        stage.setScene(new Scene(frame));
        stage.setTitle("Castle front desk");
        stage.show();
    }

    private VBox hallPage() {
        VBox page = new VBox(6, new Label("The great hall seats 200 guests."), new Label("Open daily from 10 to 17."));
        page.setPadding(new Insets(10));
        return page;
    }

    private VBox ticketPage() {
        Label sold = new Label("Tickets sold today: 0");
        Button sell = new Button("Sell a ticket");
        sell.setOnAction(event -> {
            this.tickets++;
            sold.setText("Tickets sold today: " + this.tickets);
        });
        VBox page = new VBox(6, sold, sell);
        page.setPadding(new Insets(10));
        return page;
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

```text
click Button "Tickets"
click Button "Sell a ticket"
click Button "Sell a ticket"
click Button "Great hall"
click Button "Tickets"
```

The ticket page was out of the window for a while, but it comes back as it was, with `Tickets sold today: 2`: it's the same VBox with the same label. The window as text shows the page indented under `center:`, with its own children under it.

## setScene or setCenter?

Both switch views, and they fit different windows:

- `stage.setScene(...)` replaces everything in the window. It suits views that share nothing, such as a login form and the program behind it, or step 1's settings.
- `frame.setCenter(...)` keeps the rest of the BorderPane: a menu in the top region, a status line at the bottom. It suits an application whose views are always one click away.

---

Source: [One frame, changing content](https://javaarena.com/learn/gui-views/changing-center/) in the module [GUI: multiple views](https://javaarena.com/learn/gui-views/) on Java Arena.

This module follows sections [13.5 Multiple views](https://java-programming.mooc.fi/part-13/5-multiple-views), [13.6 Summary](https://java-programming.mooc.fi/part-13/6-summary) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
