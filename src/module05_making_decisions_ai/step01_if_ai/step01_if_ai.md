> [!info] AI-Generated

# if

So far every line of a program ran every time. An `if` statement runs a block of code only when a **condition** is true:

```java
int temperature = 31;
if (temperature > 30) {
    System.out.println("Hot day: drink water.");
}
System.out.println("Temperature: " + temperature);
```

**Output**

```text
Hot day: drink water.
Temperature: 31
```

- The condition goes in parentheses after `if`. Here it's `temperature > 30`, which is either true or false.
- The **block** in braces `{ }` runs only when the condition is true. With `temperature = 25`, the program would print only the second line.
- The line after the block runs either way.

## No semicolon after the condition

A semicolon right after `if (...)` ends the `if` there, with nothing in it. The block below it then runs every time, and Java doesn't warn about it:

```java
int speed = 30;
if (speed > 50); {
    System.out.println("Too fast!");
}
```

**Output**

```text
Too fast!
```

Only 30, and yet "Too fast!". When an `if` seems to be ignored, check for this semicolon first.

---

Source: [if](https://javaarena.com/learn/conditionals/if-statements/) in the module [Making decisions](https://javaarena.com/learn/conditionals/) on Java Arena.

This module follows section [1.6 Conditional statements and conditional operation](https://java-programming.mooc.fi/part-1/6-conditional-statements) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
