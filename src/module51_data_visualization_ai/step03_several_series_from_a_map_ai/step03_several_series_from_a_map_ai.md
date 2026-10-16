> [!info] AI-Generated

# Several series from a map

One chart can hold several series. Each gets a line of its own, in a color of its own, and the legend says which line is which: that's what makes lines easy to compare. A bakery counts what it sells of three products each week, one column per product:

**The file bakery.csv**

```text
week,bread,buns,pies
1,120,80,15
2,115,95,-
3,130,90,18
4,125,-,22
5,140,105,20
```

The names of the series come from the header, so the program needs no change when the bakery adds a fourth product:

```java
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
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
        NumberAxis weeks = new NumberAxis("Week", 1, 5, 1);
        NumberAxis sold = new NumberAxis();
        sold.setLabel("Sold");
        LineChart<Number, Number> chart = new LineChart<>(weeks, sold);
        chart.setTitle("Bakery sales");

        List<String> lines = Files.readAllLines(Paths.get("bakery.csv"));
        String[] names = lines.get(0).split(",");
        List<XYChart.Series<Number, Number>> products = new ArrayList<>();
        for (int c = 1; c < names.length; c++) {
            XYChart.Series<Number, Number> series = new XYChart.Series<>();
            series.setName(names[c]);
            products.add(series);
        }
        for (int i = 1; i < lines.size(); i++) {
            String[] parts = lines.get(i).split(",");
            int week = Integer.valueOf(parts[0]);
            for (int c = 1; c < parts.length; c++) {
                if (!parts[c].equals("-")) {
                    products.get(c - 1).getData().add(new XYChart.Data<>(week, Integer.valueOf(parts[c])));
                }
            }
        }
        chart.getData().addAll(products);

        stage.setScene(new Scene(chart));
        stage.setTitle("Bakery");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

- Column `c` of the file is the series at index `c - 1` of the list, since column 0 is the week.
- A `-` leaves that week out of that series only: the other products of the week still get their points.
- `chart.getData().addAll(products)` adds every series of the list, in its order. That order is the order of the legend, and the order in which the chart hands out its colors.
- The legend is visible, as charts have it by default. With three lines, it's needed.

## One series per key

A file can also have one row per measurement. A school garden measures three plants each week, and writes a row for each plant:

**The file garden.csv**

```text
week,plant,cm
1,tomato,12
1,bean,8
1,pea,5
2,tomato,15
2,bean,13
2,pea,-
3,tomato,19
3,bean,20
3,pea,9
```

Now the names are in the rows, and the program doesn't know them before it reads the file. A map from each name to its series collects the points: the first row of a plant makes its series, and every row adds a point to the series of its plant:

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
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        NumberAxis weeks = new NumberAxis("Week", 1, 3, 1);
        NumberAxis height = new NumberAxis();
        height.setLabel("Height (cm)");
        LineChart<Number, Number> chart = new LineChart<>(weeks, height);
        chart.setTitle("School garden");

        Map<String, XYChart.Series<Number, Number>> byPlant = new HashMap<>();
        List<String> lines = Files.readAllLines(Paths.get("garden.csv"));
        for (int i = 1; i < lines.size(); i++) {
            String[] parts = lines.get(i).split(",");
            if (!parts[2].equals("-")) {
                String plant = parts[1];
                XYChart.Series<Number, Number> series = byPlant.get(plant);
                if (series == null) {
                    series = new XYChart.Series<>();
                    series.setName(plant);
                    byPlant.put(plant, series);
                }
                series.getData().add(new XYChart.Data<>(Integer.valueOf(parts[0]), Integer.valueOf(parts[2])));
            }
        }

        List<String> plants = new ArrayList<>(byPlant.keySet());
        Collections.sort(plants);
        for (String plant : plants) {
            chart.getData().add(byPlant.get(plant));
        }

        stage.setScene(new Scene(chart));
        stage.setTitle("Garden");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

- The map's values are series. `byPlant.get(plant)` returns `null` for a plant that has no series yet, and then the program makes one, names it and puts it in the map. Module 33 gave each new key its own list the same way ("A list as a value").
- The series go to the chart in the **sorted** order of their names. A HashMap's order isn't one you choose (module 31), so a program that added them in the map's order would have a legend in an order nobody decided, and the checks compare the series in order. Sorted names give a fixed order: bean, pea, tomato.
- Each series gets its points in the order of the rows, and the file goes week by week, so every series goes from the smallest x up. Keep it that way: the window as text lists the points in the order they were added, and so do the checks. If a file isn't in order, sort the rows first.

---

Source: [Several series from a map](https://javaarena.com/learn/charts/several-series/) in the module [Data visualization](https://javaarena.com/learn/charts/) on Java Arena.

This module follows section [14.1 Data visualization](https://java-programming.mooc.fi/part-14/1-data-visualization) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
