> [!info] AI-Generated

# A first line chart

A **line chart** shows how a value changes: the x axis goes across (often time: days, weeks, months), the y axis goes up (the value), and a line joins the points. A class grows a corn seedling on its windowsill and measures it once a week:

```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        NumberAxis weeks = new NumberAxis();
        NumberAxis height = new NumberAxis();
        LineChart<Number, Number> chart = new LineChart<>(weeks, height);

        XYChart.Series<Number, Number> corn = new XYChart.Series<>();
        corn.getData().add(new XYChart.Data<>(1, 3));
        corn.getData().add(new XYChart.Data<>(2, 7));
        corn.getData().add(new XYChart.Data<>(3, 14));
        corn.getData().add(new XYChart.Data<>(4, 26));
        corn.getData().add(new XYChart.Data<>(5, 41));
        chart.getData().add(corn);

        stage.setScene(new Scene(chart));
        stage.setTitle("Corn");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

The classes are in the package `javafx.scene.chart`. Part by part:

- `NumberAxis` is an **axis** for numbers. A chart has two: the first one given is the x axis, the second the y axis.
- `LineChart<Number, Number>` is a line chart whose x values and y values are both numbers. Like the classes of module 44, the chart has type parameters: the type of its x values, then of its y values. **Number** is a class of `java.lang` that Integer and Double both extend, so a chart of Numbers takes whole numbers and decimals alike. `new LineChart<>(weeks, height)` gives the chart its two axes.
- `XYChart.Series` is one **series**: a set of points that the chart joins with a line. Its name has a dot because Series is a class written inside the class XYChart (the class that every chart with an x and a y axis extends). The import of `javafx.scene.chart.XYChart` covers it.
- `new XYChart.Data<>(1, 3)` is one **data point**: x is 1 (week 1) and y is 3 (cm). `corn.getData()` is the series's list of points, and `add` adds one at the end.
- `getXValue()` and `getYValue()` read a point's values, `setYValue(...)` changes one, and the series holds the point objects themselves, so a change to a point you kept shows in the series.
- `chart.getData()` is the chart's list of series. A series shows only once it's added to the chart.
- A chart is a node, like a label or a VBox: here it's the scene's root, and it could just as well be in a layout.

A `new NumberAxis()` is **auto-ranging**: it picks its range from the data, so that every point fits. By default it also includes 0, so the y axis here starts at 0. The page draws an auto-ranging axis with a range it works out the way JavaFX does, approximately.

## Titles, labels and fixed bounds

A chart that nobody can read is no use. The same chart with a title, labels on its axes and a fixed range for the weeks:

```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        NumberAxis weeks = new NumberAxis("Week", 1, 6, 1);
        NumberAxis height = new NumberAxis();
        height.setLabel("Height (cm)");
        LineChart<Number, Number> chart = new LineChart<>(weeks, height);
        chart.setTitle("A corn plant grows");
        chart.setLegendVisible(false);

        XYChart.Series<Number, Number> corn = new XYChart.Series<>();
        corn.setName("Corn");
        corn.getData().add(new XYChart.Data<>(1, 3));
        corn.getData().add(new XYChart.Data<>(2, 7));
        corn.getData().add(new XYChart.Data<>(3, 14));
        corn.getData().add(new XYChart.Data<>(4, 26));
        corn.getData().add(new XYChart.Data<>(5, 41));
        corn.getData().add(new XYChart.Data<>(6, 58.5));
        chart.getData().add(corn);

        stage.setScene(new Scene(chart));
        stage.setTitle("Corn");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

