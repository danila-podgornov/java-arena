> [!info] AI-Generated

# Text blocks and formatted text

## Text blocks

Text of several lines, such as a ticket, has so far been many `println` calls, or one String full of `\n`. Since Java 15, a **text block** holds text of several lines as it looks. It starts with three double quotes and a line break, and ends with three double quotes:

```java
String ticket = """
        FERRY TICKET
        From: Harbor A
        To:   Island Pier
          Deck seat 14
        """;
System.out.print(ticket);
```

**Output**

```text
FERRY TICKET
From: Harbor A
To:   Island Pier
  Deck seat 14
```

- The text starts on the line after the opening `"""`. Nothing but spaces may follow the opening quotes on their line.
- The lines are indented to fit the code, and javac removes that indentation: it finds the line with the fewest spaces in front (lines with nothing else on them don't count), counting the line of the closing `"""` too, and removes that many spaces from every line. Here the closing quotes are as far in as `FERRY TICKET`, so `FERRY TICKET` starts at the left edge, and `Deck seat 14`, two spaces further in, keeps its two spaces.
- Since the closing `"""` is on a line of its own, the text ends with a line break, after `Deck seat 14`. That's why the example uses `print`: `println` would add a second line break, an empty line. Write the closing quotes right after the last word, `Deck seat 14""";`, for a text block without that last line break.
- A double quote inside a text block needs no backslash: `Seat "14"` can be written as it is. `\n` and `\t` still work, a backslash at the very end of a line joins it with the next one, and spaces at the end of a line are removed (write `\s` for a space that must stay).

Text on the line of the opening quotes doesn't compile:

```java
public class Main {
    public static void main(String[] args) {
        String sign = """Closed
            today""";
        System.out.println(sign);
    }
}
```

**What javac prints**

```text
Main.java:3: error: illegal text block open delimiter sequence, missing line terminator
        String sign = """Closed
                         ^
Main.java:4: error: illegal text block open delimiter sequence, missing line terminator
            today""";
                    ^
2 errors
```

A text block is an ordinary String once it's made: `ticket.length()`, `ticket.split("\n")` and the rest work as always.

## String.format

Building a line from text and values with `+` gets hard to read when there are many of them. `String.format` takes a **format**, a String with places marked by `%`, and the values to put there, in order:

```java
String name = "Ada";
int seat = 14;
double price = 23.5;
String line = String.format("%s sits in seat %d and paid %.2f euros", name, seat, price);
System.out.println(line);
System.out.printf("Seat %d of %d%n", seat, 120);
```

**Output**

```text
Ada sits in seat 14 and paid 23.50 euros
Seat 14 of 120
```

- `%s` puts a value as text (any value: a String, a number, an object's `toString`), `%d` a whole number, and `%f` a decimal number. `%.2f` rounds it to two decimals.
- `System.out.printf` formats and prints in one go. Unlike `println`, it adds no line break: `%n` in the format is one.
- Since Java 15, a String has the method `formatted`, which does the same with the String as the format: `"Seat %d".formatted(seat)`. It goes well with a text block: write the text block with `%s` and `%d` in it, and call `.formatted(...)` on it.
- `%%` prints a percent sign.
- The decimal point follows the language settings of the computer: on Java Arena it's a point, but `String.format("%.2f", 23.5)` gives `23,50` on a computer set up for a language that writes a comma, such as German or Finnish.

A value of the wrong kind for its place is an error only when the program runs: `%d` with a double crashes.

```java
public class Main {
    public static void main(String[] args) {
        double weight = 2.5;
        System.out.println(String.format("%d kg", weight));
    }
}
```

**The program crashes with**

```text
Exception in thread "main" java.util.IllegalFormatConversionException: d != java.lang.Double
	at Main.main(Main.java:4)
```

## Columns

A number between the `%` and the letter is a **width**: the value takes at least that many characters, padded with spaces in front, so that it's right-aligned. A minus sign pads after the value instead, which aligns it left. `%8.2f` is a decimal number with two decimals in eight characters, `%-10s` a text left-aligned in ten, and `%03d` pads a whole number with zeros instead of spaces:

```java
System.out.println(String.format("%-10s|%8.2f|", "tea", 3.5));
System.out.println(String.format("%-10s|%8.2f|", "cake", 12.25));
System.out.println(String.format("Locker %03d", 7));
```

**Output**

```text
tea       |    3.50|
cake      |   12.25|
Locker 007
```

Every line has its name in the same ten characters and its price in the same eight, so the columns line up, whatever the lengths. A value longer than its width isn't cut: it just takes more room.

---

Source: [Text blocks and formatted text](https://javaarena.com/learn/switch-and-text/text-blocks-and-format/) in the module [switch, var and text blocks](https://javaarena.com/learn/switch-and-text/) on Java Arena.

An extra module, not part of the University of Helsinki's course. Lesson text: [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/).
