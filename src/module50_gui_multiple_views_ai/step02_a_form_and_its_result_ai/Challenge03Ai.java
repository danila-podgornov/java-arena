// AI-Generated
package module50_gui_multiple_views_ai.step02_a_form_and_its_result_ai;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Challenge03Ai extends Application {

    @Override
    public void start(Stage stage) {
        TextArea errands = new TextArea();
        Button make = new Button("Make list");
        Label message = new Label("");
        Scene form = new Scene(new VBox(8, errands, make, message));

        stage.setScene(form);
        stage.setTitle("Errands");
        stage.show();
    }

    /**
     * A list of errands. The form is a VBox with the spacing 8 holding a text area, the button {@code Make list} and an empty label for messages; it's built already. The user writes the day's errands in the text area, one per line.
     * <p><b>Make list</b> builds a new scene, each time it's clicked: a VBox with the spacing 4 and no padding, holding for each line of the text area a label with {@code [ ] } and the line, trimmed, like {@code [ ] Buy stamps}, in the order of the lines, and at the end a new button {@code Edit}. Lines that are empty, or have only spaces, get no label. Edit shows the form again. When it builds the list, Make list also empties the message label, so that no old message is left when Edit brings the form back.
     * <p>When no line has any text, Make list stays on the form and the message label says {@code Write at least one errand.}
     * <p>{@code split("\n")} splits the text into its lines. The task card shows the window after writing {@code Buy stamps}, {@code Return the books}, an empty line and {@code Fix the bike}, and clicking Make list.
     * Hints
     * 1. In Make list's handler, make a new {@code VBox(4)} and go through {@code errands.getText().split("\n")} with a for-each loop, adding a {@code new Label("[ ] " + line.trim())} for each line whose trimmed text isn't empty.
     * 2. If the VBox got no labels, set the message. Otherwise add a new Edit button whose handler calls {@code stage.setScene(form)}, and show {@code new Scene(list)}. The inner lambda needs a parameter name other than {@code event}, such as {@code click}, since {@code event} is already the outer lambda's.
     */
    public static void main(String[] args) {
        launch(Challenge03Ai.class);
    }
}
