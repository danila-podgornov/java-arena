> [!info] AI-Generated

# Math methods

Java has a toolbox of ready-made calculations in `Math`. You call them with values in parentheses, and they give back a result that you can store or print:

| Call | Gives back | Example |
|---|---|---|
| `Math.sqrt(x)` | the square root of `x`, as a `double` | `Math.sqrt(9)` is `3.0` |
| `Math.pow(a, b)` | `a` to the power `b`, as a `double` | `Math.pow(2, 10)` is `1024.0` |
| `Math.max(a, b)` | the larger of the two | `Math.max(3, 8)` is `8` |
| `Math.min(a, b)` | the smaller of the two | `Math.min(3, 8)` is `3` |
| `Math.abs(x)` | `x` without its minus sign | `Math.abs(-5)` is `5` |

```java
int a = 3;
int b = 4;
double hypotenuse = Math.sqrt(a * a + b * b);
System.out.println(hypotenuse);
System.out.println(Math.max(a, b));
System.out.println(Math.pow(a, 3));
```

**Output**

```text
5.0
4
27.0
```

`Math.max` and `Math.min` keep the type they're given (two `int`s give an `int`), while `Math.sqrt` and `Math.pow` always give a `double`. A call can be part of a bigger calculation, and a call can even go inside another: `Math.max(a, Math.max(b, c))` is the largest of three.

---

Source: [Math methods](https://javaarena.com/learn/problem-patterns/math-methods/) in the module [Problem-solving patterns](https://javaarena.com/learn/problem-patterns/) on Java Arena.

This module follows section [2.1 Recurring problems and patterns to solve them](https://java-programming.mooc.fi/part-2/1-problems-and-patterns) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
