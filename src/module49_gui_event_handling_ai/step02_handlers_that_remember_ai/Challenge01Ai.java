// AI-Generated
package module49_gui_event_handling_ai.step02_handlers_that_remember_ai;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Challenge01Ai extends Application {

    @Override
    public void start(Stage stage) {
        Label glasses = new Label("Glasses of water: 0");
        Button drink = new Button("Drink one");
        Button newDay = new Button("New day");
        int count = 0;
        drink.setOnAction(event -> {
            count++;
            glasses.setText("Glasses of water: " + count);
        });
        newDay.setOnAction(event -> {
            count = 0;
            glasses.setText("Glasses of water: " + count);
        });

        stage.setScene(new Scene(new VBox(glasses, new HBox(drink, newDay))));
        stage.setTitle("Water tracker");
        stage.show();
    }

    /**
     * A water tracker doesn't compile: it keeps the number of glasses in a local variable, which its lambdas change. Keep the count in a {@code private} instance variable of Main instead, so that {@code Drink one} adds a glass and {@code New day} starts again from 0. Don't change the window or the texts. The task card shows the window after two clicks on Drink one.
     * Hints
     * 1. A lambda can change an instance variable of Main but not a local variable of {@code start}, so move the count out of {@code start}.
     * 2. Declare the count in the class, above {@code start}: {@code private int count;}. Then remove the line {@code int count = 0;} from {@code start}. In the lambdas, {@code this.count} is the instance variable: {@code this.count++;} and {@code this.count = 0;}.
     */
    public static void main(String[] args) {
        launch(Challenge01Ai.class);
    }
}
