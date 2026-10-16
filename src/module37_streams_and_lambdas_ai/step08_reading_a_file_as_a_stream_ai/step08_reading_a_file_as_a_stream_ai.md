> [!info] AI-Generated

# Reading a file as a stream

Module 20 read files line by line, with a Scanner and a `while` loop. `Files.lines(Paths.get("expenses.csv"))` gives a file's lines as a stream of Strings instead, ready for `filter`, `map` and the rest. `Files` is in `java.nio.file`, next to `Paths`, so it needs an import of its own.

## The lines of a file

The household budget is now in a file. Each line has a category and an amount in whole dollars, separated by a comma:

**The file expenses.csv**

```text
groceries,54
rent,850
bus pass,40
groceries,38
phone,25
```

```java
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        try {
            Files.lines(Paths.get("expenses.csv"))
                    .filter(line -> line.startsWith("groceries"))
                    .forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
```

**Output**

```text
groceries,54
groceries,38
```

- The stream's values are the file's lines, in the file's order, without their line breaks.
- Reading a file can fail, for example when there's no such file. As with the Scanner in module 20, the reading goes in a `try` block, and the `catch` block says what went wrong. For a missing file, the message is the file's name, so the program would print `Error: expenses.csv`.

Java insists on that `try`. Without it, the program doesn't compile:

```java
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Files.lines(Paths.get("expenses.csv")).forEach(System.out::println);
    }
}
```

**What javac prints**

```text
Main.java:6: error: unreported exception IOException; must be caught or declared to be thrown
        Files.lines(Paths.get("expenses.csv")).forEach(System.out::println);
                   ^
1 error
```

It's module 20's message about the Scanner, for the same reason.

## Parts of each line

Module 20 split each line with `split(",")`. In a stream, that's a `map` from a line to its array of parts, and then the parts can be used:

**The file expenses.csv**

```text
groceries,54
rent,850
bus pass,40
groceries,38
phone,25
```

```java
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        try {
            int total = Files.lines(Paths.get("expenses.csv"))
                    .map(line -> line.split(","))
                    .mapToInt(parts -> Integer.valueOf(parts[1]))
                    .sum();
            System.out.println("Total: " + total);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
```

**Output**

```text
Total: 1007
```

After `map(line -> line.split(","))`, each value in the stream is an array of two Strings, so the next lambda's `parts` is an array: `parts[0]` is the category and `parts[1]` the amount. `total` is created inside the `try` block, so it's printed there too.

## Lines into objects

A `map` whose lambda calls a constructor turns each line into an object, and `collect` gathers them into a list. A method that reads the file this way can return the list, and the rest of the program works on objects:

**The file expenses.csv**

```text
groceries,54
rent,850
bus pass,40
```

**Main.java**

```java
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Expense> expenses = readExpenses("expenses.csv");
        System.out.println(expenses);
        List<Expense> missing = readExpenses("august.csv");
        System.out.println(missing.size());
    }

    public static List<Expense> readExpenses(String file) {
        List<Expense> expenses = new ArrayList<>();
        try {
            expenses = Files.lines(Paths.get(file))
                    .map(line -> line.split(","))
                    .map(parts -> new Expense(parts[0], Integer.valueOf(parts[1])))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return expenses;
    }
}
```

**Expense.java**

```java
public class Expense {
    private String category;
    private int amount;

    public Expense(String category, int amount) {
        this.category = category;
        this.amount = amount;
    }

    public String getCategory() {
        return this.category;
    }

    public int getAmount() {
        return this.amount;
    }

    @Override
    public String toString() {
        return this.category + " " + this.amount;
    }
}
```

**Output**

```text
[groceries 54, rent 850, bus pass 40]
Error: august.csv
0
```

- `new Expense(parts[0], Integer.valueOf(parts[1]))` is the lambda's result, so the stream after that `map` is a stream of Expense objects.
- The method starts with an empty list. If the file can be read, the collected list takes its place; if not, the `catch` block prints the error, and the method returns the empty list, so the rest of the program still has a list to work on.

A stream from `Files.lines` keeps the file open even after its terminal operation: `forEach`, `sum` or `collect` uses the stream up, but doesn't close the file. Module 20's `try` with parentheses closes what it opens at the end of the `try` block, and it works here too, written with the stream's type: `try (Stream<String> lines = Files.lines(Paths.get(file))) { ... }`, with `import java.util.stream.Stream;`. Short programs, like the ones in this module, often leave that out: every file is closed when the program ends.

---

Source: [Reading a file as a stream](https://javaarena.com/learn/streams/files/) in the module [Streams and lambdas](https://javaarena.com/learn/streams/) on Java Arena.

This module follows section [10.1 Handling collections as streams](https://java-programming.mooc.fi/part-10/1-handling-collections-as-streams) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
