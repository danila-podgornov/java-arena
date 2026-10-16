// AI-Generated
package module49_gui_event_handling_ai.step01_buttons_that_do_something_ai;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Challenge03Ai extends Application {

    @Override
    public void start(Stage stage) {
        TextField candies = new TextField();
        candies.setPromptText("Candies");
        TextField children = new TextField();
        children.setPromptText("Children");
        Button share = new Button("Share");
        Button clear = new Button("Clear");
        Label result = new Label("");

        stage.setScene(new Scene(new VBox(candies, children, new HBox(share, clear), result)));
        stage.setTitle("Sharing candy");
        stage.show();
    }

    /**
     * A children's party hands out candy. The window is built already: a text field for the number of candies (the prompt text {@code Candies}), one for the number of children ({@code Children}), the buttons {@code Share} and {@code Clear}, and an empty label. Give the buttons their handlers:
     * <ul>
     * <li><b>Share</b> reads both numbers and sets the label to how many candies each child gets and how many are left over, like {@code Each child gets 7, and 3 are left over} for 45 candies and 6 children.
     * <li><b>Clear</b> empties both text fields and the label. {@code clear()} empties a text field.
     * </ul>
     * <p>The checks always type whole numbers, and at least 1 child, before they click Share. The task card shows the window after typing 45 and 6 and clicking Share.
     * Hints
     * 1. In Share's handler, read both fields with {@code getText()} and turn them into numbers with {@code Integer.valueOf(...)}. Integer division {@code /} gives each child's share, and {@code %} what's left over.
     * 2. Clear's handler has three statements, so its body goes in braces: {@code candies.clear();}, {@code children.clear();} and {@code result.setText("");}.
     */
    public static void main(String[] args) {
        launch(Challenge03Ai.class);
    }
}
