> [!info] AI-Generated

# Blocks and indentation

A **block** is the code between a `{` and its `}`. The class, the main method and each `if` have one, and blocks sit inside each other.

Java itself doesn't care about spaces at the start of a line. People do: indentation shows at a glance which lines are inside which block. The usual rule, used throughout this site:

- every line inside a block is indented **4 spaces** more than the line that opened the block;
- the closing `}` lines up with the line that opened the block.

```java
public class Main {
    public static void main(String[] args) {
        int points = 12;
        if (points > 10) {
            System.out.println("Level up!");
        }
        System.out.println("Points: " + points);
    }
}
```

**Output**

```text
Level up!
Points: 12
```

The editor helps: after a `{`, pressing Enter indents the next line, and the **Tab** key (also on the symbol bar on phones) adds 4 spaces.

## Checking the style

In the first two challenges of this step, **Check** also checks the indentation. Everywhere else, indentation that doesn't match the braces shows up as a note after the tests, but doesn't stop a challenge from passing.

---

Source: [Blocks and indentation](https://javaarena.com/learn/conditionals/indentation/) in the module [Making decisions](https://javaarena.com/learn/conditionals/) on Java Arena.

This module follows section [1.6 Conditional statements and conditional operation](https://java-programming.mooc.fi/part-1/6-conditional-statements) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
