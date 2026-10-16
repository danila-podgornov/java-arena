// AI-Generated
package module48_gui_windows_components_and_layouts_ai.step06_layouts_inside_layouts_ai.challenge02_ai;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        String[] lines = {"7:15;4;Harbor Square", "7:22;11;Airport", "7:30;4;Harbor Square"};
        VBox board = new VBox(4);
        for (String text : lines) {
            BusTime bus = BusTime.fromText(text);
            board.getChildren().add(new Label(bus.toString()));
        }

        stage.setScene(new Scene(board));
        stage.setTitle("Stop 14 departures");
        stage.show();
    }

    /**
     * Step 1's bus stop gets a board with all its departures. First the data. The file {@code departures.txt} has a line for each bus, such as {@code 7:15;4;Harbor Square}: the time, the line and where it goes, with semicolons between them. In {@code BusTime.java}, write the class {@code BusTime}:
     * <ul>
     * <li>a constructor {@code BusTime(String clock, String route, String towards)}
     * <li>the methods {@code getClock()}, {@code getRoute()} and {@code getTowards()}
     * <li>a static method {@code fromText(String text)}, which returns a new BusTime made from a line of the file
     * <li>{@code toString()}, which returns the departure like {@code 7:15 line 4 to Harbor Square}
     * </ul>
     * <p>{@code Main.java} is ready: it shows a VBox with a label for each of three departures, made with your class. The check runs:
     * <pre>{@code
     * BusTime bus = BusTime.fromText("7:15;4;Harbor Square");
     * System.out.println(bus.getRoute() + " leaves at " + bus.getClock());
     * System.out.println(bus);
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * 4 leaves at 7:15
     * 7:15 line 4 to Harbor Square
     * }</pre>
     * Hints
     * 1. Three private String instance variables, a constructor that stores them, and a getter for each. {@code toString} puts them together: {@code this.clock + " line " + this.route + " to " + this.towards}.
     * 2. In {@code fromText}, {@code text.split(";")} gives an array of the three parts, in the file's order: time, line, destination. Return {@code new BusTime(parts[0], parts[1], parts[2])}. The method is {@code public static BusTime fromText(String text)}.
     */
    public static void main(String[] args) {
        launch(Main.class);
    }
}
