> [!info] AI-Generated

# TreeMap and TreeSet

Java's `TreeMap` and `TreeSet`, in `java.util`, keep their keys in a binary search tree that rebalances itself (a red-black tree). Their documentation promises that `get`, `put`, `containsKey` and `remove` (`add`, `contains` and `remove` for a TreeSet) take time proportional to log n, the logarithm of the size n (the base-2 logarithm of a million is about 20). A HashMap's documentation promises constant time for `get` and `put` when the hash codes spread the keys well, but a HashMap has no order. A tree map is the one to use when the order matters.

## TreeMap

Module 57 used a TreeMap to go through its keys in order. Its keys are kept sorted by their `compareTo`: numbers from smallest to biggest, Strings in alphabetical order (by character code, so capital letters come before small ones). Printing a TreeMap, or going through `keySet()` or `entrySet()`, goes in that order. Its keys must be comparable: Strings and numbers are, and objects of your own class need to implement `Comparable` (module 38), or the TreeMap needs a Comparator, given to its constructor.

A sorted map can answer questions a HashMap can't:

- `firstKey()` and `lastKey()` are the smallest and the biggest key;
- `floorKey(key)` is the biggest key that is at most `key`, and `ceilingKey(key)` the smallest that is at least `key`. Both return `null` when there's no such key;
- `lowerKey(key)` and `higherKey(key)` are the same, but strictly smaller or bigger.

A radio station's schedule maps each show's start time to the show. The show on the air at 10:30 is the one with the latest start time at or before 10:30, which is exactly `floorKey`:

```java
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        TreeMap<String, String> schedule = new TreeMap<>();
        schedule.put("09:00", "Morning music");
        schedule.put("06:00", "News and weather");
        schedule.put("12:00", "Lunch talk");
        schedule.put("13:00", "Afternoon music");
        System.out.println(schedule);
        System.out.println("First show at " + schedule.firstKey());
        System.out.println("Last show at " + schedule.lastKey());
        String start = schedule.floorKey("10:30");
        System.out.println("At 10:30: " + schedule.get(start));
        System.out.println("Next start after 10:30: " + schedule.ceilingKey("10:30"));
        System.out.println(schedule.floorKey("05:00"));
    }
}
```

**Output**

```text
{06:00=News and weather, 09:00=Morning music, 12:00=Lunch talk, 13:00=Afternoon music}
First show at 06:00
Last show at 13:00
At 10:30: Morning music
Next start after 10:30: 12:00
null
```

The times are Strings, compared character by character. That works because they all have the same form, two digits, a colon and two digits: the first character that differs decides, and it's the most significant one. `"9:00"` would come after `"10:30"`, since `'9'` comes after `'1'`. Dates written as `yyyy-mm-dd`, such as `2024-05-03`, sort the same way: year first, then month, then day, all with a fixed number of digits.

## TreeSet

A `TreeSet` is a set that keeps its values sorted, with the same kind of methods: `first()`, `last()`, `floor(value)`, `ceiling(value)`, `lower(value)` and `higher(value)`. Like any set, it ignores a value it already has.

```java
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet<Integer> sizes = new TreeSet<>();
        sizes.add(42);
        sizes.add(38);
        sizes.add(45);
        sizes.add(38);
        sizes.add(40);
        System.out.println(sizes + ", " + sizes.size() + " sizes");
        System.out.println(sizes.first() + " to " + sizes.last());
        System.out.println(sizes.floor(41) + " " + sizes.ceiling(41));
        System.out.println(sizes.floor(40) + " " + sizes.lower(40));
        System.out.println(sizes.ceiling(46));
    }
}
```

**Output**

```text
[38, 40, 42, 45], 4 sizes
38 to 45
40 42
40 38
null
```

`floor` and `ceiling` return an Integer object, or `null`. Keep the result in an `Integer` variable (or `var`), not an `int`: putting a `null` into an `int` throws a NullPointerException.

---

Source: [TreeMap and TreeSet](https://javaarena.com/learn/linked-structures/treemap-and-treeset/) in the module [Linked lists, stacks, queues and trees](https://javaarena.com/learn/linked-structures/) on Java Arena.

An extra module, not part of the University of Helsinki's course. Lesson text: [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/).
