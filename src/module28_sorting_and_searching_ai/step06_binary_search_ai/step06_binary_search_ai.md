> [!info] AI-Generated

# Binary search

Think of a guessing game: someone picks a number from 1 to 100, and after each guess tells you "higher" or "lower". Guessing 1, 2, 3 and so on is a linear search, and could take 100 guesses. A smarter first guess is 50: whatever the answer, half of the numbers are ruled out. Then guess the middle of the half that's left, and so on. Every guess halves what's left, and 7 guesses are always enough.

**Binary search** plays this game with a sorted array. It looks at the middle element of the range where the value could still be:

- If it's the wanted value, the search is done.
- If it's smaller than the wanted value, the wanted value can only be to its right, since the array is sorted. The range becomes the right half.
- If it's larger, the range becomes the left half.

It repeats this until it finds the value, or until the range is empty, which means the value isn't there.

## In code

Two variables, `low` and `high`, are the first and the last index of the range. At first, the range is the whole array. Here a race keeps the bib numbers of the runners who finished, sorted:

```java
public class Main {
    public static void main(String[] args) {
        int[] finishers = {3, 8, 12, 15, 21, 27, 30, 34, 41};
        System.out.println(findInSorted(finishers, 27));
        System.out.println(findInSorted(finishers, 13));
    }

    public static int findInSorted(int[] sorted, int wanted) {
        int low = 0;
        int high = sorted.length - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (sorted[middle] == wanted) {
                return middle;
            }
            if (sorted[middle] < wanted) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return -1;
    }
}
```

**Output**

```text
5
-1
```

The search for 27, round by round:

| `low` | `high` | `middle` | `sorted[middle]` | Then |
| --- | --- | --- | --- | --- |
| 0 | 8 | 4 | 21 | smaller than 27: `low = 5` |
| 5 | 8 | 6 | 30 | larger than 27: `high = 5` |
| 5 | 5 | 5 | 27 | found: return 5 |

And for 13, which isn't there:

| `low` | `high` | `middle` | `sorted[middle]` | Then |
| --- | --- | --- | --- | --- |
| 0 | 8 | 4 | 21 | larger than 13: `high = 3` |
| 0 | 3 | 1 | 8 | smaller than 13: `low = 2` |
| 2 | 3 | 2 | 12 | smaller than 13: `low = 3` |
| 3 | 3 | 3 | 15 | larger than 13: `high = 2` |

Now `low` is 3 and `high` is 2: the range is empty, the loop ends, and the method returns -1.

- `(low + high) / 2` is integer division, so the middle is always a whole index. When the range has an even number of elements, it's the left one of the two in the middle.
- The middle element has been checked, so the new range leaves it out: `middle + 1` and `middle - 1`. With `low = middle`, the range could stop shrinking, and the loop would never end.
- The loop runs `while (low <= high)`: when `low` equals `high`, the range still has one element to look at.

## It needs sorted data

Binary search throws away half of the range at every look, trusting that everything to the left of the middle is smaller and everything to the right is larger. In an array that isn't sorted, that isn't true, and the search can miss a value that's there. So sort the data first (with `Arrays.sort` or `Collections.sort`), or keep it sorted as values are added. Sorting takes time too, so binary search pays off best when the same data is searched many times.

Java has binary search ready as well, in `Arrays.binarySearch` and `Collections.binarySearch`, for sorted arrays and lists. In this module you write your own, to see how it works.

## How much work is it?

Each look at a middle value halves the range, so the range runs out fast:

| Values | Values looked at, linear search | Values looked at, binary search |
| --- | --- | --- |
| 100 | 100 | 7 |
| 1,000 | 1,000 | 10 |
| 1,000,000 | 1,000,000 | 20 |
| 1,000,000,000 | 1,000,000,000 | 30 |

A sorted array of a million values needs at most 20 looks, because 2 to the 20th power is 1,048,576, more than a million: halving the range 20 times always gets it down to nothing. Each look compares the middle value with the wanted one up to twice (`==`, then `<`), so that's at most 40 comparisons, where linear search may need a million. Twice as many values take only one look more.

---

Source: [Binary search](https://javaarena.com/learn/sorting-searching/binary-search/) in the module [Sorting and searching](https://javaarena.com/learn/sorting-searching/) on Java Arena.

This module follows section [7.2 Algorithms](https://java-programming.mooc.fi/part-7/2-algorithms) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
