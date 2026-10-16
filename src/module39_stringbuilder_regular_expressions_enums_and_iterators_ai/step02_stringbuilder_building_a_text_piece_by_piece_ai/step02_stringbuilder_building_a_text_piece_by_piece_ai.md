> [!info] AI-Generated

# StringBuilder: building a text piece by piece

Programs often build a text from many pieces: a receipt from its lines, or a list of names with commas between them. Module 24's bookshelf built its `toString` with `text = text + "\n" + book` in a loop. Here's the same idea, smaller. A seaside town rents out six beach huts, B1 to B6, which stand in a row, and its booking page draws them as a row of boxes:

```java
String row = "";
for (int hut = 1; hut <= 6; hut++) {
    row += "|B" + hut;
}
row += "|";
System.out.println(row);
```

**Output**

```text
|B1|B2|B3|B4|B5|B6|
```

## Why += in a loop is slow

A String never changes after it's made. `row += "|B" + hut` doesn't add to the old String: it makes a new one, copies every character of the old one into it, then the new piece, and the old String is thrown away. Each hut's piece is 3 characters, so the first round copies 3 characters, the second 6, the third 9, and so on. Every round copies everything built so far, once more.

For six huts, that's nothing. For 1,000 pieces of 3 characters each, the rounds copy 3 + 6 + 9 + ... + 3,000 characters: 1,501,500 in all, to make a text of 3,000 characters. Twice as many pieces means about four times as much copying, so a loop that builds a long text this way gets slower and slower as the text grows.

## StringBuilder

Java's **StringBuilder** is a text that can change. It keeps its characters with room to spare, and `append` writes a new piece at the end, without copying what's already there. (When the room runs out, it makes a bigger one, again with room to spare.)

```java
StringBuilder row = new StringBuilder();
for (int hut = 1; hut <= 6; hut++) {
    row.append("|B");
    row.append(hut);
}
row.append("|");
String text = row.toString();
System.out.println(text);
```

**Output**

```text
|B1|B2|B3|B4|B5|B6|
```

- `new StringBuilder()` makes an empty one, and `new StringBuilder("Total")` one that starts with a text.
- `new StringBuilder(5)` doesn't hold 5: a number in the parentheses only sets how much room it starts with, and the text is empty. Use `new StringBuilder().append(5)`.
- `append` adds anything to the end: a String, an int, a double, a char or a boolean.
- `toString()` returns the finished text as a String. Printing a StringBuilder, or joining it to a String with `+`, calls it for you, as for any object. A method that returns a `String` needs it: `return row.toString();`
- StringBuilder is in the package `java.lang`, like String, so it needs no import.

`append` returns the StringBuilder itself, so the calls can be chained: `row.append("|B").append(hut);` does the two appends in the loop in one statement.

## A receipt

Here's a receipt, built line by line. Step 1's index loop goes through the two lists side by side, and `\n` is a line break, as in module 24:

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> items = new ArrayList<>();
        items.add("Hammer");
        items.add("Nails");
        items.add("Tape");
        ArrayList<Integer> prices = new ArrayList<>();
        prices.add(12);
        prices.add(4);
        prices.add(3);
        System.out.println(receipt(items, prices));
    }

    public static String receipt(ArrayList<String> items, ArrayList<Integer> prices) {
        StringBuilder text = new StringBuilder();
        int total = 0;
        for (int i = 0; i < items.size(); i++) {
            text.append(items.get(i)).append(": ").append(prices.get(i)).append(" dollars\n");
            total += prices.get(i);
        }
        text.append("Total: ").append(total).append(" dollars");
        return text.toString();
    }
}
```

**Output**

```text
Hammer: 12 dollars
Nails: 4 dollars
Tape: 3 dollars
Total: 19 dollars
```

## insert, reverse and length

- `insert(index, text)` puts a text at a position, and moves everything after it to the right. `insert(0, ...)` adds to the front.
- `reverse()` turns the characters around.
- `length()` and `charAt(index)` work as they do for a String.

```java
StringBuilder code = new StringBuilder("4821");
code.insert(0, "#");
code.insert(3, "-");
System.out.println(code);
code.reverse();
System.out.println(code + " has " + code.length() + " characters");
```

**Output**

```text
#48-21
12-84# has 6 characters
```

After the first insert, the text is `#4821`, and `insert(3, "-")` puts the dash in front of index 3, the 2.

## Comparing the text

A StringBuilder has no `equals` of its own. It has Object's, which asks whether two variables refer to the same object (modules 23 and 34), so a StringBuilder is never equal to a String. To compare the text, turn it into a String first:

```java
String word = "level";
StringBuilder backwards = new StringBuilder(word).reverse();
System.out.println(backwards.equals(word));
System.out.println(backwards.toString().equals(word));
```

**Output**

```text
false
true
```

"level" reads the same backwards, but only the second line says so.

`+` is still the clearest way to join a few pieces in one expression, as in `return this.name + " (" + this.age + ")";`. StringBuilder is for a text that grows in a loop.

---

Source: [StringBuilder: building a text piece by piece](https://javaarena.com/learn/useful-techniques/stringbuilder/) in the module [StringBuilder, regular expressions, enums and iterators](https://javaarena.com/learn/useful-techniques/) on Java Arena.

This module follows sections [10.3 Other useful techniques](https://java-programming.mooc.fi/part-10/3-other-useful-techniques), [10.4 Summary](https://java-programming.mooc.fi/part-10/4-summary) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
