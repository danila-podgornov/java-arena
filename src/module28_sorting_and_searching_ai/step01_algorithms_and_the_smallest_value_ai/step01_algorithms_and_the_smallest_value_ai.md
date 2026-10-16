> [!info] AI-Generated

# Algorithms and the smallest value

An **algorithm** is a precise, step-by-step way to solve a problem: precise enough that a computer can follow it without guessing, and correct for every input of the right kind, not only for the example you tried first. You've written many algorithms already: adding up the numbers of a list, finding the largest value of an array (module 15), counting the words on a line.

This module is about two problems that come up in almost every kind of program. **Sorting** puts values in order: a contact list by name, prices from the cheapest up. **Searching** finds where a value is. Both have several algorithms, and some do far less work than others, so the module also counts how much work each one does.

It starts with a small algorithm that sorting builds on.

## The smallest value, and where it is

Here are a runner's lap times, in seconds. Which lap was the fastest?

```java
public class Main {
    public static void main(String[] args) {
        int[] laps = {74, 71, 69, 73, 70};
        int best = fastestLap(laps);
        System.out.println("Fastest lap: " + laps[best] + " seconds, lap " + (best + 1));
    }

    public static int fastestLap(int[] laps) {
        int fastest = 0;
        for (int i = 1; i < laps.length; i++) {
            if (laps[i] < laps[fastest]) {
                fastest = i;
            }
        }
        return fastest;
    }
}
```

**Output**

```text
Fastest lap: 69 seconds, lap 3
```

- `fastest` is the index of the smallest value found so far. It starts at 0, the first element, and the loop compares every later element with `laps[fastest]`.
- Module 15 kept the value and its index in two variables. One is enough: the index gives the value too, as `laps[fastest]`.
- The method returns the index, not the value. With the index, the caller can get the value (`laps[best]`), but with only the value, it couldn't tell where it was.
- With `<`, a later lap that's only as fast doesn't take the place of the earlier one, so on a tie the first one wins.

## From a given index on

Sometimes only part of the array counts. Say the first three laps were a warm-up: which lap was the fastest from index 3 on? The method takes the index to start from, and both the fastest so far and the loop start there:

```java
public class Main {
    public static void main(String[] args) {
        int[] laps = {74, 71, 69, 73, 70};
        System.out.println(fastestFrom(laps, 0));
        System.out.println(fastestFrom(laps, 3));
        System.out.println(fastestFrom(laps, 4));
    }

    public static int fastestFrom(int[] laps, int start) {
        int fastest = start;
        for (int i = start + 1; i < laps.length; i++) {
            if (laps[i] < laps[fastest]) {
                fastest = i;
            }
        }
        return fastest;
    }
}
```

**Output**

```text
2
4
4
```

- From index 3 on, the laps are 73 and 70. The smaller one is at index 4, and that's what the method returns: the index still counts from the start of the array, not from `start`.
- From index 4, the last one, only one lap is left, so it's the fastest. The loop doesn't run at all.
- `fastestFrom(laps, 0)` does the same work as `fastestLap(laps)`.

Keep this method in mind: in step 3, a sorting algorithm calls it once for each index of the array.

---

Source: [Algorithms and the smallest value](https://javaarena.com/learn/sorting-searching/smallest-value/) in the module [Sorting and searching](https://javaarena.com/learn/sorting-searching/) on Java Arena.

This module follows section [7.2 Algorithms](https://java-programming.mooc.fi/part-7/2-algorithms) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
