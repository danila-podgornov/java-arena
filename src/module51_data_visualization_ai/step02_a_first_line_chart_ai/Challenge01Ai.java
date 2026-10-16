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

public class Challenge01Ai extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        NumberAxis months = new NumberAxis("Month", 1, 12, ___);
        NumberAxis loans = new NumberAxis();
        loans.setLabel("Loans");
        LineChart<Number, Number> chart = new ___<>(months, loans);
        chart.setTitle("School library loans");
        chart.setLegendVisible(false);

        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName("Loans");
        List<String> lines = Files.readAllLines(Paths.get("loans.csv"));
        for (int i = 1; i < lines.size(); i++) {
            String[] parts = lines.get(i).split(",");
            series.getData().add(new XYChart.___<>(Integer.valueOf(parts[0]), Integer.valueOf(parts[1])));
        }
        chart.getData().___(series);

        stage.setScene(new Scene(chart));
        stage.setTitle("Library");
        stage.show();
    }

    /**
     * The school library wants its loans as a line chart. {@code loans.csv} has the month's number and the loans:
     * <pre>{@code
     * month,loans
     * 1,412
     * 2,388
     * 3,455
     * 4,390
     * 5,301
     * 6,120
     * }</pre>
     * <p>Fill in the blanks. The chart's title is {@code School library loans}, its x axis is labeled {@code Month} and goes from 1 to 12 with a tick every 1, its y axis is labeled {@code Loans} and auto-ranging, and its one series, {@code Loans}, has a point for each row of the file. The legend is hidden.
     * Hints
     * 1. NumberAxis's four-argument constructor takes the label, the lower bound, the upper bound and the tick unit: how far apart are the months' ticks? Which chart class draws points joined by a line, which class is one point, and how does a series get into the chart's list?
     * 2. {@code new NumberAxis("Month", 1, 12, 1)} has a tick every 1. The chart is a {@code LineChart}, made with its two axes. A point is an {@code XYChart.Data}, and the series shows only once it's added to the chart's list: {@code chart.getData().add(series)}.
     */
    public static void main(String[] args) {
        launch(Challenge01Ai.class);
    }
}
