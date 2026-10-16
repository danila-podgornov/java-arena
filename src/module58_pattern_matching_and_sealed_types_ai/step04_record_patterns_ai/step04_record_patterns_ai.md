> [!info] AI-Generated

# Record patterns

A type pattern gives you the whole object, and you then read its values with accessors. Since Java 21, a pattern can also take a record apart: a **record pattern** names the record and, in parentheses, a pattern for each of its components.

## Taking a record apart

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        System.out.println(receipt(new Cash(450)));
        System.out.println(receipt(new BankCard("4921", 1250)));
        System.out.println(receipt(new Voucher("SPRING10", 1000)));
    }

    public static String receipt(Payment payment) {
        return switch (payment) {
            case Cash(int cents) -> "Cash: " + cents + " cents";
            case BankCard(String digits, int cents) -> "Card ending " + digits + ": " + cents + " cents";
            case Voucher(String code, int cents) -> "Voucher " + code + ": " + cents + " cents";
        };
    }
}
```

**Payment.java**

```java
public sealed interface Payment permits Cash, BankCard, Voucher {
}
```

**Cash.java**

```java
public record Cash(int cents) implements Payment {
}
```

**BankCard.java**

```java
public record BankCard(String lastDigits, int cents) implements Payment {
}
```

**Voucher.java**

```java
public record Voucher(String code, int cents) implements Payment {
}
```

**Output**

```text
Cash: 450 cents
Card ending 4921: 1250 cents
Voucher SPRING10: 1000 cents
```

`BankCard(String digits, int cents)` matches a BankCard, and declares a variable for each component, filled in from the accessors: `digits` gets the value of `lastDigits()`, and `cents` of `cents()`.

- The components are matched **by their position**, not by name: the first variable gets the first component. The names are yours to choose, as `digits` shows.
- The types must fit the components' types. In place of a type, `var` (module 57) lets javac take the component's own type: `case BankCard(var digits, var cents)`.
- Every component gets a pattern, even one the case doesn't use.

Record patterns work after `instanceof` too, and can be combined with `&&` like type patterns:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Payment[] today = {new Voucher("SPRING10", 1000), new Cash(450), new Voucher("BIG50", 5000)};
        for (Payment payment : today) {
            if (payment instanceof Voucher(String code, int cents) && cents >= 5000) {
                System.out.println("Check the voucher " + code + " by hand");
            }
        }
    }
}
```

**Payment.java**

```java
public sealed interface Payment permits Cash, BankCard, Voucher {
}
```

**Cash.java**

```java
public record Cash(int cents) implements Payment {
}
```

**BankCard.java**

```java
public record BankCard(String lastDigits, int cents) implements Payment {
}
```

**Voucher.java**

```java
public record Voucher(String code, int cents) implements Payment {
}
```

**Output**

```text
Check the voucher BIG50 by hand
```

In a switch, a `when` guard can use the pattern's variables the same way. The guarded case comes before the plain one, so a big voucher stops at the first case:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Payment[] today = {new Voucher("SPRING10", 1000), new Cash(450), new Voucher("BIG50", 5000)};
        for (Payment payment : today) {
            System.out.println(describe(payment));
        }
    }

    public static String describe(Payment payment) {
        return switch (payment) {
            case Voucher(String code, int cents) when cents >= 5000 -> "Check the voucher " + code + " by hand";
            case Voucher(String code, int cents) -> "Voucher " + code;
            case Cash(int cents) -> "Cash";
            case BankCard(String digits, int cents) -> "Card " + digits;
        };
    }
}
```

**Payment.java**

```java
public sealed interface Payment permits Cash, BankCard, Voucher {
}
```

**Cash.java**

```java
public record Cash(int cents) implements Payment {
}
```

**BankCard.java**

```java
public record BankCard(String lastDigits, int cents) implements Payment {
}
```

**Voucher.java**

```java
public record Voucher(String code, int cents) implements Payment {
}
```

**Output**

```text
Voucher SPRING10
Cash
Check the voucher BIG50 by hand
```

## Patterns inside patterns

A component's pattern can itself be a record pattern or a type pattern. A café order holds the item and its payment, and one switch can look at both at once:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        System.out.println(note(new Order("cake", new Voucher("SPRING10", 1000))));
        System.out.println(note(new Order("tea", new BankCard("4921", 320))));
        System.out.println(note(new Order("bun", new Cash(250))));
    }

    public static String note(Order order) {
        return switch (order) {
            case Order(String item, Voucher(String code, int cents)) -> item + " paid with voucher " + code;
            case Order(String item, BankCard(var digits, var cents)) -> item + " paid with card " + digits;
            case Order(String item, Payment other) -> item + " paid";
        };
    }
}
```

**Order.java**

```java
public record Order(String item, Payment payment) {
}
```

**Payment.java**

```java
public sealed interface Payment permits Cash, BankCard, Voucher {
}
```

**Cash.java**

```java
public record Cash(int cents) implements Payment {
}
```

**BankCard.java**

```java
public record BankCard(String lastDigits, int cents) implements Payment {
}
```

**Voucher.java**

```java
public record Voucher(String code, int cents) implements Payment {
}
```

**Output**

```text
cake paid with voucher SPRING10
tea paid with card 4921
bun paid
```

The last case, `Order(String item, Payment other)`, matches every order, so the switch is exhaustive.

## Records that hold their own kind

A record of a sealed interface can have a component of that same interface. Then one object can hold another, which holds another, and a method that takes them apart calls itself (module 55). A present can be a gift, or something wrapped in paper around another present:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Present box = new Wrapped("red", new Wrapped("gold", new Gift("a scarf")));
        System.out.println(unwrap(box));
    }

    public static String unwrap(Present present) {
        return switch (present) {
            case Gift(String name) -> name;
            case Wrapped(String paper, Present inside) -> paper + " paper, then " + unwrap(inside);
        };
    }
}
```

**Present.java**

```java
public sealed interface Present permits Gift, Wrapped {
}
```

**Gift.java**

```java
public record Gift(String name) implements Present {
}
```

**Wrapped.java**

```java
public record Wrapped(String paper, Present inside) implements Present {
}
```

**Output**

```text
red paper, then gold paper, then a scarf
```

The base case is the Gift, which holds no other present. The last challenge of this module builds a calculator on the same idea.

---

Source: [Record patterns](https://javaarena.com/learn/sealed-and-patterns/record-patterns/) in the module [Pattern matching and sealed types](https://javaarena.com/learn/sealed-and-patterns/) on Java Arena.

An extra module, not part of the University of Helsinki's course. Lesson text: [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/).
