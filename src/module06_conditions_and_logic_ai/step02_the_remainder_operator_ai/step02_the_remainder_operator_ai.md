> [!info] AI-Generated

# The remainder operator %

`%` gives the **remainder** of a division between whole numbers: `17 % 5` is `2`, because 17 is three fives and 2 left over.

```java
System.out.println(17 % 5);
System.out.println(12 % 4);
System.out.println(7 % 10);
```

**Output**

```text
2
0
7
```

A remainder of 0 means the division comes out even, so `%` is the way to test whether a number divides by another. The most common case is even and odd: a number is even when `number % 2 == 0`.

## Negative numbers

In Java the remainder has the same sign as the number being divided, so `-7 % 2` is `-1`, not `1`:

```java
System.out.println(-7 % 2);
System.out.println(-8 % 2);
```

**Output**

```text
-1
0
```

That's why "is it odd?" is safest written as `number % 2 != 0`: `number % 2 == 1` is false for odd negative numbers.

---

Source: [The remainder operator %](https://javaarena.com/learn/boolean-logic/remainder/) in the module [Conditions and logic](https://javaarena.com/learn/boolean-logic/) on Java Arena.

This module follows sections [1.6 Conditional statements and conditional operation](https://java-programming.mooc.fi/part-1/6-conditional-statements), [1.7 Programming in our society](https://java-programming.mooc.fi/part-1/7-programming-in-our-society) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
