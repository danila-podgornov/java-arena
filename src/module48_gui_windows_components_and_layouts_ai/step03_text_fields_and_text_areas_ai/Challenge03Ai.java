// AI-Generated
package module48_gui_windows_components_and_layouts_ai.step03_text_fields_and_text_areas_ai;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Challenge03Ai extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        List<String> lines = Files.readAllLines(Paths.get("member.txt"));
        FlowPane form = new FlowPane();

        stage.setScene(new Scene(form));
        stage.setTitle("Renewals");
        stage.show();
    }

    /**
     * The renewals desk shows a member's details from the file {@code member.txt}. Its first line is the member's name, and its second line the card number. Build the window: the title is {@code Renewals}, and the root is a FlowPane that holds, in this order:
     * <ul>
     * <li>the label {@code Member}
     * <li>a text field holding the name, not editable
     * <li>the label {@code Card}
     * <li>a text field holding the card number, not editable
     * <li>the label {@code PIN}
     * <li>an empty PasswordField with the prompt text {@code 4 digits}
     * </ul>
     * <p>No spacing, padding or sizes. For the file shown below, the window should look like the drawing under it.
     * Hints
     * 1. {@code lines.get(0)} is the name and {@code lines.get(1)} the card number. {@code new TextField(lines.get(0))} makes a field that starts with that text.
     * 2. Call {@code setEditable(false)} on both text fields, and {@code setPromptText("4 digits")} on the PasswordField. Then add the six nodes in the order of the task.
     */
    public static void main(String[] args) {
        launch(Challenge03Ai.class);
    }
}
