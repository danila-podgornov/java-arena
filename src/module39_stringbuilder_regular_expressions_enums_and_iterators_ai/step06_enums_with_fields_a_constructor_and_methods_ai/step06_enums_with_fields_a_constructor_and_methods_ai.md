> [!info] AI-Generated

# Enums with fields, a constructor and methods

An enum is a class, one whose objects are all made in advance: its constants. So it can have what a class has: instance variables, a constructor and methods.

Module 21's CoffeeOrder kept its size in a String, `"medium"` unless the order said otherwise, and its constructor turned any size other than small, medium or large into a medium. As an enum, those three sizes are the only ones there are, and each one can carry its own volume and price:

**Main.java**

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        CupSize size = CupSize.MEDIUM;
        System.out.println(size + ": " + size.getMilliliters() + " ml, " + size.getPrice() + " dollars");

        ArrayList<CupSize> order = new ArrayList<>();
        order.add(CupSize.LARGE);
        order.add(CupSize.SMALL);
        order.add(CupSize.LARGE);
        int total = 0;
        for (CupSize cup : order) {
            total += cup.getPrice();
        }
        System.out.println(order + " cost " + total + " dollars");
    }
}
```

**CupSize.java**

```java
public enum CupSize {
    SMALL(250, 3),
    MEDIUM(350, 4),
    LARGE(450, 5);

    private int milliliters;
    private int price;

    private CupSize(int milliliters, int price) {
        this.milliliters = milliliters;
        this.price = price;
    }

    public int getMilliliters() {
        return this.milliliters;
    }

    public int getPrice() {
        return this.price;
    }
}
```

**Output**

```text
MEDIUM: 350 ml, 4 dollars
[LARGE, SMALL, LARGE] cost 13 dollars
```

- The constants come first, and each one gives the constructor its values in parentheses: `SMALL(250, 3)` makes the constant SMALL with the constructor call `CupSize(250, 3)`.
- A semicolon ends the list of constants. After it, the enum goes on like a class: instance variables, the constructor, methods.
- The constructor is `private`: only the constants use it. The first time the program uses the enum, all three constants are made together, in the order they're written, and never again. An enum's constructor can't be public, and `new CupSize(300, 4)` doesn't compile (javac says `enum classes may not be instantiated`). The three constants are all the CupSizes there will ever be.
- A method is called on a constant, or on a variable that holds one: `CupSize.LARGE.getPrice()`, `size.getMilliliters()`.
- The instance variables have getters and no setters, which is usual for an enum: a constant is shared by the whole program, so changing LARGE's price would change it everywhere at once.

## Methods that do more

An enum's methods can do anything a class's methods can. They can use the instance variables, `name()` and `ordinal()`, and `toString` can be overridden:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        for (CupSize size : CupSize.values()) {
            System.out.println(size + ": two cost " + size.priceFor(2) + " dollars");
        }
        System.out.println(CupSize.SMALL.holds(300) + " " + CupSize.LARGE.holds(300));
        System.out.println(CupSize.LARGE.name());
    }
}
```

**CupSize.java**

```java
public enum CupSize {
    SMALL(250, 3),
    MEDIUM(350, 4),
    LARGE(450, 5);

    private int milliliters;
    private int price;

    private CupSize(int milliliters, int price) {
        this.milliliters = milliliters;
        this.price = price;
    }

    public int priceFor(int cups) {
        return cups * this.price;
    }

    public boolean holds(int milliliters) {
        return milliliters <= this.milliliters;
    }

    @Override
    public String toString() {
        return this.name().toLowerCase() + " (" + this.milliliters + " ml)";
    }
}
```

**Output**

```text
small (250 ml): two cost 6 dollars
medium (350 ml): two cost 8 dollars
large (450 ml): two cost 10 dollars
false true
LARGE
```

- With its own `toString`, a constant prints as `small (250 ml)` instead of `SMALL`.
- `name()` still returns the constant's name as it's written in the enum, and the new `toString` uses it.

## The order of the constants

Every enum has a natural order, as in module 38: the order in which its constants are written. Enums implement `Comparable`, so `Collections.sort` puts a list of CupSizes from SMALL to LARGE, and `size.compareTo(CupSize.MEDIUM) > 0` asks whether a size comes after MEDIUM. Write the constants in the order that makes sense, such as smallest first.

---

Source: [Enums with fields, a constructor and methods](https://javaarena.com/learn/useful-techniques/enum-fields/) in the module [StringBuilder, regular expressions, enums and iterators](https://javaarena.com/learn/useful-techniques/) on Java Arena.

This module follows sections [10.3 Other useful techniques](https://java-programming.mooc.fi/part-10/3-other-useful-techniques), [10.4 Summary](https://java-programming.mooc.fi/part-10/4-summary) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
