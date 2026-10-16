// AI-Generated
package module51_data_visualization_ai.step06_bar_charts_for_categories_ai;

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
        CategoryAxis genres = new ___();
        genres.setLabel("Genre");
        NumberAxis loans = new NumberAxis();
        loans.setLabel("Loans");
        BarChart<___, Number> chart = new ___<>(genres, loans);
        chart.setTitle("Loans by genre");
        chart.setLegendVisible(false);

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Loans");
        List<String> lines = Files.readAllLines(Paths.get("genres.csv"));
        for (int i = 1; i < lines.size(); i++) {
            String[] parts = lines.get(i).split(",");
            series.getData().add(new XYChart.Data<>(parts[0], Integer.valueOf(parts[1])));
        }
        chart.getData().add(series);

        stage.setScene(new Scene(chart));
        stage.setTitle("Library");
        stage.show();
    }

    /**
     * The school library counts its loans per genre in {@code genres.csv}:
     * <pre>{@code
     * genre,loans
     * Fantasy,128
     * Mystery,96
     * Comics,152
     * Science,61
     * }</pre>
     * <p>Fill in the blanks of a bar chart with a category axis labeled {@code Genre}, an auto-ranging number axis labeled {@code Loans}, the title {@code Loans by genre}, no legend, and one series, {@code Loans}, with a bar for each row, in the order of the file.
     * Hints
     * 1. What kind of axis holds text values, and which chart class draws bars? The chart's first type is the type of its x values.
     * 2. The axis of text values is a {@code CategoryAxis}, and the chart a {@code BarChart}. The genres are text, so the x type is {@code String}.
     */
    public static void main(String[] args) {
        launch(Challenge01Ai.class);
    }
}
