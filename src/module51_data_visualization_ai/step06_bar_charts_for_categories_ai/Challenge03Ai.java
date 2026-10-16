// AI-Generated
package module51_data_visualization_ai.step06_bar_charts_for_categories_ai;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class Challenge03Ai extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        List<String> lines = Files.readAllLines(Paths.get("tickets.csv"));

        stage.setTitle("Cinema");
        stage.show();
    }

    /**
     * A small cinema shows three films, each in an afternoon and an evening show, and writes the tickets sold in {@code tickets.csv}, one column per show. A show that was canceled has a {@code -}:
     * <pre>{@code
     * film,Afternoon,Evening
     * Cartoon,64,22
     * Nature film,31,48
     * Comedy,40,-
     * }</pre>
     * <p>Write {@code start} so that the window, titled {@code Cinema}, shows a bar chart (the scene's root) with the title {@code Tickets sold}, a category axis labeled {@code Film}, an auto-ranging number axis labeled {@code Tickets} and a visible legend. It has a series for each show, named as in the header and in its order, with a bar (film, tickets) for each film, in the order of the file; a canceled show has no bar for that film. The file may have any number of shows. The task card shows the window for the file above.
     * Hints
     * 1. This is step 3's bakery chart with categories: a series per column of the header (from index 1), and in each row, column {@code c} goes to the series at index {@code c - 1}, as the point {@code (parts[0], tickets)}.
     * 2. The chart is a {@code BarChart<String, Number>} made with a {@code CategoryAxis} and a {@code NumberAxis}, and every series is {@code XYChart.Series<String, Number>}.
     */
    public static void main(String[] args) {
        launch(Challenge03Ai.class);
    }
}
