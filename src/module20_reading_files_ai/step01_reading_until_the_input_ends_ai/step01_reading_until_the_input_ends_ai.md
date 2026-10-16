> [!info] AI-Generated

# Reading until the input ends

This module is about reading data from files. A program reads a file one line at a time, much as it reads what a user types, so it starts at the keyboard.

Module 19 read input in a `while (true)` loop that stops at a signal, such as an empty line: read a line, `break` if it's the signal, and only then use it. This step adds two more ways to know when to stop.

## Until the input ends

A Scanner's `hasNextLine()` tells whether there's another line to read. It's `true` while there is one, and `false` once the input has ended, so a loop can read every line without waiting for a signal:

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            count++;
            System.out.println(count + ": " + line);
        }
        System.out.println("Lines: " + count);
    }
}
```

**Input**

```text
red
green
blue
```

**Output**

```text
1: red
2: green
3: blue
Lines: 3
```

- `hasNextLine()` only looks. `nextLine()` then reads the line, so the next round sees the line after it.
- An empty line is a line too: `hasNextLine()` is `true` for it, and `nextLine()` gives `""`.
- In the checks on this site, the input ends after its last line. A person at a keyboard has no natural end, which is why keyboard programs usually wait for a stop signal instead. (In a terminal, Ctrl+D ends the input, or Ctrl+Z and then Enter on Windows.)

A file does have an end, and this loop is exactly how the next steps read one.

## A stop word in any capitals

A stop word typed by a person may come as `end`, `End` or `END`. `equalsIgnoreCase` from module 16 accepts all of them:

```java
String line = scanner.nextLine();
if (line.equalsIgnoreCase("end")) {
    break;
}
```

---

Source: [Reading until the input ends](https://javaarena.com/learn/reading-files/reading-until-end/) in the module [Reading files](https://javaarena.com/learn/reading-files/) on Java Arena.

This module follows sections [4.3 Files and reading data](https://java-programming.mooc.fi/part-4/3-files-and-reading-data), [4.4 Summary](https://java-programming.mooc.fi/part-4/4-summary) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
