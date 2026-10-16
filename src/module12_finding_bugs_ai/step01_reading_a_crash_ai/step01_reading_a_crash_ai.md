> [!info] AI-Generated

# Reading a crash

Programs go wrong in two ways. You've met the first since module 1: **javac** finds a mistake, and the program doesn't run at all. The second kind happens while the program runs: it gets to a line it can't carry out, and it stops. This is a **crash**, and Java calls the problem an **exception**.

This program computes an average, but nothing has been added yet:

```java
public class Main {
    public static void main(String[] args) {
        int total = 0;
        int count = 0;
        System.out.println("Scores added: " + count);
        int average = total / count;
        System.out.println("Average: " + average);
    }
}
```

**Output**

```text
Scores added: 0
```

**The program crashes with**

```text
Exception in thread "main" java.lang.ArithmeticException: / by zero
	at Main.main(Main.java:6)
```

A crash message has three parts worth reading:

- **What happened**: the exception's name, here `ArithmeticException`, a calculation that can't be done.
- **Why**: the message after the colon, `/ by zero`. A whole number can't be divided by zero.
- **Where**: `at Main.main(Main.java:6)`, the method `main` on line 6.

Everything printed before the crash still appears: `Scores added: 0` came out, and the lines after line 6 never ran.

When the crash happens inside a method, Java lists every method that was running, the one that crashed first. This is the call stack from module 11:

```java
public class Main {
    public static void main(String[] args) {
        printShare(12, 4);
        printShare(12, 0);
    }

    public static void printShare(int total, int people) {
        System.out.println("Each gets " + share(total, people));
    }

    public static int share(int total, int people) {
        return total / people;
    }
}
```

**Output**

```text
Each gets 3
```

**The program crashes with**

```text
Exception in thread "main" java.lang.ArithmeticException: / by zero
	at Main.share(Main.java:12)
	at Main.printShare(Main.java:8)
	at Main.main(Main.java:4)
```

Read it from the top: the division on line 12 in `share` failed. `share` was called by `printShare` on line 8, and that call came from line 4 of `main`, the second `printShare`. The first call worked; only the call with 0 people crashed.

Java Arena shows a crash the same way and explains it in plain words, with the line it happened on. The fix is often not on the crashing line itself: ask where the bad value came from.

---

Source: [Reading a crash](https://javaarena.com/learn/debugging/reading-a-crash/) in the module [Finding bugs](https://javaarena.com/learn/debugging/) on Java Arena.

This module follows section [3.1 Discovering errors](https://java-programming.mooc.fi/part-3/1-discovering-errors) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
