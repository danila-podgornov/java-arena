// AI-Generated
package module50_gui_multiple_views_ai.step03_one_frame_changing_content_ai;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Challenge01Ai extends Application {

    @Override
    public void start(Stage stage) {
        Label rides = new Label("The roller coaster reopens on Friday.");
        Label food = new Label("Pancakes and soup by the big wheel.");
        Label hours = new Label("Open daily from 10 to 20.");
        Label prices = new Label("One ride costs 4 tokens.");
        Button toRides = new Button("Rides");
        Button toFood = new Button("Food");
        Button toHours = new Button("Hours");
        Button toPrices = new Button("Prices");

        BorderPane frame = new BorderPane();

        stage.setScene(new Scene(frame));
        stage.setTitle("Funfair");
        stage.show();
    }

    /**
     * A funfair's info screen. The four pages (labels) and the four menu buttons are made already, and so is an empty BorderPane. Finish the window:
     * <ul>
     * <li>top: an HBox with the spacing 10 and the padding 10 on every side, holding the buttons {@code Rides}, {@code Food}, {@code Hours} and {@code Prices}, in that order
     * <li>center: the page of the button clicked last: Rides shows {@code The roller coaster reopens on Friday.}, Food shows {@code Pancakes and soup by the big wheel.}, Hours shows {@code Open daily from 10 to 20.}, and Prices shows {@code One ride costs 4 tokens.}
     * <li>at the start, the center shows the rides page
     * </ul>
     * <p>The window's title is {@code Funfair}. The task card shows the window after a click on Food.
     * Hints
     * 1. Put the four buttons in an HBox with the spacing 10 and the padding 10, place that HBox in the frame's top region, and put the rides page in the center before the window shows. Then give each button a handler that puts its own page in the center.
     * 2. The menu: {@code HBox menu = new HBox(10, toRides, toFood, toHours, toPrices);}, then {@code menu.setPadding(new Insets(10));}, {@code frame.setTop(menu);} and {@code frame.setCenter(rides);}. A handler: {@code toFood.setOnAction(event -> frame.setCenter(food));}, and the same for the other three.
     */
    public static void main(String[] args) {
        launch(Challenge01Ai.class);
    }
}
