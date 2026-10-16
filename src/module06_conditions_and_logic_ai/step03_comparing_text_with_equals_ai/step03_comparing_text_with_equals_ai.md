> [!info] AI-Generated

# Comparing text with equals

Text is compared with `equals`, not with `==`:

```java
Scanner scanner = new Scanner(System.in);
String first = scanner.nextLine();
String second = scanner.nextLine();
System.out.println(first.equals(second));
System.out.println(first == second);
```

**Input**

```text
cat
cat
```

**Output**

```text
true
false
```

Both lines are `cat`, yet `==` says false. For Strings, `==` doesn't check whether the texts are the same: it checks whether the two variables refer to the very same String object in memory. Every `nextLine()` that reads some text makes a new String, so two reads of the same word aren't `==`. `first.equals(second)` compares the characters, which is what you want. Module 22 explains objects and references properly.

To compare with a fixed word, write the text in quotes: `command.equals("quit")`. Capitals count: `"Quit".equals("quit")` is false. `equalsIgnoreCase` ignores them.

---

Source: [Comparing text with equals](https://javaarena.com/learn/boolean-logic/comparing-strings/) in the module [Conditions and logic](https://javaarena.com/learn/boolean-logic/) on Java Arena.

This module follows sections [1.6 Conditional statements and conditional operation](https://java-programming.mooc.fi/part-1/6-conditional-statements), [1.7 Programming in our society](https://java-programming.mooc.fi/part-1/7-programming-in-our-society) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
