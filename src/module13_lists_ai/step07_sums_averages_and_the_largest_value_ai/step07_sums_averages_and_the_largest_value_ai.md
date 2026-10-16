> [!info] AI-Generated

# Sums, averages and the largest value

A loop over the indexes can combine all the values into one result. For a sum, start from 0 and add each value:

```java
ArrayList<Integer> minutes = new ArrayList<>();
minutes.add(25);
minutes.add(40);
minutes.add(15);
minutes.add(30);

int total = 0;
for (int i = 0; i < minutes.size(); i++) {
    total += minutes.get(i);
}
System.out.println("Total: " + total);
System.out.println("Average: " + (double) total / minutes.size());
```

**Output**

```text
Total: 110
Average: 27.5
```

The average divides the sum by `size()`, and `(double)` keeps the decimals. (On an empty list, that divides by 0, and the average comes out as `NaN`, "not a number". Check the size first when the list may be empty.)

## The largest value

To find the largest value, keep the largest one seen so far in a variable, and compare every value with it. Start with the **first value in the list**, not with 0:

```java
ArrayList<Integer> temperatures = new ArrayList<>();
temperatures.add(-3);
temperatures.add(-8);
temperatures.add(-1);
temperatures.add(-5);

int highest = temperatures.get(0);
for (int i = 1; i < temperatures.size(); i++) {
    if (temperatures.get(i) > highest) {
        highest = temperatures.get(i);
    }
}
System.out.println("Highest: " + highest);
```

**Output**

```text
Highest: -1
```

Starting with 0 would give the wrong answer here: no temperature is above 0, so the program would print `Highest: 0`, a value that isn't even in the list. The first value is always a real candidate. The loop can then start at index 1, since index 0 has been counted already. (`get(0)` needs a list with at least one value in it.)

For the smallest value, turn the comparison around, to `<`. And `highest = Math.max(highest, temperatures.get(i));` does the same as the whole `if`.

## Where the largest value is

Sometimes the place matters more than the value: which day was the warmest? Then keep the **index** of the best value so far, and read the value with `get` when you need it:

```java
ArrayList<Integer> temperatures = new ArrayList<>();
temperatures.add(-3);
temperatures.add(-8);
temperatures.add(-1);
temperatures.add(-5);

int warmest = 0;
for (int i = 1; i < temperatures.size(); i++) {
    if (temperatures.get(i) > temperatures.get(warmest)) {
        warmest = i;
    }
}
System.out.println("Warmest: day " + (warmest + 1) + ", " + temperatures.get(warmest) + " degrees");
```

**Output**

```text
Warmest: day 3, -1 degrees
```

With `>`, a tie keeps the earlier index; with `>=`, the later one would win.

---

Source: [Sums, averages and the largest value](https://javaarena.com/learn/lists/largest-and-smallest/) in the module [Lists](https://javaarena.com/learn/lists/) on Java Arena.

This module follows section [3.2 Lists](https://java-programming.mooc.fi/part-3/2-lists) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
