> [!info] AI-Generated

# for loops

Counting loops are so common that Java has a shorter way to write them. The **for loop** puts all three parts on one line, separated by semicolons:

```java
for (int i = 1; i <= 5; i++) {
    System.out.println(i);
}
```

**Output**

```text
1
2
3
4
5
```

`for (start; condition; change)` does the same as this `while` loop:

```java
int i = 1;
while (i <= 5) {
    System.out.println(i);
    i++;
}
```

- The start runs once, before the first round.
- The condition is checked before every round.
- The change runs at the end of every round.

A loop variable is often called `i`. Made in the `for` line, it only exists inside the loop. Counting down and other steps work too: `for (int i = 10; i >= 1; i--)` counts from 10 to 1, and `i += 2` instead of `i++` takes every second number.

---

Source: [for loops](https://javaarena.com/learn/for-loops/for-loops/) in the module [Loop conditions and for](https://javaarena.com/learn/for-loops/) on Java Arena.

This module follows section [2.3 More loops](https://java-programming.mooc.fi/part-2/3-more-loops) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
