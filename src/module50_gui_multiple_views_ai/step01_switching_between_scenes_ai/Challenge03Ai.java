// AI-Generated
package module50_gui_multiple_views_ai.step01_switching_between_scenes_ai;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Challenge03Ai extends Application {

    @Override
    public void start(Stage stage) {
        Button begin = new Button("Start");
        Scene startScene = new Scene(new VBox(10, new Label("Space quiz"), begin));

        Button mars = new Button("Mars");
        Button jupiter = new Button("Jupiter");
        Button venus = new Button("Venus");
        HBox answers = new HBox(10, mars, jupiter, venus);
        Scene questionScene = new Scene(new VBox(10, new Label("Which planet is the largest?"), answers));

        stage.setScene(startScene);
        stage.setTitle("Space quiz");
        stage.show();
    }

    /**
     * A quiz with one question has three scenes. The start scene and the question scene are built already, each a VBox with the spacing 10:
     * <ul>
     * <li>start: the label {@code Space quiz} and the button {@code Start}
     * <li>question: the label {@code Which planet is the largest?} and an HBox with the spacing 10 holding the buttons {@code Mars}, {@code Jupiter} and {@code Venus}
     * </ul>
     * <p>Build the third scene, the result: a VBox with the spacing 10 and no padding, holding an empty label and the button {@code Play again}. Then give the buttons their handlers:
     * <ul>
     * <li>{@code Start} shows the question scene.
     * <li>{@code Jupiter} sets the result's label to {@code Right: Jupiter is the largest.} and shows the result scene.
     * <li>{@code Mars} and {@code Venus} set it to {@code Not quite: the largest is Jupiter.} and show the result scene.
     * <li>{@code Play again} shows the start scene.
     * </ul>
     * <p>The window's title stays {@code Space quiz}. The task card shows the window after Start and Jupiter.
     * Hints
     * 1. The result scene is built like the other two: {@code Label result = new Label("");}, a {@code Button} with the text {@code Play again}, and {@code new Scene(new VBox(10, result, again))}.
     * 2. An answer's handler has two statements in braces: set the label's text, then {@code stage.setScene(resultScene);}.
     */
    public static void main(String[] args) {
        launch(Challenge03Ai.class);
    }
}
