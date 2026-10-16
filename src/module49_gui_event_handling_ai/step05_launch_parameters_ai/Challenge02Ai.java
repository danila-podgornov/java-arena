// AI-Generated
package module49_gui_event_handling_ai.step05_launch_parameters_ai;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Challenge02Ai extends Application {

    @Override
    public void start(Stage stage) {
        System.out.println(getParameters().getNamed().get("copies"));
        System.out.println(getParameters().getNamed().size());
        System.out.println(getParameters().getUnnamed());
        System.out.println(getParameters().getRaw().size());

        stage.setScene(new Scene(new Label("Printing")));
        stage.setTitle("Print shop");
        stage.show();
    }

    /**
     * A print shop's program is started with a few arguments, some of them not quite as the shop meant. What does it print?
     * Hints
     * 1. An argument is named when it starts with two dashes, then a key that begins with a letter (or {@code _}), then {@code =}. {@code -color=red} has one dash, and {@code --draft} has no {@code =}.
     * 2. {@code copies} is given twice, and the last value wins, so the Map has one key. {@code getRaw()} keeps every argument.
     */
    public static void main(String[] args) {
        launch(Challenge02Ai.class, "--copies=3", "poster.pdf", "--copies=5", "-color=red", "--draft");
    }
}
