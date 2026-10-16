> [!info] AI-Generated

# Booleans in conditions

A comparison like `age >= 18` is an expression with a value, and that value is a `boolean`: `true` or `false`. It can be stored in a variable, printed, or used later as a condition:

```java
int age = 20;
boolean adult = age >= 18;
System.out.println("Adult: " + adult);
if (adult) {
    System.out.println("Welcome in.");
}
```

**Output**

```text
Adult: true
Welcome in.
```

`if (adult)` reads naturally: the condition is the variable itself, so there's no need to write `if (adult == true)`.

A well-named boolean variable makes a condition easier to read, especially when the test is long or used more than once. Names like `adult`, `isRaining` or `hasTicket` work well: they read like yes-or-no questions.

---

Source: [Booleans in conditions](https://javaarena.com/learn/boolean-logic/boolean-conditions/) in the module [Conditions and logic](https://javaarena.com/learn/boolean-logic/) on Java Arena.

This module follows sections [1.6 Conditional statements and conditional operation](https://java-programming.mooc.fi/part-1/6-conditional-statements), [1.7 Programming in our society](https://java-programming.mooc.fi/part-1/7-programming-in-our-society) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
