> [!info] AI-Generated

# else

`else` adds a second block that runs when the condition is **false**. Exactly one of the two blocks runs, never both, never neither:

```java
int balance = -4;
if (balance >= 0) {
    System.out.println("Balance OK");
} else {
    System.out.println("Overdrawn");
}
```

**Output**

```text
Overdrawn
```

`else` has no condition of its own: it simply catches every case the `if` didn't. The `} else {` line closes the first block and opens the second, so it lines up with the `if`.

---

Source: [else](https://javaarena.com/learn/conditionals/else/) in the module [Making decisions](https://javaarena.com/learn/conditionals/) on Java Arena.

This module follows section [1.6 Conditional statements and conditional operation](https://java-programming.mooc.fi/part-1/6-conditional-statements) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
