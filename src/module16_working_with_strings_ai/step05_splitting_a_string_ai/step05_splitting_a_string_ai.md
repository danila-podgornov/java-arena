> [!info] AI-Generated

# Splitting a string

Text often holds several values in a row: the words of a sentence, or the day, month and year of a date. `split` cuts a string at every place where a separator appears, and returns the pieces in an **array** of Strings, a `String[]`:

```java
String sentence = "cats like warm sunny windows";
String[] words = sentence.split(" ");
System.out.println(words.length);
System.out.println(words[0]);
System.out.println(words[words.length - 1]);
```

**Output**

```text
5
cats
windows
```

- The separator isn't part of any piece: here the spaces are gone.
- `words.length` is the number of pieces. No parentheses: it's an array, not a String.
- `words[0]` is the first piece and `words[words.length - 1]` the last, as in any array.

To handle every piece, loop over the array. The for-each loop works on arrays just like on lists:

```java
String sentence = "a long and winding road leads here";
int longWords = 0;
for (String word : sentence.split(" ")) {
    if (word.length() > 4) {
        longWords++;
    }
}
System.out.println(longWords + " words have more than 4 letters");
```

**Output**

```text
2 words have more than 4 letters
```

Any text can be the separator. A date splits at its dashes:

```java
String date = "2025-03-14";
String[] parts = date.split("-");
System.out.println("Day " + parts[2] + ", month " + parts[1] + ", year " + parts[0]);
```

**Output**

```text
Day 14, month 03, year 2025
```

Two things to watch for:

- Two separators in a row have an empty piece between them: `"a  b".split(" ")`, with two spaces, gives three pieces: `a`, the empty string and `b`.
- `split` reads its separator as a pattern, in which a few characters have a special meaning. The dot and `|` are two of them: to split at a dot, write `split("\\.")`. Spaces, commas, semicolons, colons, dashes and slashes work just as they are.

---

Source: [Splitting a string](https://javaarena.com/learn/strings/splitting/) in the module [Working with strings](https://javaarena.com/learn/strings/) on Java Arena.

This module follows sections [3.4 Using strings](https://java-programming.mooc.fi/part-3/4-using-strings), [3.5 Summary](https://java-programming.mooc.fi/part-3/5-increasing-amounts-of-data) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
