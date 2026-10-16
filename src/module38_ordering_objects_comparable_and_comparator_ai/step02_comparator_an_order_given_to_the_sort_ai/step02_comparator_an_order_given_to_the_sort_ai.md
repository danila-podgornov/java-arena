> [!info] AI-Generated

# Comparator: an order given to the sort

A class has only one `compareTo`, so it has only one natural order. But a program often needs the same objects in several orders. An airport's departures board lists the flights by time, the staff at the gates want them by gate, and a travel app lists them by destination. For those, you hand the sort the order to use, as a lambda.

## A lambda that compares two objects

A list has a `sort` method of its own, which takes the rule as a lambda with two parameters (module 37 showed that two parameters go in parentheses: `(a, b) -> ...`). The board's flights, by gate:

**Main.java**

```java
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight("Lisbon", "13:10", 4));
        flights.add(new Flight("Oslo", "07:45", 12));
        flights.add(new Flight("Dublin", "09:30", 7));
        flights.add(new Flight("Athens", "18:20", 2));
        flights.add(new Flight("Riga", "09:05", 12));

        flights.sort((a, b) -> Integer.compare(a.getGate(), b.getGate()));
        for (Flight flight : flights) {
            System.out.println(flight);
        }
    }
}
```

**Flight.java**

```java
public class Flight {
    private String destination;
    private String departs;
    private int gate;

    public Flight(String destination, String departs, int gate) {
        this.destination = destination;
        this.departs = departs;
        this.gate = gate;
    }

    public String getDestination() {
        return this.destination;
    }

    public String getDeparts() {
        return this.departs;
    }

    public int getGate() {
        return this.gate;
    }

    @Override
    public String toString() {
        return this.departs + " " + this.destination + " (gate " + this.gate + ")";
    }
}
```

**Output**

```text
18:20 Athens (gate 2)
13:10 Lisbon (gate 4)
09:30 Dublin (gate 7)
07:45 Oslo (gate 12)
09:05 Riga (gate 12)
```

- Flight has no `compareTo`, and it doesn't implement Comparable. The whole rule is in the lambda.
- The lambda gets two flights, `a` and `b`, and answers the way `compareTo` does: negative when `a` goes before `b`, zero for a tie, positive when `a` goes after `b`. `Integer.compare(a.getGate(), b.getGate())` puts the smaller gate first.
- `a` and `b` are names like any others: `(first, second) -> ...` works the same.
- `sort` changes the list itself, as `Collections.sort` does. Ties keep their order here too: Oslo and Riga both leave from gate 12, and Oslo was in the list first.

## The Comparator interface

The lambda is a **Comparator**, another of Java's interfaces. The one method you have to write for a comparator, the one the lambda writes, is `compare(a, b)`, which answers like `compareTo`, but for two objects given to it from outside. Every comparator also comes with ready-made methods, such as `reversed()` and `thenComparing()` later in this module. A comparator can be kept in a variable of type `Comparator<Flight>` and used as often as you like, and `Collections.sort` takes one as its second parameter:

**Main.java**

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight("Lisbon", "13:10", 4));
        flights.add(new Flight("Oslo", "07:45", 12));
        flights.add(new Flight("Dublin", "09:30", 7));
        flights.add(new Flight("Athens", "18:20", 2));
        flights.add(new Flight("Riga", "09:05", 12));

        Comparator<Flight> byTime = (a, b) -> a.getDeparts().compareTo(b.getDeparts());
        Collections.sort(flights, byTime);
        for (Flight flight : flights) {
            System.out.println(flight);
        }
    }
}
```

**Flight.java**

```java
public class Flight {
    private String destination;
    private String departs;
    private int gate;

    public Flight(String destination, String departs, int gate) {
        this.destination = destination;
        this.departs = departs;
        this.gate = gate;
    }

    public String getDestination() {
        return this.destination;
    }

    public String getDeparts() {
        return this.departs;
    }

    public int getGate() {
        return this.gate;
    }

    @Override
    public String toString() {
        return this.departs + " " + this.destination + " (gate " + this.gate + ")";
    }
}
```

**Output**

```text
07:45 Oslo (gate 12)
09:05 Riga (gate 12)
09:30 Dublin (gate 7)
13:10 Lisbon (gate 4)
18:20 Athens (gate 2)
```

- `Comparator` is in `java.util`, so the program imports it: `import java.util.Comparator;`.
- The type `Comparator<Flight>` tells Java that the lambda's `a` and `b` are Flights.
- `Collections.sort(flights, byTime)` and `flights.sort(byTime)` do the same thing. This module mostly writes the shorter `flights.sort(...)`.
- The times are Strings, and Strings sort letter by letter. Every time here has two digits for the hour, like `07:45`, so alphabetical order is time order. Written as `7:45`, it would come after `13:10`, since the character 7 comes after 1.

## Comparator.comparing

Most comparators compare one value of each object, such as the gate or the time. `Comparator.comparing` builds that comparator for you, from a method that gives the value, usually a getter written as a method reference (module 37):

**Main.java**

```java
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight("Lisbon", "13:10", 4));
        flights.add(new Flight("Oslo", "07:45", 12));
        flights.add(new Flight("Dublin", "09:30", 7));
        flights.add(new Flight("Athens", "18:20", 2));
        flights.add(new Flight("Riga", "09:05", 12));

        flights.sort(Comparator.comparing(Flight::getDestination));
        for (Flight flight : flights) {
            System.out.println(flight);
        }
    }
}
```

**Flight.java**

```java
public class Flight {
    private String destination;
    private String departs;
    private int gate;

