// AI-Generated
package module50_gui_multiple_views_ai.step04_views_as_classes_ai.challenge01_ai;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class HoursView {

    public Parent getView() {
        VBox view = new VBox(6, new Label("Weekdays 10 to 20"), new Label("Weekends 12 to 18"));
        view.setPadding(new Insets(10));
        return view;
    }
}
