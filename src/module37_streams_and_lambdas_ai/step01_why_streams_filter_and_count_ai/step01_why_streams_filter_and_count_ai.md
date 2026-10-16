> [!info] AI-Generated

# Why streams: filter and count

Since module 14, you've gone through lists with loops: a for-each loop, an `if` inside it, and a variable that counts or adds up. Java has a second way to do the same work, the **stream**. With a stream, you say *what* should happen to the values, one step after another, and Java does the looping for you.

## One question, two ways

A cycling club keeps the distance of each ride, in kilometers. How many rides were longer than 50 km? Here's the answer with a loop, as you'd write it now:

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> rides = new ArrayList<>();
        rides.add(42);
        rides.add(65);
        rides.add(18);
        rides.add(80);
        rides.add(51);
        rides.add(30);

        int count = 0;
        for (int km : rides) {
            if (km > 50) {
                count++;
            }
        }
        System.out.println("Long rides: " + count);
    }
}
```

**Output**

```text
Long rides: 3
```

And here's the same question with a stream:

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> rides = new ArrayList<>();
        rides.add(42);
        rides.add(65);
        rides.add(18);
        rides.add(80);
        rides.add(51);
        rides.add(30);

        long count = rides.stream()
                .filter(km -> km > 50)
                .count();
        System.out.println("Long rides: " + count);
    }
}
```

**Output**

```text
Long rides: 3
```

- `rides.stream()` makes a **stream** of the list's values, in the list's order. A stream isn't a list: it's a flow of values that passes through the steps you chain after it.
- `.filter(km -> km > 50)` lets through only the values for which the condition is true. `km -> km > 50` reads "take a value, call it `km`, and answer: is `km` greater than 50?" It's a **lambda expression**, and step 2 is all about them.
- `.count()` counts the values that got through, and ends the stream. It returns a `long`, the bigger whole-number type that module 22 mentioned, so the variable is a `long`. It prints just like an `int`.

The chain is one statement, with one semicolon at the very end. It's split into lines before each dot, so that each line holds one step. Java doesn't mind the line breaks: `rides.stream().filter(km -> km > 50).count()` on one line works the same. The lines after the first are indented a little further, which shows that they continue the statement.

## Read it out loud

The loop says *how* to find the answer: make a counter, go through the list, check each value, add one. The stream says *what* the answer is: from the rides, keep those over 50 km, and count them. The counter, the loop and the `if` are still there, but inside Java's code, not yours.

Both versions are right, and both are good Java. This module teaches the stream's tools one at a time, and step 9 comes back to when each way reads better.

## The list stays as it was

`filter` doesn't remove anything from the list. The stream only reads the list's values, and the list is the same afterwards:

```java
ArrayList<Integer> rides = new ArrayList<>();
rides.add(42);
rides.add(65);
rides.add(18);
long shortRides = rides.stream()
        .filter(km -> km < 20)
        .count();
System.out.println(shortRides);
System.out.println(rides);
```

**Output**

```text
1
[42, 65, 18]
```

## Two filters in a row

Each step passes the values it lets through on to the next step. Two filters in a row keep only the values that pass both, just like a condition with `&&`. The rides from 30 to 60 km:

```java
ArrayList<Integer> rides = new ArrayList<>();
rides.add(42);
rides.add(65);
rides.add(18);
rides.add(80);
rides.add(51);
rides.add(30);
long middle = rides.stream()
        .filter(km -> km >= 30)
        .filter(km -> km <= 60)
        .count();
System.out.println(middle);
```

**Output**

```text
3
```

42, 51 and 30 pass both filters. `.filter(km -> km >= 30 && km <= 60)` would give the same count.

---

Source: [Why streams: filter and count](https://javaarena.com/learn/streams/why-streams/) in the module [Streams and lambdas](https://javaarena.com/learn/streams/) on Java Arena.

This module follows section [10.1 Handling collections as streams](https://java-programming.mooc.fi/part-10/1-handling-collections-as-streams) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
