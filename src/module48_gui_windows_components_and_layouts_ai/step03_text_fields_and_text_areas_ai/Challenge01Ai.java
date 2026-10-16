// AI-Generated
package module48_gui_windows_components_and_layouts_ai.step03_text_fields_and_text_areas_ai;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Challenge01Ai extends Application {

    @Override
    public void start(Stage stage) {
        FlowPane form = new FlowPane();

        stage.setScene(new Scene(form));
        stage.setTitle("Renew a loan");
        stage.show();
    }

    /**
     * A library's window for renewing a loan. Build it: the title is {@code Renew a loan}, and the root is a FlowPane that holds, in this order:
     * <ul>
     * <li>the label {@code Card number}
     * <li>an empty text field with the prompt text {@code 8 digits}
     * <li>the label {@code Book}
     * <li>an empty text field with the prompt text {@code Title}
     * <li>the button {@code Renew}
     * </ul>
     * <p>No spacing, padding or sizes. The window it should show is drawn below.
     * Hints
     * 1. TextField needs its import: {@code import javafx.scene.control.TextField;}. Make each field, then give it its prompt text with {@code setPromptText("8 digits")}.
     * 2. Keep each field in a variable, so you can set its prompt text before adding it: {@code form.getChildren().addAll(new Label("Card number"), card, ...);}.
     */
    public static void main(String[] args) {
        launch(Challenge01Ai.class);
    }
}
