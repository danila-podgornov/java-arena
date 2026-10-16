// AI-Generated
package module50_gui_multiple_views_ai.step04_views_as_classes_ai.challenge02_ai;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class SeedView {
    private VBox view;

    public SeedView(Button toOrder) {
        this.view = new VBox(8, new Label("Tomato seeds: 3 euros a bag"), new Label("Pea seeds: 2 euros a bag"), toOrder);
    }

    public Parent getView() {
        return this.view;
    }
}
