// AI-Generated
package module48_gui_windows_components_and_layouts_ai.step04_borderpane_five_regions_ai;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Challenge02Ai extends Application {

    @Override
    public void start(Stage stage) {
        BorderPane card = new BorderPane();
        Label dish = new Label("Leek pie");
        card.setTop(dish);
        card.setBottom(new Label("Serves 6"));
        card.setLeft(new Label("Vegetarian"));
        System.out.println(card.getChildren().size());

        card.setTop(new Label("Leek and potato pie"));
        System.out.println(card.getChildren().size() + " " + (dish.getParent() == null));

        card.setLeft(null);
        card.setCenter(dish);
        Label top = (Label) card.getTop();
        System.out.println(card.getChildren().size() + " " + top.getText());

        stage.setScene(new Scene(card));
        stage.show();
    }

    /**
     * A card for a leek pie changes its mind a few times. {@code card.getChildren()} is the list of nodes in all of a BorderPane's regions, and {@code getTop()} returns a Node, which the program casts to a Label (module 36). What does the program print?
     * Hints
     * 1. Three regions are set at first. Setting the top again replaces {@code dish}, so the card still holds three nodes, and {@code dish} is in none of them.
     * 2. {@code setLeft(null)} empties the left region, and {@code setCenter(dish)} puts {@code dish} back in, now in the center. The top region still holds the second label.
     */
    public static void main(String[] args) {
        launch(Challenge02Ai.class);
    }
}
