> [!info] AI-Generated

# Arithmetic and precedence

Java calculates with the usual operators: `+` adds, `-` subtracts, `*` multiplies and `/` divides. A calculation can use numbers, variables, or both, and its result can be stored in a variable:

```java
int minutes = 3 * 60;
int total = minutes + 45;
System.out.println(total);
```

**Output**

```text
225
```

## Which part first

As in maths, `*` and `/` are done before `+` and `-`. Parentheses change the order: whatever is inside them is calculated first.

```java
System.out.println(2 + 3 * 4);
System.out.println((2 + 3) * 4);
```

**Output**

```text
14
20
```

A piece of code that has a value, like `2 + 3 * 4` or `minutes + 45`, is called an **expression**. A statement such as `int total = minutes + 45;` calculates the expression and does something with its value, here storing it.

---

Source: [Arithmetic and precedence](https://javaarena.com/learn/calculating/arithmetic/) in the module [Calculating with numbers](https://javaarena.com/learn/calculating/) on Java Arena.

This module follows section [1.5 Calculating with numbers](https://java-programming.mooc.fi/part-1/5-calculating) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
