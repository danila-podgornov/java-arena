> [!info] AI-Generated

# Collection, and choosing between an interface and an abstract class

## Collection: what lists and sets share

Lists and sets have a lot in common: both hold values, and both have `add`, `remove`, `contains`, `size`, `isEmpty` and `clear`. Java puts what they share in one more interface, **Collection**. An interface can extend another interface, and List and Set both extend Collection. So an ArrayList is a List and a Collection, and a HashSet is a Set and a Collection.

Collection has no `get(index)`, since a set's values have no positions. But a for-each loop can go through any Collection. So a method whose parameter is a Collection works with lists and sets alike. A smart home's energy meter shows it:

```java
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<Integer> hourly = new ArrayList<>();
        hourly.add(300);
        hourly.add(450);
        hourly.add(300);
        System.out.println(total(hourly));

        Set<Integer> different = new HashSet<>(hourly);
        System.out.println(different.size() + " different amounts, adding up to " + total(different));

        Map<String, Integer> watts = new HashMap<>();
        watts.put("heater", 1500);
        watts.put("fan", 60);
        watts.put("garden light", 12);
        System.out.println(total(watts.values()) + " watts with everything on");
    }

    public static int total(Collection<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
}
```

**Output**

```text
1050
2 different amounts, adding up to 750
1572 watts with everything on
```

- `total` takes a `Collection<Integer>`, so it accepts the list, the set, and `watts.values()`, which is a Collection too. With a `List<Integer>` parameter, it couldn't take the set, and with a `Set<Integer>` parameter, not the list.
- The set keeps 300 only once, so its total is smaller. A sum doesn't depend on the order of the values, so going through a set is fine here.
- A map's `keySet()` is a Set and its `values()` a Collection, so both fit a Collection parameter. A map itself isn't a Collection: it holds pairs, not single values.
- Collection needs `import java.util.Collection;`. Mind the names: `Collection` is the interface, and `Collections`, with an s, is the class with `sort` and other helpers.

## Interface or abstract class?

Module 34's abstract classes and this module's interfaces both list methods that other classes must write, and neither can be made with `new`. Which should you use? The differences decide:

| | Interface | Abstract class |
| --- | --- | --- |
| How many a class can have | any number: `implements A, B` | one: `extends A` |
| Instance variables and constructors | none | yes |
| Methods with code | none, in this course | yes, shared by every subclass |
| Says of an object | what it can do | what it is |

- Choose an **interface** when classes that are otherwise unrelated share an ability. A heater and a scooter can both be switched on; a product and a repair both have a price. Code that needs only that ability, such as `printLine` or the app's buttons, takes the interface, and works with every class that has it, including classes written later.
- Choose an **abstract class** when the classes are kinds of one thing, and share data and code: every instrument in module 34 had a name, and `play` was written once, in Instrument.
- The two combine: a class can extend an abstract class and implement interfaces. Java's own ArrayList does both: it extends an abstract class, `AbstractList`, which holds code that lists share, and it implements List.

When in doubt, start from what the code that *uses* the objects needs. If it needs only a few methods, an interface says exactly that, and leaves each class free to extend whatever else it needs. Module 36 comes back to this choice.

---

Source: [Collection, and choosing between an interface and an abstract class](https://javaarena.com/learn/interfaces/collection-interface/) in the module [Interfaces](https://javaarena.com/learn/interfaces/) on Java Arena.

This module follows section [9.2 Interfaces](https://java-programming.mooc.fi/part-9/2-interface) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
