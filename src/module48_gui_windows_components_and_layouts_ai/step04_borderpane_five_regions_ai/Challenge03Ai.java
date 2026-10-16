// AI-Generated
package module48_gui_windows_components_and_layouts_ai.step04_borderpane_five_regions_ai;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Challenge03Ai extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        List<String> lines = Files.readAllLines(Paths.get("recipe.txt"));
        BorderPane card = new BorderPane();

        stage.setScene(new Scene(card));
        stage.setTitle("Recipe card");
        stage.show();
    }

    /**
     * The recipe app reads a card from the file {@code recipe.txt}. Its first line is the dish, its second line how long the dish takes, and every line after that is a step of the method. A recipe has at least two steps. Build the window: the title is {@code Recipe card}, and the root is a BorderPane with:
     * <ul>
     * <li>top: a label with the dish, in the font {@code Font.font("Serif", 20)}
     * <li>right: a label with the time
     * <li>center: a TextArea holding the steps, each on its own line ({@code \n} between them, none after the last)
     * <li>bottom: a label with the number of steps, like {@code 3 steps}
     * </ul>
     * <p>The left region stays empty. The text area doesn't wrap its lines, and it stays editable. For the file shown below, the window should look like the drawing under it.
     * Hints
     * 1. {@code lines.get(0)} is the dish and {@code lines.get(1)} the time. The steps are the lines from index 2 on: a loop from 2 to {@code lines.size() - 1}.
     * 2. Build the area's text in a String with a loop that adds {@code \n} before every step but the first. The number of steps is {@code lines.size() - 2}.
     */
    public static void main(String[] args) {
        launch(Challenge03Ai.class);
    }
}
