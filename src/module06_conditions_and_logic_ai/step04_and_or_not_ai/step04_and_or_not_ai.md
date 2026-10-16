> [!info] AI-Generated

# And, or, not

Conditions can be combined:

- `a && b` (**and**) is true when both `a` and `b` are true.
- `a || b` (**or**) is true when at least one of them is true.
- `!a` (**not**) is true when `a` is false.

A range check is the classic use of `&&`: a number is between 1 and 10 when it's at least 1 **and** at most 10.

```java
int number = 7;
if (number >= 1 && number <= 10) {
    System.out.println("In range");
}
if (number < 1 || number > 10) {
    System.out.println("Out of range");
}
System.out.println(!(number > 5));
```

**Output**

```text
In range
false
```

Java checks `&&` and `||` from left to right and stops as soon as the answer is known: in `a && b`, when `a` is false, `b` isn't looked at.

---

Source: [And, or, not](https://javaarena.com/learn/boolean-logic/and-or-not/) in the module [Conditions and logic](https://javaarena.com/learn/boolean-logic/) on Java Arena.

This module follows sections [1.6 Conditional statements and conditional operation](https://java-programming.mooc.fi/part-1/6-conditional-statements), [1.7 Programming in our society](https://java-programming.mooc.fi/part-1/7-programming-in-our-society) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
