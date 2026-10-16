// AI-Generated
package module51_data_visualization_ai.step08_charts_from_your_own_data_ai;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class Challenge01Ai extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        List<String> lines = Files.readAllLines(Paths.get("temps.csv"));

        stage.setTitle("Mountain hut");
        stage.show();
    }

    /**
     * A sensor outside a mountain hut reads the temperature three times a day, in whole degrees, and writes {@code temps.csv}. A failed reading has a {@code -} (careful: {@code -3} is a reading, 3 degrees below zero):
     * <pre>{@code
     * day,hour,temp
     * 1,6,4
     * 1,12,11
     * 1,18,8
     * 2,6,-3
     * 2,12,-
     * 2,18,6
     * 3,6,5
     * 3,12,14
     * 3,18,10
     * }</pre>
     * <p>Write {@code start} so that the window, titled {@code Mountain hut}, shows a line chart (the scene's root) with the title {@code Coldest and warmest}, an auto-ranging x axis labeled {@code Day}, an auto-ranging y axis labeled {@code Temperature (°C)} and a visible legend. It has two series, first {@code Lowest}, then {@code Highest}: for each day with at least one reading, {@code Lowest} has the point (day, the day's lowest reading) and {@code Highest} the point (day, the day's highest reading), from the smallest day up. The rows may come in any order. The task card shows the window for the file above.
     * Hints
     * 1. Keep two maps from the day to its lowest and its highest reading so far. For each row whose temperature isn't exactly {@code "-"}, update a day's lowest when the map has no value for the day yet or the reading is lower, and the highest the same way.
     * 2. Then copy the days of a map into a list, sort it with {@code Collections.sort}, and add a point to both series for each day in that order.
     */
    public static void main(String[] args) {
        launch(Challenge01Ai.class);
    }
}
