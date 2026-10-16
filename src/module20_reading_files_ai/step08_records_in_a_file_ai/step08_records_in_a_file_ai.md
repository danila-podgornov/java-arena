> [!info] AI-Generated

# Records in a file

Most data files hold **records**: each line describes one thing, with its values separated by a comma. This format is called CSV, short for comma-separated values, and spreadsheet programs can save a sheet in it. Each line is read, split and converted, just as in module 16:

**The file rentals.txt**

```text
Ilona,3
Marek,1
Sofia,5
```

```java
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int total = 0;
        int longest = 0;
        String longestName = "";
        try (Scanner scanner = new Scanner(Paths.get("rentals.txt"))) {
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(",");
                String name = parts[0];
                int hours = Integer.valueOf(parts[1]);
                System.out.println(name + ": " + hours + " h");
                total += hours;
                if (hours > longest) {
                    longest = hours;
                    longestName = name;
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Total: " + total + " h");
        System.out.println("Longest rental: " + longestName);
    }
}
```

**Output**

```text
Ilona: 3 h
Marek: 1 h
Sofia: 5 h
Total: 9 h
Longest rental: Sofia
```

`scanner.nextLine().split(",")` reads a line and splits it at once. The parts are Strings, so the hours need `Integer.valueOf` before they can be added up.

Not every file uses commas. Semicolons are common too, especially where the comma is the decimal separator: then the line is split with `split(";")`. Look at the file before you write the program.

## A header line

A CSV file often starts with a **header**: a first line that names the columns, such as `name,hours`. It isn't data, and `Integer.valueOf("hours")` would fail. Read it before the loop, and don't use it:

```java
try (Scanner scanner = new Scanner(Paths.get("rentals.csv"))) {
    scanner.nextLine(); // skip the header
    while (scanner.hasNextLine()) {
        String[] parts = scanner.nextLine().split(",");
        // ...
    }
}
```

## Lines that don't fit

A line with no comma splits into one part only, and `parts[1]` throws an exception. Inside the `try`, that ends the reading. When a file may have such lines, check `parts.length` first, and skip the line with `continue` if it has too few parts.

---

Source: [Records in a file](https://javaarena.com/learn/reading-files/records-in-a-file/) in the module [Reading files](https://javaarena.com/learn/reading-files/) on Java Arena.

This module follows sections [4.3 Files and reading data](https://java-programming.mooc.fi/part-4/3-files-and-reading-data), [4.4 Summary](https://java-programming.mooc.fi/part-4/4-summary) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