- `new NumberAxis("Week", 1, 6, 1)` is an axis with the label `Week` that goes from 1 (its **lower bound**) to 6 (its **upper bound**), with a tick mark and a number every 1 (its **tick unit**). An axis with bounds isn't auto-ranging: it shows exactly that range, even if a point lies outside it. `new NumberAxis(1, 6, 1)` is the same without a label. `getLowerBound()`, `getUpperBound()` and `getTickUnit()` read them back as doubles (`1.0`, not `1`), and `isAutoRanging()` says whether the axis picks its own range.
- `height.setLabel("Height (cm)")` labels an axis that stays auto-ranging. A label should say the unit: 58.5 what?
- `chart.setTitle(...)` is the title above the chart (and `stage.setTitle(...)` still the window's own title).
- `corn.setName("Corn")` names the series. The chart's **legend**, under the chart, shows each series's name next to its color. With one series the legend says little, so `chart.setLegendVisible(false)` hides it.
- Week 6 is `58.5`, a Double, in the same series as the Integers: both are Numbers.

## What the page draws, and what's checked

The drawing above is the page's own, made from what the program told the chart: approximate, like the windows of part 13. What the program decided is listed exactly under it, in "The window as text":

```text
Window "Corn"
  LineChart "A corn plant grows" (no legend)
    x axis NumberAxis "Week" 1 to 6 by 1
    y axis NumberAxis "Height (cm)"
    series "Corn": (1, 3) (2, 7) (3, 14) (4, 26) (5, 41) (6, 58.5)
```

These lines are what the checks of the challenges compare: the kind of chart, its title, whether the legend shows, each axis (its class and label, and its bounds and tick unit when you set them), and each series, with its name and its points in the order they were added. So a task says all of these exactly, and when it says that an axis is auto-ranging, its line shows no bounds. The colors, the sizes and the range that an auto-ranging axis picks aren't compared. Numbers are written without a `.0` at the end, so 58.5 is `58.5` and 41.0 would be `41`.

## From a file

The class keeps the heights in a file, with a `-` for a week when nobody measured:

**The file corn.csv**

```text
week,cm
1,3
2,7
3,-
4,26
5,41
6,58.5
```

`start` reads it as step 1 did. `start` may declare `throws Exception` (module 48 did), so the reading needs no `try`:

```java
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        NumberAxis weeks = new NumberAxis("Week", 1, 6, 1);
        NumberAxis height = new NumberAxis();
        height.setLabel("Height (cm)");
        LineChart<Number, Number> chart = new LineChart<>(weeks, height);
        chart.setTitle("A corn plant grows");
        chart.setLegendVisible(false);

        XYChart.Series<Number, Number> corn = new XYChart.Series<>();
        corn.setName("Corn");
        List<String> lines = Files.readAllLines(Paths.get("corn.csv"));
        for (int i = 1; i < lines.size(); i++) {
            String[] parts = lines.get(i).split(",");
            if (!parts[1].equals("-")) {
                int week = Integer.valueOf(parts[0]);
                double cm = Double.valueOf(parts[1]);
                corn.getData().add(new XYChart.Data<>(week, cm));
            }
        }
        chart.getData().add(corn);
        System.out.println(corn);
        System.out.println(corn.getData().size() + " points");
        System.out.println(corn.getData().get(2));

        stage.setScene(new Scene(chart));
        stage.setTitle("Corn");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

**Output**

```text
Series[Corn]
5 points
Data[4,26.0,null]
```

- Week 3 has no point, so the line goes straight from week 2 to week 4. A reader can easily miss that a week is missing: only the missing mark at week 3 shows it, while the window as text and the `5 points` above say it plainly.
- Printing a series shows its name, and printing a point shows its x and its y. The third value, `null`, is an extra value that JavaFX lets a point carry; this course doesn't use it. The third point is week 4's: the index counts the points of the series, not the rows of the file.
- `cm` is a double, so even `26` from the file became `26.0`. In the window as text it's `26`, since that leaves out the `.0`.

---

Source: [A first line chart](https://javaarena.com/learn/charts/line-chart/) in the module [Data visualization](https://javaarena.com/learn/charts/) on Java Arena.

This module follows section [14.1 Data visualization](https://java-programming.mooc.fi/part-14/1-data-visualization) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
