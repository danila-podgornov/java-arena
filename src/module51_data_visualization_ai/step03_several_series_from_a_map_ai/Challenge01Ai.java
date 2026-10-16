// AI-Generated
package module51_data_visualization_ai.step03_several_series_from_a_map_ai;

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
        NumberAxis weeks = new NumberAxis();
        weeks.setLabel("Week");
        NumberAxis km = new NumberAxis();
        km.setLabel("km");
        LineChart<Number, Number> chart = new LineChart<>(weeks, km);
        chart.setTitle("Running club");

        List<String> lines = Files.readAllLines(Paths.get("runs.csv"));

        stage.setScene(new Scene(chart));
        stage.setTitle("Club");
        stage.show();
    }

    /**
     * A running club writes down how far each runner ran in each week's training run, one row per runner and week, with a {@code -} when a runner skipped the run:
     * <pre>{@code
     * week,runner,km
     * 1,Mia,5.5
     * 1,Leo,7
     * 1,Ava,4
     * 2,Mia,6
     * 2,Leo,-
     * 2,Ava,4.5
     * 3,Mia,6.5
     * 3,Leo,8
     * 3,Ava,5
     * }</pre>
     * <p>The window, its line chart and the axes are ready. Read {@code runs.csv} and add a series for each runner, named after the runner, with a point (week, km) for each of the runner's rows that has a number, in the order of the file. Read the km as doubles. Add the series to the chart in the alphabetical order of the names (here Ava, Leo, Mia). A runner whose every row has a {@code -} gets no series. The task card shows the window for the file above.
     * Hints
     * 1. Keep a {@code Map<String, XYChart.Series<Number, Number>>} from each runner's name to the runner's series. For a row with a number, get the runner's series from the map, and make it (named, and put in the map) when it's {@code null}.
     * 2. After the loop, copy the names into a list, {@code new ArrayList<>(byRunner.keySet())}, sort it with {@code Collections.sort}, and add each runner's series to {@code chart.getData()} in that order.
     */
    public static void main(String[] args) {
        launch(Challenge01Ai.class);
    }
}
