// AI-Generated
package module48_gui_windows_components_and_layouts_ai.step01_a_first_window_ai;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Challenge02Ai extends Application {

    @Override
    public void start(Stage stage) {
        Label next = new Label("Line 4 to Harbor Square: 7:23");
        stage.setScene(new Scene(next));
        stage.setTitle("Stop 16");
    }

    /**
     * The screen at stop 16 runs without an error, but no window ever appears. Two lines are missing, one in {@code start} and one in {@code main}: add them. The window's title is {@code Stop 16}, and it shows the label {@code Line 4 to Harbor Square: 7:23}.
     * Hints
     * 1. Nothing calls {@code start} yet: JavaFX calls it only after {@code main} starts JavaFX with {@code launch(Main.class);}.
     * 2. Even then, a window stays hidden until {@code start} calls {@code stage.show();}.
     */
    public static void main(String[] args) {

    }
}
