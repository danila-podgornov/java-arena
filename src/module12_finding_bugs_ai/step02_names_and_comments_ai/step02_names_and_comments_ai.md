> [!info] AI-Generated

# Names and comments

When you read your own code, you tend to see what you *meant* to write, not what's actually there. That's why a bug can sit in plain sight while you read over it again and again.

Two habits make code easier to read, both for others and for you next week.

## Names that say what a value is

Compare these two versions of the same calculation:

```java
int a = 3;
int b = 250;
int c = a * b;
System.out.println(c);
```

**Output**

```text
750
```

```java
int tickets = 3;
int priceInCents = 250;
int totalInCents = tickets * priceInCents;
System.out.println(totalInCents);
```

**Output**

```text
750
```

Both work, but only the second one tells you what it does. A wrong line such as `int totalInCents = tickets + priceInCents;` stands out when the names make sense, and hides easily among `a`, `b` and `c`. Short names are fine where the meaning is obvious, such as `i` for a loop counter.

## Comments that explain why

You met comments in module 1: `//` runs to the end of the line, and `/*` runs until `*/`. Java skips them, so they're written for people:

```java
/* Prices are kept in cents,
   so no rounding happens. */
int priceInCents = 250;
// A discount of 10 percent on orders of 4 or more
int tickets = 4;
if (tickets >= 4) {
    priceInCents = priceInCents * 90 / 100;
}
System.out.println(tickets * priceInCents);
```

**Output**

```text
900
```

Good comments say what the code can't: why it's written this way, or what a rule means. A comment that repeats the code (`// adds one to count` above `count++;`) adds nothing, and a comment that no longer matches the code is worse than none.

A comment that states a rule is also a debugging aid: when the code and the comment above it disagree, one of them is wrong, and you've found where to look.

---

Source: [Names and comments](https://javaarena.com/learn/debugging/names-and-comments/) in the module [Finding bugs](https://javaarena.com/learn/debugging/) on Java Arena.

This module follows section [3.1 Discovering errors](https://java-programming.mooc.fi/part-3/1-discovering-errors) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
