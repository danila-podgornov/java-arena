> [!info] AI-Generated

# Methods and factories

A record's body can hold methods, like a class's. They can read the components, and they're how a record does more than hold its values.

## Methods that use the components

A shop keeps prices in whole cents, so that adding them up never meets the rounding errors of `double`. A record for an amount of money:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Money coffee = new Money(350);
        Money bun = Money.euros(2, 5);
        Money order = coffee.plus(bun.times(2));
        System.out.println(coffee + " + 2 x " + bun + " = " + order);
        System.out.println(order.cents());
    }
}
```

**Money.java**

```java
public record Money(int cents) {
    public static Money euros(int euros, int cents) {
        return new Money(euros * 100 + cents);
    }

    public Money plus(Money other) {
        return new Money(this.cents + other.cents);
    }

    public Money times(int count) {
        return new Money(this.cents * count);
    }

    @Override
    public String toString() {
        int rest = this.cents % 100;
        String zero = "";
        if (rest < 10) {
            zero = "0";
        }
        return this.cents / 100 + "." + zero + rest + " EUR";
    }
}
```

**Output**

```text
3.50 EUR + 2 x 2.05 EUR = 7.60 EUR
760
```

- Inside the record, `this.cents` is the instance variable. `other.cents` works too, since `other` is a Money and the code is inside Money; `other.cents()` would be the same value.
- `plus` and `times` don't change anything. They return a **new** Money with the result, as String's `toUpperCase` returns a new String. `coffee` is still 3.50 after `plus`.
- A record may override `toString` (or `equals` and `hashCode`, though you rarely need to). Here the amount is shown as euros and cents, with a 0 before a cents value under 10.
- `euros` is a **static factory**: a static method that makes a record in another way than the constructor, `Money.euros(2, 5)` for 2 euros and 5 cents. Static methods, and static variables too, are allowed in a record.

## A record never changes

A method can't assign a component, since its instance variable is `final`:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Money price = new Money(350);
        price.add(new Money(205));
        System.out.println(price);
    }
}
```

**Money.java**

```java
public record Money(int cents) {
    public void add(Money other) {
        this.cents = this.cents + other.cents;
    }
}
```

**What javac prints**

```text
Money.java:3: error: cannot assign a value to final variable cents
        this.cents = this.cents + other.cents;
            ^
1 error
```

Nor can a record have instance variables of its own besides its components. Everything a record holds is in its header:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        System.out.println(new Money(350));
    }
}
```

**Money.java**

```java
public record Money(int cents) {
    private int timesUsed;
}
```

**What javac prints**

```text
Money.java:2: error: field declaration must be static
    private int timesUsed;
                ^
  (consider replacing field with record component)
1 error
```

## "Changing" one value: with-methods

To change one component, make a new record with that one value different and the others copied. Such methods are customarily named `with` and the component:

```java
public Money withCents(int newCents) {
    return new Money(newCents);
}
```

For a record with one component, that's just the constructor. With several components it saves the caller from copying all the others, as the second task below shows.

---

Source: [Methods and factories](https://javaarena.com/learn/records/methods-and-factories/) in the module [Records](https://javaarena.com/learn/records/) on Java Arena.

An extra module, not part of the University of Helsinki's course. Lesson text: [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/).
