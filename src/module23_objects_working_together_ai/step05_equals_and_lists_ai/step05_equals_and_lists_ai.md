> [!info] AI-Generated

# equals and lists

The list methods `contains`, `indexOf` and `remove(value)` from module 14 all search the list. To decide whether a value in the list is the one they're looking for, they call `equals`. With Strings that has always worked, because String has an `equals` of its own that compares the letters. With objects of your own class, it works as soon as the class has its own `equals`, like the Seat from the previous step:

**Main.java**

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Seat> booked = new ArrayList<>();
        booked.add(new Seat("A", 3));
        booked.add(new Seat("B", 7));
        booked.add(new Seat("C", 1));

        System.out.println(booked.contains(new Seat("B", 7)));
        System.out.println(booked.indexOf(new Seat("C", 1)));
        booked.remove(new Seat("A", 3));
        System.out.println(booked);
    }
}
```

**Seat.java**

```java
public class Seat {
    private String row;
    private int number;

    public Seat(String row, int number) {
        this.row = row;
        this.number = number;
    }

    public boolean equals(Object compared) {
        if (this == compared) {
            return true;
        }
        if (!(compared instanceof Seat)) {
            return false;
        }
        Seat other = (Seat) compared;
        return this.row.equals(other.row) && this.number == other.number;
    }

    public String toString() {
        return this.row + this.number;
    }
}
```

**Output**

```text
true
2
[B7, C1]
```

- Each `new Seat(...)` in the parentheses is a brand-new object, not one of the objects in the list. `contains` finds it anyway, because it compares with `equals`, and a seat in the list is equal to it.
- `indexOf` gives the index of the first equal seat, and `remove(value)` removes the first equal seat, as they did with Strings.
- Printing a list prints each value with its `toString`, between brackets and separated by commas.

Without the `equals` method in Seat, all three would miss: `contains` would print `false`, `indexOf` would print `-1`, and `remove` wouldn't remove anything. The seat they're given is never the very same object as one in the list, and the `equals` that every class gets only looks for the same object.

For lists, `equals` is all it takes. Some of Java's other collections, which come in part 8, also need a second method, `hashCode`.

## Only once in the list

A common use is a list that holds each value only once: before adding, check that no equal value is in it yet.

```java
Seat seat = new Seat(row, number);
if (booked.contains(seat)) {
    System.out.println(seat + " is already taken");
} else {
    booked.add(seat);
    System.out.println("Booked " + seat);
}
```

---

Source: [equals and lists](https://javaarena.com/learn/object-interaction/equals-and-lists/) in the module [Objects working together](https://javaarena.com/learn/object-interaction/) on Java Arena.

This module follows sections [5.4 Objects and references](https://java-programming.mooc.fi/part-5/4-objects-and-references), [5.5 Conclusion](https://java-programming.mooc.fi/part-5/5-conclusion) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
