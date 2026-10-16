> [!info] AI-Generated

# Equal objects

## == compares references

When are two objects the same? Here are two theater seats, both in row B, seat 7:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Seat mine = new Seat("B", 7);
        Seat yours = new Seat("B", 7);
        Seat same = mine;
        System.out.println(mine == yours);
        System.out.println(mine == same);
        System.out.println(mine.equals(yours));
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

    public String toString() {
        return this.row + this.number;
    }
}
```

**Output**

```text
false
true
false
```

- As in module 22, `==` on two objects asks whether both variables refer to the **same object**. `mine` and `yours` were made by two `new`s, so they're two objects, even though what's in them is the same. `Seat same = mine;` copies the reference, so `mine == same` is true.
- Seat has no method called `equals`, yet `mine.equals(yours)` compiles. Every class gets a few methods from Java without writing them, among them `toString` and `equals`. The `toString` it gets gives the class name and a code (module 18), and the `equals` it gets does the same as `==`.

You've met this with Strings: `==` asks whether two Strings are the same object, while `equals` compares their letters. That's why text is always compared with `equals`. To make `equals` compare the contents of your own objects, the class writes its own `equals`, just as it writes its own `toString`.

## Writing equals

Two seats are equal when they have the same row and the same number. Here's the `equals` method for Seat:

```java
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
```

Line by line:

- The header must be exactly `public boolean equals(Object compared)`. `Object` is Java's type for any object at all, so `equals` can be given a Seat, a String, a list or anything else. Java's own methods, such as a list's `contains` in the next step, use only an `equals` with exactly this header. (The parameter's name can be anything; `compared` is a common one.)
- `if (this == compared)`: when it's the very same object, it's certainly equal, and nothing else needs checking.
- `compared instanceof Seat` is true when `compared` is a Seat object. Anything else, such as a String, can't be equal to a seat, so the method returns `false`. `instanceof` is false for `null` too, so `seat.equals(null)` gives `false` without a crash.
- `Seat other = (Seat) compared;` is a **cast**. `compared` is a Seat, but its type says only `Object`, and an Object has no `row` or `number`. The cast lets the code use it as a Seat. It's safe here, because the line before made sure it is one.
- The last line compares the contents: Strings with `equals`, numbers with `==`. As in the previous step, `other.row` may read the private variables, because this code is in the Seat class.

With the method in the class:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Seat mine = new Seat("B", 7);
        Seat yours = new Seat("B", 7);
        Seat next = new Seat("B", 8);
        System.out.println(mine == yours);
        System.out.println(mine.equals(yours));
        System.out.println(mine.equals(next));
        System.out.println(mine.equals("B7"));
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
false
false
```

`==` still says `false`: `mine` and `yours` are two objects. But `equals` now compares what's in them, and says they're equal. A String is never equal to a seat, even when it looks like the seat printed out: `"B7"` doesn't pass the `instanceof` check.

What counts as equal is up to the class. Two seats are equal when the row and the number match. A class for library members might say two members are equal when their membership numbers match, whatever names they were written down with.

Newer versions of Java can do the `instanceof` check and the cast in one go (`compared instanceof Seat other`), but in this course they're written as two separate steps.

---

Source: [Equal objects](https://javaarena.com/learn/object-interaction/equals/) in the module [Objects working together](https://javaarena.com/learn/object-interaction/) on Java Arena.

This module follows sections [5.4 Objects and references](https://java-programming.mooc.fi/part-5/4-objects-and-references), [5.5 Conclusion](https://java-programming.mooc.fi/part-5/5-conclusion) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
