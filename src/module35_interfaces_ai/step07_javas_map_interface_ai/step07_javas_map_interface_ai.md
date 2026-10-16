> [!info] AI-Generated

# Java's Map interface

Maps work the same way. HashMap is a class, and it implements an interface called **Map**, also in `java.util`. Map promises what modules 31 to 33 used: `put`, `get`, `getOrDefault`, `containsKey`, `remove`, `size`, `keySet` and `values`. A bakery keeps the day's orders, from each kind of bread to a number of loaves:

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> orders = new HashMap<>();
        orders.put("rye", 4);
        orders.put("sourdough", 10);
        orders.put("rye", orders.get("rye") + 2);
        orders.put("baguette", 7);
        System.out.println(orders.get("rye"));
        System.out.println(orders.getOrDefault("spelt", 0));
        System.out.println(totalLoaves(orders));
        printOrders(orders);
    }

    public static int totalLoaves(Map<String, Integer> orders) {
        int total = 0;
        for (int loaves : orders.values()) {
            total += loaves;
        }
        return total;
    }

    public static void printOrders(Map<String, Integer> orders) {
        List<String> breads = new ArrayList<>(orders.keySet());
        Collections.sort(breads);
        for (String bread : breads) {
            System.out.println(bread + ": " + orders.get(bread));
        }
    }
}
```

**Output**

```text
6
0
23
baguette: 7
rye: 6
sourdough: 10
```

- `Map<String, Integer> orders = new HashMap<>();`: the variable's type is the interface, and the object is a HashMap. Map needs its own import, `import java.util.Map;`.
- Every call you know from HashMap works, since every one of them is in Map.
- `totalLoaves` and `printOrders` take a Map, so they'd work with any class that implements Map. Java has others, such as `TreeMap`, which keeps its keys in sorted order. This course keeps to HashMap.
- The object is still a HashMap, so module 31's rule about order still holds: it goes through its keys in an order set by their hash codes. That's why `printOrders` sorts a list of the keys first. The list is a `List<String>` now, like step 6's lists.

## What keySet and values give

`keySet()` and `values()` return interface types too:

- `keySet()` returns a `Set<String>`, a set of the keys. Sets are the next step.
- `values()` returns a `Collection<Integer>`. Collection is the interface of step 9.

So far you've used them only in a for-each loop or in `new ArrayList<>(...)`, and both of those accept any Set or Collection.

Module 33's maps of lists can use the interfaces too: `Map<String, List<String>> byClub = new HashMap<>();` holds a List for each key, and each new value can still be made with `new ArrayList<>()`, since an ArrayList is a List.

---

Source: [Java's Map interface](https://javaarena.com/learn/interfaces/map-interface/) in the module [Interfaces](https://javaarena.com/learn/interfaces/) on Java Arena.

This module follows section [9.2 Interfaces](https://java-programming.mooc.fi/part-9/2-interface) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
