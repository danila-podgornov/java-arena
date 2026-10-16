> [!info] AI-Generated

# Reading a file line by line

Here's the program from the previous step again, this time printing each line as it is:

**The file plants.txt**

```text
basil
mint
rosemary
```

```java
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(Paths.get("plants.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
```

**Output**

```text
basil
mint
rosemary
```

Its parts:

- `Paths.get("plants.txt")` turns the file's name into a **path**, Java's way of pointing to a file. `Paths` needs its own import at the top: `import java.nio.file.Paths;`.
- `new Scanner(...)` with a path makes a Scanner that reads the file instead of the keyboard (`System.in`). Its `nextLine()` works like the keyboard's: each call gives the next line, without the line break at its end.
- `scanner.hasNextLine()` works as it did on the keyboard in the first step: it's `true` until every line has been read, so the loop runs once for each line of the file and then stops.
- `try (...)` opens the file for the block after it and **closes** it when the block ends. A program should close a file when it's done with it, and this form of `try`, called **try-with-resources**, does that for you. The Scanner exists only inside the block's braces.
- `catch (Exception e) { ... }` is what happens when the reading fails, for example because there's no such file. The next step is about it.

Every round of the loop must call `nextLine()`. `hasNextLine()` only looks: if nothing reads the line, the same line stays waiting, `hasNextLine()` stays `true`, and the loop never ends.

## Keeping the lines in a list

The loop sees each line once. When the program needs the lines afterwards, for example to know how many there are or to use them in another order, it adds them to a list:

**The file plants.txt**

```text
basil
mint
rosemary
```

```java
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> plants = new ArrayList<>();
        try (Scanner scanner = new Scanner(Paths.get("plants.txt"))) {
            while (scanner.hasNextLine()) {
                plants.add(scanner.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Plants: " + plants.size());
        System.out.println("The last one: " + plants.get(plants.size() - 1));
    }
}
```

**Output**

```text
Plants: 3
The last one: rosemary
```

The list is made before the `try`, so it still exists after the block. A variable made inside the braces would be gone by then.

## A Scanner can read a String too

`new Scanner(...)` also takes a String, and then reads it as if it were a file. Inside quotes, `\n` stands for a line break, so the String below holds two lines. A String can't go missing, so no `try` is needed. It's a quick way to try out a loop, and some of the practice questions use it:

```java
Scanner scanner = new Scanner("first line\nsecond line");
while (scanner.hasNextLine()) {
    System.out.println("> " + scanner.nextLine());
}
```

**Output**

```text
> first line
> second line
```

---

Source: [Reading a file line by line](https://javaarena.com/learn/reading-files/reading-a-file/) in the module [Reading files](https://javaarena.com/learn/reading-files/) on Java Arena.

This module follows sections [4.3 Files and reading data](https://java-programming.mooc.fi/part-4/3-files-and-reading-data), [4.4 Summary](https://java-programming.mooc.fi/part-4/4-summary) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
