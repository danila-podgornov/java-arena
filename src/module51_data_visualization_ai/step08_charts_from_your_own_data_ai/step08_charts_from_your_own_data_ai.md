> [!info] AI-Generated

# Charts from your own data

This step puts the module together: a file of rows, some computing, and a chart that shows the result honestly. The last challenge is a small tool that charts any data written in its format.

## From a file to a chart, the whole way

A household writes down its electricity meter's reading at the start of each month. The meter only counts up, so the electricity used in a month is the difference between two readings in a row:

**The file meter.csv**

```text
month,kWh
Jan,10250
Feb,10560
Mar,10830
Apr,11040
May,11190
```

The computing goes in a class of its own, and the window charts what it returns:

**Main.java**

```java
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

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        List<String> months = new ArrayList<>();
        List<Integer> readings = new ArrayList<>();
        List<String> lines = Files.readAllLines(Paths.get("meter.csv"));
        for (int i = 1; i < lines.size(); i++) {
            String[] parts = lines.get(i).split(",");
            months.add(parts[0]);
            readings.add(Integer.valueOf(parts[1]));
        }
        List<Integer> used = Meter.differences(readings);
        System.out.println(used);

        CategoryAxis monthAxis = new CategoryAxis();
        monthAxis.setLabel("Month");
        NumberAxis kwhAxis = new NumberAxis();
        kwhAxis.setLabel("Electricity used (kWh)");
        BarChart<String, Number> chart = new BarChart<>(monthAxis, kwhAxis);
        chart.setTitle("Electricity used per month");
        chart.setLegendVisible(false);
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("kWh");
        for (int i = 0; i < used.size(); i++) {
            series.getData().add(new XYChart.Data<>(months.get(i), used.get(i)));
        }
        chart.getData().add(series);

        stage.setScene(new Scene(chart));
        stage.setTitle("Electricity");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

**Meter.java**

```java
import java.util.ArrayList;
import java.util.List;

public class Meter {

    public static List<Integer> differences(List<Integer> readings) {
        List<Integer> used = new ArrayList<>();
        for (int i = 1; i < readings.size(); i++) {
            used.add(readings.get(i) - readings.get(i - 1));
        }
        return used;
    }
}
```

**Output**

```text
[310, 270, 210, 150]
```

Five readings give four differences: the reading of February minus that of January is what January used, so the bars are January to April. `months.get(i)` pairs difference `i` with the month it was used in.

Here are the choices that every chart of this module made, as a list to go through for a chart of your own:

1. **Read the rows**: skip the header, `split` on the separator, turn the text into numbers with `Integer.valueOf` or `Double.valueOf`, and decide what a missing value (`-`) means: left out, or 0 because nothing happened.
2. **Compute** what the chart shows (totals, differences, a formula) in a plain class, and print it to check it before any chart exists.
3. **Choose the chart**: a line chart when x is a number and the values change along it, a bar chart to compare categories, a scatter chart for points that have no order.
4. **Axes**: labels with units, bars from 0, fixed bounds when a slider changes the data, and the same scale for charts that are compared.
5. **Series**: a name for each, the legend when there are several, the points from the smallest x up, and series in an order you chose (the file's, or sorted names), never a HashMap's.

## The end of section 14.1

This module followed the MOOC's section 14.1, on data visualization. You read rows of data into numbers, lists and maps, drew line charts with NumberAxis, XYChart.Series and XYChart.Data, made several series from a file's columns or from a map, computed series from a formula in a plain class, redrew a chart with a Slider and its `valueProperty()` listener, compared categories with a BarChart and a CategoryAxis, and kept charts honest. Module 52 follows the MOOC's section 14.2: it draws on a canvas with colors and the mouse, works with images pixel by pixel, and explains sound.

---

Source: [Charts from your own data](https://javaarena.com/learn/charts/own-data/) in the module [Data visualization](https://javaarena.com/learn/charts/) on Java Arena.

This module follows section [14.1 Data visualization](https://java-programming.mooc.fi/part-14/1-data-visualization) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
