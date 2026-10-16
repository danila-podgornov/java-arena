> [!info] AI-Generated

# Selection sort in code

Step 2 wrote the rounds of selection sort out by hand, one line per round. A loop does the same for an array of any length: the round's index goes up from 0, and each round finds the smallest value from that index on, and swaps it there.

```java
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] heights = {152, 140, 171, 131, 160};
        selectionSort(heights);
        System.out.println(Arrays.toString(heights));
    }

    public static void selectionSort(int[] values) {
        for (int i = 0; i < values.length - 1; i++) {
            int lowest = positionOfLowest(values, i);
            switchPlaces(values, i, lowest);
        }
    }

    public static int positionOfLowest(int[] values, int start) {
        int lowest = start;
        for (int i = start + 1; i < values.length; i++) {
            if (values[i] < values[lowest]) {
                lowest = i;
            }
        }
        return lowest;
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
[131, 140, 152, 160, 171]
```

- The loop variable `i` is the index that the round fills. Everything before it is already sorted, and holds the smallest values of the array.
- The loop stops before `values.length - 1`, so five values take four rounds: the last value is in place once all the others are.
- `selectionSort` returns nothing. It sorts the array it's given, in place, and `main` sees the change because both refer to the same array.
- Short methods with one job each keep the algorithm easy to read: `selectionSort` reads almost like the description in step 2.

## All in one method

Selection sort is often written as one method, with the search for the smallest value as a loop inside the loop of the rounds. The inner loop needs a variable of its own, usually `j`:

```java
public static void selectionSort(int[] values) {
    for (int i = 0; i < values.length - 1; i++) {
        int lowest = i;
        for (int j = i + 1; j < values.length; j++) {
            if (values[j] < values[lowest]) {
                lowest = j;
            }
        }
        int temp = values[i];
        values[i] = values[lowest];
        values[lowest] = temp;
    }
}
```

It does the same work, line by line: the inner loop is `positionOfLowest` with `i` as its start, and the last three lines are the swap.

## How much work is it?

Count the comparisons `values[j] < values[lowest]`. With 5 values, the first round compares each of the other 4 values with the smallest so far, the next round makes 3 comparisons, then 2, then 1: 10 in all. With `n` values, it's `(n - 1) + (n - 2) + ... + 1` comparisons, which adds up to `n * (n - 1) / 2`:

| Values | Comparisons |
| --- | --- |
| 5 | 10 |
| 1,000 | 499,500 |
| 2,000 | 1,999,000 |
| 1,000,000 | 499,999,500,000 |

Twice as many values take about four times as many comparisons. And the order the values start in doesn't help: even an array that's already sorted gets every comparison. Selection sort is fine for a few thousand values, but slow for millions. Much faster sorting algorithms exist, and Java has them ready for you (next step).

---

Source: [Selection sort in code](https://javaarena.com/learn/sorting-searching/selection-sort/) in the module [Sorting and searching](https://javaarena.com/learn/sorting-searching/) on Java Arena.

This module follows section [7.2 Algorithms](https://java-programming.mooc.fi/part-7/2-algorithms) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
