> [!info] AI-Generated

# Reading integers

`scanner.nextLine()` always gives text, a String, even when the user types digits. To calculate with the number, the text has to be turned into an `int`. `Integer.valueOf(...)` does that:

```java
Scanner scanner = new Scanner(System.in);
System.out.println("How old are you?");
int age = Integer.valueOf(scanner.nextLine());
System.out.println("Next year you'll be " + (age + 1) + ".");
```

**Input**

```text
29
```

**Output**

```text
How old are you?
Next year you'll be 30.
```

Reading and converting fit on one line: the inner part, `scanner.nextLine()`, runs first and gives the text `"29"`, and `Integer.valueOf` turns it into the number `29`. (`age + 1` in parentheses is calculated before it's joined to the text; the next module is all about calculating.)

`Integer.parseInt(...)` does the same job, and you'll see both in Java code. If the text isn't a whole number, for example `twenty` or `2.5`, the program stops with a `NumberFormatException`.

---

Source: [Reading integers](https://javaarena.com/learn/variables/reading-integers/) in the module [Variables and types](https://javaarena.com/learn/variables/) on Java Arena.

This module follows section [1.4 Variables](https://java-programming.mooc.fi/part-1/4-variables) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
