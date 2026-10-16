> [!info] AI-Generated

# Bar charts for categories

A line chart has numbers on both axes, and its line says that the values change from one x to the next. Often the x values are names instead: days of the week, products, kinds of books. Such values are **categories**, and a **bar chart** compares them, with a bar per category whose height is its value.

## A bar chart

A city's bike share counts the trips started on each day of one week:

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
        CategoryAxis days = new CategoryAxis();
        days.setLabel("Day");
        NumberAxis trips = new NumberAxis();
        trips.setLabel("Trips");
        BarChart<String, Number> chart = new BarChart<>(days, trips);
        chart.setTitle("Bike share trips in a week");
        chart.setLegendVisible(false);

        XYChart.Series<String, Number> week = new XYChart.Series<>();
        week.setName("Trips");
        week.getData().add(new XYChart.Data<>("Mon", 340));
        week.getData().add(new XYChart.Data<>("Tue", 310));
        week.getData().add(new XYChart.Data<>("Wed", 365));
        week.getData().add(new XYChart.Data<>("Thu", 330));
        week.getData().add(new XYChart.Data<>("Fri", 405));
        week.getData().add(new XYChart.Data<>("Sat", 520));
        week.getData().add(new XYChart.Data<>("Sun", 470));
        chart.getData().add(week);

        stage.setScene(new Scene(chart));
        stage.setTitle("Bike share");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

- A **CategoryAxis** is an axis of text values. Each category gets a place of its own along the axis, in the order the categories first appear in the data: here Mon to Sun, as they were added.
- `BarChart<String, Number>`: the x values are Strings and the y values Numbers, so the series and the points have the same two types, `XYChart.Series<String, Number>` and `new XYChart.Data<>("Mon", 340)`.
- Everything else is as in a line chart: titles, labels, series, legend. In the window as text, a category is in quotes: `("Mon", 340)`.
- A bar chart needs one category axis and one number axis. With the number axis first, `BarChart<Number, String>`, the bars lie sideways, which suits long category names.

## Totals from a file

The bike share's file has a row per station and day. A station that was closed for the day (for repairs) has a `-`:

**The file trips.csv**

```text
day,station,trips
Mon,Harbor,180
Mon,Market,160
Tue,Harbor,150
Tue,Market,-
Wed,Harbor,170
Wed,Market,195
Thu,Harbor,165
Thu,Market,165
```

The chart of the days needs each day's **total**, so the program adds the rows up in a map from the day to its total, as module 31 counted things. It also needs the days in order, and a HashMap's keys don't keep one, so a list keeps the days in the order they first appear in the file:

```java
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        Map<String, Integer> totals = new HashMap<>();
        List<String> days = new ArrayList<>();
        List<String> lines = Files.readAllLines(Paths.get("trips.csv"));
        for (int i = 1; i < lines.size(); i++) {
            String[] parts = lines.get(i).split(",");
            String day = parts[0];
            if (!days.contains(day)) {
                days.add(day);
                totals.put(day, 0);
            }
            if (!parts[2].equals("-")) {
                totals.put(day, totals.get(day) + Integer.valueOf(parts[2]));
            }
        }

        CategoryAxis dayAxis = new CategoryAxis();
        dayAxis.setLabel("Day");
        NumberAxis tripAxis = new NumberAxis();
        tripAxis.setLabel("Trips");
        BarChart<String, Number> chart = new BarChart<>(dayAxis, tripAxis);
        chart.setTitle("Trips per day, all stations");
        chart.setLegendVisible(false);
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Trips");
        for (String day : days) {
            series.getData().add(new XYChart.Data<>(day, totals.get(day)));
        }
        chart.getData().add(series);

        stage.setScene(new Scene(chart));
        stage.setTitle("Bike share");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

- A day enters the list and the map (with the total 0) at its first row, and every row with a number adds to its day's total. A closed station adds nothing to the total: no trips started there.
- The bars come from the list, in its order, and each bar's value from the map.

## Bars side by side

To compare the stations, each station gets a series of its own, as each plant did in step 3. A bar chart puts the bars of a category side by side, one per series, and the legend tells the series apart:

**The file trips.csv**

```text
day,station,trips
Mon,Harbor,180
Mon,Market,160
Tue,Harbor,150
Tue,Market,-
Wed,Harbor,170
Wed,Market,195
Thu,Harbor,165
Thu,Market,165
```

```java
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        Map<String, XYChart.Series<String, Number>> byStation = new HashMap<>();
        List<String> lines = Files.readAllLines(Paths.get("trips.csv"));
        for (int i = 1; i < lines.size(); i++) {
            String[] parts = lines.get(i).split(",");
            String station = parts[1];
            if (!byStation.containsKey(station)) {
                XYChart.Series<String, Number> series = new XYChart.Series<>();
                series.setName(station);
                byStation.put(station, series);
            }
            int trips = 0;
            if (!parts[2].equals("-")) {
                trips = Integer.valueOf(parts[2]);
            }
            byStation.get(station).getData().add(new XYChart.Data<>(parts[0], trips));
        }

        CategoryAxis dayAxis = new CategoryAxis();
        dayAxis.setLabel("Day");
        NumberAxis tripAxis = new NumberAxis();
        tripAxis.setLabel("Trips");
        BarChart<String, Number> chart = new BarChart<>(dayAxis, tripAxis);
        chart.setTitle("Trips per station");
        List<String> stations = new ArrayList<>(byStation.keySet());
        Collections.sort(stations);
        for (String station : stations) {
            chart.getData().add(byStation.get(station));
        }

        stage.setScene(new Scene(chart));
        stage.setTitle("Bike share");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

- Here a closed station gets a bar of 0 for its day, on purpose: every series then has the same categories in the same order, and the empty place next to Harbor's Tuesday bar shows that Market had no trips. (A `-` that meant "not measured" would instead be left out, as in step 1: then no bar, rather than a bar of 0.)
- The stations are sorted by name, as the plants were, so the series are in a fixed order.

---

Source: [Bar charts for categories](https://javaarena.com/learn/charts/bar-charts/) in the module [Data visualization](https://javaarena.com/learn/charts/) on Java Arena.

This module follows section [14.1 Data visualization](https://java-programming.mooc.fi/part-14/1-data-visualization) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
