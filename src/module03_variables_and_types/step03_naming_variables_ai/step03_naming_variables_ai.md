> [!info] AI-Generated

# Naming variables

You choose each variable's name. A good name says what the value means: `price`, `laps`, `firstName`. Java has a few rules for names:

- Letters, digits, `_` and `$` are allowed, but a name can't **start** with a digit: `level2` is fine, `2ndLevel` isn't.
- No spaces and no other symbols, like `!`, `-` or `.`.
- Words that are part of Java itself, such as `class`, `int` or `public`, can't be names.
- Capitals matter: `score` and `Score` are two different names.

When a name is made of several words, Java programmers write it in **camelCase**: the first word in lower case, and every following word starting with a capital: `firstName`, `numberOfLaps`, `isRaining`.

```java
String firstName = "Grace";
int yearOfBirth = 1906;
System.out.println(firstName + " was born in " + yearOfBirth + ".");
```

**Output**

```text
Grace was born in 1906.
```

A name that breaks the rules confuses the compiler, and its errors can look strange. `String first name` gives `';' expected`, because Java reads `first` as the whole name and then doesn't know what `name` is doing there.

---

Source: [Naming variables](https://javaarena.com/learn/variables/naming-variables/) in the module [Variables and types](https://javaarena.com/learn/variables/) on Java Arena.

This module follows section [1.4 Variables](https://java-programming.mooc.fi/part-1/4-variables) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
