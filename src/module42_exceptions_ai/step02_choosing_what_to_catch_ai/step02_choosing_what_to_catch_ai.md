> [!info] AI-Generated

# Choosing what to catch

A time of day such as `7:45` is easy for people to read. A program that compares or adds up times often turns it into a single number, the minutes after midnight: 7 hours and 45 minutes is 7 * 60 + 45 = 465. Two different things can go wrong on the way, and each throws its own exception:

```java
public class Main {
    public static void main(String[] args) {
        String[] times = {"7:45", "745", "7:4five"};
        for (String time : times) {
            try {
                String[] parts = time.split(":");
                int hours = Integer.parseInt(parts[0]);
                int minutes = Integer.parseInt(parts[1]);
                System.out.println(time + " is " + (hours * 60 + minutes) + " minutes after midnight");
            } catch (NumberFormatException e) {
                System.out.println(time + ": the hours and minutes must be numbers");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(time + ": write the time as hours:minutes");
            }
        }
    }
}
```

**Output**

```text
7:45 is 465 minutes after midnight
745: write the time as hours:minutes
7:4five: the hours and minutes must be numbers
```

- `745` has no colon, so `split` gives just one part, and `parts[1]` throws an `ArrayIndexOutOfBoundsException` (module 15).
- In `7:4five`, the minutes aren't a number, and `parseInt` throws a `NumberFormatException`.

A `try` can have several `catch` blocks, one after the other. When an exception is thrown, Java checks them from the top and runs the **first** one whose class matches. At most one `catch` block runs, and then the program goes on after the last one.

## A family of classes

Each kind of exception is a class, and the classes inherit from each other, just like the classes of module 34. Here's a part of the family, each class under its parent:

- `Exception`
    - `IOException`: reading or writing data failed. Reading a missing file the way this course does, with `Paths.get(...)`, throws a `NoSuchFileException`, one of its descendants. Some other ways of opening a file throw a `FileNotFoundException` instead, also an IOException. Module 43 meets it.
    - `RuntimeException`
        - `ArithmeticException`, such as `/ by zero`
        - `IllegalArgumentException`: a method got a value it can't work with
            - `NumberFormatException`
        - `IndexOutOfBoundsException`
            - `ArrayIndexOutOfBoundsException` and `StringIndexOutOfBoundsException`
        - `NullPointerException`

A NumberFormatException **is an** IllegalArgumentException, which is a RuntimeException, which is an Exception. So a `catch` block catches its own class and every class below it:

- `catch (IndexOutOfBoundsException e)` catches the index problems of lists, arrays and Strings.
- `catch (RuntimeException e)` catches everything in its branch.
- `catch (Exception e)`, as in module 20, catches all of them.

Catch a parent class when every child gets the same reaction, and separate classes when each problem needs its own. If one message covers both problems with the times, one block is enough:

```java
String[] times = {"745", "7:4five"};
for (String time : times) {
    try {
        String[] parts = time.split(":");
        int minutes = Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
        System.out.println(minutes);
    } catch (RuntimeException e) {
        System.out.println(time + " isn't a time like 7:45");
    }
}
```

**Output**

```text
745 isn't a time like 7:45
7:4five isn't a time like 7:45
```

## The more specific class first

Since a parent class catches its children, the order of the `catch` blocks matters. A `catch` for a child class after its parent's could never run, and javac refuses it:

```java
public class Main {
    public static void main(String[] args) {
        try {
            int minutes = Integer.parseInt("4five");
            System.out.println(minutes);
        } catch (IllegalArgumentException e) {
            System.out.println("That's not a valid value");
        } catch (NumberFormatException e) {
            System.out.println("That's not a number");
        }
    }
}
```

**What javac prints**

```text
Main.java:8: error: exception NumberFormatException has already been caught
        } catch (NumberFormatException e) {
          ^
1 error
```

Swap the two blocks, and it compiles: a NumberFormatException then goes to its own block, and any other IllegalArgumentException to the second one. A common pattern is the specific classes first and a `catch (Exception e)` at the end, for anything else.

## finally

A `try` can end with a `finally` block. It runs after the `try` block and the `catch` block, whatever happened: when nothing was thrown, when an exception was caught, and even when the `try` or `catch` block leaves the method with `return`:

```java
public class Main {
    public static void main(String[] args) {
        System.out.println(minutesOf("7:45"));
        System.out.println(minutesOf("745"));
    }

    public static int minutesOf(String time) {
        try {
            String[] parts = time.split(":");
            return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
        } catch (RuntimeException e) {
            return -1;
        } finally {
            System.out.println("checked " + time);
        }
    }
}
```

**Output**

```text
checked 7:45
465
checked 745
-1
```

The `return` decides the value, then the `finally` block runs, and only then does the method really return. That's why `checked 7:45` comes before `main` prints 465. An exception that no `catch` block catches runs the `finally` block too, on its way out of the method.

`finally` is for work that must be done however the `try` block ends, such as giving back something the program borrowed. The most common case, closing a file, has a shorter form of its own, in step 4.

---

Source: [Choosing what to catch](https://javaarena.com/learn/exceptions/choosing-what-to-catch/) in the module [Exceptions](https://javaarena.com/learn/exceptions/) on Java Arena.

This module follows section [11.3 Exceptions](https://java-programming.mooc.fi/part-11/3-exceptions) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
