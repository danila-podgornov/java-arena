> [!info] AI-Generated

# A slider that redraws a chart

A chart can answer "what if?" questions: what if I paid more each month, what if the price were lower? A **slider** lets the user pick a number by dragging, and the program redraws the chart for it.

## A slider and its value

Ana borrows 1200 euros from a friend, without interest, and pays the same amount back each month. A slider picks the amount:

```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Slider payment = new Slider(50, 300, 100);
        payment.setShowTickLabels(true);
        payment.setShowTickMarks(true);
        payment.setMajorTickUnit(50);
        Label amount = new Label("Pay 100 euros a month");
        Label months = new Label("Paid back in 12 months");
        payment.valueProperty().addListener((observable, oldValue, newValue) -> {
            int euros = newValue.intValue();
            amount.setText("Pay " + euros + " euros a month");
            months.setText("Paid back in " + this.monthsToPay(1200, euros) + " months");
        });

        stage.setScene(new Scene(new VBox(10, payment, amount, months)));
        stage.setTitle("Paying back");
        stage.show();
    }

    private int monthsToPay(int debt, int perMonth) {
        return (debt + perMonth - 1) / perMonth;
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

```text
set Slider 1 150
```

The window is drawn after the event in the block under the code, `set Slider 1 150`: the first slider of the window, moved to 150. The checks of the challenges move sliders with such lines. When you run a program yourself ("Run with my input" in a challenge, or the Playground), you can drag its slider: when you let go of it, the program runs again from the start with the slider moved to where you let go, as a click on a button did in part 13.

- `new Slider(50, 300, 100)` goes from 50 (its **min**) to 300 (its **max**) and starts at 100. `getValue()` returns the value, a double, and `setValue(...)` moves the slider. A value outside the range is kept inside it: `setValue(500)` moves this slider to 300.
- `setShowTickMarks(true)` draws tick marks along the slider and `setShowTickLabels(true)` numbers under them, a number every `setMajorTickUnit(50)`, counted from the min.
- `payment.valueProperty()` is the value as a property, like the `textProperty()` of a text field in module 49, and `addListener` gives it a listener that runs at each real change. The old and the new value are **Numbers** here, not doubles: `newValue.intValue()` gives the whole part (137.8 gives 137), and `newValue.doubleValue()` the double. `newValue * 2` doesn't compile, since a Number isn't a double: get a double or an int out of it first.
- The listener runs only when the value changes. The labels must match the slider before anyone moves it, so `start` gives them the texts for 100.
- `(debt + perMonth - 1) / perMonth` rounds the division up: 1200 at 150 a month takes exactly 8 months, and 1200 at 250 takes 5 (the last month pays less).

## Snapping to ticks

A payment of 137.4 euros is odd. With `setSnapToTicks(true)`, a slider that is let go moves to the nearest **tick**. The ticks are the major ticks, plus `setMinorTickCount(...)` small ticks between each two of them (3 by default). So with a major tick unit of 50 and a minor tick count of 4, there's a tick every 10: 50, 60, 70 and so on, and `set Slider 1 137` moves the slider to 140. With a minor tick count of 0, only the major ticks are left. Halfway between two ticks goes up.

In the window as text, a slider's line says its min, max and value, then what was set. For the payment slider above, with `setMinorTickCount(4)` and `setSnapToTicks(true)` added, after `set Slider 1 137`, it reads `Slider 50 to 300, value 140, tick labels, tick marks, major tick 50, snaps` (the minor tick count isn't listed, but it decides where the slider snaps).

## Redrawing a chart

Now Ana's debt month by month, as a line chart that follows the slider. When the payment changes, the program **clears** the series and fills it again with the new points:

```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Slider payment = new Slider(50, 300, 100);
        payment.setShowTickLabels(true);
        payment.setMajorTickUnit(50);
        payment.setMinorTickCount(4);
        payment.setSnapToTicks(true);
        Label amount = new Label("Pay 100 euros a month");

        NumberAxis months = new NumberAxis("Month", 0, 24, 2);
        NumberAxis owed = new NumberAxis("Still owed (euros)", 0, 1200, 200);
        LineChart<Number, Number> chart = new LineChart<>(months, owed);
        chart.setTitle("Paying back 1200 euros");
        chart.setLegendVisible(false);
        XYChart.Series<Number, Number> debt = new XYChart.Series<>();
        debt.setName("Debt");
        this.fill(debt, 100);
        chart.getData().add(debt);

        payment.valueProperty().addListener((observable, oldValue, newValue) -> {
            int euros = newValue.intValue();
            amount.setText("Pay " + euros + " euros a month");
            this.fill(debt, euros);
        });

        stage.setScene(new Scene(new VBox(10, payment, amount, chart)));
        stage.setTitle("Paying back");
        stage.show();
    }

    private void fill(XYChart.Series<Number, Number> debt, int perMonth) {
        debt.getData().clear();
        int owed = 1200;
        int month = 0;
        debt.getData().add(new XYChart.Data<>(month, owed));
        while (owed > 0) {
            owed = Math.max(0, owed - perMonth);
            month++;
            debt.getData().add(new XYChart.Data<>(month, owed));
        }
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

```text
set Slider 1 237
```

- The slider snaps: 237 becomes 240, so the debt is gone in 5 months.
- `fill` empties the series with `debt.getData().clear()`, then adds the points for the new payment: the debt at month 0, and after each month until nothing is owed. Without the `clear()`, the new points would come after the old ones, and the line would jump back to the start.
- `fill` runs once in `start`, for the first payment, and again in the listener at each change. Writing the filling once, in a method, keeps the two the same.
- The series stays in the chart the whole time, with its name and its color: only its points change.
- Both axes have fixed bounds. An auto-ranging axis would pick a new range at every move, and the line would seem to stay put while the numbers under it changed. Fixed bounds make the moves visible: a bigger payment makes the line fall faster.

---

Source: [A slider that redraws a chart](https://javaarena.com/learn/charts/slider/) in the module [Data visualization](https://javaarena.com/learn/charts/) on Java Arena.

This module follows section [14.1 Data visualization](https://java-programming.mooc.fi/part-14/1-data-visualization) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
