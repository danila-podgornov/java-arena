// AI-Generated
package module51_data_visualization_ai.step04_series_from_a_formula_ai;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class Challenge03Ai extends Application {

    @Override
    public void start(Stage stage) {
        XYChart.Series<Number, Number> squares = new XYChart.Series<>();
        for (int i = 0; i <= 4; i++) {
            squares.getData().add(new XYChart.Data<>(i / 2, i * i));
        }
        System.out.println(squares.getData().size());
        System.out.println(squares.getData().get(3));
        System.out.println(squares.getData().get(4).getXValue());

        LineChart<Number, Number> chart = new LineChart<>(new NumberAxis(), new NumberAxis());
        chart.getData().add(squares);
        stage.setScene(new Scene(chart));
        stage.setTitle("Squares");
        stage.show();
    }

    /**
     * A program should put points at x = 0, 0.5, 1, 1.5 and 2, but its author wrote {@code i / 2}. What does it print?
     * Hints
     * 1. {@code i} is an int and so is {@code 2}, so {@code i / 2} is integer division: 0, 0, 1, 1, 2. The loop still adds five points.
     * 2. The point at index 3 was made when {@code i} was 3: x is {@code 3 / 2}, and y is {@code 3 * 3}. Printing a point gives {@code Data[x,y,null]}.
     */
    public static void main(String[] args) {
        launch(Challenge03Ai.class);
    }
}
