// AI-Generated
package module51_data_visualization_ai.step02_a_first_line_chart_ai;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class Challenge03Ai extends Application {

    @Override
    public void start(Stage stage) {
        XYChart.Series<Number, Number> basil = new XYChart.Series<>();
        basil.setName("Basil");
        XYChart.Data<Number, Number> first = new XYChart.Data<>(1, 4);
        basil.getData().add(first);
        basil.getData().add(new XYChart.Data<>(2, 9));
        first.setYValue(5);
        System.out.println(basil.getData().size());
        System.out.println(first.getXValue() + " " + first.getYValue());
        System.out.println(basil.getData().get(1));
        System.out.println(basil);

        LineChart<Number, Number> chart = new LineChart<>(new NumberAxis(), new NumberAxis());
        chart.getData().add(basil);
        stage.setScene(new Scene(chart));
        stage.setTitle("Herbs");
        stage.show();
    }

    /**
     * A herb garden's basil gets a series of its own. What does this program print?
     * Hints
     * 1. The series holds the point objects themselves, so {@code first.setYValue(5)} changes the first point of the series. {@code getXValue()} and {@code getYValue()} give a point's x and y.
     * 2. Printing a point gives {@code Data[x,y,null]}, and printing a series gives {@code Series[} and its name, then {@code ]}.
     */
    public static void main(String[] args) {
        launch(Challenge03Ai.class);
    }
}
