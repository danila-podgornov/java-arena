> [!info] AI-Generated

# The command program with a class

Here's the box office again. The state and the rules that guard it move into a class, `Concert`, and the part of `main` that reads commands only calls its methods:

**Main.java**

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Concert concert = new Concert(200);
        while (true) {
            System.out.print("> ");
            String command = scanner.nextLine();
            if (command.equals("quit")) {
                System.out.println("Box office closed");
                break;
            }
            if (command.equals("sell")) {
                int count = Integer.valueOf(scanner.nextLine());
                if (concert.sell(count)) {
                    System.out.println("Sold! Tickets left: " + concert.ticketsLeft());
                } else {
                    System.out.println("Sorry, tickets left: " + concert.ticketsLeft());
                }
            } else if (command.equals("refund")) {
                int count = Integer.valueOf(scanner.nextLine());
                if (concert.refund(count)) {
                    System.out.println("Refunded! Tickets left: " + concert.ticketsLeft());
                } else {
                    System.out.println("Sorry, tickets sold: " + concert.getSold());
                }
            } else if (command.equals("status")) {
                System.out.println("Sold: " + concert.getSold() + ", left: " + concert.ticketsLeft());
            } else {
                System.out.println("Unknown command: " + command);
            }
        }
    }
}
```

**Concert.java**

```java
public class Concert {
    private int seats;
    private int sold;

    public Concert(int seats) {
        this.seats = seats;
        this.sold = 0;
    }

    public boolean sell(int count) {
        if (this.sold + count > this.seats) {
            return false;
        }
        this.sold = this.sold + count;
        return true;
    }

    public boolean refund(int count) {
        if (count > this.sold) {
            return false;
        }
        this.sold = this.sold - count;
        return true;
    }

    public int getSold() {
        return this.sold;
    }

    public int ticketsLeft() {
        return this.seats - this.sold;
    }
}
```

**Input**

```text
sell
150
sell
80
sell
50
refund
20
refund
300
status
quit
```

**Output**

```text
> Sold! Tickets left: 50
> Sorry, tickets left: 50
> Sold! Tickets left: 0
> Refunded! Tickets left: 20
> Sorry, tickets sold: 180
> Sold: 180, left: 20
> Box office closed
```

- `Concert` keeps the state, `seats` and `sold`, in private instance variables, and its methods keep the rules. `sell` and `refund` return `true` when they did what was asked and `false` when they refused, so the caller knows which message to print. The class never reads or prints anything, as in module 25.
- The loop in `main` reads the commands and prints the answers. It no longer knows how the limits are checked: it asks `concert.sell(count)` and looks at the answer.
- The tickets left are worked out in one place, `ticketsLeft()`.
- `main` isn't much shorter than before. The gain isn't in the number of lines, but in where things are, as the next section shows.

## Why it helps

The procedural version made three changes hard. Here they are again.

**A second concert.** The hall adds an afternoon show with 120 seats. That's one more object:

```java
Concert afternoon = new Concert(120);
Concert evening = new Concert(200);
```

Each object has its own `seats` and `sold`, and both follow the same rules, written once in the class. In the procedural version, the afternoon show needed two more variables and a copy of every branch. This step's second challenge sells tickets for both shows.

**A new command.** Say the box office adds `one`, which sells a single ticket at the door. In the class version, its branch calls `concert.sell(1)`, and it can't skip the check, because the check is inside `sell`. Every command that sells tickets goes through the same method, so a rule written once holds for all of them.

**A test of the class alone.** The rules can be checked without the command loop, and without typing a single command. Here are two JUnit tests for them (module 26):

**Concert.java**

```java
public class Concert {
    private int seats;
    private int sold;

    public Concert(int seats) {
        this.seats = seats;
        this.sold = 0;
    }

    public boolean sell(int count) {
        if (this.sold + count > this.seats) {
            return false;
        }
        this.sold = this.sold + count;
        return true;
    }

    public boolean refund(int count) {
        if (count > this.sold) {
            return false;
        }
        this.sold = this.sold - count;
        return true;
    }

    public int getSold() {
        return this.sold;
    }

    public int ticketsLeft() {
        return this.seats - this.sold;
    }
}
```

**ConcertTest.java**

```java
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class ConcertTest {
    @Test
    public void cannotSellMoreThanTheSeats() {
        Concert concert = new Concert(10);
        concert.sell(8);
        assertFalse(concert.sell(3));
        assertEquals(2, concert.ticketsLeft());
    }

    @Test
    public void cannotRefundMoreThanWereSold() {
        Concert concert = new Concert(10);
        concert.sell(4);
        assertFalse(concert.refund(5));
        assertEquals(4, concert.getSold());
    }
}
```

**Output**

```text
ConcertTest: 2 tests
  cannotRefundMoreThanWereSold: passed
  cannotSellMoreThanTheSeats: passed
2 of 2 tests passed
```

In the procedural version, the same rules sat inside the loop, between a `nextLine` and a `println`, where no unit test could reach them on their own.

## Both styles in one program

Look at the class version once more. It isn't object-oriented all the way down. The command loop in `main` is a sequence of steps with a loop and ifs, and so is the body of `sell`: check the limit, change the count, return. That's procedural code. What the object adds is the organization: which data belongs together, and which code may change it.

That's how Java programs are usually written. Objects hold the data and the rules that guard it, and inside the methods, the code mostly runs step by step. A calculation that needs no data of its own often stays a static method, like `Math.max`, which takes two numbers and returns the larger one. And in a bigger program, the command loop would move into a user interface class that takes a Scanner, as in module 25, so that `main` only creates the objects.

There are other paradigms too. In **functional programming**, for example, a program is built from functions that compute new values from the values they're given, instead of changing variables step by step. Java supports parts of that style as well, with lambdas and streams, which come later in the course (MOOC part 10).

---

Source: [The command program with a class](https://javaarena.com/learn/paradigms/object-commands/) in the module [Procedural and object-oriented programs](https://javaarena.com/learn/paradigms/) on Java Arena.

This module follows section [7.1 Programming paradigms](https://java-programming.mooc.fi/part-7/1-programming-paradigms) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
