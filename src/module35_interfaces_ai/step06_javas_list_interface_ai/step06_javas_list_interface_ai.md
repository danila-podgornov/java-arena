> [!info] AI-Generated

# Java's List interface

Since module 13, every list in this course has been an `ArrayList`. ArrayList is a class, and it implements an interface from `java.util` called **List**. List promises the methods that every list has: `add`, `get`, `set`, `remove`, `size`, `contains`, `indexOf`, `isEmpty`, `clear` and the rest of module 14's toolbox. ArrayList is one class that keeps that promise.

So a list variable can have the interface as its type:

```java
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> stops = new ArrayList<>();
        stops.add("Harbor");
        stops.add("Market Square");
        stops.add("Museum");
        stops.add(1, "Old Mill");
        System.out.println(stops);
        System.out.println(stops.size() + " stops, the last is " + stops.get(stops.size() - 1));
        printTimetable(stops, 4);
    }

    public static void printTimetable(List<String> stops, int minutesBetween) {
        int minute = 0;
        for (String stop : stops) {
            System.out.println(minute + " min: " + stop);
            minute += minutesBetween;
        }
    }
}
```

**Output**

```text
[Harbor, Old Mill, Market Square, Museum]
4 stops, the last is Museum
0 min: Harbor
4 min: Old Mill
8 min: Market Square
12 min: Museum
```

- `List<String> stops = new ArrayList<>();`: the variable's type is the interface, and the object is an ArrayList. List needs its own import, `import java.util.List;`.
- Every call works as before, since every one of those methods is in List. The list prints as before too: `println` runs the object's `toString`, and the object is an ArrayList.
- `printTimetable` takes a `List<String>`, so it accepts any list of Strings: an ArrayList, or an object of any other class that implements List. Java has others, such as `LinkedList`, which keeps its values in a different way. This course keeps to ArrayList, but code written for List works with any of them.
- `new List<>()` doesn't compile, as with any interface.

## Why many programs write List

Many Java programs declare their lists as `List<String> names = new ArrayList<>();`. It's step 3's advice: the rest of the code uses only what List promises, so it doesn't depend on which kind of list it has. A method with a List parameter accepts more kinds of lists, and a program could change `new ArrayList<>()` to another kind of list in one place.

The same idea is behind `Collections.sort`, which you've used since module 28: its parameter is a List, and that's why it can sort an ArrayList.

## An ArrayList fits a List, not the other way round

An ArrayList can go wherever a List is asked for. But a List variable can't be given to a method that asks for an ArrayList: javac knows only that the variable holds some list, not which kind.

```java
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> stops = new ArrayList<>();
        stops.add("Harbor");
        System.out.println(count(stops));
    }

    public static int count(ArrayList<String> stops) {
        return stops.size();
    }
}
```

**What javac prints**

```text
Main.java:8: error: incompatible types: List<String> cannot be converted to ArrayList<String>
        System.out.println(count(stops));
                                 ^
Note: Some messages have been simplified; recompile with -Xdiags:verbose to get full output
1 error
```

So `List<String>` is usually the better parameter type: it accepts a List variable and an ArrayList variable alike. The rest of this module writes List for its parameters.

---

Source: [Java's List interface](https://javaarena.com/learn/interfaces/list-interface/) in the module [Interfaces](https://javaarena.com/learn/interfaces/) on Java Arena.

This module follows section [9.2 Interfaces](https://java-programming.mooc.fi/part-9/2-interface) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
