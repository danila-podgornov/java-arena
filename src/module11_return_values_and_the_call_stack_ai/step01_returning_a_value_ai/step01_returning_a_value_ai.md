> [!info] AI-Generated

# Returning a value

The methods so far did their work and gave nothing back: they were `void`. A method can instead **return** a value to the code that called it. The value's type goes where `void` was, and a `return` statement says what to give back:

```java
public class Main {
    public static void main(String[] args) {
        int weeks = 3;
        int days = weeks * daysInWeek();
        System.out.println(weeks + " weeks is " + days + " days");
        System.out.println(daysInWeek());
    }

    public static int daysInWeek() {
        return 7;
    }
}
```

**Output**

```text
3 weeks is 21 days
7
```

- `public static int daysInWeek()` says the method returns an `int`.
- `return 7;` ends the method and hands 7 back to the call.
- The call `daysInWeek()` then stands for that value, anywhere a value can go: in a calculation, in a print line, or stored in a variable (`int d = daysInWeek();`).

A call whose value isn't used, like `daysInWeek();` on a line of its own, runs the method, and the value is simply lost.

## return ends the method

Nothing after a `return` runs, and Java refuses code that could never run:

```java
public class Main {
    public static void main(String[] args) {
        System.out.println(daysInWeek());
    }

    public static int daysInWeek() {
        return 7;
        System.out.println("Counted the days");
    }
}
```

**What javac prints**

```text
Main.java:8: error: unreachable statement
        System.out.println("Counted the days");
        ^
1 error
```

A `void` method can use a plain `return;` to stop early.

---

Source: [Returning a value](https://javaarena.com/learn/return-values/returning-a-value/) in the module [Return values and the call stack](https://javaarena.com/learn/return-values/) on Java Arena.

This module follows sections [2.4 Methods and dividing the program into smaller parts](https://java-programming.mooc.fi/part-2/4-methods), [2.5 End questionnaire](https://java-programming.mooc.fi/part-2/5-end-questionnaire) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
