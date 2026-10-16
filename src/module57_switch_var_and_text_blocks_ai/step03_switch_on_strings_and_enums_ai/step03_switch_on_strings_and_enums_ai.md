> [!info] AI-Generated

# switch on strings and enums

## Strings

Since Java 7, a switch can choose by a String. The labels are String literals, and a label matches when the String `equals` it, exactly: capitals count, and so do spaces. A radio reads commands:

```java
Scanner scanner = new Scanner(System.in);
int volume = 5;
while (true) {
    String command = scanner.nextLine();
    if (command.equals("off")) {
        break;
    }
    switch (command) {
        case "louder" -> volume++;
        case "quieter" -> volume--;
        case "status" -> System.out.println("Volume " + volume);
        default -> System.out.println("Unknown command: " + command);
    }
}
System.out.println("Radio off at volume " + volume);
```

**Input**

```text
louder
louder
status
Quieter
off
```

**Output**

```text
Volume 7
Unknown command: Quieter
Radio off at volume 7
```

`Quieter` with a capital Q isn't `quieter`, so it goes to `default`. A program that should take both can switch on `command.toLowerCase()`.

The check for `off` stays an `if` before the switch, and here's why: inside a switch, `break` ends the switch, not the loop around it. A `break` in a case would leave the switch and go on reading commands.

One more thing to know: a switch on a String that is `null` throws a NullPointerException, as calling a method on it would.

## Enums

A switch on an enum (module 39) uses the constants' names as labels. A cinema's tickets come in three kinds:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        System.out.println(price(Ticket.CHILD));
        System.out.println(price(Ticket.ADULT) + price(Ticket.SENIOR));
    }

    public static int price(Ticket ticket) {
        return switch (ticket) {
            case CHILD -> 6;
            case ADULT -> 12;
            case SENIOR -> 8;
        };
    }
}
```

**Ticket.java**

```java
public enum Ticket {
    CHILD, ADULT, SENIOR
}
```

**Output**

```text
6
20
```

- A label is the constant's name alone, `case CHILD`, not `case Ticket.CHILD`: the switch already knows the enum. (Since Java 21 the long name is allowed too, but the short one is the custom.)
- This switch expression has no `default`, and it doesn't need one: an enum has only the values it lists, and the three cases cover them all, so javac knows the switch always gives a value.

## When the enum grows

Leaving out `default` pays off when someone adds a constant. Say the cinema starts selling STUDENT tickets:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        System.out.println(price(Ticket.STUDENT));
    }

    public static int price(Ticket ticket) {
        return switch (ticket) {
            case CHILD -> 6;
            case ADULT -> 12;
            case SENIOR -> 8;
        };
    }
}
```

**Ticket.java**

```java
public enum Ticket {
    CHILD, ADULT, SENIOR, STUDENT
}
```

**What javac prints**

```text
Main.java:7: error: the switch expression does not cover all possible input values
        return switch (ticket) {
               ^
1 error
```

javac points at every switch expression that has no case for STUDENT, and once each has one, the program is complete again. With `default -> 0;` in the switch, it would have compiled, and every student would have got in for free without anyone noticing. So for an enum, list every constant and leave `default` out.

A switch *statement* on an enum, with arrows or with colons, may leave constants out, like a switch statement on an int.

---

Source: [switch on strings and enums](https://javaarena.com/learn/switch-and-text/strings-and-enums/) in the module [switch, var and text blocks](https://javaarena.com/learn/switch-and-text/) on Java Arena.

An extra module, not part of the University of Helsinki's course. Lesson text: [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/).
