> [!info] AI-Generated

# reduce, and IntStream

Every terminal operation so far has had one fixed job: count, add up, collect. `reduce` is the general one: it combines all the values into one, in whatever way its lambda says.

## reduce

`reduce` takes two things: a starting value, and a lambda with two parameters, the result so far and the next value. The lambda returns the new result so far. The club's total distance, with `reduce`:

```java
ArrayList<Integer> rides = new ArrayList<>();
rides.add(42);
rides.add(65);
rides.add(18);
int total = rides.stream()
        .reduce(0, (sum, km) -> sum + km);
System.out.println(total);
```

**Output**

```text
125
```

The result starts as 0. Then the lambda runs once for each value: 0 + 42 is 42, 42 + 65 is 107, and 107 + 18 is 125. When the stream is empty, the lambda never runs, and `reduce` returns the starting value.

`mapToInt(km -> km).sum()` gives the same total, and reads more easily. After `mapToInt`, an IntStream also has `max()`, but like `average()` it returns a box that may be empty (an OptionalInt, whose `getAsInt()` takes the `int` out). `reduce` can find the longest ride as a plain `int`, with 0 for an empty list: start at 0, and keep, at each value, the bigger of the result so far and the value:

```java
ArrayList<Integer> rides = new ArrayList<>();
rides.add(42);
rides.add(65);
rides.add(18);
int longest = rides.stream()
        .reduce(0, (longestSoFar, km) -> Math.max(longestSoFar, km));
System.out.println(longest);
```

**Output**

```text
65
```

The starting value takes part in the result, so pick one that changes nothing: 0 for a sum, `""` for text. For the longest ride, 0 changes nothing only because no ride is shorter than 0 km. It's the same thought as the "best so far" of module 29: for the lowest temperature, 0 would be a bad start, since every reading could be above it.

`reduce` works on Strings too. The first letters of the riders' names, joined together:

```java
ArrayList<String> riders = new ArrayList<>();
riders.add("Noor");
riders.add("Pablo");
riders.add("Kaia");
String initials = riders.stream()
        .map(name -> name.substring(0, 1))
        .reduce("", (text, letter) -> text + letter);
System.out.println(initials);
```

**Output**

```text
NPK
```

`map` first turns each name into its first letter, and `reduce` only joins the letters. That's how Java's documentation asks for `reduce` to be used: a start that changes nothing, and a lambda that only combines two values, so that the result doesn't depend on how the values are grouped. Any work on each value belongs in a `map` before `reduce`.

In this form, `reduce` gives a result of the same type as the stream's values: an Integer for a stream of Integers, a String for a stream of Strings. For a stream of objects, `map` them to the value you want to combine first.

## IntStream: numbers without a list

Step 3's IntStream, the stream of `int` values, can also be made from nothing but a range of numbers. `IntStream.range(1, 5)` is the numbers 1, 2, 3 and 4: the end isn't included, just like in `for (int i = 1; i < 5; i++)` and in `substring`'s end index. `IntStream.rangeClosed(1, 5)` includes the end, 5. IntStream lives in `java.util.stream`:

```java
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        IntStream.range(1, 5)
                .forEach(seat -> System.out.println("Seat " + seat));
        System.out.println(IntStream.rangeClosed(1, 10).sum());
        long evenSeats = IntStream.rangeClosed(1, 20)
                .filter(seat -> seat % 2 == 0)
                .count();
        System.out.println(evenSeats);
    }
}
```

**Output**

```text
Seat 1
Seat 2
Seat 3
Seat 4
55
10
```

- A cinema's row with seats 1 to 4 comes from `range(1, 5)`.
- `rangeClosed(1, 10).sum()` adds up 1 to 10.
- An IntStream has the intermediate operations you know, such as `filter`, and its values are plain `int` values.

A range can go through a list's indexes, `range(0, list.size())`, when the position matters, as in a numbered list:

```java
import java.util.ArrayList;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> films = new ArrayList<>();
        films.add("Vertigo");
        films.add("Alien");
        films.add("Heat");
        IntStream.range(0, films.size())
                .forEach(i -> System.out.println((i + 1) + ". " + films.get(i)));
    }
}
```

**Output**

```text
1. Vertigo
2. Alien
3. Heat
```

The lambda uses `films` from outside, which is fine: it only reads the list, and `films` is never given another list.

---

Source: [reduce, and IntStream](https://javaarena.com/learn/streams/reduce-and-intstream/) in the module [Streams and lambdas](https://javaarena.com/learn/streams/) on Java Arena.

This module follows section [10.1 Handling collections as streams](https://java-programming.mooc.fi/part-10/1-handling-collections-as-streams) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
