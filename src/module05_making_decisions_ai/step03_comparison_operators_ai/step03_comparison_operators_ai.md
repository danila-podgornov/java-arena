> [!info] AI-Generated

# Comparison operators

A condition is usually a comparison. Java has six comparison operators, and each one gives `true` or `false`:

| Operator | Means | Example that's true |
|---|---|---|
| `>` | greater than | `5 > 3` |
| `>=` | greater than or equal to | `3 >= 3` |
| `<` | less than | `2 < 7` |
| `<=` | less than or equal to | `7 <= 7` |
| `==` | equal to | `4 == 4` |
| `!=` | not equal to | `4 != 5` |

## `==` compares, `=` assigns

Comparing uses two equals signs. With one, Java reads it as an assignment. An assignment has a value too, the value it stores: here that's the `int` 5, and an `if` needs `true` or `false`:

```java
public class Main {
    public static void main(String[] args) {
        int number = 5;
        if (number = 5) {
            System.out.println("Five!");
        }
    }
}
```

**What javac prints**

```text
Main.java:4: error: incompatible types: int cannot be converted to boolean
        if (number = 5) {
                   ^
1 error
```

With numbers the compiler catches this mistake. With a `boolean` variable (the next module introduces them) it can't: `if (done = true)` stores `true` in `done`, compiles without a warning, and the block always runs. To compare, always use `==`.

These operators compare numbers. Comparing text is different, and the next module shows how.

---

Source: [Comparison operators](https://javaarena.com/learn/conditionals/comparisons/) in the module [Making decisions](https://javaarena.com/learn/conditionals/) on Java Arena.

This module follows section [1.6 Conditional statements and conditional operation](https://java-programming.mooc.fi/part-1/6-conditional-statements) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
