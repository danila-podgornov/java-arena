> [!info] AI-Generated

# Tracing values

`=` copies a value into a variable, once. After `a = b;`, the variable `a` holds the same number as `b`, but the two aren't linked: changing `b` later doesn't change `a`.

```java
int b = 5;
int a = b;
b = 8;
System.out.println(a);
System.out.println(b);
```

**Output**

```text
5
8
```

When a program gets confusing, trace it by hand: go through it line by line and write down what each variable holds after each line.

| After line | a | b |
|---|---|---|
| `int b = 5;` | | 5 |
| `int a = b;` | 5 | 5 |
| `b = 8;` | 5 | 8 |

Tracing is how programmers check their own thinking, and it's a skill worth practicing on paper, without running anything.

---

Source: [Tracing values](https://javaarena.com/learn/calculating/tracing-values/) in the module [Calculating with numbers](https://javaarena.com/learn/calculating/) on Java Arena.

This module follows section [1.5 Calculating with numbers](https://java-programming.mooc.fi/part-1/5-calculating) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
