// AI-Generated
package module50_gui_multiple_views_ai.step05_logic_apart_from_the_views_ai.challenge03_ai;

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

    }

    /**
     * The agency runs two excursions. {@code Excursion} and {@code BookingView} (from the tasks before) are ready. Write {@code start} in {@code Main}:
     * <ul>
     * <li>two Excursion objects: {@code Island tour} with 40 seats and {@code Lake cruise} with 25 seats, and a BookingView for each, made once
     * <li>a BorderPane whose top is an HBox with the spacing 10 and the padding 10 on every side, holding the buttons {@code Island tour} and {@code Lake cruise}
     * <li>each button puts the BookingView of its excursion in the center; at the start, the center shows the Island tour's
     * <li>the window's title is {@code Excursions}
     * </ul>
     * <p>The task card shows the window after booking 2 seats for the Lake cruise.
     * Hints
     * 1. Each excursion needs an Excursion object of its own, and each BookingView gets its excursion's: {@code BookingView island = new BookingView(new Excursion("Island tour", 40));}, and the same for the Lake cruise.
     * 2. The rest is step 3's frame: an HBox menu with {@code setPadding(new Insets(10))} in the top region, {@code frame.setCenter(island.getView())} at the start, and a handler on each button that puts its view in the center.
     */
    public static void main(String[] args) {
        launch(Main.class);
    }
}
