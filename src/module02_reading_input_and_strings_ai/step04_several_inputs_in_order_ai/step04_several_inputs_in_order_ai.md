> [!info] AI-Generated

# Several inputs in order

Each call to `nextLine()` reads the next line of input, so a program can read as many lines as it needs, one after another. They're read in order: the first `nextLine()` gets the first line, the second gets the second, and so on. The program waits at each `nextLine()` until a line is there.

```java
Scanner scanner = new Scanner(System.in);
System.out.println("First word?");
String first = scanner.nextLine();
System.out.println("Second word?");
String second = scanner.nextLine();
System.out.println(second + " " + first);
```

**Input**

```text
world
hello
```

**Output**

```text
First word?
Second word?
hello world
```

The variables keep their values, so the program can print them in any order and as often as it likes. Only the reading has to follow the order of the input.

If a program asks for more lines than the input has, it stops with an error: `NoSuchElementException: No line found`. When that happens on this site, the result explains it. It usually means the program reads one line too many.

---

Source: [Several inputs in order](https://javaarena.com/learn/reading-input/several-inputs/) in the module [Reading input and strings](https://javaarena.com/learn/reading-input/) on Java Arena.

This module follows section [1.3 Reading input](https://java-programming.mooc.fi/part-1/3-reading) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
