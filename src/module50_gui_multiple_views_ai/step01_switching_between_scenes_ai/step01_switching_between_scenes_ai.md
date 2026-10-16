> [!info] AI-Generated

# Switching between scenes

Each window in modules 48 and 49 showed one scene, set once in `start`. Most applications have more than one **view**: a main view, a page of settings, a help page, a form and then its result. The user moves between them by clicking, and the window shows one view at a time.

This module shows a few ways to build that. The simplest one uses what you know already: a stage shows a scene, and it can be given another scene at any time, also in an event handler.

## Two scenes, one window

A sailing app shows the distance to the next harbor, and it has a page of settings:

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
        Label route = new Label("Next harbor: 12 km");
        Button toSettings = new Button("Settings");
        Scene routeScene = new Scene(new VBox(10, route, toSettings));

        Label heading = new Label("Settings");
        Button back = new Button("Back");
        Scene settingsScene = new Scene(new VBox(10, heading, back));

        toSettings.setOnAction(event -> stage.setScene(settingsScene));
        back.setOnAction(event -> stage.setScene(routeScene));

        stage.setScene(routeScene);
        stage.setTitle("Sailing");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

```text
click Button "Settings"
```

The window is drawn after a click on Settings, so it shows the settings scene. (The windows in the lesson text are drawn as the clicks listed with them leave them. When you run a program of your own, you can click its window, as in modules 48 and 49: Java Arena runs the program again from the start with all your clicks so far, and draws the scene it ends on.)

- `start` builds two scenes, each with a layout and nodes of its own, and the window starts with the route scene.
- The handler of Settings calls `stage.setScene(settingsScene)`. The window shows the other scene at once, in place of everything it showed before.
- The title belongs to the stage, not to a scene, so it stays `Sailing`. A handler can change it too, with `stage.setTitle(...)`.
- The lambdas use `stage`, `routeScene` and `settingsScene`: a parameter of `start` and two local variables. None of them changes after it gets its value, so they're effectively final, and a lambda may use them (module 49).
- The route scene isn't gone while the settings show. The variable `routeScene` still refers to it, with its label and its button, and Back shows it again.

The window as text, and the checks of this module, see only the scene that the window shows at the end.

## Changes in a scene that isn't showing

The settings get two buttons that choose how distances are shown:

```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Label route = new Label("Next harbor: 12 km");
        Button toSettings = new Button("Settings");
        Scene routeScene = new Scene(new VBox(10, route, toSettings));

        Label heading = new Label("Distances in kilometers");
        Button km = new Button("Kilometers");
        Button nautical = new Button("Nautical miles");
        Button back = new Button("Back");
        Scene settingsScene = new Scene(new VBox(10, heading, new HBox(10, km, nautical), back));

        toSettings.setOnAction(event -> stage.setScene(settingsScene));
        back.setOnAction(event -> stage.setScene(routeScene));
        km.setOnAction(event -> {
            heading.setText("Distances in kilometers");
            route.setText("Next harbor: 12 km");
        });
        nautical.setOnAction(event -> {
            heading.setText("Distances in nautical miles");
            route.setText("Next harbor: 6.5 nautical miles");
        });

        stage.setScene(routeScene);
        stage.setTitle("Sailing");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

```text
click Button "Settings"
click Button "Nautical miles"
click Button "Back"
```

The handler of Nautical miles changes the label `route`, which is in the route scene, while the window shows the settings. That's fine: the nodes of a scene that isn't showing are ordinary objects, and they keep everything that's done to them. When Back shows the route scene again, its label has the new text.

That's why `start` builds each scene once and keeps it in a variable. Switching only chooses which scene the window shows, and nothing in the other scene is lost: not a label's text, and not what the user typed into a text field.

## One scene, one root

A scene's root belongs to that scene only. `new Scene(layout)` with a layout that is already the root of another scene stops with an IllegalArgumentException ("is already set as root of another scene"). So a handler that does `stage.setScene(new Scene(sameLayout))` works the first time and fails the second. Build each scene once, as above, and the problem doesn't come up.

---

Source: [Switching between scenes](https://javaarena.com/learn/gui-views/switching-scenes/) in the module [GUI: multiple views](https://javaarena.com/learn/gui-views/) on Java Arena.

This module follows sections [13.5 Multiple views](https://java-programming.mooc.fi/part-13/5-multiple-views), [13.6 Summary](https://java-programming.mooc.fi/part-13/6-summary) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
