> [!info] AI-Generated

# Calling a method from a loop

A method call is a statement like any other, so it can go inside a loop. The method's lines are written once and run every time the loop comes round:

```java
public class Main {
    public static void main(String[] args) {
        for (int round = 1; round <= 3; round++) {
            System.out.println("Round " + round);
            printDivider();
        }
    }

    public static void printDivider() {
        System.out.println("-----");
    }
}
```

**Output**

```text
Round 1
-----
Round 2
-----
Round 3
-----
```

Methods also make a program easier to change. To make the divider longer, you change one line in `printDivider`, and every call prints the new one.

---

Source: [Calling a method from a loop](https://javaarena.com/learn/methods/calling-in-a-loop/) in the module [Methods and parameters](https://javaarena.com/learn/methods/) on Java Arena.

This module follows section [2.4 Methods and dividing the program into smaller parts](https://java-programming.mooc.fi/part-2/4-methods) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
