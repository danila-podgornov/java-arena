// AI-Generated
package module48_gui_windows_components_and_layouts_ai.step02_scene_layout_and_components_ai;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Challenge03Ai extends Application {

    @Override
    public void start(Stage stage) {
        Label note = new Label("No sugar");
        Button cup = new Button("Cup");
        FlowPane draft = new FlowPane(note, cup);
        FlowPane slip = new FlowPane(new Label("Order 30: cocoa"));
        System.out.println(draft.getChildren().size() + " " + slip.getChildren().size());

        slip.getChildren().add(note);
        System.out.println(draft.getChildren().size() + " " + slip.getChildren().size());

        slip.getChildren().add(1, cup);
        System.out.println(slip.getChildren().indexOf(note) + " " + draft.getChildren().isEmpty());

        stage.setScene(new Scene(slip));
        stage.show();
    }

    /**
     * The slip for order 30 is drafted in one FlowPane and then built in another. A node can be in one place at a time. {@code add(1, cup)} puts {@code cup} at index 1 of the list. What does the program print?
     * Hints
     * 1. At first {@code draft} holds the note and the cup, and {@code slip} holds one label. Adding {@code note} to {@code slip} takes it out of {@code draft}.
     * 2. {@code add(1, cup)} takes the cup out of {@code draft} too and puts it between the order's label and the note, so the note moves to index 2.
     */
    public static void main(String[] args) {
        launch(Challenge03Ai.class);
    }
}
