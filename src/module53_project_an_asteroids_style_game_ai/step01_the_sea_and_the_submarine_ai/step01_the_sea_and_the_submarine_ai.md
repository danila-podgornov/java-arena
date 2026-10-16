> [!info] AI-Generated

# The sea and the submarine

The MOOC's section 14.3 builds a larger program step by step: a game in the style of Asteroids, where a ship turns, speeds up, shoots and dodges rocks. This module builds the same kind of game in a theme of its own: a small **yellow submarine** in a dark sea. It steers with the arrow keys, dodges **jellyfish** and fires **bubbles** at them. Each step adds one idea, and by step 8 it's a whole game with points and a game over.

## How a game runs on this page

As with the windows, charts and drawings before (module 48 explained it), Java Arena's JavaFX is a practice version written for this site, and the page draws the game from what your program told JavaFX: every shape with its corners, its place, its turn and its color, approximately. The game **doesn't run live** here. Your program runs from its start to its end each time: you choose which keys are held and how many frames to run, the program runs those frames, and the page plays them back as an animation. The shapes, the turning, `Point2D` and the collision test of the practice version were compared with real JavaFX 21. Each model solution's game was also run on real JavaFX 21 frame by frame, with the same keys, and left the same shapes in the same places, turned the same way, after every step of each test. On your own computer, the same code runs live with the real JavaFX (step 8 says how).

## A pane of a fixed size

The layouts of part 13 placed their children by themselves: a VBox one under the other, a GridPane in cells. A game places everything itself, so it uses the plainest layout, **Pane**, which leaves each child where the child says. Without one, a Pane is only as big as its children's own shapes, and moving a shape with translate doesn't count, so a game always gives it a size with `setPrefSize(width, height)`: its **preferred** size. A Scene made from that pane, without a size, takes the pane's.

Then come the **shapes**, from the package `javafx.scene.shape`. They are nodes, like labels and canvases, so they go into the pane's children:

```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Pane pane = new Pane();
        pane.setPrefSize(360, 240);

        Rectangle water = new Rectangle(360, 240, Color.MIDNIGHTBLUE);
        Polygon sub = new Polygon(-15, -6, 9, -6, 15, 0, 9, 6, -15, 6);
        sub.setFill(Color.GOLD);
        sub.setTranslateX(180);
        sub.setTranslateY(120);
        Circle bubble = new Circle(4, Color.LIGHTCYAN);
        bubble.setTranslateX(215);
        bubble.setTranslateY(110);

        pane.getChildren().addAll(water, sub, bubble);

        stage.setScene(new Scene(pane));
        stage.setTitle("Deep dive");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

- `new Rectangle(360, 240, Color.MIDNIGHTBLUE)` is a filled rectangle 360 wide and 240 high, with its top left corner at (0, 0): the water.
- `new Polygon(...)` is a shape with corners, given as numbers in pairs: x, then y, for each corner in turn. The submarine has five corners: (-15, -6), (9, -6), (15, 0), (9, 6) and (-15, 6). Its nose, (15, 0), points to the right. A polygon is closed: the last corner joins the first.
- `new Circle(4, Color.LIGHTCYAN)` is a filled circle with a radius of 4 and its center at (0, 0).
- `setFill` gives a shape its color. A new shape is black, as JavaFX makes it.
- `pane.getChildren().addAll(water, sub, bubble)` puts the shapes into the pane. Later children are drawn over earlier ones, so the water goes first.

Coordinates work as on module 52's canvas: (0, 0) is the top left corner of the pane, x grows to the right and y grows **down**.

## Moving a shape: translate

The submarine's corners are around (0, 0), the pane's top left corner. `setTranslateX(180)` and `setTranslateY(120)` move the whole shape: what was at (0, 0) is drawn at (180, 120), the middle of the pane, and every corner moves with it. The corners themselves don't change: `getPoints()` gives them back as one list of numbers (x, y, x, y and so on), so `sub.getPoints().size()` is twice the number of corners, and it's the same list after a move. That is how the game will move things: it never changes a shape's corners, only its translate, frame after frame. The bubble is moved the same way, to (215, 110).

## Turning a shape: rotate

`setRotate(degrees)` turns a shape. A positive angle turns it **clockwise** on the screen (y grows down, so that's the direction of growing angles here), a negative one counterclockwise, and the shape turns about the **center of its own corners**: the middle of the box around its corners before it's moved. The submarine's corners go from -15 to 15 across and from -6 to 6 down, so that center is (0, 0), the point that translate moves, and the submarine turns on the spot. That's why the game's shapes are drawn around (0, 0).

Three submarines, turned 0, 45 and -90 degrees:

```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Pane pane = new Pane();
        pane.setPrefSize(360, 240);
        pane.getChildren().add(new Rectangle(360, 240, Color.MIDNIGHTBLUE));

        int[] turns = {0, 45, -90};
        for (int i = 0; i < turns.length; i++) {
            Polygon sub = new Polygon(-15, -6, 9, -6, 15, 0, 9, 6, -15, 6);
            sub.setFill(Color.GOLD);
            sub.setTranslateX(70 + 110 * i);
            sub.setTranslateY(120);
            sub.setRotate(turns[i]);
            pane.getChildren().add(sub);
        }

        stage.setScene(new Scene(pane));
        stage.setTitle("Turning");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

The first points right, the second down and to the right (45 degrees clockwise), the third straight up (90 degrees counterclockwise). Each loop round makes a **new** Polygon: a node can be in a pane only once, so three submarines need three shapes.

## The window as text

"The window as text" under each drawing lists the shapes, and it's what the challenges compare:

```text
Window "Turning"
  Pane 360 x 240
    Rectangle 360 x 240 at (0, 0), fill #191970
    Polygon (-15, -6) (9, -6) (15, 0) (9, 6) (-15, 6), at (70, 120), fill #ffd700
    Polygon (-15, -6) (9, -6) (15, 0) (9, 6) (-15, 6), at (180, 120), rotate 45, fill #ffd700
    Polygon (-15, -6) (9, -6) (15, 0) (9, 6) (-15, 6), at (290, 120), rotate -90, fill #ffd700
```

`Pane 360 x 240` is the pane's preferred size. A polygon's line has its corners as given, then `at` and its translate, then its rotate (when it isn't 0) and its fill. A rectangle's `at` is its own corner, and a circle's `at` is its center; a circle that is moved adds `translate (215, 110)`. The numbers are compared exactly, so a task always says where each shape goes, how far it's turned and in which color.

---

Source: [The sea and the submarine](https://javaarena.com/learn/asteroids/shapes/) in the module [Project: an Asteroids-style game](https://javaarena.com/learn/asteroids/) on Java Arena.

This module follows section [14.3 Larger application: Asteroids](https://java-programming.mooc.fi/part-14/3-larger-application-asteroids) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
