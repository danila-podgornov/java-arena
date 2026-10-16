> [!info] AI-Generated

# Comparing strings

Module 6 showed that text is compared with `equals`. Here's the rule once more, with the reason behind it. `==` asks whether two variables refer to one and the same String object in memory, while `equals` compares the characters:

```java
answer == "yes"         // wrong: are they the very same object?
answer.equals("yes")    // right: do they have the same characters?
```

What makes `==` tricky is that it sometimes seems to work. Java may reuse one String object for equal texts written in the code, and whether two strings end up as the same object depends on where they came from and on Java's own internals. So a program that compares text with `==` can pass a quick test and then fail on real input. With `equals`, the result depends only on the text. (For `int` and `char` values, which aren't objects, `==` is the right tool.)

## Ignoring capitals

`equals` counts capitals: `"Yes".equals("yes")` is `false`. When capitals shouldn't matter, use `equalsIgnoreCase`:

```java
Scanner scanner = new Scanner(System.in);
System.out.println("Play again? (yes/no)");
String answer = scanner.nextLine();
if (answer.equalsIgnoreCase("yes")) {
    System.out.println("New game!");
} else {
    System.out.println("Thanks for playing");
}
```

**Input**

```text
YES
```

**Output**

```text
Play again? (yes/no)
New game!
```

Two more tools go well with comparing:

- `!` in front turns the result around: `if (!answer.equals("no"))` runs its block for every answer except `no`.
- People sometimes type a space before or after a word without noticing. `answer.trim().equalsIgnoreCase("yes")` trims first and then compares, so `" Yes "` counts too.

A method can return the result of a comparison as a `boolean`:

```java
public class Main {
    public static void main(String[] args) {
        System.out.println(isWeekend("Sunday"));
        System.out.println(isWeekend("monday"));
        System.out.println(isWeekend("SATURDAY"));
    }

    public static boolean isWeekend(String day) {
        return day.equalsIgnoreCase("saturday") || day.equalsIgnoreCase("sunday");
    }
}
```

**Output**

```text
true
false
true
```

---

Source: [Comparing strings](https://javaarena.com/learn/strings/comparing-strings/) in the module [Working with strings](https://javaarena.com/learn/strings/) on Java Arena.

This module follows sections [3.4 Using strings](https://java-programming.mooc.fi/part-3/4-using-strings), [3.5 Summary](https://java-programming.mooc.fi/part-3/5-increasing-amounts-of-data) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
