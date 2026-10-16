> [!info] AI-Generated

# Your first Java program

A **program** is a list of instructions that a computer carries out one after another. You write the instructions as text, called **source code**. Java can't run that text directly: first a tool called the **compiler** (named `javac`) checks it and translates it into a compact form, and then the **Java virtual machine** runs the result. When you press **Check** on this site, both happen right in your browser, with the real Java 21 compiler.

## The shape of a Java program

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, Java!");
    }
}
```

**Output**

```text
Hello, Java!
```

Almost every line here is a frame that you'll write the same way every time:

- `public class Main { ... }` creates a **class** called `Main`. All Java code lives inside a class. The class name has to match the name of the file, and on this site the file is always `Main.java`, so the class is always `Main`.
- `public static void main(String[] args) { ... }` is the **main method**: the place where the program starts running. The words around `main` all have a meaning that later modules explain. For now, copy the line exactly as it is.
- `System.out.println("Hello, Java!");` is the one line that does something: it prints the text between the double quotes and then ends the line. The quotes themselves are not printed.
- Every `{` has a matching `}`. The class's braces wrap the main method, and the main method's braces wrap the instructions.

In other Java courses and tools the class often has a different name, such as `Sandbox` or `Program`. That's fine: the rule is only that the class name and the file name match.

## Capital letters matter

Java reads `System` and `system` as two different words. `System.out.println` has a capital `S` and nothing else in capitals. If one letter is off, the compiler stops and says what it couldn't understand. Step 5 of this module shows how to read those messages.

---

Source: [Your first Java program](https://javaarena.com/learn/printing/first-program/) in the module [Printing](https://javaarena.com/learn/printing/) on Java Arena.

This module follows sections [1.1 Getting started with programming](https://java-programming.mooc.fi/part-1/1-starting-programming), [1.2 Printing](https://java-programming.mooc.fi/part-1/2-printing), [2.1 Recurring problems and patterns to solve them](https://java-programming.mooc.fi/part-2/1-problems-and-patterns) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
