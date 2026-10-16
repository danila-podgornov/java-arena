// AI-Generated
package module50_gui_multiple_views_ai.step07_a_practice_app_part_2_the_views_ai.challenge03_ai;

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
     * A text field has an action too: {@code setOnAction} on a TextField gives it a handler that runs when the user presses Enter in it. Typing an answer and then reaching for the mouse is slow, so make Enter work:
     * <ul>
     * <li>in NewCardView, Enter in the capital field adds the card, exactly as a click on {@code Add card} does
     * <li>in TrainingView, Enter in the answer field answers, exactly as a click on {@code Answer} does
     * </ul>
     * <p>A button's {@code fire()} runs its handler, so neither handler needs to be written twice. Enter in the country field still does nothing. Nothing else changes. The task card shows the window after adding Peru and Kenya with Enter, clicking Train, and answering {@code Lima} with Enter.
     * Hints
     * 1. In NewCardView's constructor, after Add card's handler: {@code capital.setOnAction(event -> add.fire());}.
     * 2. In TrainingView's {@code getView()}, after Answer's handler: {@code answer.setOnAction(event -> check.fire());}, with the names your fields and buttons have.
     */
    public static void main(String[] args) {
        launch(Main.class);
    }
}
