// AI-Generated
package module50_gui_multiple_views_ai.step04_views_as_classes_ai.challenge03_ai;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        TeamView herons = new TeamView("Herons");
        TeamView beavers = new TeamView("Beavers");

        Button toHerons = new Button("Herons");
        Button toBeavers = new Button("Beavers");
        BorderPane frame = new BorderPane();
        frame.setTop(new HBox(10, toHerons, toBeavers));
        frame.setCenter(herons.getView());
        toHerons.setOnAction(event -> frame.setCenter(herons.getView()));
        toBeavers.setOnAction(event -> frame.setCenter(beavers.getView()));

        stage.setScene(new Scene(frame));
        stage.setTitle("Cleanup day");
        stage.show();
    }

    /**
     * On a cleanup day, two teams collect bags of litter. {@code Main} is ready: it makes two views of the same class, {@code TeamView}, one for each team, and a menu with the buttons {@code Herons} and {@code Beavers} that shows a team's view in the center. Write the class {@code TeamView} in {@code TeamView.java}:
     * <ul>
     * <li>a constructor {@code TeamView(String team)}
     * <li>{@code getView()}, which returns a Parent: a VBox with the spacing 8 and no padding, holding the label {@code Bags for Herons: 0} (with the team's name) and the button {@code Add a bag}
     * <li>each click on the button adds a bag to that team only, like {@code Bags for Herons: 2}
     * <li>each team keeps its count when the user switches to the other team and back
     * </ul>
     * <p>The task card shows the window after two clicks on Add a bag for the Herons, a click on Beavers and one more on Add a bag.
     * Hints
     * 1. Each TeamView object has its own instance variables, so {@code private int bags;} gives each team its own count. Make the label, the button and the VBox in the constructor, and keep the VBox in {@code private VBox view;}.
     * 2. The handler can use the constructor's parameter {@code team}, which never changes: {@code score.setText("Bags for " + team + ": " + this.bags);}.
     */
    public static void main(String[] args) {
        launch(Main.class);
    }
}
