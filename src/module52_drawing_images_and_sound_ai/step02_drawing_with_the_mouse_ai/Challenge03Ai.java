// AI-Generated
package module52_drawing_images_and_sound_ai.step02_drawing_with_the_mouse_ai;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Challenge03Ai extends Application {

    @Override
    public void start(Stage stage) {
        Canvas canvas = new Canvas(200, 150);
        GraphicsContext pen = canvas.getGraphicsContext2D();

        stage.setScene(new Scene(new Pane(canvas)));
        stage.setTitle("Room planner");
        stage.show();
    }

    /**
     * A room planner draws furniture as rectangles. Drag on the canvas from one corner of a piece to the opposite corner: where the mouse is pressed is one corner, and where it's released is the other. On release, draw the rectangle between them: first filled in light steel blue ({@code Color.LIGHTSTEELBLUE}), then its outline with the same numbers in the pen's own stroke (black, 1 pixel wide). Its top left corner is at the smaller x and the smaller y of the two points, and its width and height are the distances between them, so a drag up or to the left works too. When the width or the height is 0 (a click, say), draw nothing. Nothing is drawn while the mouse moves. The window after the events below is drawn under them.
     * Hints
     * 1. The pressed handler stores the first corner in two instance variables. The released handler has the other corner in {@code event.getX()} and {@code event.getY()}.
     * 2. {@code Math.min(this.startX, event.getX())} is the left edge, and {@code Math.abs(event.getX() - this.startX)} the width; the same for y. Then {@code fillRect} and {@code strokeRect} with those four numbers, inside an {@code if} that checks both are above 0.
     */
    public static void main(String[] args) {
        launch(Challenge03Ai.class);
    }
}