    public Flight(String destination, String departs, int gate) {
        this.destination = destination;
        this.departs = departs;
        this.gate = gate;
    }

    public String getDestination() {
        return this.destination;
    }

    public String getDeparts() {
        return this.departs;
    }

    public int getGate() {
        return this.gate;
    }

    @Override
    public String toString() {
        return this.departs + " " + this.destination + " (gate " + this.gate + ")";
    }
}
```

**Output**

```text
18:20 Athens (gate 2)
09:30 Dublin (gate 7)
13:10 Lisbon (gate 4)
07:45 Oslo (gate 12)
09:05 Riga (gate 12)
```

`Comparator.comparing(Flight::getDestination)` reads: to compare two flights, call `getDestination()` on each, and compare those values. So the values need an order of their own: numbers, Strings, or objects of a Comparable class like step 1's Talk. The two comparators above, built this way:

- `Comparator.comparing(Flight::getGate)` does what `(a, b) -> Integer.compare(a.getGate(), b.getGate())` did.
- `Comparator.comparing(Flight::getDeparts)` does what `byTime` did.

## reversed

`reversed()` turns a comparator around: the largest first, or Z to A. The board's evening view shows the latest flights first:

**Main.java**

```java
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight("Lisbon", "13:10", 4));
        flights.add(new Flight("Oslo", "07:45", 12));
        flights.add(new Flight("Dublin", "09:30", 7));
        flights.add(new Flight("Athens", "18:20", 2));
        flights.add(new Flight("Riga", "09:05", 12));

        flights.sort(Comparator.comparing(Flight::getDeparts).reversed());
        for (Flight flight : flights) {
            System.out.println(flight);
        }
        System.out.println();

        flights.sort(Comparator.comparing(Flight::getGate).reversed());
        for (Flight flight : flights) {
            System.out.println(flight);
        }
    }
}
```

**Flight.java**

```java
public class Flight {
    private String destination;
    private String departs;
    private int gate;

    public Flight(String destination, String departs, int gate) {
        this.destination = destination;
        this.departs = departs;
        this.gate = gate;
    }

    public String getDestination() {
        return this.destination;
    }

    public String getDeparts() {
        return this.departs;
    }

    public int getGate() {
        return this.gate;
    }

    @Override
    public String toString() {
        return this.departs + " " + this.destination + " (gate " + this.gate + ")";
    }
}
```

**Output**

```text
18:20 Athens (gate 2)
13:10 Lisbon (gate 4)
09:30 Dublin (gate 7)
09:05 Riga (gate 12)
07:45 Oslo (gate 12)

09:05 Riga (gate 12)
07:45 Oslo (gate 12)
09:30 Dublin (gate 7)
13:10 Lisbon (gate 4)
18:20 Athens (gate 2)
```

Look at Riga and Oslo in the second list. `reversed()` turns the comparator's answers around, not the list: flights that tie still tie, and a tie keeps the order the list had. After the first sort, Riga was before Oslo, so it stays before Oslo.

A lambda you write yourself turns around by swapping the two values, `(a, b) -> Integer.compare(b.getGate(), a.getGate())`, just as swapping them in step 1's `compareTo` put the latest talk first.

## Use a method reference in comparing

`Comparator.comparing(flight -> flight.getGate())` works too, on its own. But with `.reversed()` after it, it doesn't compile:

**Main.java**

```java
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight("Lisbon", "13:10", 4));
        flights.add(new Flight("Oslo", "07:45", 12));
        flights.sort(Comparator.comparing(flight -> flight.getGate()).reversed());
        System.out.println(flights);
    }
}
```

**Flight.java**

```java
public class Flight {
    private String destination;
    private String departs;
    private int gate;

    public Flight(String destination, String departs, int gate) {
        this.destination = destination;
        this.departs = departs;
        this.gate = gate;
    }

    public int getGate() {
        return this.gate;
    }

    @Override
    public String toString() {
        return this.departs + " " + this.destination + " (gate " + this.gate + ")";
    }
}
```

**What javac prints**

```text
Main.java:10: error: cannot find symbol
        flights.sort(Comparator.comparing(flight -> flight.getGate()).reversed());
                                                          ^
  symbol:   method getGate()
  location: variable flight of type Object
1 error
```

Java works out a lambda's parameter types from the place where the lambda is used. Here, `.reversed()` is called on the comparator before Java has seen that it's meant for flights, so it takes `flight` to be just an Object, which has no `getGate()`. The method reference `Flight::getGate` names the class, so Java knows. Write method references in `comparing`, as the rest of this module does.

---

Source: [Comparator: an order given to the sort](https://javaarena.com/learn/sorting-objects/comparator/) in the module [Ordering objects: Comparable and Comparator](https://javaarena.com/learn/sorting-objects/) on Java Arena.

This module follows section [10.2 The Comparable Interface](https://java-programming.mooc.fi/part-10/2-interface-comparable) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
