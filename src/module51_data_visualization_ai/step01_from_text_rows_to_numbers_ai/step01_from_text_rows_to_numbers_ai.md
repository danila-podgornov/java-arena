> [!info] AI-Generated

# From text rows to numbers

Part 14 starts with **data visualization**: showing numbers as a picture. A table of 50 numbers is hard to read, while a line that climbs and then falls tells its story at a glance. JavaFX, the library of part 13, has classes for charts, and this module uses them: line charts, bar charts and charts that change when the user moves a slider.

## Charts in Java Arena

As with the windows of part 13 (module 48 explained it), Java Arena's JavaFX is a practice version written for this site, and the page draws each chart from what your program told JavaFX to show: the kind of chart, its title, its axes and every data point. The drawing is approximate, as the windows were: real JavaFX picks its own colors, fonts and tick marks. Under each chart, "The window as text" lists every data point, and that's what the checks compare. The check that runs every model solution on the real JavaFX (module 48) covers charts too: it confirms that real JavaFX gets the same kind of chart, title, legend, axes and points, and the same slider values. It doesn't check how the chart is drawn. (Module 52 draws on a canvas and works with images, which are read and written pixel by pixel exactly; it also explains why sound can't play on this page.)

A chart needs numbers, and numbers usually come from a file. So this first step reads files of data, and step 2 draws the first chart. The numbers in this module's files are made up for the exercises: they look like measurements, but nobody measured them.

## Rows and columns

A weather station on a hill measures the rain each month. Its file, `rain.csv`:

**The file rain.csv**

```text
month,mm
1,52
2,41
3,-
4,38
5,45
6,60
```

This is a **CSV** file (comma-separated values): one **row** per line, and the values of a row separated by commas, so that they form **columns**. The first line is a **header**: it names the columns, and it isn't data. The `-` in March means that there's no measurement for that month (the rain gauge was broken). Files of data often mark a missing value like that, so a program must expect it.

The program reads the lines (module 48 used `Files.readAllLines` too), skips the header, and splits each row into its values with `split`:

```java
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        List<String> lines = Files.readAllLines(Paths.get("rain.csv"));
        int total = 0;
        int months = 0;
        for (int i = 1; i < lines.size(); i++) {
            String[] parts = lines.get(i).split(",");
            if (parts[1].equals("-")) {
                System.out.println("Month " + parts[0] + ": no measurement");
            } else {
                total += Integer.valueOf(parts[1]);
                months++;
            }
        }
        System.out.println("Months measured: " + months);
        System.out.println("Rain in them: " + total + " mm");
    }
}
```

**Output**

```text
Month 3: no measurement
Months measured: 5
Rain in them: 236 mm
```

- The loop starts at index 1, so the header line is left out. `Integer.valueOf("mm")` would throw a NumberFormatException.
- `"4,38".split(",")` gives the array `["4", "38"]`: text, still. `Integer.valueOf(parts[1])` turns the text into a number. A value with a decimal point, such as `12.5`, needs `Double.valueOf`.
- The check for `-` comes **before** `Integer.valueOf`, since `Integer.valueOf("-")` throws too. A missing value is skipped: it isn't counted as 0, which would be a measurement of no rain at all, and so a lie.

Two more things that files of data do:

- **Tabs.** A **tab-separated** file (often named `.tsv`) has a tab between its values instead of a comma: `split("\t")`. Tabs are handy when the values themselves may contain commas, such as `Smith, Ann`.
- **Empty values at the end.** `split` drops empty values at the end of a row: `"5,".split(",")` gives only `["5"]`, an array of length 1, and `parts[1]` throws an ArrayIndexOutOfBoundsException. That's one reason why files mark a missing value with a `-` rather than with nothing.

## Keeping the numbers

A sum is fine for a report, but a chart needs every value, and which month it belongs to. A **map** from the month to the rain keeps both, and a month without a measurement simply isn't in it. Put the reading in a class of its own, and the rest of the program asks it for the map. The same file again:

**The file rain.csv**

```text
month,mm
1,52
2,41
3,-
4,38
5,45
6,60
```

**Main.java**

```java
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        Map<Integer, Integer> rain = RainFile.read("rain.csv");
        System.out.println(rain.size() + " months");
        System.out.println("April: " + rain.get(4) + " mm");
        System.out.println("March measured: " + rain.containsKey(3));
    }
}
```

**RainFile.java**

```java
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RainFile {

    public static Map<Integer, Integer> read(String fileName) throws IOException {
        Map<Integer, Integer> rain = new HashMap<>();
        List<String> lines = Files.readAllLines(Paths.get(fileName));
        for (int i = 1; i < lines.size(); i++) {
            String[] parts = lines.get(i).split(",");
            if (!parts[1].equals("-")) {
                rain.put(Integer.valueOf(parts[0]), Integer.valueOf(parts[1]));
            }
        }
        return rain;
    }
}
```

**Output**

```text
5 months
April: 38 mm
March measured: false
```

`read` declares `throws IOException` (module 42), since `Files.readAllLines` can throw it, and leaves it to the caller. When the values are only a sequence, such as the cups of coffee on each day of a week in order, a **list** is enough: the position in the list says where each value belongs.

---

Source: [From text rows to numbers](https://javaarena.com/learn/charts/rows-to-numbers/) in the module [Data visualization](https://javaarena.com/learn/charts/) on Java Arena.

This module follows section [14.1 Data visualization](https://java-programming.mooc.fi/part-14/1-data-visualization) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
