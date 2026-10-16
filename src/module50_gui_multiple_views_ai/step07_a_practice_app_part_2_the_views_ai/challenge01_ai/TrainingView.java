// AI-Generated
package module50_gui_multiple_views_ai.step07_a_practice_app_part_2_the_views_ai.challenge01_ai;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class TrainingView {
    private CardBox box;
    private PracticeRound round;

    public TrainingView(CardBox box, PracticeRound round) {
        this.box = box;
        this.round = round;
    }

    public Parent getView() {
        VBox view = new VBox(8, new Label("Training comes in the next version."));
        view.setPadding(new Insets(10));
        return view;
    }
}
