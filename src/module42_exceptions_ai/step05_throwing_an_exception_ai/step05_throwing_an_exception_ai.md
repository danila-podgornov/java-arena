> [!info] AI-Generated

# Throwing an exception

So far every exception came from one of Java's own methods. Your own methods and constructors can throw one too, with `throw`. That's how a class refuses values it can't work with.

## Refusing a bad value

A bank transfer moves money from one person to another. A transfer of -40 dollars would move money the wrong way, so this class refuses to create one:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Transfer rent = new Transfer("Maya", "Leo", 400);
        System.out.println(rent);
        Transfer odd = new Transfer("Maya", "Leo", -40);
        System.out.println(odd);
    }
}
```

**Transfer.java**

```java
public class Transfer {
    private String from;
    private String to;
    private int amount;

    public Transfer(String from, String to, int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("The amount must be positive, not " + amount);
        }
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return this.from + " -> " + this.to + ": " + this.amount + " dollars";
    }
}
```

**Output**

```text
Maya -> Leo: 400 dollars
```

**The program crashes with**

```text
Exception in thread "main" java.lang.IllegalArgumentException: The amount must be positive, not -40
	at Transfer.<init>(Transfer.java:8)
	at Main.main(Main.java:5)
```

- `new IllegalArgumentException("...")` creates an exception object, like any other `new`. The text becomes its message.
- `throw` throws it. The constructor stops on that line, a bit like `return`, and the exception goes to the code that called it. Here that's `main`, which doesn't catch it, so the program stops.
- In the stack trace, `Transfer.<init>` is the constructor: `<init>` is how a stack trace names one.
- The check comes first, before any instance variable is set, and the exception stops the constructor, so no transfer of -40 is ever made: `odd` never gets a value. An object that refuses bad values can't end up in an impossible state.

**IllegalArgumentException** is Java's exception for exactly this: a method or constructor was given a parameter value it can't accept. It's a RuntimeException, so it's unchecked: neither the constructor nor the code that calls it needs a `throws`. A good message says what was wrong, and includes the value that was refused.

## Catching it

The code that creates the transfers decides what a refusal means. Here the amounts come from an array, and a refused one is reported and skipped:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        int[] amounts = {120, 0, 35, -8};
        int sent = 0;
        for (int amount : amounts) {
            try {
                Transfer transfer = new Transfer("Maya", "Leo", amount);
                System.out.println("Sent: " + transfer);
                sent += amount;
            } catch (IllegalArgumentException e) {
                System.out.println("Refused: " + e.getMessage());
            }
        }
        System.out.println("Sent in all: " + sent + " dollars");
    }
}
```

**Transfer.java**

```java
public class Transfer {
    private String from;
    private String to;
    private int amount;

    public Transfer(String from, String to, int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("The amount must be positive, not " + amount);
        }
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return this.from + " -> " + this.to + ": " + this.amount + " dollars";
    }
}
```

**Output**

```text
Sent: Maya -> Leo: 120 dollars
Refused: The amount must be positive, not 0
Sent: Maya -> Leo: 35 dollars
Refused: The amount must be positive, not -8
Sent in all: 155 dollars
```

`e.getMessage()` is the text the exception was given when it was created.

## In a method

Methods check their parameters the same way. A small concert hall has its seats numbered from 1 up, and a seat can be reserved once. Reserving a seat that doesn't exist is a bad parameter. Reserving a seat that's already taken is a different problem: the number is fine, just not now. Java has an exception for that too, **IllegalStateException**: the object isn't in a state where it can do what was asked. It's unchecked as well.

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        SeatMap hall = new SeatMap(20);
        int[] requests = {5, 25, 5, 6};
        for (int seat : requests) {
            try {
                hall.reserve(seat);
                System.out.println("Seat " + seat + " is yours");
            } catch (IllegalArgumentException e) {
                System.out.println("Check the number: " + e.getMessage());
            } catch (IllegalStateException e) {
                System.out.println("Sorry: " + e.getMessage());
            }
        }
        System.out.println(hall.free() + " seats left");
    }
}
```

**SeatMap.java**

```java
public class SeatMap {
    private boolean[] taken;

    public SeatMap(int seats) {
        this.taken = new boolean[seats];
    }

    public void reserve(int seat) {
        if (seat < 1 || seat > this.taken.length) {
            throw new IllegalArgumentException("there's no seat " + seat);
        }
        if (this.taken[seat - 1]) {
            throw new IllegalStateException("seat " + seat + " is taken");
        }
        this.taken[seat - 1] = true;
    }

    public int free() {
        int count = 0;
        for (boolean seatTaken : this.taken) {
            if (!seatTaken) {
                count++;
            }
        }
        return count;
    }
}
```

**Output**

```text
Seat 5 is yours
Check the number: there's no seat 25
Sorry: seat 5 is taken
Seat 6 is yours
18 seats left
```

- Both checks come before the seat is marked as taken, so a refused call changes nothing. Check first, then change.
- `reserve` returns nothing. When it returns normally, the reservation worked; when it can't do its job, it throws. A method could return `false` instead, but a return value is easy to ignore by accident. An exception isn't: if nothing catches it, the program stops.

---

Source: [Throwing an exception](https://javaarena.com/learn/exceptions/throwing-exceptions/) in the module [Exceptions](https://javaarena.com/learn/exceptions/) on Java Arena.

This module follows section [11.3 Exceptions](https://java-programming.mooc.fi/part-11/3-exceptions) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
