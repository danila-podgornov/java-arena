> [!info] AI-Generated

# Joining strings with +

Between pieces of text, `+` joins them into one longer text. This is called **concatenation**. It works with variables too, so a program can build a sentence around what the user typed:

```java
Scanner scanner = new Scanner(System.in);
System.out.println("What is your name?");
String name = scanner.nextLine();
System.out.println("Hi " + name + ", nice to meet you!");
```

**Input**

```text
Ada
```

**Output**

```text
What is your name?
Hi Ada, nice to meet you!
```

(From here on, some examples show only the lines inside `main`. The class, the main method and the import around them are the same as before.)

`+` adds no spaces of its own. Every space in the result has to be inside some quotes: `"Hi " + name` gives `Hi Ada`, but `"Hi" + name` gives `HiAda`. The same goes for commas and other punctuation.

A single `println` can join as many pieces as you like: `"a" + b + "c" + d` works from left to right.

---

Source: [Joining strings with +](https://javaarena.com/learn/reading-input/joining-strings/) in the module [Reading input and strings](https://javaarena.com/learn/reading-input/) on Java Arena.

This module follows section [1.3 Reading input](https://java-programming.mooc.fi/part-1/3-reading) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
