// AI-Generated
package module48_gui_windows_components_and_layouts_ai.step02_scene_layout_and_components_ai;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Challenge01Ai extends Application {

    @Override
    public void start(Stage stage) {
        FlowPane slip = new FlowPane();

        stage.setScene(new Scene(slip));
        stage.show();
    }

    /**
     * The café's slip for tea. Build this window: its title is {@code Tea order}, and the scene's root is a FlowPane that holds, in this order, the label {@code Order 21: green tea} and the buttons {@code Pot}, {@code Cup} and {@code To go}. No spacing, padding or sizes. The window it should show is drawn below.
     * Hints
     * 1. Each node goes into {@code slip.getChildren()}, the pane's list of children, in the order it should appear. The title belongs to the stage.
     * 2. {@code slip.getChildren().add(new Label("Order 21: green tea"));}, then a {@code new Button(...)} for each button, and {@code stage.setTitle("Tea order");}.
     */
    public static void main(String[] args) {
        launch(Challenge01Ai.class);
    }
}
