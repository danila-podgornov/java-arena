> [!info] AI-Generated

# An interface as a parameter's type

A watch shop sells products, such as straps and alarm clocks, and it does repairs, which cost 2 dollars a minute. A product and a repair have little in common: a product has a name and a fixed price, and a repair has minutes of work. But at the checkout, both need a line on the receipt and a price. That's an interface:

```java
public interface Priced {
    String label();
    int price();
}
```

A method whose parameter has the type Priced accepts both:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Product strap = new Product("Watch strap", 12);
        Repair repair = new Repair(25);
        printLine(strap);
        printLine(repair);
        printLine(new Product("Alarm clock", 45));
    }

    public static void printLine(Priced item) {
        System.out.println(item.label() + ": " + item.price() + " dollars");
    }
}
```

**Priced.java**

```java
public interface Priced {
    String label();
    int price();
}
```

**Product.java**

```java
public class Product implements Priced {
    private String name;
    private int dollars;

    public Product(String name, int dollars) {
        this.name = name;
        this.dollars = dollars;
    }

    @Override
    public String label() {
        return this.name;
    }

    @Override
    public int price() {
        return this.dollars;
    }
}
```

**Repair.java**

```java
public class Repair implements Priced {
    private int minutes;

    public Repair(int minutes) {
        this.minutes = minutes;
    }

    @Override
    public String label() {
        return "Repair, " + this.minutes + " minutes";
    }

    @Override
    public int price() {
        return 2 * this.minutes;
    }
}
```

**Output**

```text
Watch strap: 12 dollars
Repair, 25 minutes: 50 dollars
Alarm clock: 45 dollars
```

- `printLine`'s parameter has the type Priced, so the method accepts an object of any class that implements Priced. The call `printLine(strap)` works as if it said `Priced item = strap;`, which compiles because a Product is a Priced.
- Inside the method, `item` is a Priced variable, like step 3's `device`. The method may call `label()` and `price()`, and each object runs its own: the product gives its fixed price, the repair works its price out from the minutes.

## One method for every kind of item

Without the interface, `printLine` would need two versions, `printLine(Product item)` and `printLine(Repair item)`, with the same code in each (overloading, module 21). Every new thing the shop sells would need one more.

With the interface, `printLine` is written once, and it depends only on what it uses: a label and a price. When the shop starts engraving watches, a new class `Engraving` that implements Priced works with `printLine` at once, without any change to it. The last challenge of this step shows that.

Java's own classes work this way too. `System.out.println` can print any object because it has a version whose parameter's type is Object, and step 6 shows that `Collections.sort` takes an interface.

---

Source: [An interface as a parameter's type](https://javaarena.com/learn/interfaces/parameter-type/) in the module [Interfaces](https://javaarena.com/learn/interfaces/) on Java Arena.

This module follows section [9.2 Interfaces](https://java-programming.mooc.fi/part-9/2-interface) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
