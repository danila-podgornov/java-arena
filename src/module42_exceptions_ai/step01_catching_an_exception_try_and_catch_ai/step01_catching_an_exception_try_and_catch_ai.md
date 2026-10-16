> [!info] AI-Generated

# Catching an exception: try and catch

You've met exceptions since module 12: a program gets to a line it can't carry out, and it stops with a report. Module 20 put file reading in a `try` block with a `catch` block after it. This module is all about exceptions: what they are, how to catch the ones you expect, which ones Java makes you plan for, and how your own classes can throw one.

## A crash, read slowly

This program asks for a height in centimeters and prints it in meters. The user typed a unit after the number:

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Height in centimeters?");
        int height = Integer.parseInt(scanner.nextLine());
        System.out.println("That's " + (height / 100.0) + " meters");
    }
}
```

**Input**

```text
180 cm
```

**Output**

```text
Height in centimeters?
```

**The program crashes with**

```text
Exception in thread "main" java.lang.NumberFormatException: For input string: "180 cm"
	at Main.main(Main.java:7)
```

`Integer.parseInt` can't turn `180 cm` into a number, and it can't return a made-up number either. So it **throws an exception**: it creates an object that describes the problem, and hands that object to the code that called it, in place of a return value. Nothing here catches it, so it goes on out of `main`, and Java stops the program and prints the report:

- `java.lang.NumberFormatException` is the exception's class, with its package in front (`java.lang` is the package of `String` and `Integer`). Exceptions are objects, and each kind of problem has a class of its own.
- `For input string: "180 cm"` is the exception's **message**, written by the code that threw it.
- `at Main.main(Main.java:7)` is the **stack trace**: where the program was when it happened. Line 7 is the `parseInt` line. On your own computer, Java also prints a few `at` lines from inside its own classes above this one (from inside `Integer.parseInt`, where the text was checked). The line to look for is the first one from your own code.

Everything after line 7 was skipped: the meters were never printed.

## try and catch

A program that reads what people type should expect text that isn't a number. `try` and `catch` let it decide what happens then:

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Height in centimeters?");
        String line = scanner.nextLine();
        try {
            int height = Integer.parseInt(line);
            System.out.println("That's " + (height / 100.0) + " meters");
        } catch (NumberFormatException e) {
            System.out.println("Please type just the number, like 172");
        }
        System.out.println("Thanks!");
    }
}
```

**Input**

```text
180 cm
```

**Output**

```text
Height in centimeters?
Please type just the number, like 172
Thanks!
```

- The `try` block holds the code that might throw. Java runs it line by line, as usual.
- When a line in it throws, the rest of the `try` block is skipped (here the line that prints the meters), and Java looks at the `catch` block. `catch (NumberFormatException e)` catches exceptions of the class NumberFormatException, so its block runs.
- `e` is a variable, a bit like a parameter, that holds the exception object. This `catch` block doesn't use it; the last step of this module shows what it can tell you.
- After the `catch` block, the program goes on as usual: `Thanks!` is printed.
- When nothing in the `try` block throws, the `catch` block is skipped. With the input `180`, the program prints `That's 1.8 meters` and `Thanks!`.

Module 20 wrote `catch (Exception e)`, which catches every kind of exception. `catch (NumberFormatException e)` catches only this kind, and that's often better: its message, "type just the number", fits this problem and no other. Any other exception still shows up as a crash with its report, instead of hiding behind a message that doesn't fit. The next step is about choosing what to catch.

`Integer.valueOf` throws a NumberFormatException for the same texts, and `Double.parseDouble` throws one for a text that isn't a decimal number, such as `1,80` with a comma.

## Asking again

In a loop, a caught exception can simply mean "try again". This method asks until the user types a whole number:

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int height = readHeight(scanner);
        System.out.println("That's " + (height / 100.0) + " meters");
    }

    public static int readHeight(Scanner scanner) {
        while (true) {
            System.out.println("Height in centimeters?");
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Not a whole number, try again");
            }
        }
    }
}
```

**Input**

```text
tall
1.80
180
```

**Output**

```text
Height in centimeters?
Not a whole number, try again
Height in centimeters?
Not a whole number, try again
Height in centimeters?
That's 1.8 meters
```

The `return` in the `try` block ends the method only when `parseInt` succeeds. When `parseInt` throws, the `return` never happens: the `catch` block prints its message, and the loop goes around again.

---

Source: [Catching an exception: try and catch](https://javaarena.com/learn/exceptions/try-and-catch/) in the module [Exceptions](https://javaarena.com/learn/exceptions/) on Java Arena.

This module follows section [11.3 Exceptions](https://java-programming.mooc.fi/part-11/3-exceptions) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
