// AI-Generated
package module48_gui_windows_components_and_layouts_ai.step06_layouts_inside_layouts_ai.challenge03_ai;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        List<String> lines = Files.readAllLines(Paths.get("departures.txt"));
        BorderPane board = new BorderPane();

        stage.setScene(new Scene(board));
        stage.setTitle("Stop 14 departures");
        stage.show();
    }

    /**
     * Now the board itself, with {@code BusTime} from the last challenge ready in {@code BusTime.java}. Build the window: the title is {@code Stop 14 departures}, and the root is a BorderPane with:
     * <ul>
     * <li>top: the label {@code Departures from stop 14}
     * <li>center: a GridPane with the gaps 12 between columns and 4 between rows, and the padding 10 on every side. Row 0 holds the labels {@code Time}, {@code Line} and {@code To}, in columns 0 to 2. Below it, a row for each departure of {@code departures.txt}, in the file's order: labels with its time, its line and its destination, in the same columns.
     * </ul>
     * <p>Write a helper method {@code addRow(GridPane grid, int row, String first, String second, String third)} (it returns nothing) that adds the three labels of one row, and use it for every row, the first one too. For the file shown below, the window should look like the drawing under it.
     * Hints
     * 1. {@code addRow} puts its three texts into the columns 0, 1 and 2 of the given row: {@code grid.add(new Label(first), 0, row);} and so on. The header is {@code addRow(grid, 0, "Time", "Line", "To");}.
     * 2. The departure on line {@code i} of the file (counting from 0) goes into row {@code i + 1}, below the header. Make it with {@code BusTime.fromText(lines.get(i))}, and pass its time, line and destination to {@code addRow}.
     */
    public static void main(String[] args) {
        launch(Main.class);
    }
}
