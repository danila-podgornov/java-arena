> [!info] AI-Generated

# The first true branch wins

In an `else if` chain only the first true condition counts, so the **order** of the conditions changes what the program does. Look at this chain, meant to give a grade:

```java
int points = 95;
if (points >= 50) {
    System.out.println("Passed");
} else if (points >= 90) {
    System.out.println("Excellent");
}
```

**Output**

```text
Passed
```

95 should be `Excellent`, but `points >= 50` is checked first, it's true, and the rest of the chain is skipped. `Excellent` can never be printed. Checking the strictest condition first fixes it:

```java
int points = 95;
if (points >= 90) {
    System.out.println("Excellent");
} else if (points >= 50) {
    System.out.println("Passed");
}
```

**Output**

```text
Excellent
```

When conditions overlap, put the most specific one first. Each `else if` can then rely on the earlier conditions having been false: in the second version, the `>= 50` branch only ever sees points below 90.

---

Source: [The first true branch wins](https://javaarena.com/learn/conditionals/order-of-conditions/) in the module [Making decisions](https://javaarena.com/learn/conditionals/) on Java Arena.

This module follows section [1.6 Conditional statements and conditional operation](https://java-programming.mooc.fi/part-1/6-conditional-statements) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
