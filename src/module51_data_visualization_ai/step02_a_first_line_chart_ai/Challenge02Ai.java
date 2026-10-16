// AI-Generated
package module51_data_visualization_ai.step02_a_first_line_chart_ai;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class Challenge02Ai extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        List<String> lines = Files.readAllLines(Paths.get("rain.csv"));
        LineChart<Number, Number> chart = new LineChart<>(new NumberAxis(), new NumberAxis());

        stage.setScene(new Scene(chart));
        stage.setTitle("Rain");
        stage.show();
    }

    /**
     * A weather station sends its rain for the year in {@code rain.csv}. Its first line is the station's name, then come the header and a row for each month, with a {@code -} for a month without a measurement:
     * <pre>{@code
     * Hilltop
     * month,mm
     * 1,52
     * 2,41
     * 3,-
     * 4,38
     * 5,45
     * 6,60
     * 7,72
     * 8,81
     * 9,64
     * 10,77
     * 11,69
     * 12,58
     * }</pre>
     * <p>Write {@code start} so that the window, titled {@code Rain}, shows a line chart (the scene's root) with:
     * <ul>
     * <li>the title {@code Rain at Hilltop}: {@code Rain at } and the name from the first line
     * <li>an x axis labeled {@code Month}, from 1 to 12 with a tick every 1
     * <li>a y axis labeled {@code Rain (mm)}, auto-ranging
     * <li>one series named {@code Rain}, with a point (month, mm) for each month that has a measurement, in the order of the file
     * <li>no legend
     * </ul>
     * <p>Read the rain as whole numbers. The task card shows the window for the file above.
     * Hints
     * 1. The name is {@code lines.get(0)}, and line 1 is the header, so the rows of data start at index 2.
     * 2. Make the axes first: {@code new NumberAxis("Month", 1, 12, 1)}, and a {@code new NumberAxis()} with {@code setLabel("Rain (mm)")}. Give them to {@code new LineChart<>(...)}, and skip a row whose {@code parts[1]} is {@code "-"}.
     */
    public static void main(String[] args) {
        launch(Challenge02Ai.class);
    }
}
