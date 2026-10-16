> [!info] AI-Generated

# Calculating with input

Numbers read from the user work like any other numbers once they're converted. A common pattern: read, calculate, then print the result.

```java
Scanner scanner = new Scanner(System.in);
int price = Integer.valueOf(scanner.nextLine());
int count = Integer.valueOf(scanner.nextLine());
int total = price * count;
System.out.println("Total: " + total);
```

**Input**

```text
12
4
```

**Output**

```text
Total: 48
```

Storing the result in its own variable (`total` here) gives it a name, which makes the program easier to read than one long line. It also lets you use the result more than once.

---

Source: [Calculating with input](https://javaarena.com/learn/calculating/calculating-with-input/) in the module [Calculating with numbers](https://javaarena.com/learn/calculating/) on Java Arena.

This module follows section [1.5 Calculating with numbers](https://java-programming.mooc.fi/part-1/5-calculating) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
