> [!info] AI-Generated

# Several constructors

Some objects are nearly always made the same way. At a café, most coffee orders are for a medium cup, so writing `"medium"` in every order gets tiresome. A class can have more than one constructor, and `new` picks the one that fits:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        CoffeeOrder first = new CoffeeOrder("latte");
        CoffeeOrder second = new CoffeeOrder("mocha", "large");
        System.out.println(first);
        System.out.println(second);
    }
}
```

**CoffeeOrder.java**

```java
public class CoffeeOrder {
    private String drink;
    private String size;

    public CoffeeOrder(String drink) {
        this.drink = drink;
        this.size = "medium";
    }

    public CoffeeOrder(String drink, String size) {
        this.drink = drink;
        this.size = size;
    }

    public String toString() {
        return this.size + " " + this.drink;
    }
}
```

**Output**

```text
medium latte
large mocha
```

- Both constructors have the class's name, but different parameters. Constructors like these are called **overloaded** constructors.
- Java picks the constructor whose parameters fit the values in `new`. `new CoffeeOrder("latte")` gives one String, so it runs the first constructor. `new CoffeeOrder("mocha", "large")` gives two, so it runs the second. Values that fit no constructor, as in `new CoffeeOrder(2)`, don't compile.
- The first constructor fills in a **default value**: the size used when the order doesn't say one.

## A constructor without parameters

Module 17 showed that Java adds a default constructor, without parameters, only to a class that has no constructor of its own. `CoffeeOrder` has two, so `new CoffeeOrder()` doesn't compile. If the café wants a quick way to order "the usual", the class needs a third constructor, written out:

```java
public CoffeeOrder() {
    this.drink = "filter coffee";
    this.size = "medium";
}
```

A class can have as many constructors as it needs, in any order.

## What makes constructors different

Constructors must differ in their **parameter types**: in the number of parameters, in their types, or in the order of the types. The parameter names don't count. Say the café wants a constructor for a drink and a kind of milk. It takes two Strings, just like the one for a drink and a size, so a call such as `new CoffeeOrder("tea", "oat")` couldn't say which one it meant. javac doesn't wait for such a call: it rejects the second constructor itself, even in a program that never uses it:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("The café is open");
    }
}
```

**CoffeeOrder.java**

```java
public class CoffeeOrder {
    private String drink;
    private String size;
    private String milk;

    public CoffeeOrder(String drink, String size) {
        this.drink = drink;
        this.size = size;
        this.milk = "none";
    }

    public CoffeeOrder(String drink, String milk) {
        this.drink = drink;
        this.size = "medium";
        this.milk = milk;
    }
}
```

**What javac prints**

```text
CoffeeOrder.java:12: error: constructor CoffeeOrder(String,String) is already defined in class CoffeeOrder
    public CoffeeOrder(String drink, String milk) {
           ^
1 error
```

`CoffeeOrder(String,String)` is the constructor as javac sees it: only the types, no names. A constructor for a drink, a size and a milk, `CoffeeOrder(String drink, String size, String milk)`, would be fine, since it takes three values.

---

Source: [Several constructors](https://javaarena.com/learn/class-design/several-constructors/) in the module [Designing classes and overloading](https://javaarena.com/learn/class-design/) on Java Arena.

This module follows sections [5.1 Learning object-oriented programming](https://java-programming.mooc.fi/part-5/1-learning-object-oriented-programming), [5.2 Removing repetitive code (overloading methods and constructors)](https://java-programming.mooc.fi/part-5/2-method-and-constructor-overloading) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
