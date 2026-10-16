// AI-Generated
package module49_gui_event_handling_ai.step03_reacting_to_typing_ai;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Challenge02Ai extends Application {

    @Override
    public void start(Stage stage) {
        TextField code = new TextField();
        code.textProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println(oldValue.length() + " to " + newValue.length());
        });
        code.setText("SPRING");
        code.appendText("25");
        code.setText("SPRING25");
        code.clear();
        code.clear();
        System.out.println("Done: " + code.getText().length());

        stage.setScene(new Scene(new VBox(code)));
        stage.setTitle("Checkout");
        stage.show();
    }

    /**
     * A shop's checkout has a field for a discount code, with a listener that prints the length of the text before and after each change. {@code appendText} adds a whole text with one change, and {@code clear()} empties the field. What does the program print?
     * Hints
     * 1. The listener runs only when the text really changes: {@code setText("SPRING25")} when the text already is {@code SPRING25} changes nothing, and neither does clearing an empty field.
     * 2. {@code appendText("25")} is a single change from 6 characters to 8, unlike typing, which adds one character at a time.
     */
    public static void main(String[] args) {
        launch(Challenge02Ai.class);
    }
}
