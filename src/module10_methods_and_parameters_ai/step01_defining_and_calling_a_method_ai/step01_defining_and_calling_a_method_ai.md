> [!info] AI-Generated

# Defining and calling a method

So far every program has been one long `main` method. As programs grow, that gets hard to read. A **method** is a named piece of code: you write it once and run it by its name, as often as you like.

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Let's begin.");
        greet();
        greet();
        System.out.println("Done.");
    }

    public static void greet() {
        System.out.println("Hello from a method!");
    }
}
```

**Output**

```text
Let's begin.
Hello from a method!
Hello from a method!
Done.
```

- `public static void greet() { ... }` **defines** the method. It sits inside the class, next to `main`, never inside another method.
- `greet();` **calls** it: Java runs the method's lines, then carries on after the call.
- Every method in these lessons starts with `public static`; the modules on objects explain what that means. `void` means the method gives nothing back. Module 11 is about methods that do.
- Method names follow the same style as variable names: a small first letter, and a capital for each new word, such as `printMenu` or `showScore`.

The order of the methods in the class doesn't matter: Java always starts at `main`.

---

Source: [Defining and calling a method](https://javaarena.com/learn/methods/defining-methods/) in the module [Methods and parameters](https://javaarena.com/learn/methods/) on Java Arena.

This module follows section [2.4 Methods and dividing the program into smaller parts](https://java-programming.mooc.fi/part-2/4-methods) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
