> [!info] AI-Generated

# Several lines, in order

A program's instructions are called **statements**. Inside `main` they run from top to bottom, one after another, and each `System.out.println` prints one line. Statements like these end with a semicolon `;`, much like a sentence ends with a full stop. (Later modules show statements that hold other statements in braces instead, such as `if` and loops.)

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("3");
        System.out.println("2");
        System.out.println("1");
        System.out.println("Liftoff!");
    }
}
```

**Output**

```text
3
2
1
Liftoff!
```

Swap two of the lines and the countdown is in the wrong order: the computer does exactly what the statements say, in the order they are written.

## The output has to match exactly

The checks on this site compare what your program prints with the expected output, character by character. `Liftoff!` and `liftoff!` are different, and so are `Hello, world` and `Hello,world`. The only things ignored are spaces at the very end of a line and empty lines at the very end of the output. Real programs are held to the same standard: another program reading your output won't guess what you meant.

## Less typing

`System.out.println` is long to type, especially on a phone. On a touch screen, the row of keys under the editor has a **sout** key that types `System.out.println();` for you, with the cursor inside the parentheses. Many Java editors have the same shortcut: type `sout` and press Tab.

---

Source: [Several lines, in order](https://javaarena.com/learn/printing/several-lines/) in the module [Printing](https://javaarena.com/learn/printing/) on Java Arena.

This module follows sections [1.1 Getting started with programming](https://java-programming.mooc.fi/part-1/1-starting-programming), [1.2 Printing](https://java-programming.mooc.fi/part-1/2-printing), [2.1 Recurring problems and patterns to solve them](https://java-programming.mooc.fi/part-2/1-problems-and-patterns) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
