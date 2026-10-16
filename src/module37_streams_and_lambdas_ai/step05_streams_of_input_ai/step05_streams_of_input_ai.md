> [!info] AI-Generated

# Streams of input

The streams so far start from a list, and input comes one line at a time. So a program that works on input with a stream first reads the lines into a list, with the loop you know from module 13, and then makes a stream of the list.

## Read first, then stream

A weather station sends its temperature readings, in whole degrees, one per line. An empty line ends them:

```java
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> lines = new ArrayList<>();
        while (true) {
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                break;
            }
            lines.add(line);
        }

        long belowZero = lines.stream()
                .mapToInt(Integer::valueOf)
                .filter(degrees -> degrees < 0)
                .count();
        long aboveZero = lines.stream()
                .mapToInt(Integer::valueOf)
                .filter(degrees -> degrees > 0)
                .count();
        System.out.println("Readings: " + lines.size());
        System.out.println("Below zero: " + belowZero);
        System.out.println("Above zero: " + aboveZero);
    }
}
```

**Input**

```text
-3
2
5
-1
0
4
(an empty line)
```

**Output**

```text
Readings: 6
Below zero: 2
Above zero: 3
```

- The loop only reads and stores. It doesn't count or add anything: that's the streams' work.
- `mapToInt(Integer::valueOf)` turns each line into an `int`: `Integer::valueOf` is step 2's method reference for `line -> Integer.valueOf(line)`.
- An IntStream has `filter` too, and `count`, so the filter can come after `mapToInt` and compare plain numbers.

## A list of numbers

When a program asks several questions about the same numbers, it can turn the lines into numbers once, with `map(Integer::valueOf)` and `collect`, and then stream the list of numbers as often as it likes. Before an average, it checks that there's at least one reading, since `getAsDouble()` crashes when there's no value (step 3):

```java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> lines = new ArrayList<>();
        while (true) {
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                break;
            }
            lines.add(line);
        }

        List<Integer> readings = lines.stream()
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        if (readings.isEmpty()) {
            System.out.println("No readings");
        } else {
            double average = readings.stream()
                    .mapToInt(degrees -> degrees)
                    .average()
                    .getAsDouble();
            System.out.println("Average: " + average);
            System.out.println("Frosty: " + readings.stream().filter(degrees -> degrees <= 0).count());
        }
    }
}
```

**Input**

```text
-3
2
5
-1
0
4
(an empty line)
```

**Output**

```text
Average: 1.1666666666666667
Frosty: 3
```

The average is 7 / 6, printed with every digit a double has, as in module 29.

## Lines that aren't numbers

When the station misses a reading, it sends a `-` in its place. `Integer.valueOf("-")` crashes, so a `filter` must drop those lines, and it must come *before* the step that turns lines into numbers. A filter after `mapToInt` comes too late, whatever it keeps, because the crash comes first:

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> lines = new ArrayList<>();
        lines.add("4");
        lines.add("-");
        lines.add("6");
        int sum = lines.stream()
                .mapToInt(Integer::valueOf)
                .filter(degrees -> degrees > 0)
                .sum();
        System.out.println(sum);
    }
}
```

**The program crashes with**

```text
Exception in thread "main" java.lang.NumberFormatException: For input string: "-"
	at Main.main(Main.java:12)
```

Java reports the line where the chain's terminal operation, `sum()`, runs, because that's when the lambdas and method references are called. The dash filter itself can't go after `mapToInt` at all: by then the values are `int`s, which have no `equals`. So filter the dashes out first, `.filter(line -> !line.equals("-"))`, and then turn the rest into numbers: the sum is 10.

---

Source: [Streams of input](https://javaarena.com/learn/streams/from-input/) in the module [Streams and lambdas](https://javaarena.com/learn/streams/) on Java Arena.

This module follows section [10.1 Handling collections as streams](https://java-programming.mooc.fi/part-10/1-handling-collections-as-streams) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
