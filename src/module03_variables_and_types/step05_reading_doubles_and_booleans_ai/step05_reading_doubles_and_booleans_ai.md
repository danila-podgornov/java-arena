> [!info] AI-Generated

# Reading doubles and booleans

Decimal numbers and true-or-false answers are read the same way: read a line, then convert it.

- `Double.valueOf(text)` turns text like `2.5` or `-0.75` into a `double`.
- `Boolean.valueOf(text)` gives `true` when the text is `true` in any mix of capitals (`TRUE`, `True`), and `false` for anything else.

```java
Scanner scanner = new Scanner(System.in);
double height = Double.valueOf(scanner.nextLine());
boolean ready = Boolean.valueOf(scanner.nextLine());
System.out.println("Height: " + height);
System.out.println("Ready: " + ready);
```

**Input**

```text
2
yes
```

**Output**

```text
Height: 2.0
Ready: false
```

Two things in that output are worth a second look:

- The input was `2`, but the program prints `2.0`. A `double` is always printed with its decimal part.
- The input was `yes`, which isn't `true`, so the boolean is `false`.

---

Source: [Reading doubles and booleans](https://javaarena.com/learn/variables/doubles-and-booleans/) in the module [Variables and types](https://javaarena.com/learn/variables/) on Java Arena.

This module follows section [1.4 Variables](https://java-programming.mooc.fi/part-1/4-variables) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
