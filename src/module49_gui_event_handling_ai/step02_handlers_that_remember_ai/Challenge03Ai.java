// AI-Generated
package module49_gui_event_handling_ai.step02_handlers_that_remember_ai;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Challenge03Ai extends Application {

    @Override
    public void start(Stage stage) {
        Label gear = new Label("Gear 1");
        Button down = new Button("Down");
        Button up = new Button("Up");

        stage.setScene(new Scene(new VBox(gear, new HBox(down, up))));
        stage.setTitle("Gears");
        stage.show();
    }

    /**
     * A bike's handlebar display shows its gear. The window is built already: the label {@code Gear 1}, and under it the buttons {@code Down} and {@code Up}. Give the buttons their handlers. <b>Up</b> shifts one gear up and <b>Down</b> one gear down, and the label shows the gear, like {@code Gear 4}. The bike has gears 1 to 7: Up does nothing in gear 7, and Down does nothing in gear 1 (keep both buttons enabled). The task card shows the window after three clicks on Up.
     * Hints
     * 1. The gear changes at every click, so keep it in an instance variable that starts at 1: {@code private int current = 1;}.
     * 2. In Up's handler, add one only while the gear is below 7: {@code if (this.current < 7) { this.current++; }}, then set the label to {@code "Gear " + this.current}. Down is the same the other way around.
     */
    public static void main(String[] args) {
        launch(Challenge03Ai.class);
    }
}
