> [!info] AI-Generated

# else if chains

With more than two cases, chain conditions with `else if`. Java checks them from the top, runs the block of the **first** condition that's true, and skips the rest. A final `else` catches everything else.

```java
int temperature = 12;
if (temperature > 25) {
    System.out.println("Hot");
} else if (temperature > 15) {
    System.out.println("Warm");
} else if (temperature > 5) {
    System.out.println("Cool");
} else {
    System.out.println("Cold");
}
```

**Output**

```text
Cool
```

For 12, the first two conditions are false and the third is true, so the program prints `Cool` and the rest of the chain is skipped. Exactly one block of the chain runs. The final `else` is optional; without it, no block runs when no condition is true.

---

Source: [else if chains](https://javaarena.com/learn/conditionals/else-if/) in the module [Making decisions](https://javaarena.com/learn/conditionals/) on Java Arena.

This module follows section [1.6 Conditional statements and conditional operation](https://java-programming.mooc.fi/part-1/6-conditional-statements) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
