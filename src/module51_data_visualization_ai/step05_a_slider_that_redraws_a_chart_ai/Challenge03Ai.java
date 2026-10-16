// AI-Generated
package module51_data_visualization_ai.step05_a_slider_that_redraws_a_chart_ai;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Challenge03Ai extends Application {

    @Override
    public void start(Stage stage) {
        Slider price = new Slider(1, 5, 3);
        price.setShowTickLabels(true);
        price.setMajorTickUnit(1);
        price.setMinorTickCount(0);
        price.setSnapToTicks(true);
        Label label = new Label("Plan B: 3 euros per GB");

        NumberAxis gigabytes = new NumberAxis("GB", 0, 10, 1);
        NumberAxis euros = new NumberAxis();
        euros.setLabel("Euros");
        LineChart<Number, Number> chart = new LineChart<>(gigabytes, euros);
        chart.setTitle("Monthly cost");
        XYChart.Series<Number, Number> planA = new XYChart.Series<>();
        planA.setName("Plan A");
        for (int gb = 0; gb <= 10; gb++) {
            planA.getData().add(new XYChart.Data<>(gb, 10 + 2 * gb));
        }
        chart.getData().add(planA);

        stage.setScene(new Scene(new VBox(10, price, label, chart)));
        stage.setTitle("Phone plans");
        stage.show();
    }

    /**
     * A phone company has two plans. <b>Plan A</b> costs 10 euros a month plus 2 euros per GB of data. <b>Plan B</b> has no monthly fee, only a price per GB, and a slider tries out that price. The window is partly built: the slider, the label and the chart with Plan A. Add Plan B:
     * <ul>
     * <li>a second series, {@code Plan B}, added to the chart after Plan A, with a point (gb, price * gb) for each gb from 0 to 10, where the price is the slider's value as an int
     * <li>when the slider moves, Plan B gets the points for the new price (it stays the second series), and the label says {@code Plan B: 4 euros per GB} with the new price
     * </ul>
     * <p>The slider goes from 1 to 5, starts at 3 and snaps to whole numbers. The task card shows the window after the slider is moved to 4.
     * Hints
     * 1. Write a method {@code fill(XYChart.Series<Number, Number> plan, int perGb)} that clears the series and adds the 11 points. Call it in {@code start} with 3, before adding Plan B to the chart.
     * 2. In the listener of {@code price.valueProperty()}, take {@code newValue.intValue()}, set the label's text and call {@code fill} again with the new price.
     */
    public static void main(String[] args) {
        launch(Challenge03Ai.class);
    }
}
