// AI-Generated
package module51_data_visualization_ai.step03_several_series_from_a_map_ai;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class Challenge03Ai extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        List<String> lines = Files.readAllLines(Paths.get("pools.tsv"));

        stage.setTitle("Pools");
        stage.show();
    }

    /**
     * A town has three swimming pools, and counts each pool's visitors per week in the tab-separated file {@code pools.tsv}, one column per pool. A pool that was closed for a week has a {@code -}:
     * <pre>{@code
     * week	North	Lake	Park
     * 1	310	520	-
     * 2	295	610	140
     * 3	-	700	180
     * 4	350	655	210
     * }</pre>
     * <p>Write {@code start} so that the window, titled {@code Pools}, shows a line chart (the scene's root) with the title {@code Swimming pool visitors}, an auto-ranging x axis labeled {@code Week}, an auto-ranging y axis labeled {@code Visitors} and a visible legend. It has a series for each pool, named as in the header and in the header's order, with a point (week, visitors) for each week the pool was open, in the order of the file. The file may have any number of pools. The task card shows the window for the file above.
     * Hints
     * 1. Split the header with {@code split("\t")}: its values from index 1 on are the pools' names. Make a series for each, in a list, before you read the rows.
     * 2. In each row, column {@code c} (from 1 on) belongs to the series at index {@code c - 1}. Skip a {@code -}, and add the series to the chart with {@code chart.getData().addAll(...)} at the end.
     */
    public static void main(String[] args) {
        launch(Challenge03Ai.class);
    }
}
