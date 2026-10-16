> [!info] AI-Generated

# Exceptions and resources

Module 20 read files with a Scanner in `try (...)`, and said that this form of `try` closes the file. This step looks at what that means, and when it happens.

## Resources

An open file is a **resource**: something a program borrows from the operating system while it uses it, and gives back when it's done, by **closing** it. Until then the system keeps the file marked as in use. On some systems another program can't change or delete a file while it's open, and a program that opens files without closing them can run out of files it's allowed to have open at once. Everything a program has open is closed when it ends, but some programs, such as a web server, run for months.

A Scanner that reads a file has a method `close()`, and try-with-resources calls it for you:

```java
try (Scanner scanner = new Scanner(Paths.get("settings.txt"))) {
    // read with the scanner
} catch (Exception e) {
    // the reading failed
}
```

- The **resource** is created in the parentheses after `try`. It exists only inside the `try` block.
- When the `try` block ends, Java calls the resource's `close()`, however the block ends: after its last line, with a `return`, or with an exception.
- When an exception comes out of the `try` block, the resource is closed first, and then the `catch` block runs.
- When creating the resource fails, for example because there's no such file, there's no Scanner to close, and Java goes straight to the `catch` block.
- A try-with-resources needs no `catch` block at all when its method passes the exception on with `throws IOException`. The file is closed all the same, and the exception goes on to the caller.

## Seeing it happen

Closing a Scanner prints nothing, so here's a class whose `close()` does. An object can be a resource when its class implements Java's interface `AutoCloseable`, which has one method, `close()`. The Scanner's class implements it, and so does this faucet, which turns the water on when it's created and off when it's closed:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        try (Faucet faucet = new Faucet("kitchen")) {
            System.out.println("Filling the kettle");
            int cups = Integer.parseInt("four");
            System.out.println("Filled " + cups + " cups");
        } catch (NumberFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Done");
    }
}
```

**Faucet.java**

```java
public class Faucet implements AutoCloseable {
    private String room;

    public Faucet(String room) {
        this.room = room;
        System.out.println("Water on in the " + room);
    }

    @Override
    public void close() {
        System.out.println("Water off in the " + this.room);
    }
}
```

**Output**

```text
Water on in the kitchen
Filling the kettle
Water off in the kitchen
Error: For input string: "four"
Done
```

The water goes off before the `catch` block runs: the resource is closed as soon as the `try` block ends. (You won't need resources of your own in this course: Java's own, such as the Scanner, already implement AutoCloseable.)

Several resources can go in the parentheses, separated by semicolons. They're closed in the opposite order: the one created last is closed first.

## Returning from inside

Because the resource is closed however the block ends, a method can `return` from the middle of a try-with-resources. This one returns the first line of a file that starts with a given text. When it finds the line, it returns at once, and the file is closed on the way out:

**The file settings.txt**

```text
volume=7
theme=dark
```

```java
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(findLine("settings.txt", "theme"));
        System.out.println(findLine("settings.txt", "language"));
        System.out.println(findLine("colors.txt", "theme"));
    }

    public static String findLine(String fileName, String start) {
        try (Scanner scanner = new Scanner(Paths.get(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.startsWith(start)) {
                    return line;
                }
            }
        } catch (Exception e) {
            return "no file " + fileName;
        }
        return "none";
    }
}
```

**Output**

```text
theme=dark
none
no file colors.txt
```

## The long way

Before try-with-resources came to Java (in version 7), programs closed their files themselves, in a `finally` block, so that it happened even after an exception:

```java
Scanner scanner = new Scanner(Paths.get("settings.txt"));
try {
    while (scanner.hasNextLine()) {
        System.out.println(scanner.nextLine());
    }
} finally {
    scanner.close();
}
```

You'll still see this in older code. try-with-resources does the same with less to write, and nothing to forget.

## Not the keyboard

One Scanner never goes in a try-with-resources: `new Scanner(System.in)`. Closing it closes `System.in` too, and after that the program can't read the keyboard any more, not even with a new Scanner. The keyboard isn't a file the program borrowed, so leave that Scanner open.

---

Source: [Exceptions and resources](https://javaarena.com/learn/exceptions/try-with-resources/) in the module [Exceptions](https://javaarena.com/learn/exceptions/) on Java Arena.

This module follows section [11.3 Exceptions](https://java-programming.mooc.fi/part-11/3-exceptions) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
