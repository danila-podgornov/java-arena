> [!info] AI-Generated

# switch on sealed types

In module 57, a switch expression over an enum needed no `default` when it had a case for every constant. Since Java 21, a switch can also choose by an object's **type**, and a sealed interface's permitted types work like an enum's constants: when every one has a case, the switch is complete.

## Type patterns in case labels

The café's payments, now as records:

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
            case Cash cash -> "Cash: " + cash.cents() + " cents";
            case BankCard card -> "Card ending " + card.lastDigits() + ": " + card.cents() + " cents";
            case Voucher voucher -> "Voucher " + voucher.code() + ": " + voucher.cents() + " cents";
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

- `case Cash cash ->` has a type pattern, like the ones `instanceof` takes. The case matches when the payment is a Cash, and then `cash` is the payment as a Cash, for that case only.
- Java tries the cases from the top, and the first one that matches gives the value.
- There is no `default`, and none is needed: Payment is sealed, so javac knows that every payment is a Cash, a BankCard or a Voucher. A switch that covers every possible value is **exhaustive**.

The same choice with `instanceof` needs a last `return` for "none of these", which can never happen. The switch says exactly what the program means, and javac checks it.

## javac finds the switches to update

The café starts taking mobile payments. Someone adds `MobilePay` to the permits list and writes the record, but forgets the switch:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        System.out.println(receipt(new MobilePay("040 123 4567", 300)));
    }

    public static String receipt(Payment payment) {
        return switch (payment) {
            case Cash cash -> "Cash: " + cash.cents() + " cents";
            case BankCard card -> "Card ending " + card.lastDigits() + ": " + card.cents() + " cents";
            case Voucher voucher -> "Voucher " + voucher.code() + ": " + voucher.cents() + " cents";
        };
    }
}
```

**Payment.java**

```java
public sealed interface Payment permits Cash, BankCard, Voucher, MobilePay {
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

**MobilePay.java**

```java
public record MobilePay(String phone, int cents) implements Payment {
}
```

**What javac prints**

```text
Main.java:7: error: the switch expression does not cover all possible input values
        return switch (payment) {
               ^
1 error
```

In a large program, javac points at every switch that needs a case for the new type. With a `default` in them, the program would compile, and every mobile payment would quietly get whatever the default gives. So with sealed types, leave `default` out.

A switch *statement* (one that gives no value) with type patterns must cover every type too. And as with every switch, a `null` payment throws a NullPointerException; since Java 21 a switch can have `case null ->` for it, but it's usually better not to pass `null` around at all.

## Guards: case ... when

A case can have a condition after the word `when`. The case matches only when the type matches and the condition is true. A card payment over 50 euros needs the card's PIN:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        System.out.println(receipt(new BankCard("4921", 1250)));
        System.out.println(receipt(new BankCard("4921", 8900)));
        System.out.println(receipt(new Cash(8900)));
    }

    public static String receipt(Payment payment) {
        return switch (payment) {
            case Cash cash -> "Cash: " + cash.cents() + " cents";
            case BankCard card when card.cents() > 5000 -> "Card ending " + card.lastDigits() + ": " + card.cents() + " cents, PIN needed";
            case BankCard card -> "Card ending " + card.lastDigits() + ": " + card.cents() + " cents";
            case Voucher voucher -> "Voucher " + voucher.code() + ": " + voucher.cents() + " cents";
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
Card ending 4921: 1250 cents
Card ending 4921: 8900 cents, PIN needed
Cash: 8900 cents
```

A case with `when` doesn't count toward covering BankCard, since its condition can be false; the plain `case BankCard card` after it does. The order matters: the guarded case must come first. In the other order, the plain case would match every card, and the guarded one could never be reached. javac doesn't allow that:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        System.out.println(receipt(new BankCard("4921", 8900)));
    }

    public static String receipt(Payment payment) {
        return switch (payment) {
            case Cash cash -> "Cash: " + cash.cents() + " cents";
            case BankCard card -> "Card ending " + card.lastDigits() + ": " + card.cents() + " cents";
            case BankCard card when card.cents() > 5000 -> "Card ending " + card.lastDigits() + ": " + card.cents() + " cents, PIN needed";
            case Voucher voucher -> "Voucher " + voucher.code() + ": " + voucher.cents() + " cents";
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

**What javac prints**

```text
Main.java:10: error: this case label is dominated by a preceding case label
            case BankCard card when card.cents() > 5000 -> "Card ending " + card.lastDigits() + ": " + card.cents() + " cents, PIN needed";
                 ^
1 error
```

---

Source: [switch on sealed types](https://javaarena.com/learn/sealed-and-patterns/switch-on-types/) in the module [Pattern matching and sealed types](https://javaarena.com/learn/sealed-and-patterns/) on Java Arena.

An extra module, not part of the University of Helsinki's course. Lesson text: [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/).
