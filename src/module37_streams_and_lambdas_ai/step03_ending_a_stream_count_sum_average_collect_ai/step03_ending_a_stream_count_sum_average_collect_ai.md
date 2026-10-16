> [!info] AI-Generated

# Ending a stream: count, sum, average, collect

A stream chain has two kinds of steps. The steps in the middle, such as `filter`, are **intermediate operations**: each one gives a new stream, so another step can follow it. The last step is a **terminal operation**: it ends the stream with a result, such as the count, or with an action, such as `forEach`'s printing. After a terminal operation, the stream is used up.

This step goes through the terminal operations you'll use most. The data is a household budget: a month's expenses, in whole dollars.

## count

`count()` returns how many values reach it, as a `long`. A `long` doesn't fit into an `int` variable, even when the number is small:

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> expenses = new ArrayList<>();
        expenses.add(54);
        expenses.add(120);
        int count = expenses.stream().filter(amount -> amount > 100).count();
        System.out.println(count);
    }
}
```

**What javac prints**

```text
Main.java:8: error: incompatible types: possible lossy conversion from long to int
        int count = expenses.stream().filter(amount -> amount > 100).count();
                                                                          ^
1 error
```

Make the variable a `long`, as in step 1.

## sum, with mapToInt

A stream made from an `ArrayList<Integer>` holds Integer objects, and such a stream has no `sum` method. `mapToInt` turns it into an **IntStream**, a stream of plain `int` values, which has `sum`:

```java
ArrayList<Integer> expenses = new ArrayList<>();
expenses.add(54);
expenses.add(120);
expenses.add(18);
expenses.add(35);
expenses.add(9);
expenses.add(64);
int total = expenses.stream()
        .mapToInt(amount -> amount)
        .sum();
int small = expenses.stream()
        .filter(amount -> amount < 40)
        .mapToInt(amount -> amount)
        .sum();
System.out.println("Total: " + total);
System.out.println("Under 40: " + small);
```

**Output**

```text
Total: 300
Under 40: 62
```

- `mapToInt(amount -> amount)` gives each Integer back as an `int`: the lambda returns its value as it is, and Java turns the Integer into an `int` by itself, as module 13 described. `mapToInt(Integer::intValue)` says the same with a method reference.
- `sum()` returns an `int`: 54 + 120 + 18 + 35 + 9 + 64 = 300.
- `filter` can come before `mapToInt`, and then only the values that got through are added: 18 + 35 + 9 = 62.

## average, with getAsDouble

An IntStream also has `average()`: the sum divided by the count, as a double. There's a catch: an empty stream has no average, so `average()` doesn't return a plain double. It returns an **OptionalDouble**, a box that may hold a double or be empty. `getAsDouble()` takes the double out:

```java
ArrayList<Integer> expenses = new ArrayList<>();
expenses.add(54);
expenses.add(120);
expenses.add(18);
expenses.add(35);
double average = expenses.stream()
        .mapToInt(amount -> amount)
        .average()
        .getAsDouble();
System.out.println("Average: " + average);
```

**Output**

```text
Average: 56.75
```

227 / 4 is 56.75. When the box is empty, `getAsDouble()` crashes the program, here because no expense is over 500:

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> expenses = new ArrayList<>();
        expenses.add(54);
        expenses.add(120);
        double average = expenses.stream()
                .filter(amount -> amount > 500)
                .mapToInt(amount -> amount)
                .average()
                .getAsDouble();
        System.out.println(average);
    }
}
```

**The program crashes with**

```text
Exception in thread "main" java.util.NoSuchElementException: No value present
	at Main.main(Main.java:12)
```

So before you ask for an average, make sure there's at least one value: check that the list isn't empty, or that the filter's `count()` is above 0.

## collect

`collect(Collectors.toList())` gathers the values that reach it into a new list. `Collectors` lives in `java.util.stream`, so it needs an import, and the new list's type is `List` (module 35):

```java
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> expenses = new ArrayList<>();
        expenses.add(54);
        expenses.add(120);
        expenses.add(18);
        expenses.add(35);
        expenses.add(9);
        expenses.add(64);

        List<Integer> big = expenses.stream()
                .filter(amount -> amount >= 50)
                .collect(Collectors.toList());
        System.out.println(big);
        System.out.println(big.size() + " of " + expenses.size());
    }
}
```

**Output**

```text
[54, 120, 64]
3 of 6
```

The new list keeps the stream's order, and the old list doesn't change. Java 16 added a shorter ending, `.toList()`, whose list can't be changed afterwards; this course uses `collect(Collectors.toList())`, which you'll see in a lot of Java code.

## forEach

You met `forEach` in step 2. It's a terminal operation too: it runs its lambda for each value, and returns nothing.

| Terminal operation | Gives |
| --- | --- |
| `count()` | how many values, as a `long` |
| `sum()` (after `mapToInt`) | their sum, as an `int` |
| `average()` (after `mapToInt`) | an OptionalDouble; `getAsDouble()` takes out the average |
| `collect(Collectors.toList())` | a new `List` of the values |
| `forEach(...)` | nothing: runs the lambda for each value |

---

Source: [Ending a stream: count, sum, average, collect](https://javaarena.com/learn/streams/terminal-operations/) in the module [Streams and lambdas](https://javaarena.com/learn/streams/) on Java Arena.

This module follows section [10.1 Handling collections as streams](https://java-programming.mooc.fi/part-10/1-handling-collections-as-streams) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
