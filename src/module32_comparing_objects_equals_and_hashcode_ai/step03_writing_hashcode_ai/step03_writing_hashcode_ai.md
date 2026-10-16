> [!info] AI-Generated

# Writing hashCode

## A hashCode for Seat

A class gets hash codes of its own the same way it gets its own `equals`: by writing the method. The header must be exactly `public int hashCode()`, with no parameters and an `int` back. A method with any other name, even `hashcode` with a small `c`, is just a new method, and no hash map ever calls it.

What should it return? The rule says that equal seats must get equal hash codes, and two seats are equal when their rows and numbers are. So work the hash code out from those two values, and from nothing else:

```java
public int hashCode() {
    return 31 * this.row.hashCode() + this.number;
}
```

- The row is a String, and equal Strings have equal hash codes. The number is an `int`, used as it is. So two equal seats give the same result, and the rule holds.
- Why times 31? `this.row.hashCode() + this.number` would follow the rule too, but many different seats would share a hash code. A one-letter String's hash code is the letter's code, so B7 would be 66 + 7 = 73, and so would C6 (67 + 6) and D5 (68 + 5). With the 31, B7 is 66 * 31 + 7 = 2053, and C6 is 67 * 31 + 6 = 2083. String's own `hashCode` uses the same trick.
- Use only the values that `equals` compares. A value that `equals` ignores could give two equal seats different hash codes, and that breaks the rule. (The last challenge of this step shows what happens then.)
- If the calculation grows past the largest `int` and wraps around, that's fine: any `int` will do as a hash code.

Here's step 1's hash map program again. Only Seat has changed: it has both methods now.

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

    public int hashCode() {
        return 31 * this.row.hashCode() + this.number;
    }

    public String toString() {
        return this.row + this.number;
    }
}
```

**Output**

```text
Ada
Ada
true
1
```

- A new B7 seat now has the same hash code as the key in the map, so `get` and `containsKey` look in the right bucket, and `equals` confirms the match.
- `put` with an equal key replaces the value, as it does with String keys: the map has one B7 seat, and Ben holds it now.
- Seat's own hash code is worked out from its values, so it's the same on every run: `new Seat("B", 7).hashCode()` is always 2053, and it's fine to print. Only the default one, of a class without a `hashCode` of its own, is never printed in this course.

## Objects.hash

With more values, combining them by hand gets long. The class `Objects`, in `java.util`, has a method for it: `Objects.hash(...)` takes any number of values, and combines their hash codes with 31, much as String's `hashCode` combines its characters. Seat's `hashCode` could be:

```java
public int hashCode() {
    return Objects.hash(this.row, this.number);
}
```

- `Seat.java` then needs the line `import java.util.Objects;` at the top, just as a class that uses `ArrayList` needs its import.
- Give it the same values that `equals` compares. It takes numbers as well as objects.
- It doesn't give the same number as the hand-written version (for B7 it's 3014), and it doesn't need to: any `hashCode` that follows the rule works.
- A value that's `null` counts as 0, where `this.row.hashCode()` would crash with a NullPointerException.

## Letting the editor write them

Writing `equals` and `hashCode` is routine enough that most Java editors, such as IntelliJ IDEA, Eclipse and NetBeans, can generate both from the instance variables you pick, each with a line `@Override` above it, which module 34 explains. However they're written, write them together: Java's documentation of `equals` says that a class with its own `equals` generally needs its own `hashCode` too.

---

Source: [Writing hashCode](https://javaarena.com/learn/equals-hashcode/writing-hashcode/) in the module [Comparing objects: equals and hashCode](https://javaarena.com/learn/equals-hashcode/) on Java Arena.

This module follows section [8.3 Similarity of objects](https://java-programming.mooc.fi/part-8/3-similarity-of-objects) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
