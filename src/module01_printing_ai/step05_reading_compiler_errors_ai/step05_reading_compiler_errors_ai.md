> [!info] AI-Generated

# Reading compiler errors

Before a program runs, the compiler reads all of it. If something isn't valid Java, it stops and prints an **error** instead, and nothing runs. Errors are normal: they're the compiler pointing at the exact spot it didn't understand. Here is a program with one character missing:

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello")
    }
}
```

**What javac prints**

```text
Main.java:3: error: ';' expected
        System.out.println("Hello")
                                   ^
1 error
```

Read it piece by piece:

- `Main.java:3` is the file and the **line number**: line 3.
- `error: ';' expected` says what went wrong: Java expected a semicolon.
- The next line repeats the code, and the `^` below it points at the exact position, here the end of the line where the `;` belongs.
- `1 error` counts the errors. Fix the first one first: one mistake sometimes confuses the compiler into reporting more lines after it.

On this site each error also gets a plain-English explanation under it, and the editor marks the line.

## A few words to know

- A **statement** is one instruction. The ones in this module each end with a semicolon.
- The text inside the parentheses of `println( ... )` is the **parameter**: the value the method works with.
- A **typo** in a name gives a `cannot find symbol` error. For example `System.out.printn("Hi");` makes the compiler report that there is no method `printn`.

---

Source: [Reading compiler errors](https://javaarena.com/learn/printing/compiler-errors/) in the module [Printing](https://javaarena.com/learn/printing/) on Java Arena.

This module follows sections [1.1 Getting started with programming](https://java-programming.mooc.fi/part-1/1-starting-programming), [1.2 Printing](https://java-programming.mooc.fi/part-1/2-printing), [2.1 Recurring problems and patterns to solve them](https://java-programming.mooc.fi/part-2/1-problems-and-patterns) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
