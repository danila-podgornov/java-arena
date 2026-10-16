> [!info] AI-Generated

# Methods that return a value

In module 17 the methods of your classes did something: they printed, or they changed the object's instance variables. They were all `void`. An object's method can also **return** a value, just like the methods of module 11. This basket counts its fruit:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Basket basket = new Basket();
        System.out.println(basket.isEmpty());
        basket.addApples(3);
        basket.addPears(2);
        int fruit = basket.total();
        System.out.println("Fruit in the basket: " + fruit);
        System.out.println(basket.isEmpty());
    }
}
```

**Basket.java**

```java
public class Basket {
    private int apples;
    private int pears;

    public Basket() {
        this.apples = 0;
        this.pears = 0;
    }

    public void addApples(int count) {
        this.apples = this.apples + count;
    }

    public void addPears(int count) {
        this.pears = this.pears + count;
    }

    public int total() {
        return this.apples + this.pears;
    }

    public boolean isEmpty() {
        return this.apples + this.pears == 0;
    }
}
```

**Output**

```text
true
Fruit in the basket: 5
false
```

- `public int total()` returns an `int`: the apples and pears of *this* basket added up. There's no `static` in the header, because the method belongs to an object and works with that object's own variables.
- In `main`, the call `basket.total()` stands for the value it returns. Here `main` stores it in `fruit`, but the call can go anywhere a value can: in a print line, a calculation or a comparison.
- `isEmpty()` returns a `boolean`, so its call works as a condition on its own: `if (basket.isEmpty()) { ... }`. A method that answers a yes-or-no question usually has a name that starts with `is` or `has`, such as `isEmpty` or `hasRoom`.

You've used methods like these on lists and strings: `list.size()` returns how many values a list has, and `word.isEmpty()` tells whether a string is empty. Now your own classes can have them too.

Why return the value instead of printing it? For the same reason as in module 11: the caller decides what to do with it. `main` can compare the totals of two baskets, add them up, or print them in its own words.

---

Source: [Methods that return a value](https://javaarena.com/learn/object-methods/returning-values/) in the module [Getters, toString and bigger classes](https://javaarena.com/learn/object-methods/) on Java Arena.

This module follows section [4.1 Introduction to object-oriented programming](https://java-programming.mooc.fi/part-4/1-introduction-to-object-oriented-programming) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
