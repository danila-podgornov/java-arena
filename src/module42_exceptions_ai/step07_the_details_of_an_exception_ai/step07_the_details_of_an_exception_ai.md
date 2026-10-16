> [!info] AI-Generated

# The details of an exception

The `e` in `catch (NumberFormatException e)` is an object, and it knows more than its class. This last step is about what it can tell you, and how to read the report a crash leaves behind.

## getMessage, and printing e

```java
try {
    Integer.parseInt("12 kg");
} catch (NumberFormatException e) {
    System.out.println(e.getMessage());
    System.out.println(e);
}
int[] floors = {0, 1, 2};
try {
    System.out.println(floors[5]);
} catch (ArrayIndexOutOfBoundsException e) {
    System.out.println(e.getMessage());
}
IllegalArgumentException plain = new IllegalArgumentException();
System.out.println(plain.getMessage());
System.out.println(plain);
```

**Output**

```text
For input string: "12 kg"
java.lang.NumberFormatException: For input string: "12 kg"
Index 5 out of bounds for length 3
null
java.lang.IllegalArgumentException
```

- `e.getMessage()` returns the message: the text after the colon in a crash report.
- Printing `e` itself uses the exception's `toString`: its class, with the package, then a colon and the message. That's the first line of a crash report, without the `Exception in thread "main"` in front.
- An exception created without a message, such as `new IllegalArgumentException()`, has `null` as its message, and printing it shows only its class. That's one reason to always give your own exceptions a message.

Which one should a program show? Your own messages, such as `there's no seat 25`, are written for the people who use the program, so `getMessage()` fits them. Java's messages are written for programmers: `For input string: "12 kg"` doesn't tell a user what to do, so a program usually prints a text of its own instead, as the first step did. Printing `e` is handy while you hunt for a bug, since it names the kind of exception too.

## The stack trace

The `at` lines of a crash report are the **stack trace**: the methods that were running when the exception was created, the newest first. Each line names a class and a method, and in parentheses the file and the line. This program finds the last bus of the day from a list of departure times, and one of the times is written wrong:

```java
public class Main {
    public static void main(String[] args) {
        String[] departures = {"8:15", "9:40", "10h05"};
        System.out.println("Last departure: " + latest(departures));
    }

    public static int latest(String[] times) {
        int latest = 0;
        for (String time : times) {
            latest = Math.max(latest, minutesOf(time));
        }
        return latest;
    }

    public static int minutesOf(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
}
```

**The program crashes with**

```text
Exception in thread "main" java.lang.NumberFormatException: For input string: "10h05"
	at Main.minutesOf(Main.java:17)
	at Main.latest(Main.java:10)
	at Main.main(Main.java:4)
```

Read it from the top:

- `at Main.minutesOf(Main.java:17)`: the exception was thrown on line 17, in `minutesOf`, by `parseInt`. `10h05` has no colon, so `parts[0]` is the whole text.
- `at Main.latest(Main.java:10)`: `minutesOf` was called on line 10, in `latest`'s loop.
- `at Main.main(Main.java:4)`: and `latest` was called on line 4 of `main`, where it all started.

The top line says where it happened, and the lines below it say how the program got there. You can also read it from the bottom up, as the MOOC does: `main` called `latest`, which called `minutesOf`. The fix isn't always on the top line: here the mistake is in the data, `10h05`. On your own computer, lines from inside Java's own classes, which start with `at java.base/`, come first; skip them to the first line from your own code.

A `catch` block can print the whole report without stopping the program: `e.printStackTrace()`. It prints to the error stream, `System.err`, as a crash does. It's a tool for finding bugs; a finished program shows its users a message instead, so the programs of this course don't use it.

## An exception class of your own

Java's exceptions cover most needs, but a program can also define its own kind, as a class that extends Exception (for a checked one) or RuntimeException (for an unchecked one):

```java
public class SeatTakenException extends RuntimeException {
    public SeatTakenException(String message) {
        super(message);
    }
}
```

`super(message)` hands the message to the parent's constructor (module 34). After that, `throw new SeatTakenException("seat 5 is taken")` works like any other `throw`, and `catch (SeatTakenException e)` catches exactly this kind. This course won't need any: IllegalArgumentException and IllegalStateException say well enough what's wrong.

## What this module covered

- An exception is an object that describes a problem. It's thrown, travels up the call stack to a `catch` block for its class or a parent class, and stops the program with a report if nothing catches it.
- `try` holds the code that might throw. Several `catch` blocks go from the most specific class to the most general, and `finally` runs whatever happens.
- Checked exceptions, such as IOException, must be caught or declared with `throws`. Unchecked ones, RuntimeException and the classes below it, needn't be.
- try-with-resources closes a file, or any other AutoCloseable, as soon as its block ends.
- `throw new IllegalArgumentException("...")` refuses a bad parameter, before anything is changed.
- An interface's `throws` says what its implementations may throw: that, less, or nothing.
- `getMessage()` is the message, printing `e` adds the class, and the stack trace shows where it happened and how the program got there.

---

Source: [The details of an exception](https://javaarena.com/learn/exceptions/details-of-an-exception/) in the module [Exceptions](https://javaarena.com/learn/exceptions/) on Java Arena.

This module follows section [11.3 Exceptions](https://java-programming.mooc.fi/part-11/3-exceptions) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
