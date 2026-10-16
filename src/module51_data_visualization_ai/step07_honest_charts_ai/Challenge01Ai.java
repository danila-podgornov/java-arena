// AI-Generated
package module51_data_visualization_ai.step07_honest_charts_ai;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class Challenge01Ai extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        CategoryAxis services = new CategoryAxis();
        services.setLabel("Service");
        NumberAxis percent = new NumberAxis("On time (%)", 95, 100, 1);
        BarChart<String, Number> chart = new BarChart<>(services, percent);
        chart.setTitle("Week 41");
        chart.setLegendVisible(false);

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("On time");
        List<String> lines = Files.readAllLines(Paths.get("ontime.csv"));
        for (int i = 1; i < lines.size(); i++) {
            String[] parts = lines.get(i).split(",");
            series.getData().add(new XYChart.Data<>(parts[0], Integer.valueOf(parts[1])));
        }
        chart.getData().add(series);

        stage.setScene(new Scene(chart));
        stage.setTitle("Parcels");
        stage.show();
    }

    /**
     * A delivery team's weekly report compares three made-up parcel services by the percentage of parcels they deliver on time, read from {@code ontime.csv}. Its y axis is truncated: it starts at 95, so a difference of 3 points looks huge, and its title doesn't say what the bars show. Change the y axis to go from 0 to 100 with a tick every 10 (keep its label {@code On time (%)}), and the chart's title to {@code Parcels delivered on time}. Everything else stays as it is. The task card shows the window for this file: see the expected output below.
     * Expected output
     * <pre>{@code
     * service,percent
     * Service A,96
     * Service B,97
     * Service C,99
     * }</pre>
     * Hints
     * 1. The y axis is made by {@code new NumberAxis("On time (%)", 95, 100, 1)}: the numbers are the lower bound, the upper bound and the tick unit.
     * 2. A percentage goes from 0 to 100, so the honest axis is {@code new NumberAxis("On time (%)", 0, 100, 10)}. Then change the text in {@code setTitle}.
     */
    public static void main(String[] args) {
        launch(Challenge01Ai.class);
    }
}
