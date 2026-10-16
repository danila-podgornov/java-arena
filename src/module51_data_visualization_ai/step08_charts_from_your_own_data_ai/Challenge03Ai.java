// AI-Generated
package module51_data_visualization_ai.step08_charts_from_your_own_data_ai;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class Challenge03Ai extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        List<String> lines = Files.readAllLines(Paths.get("chart.csv"));
        String[] first = lines.get(0).split(",");
        String[] header = lines.get(1).split(",");

        stage.setTitle("My chart");
        stage.show();
    }

    /**
     * A chart tool for your own data: it reads {@code chart.csv}, whose first line says the kind of chart and its title, separated by a comma ({@code bar,Books read} or {@code line,Books read}). The second line is the header, which names the x values and the y values, and the rows follow. A {@code -} is a missing value:
     * <pre>{@code
     * bar,Books read in the club
     * month,books
     * Jan,3
     * Feb,5
     * Mar,-
     * Apr,4
     * }</pre>
     * <p>Write {@code start}. The window, titled {@code My chart}, shows the chart (the scene's root) with the title from the first line, no legend and one series, named as the header's second value, with a point (x, y) for each row whose y isn't {@code -}, in the order of the file. Read the y values as doubles.
     * <ul>
     * <li>For {@code bar}, it's a bar chart with a category axis labeled as the header's first value (here {@code month}) and an auto-ranging number axis labeled as the header's second value (here {@code books}).
     * <li>For {@code line}, it's a line chart with two auto-ranging number axes labeled the same way, and the x values are numbers too (read them as doubles).
     * </ul>
     * <p>The task card shows the window for the file above. The tool charts any file in this form, so on your own computer, with JavaFX installed (module 48 says where to find how), you can give it data of your own.
     * Hints
     * 1. The two kinds of chart have different types ({@code BarChart<String, Number>} and {@code LineChart<Number, Number>}), so a method for each keeps them apart. Both are nodes that a Scene can hold.
     * 2. The rows start at index 2, after the first line and the header. In each method, skip a row whose {@code parts[1]} is {@code "-"}.
     */
    public static void main(String[] args) {
        launch(Challenge03Ai.class);
    }
}
