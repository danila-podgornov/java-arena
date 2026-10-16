> [!info] AI-Generated

# Taking text apart

Input often packs several values into one line of text. A program cuts the line into parts, turns the parts that are numbers into numbers, and asks questions about the parts that are words.

## The tools

| Tool | What it does | Taught in |
| --- | --- | --- |
| `line.split(",")` | cuts a line at every comma, into an array of parts | module 16, Working with strings |
| `parts.length`, `parts[0]` | how many parts there are, and one part | module 15, Arrays |
| `Integer.valueOf(parts[1])` | a part that holds a whole number, as an int | module 3, Variables and types, and module 16 |
| `text.equals(other)` | the same text? Never compare text with `==` | module 6, Conditions and logic |
| `contains`, `startsWith`, `endsWith` | yes-or-no questions about text | module 16, Working with strings |
| `text.trim()` | the text without spaces at either end | module 16, Working with strings |

## Words on a line

Chess players write down their games move by move. Each move is a short code, such as `Nf3` (a knight moves to the square f3). An `x` in a move means it captures a piece, and a `+` at the end means it puts the other king in check. Here are the first moves of a game, one code for each player's move, separated by spaces:

```java
String moves = "e4 e5 Nf3 Nc6 Bb5 a6 Bxc6 dxc6";
String[] parts = moves.split(" ");
int captures = 0;
for (String move : parts) {
    if (move.contains("x")) {
        captures++;
    }
}
System.out.println(parts.length + " moves, " + captures + " captures");
System.out.println("Last move: " + parts[parts.length - 1]);
```

**Output**

```text
8 moves, 2 captures
Last move: dxc6
```

- `split(" ")` gives an array of Strings, one per move, and a for-each loop goes through them.
- `contains("x")` asks whether the letter appears anywhere in the move. It counts capital letters apart from small ones: `contains("X")` would find nothing here.
- The last part is at the index `parts.length - 1`.

## A line of comma-separated values

A climbing gym's member list has one line per member: the name, the age and the number of visits this month, separated by commas. Someone typed a space after each comma. The gym calls a member with 8 visits or more in a month a regular.

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] parts = scanner.nextLine().split(",");
        String name = parts[0].trim();
        int age = Integer.valueOf(parts[1].trim());
        int visits = Integer.valueOf(parts[2].trim());
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Visits: " + visits);
        System.out.println("Regular: " + (visits >= 8));
    }
}
```

**Input**

```text
Mira Koski, 34, 12
```

**Output**

```text
Name: Mira Koski
Age: 34
Visits: 12
Regular: true
```

- The parts are Strings, even when they hold digits. `Integer.valueOf` turns them into ints. Without it, `parts[2].trim() + 1` would join the texts and give `121`.
- `split(",")` cuts only at the commas, so the second part is `" 34"`, with the space in front. `Integer.valueOf(" 34")` throws a NumberFormatException, and `trim()` removes the space first (module 16).
- A line with fewer than three parts would crash at `parts[2]` with an ArrayIndexOutOfBoundsException. When lines can be broken, check `parts.length` first and skip the line (module 29).

---

Source: [Taking text apart](https://javaarena.com/learn/recap/text/) in the module [Warm-up: recap of parts 1 to 7](https://javaarena.com/learn/recap/) on Java Arena.

This module follows section [8.1 Short recap](https://java-programming.mooc.fi/part-8/1-recap) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
