> [!info] AI-Generated

# Java's own sorting methods

Writing selection sort shows what sorting takes, but in real programs you rarely write your own. Java has sorting methods ready, and they use algorithms that are much faster than selection sort on large arrays.

`Arrays.sort(array)` sorts an array, and `Collections.sort(list)` sorts a list. Both classes are in `java.util`, so each needs an import line, like `Scanner`:

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        int[] prices = {250, 120, 310, 90};
        Arrays.sort(prices);
        System.out.println(Arrays.toString(prices));

        ArrayList<String> cities = new ArrayList<>();
        cities.add("Oslo");
        cities.add("Lima");
        cities.add("Cairo");
        Collections.sort(cities);
        System.out.println(cities);
    }
}
```

**Output**

```text
[90, 120, 250, 310]
[Cairo, Lima, Oslo]
```

- Numbers sort from the smallest to the largest, and Strings in alphabetical order (with a few surprises, below).
- Neither method returns anything. They sort the array or the list itself, in place, as `selectionSort` did. The old order is gone, so if the program still needs it, it should keep a copy of the values somewhere else first.
- `Arrays.sort` works on arrays of numbers and of Strings, such as `int[]`, `double[]` and `String[]`. `Collections.sort` works on lists of them, such as `ArrayList<Integer>` and `ArrayList<String>`.

## The order of Strings

Strings are compared character by character, by each character's code. In those codes, digits come before capital letters, and capital letters come before small ones. So the "alphabetical" order holds some surprises:

```java
ArrayList<String> words = new ArrayList<>();
words.add("banana");
words.add("Cherry");
words.add("apple");
words.add("Apple");
Collections.sort(words);
System.out.println(words);

ArrayList<String> labels = new ArrayList<>();
labels.add("9");
labels.add("10");
labels.add("100");
labels.add("25");
Collections.sort(labels);
System.out.println(labels);
```

**Output**

```text
[Apple, Cherry, apple, banana]
[10, 100, 25, 9]
```

- Every word that starts with a capital letter comes before every word that starts with a small one, so `Cherry` is before `apple`.
- The labels are Strings, not numbers. `"10"` comes before `"9"` because its first character, `1`, comes before `9`, just as `"ba"` comes before `"c"`. When one String is the start of another, the shorter one comes first, so `"10"` is before `"100"`.
- Numbers kept as `int` or `Integer` sort by their value. To sort numbers, store them as numbers.

## Your own classes

A list of objects of your own class, such as an `ArrayList<Album>`, can't be sorted this way yet. Java doesn't know whether albums go by title, by year or by something else, so `Collections.sort` on such a list doesn't compile. Part 10 of the course shows how a class tells Java its order, with `Comparable`.

---

Source: [Java's own sorting methods](https://javaarena.com/learn/sorting-searching/ready-made-sorting/) in the module [Sorting and searching](https://javaarena.com/learn/sorting-searching/) on Java Arena.

This module follows section [7.2 Algorithms](https://java-programming.mooc.fi/part-7/2-algorithms) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
