> [!info] AI-Generated

# When the condition is checked

A loop's condition is checked at one moment only: **before each round**, including the very first. It isn't watched during the round. If the variable passes the limit halfway through the block, the rest of the block still runs, and the loop stops only at the next check.

```java
int total = 0;
int rounds = 0;
while (total < 10) {
    total += 4;
    rounds++;
    System.out.println("Round " + rounds + ": total " + total);
}
System.out.println("After the loop: " + total);
```

**Output**

```text
Round 1: total 4
Round 2: total 8
Round 3: total 12
After the loop: 12
```

In round 3, `total` went past 10, but the round finished and printed. Only then did the check `12 < 10` fail. So after a loop, its variable holds the first value that made the condition false, which isn't necessarily the limit.

Tracing a loop by hand (writing down each variable after each round) is the surest way to know what it does. These three challenges are for tracing.

---

Source: [When the condition is checked](https://javaarena.com/learn/for-loops/when-the-condition-is-checked/) in the module [Loop conditions and for](https://javaarena.com/learn/for-loops/) on Java Arena.

This module follows section [2.3 More loops](https://java-programming.mooc.fi/part-2/3-more-loops) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
