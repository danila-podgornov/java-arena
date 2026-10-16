> [!info] AI-Generated

# print and println

`System.out.println` prints its text and then ends the line, so the next output starts on a new line. Its sibling `System.out.print` prints the text and stays on the same line, so the next output continues right after it.

```java
System.out.print("Loading");
System.out.print("...");
System.out.println(" done");
System.out.println("Next line");
```

**Output**

```text
Loading... done
Next line
```

`print` never adds a space by itself. The space before `done` is there because it is inside the quotes.

## An empty line

`System.out.println()` with nothing between the parentheses prints nothing and ends the line. That gives an empty line, or finishes a line that `print` started.

```java
System.out.println("First paragraph.");
System.out.println();
System.out.println("Second paragraph.");
```

**Output**

```text
First paragraph.

Second paragraph.
```

---

Source: [print and println](https://javaarena.com/learn/printing/print-and-println/) in the module [Printing](https://javaarena.com/learn/printing/) on Java Arena.

This module follows sections [1.1 Getting started with programming](https://java-programming.mooc.fi/part-1/1-starting-programming), [1.2 Printing](https://java-programming.mooc.fi/part-1/2-printing), [2.1 Recurring problems and patterns to solve them](https://java-programming.mooc.fi/part-2/1-problems-and-patterns) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
