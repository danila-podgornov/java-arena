// AI-Generated
package module49_gui_event_handling_ai.step05_launch_parameters_ai;

import java.util.Map;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Challenge01Ai extends Application {

    @Override
    public void start(Stage stage) {
        Map<String, String> named = getParameters().___();
        Label flight = new Label("Flight " + named.get("flight"));
        Label gate = new Label("Gate: " + named.___("gate", "not yet known"));

        stage.setScene(new Scene(new VBox(flight, gate)));
        stage.setTitle("Boarding");
        stage.show();
    }

    /**
     * A screen at an airport's gate shows a flight and its gate, given as launch parameters such as {@code --flight=AY123 --gate=12}. When there's no gate yet, the screen says {@code Gate: not yet known}. Fill in the three blanks. The task card shows the window for the arguments {@code --flight=AY123 --gate=12}.
     * Hints
     * 1. The {@code --key=value} arguments come from {@code getParameters().getNamed()}, a Map. For a key that may be missing, a Map has {@code getOrDefault(key, fallback)}.
     * 2. {@code main} hands its own arguments on to the application: {@code launch(Main.class, args)}.
     */
    public static void main(String[] args) {
        launch(Challenge01Ai.class, ___);
    }
}
