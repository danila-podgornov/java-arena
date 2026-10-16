> [!info] AI-Generated

# Comments

A **comment** is a note for people reading the code. The compiler skips it completely, so it never changes what the program does. Java has two kinds:

- `//` starts a comment that runs to the end of the line.
- `/*` starts a comment that runs until the next `*/`, even across several lines.

```java
public class Main {
    public static void main(String[] args) {
        // This is a note. Java skips this line.
        System.out.println("Visible");
        // System.out.println("Hidden");
        /* A block comment
           can span several lines. */
        System.out.println("Also visible");
    }
}
```

**Output**

```text
Visible
Also visible
```

The fifth line shows a common trick: putting `//` in front of a statement **comments it out**. The statement stays in the file, so it's easy to bring back, but it doesn't run. That's handy when you want to try the program without one line.

Inside quotes, `//` is ordinary text: `System.out.println("// not a comment");` prints `// not a comment`.

---

Source: [Comments](https://javaarena.com/learn/printing/comments/) in the module [Printing](https://javaarena.com/learn/printing/) on Java Arena.

This module follows sections [1.1 Getting started with programming](https://java-programming.mooc.fi/part-1/1-starting-programming), [1.2 Printing](https://java-programming.mooc.fi/part-1/2-printing), [2.1 Recurring problems and patterns to solve them](https://java-programming.mooc.fi/part-2/1-problems-and-patterns) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
