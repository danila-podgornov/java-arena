// AI-Generated
package module49_gui_event_handling_ai.step01_buttons_that_do_something_ai;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Challenge02Ai extends Application {

    @Override
    public void start(Stage stage) {
        Label tally = new Label("Votes:");
        Button yes = new Button("Yes");
        Button no = new Button("No");
        yes.setOnAction(event -> tally.setText(tally.getText() + " Y"));
        no.setOnAction(event -> tally.setText(tally.getText() + " N"));
        System.out.println(tally.getText());
        yes.fire();
        no.fire();
        yes.fire();
        System.out.println(tally.getText());
        no.setOnAction(event -> tally.setText("Votes: none"));
        no.fire();
        yes.fire();
        System.out.println(tally.getText());

        stage.setScene(new Scene(new VBox(tally, new HBox(yes, no))));
        stage.setTitle("Club vote");
        stage.show();
    }

    /**
     * A club votes by a show of hands, and its secretary tries out a window for counting them. The program clicks its own buttons with {@code fire()}. What does it print?
     * Hints
     * 1. {@code setOnAction} only gives the button its handler: the label changes when the button fires, not before. Each handler adds to the end of the label's text.
     * 2. A button has one handler for its action. The second {@code setOnAction} on {@code no} replaces the first one, so from then on {@code no} sets the text to {@code Votes: none}, and {@code yes} still adds {@code  Y} after it.
     */
    public static void main(String[] args) {
        launch(Challenge02Ai.class);
    }
}
