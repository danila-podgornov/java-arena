// AI-Generated
package module48_gui_windows_components_and_layouts_ai.step02_scene_layout_and_components_ai;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Challenge02Ai extends Application {

    @Override
    public void start(Stage stage) {
        FlowPane slip = new FlowPane();

        stage.setScene(new Scene(slip));
        stage.setTitle("Syrups");
        stage.show();
    }

    /**
     * The café's syrups are in the file {@code syrups.txt}, one per line. Build the slip that offers them: the window's title is {@code Syrups}, and its root is a FlowPane holding the label {@code Add a syrup:} and then a button for each line of the file, in the file's order. For the file shown below, the window should look like the drawing under it.
     * Hints
     * 1. Read the lines with {@code Files.readAllLines(Paths.get("syrups.txt"))}, which needs {@code import java.nio.file.Files;} and {@code import java.nio.file.Paths;}. It can throw an IOException, so add {@code throws Exception} to the header of {@code start}.
     * 2. Add the label first, then loop over the lines and add a {@code new Button(syrup)} for each one.
     */
    public static void main(String[] args) {
        launch(Challenge02Ai.class);
    }
}
