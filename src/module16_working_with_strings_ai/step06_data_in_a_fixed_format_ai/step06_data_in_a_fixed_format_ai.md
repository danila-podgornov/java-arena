> [!info] AI-Generated

# Data in a fixed format

Programs often read data in which every line has the same shape: a name and a score, or a city and a temperature. The values are separated by a character that doesn't appear in the values themselves, often a comma or a semicolon:

```text
Mira,87
Otto,92
```

Each line is split at the separator, and the parts are picked out by their index. The parts are Strings, so a number has to be turned into an `int` with `Integer.valueOf` (or into a `double` with `Double.valueOf`) before you can calculate with it:

```java
String line = "Mira,87";
String[] parts = line.split(",");
String name = parts[0];
int score = Integer.valueOf(parts[1]);
System.out.println(name + " scored " + score);
System.out.println("With the bonus: " + (score + 5));
```

**Output**

```text
Mira scored 87
With the bonus: 92
```

Without `Integer.valueOf`, `parts[1] + 5` would join the two as text and give `875`.

Decimal numbers separated by semicolons work the same way:

```java
String line = "Oulu;-4.5";
String[] parts = line.split(";");
double temperature = Double.valueOf(parts[1]);
if (temperature < 0) {
    System.out.println(parts[0] + " is below freezing");
}
```

**Output**

```text
Oulu is below freezing
```

## A space too many

Data typed by people isn't always tidy. If a line has a space after the comma, the second part starts with that space, and `Integer.valueOf` refuses it:

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] parts = line.split(",");
        int score = Integer.valueOf(parts[1]);
        System.out.println(parts[0] + ": " + score);
    }
}
```

**Input**

```text
Mira, 87
```

**The program crashes with**

```text
Exception in thread "main" java.lang.NumberFormatException: For input string: " 87"
	at Main.main(Main.java:8)
```

The quotes in the message show the culprit: the text was `" 87"`, with a space in front. `trim()` removes it, so `Integer.valueOf(parts[1].trim())` works whether the space is there or not.

A line with no comma at all splits into just one part, and `parts[1]` then crashes with an `ArrayIndexOutOfBoundsException`. When the input might have lines like that, check `parts.length` before you use the parts.

---

Source: [Data in a fixed format](https://javaarena.com/learn/strings/fixed-format-data/) in the module [Working with strings](https://javaarena.com/learn/strings/) on Java Arena.

This module follows sections [3.4 Using strings](https://java-programming.mooc.fi/part-3/4-using-strings), [3.5 Summary](https://java-programming.mooc.fi/part-3/5-increasing-amounts-of-data) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
