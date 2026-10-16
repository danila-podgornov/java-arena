> [!info] AI-Generated

# One constructor calling another

The two constructors of `CoffeeOrder` in step 3 repeat each other: both store a drink and a size. That's only two lines, but setting up an object often takes more. Say the café adds a rule: it only has small, medium and large cups, and any other size is made a medium. With every constructor setting up the object on its own, a rule like that has to be written into each of them, and so does every instance variable the class gets later.

Instead, a constructor can hand the work to another constructor of the same class, with `this(...)`:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        System.out.println(new CoffeeOrder("latte", "large"));
        System.out.println(new CoffeeOrder("tea", "huge"));
        System.out.println(new CoffeeOrder("mocha"));
        System.out.println(new CoffeeOrder());
    }
}
```

**CoffeeOrder.java**

```java
public class CoffeeOrder {
    private String drink;
    private String size;

    public CoffeeOrder(String drink, String size) {
        this.drink = drink;
        if (size.equals("small") || size.equals("large")) {
            this.size = size;
        } else {
            this.size = "medium";
        }
    }

    public CoffeeOrder(String drink) {
        this(drink, "medium");
    }

    public CoffeeOrder() {
        this("filter coffee");
    }

    public String toString() {
        return this.size + " " + this.drink;
    }
}
```

**Output**

```text
large latte
medium tea
medium mocha
medium filter coffee
```

- `this(drink, "medium");` runs the constructor that takes two Strings, with the drink and the default size. That constructor sets up the object, and the one-parameter constructor has nothing else to do.
- `this("filter coffee");` runs the one-parameter constructor, which in turn runs the two-parameter one. However an order is made, it goes through the same code, so the size rule is written once.
- Java picks the constructor for `this(...)` the same way as for `new`: by the values in the parentheses.

`this(...)` and `this.size` look alike but are different things. `this.size` is the object's instance variable. `this` with parentheses right after it runs another constructor on the same object, the one being built. It doesn't make a new object. Writing `new CoffeeOrder(drink, "medium");` inside a constructor would build a second, separate order and throw it away, and the order being built would get no drink at all.

## It must come first

`this(...)` can only be used in a constructor, and it must be the constructor's first statement. Anything before it is an error:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        CoffeeOrder order = new CoffeeOrder("latte");
    }
}
```

**CoffeeOrder.java**

```java
public class CoffeeOrder {
    private String drink;
    private String size;

    public CoffeeOrder(String drink, String size) {
        this.drink = drink;
        this.size = size;
    }

    public CoffeeOrder(String drink) {
        System.out.println("New order");
        this(drink, "medium");
    }
}
```

**What javac prints**

```text
CoffeeOrder.java:12: error: call to this must be first statement in constructor
        this(drink, "medium");
            ^
1 error
```

After `this(...)`, a constructor may do more: its other lines run once the other constructor has finished.

---

Source: [One constructor calling another](https://javaarena.com/learn/class-design/constructor-calling-constructor/) in the module [Designing classes and overloading](https://javaarena.com/learn/class-design/) on Java Arena.

This module follows sections [5.1 Learning object-oriented programming](https://java-programming.mooc.fi/part-5/1-learning-object-oriented-programming), [5.2 Removing repetitive code (overloading methods and constructors)](https://java-programming.mooc.fi/part-5/2-method-and-constructor-overloading) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
