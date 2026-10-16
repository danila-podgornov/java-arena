> [!info] AI-Generated

# Class or record?

Records are a handy tool, but not for every class. This step shows what a record can't do, and how to choose.

## What a record can't do

- **Change.** Its values are fixed when it's made. Anything whose values change over time, such as a counter, a bank account's balance or a shopping cart that items are added to, needs a class.
- **Hide a value or keep one of its own.** Every component has a public accessor, and a record has no instance variables besides its components.
- **Inherit.** A record is `final`, so no class can extend it, and a record can't extend a class either. Every record already extends Java's class `Record`:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        System.out.println(new Tram("7A", 22));
    }
}
```

**Vehicle.java**

```java
public class Vehicle {
}
```

**Tram.java**

```java
public record Tram(String line, int stops) extends Vehicle {
}
```

**What javac prints**

```text
Tram.java:1: error: '{' expected
public record Tram(String line, int stops) extends Vehicle {
                                          ^
1 error
```

javac doesn't even read on to the word `extends`: after a record's header it expects its body. A record can **implement interfaces**, though, as a class does (module 35), and that includes Comparable.

One more thing to know: a record is only as fixed as its components. A component that's an `ArrayList` can't be swapped for another list, but the list itself can still get new elements, through the accessor. Records work best with components that don't change either: numbers, Strings and other records.

## Records and sorting

Accessors are methods, so they work as method references (module 37) in `Comparator.comparing` (module 38), and a record can implement `Comparable` for its natural order:

**Main.java**

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        ArrayList<Departure> board = new ArrayList<>();
        board.add(new Departure("R 14", 1015, 3));
        board.add(new Departure("IC 27", 940, 8));
        board.add(new Departure("S 102", 1015, 1));

        Collections.sort(board);
        System.out.println(board.get(0).train() + " leaves first");

        board.sort(Comparator.comparing(Departure::platform));
        for (Departure departure : board) {
            System.out.println(departure);
        }
    }
}
```

**Departure.java**

```java
public record Departure(String train, int time, int platform) implements Comparable<Departure> {
    @Override
    public int compareTo(Departure other) {
        return this.time - other.time;
    }
}
```

**Output**

```text
IC 27 leaves first
Departure[train=S 102, time=1015, platform=1]
Departure[train=R 14, time=1015, platform=3]
Departure[train=IC 27, time=940, platform=8]
```

## Choosing

A record fits when the object **is** its values: two of them with the same values are interchangeable, as two 5 euro notes are. A point, an amount of money, a date range, a reading, a timetable entry. A class fits when the object has a life of its own: its values change, it keeps things hidden, or two objects with the same values are still different things, as two bank accounts that both hold 0 euros are.

Many programs use both: a class keeps changing state, and records are the values it holds and hands out.

---

Source: [Class or record?](https://javaarena.com/learn/records/class-or-record/) in the module [Records](https://javaarena.com/learn/records/) on Java Arena.

An extra module, not part of the University of Helsinki's course. Lesson text: [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/).
