> [!info] AI-Generated

# A small calculator

Time to put the operators together. A calculator program reads two numbers and prints one line per operation:

```java
Scanner scanner = new Scanner(System.in);
int a = Integer.valueOf(scanner.nextLine());
int b = Integer.valueOf(scanner.nextLine());
System.out.println(a + " + " + b + " = " + (a + b));
System.out.println(a + " / " + b + " = " + ((double) a / b));
```

**Input**

```text
7
2
```

**Output**

```text
7 + 2 = 9
7 / 2 = 3.5
```

Two details make it right:

- Each calculation is in parentheses, so it happens before the joining.
- The division casts to `double`, so `7 / 2` shows `3.5` and not `3`.

---

Source: [A small calculator](https://javaarena.com/learn/calculating/calculator/) in the module [Calculating with numbers](https://javaarena.com/learn/calculating/) on Java Arena.

This module follows section [1.5 Calculating with numbers](https://java-programming.mooc.fi/part-1/5-calculating) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
