> [!info] AI-Generated

# Swapping, and sorting by hand

Sorting moves values around in an array, and its basic move is the **swap**: two elements trade places. It takes a little care. This tries to swap the first two heights the obvious way:

```java
int[] heights = {152, 140, 171};
heights[0] = heights[1];
heights[1] = heights[0];
System.out.println(Arrays.toString(heights));
```

**Output**

```text
[140, 140, 171]
```

The first line copies 140 over 152, so 152 is gone before the second line can use it. `heights[1] = heights[0]` then copies 140 back to where it already was. It's like swapping the drinks in two full glasses: you need a third, empty glass to hold one drink while you pour the other.

In code, the third glass is a variable:

```java
int[] heights = {152, 140, 171};
int temp = heights[0];
heights[0] = heights[1];
heights[1] = temp;
System.out.println(Arrays.toString(heights));
```

**Output**

```text
[140, 152, 171]
```

`temp` keeps a copy of 152 while 140 moves to index 0, and then 152 goes to index 1. (`Arrays.toString` gives an array's values in square brackets, as in module 15.)

As a method, a swap takes the array and the two indexes. A method that gets an array can change the caller's array (module 15), so the swap shows in `main`:

```java
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] heights = {152, 140, 171, 131};
        switchPlaces(heights, 0, 3);
        System.out.println(Arrays.toString(heights));
    }

    public static void switchPlaces(int[] values, int a, int b) {
        int temp = values[a];
        values[a] = values[b];
        values[b] = temp;
    }
}
```

**Output**

```text
[131, 140, 171, 152]
```

## Sorting a line of people by hand

Picture a class lining up for a photo, shortest first. One simple way to do it: find the shortest person, and have them swap places with whoever stands first. Then find the shortest of the rest, and swap them with whoever stands second. Keep going until you reach the end of the line. This is **selection sort**: each round *selects* the smallest of the values that aren't in place yet.

Here it is on five heights, in centimeters. Each round finds the smallest value from the round's index on, and swaps it to that index:

| Round | Smallest from the index on | Swap | The array after the round |
| --- | --- | --- | --- |
| start | | | `[152, 140, 171, 131, 160]` |
| index 0 | 131, at index 3 | 0 and 3 | `[131, 140, 171, 152, 160]` |
| index 1 | 140, at index 1 | 1 and 1 | `[131, 140, 171, 152, 160]` |
| index 2 | 152, at index 3 | 2 and 3 | `[131, 140, 152, 171, 160]` |
| index 3 | 160, at index 4 | 3 and 4 | `[131, 140, 152, 160, 171]` |

- After each round, one more value is in its final place, and the front part of the array is sorted.
- In the round of index 1, 140 is already where it belongs. Swapping an element with itself changes nothing, so this round needs no special case.
- Five values take four rounds. Once all the others are in place, the last one, 171, has nowhere else to go.

Each round is two things you've already seen: step 1's search for the smallest value from an index on, and a swap. The program of this task writes the rounds out by hand. Its `positionOfLowest(values, start)` is step 1's `fastestFrom` with names that fit any numbers: it returns the index of the smallest value from `start` on.

---

Source: [Swapping, and sorting by hand](https://javaarena.com/learn/sorting-searching/swapping/) in the module [Sorting and searching](https://javaarena.com/learn/sorting-searching/) on Java Arena.

This module follows section [7.2 Algorithms](https://java-programming.mooc.fi/part-7/2-algorithms) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
