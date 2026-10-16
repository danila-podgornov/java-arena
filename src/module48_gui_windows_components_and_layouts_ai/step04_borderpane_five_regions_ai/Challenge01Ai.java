// AI-Generated
package module48_gui_windows_components_and_layouts_ai.step04_borderpane_five_regions_ai;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Challenge01Ai extends Application {

    @Override
    public void start(Stage stage) {
        Label dish = new Label("Mushroom risotto");
        dish.setFont(Font.font("Serif", 20));
        TextArea method = new TextArea("Soften the onion.\nStir in the rice, then the stock.");
        Label serves = new Label("Serves 2");

        BorderPane card = new BorderPane();
        card.___(dish);
        card.___(method);
        card.___(serves);

        stage.setScene(new Scene(card));
        stage.setTitle("Recipe card");
        stage.show();
    }

    /**
     * A card for a mushroom risotto. Fill in the three blanks, so that the dish's name is in the top region, the method in the center and the servings at the bottom. The window it should show is drawn below.
     * Hints
     * 1. Each region has its own method: {@code setTop}, {@code setRight}, {@code setBottom}, {@code setLeft} and {@code setCenter}.
     * 2. The name goes to {@code setTop}, the method to {@code setCenter} and the servings to {@code setBottom}.
     */
    public static void main(String[] args) {
        launch(Challenge01Ai.class);
    }
}
