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

public class Challenge02Ai extends Application {

    @Override
    public void start(Stage stage) {
        Label prices = new Label("A ride of 30 minutes costs 1 euro.");
        Label stations = new Label("There are 42 stations around the city.");
        Label help = new Label("A bike is broken? Leave it at a station and press its red button.");

        Button toPrices = new Button("Prices");
        Button toStations = new Button("Stations");
        Button toHelp = new Button("Help");
        HBox menu = new HBox(10, toPrices, toStations, toHelp);
        menu.setPadding(new Insets(10));

        BorderPane frame = new BorderPane();
        frame.setTop(menu);
        frame.setCenter(prices);

        toPrices.setOnAction(event -> frame.setCenter(prices));
        toStations.setOnAction(event -> frame.setCenter(stations));
        toHelp.setOnAction(event -> frame.setCenter(help));

        stage.setScene(new Scene(frame));
        stage.setTitle("City bikes");
        stage.show();
    }

    /**
     * A city bike app has a menu that shows its pages in the center of a BorderPane. Make the menu show where the user is: the button of the page that is showing is <b>disabled</b>, and the other two are enabled. {@code setDisable(true)} disables a button, and {@code setDisable(false)} enables it again (module 49). A disabled button does nothing when it's clicked.
     * <p>The app opens on the prices page, so {@code Prices} starts disabled. A click on {@code Stations} shows the stations page, disables {@code Stations} and enables the other two, and so on. Don't change anything else: the pages, the menu and the texts stay as they are. The task card shows the window after a click on Stations.
     * Hints
     * 1. Before the window shows, disable the button of the default page: {@code toPrices.setDisable(true);}.
     * 2. Each handler now has a body in braces: it sets the center, then calls {@code setDisable} on all three buttons, {@code true} for its own and {@code false} for the other two.
     */
    public static void main(String[] args) {
        launch(Challenge02Ai.class);
    }
}
