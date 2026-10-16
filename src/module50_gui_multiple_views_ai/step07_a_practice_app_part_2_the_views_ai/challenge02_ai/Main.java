// AI-Generated
package module50_gui_multiple_views_ai.step07_a_practice_app_part_2_the_views_ai.challenge02_ai;

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
     * The trainer gets a third view: the countries to practice again. Write the class {@code MissedView} in {@code MissedView.java}, and add it to the menu in {@code Main}:
     * <ul>
     * <li>a constructor {@code MissedView(CardBox box, PracticeRound round)}
     * <li>{@code getView()} builds a new VBox at each call, with the spacing 4 and the padding 10 on every side. When {@code round.missed()} is empty, it holds only the label {@code Nothing missed so far.} Otherwise it holds the label {@code Practice these again:} and then a label for each missed country, in the order of {@code missed()}, like {@code Peru: Lima} (the country and its capital).
     * <li>in {@code Main}, a third button {@code Missed}, after {@code Train} in the menu, puts the missed view in the center
     * </ul>
     * <p>The other classes are ready. The task card shows the window after adding Peru and Kenya, answering {@code Cusco} and {@code Nairobi}, and clicking Missed.
     * Hints
     * 1. MissedView keeps the box and the round in instance variables. {@code getView()} makes {@code new VBox(4)} with {@code setPadding(new Insets(10))}, and checks {@code this.round.missed().isEmpty()} to choose between the one label and the list.
     * 2. For the list, a for-each loop over {@code this.round.missed()} adds {@code new Label(country + ": " + this.box.capitalOf(country))}. In {@code Main}, make {@code new MissedView(box, round)} and a third button, put the button in the HBox, and give it a handler like the other two.
     */
    public static void main(String[] args) {
        launch(Main.class);
    }
}
