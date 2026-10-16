> [!info] AI-Generated

# Methods that call methods

Any method can call other methods, not only `main`. A bigger method can then be built from smaller ones that each do one thing:

```java
public class Main {
    public static void main(String[] args) {
        System.out.println(distance(3, 4));
    }

    public static int square(int number) {
        return number * number;
    }

    public static double distance(int x, int y) {
        return Math.sqrt(square(x) + square(y));
    }
}
```

**Output**

```text
5.0
```

`distance` calls `square` twice and uses what it returns. Each small method can be checked on its own, and once `square` works, every method that uses it can rely on it.

Methods that print can call each other too. A method that prints a table can call a method that prints one row, once for each row. The row method then only has to know how to print a single row.

---

Source: [Methods that call methods](https://javaarena.com/learn/return-values/methods-calling-methods/) in the module [Return values and the call stack](https://javaarena.com/learn/return-values/) on Java Arena.

This module follows sections [2.4 Methods and dividing the program into smaller parts](https://java-programming.mooc.fi/part-2/4-methods), [2.5 End questionnaire](https://java-programming.mooc.fi/part-2/5-end-questionnaire) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
