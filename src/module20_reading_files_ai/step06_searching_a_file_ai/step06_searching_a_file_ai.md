> [!info] AI-Generated

# Searching a file

Many questions about a file are answered by going through its lines once and checking each one. How many lines mention something? Is a certain line there at all? This program counts and prints the lines of a log that contain the word `ERROR`:

**The file log.txt**

```text
08:00 start
08:15 ERROR disk almost full
09:30 backup done
10:05 ERROR connection lost
10:06 connection back
```

```java
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int errors = 0;
        try (Scanner scanner = new Scanner(Paths.get("log.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("ERROR")) {
                    System.out.println(line);
                    errors++;
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Errors: " + errors);
    }
}
```

**Output**

```text
08:15 ERROR disk almost full
10:05 ERROR connection lost
Errors: 2
```

Any String method can do the checking: `contains` for a part of the line, `startsWith` for its beginning, `equals` for the whole line, `equalsIgnoreCase` when capitals shouldn't matter.

## Is a line there?

To find out whether something is in the file at all, keep a `boolean` that starts as `false` and becomes `true` when a line matches. The answer is known only after the loop, once every line has been checked. Here the user types a discount code, and the program looks for it in the file of valid codes:

**The file codes.txt**

```text
WELCOME5
SPRING10
FRIEND20
```

```java
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String code = scanner.nextLine();
        boolean found = false;
        try (Scanner fileScanner = new Scanner(Paths.get("codes.txt"))) {
            while (fileScanner.hasNextLine()) {
                if (fileScanner.nextLine().equals(code)) {
                    found = true;
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        if (found) {
            System.out.println("Code accepted");
        } else {
            System.out.println("Unknown code");
        }
    }
}
```

**Input**

```text
SPRING10
```

**Output**

```text
Code accepted
```

- `equals` compares whole lines. With `contains`, the code `RING1` would be accepted too, since it's inside `SPRING10`.
- The answer is printed after the loop. Printed inside it, there would be an answer for every line of the file.

---

Source: [Searching a file](https://javaarena.com/learn/reading-files/searching-a-file/) in the module [Reading files](https://javaarena.com/learn/reading-files/) on Java Arena.

This module follows sections [4.3 Files and reading data](https://java-programming.mooc.fi/part-4/3-files-and-reading-data), [4.4 Summary](https://java-programming.mooc.fi/part-4/4-summary) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
