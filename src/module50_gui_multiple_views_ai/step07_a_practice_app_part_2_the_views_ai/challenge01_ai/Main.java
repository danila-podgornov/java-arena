// AI-Generated
package module50_gui_multiple_views_ai.step07_a_practice_app_part_2_the_views_ai.challenge01_ai;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        CardBox box = new CardBox();
        PracticeRound round = new PracticeRound(box);
        NewCardView newCards = new NewCardView(box);
        TrainingView training = new TrainingView(box, round);

        Button toNewCards = new Button("Add cards");
        Button toTraining = new Button("Train");
        HBox menu = new HBox(10, toNewCards, toTraining);
        menu.setPadding(new Insets(10));

        BorderPane frame = new BorderPane();
        frame.setTop(menu);
        frame.setCenter(newCards.getView());
        toNewCards.setOnAction(event -> frame.setCenter(newCards.getView()));
        toTraining.setOnAction(event -> frame.setCenter(training.getView()));

        stage.setScene(new Scene(frame));
        stage.setTitle("Capitals");
        stage.show();
    }

    /**
     * Replace the stand-in. Write {@code TrainingView} in {@code TrainingView.java}; everything else is ready, and {@code PracticeRound} is step 6's, with {@code missed()}. {@code getView()} returns a VBox with the spacing 8 and the padding 10 on every side:
     * <ul>
     * <li>when the box is empty, it holds only the label {@code Add some cards first.}
     * <li>otherwise it holds, in order: the label {@code Capital of Peru?} (with the country of {@code round.question()}), a text field with the prompt text {@code Capital}, the button {@code Answer}, an empty label for feedback, and the label {@code Right 0, wrong 0} (with the round's counts)
     * </ul>
     * <p><b>Answer</b> answers with the field's text, and then:
     * <ul>
     * <li>the feedback label says {@code Yes, Lima.} for a right answer, or {@code No, it's Lima.} for a wrong one (with the capital of the country that was asked)
     * <li>the question label shows the next question, the field is emptied, and the score label shows the new counts
     * </ul>
     * <p>The task card shows the window after adding Peru and Kenya, clicking Train and answering {@code lima}.
     * Hints
     * 1. Start {@code getView()} with {@code VBox view = new VBox(8);} and {@code view.setPadding(new Insets(10));}. If {@code this.round.question() == null}, add the label {@code Add some cards first.} and return the view. Otherwise make the five nodes and add them with {@code view.getChildren().addAll(...)}.
     * 2. In Answer's handler, first {@code String country = this.round.question();} and {@code String capital = this.box.capitalOf(country);}. Then {@code if (this.round.answer(answer.getText()))} chooses the feedback, and after that come the question label, {@code answer.clear()} and the score.
     */
    public static void main(String[] args) {
        launch(Main.class);
    }
}
