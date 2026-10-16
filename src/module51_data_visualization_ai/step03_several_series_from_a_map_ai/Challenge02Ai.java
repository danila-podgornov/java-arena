// AI-Generated
package module51_data_visualization_ai.step03_several_series_from_a_map_ai;

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

public class Challenge02Ai extends Application {

    @Override
    public void start(Stage stage) {
        String[] rows = {"1,oak,30", "1,elm,25", "2,oak,34", "2,ash,-", "2,elm,29"};
        Map<String, XYChart.Series<Number, Number>> byTree = new HashMap<>();
        for (String row : rows) {
            String[] parts = row.split(",");
            XYChart.Series<Number, Number> series = byTree.get(parts[1]);
            if (series == null) {
                series = new XYChart.Series<>();
                series.setName(parts[1]);
                byTree.put(parts[1], series);
            }
            if (!parts[2].equals("-")) {
                series.getData().add(new XYChart.Data<>(Integer.valueOf(parts[0]), Integer.valueOf(parts[2])));
            }
        }
        List<String> trees = new ArrayList<>(byTree.keySet());
        Collections.sort(trees);
        LineChart<Number, Number> chart = new LineChart<>(new NumberAxis(), new NumberAxis());
        for (String tree : trees) {
            chart.getData().add(byTree.get(tree));
            System.out.println(tree + ": " + byTree.get(tree).getData().size());
        }

        stage.setScene(new Scene(chart));
        stage.setTitle("Park");
        stage.show();
    }

    /**
     * A park measures its young trees in centimeters. What does this program print?
     * Hints
     * 1. This program makes a tree's series before it checks for {@code -}, so every tree that has a row gets a series, even one without a single number.
     * 2. The names are sorted before they're printed: ash, elm, oak. Count each tree's rows with a number.
     */
    public static void main(String[] args) {
        launch(Challenge02Ai.class);
    }
}
