// AI-Generated
package module51_data_visualization_ai.step04_series_from_a_formula_ai;

import java.nio.file.Files;
import java.nio.file.Paths;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class Challenge02Ai extends Application {
    private double start;
    private double speed;

    @Override
    public void start(Stage stage) throws Exception {
        String[] parts = Files.readAllLines(Paths.get("throw.txt")).get(0).split(",");
        this.start = Double.valueOf(parts[0]);
        this.speed = Double.valueOf(parts[1]);

        stage.setTitle("Ball");
        stage.show();
    }

    private double height(double t) {
        return this.start + this.speed * t - 5 * t * t;
    }

    /**
     * A ball is thrown straight up. With the pull of gravity rounded to 10 m/s² and no air to slow it, its height in meters after {@code t} seconds is {@code start + speed * t - 5 * t * t}, where {@code start} is the height it leaves the hand at and {@code speed} its speed upward in m/s. The file {@code throw.txt} holds both, separated by a comma, such as {@code 2,14}. {@code Main} already reads them and has the method {@code height}.
     * <p>Finish {@code start}: the window, titled {@code Ball}, shows a line chart (the scene's root) with the title {@code A thrown ball}, an auto-ranging x axis labeled {@code Seconds}, an auto-ranging y axis labeled {@code Height (m)}, no symbols and no legend. Its one series, {@code Ball}, has a point (t, height) for t = 0, 0.25, 0.5, 0.75 and so on, as long as the height is at least 0: the first point whose height is below 0 isn't added, and the series ends there. The task card shows the window for {@code 2,14}.
     * Hints
     * 1. A {@code while} loop fits: start with {@code double t = 0}, and as long as {@code this.height(t) >= 0}, add the point {@code (t, this.height(t))} and add 0.25 to {@code t}.
     * 2. {@code setCreateSymbols(false)} and {@code setLegendVisible(false)} are methods of the chart; the labels are set on the two {@code NumberAxis} objects.
     */
    public static void main(String[] args) {
        launch(Challenge02Ai.class);
    }
}
