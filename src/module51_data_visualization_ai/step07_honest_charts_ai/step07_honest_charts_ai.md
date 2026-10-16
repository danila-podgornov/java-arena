> [!info] AI-Generated

# Honest charts

A chart can persuade: a picture makes a point faster than a table of numbers does. That's why a chart must show its numbers fairly. The same numbers can make a small difference look huge, by a choice that's easy to miss: where the y axis starts.

## A truncated axis

Three brands of rechargeable batteries are compared by how many times a battery can be charged before it wears out. The brands and the numbers are made up:

```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        CategoryAxis brands = new CategoryAxis();
        NumberAxis cycles = new NumberAxis("Charge cycles", 970, 1015, 5);
        BarChart<String, Number> chart = new BarChart<>(brands, cycles);
        chart.setTitle("Brand C lasts longest!");
        chart.setLegendVisible(false);

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Cycles");
        series.getData().add(new XYChart.Data<>("Brand A", 980));
        series.getData().add(new XYChart.Data<>("Brand B", 1000));
        series.getData().add(new XYChart.Data<>("Brand C", 1010));
        chart.getData().add(series);

        stage.setScene(new Scene(chart));
        stage.setTitle("Batteries");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

Brand C's bar is four times as tall as Brand A's, yet its number is only 3 percent bigger (1010 against 980). The y axis starts at 970: it is **truncated**. Every bar loses the same 970 from its bottom, which takes away almost all of the short bars and leaves the differences.

The length of a bar is what the eye compares, so the length must stand for the value: a bar twice as long must mean twice as much. That holds only when the bars start at 0. The fair chart is the same program with another axis:

```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        CategoryAxis brands = new CategoryAxis();
        NumberAxis cycles = new NumberAxis("Charge cycles", 0, 1200, 200);
        BarChart<String, Number> chart = new BarChart<>(brands, cycles);
        chart.setTitle("Charge cycles per battery");
        chart.setLegendVisible(false);

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Cycles");
        series.getData().add(new XYChart.Data<>("Brand A", 980));
        series.getData().add(new XYChart.Data<>("Brand B", 1000));
        series.getData().add(new XYChart.Data<>("Brand C", 1010));
        chart.getData().add(series);

        stage.setScene(new Scene(chart));
        stage.setTitle("Batteries");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

Now the bars are almost the same, as the numbers are. The title changed too: it says what is shown, and leaves the judging to the reader.

## Rules of thumb

- **Bars start at 0.** An auto-ranging NumberAxis already includes 0, since its `forceZeroInRange` is `true` by default. `setForceZeroInRange(false)` lets it start near the smallest value instead, and so do bounds that you give. Never do either for bars.
- **Lines may zoom in, in plain sight.** A line chart shows how a value changes, and a y axis from 15 to 25 °C can be the right choice for a day's temperatures. The numbers on the axis say where it starts, so a reader can see that it zooms in.
- **Charts that are compared share their scale.** Two charts side by side with different y axes look alike when their numbers aren't.
- **Labels say what and in which unit**, and a title says what is shown, not what to think of it.

In this module's tasks, honest bounds are set with numbers (the window as text shows bounds that are set, and not `forceZeroInRange`).

## Honest bounds, computed

When the data comes from a file, the program doesn't know the largest value in advance, so it computes the bounds: 0 at the bottom, and at the top the first tick at or above the largest value. A class without JavaFX does it:

**Main.java**

```java
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> cycles = new ArrayList<>();
        cycles.add(980);
        cycles.add(1000);
        cycles.add(1010);
        System.out.println(Bounds.upperBound(cycles, 200));
        System.out.println(Bounds.upperBound(cycles, 10));
        System.out.println(Bounds.upperBound(new ArrayList<>(), 50));
    }
}
```

**Bounds.java**

```java
import java.util.List;

public class Bounds {

    public static int upperBound(List<Integer> values, int tick) {
        int max = 0;
        for (int value : values) {
            max = Math.max(max, value);
        }
        int upper = tick;
        while (upper < max) {
            upper += tick;
        }
        return upper;
    }
}
```

**Output**

```text
1200
1010
50
```

The upper bound is a whole number of ticks, so the top of the axis has a number, and it's at least one tick, so an axis for data of only zeros still has a range. The chart then uses `new NumberAxis("Charge cycles", 0, Bounds.upperBound(cycles, 200), 200)`.

---

Source: [Honest charts](https://javaarena.com/learn/charts/honest-charts/) in the module [Data visualization](https://javaarena.com/learn/charts/) on Java Arena.

This module follows section [14.1 Data visualization](https://java-programming.mooc.fi/part-14/1-data-visualization) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
