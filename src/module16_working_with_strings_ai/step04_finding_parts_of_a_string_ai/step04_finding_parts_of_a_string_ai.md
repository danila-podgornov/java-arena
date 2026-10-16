> [!info] AI-Generated

# Finding parts of a string

`substring` cuts a piece out of a string. Like every String method, it gives back a new string and leaves the original whole.

- `substring(start)` gives everything from the index `start` to the end.
- `substring(start, end)` gives the characters from `start` up to, **but not including**, `end`.

| Index | 0 | 1 | 2 | 3 | 4 | 5 |
|---|---|---|---|---|---|---|
| `"carpet"` | c | a | r | p | e | t |

```java
String word = "carpet";
System.out.println(word.substring(3));
System.out.println(word.substring(0, 3));
System.out.println(word.substring(1, 4));
```

**Output**

```text
pet
car
arp
```

Because the end isn't included, `substring(start, end)` is always `end - start` characters long: `substring(1, 4)` has 3. An index past the end crashes the program with the same `StringIndexOutOfBoundsException` as `charAt`.

## Searching in a string

`indexOf` looks for a piece of text and returns the index where it first starts, or -1 when it isn't there. Together with `substring`, it cuts a string at a certain character, wherever that character happens to be:

```java
String email = "ada@example.com";
int at = email.indexOf("@");
System.out.println(at);
System.out.println(email.substring(0, at));
System.out.println(email.substring(at + 1));
System.out.println(email.indexOf("#"));
```

**Output**

```text
3
ada
example.com
-1
```

Three more methods answer yes-or-no questions with a `boolean`:

```java
String file = "holiday-photo.jpg";
System.out.println(file.contains("photo"));
System.out.println(file.startsWith("holiday"));
System.out.println(file.endsWith(".png"));
```

**Output**

```text
true
true
false
```

All of these count capitals: `"Photo.JPG".endsWith(".jpg")` is `false`. When capitals shouldn't matter, make the text small first: `file.toLowerCase().endsWith(".jpg")`.

---

Source: [Finding parts of a string](https://javaarena.com/learn/strings/finding-parts/) in the module [Working with strings](https://javaarena.com/learn/strings/) on Java Arena.

This module follows sections [3.4 Using strings](https://java-programming.mooc.fi/part-3/4-using-strings), [3.5 Summary](https://java-programming.mooc.fi/part-3/5-increasing-amounts-of-data) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
