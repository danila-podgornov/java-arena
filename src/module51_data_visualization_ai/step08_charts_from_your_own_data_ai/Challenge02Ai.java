// AI-Generated
package module51_data_visualization_ai.step08_charts_from_your_own_data_ai;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class Challenge02Ai extends Application {

    @Override
    public void start(Stage stage) {
        String[] rows = {"Tue,4", "Mon,3", "Tue,-", "Mon,5", "Wed,1"};
        Map<String, Integer> bags = new HashMap<>();
        List<String> days = new ArrayList<>();
        for (String row : rows) {
            String[] parts = row.split(",");
            if (!days.contains(parts[0])) {
                days.add(parts[0]);
            }
            if (!parts[1].equals("-")) {
                bags.put(parts[0], bags.getOrDefault(parts[0], 0) + Integer.valueOf(parts[1]));
            }
        }
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        for (String day : days) {
            series.getData().add(new XYChart.Data<>(day, bags.get(day)));
        }
        System.out.println(series.getData().size());
        System.out.println(series.getData().get(0));
        System.out.println(series.getData().get(1).getYValue());

        BarChart<String, Number> chart = new BarChart<>(new CategoryAxis(), new NumberAxis());
        chart.getData().add(series);
        stage.setScene(new Scene(chart));
        stage.setTitle("Litter");
        stage.show();
    }

    /**
     * A program sums up a week of litter picking by day: the bags filled by each volunteer group. What does it print?
     * Hints
     * 1. The list {@code days} keeps each day once, in the order it first appears in the rows: Tue, Mon, Wed. The map only holds the totals.
     * 2. Tuesday's {@code -} adds nothing, so its total stays 4. Monday's rows add up to 8.
     */
    public static void main(String[] args) {
        launch(Challenge02Ai.class);
    }
}
