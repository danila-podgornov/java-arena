> [!info] AI-Generated

# Strings again

Strings have been with you since module 2: `nextLine()` reads one, `+` joins them, and `println` prints them. You've compared them with `equals` (module 6) and built them up in a loop with `+=` (module 11). This module is about what else you can do with text: look at its characters, cut out pieces, and split a line into parts. That's how a program makes sense of input such as `Aino,42`.

## Methods of a String

A String has methods of its own. You call them with a dot after the string, the same way you call `nextLine()` on a scanner. `length()` tells how many characters the string has:

```java
Scanner scanner = new Scanner(System.in);
System.out.println("Name of your pet?");
String pet = scanner.nextLine();
System.out.println(pet + " has " + pet.length() + " characters");
```

**Input**

```text
Mr Biscuit
```

**Output**

```text
Name of your pet?
Mr Biscuit has 10 characters
```

Every character counts, the space included. The empty string `""`, which is what `nextLine()` gives when the user presses Enter without typing anything, has the length 0. `isEmpty()` is `true` for it, and `false` for any other string.

## Strings can't be changed

`toUpperCase()`, `toLowerCase()` and `trim()` look as if they change a string, but they don't: each one gives back a **new** string. `trim()` removes the spaces at the start and at the end, not the ones in the middle. The brackets show where the spaces are:

```java
String title = "  Tea Time ";
System.out.println("[" + title.toUpperCase() + "]");
System.out.println("[" + title.toLowerCase() + "]");
System.out.println("[" + title.trim() + "]");
System.out.println("[" + title + "]");
```

**Output**

```text
[  TEA TIME ]
[  tea time ]
[Tea Time]
[  Tea Time ]
```

The last line shows that `title` is still what it was. No String method ever changes the string it's called on: Strings are **immutable**. To keep a result, store it, often in the same variable: `title = title.trim();`. A line like `title.trim();` on its own does nothing useful, because the new string is thrown away, just like the value of a method call that isn't used (module 11).

Since each of these methods returns a string, you can call another method on the result straight away. `title.trim().toUpperCase()` trims first and then makes capitals of the trimmed text: `TEA TIME`.

---

Source: [Strings again](https://javaarena.com/learn/strings/strings-again/) in the module [Working with strings](https://javaarena.com/learn/strings/) on Java Arena.

This module follows sections [3.4 Using strings](https://java-programming.mooc.fi/part-3/4-using-strings), [3.5 Summary](https://java-programming.mooc.fi/part-3/5-increasing-amounts-of-data) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
