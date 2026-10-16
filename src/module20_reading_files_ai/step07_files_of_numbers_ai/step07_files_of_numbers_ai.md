> [!info] AI-Generated

# Files of numbers

The lines of a file are Strings, just like keyboard input. In a file of numbers, each line is turned into a number with `Integer.valueOf` (or `Double.valueOf` for decimals), and then the usual tools work: a sum, a count, the largest. This file has the millimeters of rain on each day of a week:

**The file rain.txt**

```text
0
12
3
0
25
0
0
```

```java
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int total = 0;
        int dryDays = 0;
        int wettest = 0;
        try (Scanner scanner = new Scanner(Paths.get("rain.txt"))) {
            while (scanner.hasNextLine()) {
                int rain = Integer.valueOf(scanner.nextLine());
                total += rain;
                if (rain == 0) {
                    dryDays++;
                }
                if (rain > wettest) {
                    wettest = rain;
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Total: " + total + " mm");
        System.out.println("Dry days: " + dryDays);
        System.out.println("Wettest day: " + wettest + " mm");
    }
}
```

**Output**

```text
Total: 40 mm
Dry days: 4
Wettest day: 25 mm
```

Starting `wettest` at 0 works because rain is never below zero. For values that can be negative, such as temperatures, start from the first value instead: read the numbers into a list, and start from `numbers.get(0)`.

## Empty lines

Files sometimes have empty lines, for example between groups of values or at the very end. An empty line isn't a number:

**The file steps.txt**

```text
5200

7400
```

```java
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int total = 0;
        try (Scanner scanner = new Scanner(Paths.get("steps.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                total += Integer.valueOf(line);
            }
            System.out.println("Steps: " + total);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
```

**Output**

```text
Error: For input string: ""
```

`Integer.valueOf("")` threw a `NumberFormatException`, and the `catch` block caught it, as it catches any exception in the `try` block. The reading stopped at the empty line. To skip empty lines instead, check each line before turning it into a number, and go on to the next round with `continue`:

```java
String line = scanner.nextLine();
if (line.isEmpty()) {
    continue;
}
total += Integer.valueOf(line);
```

With that check, the program prints `Steps: 12600`.

---

Source: [Files of numbers](https://javaarena.com/learn/reading-files/numbers-from-a-file/) in the module [Reading files](https://javaarena.com/learn/reading-files/) on Java Arena.

This module follows sections [4.3 Files and reading data](https://java-programming.mooc.fi/part-4/3-files-and-reading-data), [4.4 Summary](https://java-programming.mooc.fi/part-4/4-summary) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
