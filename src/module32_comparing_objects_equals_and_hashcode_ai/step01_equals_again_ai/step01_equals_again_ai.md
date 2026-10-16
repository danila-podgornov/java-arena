> [!info] AI-Generated

# equals, again

Module 23 gave classes an `equals` of their own, so that two objects with the same values count as equal. Module 31 used Strings and Integers as the keys of hash maps. This module brings the two together: objects of your own classes as hash map keys. That takes one more method, `hashCode`, and this step shows why.

## A quick recap

Here's the theater seat from module 23, with its `equals`:

**Main.java**

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Seat mine = new Seat("B", 7);
        Seat yours = new Seat("B", 7);
        System.out.println(mine == yours);
        System.out.println(mine.equals(yours));

        ArrayList<Seat> booked = new ArrayList<>();
        booked.add(mine);
        booked.add(new Seat("C", 2));
        System.out.println(booked.contains(new Seat("C", 2)));
        System.out.println(booked.indexOf(new Seat("B", 7)));
        booked.remove(new Seat("B", 7));
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
false
true
true
0
[C2]
```

- `==` on two objects asks whether both variables refer to the same object. `mine` and `yours` come from two `new`s, so they're two objects, and `==` says `false` even though their values are the same.
- `equals` is Seat's own method, written the classic way: the header `public boolean equals(Object compared)`, `true` for the very same object, `false` for anything that isn't a Seat (`instanceof`), and otherwise a cast to Seat and a comparison of the values. The row is a String, so it's compared with `equals`, and the number with `==`.
- A list's `contains`, `indexOf` and `remove(value)` compare with `equals`, so they find a brand-new Seat that's equal to one in the list.

## Seats as hash map keys

A theater wants to look up who holds each seat, so it keeps a `HashMap<Seat, String>` from a seat to a name. It's the same Seat class, with the same `equals`:

**Main.java**

```java
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<Seat, String> holders = new HashMap<>();
        Seat seat = new Seat("B", 7);
        holders.put(seat, "Ada");
        System.out.println(holders.get(seat));
        System.out.println(holders.get(new Seat("B", 7)));
        System.out.println(holders.containsKey(new Seat("B", 7)));

        holders.put(new Seat("B", 7), "Ben");
        System.out.println(holders.size());
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
Ada
null
false
2
```

- With the very object that was put in, `get` finds Ada.
- `new Seat("B", 7)` is equal to that key, and a list would have found it. The map doesn't: `get` gives `null`, and `containsKey` gives `false`.
- It gets worse. A `put` with a key that's already in the map should replace its value (module 31), but the new B7 seat didn't replace Ada: the map added it as a second key. Now it holds B7 twice, once for Ada and once for Ben.

A hash map doesn't go through all of its keys and compare each one with `equals`, the way a list's `contains` does: that would be slow in a big map. It first asks the key for a number, its **hash code**, and uses that number to decide where to look. Seat has an `equals`, but no `hashCode` of its own, so in practice the map looks in the wrong place. The next step shows what a hash code is, and step 3 gives Seat a `hashCode`. Until then, keep one rule in mind: a class whose objects are hash map keys needs both methods.

---

Source: [equals, again](https://javaarena.com/learn/equals-hashcode/equals-again/) in the module [Comparing objects: equals and hashCode](https://javaarena.com/learn/equals-hashcode/) on Java Arena.

This module follows section [8.3 Similarity of objects](https://java-programming.mooc.fi/part-8/3-similarity-of-objects) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
