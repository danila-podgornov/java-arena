> [!info] AI-Generated

# Getting values by index

Every value in a list has an **index**: its position, counting from 0. The first value is at index 0, the second at index 1, and so on. `get(index)` gives back the value at that index:

```java
ArrayList<String> colors = new ArrayList<>();
colors.add("red");
colors.add("green");
colors.add("blue");
System.out.println(colors.get(0));
System.out.println(colors.get(2));
System.out.println(colors.get(1));
```

**Output**

```text
red
blue
green
```

| index | 0 | 1 | 2 |
|---|---|---|---|
| value | red | green | blue |

So the third value is at index 2: the index is always one less than the place as people count it. `get` only reads the value, and the list stays as it was.

The index can be any `int` expression: a variable, as in `colors.get(i)`, or a calculation, as in `colors.get(i + 1)`.

## Using the values

A value from an `ArrayList<Integer>` can be stored in an `int` variable, or used in a calculation like any `int`:

```java
ArrayList<Integer> points = new ArrayList<>();
points.add(8);
points.add(5);
points.add(10);
int first = points.get(0);
int total = points.get(0) + points.get(1) + points.get(2);
System.out.println("First round: " + first);
System.out.println("Total: " + total);
System.out.println("Last two: " + (points.get(1) + points.get(2)));
```

**Output**

```text
First round: 8
Total: 23
Last two: 15
```

Mind the parentheses in the last line. Without them, Java joins `"Last two: "` and 5 into text first, and then adds 10 to that text: `Last two: 510`.

One place where a list value is not like an `int`: `==` between two values that both come straight from the list, as in `points.get(0) == points.get(1)`. That compares the two `Integer` objects, not the numbers, and it can be false even when both hold 1000. To compare two values from the list with each other, store them in `int` variables first and compare those, or use `points.get(0).equals(points.get(1))`. Comparing a list value with an `int` variable or a plain number, as in `points.get(0) == 8`, compares the numbers and works as expected.

---

Source: [Getting values by index](https://javaarena.com/learn/lists/getting-values/) in the module [Lists](https://javaarena.com/learn/lists/) on Java Arena.

This module follows section [3.2 Lists](https://java-programming.mooc.fi/part-3/2-lists) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
