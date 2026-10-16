> [!info] AI-Generated

# Division and casting

Dividing two `int` values gives an `int`: the part after the decimal point is simply dropped, not rounded.

```java
System.out.println(7 / 2);
System.out.println(9 / 10);
System.out.println(7.0 / 2);
```

**Output**

```text
3
0
3.5
```

As soon as one of the two numbers is a `double`, like `7.0`, the division gives a `double`. With variables, turn an `int` into a `double` with a **cast**: `(double)` in front of it.

```java
int sum = 7;
int count = 2;
double average = (double) sum / count;
System.out.println(average);
```

**Output**

```text
3.5
```

Where the cast goes matters. `(double) sum / count` turns `sum` into `7.0` first and then divides, giving `3.5`. `(double) (sum / count)` divides the two `int` values first, giving `3`, and then turns that into `3.0`.

---

Source: [Division and casting](https://javaarena.com/learn/calculating/division/) in the module [Calculating with numbers](https://javaarena.com/learn/calculating/) on Java Arena.

This module follows section [1.5 Calculating with numbers](https://java-programming.mooc.fi/part-1/5-calculating) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
