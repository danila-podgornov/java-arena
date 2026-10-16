// AI-Generated
package module49_gui_event_handling_ai.step03_reacting_to_typing_ai;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Challenge01Ai extends Application {

    @Override
    public void start(Stage stage) {
        TextField name = new TextField();
        name.setPromptText("Name");
        Label preview = new Label("Badge: ");
        name.___().___((observable, oldValue, newValue) -> {
            preview.setText("Badge: " + ___.toUpperCase());
        });

        stage.setScene(new Scene(new VBox(name, preview)));
        stage.setTitle("Name badge");
        stage.show();
    }

    /**
     * A name badge printer shows a preview while the name is typed. Fill in the three blanks, so that the label shows {@code Badge: } and the name in capital letters after every change of the text. The task card shows the window after typing {@code Ada Lovelace}.
     * Hints
     * 1. The text field's text is a property, returned by {@code textProperty()}, and a listener is added to it with {@code addListener}.
     * 2. The last blank is the text after the change: the listener's third parameter, {@code newValue}.
     */
    public static void main(String[] args) {
        launch(Challenge01Ai.class);
    }
}
