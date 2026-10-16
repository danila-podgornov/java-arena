> [!info] AI-Generated

# Methods, lists and arrays

A method with a clear job, a name and a return value keeps `main` short. Methods that take a list or an array and give back an answer come up in almost every program.

## The tools

| Tool | What it does | Taught in |
| --- | --- | --- |
| `public static int total(int[] values)` | a method with parameters and a return value | module 10, Methods and parameters, and module 11, Return values and the call stack |
| `ArrayList<Integer>`, `add`, `get`, `size` | a list that grows as values are added | module 13, Lists |
| for-each, `contains`, `indexOf`, `remove` | go through a list, and search it | module 14, For-each, list methods and lists in methods |
| a list as a parameter | the method gets the caller's list itself, not a copy | module 14 |
| `int[] bags = {14, 9, 22};`, `bags.length` | an array: a fixed number of values | module 15, Arrays |
| `Collections.sort(list)`, `Arrays.sort(array)` | sort in place | module 28, Sorting and searching |
| the index of the smallest or largest value, linear search | where a value is | module 15, Arrays, and module 28, Sorting and searching |

## A method that returns a new list

A potato farmer at the farmers' market sells potatoes in 2-kilo bags, and weighs every bag, in grams. A bag under 2000 grams can't be sold as 2 kilos. The method `lighterThan` gives back the bags that are too light:

```java
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> bags = new ArrayList<>();
        bags.add(2050);
        bags.add(1890);
        bags.add(2010);
        bags.add(1975);
        bags.add(2100);
        ArrayList<Integer> light = lighterThan(bags, 2000);
        System.out.println("Too light: " + light);
        System.out.println("All bags: " + bags);
        Collections.sort(bags);
        System.out.println("Lightest to heaviest: " + bags);
    }

    public static ArrayList<Integer> lighterThan(ArrayList<Integer> bags, int limit) {
        ArrayList<Integer> light = new ArrayList<>();
        for (int bag : bags) {
            if (bag < limit) {
                light.add(bag);
            }
        }
        return light;
    }
}
```

**Output**

```text
Too light: [1890, 1975]
All bags: [2050, 1890, 2010, 1975, 2100]
Lightest to heaviest: [1890, 1975, 2010, 2050, 2100]
```

- The return type `ArrayList<Integer>` says what the method gives back. It makes a new list, fills it, and returns it, so `main` gets the light bags, and the list of all bags stays as it was.
- `Collections.sort(bags)` returns nothing. It sorts the list it gets, in place: the old order is gone.
- A method that gets a list gets the caller's own list, not a copy (module 14). So a method that sorts or removes from its parameter changes the caller's list too. When the caller still needs the list as it was, the method should build a new one instead.

## A method that returns an index

The same stall keeps the bags it sold on each market day in an array, and the day names in a second array, in the same order. `indexOfLargest` finds the largest value the way module 28 found the smallest, and it returns the index, which fits both arrays:

```java
public class Main {
    public static void main(String[] args) {
        String[] days = {"Wed", "Thu", "Fri", "Sat"};
        int[] sold = {14, 9, 22, 31};
        int best = indexOfLargest(sold);
        System.out.println("Best day: " + days[best] + ", " + sold[best] + " bags");
        System.out.println("Bags in all: " + total(sold));
    }

    public static int indexOfLargest(int[] values) {
        int largest = 0;
        for (int i = 1; i < values.length; i++) {
            if (values[i] > values[largest]) {
                largest = i;
            }
        }
        return largest;
    }

    public static int total(int[] values) {
        int sum = 0;
        for (int value : values) {
            sum += value;
        }
        return sum;
    }
}
```

**Output**

```text
Best day: Sat, 31 bags
Bags in all: 76
```

- With the index, `main` can look up both the day and the number. With only the number 31, it couldn't tell which day it was.
- A for-each loop works on an array too, when the loop needs the values and not their indexes.

---

Source: [Methods, lists and arrays](https://javaarena.com/learn/recap/methods-lists-arrays/) in the module [Warm-up: recap of parts 1 to 7](https://javaarena.com/learn/recap/) on Java Arena.

This module follows section [8.1 Short recap](https://java-programming.mooc.fi/part-8/1-recap) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
