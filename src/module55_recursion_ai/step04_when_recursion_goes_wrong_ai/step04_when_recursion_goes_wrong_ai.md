> [!info] AI-Generated

# When recursion goes wrong

A recursive method needs a base case, and every call must get closer to it. When one of the two is missing, the calls never stop, and the program crashes.

## No base case

Here is `digits` from step 2 with its base case left out. A program that crashes this way prints a very long report, so this one catches the error (module 42) and prints one line instead:

```java
public class Main {
    public static void main(String[] args) {
        try {
            System.out.println(digits(4096));
        } catch (StackOverflowError e) {
            System.out.println("The calls never stopped: " + e);
        }
    }

    public static int digits(int n) {
        return 1 + digits(n / 10);
    }
}
```

**Output**

```text
The calls never stopped: java.lang.StackOverflowError
```

`digits(4096)` calls `digits(409)`, `digits(40)`, `digits(4)` and `digits(0)`, and then `digits(0)` again and again, since `0 / 10` is 0. None of the calls ever returns. Every call of a method takes some memory on the call stack for its parameters and variables, and gives it back when it returns. The call stack has a fixed size, so a chain of calls that never returns fills it up. Java then throws a **StackOverflowError**. It's an error, not an exception (its class extends `Error`, not `Exception`): errors are for problems a program usually can't recover from, and catching one is rare. It's done here only to keep the page short.

Without the `try` (with `System.out.println(digits(4096));` alone in `main`), the program would crash with a report like this, where line 7 is the line of the recursive call:

```text
Exception in thread "main" java.lang.StackOverflowError
	at Main.digits(Main.java:7)
	at Main.digits(Main.java:7)
	at Main.digits(Main.java:7)
```

and so on: the reference JDK prints 1,024 `at` lines, all of them the same. The report lists the calls that were on the stack, newest first, and a report whose `at` lines repeat one method is the sign of a recursion that doesn't stop.

The fix is the base case that was left out: a number below 10 has one digit, and the method returns 1 without calling itself.

## A base case that's never reached

The quiz show's `countDown` from step 1 has a base case, `seconds == 0`:

```java
public static void countDown(int seconds) {
    if (seconds == 0) {
        return;
    }
    System.out.println(seconds);
    countDown(seconds - 1);
}
```

`countDown(3)` prints 3, 2 and 1, and stops. But `countDown(-3)` prints -3, -4, -5... and never reaches 0, so it overflows the stack too. (On the reference JDK it prints thousands of lines first. Java Arena stops a program once it has printed 64 KB, so here a program like this is stopped for printing too much before the stack runs out.) The base case exists, but some inputs miss it. A base case written as a range, `seconds <= 0`, catches every input at or past the end. So when you write a recursive method, try it on the smallest inputs: 0, 1, a negative number, and odd and even numbers when the method takes steps of 2.

## Calls that repeat work

A method can also call itself correctly and still be far too slow. A child climbs a staircase one or two steps at a time. In how many ways can they climb `n` steps? The first move is one step (then `n - 1` steps are left) or two steps (then `n - 2` are left), so the ways for `n` are the ways for `n - 1` plus the ways for `n - 2`. 0 or 1 steps can be climbed in one way. These are the Fibonacci numbers.

```java
public class Main {
    public static void main(String[] args) {
        System.out.println(ways(4));
        System.out.println(ways(30));
    }

    public static long ways(int steps) {
        if (steps <= 1) {
            return 1;
        }
        return ways(steps - 1) + ways(steps - 2);
    }
}
```

**Output**

```text
5
1346269
```

The answer is right, but each call makes two more, and they repeat the same work: `ways(30)` calls `ways(29)` and `ways(28)`, and `ways(29)` calls `ways(28)` again. The number of calls grows about as fast as the answer itself; for `ways(30)`, it's over two million, and every 10 more steps make it more than a hundred times larger. A loop that adds up the ways from the bottom (or a recursive method that remembers its answers in a HashMap) does about one round per step. The third challenge of this step counts the calls.

---

Source: [When recursion goes wrong](https://javaarena.com/learn/recursion/when-it-goes-wrong/) in the module [Recursion](https://javaarena.com/learn/recursion/) on Java Arena.

An extra module, not part of the University of Helsinki's course. Lesson text: [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/).
