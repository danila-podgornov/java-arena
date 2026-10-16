> [!info] AI-Generated

# Series from a formula

Not every chart shows measurements. A chart can show what a formula computes, and then the points come from a loop. Module 50 kept an application's logic in a plain class without JavaFX, which can be checked without a window; computed points belong in such a class too, and the window only draws them.

## Computing the points

A cup of tea cools down. A simple model of it (a model, not an exact law of nature): each minute, the tea loses a tenth of how much warmer than the room it is. The class `Cooling` computes the temperature at each minute:

**Main.java**

```java
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Double> tea = Cooling.temperatures(90, 20, 5);
        System.out.println(tea);
        System.out.println("After 5 minutes: " + tea.get(5));
    }
}
```

**Cooling.java**

```java
import java.util.ArrayList;
import java.util.List;

public class Cooling {

    public static List<Double> temperatures(double start, double room, int minutes) {
        List<Double> temps = new ArrayList<>();
        double tea = start;
        for (int minute = 0; minute <= minutes; minute++) {
            temps.add(Math.round(tea * 10) / 10.0);
            tea = room + (tea - room) * 0.9;
        }
        return temps;
    }
}
```

**Output**

```text
[90.0, 83.0, 76.7, 71.0, 65.9, 61.3]
After 5 minutes: 61.3
```

- The list holds the temperature at minute 0, 1, 2 and so on: the index is the minute. So the x of each point is its index, and the list needs no x values of its own.
- `Math.round(x)` rounds a double to the nearest whole number and gives it as a `long` (2.5 goes up to 3). So `Math.round(tea * 10) / 10.0` keeps one decimal: 65.927 becomes 659.27, then 659, then 65.9. Dividing by `10.0`, a double, is what keeps the decimal. Computing with doubles leaves tiny errors (`0.1 + 0.2` is `0.30000000000000004`), and the window as text would show them. Rounding what goes into the chart keeps the numbers readable.
- The program prints the numbers before any chart exists. Checking them first is easier than reading them off a drawing.

## Charting them

The window makes a series from each list. The tea in a 20 °C kitchen, and the same tea taken out to a 5 °C balcony:

**Main.java**

```java
import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        NumberAxis minutes = new NumberAxis("Minutes", 0, 30, 5);
        NumberAxis degrees = new NumberAxis();
        degrees.setLabel("Temperature (°C)");
        LineChart<Number, Number> chart = new LineChart<>(minutes, degrees);
        chart.setTitle("A cup of tea cools down");
        chart.setCreateSymbols(false);

        chart.getData().add(series("In the kitchen", Cooling.temperatures(90, 20, 30)));
        chart.getData().add(series("On the balcony", Cooling.temperatures(90, 5, 30)));

        stage.setScene(new Scene(chart));
        stage.setTitle("Tea");
        stage.show();
    }

    private XYChart.Series<Number, Number> series(String name, List<Double> values) {
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName(name);
        for (int x = 0; x < values.size(); x++) {
            series.getData().add(new XYChart.Data<>(x, values.get(x)));
        }
        return series;
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

**Cooling.java**

```java
import java.util.ArrayList;
import java.util.List;

public class Cooling {

    public static List<Double> temperatures(double start, double room, int minutes) {
        List<Double> temps = new ArrayList<>();
        double tea = start;
        for (int minute = 0; minute <= minutes; minute++) {
            temps.add(Math.round(tea * 10) / 10.0);
            tea = room + (tea - room) * 0.9;
        }
        return temps;
    }
}
```

- The method `series` turns a name and a list of values into a series, so both lines are made the same way. It's an instance method of Main, as `start` is.
- `chart.setCreateSymbols(false)` leaves out the marks that a line chart puts on each point. With 31 points per line, the marks would only clutter it. The window as text says `(no symbols)`.
- Both series share the axes, so the lines can be compared: the tea on the balcony cools faster, and toward a lower temperature.

## Points without a line: ScatterChart

A **ScatterChart** draws the points and no line. It suits points that have no order, where a line from one to the next would mean nothing. Fifteen raindrops land on a paving stone of 50 by 50 cm. Where each one lands is random, so the program uses a `Random` with a seed (module 46): the drops land in the same places at every run, and the window is the same at every run, as the window of a check must be.

```java
import java.util.Random;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        ScatterChart<Number, Number> chart = new ScatterChart<>(new NumberAxis("cm", 0, 50, 10), new NumberAxis("cm", 0, 50, 10));
        chart.setTitle("Raindrops on a paving stone");
        chart.setLegendVisible(false);

        Random random = new Random(14);
        XYChart.Series<Number, Number> drops = new XYChart.Series<>();
        drops.setName("Drops");
        for (int i = 0; i < 15; i++) {
            int x = random.nextInt(51);
            int y = random.nextInt(51);
            drops.getData().add(new XYChart.Data<>(x, y));
        }
        chart.getData().add(drops);

        stage.setScene(new Scene(chart));
        stage.setTitle("Rain");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

A ScatterChart is made and filled exactly like a LineChart: axes, series, data points.

---

Source: [Series from a formula](https://javaarena.com/learn/charts/series-from-formula/) in the module [Data visualization](https://javaarena.com/learn/charts/) on Java Arena.

This module follows section [14.1 Data visualization](https://java-programming.mooc.fi/part-14/1-data-visualization) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
