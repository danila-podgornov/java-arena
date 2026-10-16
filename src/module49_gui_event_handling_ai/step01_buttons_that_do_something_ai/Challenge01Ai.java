// AI-Generated
package module49_gui_event_handling_ai.step01_buttons_that_do_something_ai;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Challenge01Ai extends Application {

    @Override
    public void start(Stage stage) {
        Label sign = new Label("Room 4 is free");
        Button book = new Button("Book");
        Button leave = new Button("Leave");
        book.___(event ___ sign.setText("Room 4 is booked"));
        leave.setOnAction(event -> sign.___("Room 4 is free"));

        stage.setScene(new Scene(new VBox(sign, new HBox(book, leave))));
        stage.setTitle("Study room 4");
        stage.show();
    }

    /**
     * A study room has a screen by its door. Fill in the three blanks, so that {@code Book} changes the label to {@code Room 4 is booked} and {@code Leave} changes it back to {@code Room 4 is free}. The task card shows the window after a click on Book.
     * Hints
     * 1. A button gets its handler with {@code setOnAction}, and a lambda has an arrow, {@code ->}, between its parameter and its body.
     * 2. The handler of Leave changes the label's text, as the one of Book does: {@code sign.setText(...)}.
     */
    public static void main(String[] args) {
        launch(Challenge01Ai.class);
    }
}
