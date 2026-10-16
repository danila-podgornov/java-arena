> [!info] AI-Generated

# When the file is missing

A program that reads a file depends on something outside itself: the file might not be there, it might have another name, or it might be in another folder. Java knows this, and it doesn't even compile code that opens a file without saying what to do if that fails:

```java
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(Paths.get("notes.txt"));
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
    }
}
```

**What javac prints**

```text
Main.java:6: error: unreported exception IOException; must be caught or declared to be thrown
        Scanner scanner = new Scanner(Paths.get("notes.txt"));
                          ^
1 error
```

An `IOException` is a failure in reading or writing data (I/O is short for input and output). Most exceptions, such as the `NumberFormatException` from module 16, can happen without warning; this kind is one that Java makes you plan for. `catch` is the plan. (The other option in the message, declaring it, comes later in the course.)

## try and catch

The `try` block holds the code that might fail. If a line in it throws an exception, Java leaves the `try` block right there and runs the `catch` block, instead of crashing. After the `catch` block, the program goes on as usual. Here there's no file `prices.txt` at all:

```java
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Reading the prices...");
        try (Scanner scanner = new Scanner(Paths.get("prices.txt"))) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            System.out.println("All prices read");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Bye!");
    }
}
```

**Output**

```text
Reading the prices...
Error: prices.txt
Bye!
```

- `catch (Exception e)` catches any exception. `e` is a variable that holds the exception, and `e.getMessage()` is its message. A missing file throws a `NoSuchFileException`, whose message is just the file's name: that's why the program prints `Error: prices.txt`. Your own text in the `catch` block, such as `Could not open prices.txt`, can say more.
- `All prices read` isn't printed: the rest of the `try` block is skipped.
- `Bye!` is printed: after the `catch` block, the program carries on.

## A message instead of a crash

`catch (Exception e)` catches every exception thrown inside its `try` block, not only the file's. A `try` without parentheses works for code that opens nothing:

```java
try {
    int number = Integer.valueOf("12a");
    System.out.println("Got " + number);
} catch (Exception e) {
    System.out.println("Error: " + e.getMessage());
}
System.out.println("Still running");
```

**Output**

```text
Error: For input string: "12a"
Still running
```

Without the `try`, the same line would crash the program with a `NumberFormatException`, as in module 16: Java's report, and nothing after it runs. With `catch`, your program decides what to say and keeps going.

---

Source: [When the file is missing](https://javaarena.com/learn/reading-files/when-the-file-is-missing/) in the module [Reading files](https://javaarena.com/learn/reading-files/) on Java Arena.

This module follows sections [4.3 Files and reading data](https://java-programming.mooc.fi/part-4/3-files-and-reading-data), [4.4 Summary](https://java-programming.mooc.fi/part-4/4-summary) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
