// AI-Generated
package module52_drawing_images_and_sound_ai.step02_drawing_with_the_mouse_ai;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Challenge01Ai extends Application {

    @Override
    public void start(Stage stage) {
        Canvas canvas = new Canvas(200, 150);
        GraphicsContext pen = canvas.getGraphicsContext2D();
        Label nests = new Label("Nests: 0");

        stage.setScene(new Scene(new VBox(canvas, nests)));
        stage.setTitle("Nest map");
        stage.show();
    }

    /**
     * A park ranger marks on a map where birds have built their nests. The starter code makes a canvas of 200 x 150 pixels with the label {@code Nests: 0} under it. Make each click on the canvas mark a nest: an orange ({@code Color.ORANGE}) filled circle 12 pixels across, with its center where the mouse was clicked. The label then says how many nests are marked: {@code Nests: 2} after two clicks. The window after the two clicks listed below is drawn under them.
     * Hints
     * 1. {@code canvas.setOnMouseClicked(event -> { ... });} runs at each click. The circle's square starts 6 pixels left of and above the mouse: {@code pen.fillOval(event.getX() - 6, event.getY() - 6, 12, 12);}.
     * 2. The count has to survive from one click to the next, so keep it in an instance variable, {@code private int marked;}, and add one to it in the handler before setting the label's text.
     */
    public static void main(String[] args) {
        launch(Challenge01Ai.class);
    }
}
