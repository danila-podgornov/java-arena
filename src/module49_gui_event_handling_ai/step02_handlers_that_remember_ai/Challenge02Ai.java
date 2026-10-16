// AI-Generated
package module49_gui_event_handling_ai.step02_handlers_that_remember_ai;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Challenge02Ai extends Application {

    @Override
    public void start(Stage stage) {
        TextField name = new TextField("Ada");
        Label note = new Label("");
        Button sign = new Button("Sign");
        String early = name.getText();
        sign.setOnAction(event -> note.setText(early + " / " + name.getText()));
        name.setText("Grace");
        sign.fire();
        System.out.println(note.getText());
        name.appendText(" Hopper");
        System.out.println(note.getText());
        sign.fire();
        System.out.println(note.getText());

        stage.setScene(new Scene(new VBox(name, sign, note)));
        stage.setTitle("Delivery note");
        stage.show();
    }

    /**
     * A delivery note gets the name of whoever signs for a parcel. Watch which value each part of the handler uses, and when the label changes. What does the program print?
     * Hints
     * 1. {@code early} got its value once, before the handler was even set: {@code Ada}. {@code name.getText()} in the handler reads the field each time the handler runs.
     * 2. The label changes only when the handler runs. Changing the field after a {@code fire()} doesn't change the label until the next {@code fire()}.
     */
    public static void main(String[] args) {
        launch(Challenge02Ai.class);
    }
}
