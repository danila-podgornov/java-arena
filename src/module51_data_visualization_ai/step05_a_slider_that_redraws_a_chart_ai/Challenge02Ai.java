// AI-Generated
package module51_data_visualization_ai.step05_a_slider_that_redraws_a_chart_ai;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Challenge02Ai extends Application {

    @Override
    public void start(Stage stage) {
        Slider volume = new Slider(0, 10, 5);
        volume.valueProperty().addListener((observable, oldValue, newValue) -> System.out.println(oldValue + " to " + newValue));
        volume.setValue(8);
        volume.setValue(12);
        volume.setValue(10);
        System.out.println(volume.getValue());

        stage.setScene(new Scene(new VBox(volume)));
        stage.setTitle("Volume");
        stage.show();
    }

    /**
     * A music app has a volume slider. What does this program print?
     * Hints
     * 1. The value is a double, and the listener gets Numbers that print as doubles do: {@code 5.0}, not {@code 5}. A value above the max is kept at the max.
     * 2. So {@code setValue(12)} moves the slider to 10. Then {@code setValue(10)} changes nothing, and a listener runs only at a real change.
     */
    public static void main(String[] args) {
        launch(Challenge02Ai.class);
    }
}
