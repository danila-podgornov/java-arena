// AI-Generated
package module50_gui_multiple_views_ai.step02_a_form_and_its_result_ai;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Challenge01Ai extends Application {

    @Override
    public void start(Stage stage) {
        TextField name = new TextField();
        Button checkIn = new Button("Check in");
        Label message = new Label("");
        Scene form = new Scene(new VBox(8, new Label("Pet's name"), name, checkIn, message));

        Label room = new Label("");
        Button next = new Button("Next pet");
        Scene roomScene = new Scene(new VBox(8, room, next));

        stage.setScene(form);
        stage.setTitle("Pet hotel");
        stage.show();
    }

    /**
     * A pet hotel checks pets in. Both scenes are built already, each a VBox with the spacing 8:
     * <ul>
     * <li>the form: the label {@code Pet's name}, a text field, the button {@code Check in} and an empty label for messages
     * <li>the room: an empty label and the button {@code Next pet}
     * </ul>
     * <p>Give the buttons their handlers:
     * <ul>
     * <li><b>Check in</b>: when the field is empty (or has only spaces), the message label says {@code Type the pet's name first.} and the window stays on the form. Otherwise the room's label says which room is ready, like {@code Room 1 is ready for Rex.} (with the name trimmed), and the window shows the room scene. The rooms are numbered from 1, in the order the pets check in: keep the count in an instance variable of Main.
     * <li><b>Next pet</b>: empties the text field and the message label, and shows the form again.
     * </ul>
     * <p>The task card shows the window after typing {@code Rex} and clicking Check in.
     * Hints
     * 1. In Check in's handler, read the name once: {@code String pet = name.getText().trim();}. If {@code pet.isEmpty()}, set the message; otherwise count the room, set the room's label and call {@code stage.setScene(roomScene)}.
     * 2. The room number changes at each check-in, so it can't be a local variable of {@code start}: declare {@code private int rooms;} in the class and add one with {@code this.rooms++} before you use it.
     */
    public static void main(String[] args) {
        launch(Challenge01Ai.class);
    }
}
