> [!info] AI-Generated

# Test input for a Scanner

Steps 1 and 5 of the checklist mean running a program again and again with the same input. Typing it every time is slow, and it's easy to type something a little different by mistake. Module 20 showed that a Scanner can read a String, and in module 25 the user interface was given its Scanner instead of making one. Put the two together, and any code that reads input can be tried with input written right in the code.

The trick is that the method that reads doesn't make its own Scanner: it gets one as a parameter. A hiker writes down the kilometers walked each day, one number per line, and an empty line ends the list:

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(totalKilometers(new Scanner("12\n8\n15\n")));
        System.out.println(totalKilometers(new Scanner("7\n\n30\n")));
        System.out.println(totalKilometers(new Scanner("")));
    }

    public static int totalKilometers(Scanner scanner) {
        int total = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                break;
            }
            total += Integer.valueOf(line);
        }
        return total;
    }
}
```

**Output**

```text
35
7
0
```

- Inside the quotes, `\n` is a line break, so `"12\n8\n15\n"` is three lines, just as if someone had typed 12, 8 and 15, pressing Enter after each.
- `"7\n\n30\n"` has an empty line after the 7, so the method stops there and never reads the 30.
- `""` has no lines at all, like input that ends right away. It's easy to write here, and awkward to try by typing.
- In the finished program, `main` gives the method the keyboard: `totalKilometers(new Scanner(System.in))`. The method works the same either way, because it only uses the Scanner it was given.

A method that makes its own `new Scanner(System.in)` inside can only ever read the keyboard. Taking the Scanner as a parameter is what makes it easy to try out.

## A check that says ok or wrong

Printing the results still means comparing them in your head, every time. Let the program do that too: give it the input and the result it should give, and have it print whether it did.

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        check("12\n8\n15\n", 35);
        check("7\n\n30\n", 7);
        check("", 0);
        check("5\n", 5);
    }

    public static void check(String input, int expected) {
        int result = totalKilometers(new Scanner(input));
        if (result == expected) {
            System.out.println("ok");
        } else {
            System.out.println("WRONG: expected " + expected + " but got " + result);
        }
    }

    public static int totalKilometers(Scanner scanner) {
        int total = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                break;
            }
            total += Integer.valueOf(line);
        }
        return total;
    }
}
```

**Output**

```text
ok
ok
ok
ok
```

Now any change to `totalKilometers` can be checked in a second. Say someone changes `break` to `continue`, to skip empty lines instead of stopping at them. Then the second check prints `WRONG: expected 7 but got 37`, and you know at once, without typing a single number.

Each call to `check` is a small **test**: an input, the result it should give, and a comparison. Tests like these, which check one method or one class on its own, are called **unit tests**. Writing a `check` method for every program gets tedious, though. The next step uses JUnit, a library that runs your tests, does the comparing, and keeps track of which tests passed and which failed.

---

Source: [Test input for a Scanner](https://javaarena.com/learn/unit-testing/test-input/) in the module [Troubleshooting and unit testing](https://javaarena.com/learn/unit-testing/) on Java Arena.

This module follows sections [6.3 Introduction to testing](https://java-programming.mooc.fi/part-6/3-introduction-to-testing), [6.4 Complex programs](https://java-programming.mooc.fi/part-6/4-complex-programs) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
