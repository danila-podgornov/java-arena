> [!info] AI-Generated

# Java's Set interface and HashSet

## Values kept once

The smart home app keeps a log: every time a device reports in, the log gets the device's name. The heater reports again and again, but at the end of the day the app wants to know which devices reported in, each just once. A list keeps every report, repeats too. A **set** keeps each value only once. `Set` is an interface in `java.util`, and `HashSet` is a class that implements it:

```java
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> devices = new HashSet<>();
        devices.add("heater");
        devices.add("fan");
        devices.add("heater");
        System.out.println(devices.size());
        System.out.println(devices.contains("fan"));
        System.out.println(devices.contains("sprinkler"));
        System.out.println(devices.add("sprinkler"));
        System.out.println(devices.add("heater"));
        devices.remove("fan");
        System.out.println(devices.size());
    }
}
```

**Output**

```text
2
true
false
true
false
2
```

- `Set<String> devices = new HashSet<>();` follows the pattern of the lists and maps before it: the interface as the variable's type, the class after `new`. Both need an import.
- `add` adds a value that isn't in the set yet. A value that's already there isn't added again: the second heater changes nothing, so the size is 2.
- `add` also returns a boolean: `true` when it added the value, and `false` when the value was there already. Programs often ignore it, but it's handy for spotting repeats.
- `contains`, `remove(value)`, `size`, `isEmpty` and `clear` work as they do for a list.
- A set has no `get(index)`, no `indexOf` and no `remove(index)`: its values have no positions. So in a `Set<Integer>`, `remove(7)` removes the value 7. Module 14's trap with number lists doesn't apply to sets.

## How a HashSet finds its values

A HashSet keeps its values the way a HashMap keeps its keys: in buckets chosen by their hash codes (module 32). So its `contains` is fast even in a big set, where a list's `contains` looks at every value in turn. For the same reason, a HashSet needs values whose `hashCode` and `equals` agree. Strings and Integers have both. Objects of your own classes need both, just as the keys of a hash map do. In fact, a map's `keySet()` is a Set: a map keeps each key once, too.

## The order of a set

A for-each loop goes through a HashSet as a HashMap goes through its keys: in an order set by the hash codes. That order may happen to match the order the values were added, or alphabetical order, but Java makes no promise about it, so never rely on it. That's why this course never prints a whole set of several values. To show them in a fixed order, copy them into a list and sort it, as module 31 did with keys:

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String[] reports = {"fan", "heater", "lamp", "heater", "fan", "heater"};
        Set<String> devices = new HashSet<>();
        for (String device : reports) {
            devices.add(device);
        }
        List<String> sorted = new ArrayList<>(devices);
        Collections.sort(sorted);
        System.out.println(reports.length + " reports from " + devices.size() + " devices");
        System.out.println(sorted);
    }
}
```

**Output**

```text
6 reports from 3 devices
[fan, heater, lamp]
```

- `new ArrayList<>(devices)` makes a list of the set's values, just as `new ArrayList<>(map.keySet())` does for a map's keys. `Collections.sort` then puts them in order.
- It works the other way round too: `new HashSet<>(list)` makes a set of a list's values, each once.

---

Source: [Java's Set interface and HashSet](https://javaarena.com/learn/interfaces/set-interface/) in the module [Interfaces](https://javaarena.com/learn/interfaces/) on Java Arena.

This module follows section [9.2 Interfaces](https://java-programming.mooc.fi/part-9/2-interface) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
