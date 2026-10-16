> [!info] AI-Generated

# Divide and conquer: merge sort

Binary search splits a problem in half and solves one half. Many algorithms split a problem into parts, solve each part the same way, and combine the answers: that's called **divide and conquer**. Merge sort is the classic example. It sorts an array like this:

1. An array of 0 or 1 values is already sorted (the base case).
2. Otherwise, split it into two halves, and sort each half, with merge sort (the recursive calls).
3. Merge the two sorted halves into one sorted array.

## Merging two sorted arrays

The work is in step 3. Two sorted arrays merge like two sorted piles of exam papers: the paper that goes next is always the smaller of the two on top of the piles. Take it, and look again. When one pile is empty, the rest of the other pile follows as it is.

```java
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] morning = {3, 8, 9, 15};
        int[] evening = {1, 8, 12};
        System.out.println(Arrays.toString(merge(morning, evening)));
    }

    public static int[] merge(int[] first, int[] second) {
        int[] merged = new int[first.length + second.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < first.length && j < second.length) {
            if (first[i] <= second[j]) {
                merged[k] = first[i];
                i++;
            } else {
                merged[k] = second[j];
                j++;
            }
            k++;
        }
        while (i < first.length) {
            merged[k] = first[i];
            i++;
            k++;
        }
        while (j < second.length) {
            merged[k] = second[j];
            j++;
            k++;
        }
        return merged;
    }
}
```

**Output**

```text
[1, 3, 8, 8, 9, 12, 15]
```

`i` is the place in `first`, `j` the place in `second`, and `k` the place in `merged`. Each round of the first loop copies one value, so merging takes one round per value: merging is quick. Merging doesn't need recursion; the loops are the simplest way to write it.

## The recursive sort

`Arrays.copyOfRange(values, from, to)` makes a new array of the values from index `from` up to (not including) `to`. With it, the sort is a few lines:

```java
public static int[] mergeSort(int[] values) {
    if (values.length <= 1) {
        return values;
    }
    int middle = values.length / 2;
    int[] left = mergeSort(Arrays.copyOfRange(values, 0, middle));
    int[] right = mergeSort(Arrays.copyOfRange(values, middle, values.length));
    return merge(left, right);
}
```

The halves are sorted by the same method, which splits them again, until the parts have one value each. Then the merges put them together again, in order. Sorting `{5, 2, 7, 1}` goes like this:

```text
mergeSort [5, 2, 7, 1]
    mergeSort [5, 2]
        mergeSort [5]  returns [5]
        mergeSort [2]  returns [2]
        merge          returns [2, 5]
    mergeSort [7, 1]
        mergeSort [7]  returns [7]
        mergeSort [1]  returns [1]
        merge          returns [1, 7]
    merge              returns [1, 2, 5, 7]
```

## How much work it does

Halving an array of 1,000 values again and again gets down to single values after 10 levels, since 2 to the 10th is 1,024. At each level, the merges together copy every value once. So merge sort does about 1,000 times 10 steps, where selection sort (module 28) compares about 1,000 times 1,000 divided by 2, close to half a million times. This program counts the comparisons that `merge` makes while sorting 1,000 numbers that start in reverse order, and the comparisons selection sort makes on any 1,000 values:

```java
import java.util.Arrays;

public class Main {
    private static int comparisons = 0;

    public static void main(String[] args) {
        int[] values = new int[1000];
        for (int i = 0; i < values.length; i++) {
            values[i] = 1000 - i;
        }
        int[] sorted = mergeSort(values);
        System.out.println(sorted[0] + " " + sorted[999]);
        System.out.println("Merge sort: " + comparisons + " comparisons");
        System.out.println("Selection sort: " + (1000 * 999 / 2) + " comparisons");
    }

    public static int[] mergeSort(int[] values) {
        if (values.length <= 1) {
            return values;
        }
        int middle = values.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(values, 0, middle));
        int[] right = mergeSort(Arrays.copyOfRange(values, middle, values.length));
        return merge(left, right);
    }

    public static int[] merge(int[] first, int[] second) {
        int[] merged = new int[first.length + second.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < first.length && j < second.length) {
            comparisons++;
            if (first[i] <= second[j]) {
                merged[k] = first[i];
                i++;
            } else {
                merged[k] = second[j];
                j++;
            }
            k++;
        }
        while (i < first.length) {
            merged[k] = first[i];
            i++;
            k++;
        }
        while (j < second.length) {
            merged[k] = second[j];
            j++;
            k++;
        }
        return merged;
    }
}
```

**Output**

```text
1 1000
Merge sort: 5044 comparisons
Selection sort: 499500 comparisons
```

`comparisons` is declared in the class, outside the methods, with `static`: a static variable belongs to the class itself, not to one call, so every call of `merge` adds to the same counter (a variable declared inside `merge` would start again at 0 in each call).

The difference grows with the size: for a million values, merge sort compares about 20 million times and selection sort about 500 billion times. Merge sort needs extra arrays for the halves, which selection sort doesn't.

## Stable sorting

`merge` takes from `first` when the two values are equal (`<=`, not `<`). So values that compare as equal keep the order they had: a sort that does this is **stable**. It matters when you sort objects by one property, such as words by their length: words of the same length stay in the order they were in. Java's `Collections.sort` is a merge sort too (a refined one), and its documentation promises that it is stable.

---

Source: [Divide and conquer: merge sort](https://javaarena.com/learn/recursion/merge-sort/) in the module [Recursion](https://javaarena.com/learn/recursion/) on Java Arena.

An extra module, not part of the University of Helsinki's course. Lesson text: [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/).
