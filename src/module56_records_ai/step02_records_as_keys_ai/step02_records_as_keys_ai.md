> [!info] AI-Generated

# Records as keys

In module 32, a class needed its own `equals` and `hashCode` before a HashMap could find its objects as keys. A record has both from the start, written by Java from the components.

## Equal when the components are equal

**Main.java**

```java
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Pin first = new Pin(3, 5);
        Pin second = new Pin(3, 5);
        System.out.println(first == second);
        System.out.println(first.equals(second));

        HashMap<Pin, String> places = new HashMap<>();
        places.put(new Pin(3, 5), "bakery");
        places.put(new Pin(8, 1), "library");
        System.out.println(places.get(new Pin(8, 1)));
        System.out.println(places.containsKey(new Pin(1, 8)));
    }
}
```

**Pin.java**

```java
public record Pin(int x, int y) {
}
```

**Output**

```text
false
true
library
false
```

- `first == second` is still `false`: `new` makes two objects, and `==` asks whether two references point to the very same object (module 32).
- `first.equals(second)` is `true`. A record's `equals` is true when the other object is a record of the same type and every component is equal: components of a primitive type such as `int` are compared by their value (doubles with `Double.compare`), and objects such as Strings with their own `equals`.
- `places.get(new Pin(8, 1))` finds the library, although the key in the map is another object: the map uses the record's `hashCode` and `equals`, and both look only at the components. `new Pin(1, 8)` has the same numbers the other way round, so it's a different key.

## What hashCode gives

A record's `hashCode` is computed from its components, so equal records always have the same hash code, which is the rule from module 32 that a HashMap needs. Java doesn't promise what the number itself is, though: it may differ from one Java version to another. So don't print it or write code that depends on its value. The same goes for printing a whole HashMap or HashSet of records: it shows them in an order of its own (module 31). Print what you look up, or go through a list.

## Records in a HashSet

A HashSet keeps each value once, by `equals` and `hashCode`, so records work in sets too. A set of pins dropped by friends who meet up, with one pin dropped twice:

**Main.java**

```java
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        HashSet<Pin> dropped = new HashSet<>();
        System.out.println(dropped.add(new Pin(3, 5)));
        System.out.println(dropped.add(new Pin(6, 2)));
        System.out.println(dropped.add(new Pin(3, 5)));
        System.out.println(dropped.size() + " different places");
    }
}
```

**Pin.java**

```java
public record Pin(int x, int y) {
}
```

**Output**

```text
true
true
false
2 different places
```

`add` returns `false` when an equal value is already in the set, and leaves the set as it was.

---

Source: [Records as keys](https://javaarena.com/learn/records/equals-and-hashcode/) in the module [Records](https://javaarena.com/learn/records/) on Java Arena.

An extra module, not part of the University of Helsinki's course. Lesson text: [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/).
