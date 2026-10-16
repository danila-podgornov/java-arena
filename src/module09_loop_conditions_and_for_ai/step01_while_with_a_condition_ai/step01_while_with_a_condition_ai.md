> [!info] AI-Generated

# while with a condition

`while (true)` needs a `break` to stop. A loop can instead have a real **condition**: it's checked before every round, and the loop ends the first time that check finds it false.

```java
int number = 1;
while (number <= 5) {
    System.out.println(number);
    number++;
}
System.out.println("Done, number is now " + number);
```

**Output**

```text
1
2
3
4
5
Done, number is now 6
```

This is a **counting loop**, and it has three parts:

1. a variable set before the loop (`int number = 1;`),
2. a condition that decides whether another round runs (`number <= 5`),
3. a change inside the loop that moves toward the end (`number++`).

Forget the third part and `number` stays 1 forever: the condition never turns false.

When the loop should end at a known point, a condition says so right at the top. `while (true)` with `break` suits loops that end on something the loop reads, like a word such as `end`.

---

Source: [while with a condition](https://javaarena.com/learn/for-loops/loop-conditions/) in the module [Loop conditions and for](https://javaarena.com/learn/for-loops/) on Java Arena.

This module follows section [2.3 More loops](https://java-programming.mooc.fi/part-2/3-more-loops) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
