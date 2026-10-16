> [!info] AI-Generated

# Steps in the middle: map, sorted, distinct, limit, skip

`filter` is one intermediate operation. There are more, and each of them takes a stream and gives a new stream, so you can chain as many as you need before the terminal operation. This step's data comes from a cinema: the films it shows today, and the tickets sold for each screening.

## map

`map` turns each value into another one: the lambda's result goes on down the stream in place of the value. A ticket costs 12 dollars, so each screening's takings are its tickets times 12:

```java
ArrayList<Integer> tickets = new ArrayList<>();
tickets.add(85);
tickets.add(140);
tickets.add(32);
tickets.add(120);
tickets.stream()
        .map(sold -> sold * 12)
        .forEach(System.out::println);
```

**Output**

```text
1020
1680
384
1440
```

The new value can be of another type. Here Strings become other Strings, and then numbers:

```java
ArrayList<String> films = new ArrayList<>();
films.add("Vertigo");
films.add("Alien");
films.add("Casablanca");
films.stream()
        .map(String::toUpperCase)
        .forEach(System.out::println);
films.stream()
        .map(film -> film.length())
        .forEach(System.out::println);
```

**Output**

```text
VERTIGO
ALIEN
CASABLANCA
7
5
10
```

Step 3's `mapToInt` is a `map` whose results are `int` values: its stream is an IntStream, with `sum` and `average`. A plain `map` gives a stream of objects, such as Integers or Strings, which has neither.

## sorted and distinct

`sorted()` passes the values on in increasing order: numbers from the smallest, Strings in alphabetical order, as `Collections.sort` sorts them (module 28). `distinct()` lets each value through only once, the first time it arrives, and drops the copies that come later. It compares values with `equals` and `hashCode` (module 32), so it works for Strings and numbers.

```java
ArrayList<Integer> tickets = new ArrayList<>();
tickets.add(85);
tickets.add(140);
tickets.add(32);
tickets.add(120);
tickets.stream()
        .sorted()
        .forEach(System.out::println);
ArrayList<String> films = new ArrayList<>();
films.add("Heat");
films.add("Alien");
films.add("Heat");
films.add("Up");
films.add("Alien");
films.stream()
        .distinct()
        .forEach(System.out::println);
System.out.println(films);
```

**Output**

```text
32
85
120
140
Heat
Alien
Up
[Heat, Alien, Heat, Up, Alien]
```

As always, the list itself keeps its order and its copies: only the stream's values are sorted or dropped.

## limit and skip

`limit(n)` lets through the first `n` values and drops the rest. `skip(n)` drops the first `n` values and lets the rest through. The screenings are in the order of the day, so `limit(2)` gives the first two, and `skip(4)` the ones after the fourth:

```java
ArrayList<Integer> tickets = new ArrayList<>();
tickets.add(85);
tickets.add(140);
tickets.add(32);
tickets.add(120);
tickets.add(64);
tickets.add(150);
tickets.stream()
        .limit(2)
        .forEach(System.out::println);
System.out.println("--");
tickets.stream()
        .skip(4)
        .forEach(System.out::println);
```

**Output**

```text
85
140
--
64
150
```

A `limit` bigger than the number of values is fine: all of them get through. A `skip` bigger than that leaves nothing.

## The order of the steps matters

Each step works on what the step before it let through. `sorted()` then `limit(3)` gives the three smallest values; `limit(3)` then `sorted()` gives the first three values, sorted:

```java
ArrayList<Integer> tickets = new ArrayList<>();
tickets.add(85);
tickets.add(140);
tickets.add(32);
tickets.add(120);
tickets.add(64);
tickets.stream()
        .sorted()
        .limit(3)
        .forEach(System.out::println);
System.out.println("--");
tickets.stream()
        .limit(3)
        .sorted()
        .forEach(System.out::println);
```

**Output**

```text
32
64
85
--
32
85
140
```

So read a chain from the top, one step at a time, and ask what each step gets from the one before.

## Nothing happens without a terminal operation

The intermediate steps only describe what to do. The work starts when a terminal operation asks for the values. This `filter` has a lambda that prints, but the stream has no terminal operation, so the lambda never runs:

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> tickets = new ArrayList<>();
        tickets.add(85);
        tickets.add(140);
        tickets.add(32);
        tickets.stream().filter(sold -> {
            System.out.println("Checking " + sold);
            return sold > 100;
        });
        System.out.println("Done");
    }
}
```

**Output**

```text
Done
```

Add `.count()` after the `)` that closes `filter(...)`, and the lambda runs once for each value. If a stream seems to do nothing, check that it ends with a terminal operation.

---

Source: [Steps in the middle: map, sorted, distinct, limit, skip](https://javaarena.com/learn/streams/intermediate-operations/) in the module [Streams and lambdas](https://javaarena.com/learn/streams/) on Java Arena.

This module follows section [10.1 Handling collections as streams](https://java-programming.mooc.fi/part-10/1-handling-collections-as-streams) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
