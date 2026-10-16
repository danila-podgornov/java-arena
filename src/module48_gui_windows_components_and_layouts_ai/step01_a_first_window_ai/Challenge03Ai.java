// AI-Generated
package module48_gui_windows_components_and_layouts_ai.step01_a_first_window_ai;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Challenge03Ai extends Application {

    @Override
    public void start(Stage stage) {
        System.out.println("Title: " + stage.getTitle());
        stage.setTitle("Stop 17");
        stage.setScene(new Scene(new Label("Line 4 to Harbor Square: 7:27")));
        stage.show();
        System.out.println("Title: " + stage.getTitle());
    }

    /**
     * Stop 17's screen prints a few lines on its way. A stage that was never given a title has the title {@code null}. What does the program print?
     * Hints
     * 1. {@code main} runs first. {@code launch} calls {@code start}, and {@code start} runs to its end before {@code launch} returns.
     * 2. {@code launch} returns only when the window is closed, so {@code Closed} comes after everything {@code start} prints.
     */
    public static void main(String[] args) {
        System.out.println("Starting");
        launch(Challenge03Ai.class);
        System.out.println("Closed");
    }
}
