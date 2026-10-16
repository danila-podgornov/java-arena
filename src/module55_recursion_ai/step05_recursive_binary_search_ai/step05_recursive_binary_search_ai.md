> [!info] AI-Generated

# Recursive binary search

Module 28 searched a sorted array with binary search, in a `while` loop: look at the middle value, and if it isn't the wanted one, go on in the half where the wanted value would be. "Go on in the half" is the same search on a smaller range, so binary search can also be written recursively.

## The range as parameters

The loop kept the range in two variables, `low` and `high`. The recursive method gets them as parameters, and the recursive call gets the new range. A greengrocer keeps the prices of the products, in cents, in a sorted array:

```java
public class Main {
    public static void main(String[] args) {
        int[] prices = {45, 80, 120, 199, 250, 310, 475, 520};
        System.out.println(find(prices, 310, 0, prices.length - 1));
        System.out.println(find(prices, 100, 0, prices.length - 1));
    }

    public static int find(int[] sorted, int wanted, int low, int high) {
        if (low > high) {
            return -1;
        }
        int middle = (low + high) / 2;
        System.out.println("  looking between " + low + " and " + high + " at " + sorted[middle]);
        if (sorted[middle] == wanted) {
            return middle;
        }
        if (sorted[middle] < wanted) {
            return find(sorted, wanted, middle + 1, high);
        }
        return find(sorted, wanted, low, middle - 1);
    }
}
```

**Output**

```text
  looking between 0 and 7 at 199
  looking between 4 and 7 at 310
5
  looking between 0 and 7 at 199
  looking between 0 and 2 at 80
  looking between 2 and 2 at 120
-1
```

There are two base cases: an empty range (`low > high`), where the value isn't in the array, and a middle value that is the wanted one. Every other call searches a range at most half as long, so the calls reach a base case quickly: for an array of a million values, at most 20 looks, as in module 28. The recursion is at most about 20 calls deep, so the call stack is never a problem here.

Each recursive call is `return find(...)`: the method returns whatever the smaller search found, unchanged. The answer is found at the bottom and passed up through every call.

## A friendlier method on top

Callers shouldn't have to pass `0` and `prices.length - 1` themselves. The usual way is a second method with the same name and fewer parameters, which starts the search on the whole array (two methods with the same name and different parameters are overloads, module 21):

```java
public static int find(int[] sorted, int wanted) {
    return find(sorted, wanted, 0, sorted.length - 1);
}
```

The extra parameters of the recursive method are then a detail that only this class sees. The third challenge of this step uses the pattern.

---

Source: [Recursive binary search](https://javaarena.com/learn/recursion/binary-search/) in the module [Recursion](https://javaarena.com/learn/recursion/) on Java Arena.

An extra module, not part of the University of Helsinki's course. Lesson text: [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/).
