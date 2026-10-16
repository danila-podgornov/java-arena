> [!info] AI-Generated

# Bugs and troubleshooting step by step

Programs rarely work right on the first try, and finding bugs is a big part of programming. This module is about doing it on purpose and step by step: reading what Java tells you, narrowing a problem down, and then writing tests that check your code for you, every time it changes.

## Three kinds of errors

| Kind | When it shows | What points to it |
| --- | --- | --- |
| A compile error | Before the program runs | javac names the file, the line and the problem |
| A crash | While the program runs | The exception and its stack trace name the line |
| A wrong result | After it runs, if you check | Nothing: you have to find it yourself |

The first two tell you where to look. The third is the sneaky one: the program ends normally, and what it prints just isn't right. Nobody may notice for a long time, and that's why most of this module is about catching it.

## A stack trace through several classes

Module 12 showed how to read a crash: the exception, its message, and the `at` lines, with the method that crashed at the top. That list of `at` lines is called a **stack trace**. In a program of several classes, each line names the class, the method and the file. An orchard has apple trees, and each tree tells how many of its apples are ripe:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Orchard orchard = new Orchard();
        orchard.plant(new AppleTree("Old Gala", 50, 20));
        orchard.plant(new AppleTree("Sapling", 0, 0));
        orchard.plant(new AppleTree("Big Fuji", 80, 60));
        orchard.printReport();
    }
}
```

**Orchard.java**

```java
import java.util.ArrayList;

public class Orchard {
    private ArrayList<AppleTree> trees;

    public Orchard() {
        this.trees = new ArrayList<>();
    }

    public void plant(AppleTree tree) {
        this.trees.add(tree);
    }

    public void printReport() {
        for (AppleTree tree : this.trees) {
            System.out.println(tree.getName() + ": " + tree.percentRipe() + "% ripe");
        }
    }
}
```

**AppleTree.java**

```java
public class AppleTree {
    private String name;
    private int apples;
    private int ripe;

    public AppleTree(String name, int apples, int ripe) {
        this.name = name;
        this.apples = apples;
        this.ripe = ripe;
    }

    public String getName() {
        return this.name;
    }

    public int percentRipe() {
        return 100 * this.ripe / this.apples;
    }
}
```

**Output**

```text
Old Gala: 40% ripe
```

**The program crashes with**

```text
Exception in thread "main" java.lang.ArithmeticException: / by zero
	at AppleTree.percentRipe(AppleTree.java:17)
	at Orchard.printReport(Orchard.java:16)
	at Main.main(Main.java:7)
```

Read it from the top, one line at a time:

- `at AppleTree.percentRipe(AppleTree.java:17)`: the division on line 17 of `AppleTree.java`, in the method `percentRipe`, divided by zero.
- `at Orchard.printReport(Orchard.java:16)`: `percentRipe` was called by the orchard's `printReport`, on line 16 of `Orchard.java`.
- `at Main.main(Main.java:7)`: and `printReport` was called on line 7 of `main`.

Each line is a method that was still running, waiting for the method above it to return. The trace doesn't say which tree it was, but the output does: Old Gala was printed, so the crash came with the next tree, the sapling, which has no apples yet. A tree without apples is a real thing, so the fix belongs in `percentRipe`: return 0 when `apples` is 0, before dividing.

On your own computer, a stack trace often has lines from inside Java's own classes too, above yours. They start with `at java.base/`, for example when a list's `get` is given an index that doesn't exist. Java Arena leaves them out. When you see them, read down to the first line that names one of your own classes: that's the last place your code was.

## A checklist for troubleshooting

When a program does something wrong and you don't see why, changing things at random usually makes it worse. Work through it step by step:

1. **Make the bug happen again.** Find an input that shows it every time, as small as you can. Write down what the program should print for it, and what it prints.
2. **Read everything Java tells you.** The first line of a compile error or a crash, and the first `at` line in your own code.
3. **Narrow it down.** Find the first place where a value goes wrong. Try one method at a time with a value you know the answer for, or print values along the way (module 12).
4. **Change one thing, then run again.** If it didn't help, undo it before you try something else.
5. **Try the other cases again.** A fix for one input can break another input that worked before.
6. **Clean up.** Remove the debug prints.

Steps 1 and 5 mean running the same inputs again and again. The rest of this module shows how to make that automatic.

---

Source: [Bugs and troubleshooting step by step](https://javaarena.com/learn/unit-testing/troubleshooting/) in the module [Troubleshooting and unit testing](https://javaarena.com/learn/unit-testing/) on Java Arena.

This module follows sections [6.3 Introduction to testing](https://java-programming.mooc.fi/part-6/3-introduction-to-testing), [6.4 Complex programs](https://java-programming.mooc.fi/part-6/4-complex-programs) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
