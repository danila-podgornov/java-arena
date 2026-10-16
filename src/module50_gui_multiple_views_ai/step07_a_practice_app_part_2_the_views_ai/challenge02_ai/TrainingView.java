// AI-Generated
package module50_gui_multiple_views_ai.step07_a_practice_app_part_2_the_views_ai.challenge02_ai;

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
        VBox view = new VBox(8);
        view.setPadding(new Insets(10));
        if (this.round.question() == null) {
            view.getChildren().add(new Label("Add some cards first."));
            return view;
        }
        Label question = new Label("Capital of " + this.round.question() + "?");
        TextField answer = new TextField();
        answer.setPromptText("Capital");
        Button check = new Button("Answer");
        Label feedback = new Label("");
        Label score = new Label(this.scoreText());
        check.setOnAction(event -> {
            String country = this.round.question();
            String capital = this.box.capitalOf(country);
            if (this.round.answer(answer.getText())) {
                feedback.setText("Yes, " + capital + ".");
            } else {
                feedback.setText("No, it's " + capital + ".");
            }
            question.setText("Capital of " + this.round.question() + "?");
            answer.clear();
            score.setText(this.scoreText());
        });
        view.getChildren().addAll(question, answer, check, feedback, score);
        return view;
    }

    private String scoreText() {
        return "Right " + this.round.getRight() + ", wrong " + this.round.getWrong();
    }
}
