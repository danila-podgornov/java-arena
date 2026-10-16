> [!info] AI-Generated

# String variables

A **variable** is a named place that holds a value. `String message = scanner.nextLine();` in the last step created one. Variables can also get their value straight from the code:

```java
String food = "pizza";
System.out.println(food);
System.out.println("food");
```

**Output**

```text
pizza
food
```

The line `String food = "pizza";` has three parts:

- `String` is the variable's **type**: what kind of value it holds. A `String` holds text.
- `food` is the variable's **name**. You choose it.
- `= "pizza"` gives it its value.

After that, the name stands for the value. That's why `System.out.println(food)` prints `pizza`, while `System.out.println("food")`, with quotes, prints the word `food` itself. Quotes mean "this exact text"; no quotes mean "the value of this variable".

A variable has to be created before it's used, and Java checks the name's spelling and capitals: `Food` and `food` are two different names.

---

Source: [String variables](https://javaarena.com/learn/reading-input/string-variables/) in the module [Reading input and strings](https://javaarena.com/learn/reading-input/) on Java Arena.

This module follows section [1.3 Reading input](https://java-programming.mooc.fi/part-1/3-reading) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
