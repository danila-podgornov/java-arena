> [!info] AI-Generated

# Print debugging

A crash tells you where to look. A wrong answer doesn't: the program runs to the end and prints something, just not the right thing. Then you need to see what the program actually does, step by step.

The simplest tool is a temporary print that shows the values of variables at an interesting point. This program should add up the numbers from 1 to 5, which is 15:

```java
int sum = 0;
for (int i = 1; i < 5; i++) {
    sum += i;
}
System.out.println("Sum: " + sum);
```

**Output**

```text
Sum: 10
```

10 is wrong, but why? Add a print inside the loop:

```java
int sum = 0;
for (int i = 1; i < 5; i++) {
    sum += i;
    System.out.println("debug: i = " + i + ", sum = " + sum);
}
System.out.println("Sum: " + sum);
```

**Output**

```text
debug: i = 1, sum = 1
debug: i = 2, sum = 3
debug: i = 3, sum = 6
debug: i = 4, sum = 10
Sum: 10
```

Now it's plain to see: the loop stops after 4, so 5 is never added. The condition should be `i <= 5`. Fix it, run it again, and remove the debug print (or comment it out) once the answer is right.

Some tips:

- Print a label with each value (`"debug: i = " + i`), so you know which print you're looking at.
- Print in the places where the program decides something: inside loops, before and after an `if`, at the start of a method (its parameters) and just before it returns.
- Start with one or two prints. If the values are right there, move them later in the program; if they're already wrong, move them earlier.

---

Source: [Print debugging](https://javaarena.com/learn/debugging/print-debugging/) in the module [Finding bugs](https://javaarena.com/learn/debugging/) on Java Arena.

This module follows section [3.1 Discovering errors](https://java-programming.mooc.fi/part-3/1-discovering-errors) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
