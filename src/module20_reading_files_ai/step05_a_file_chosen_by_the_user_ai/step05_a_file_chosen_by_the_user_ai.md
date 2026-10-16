> [!info] AI-Generated

# A file chosen by the user

A program is more useful when the user can pick the file. It then needs two Scanners: one for the keyboard and one for the file, each with a name of its own:

**The file shopping.txt**

```text
apples
bread
coffee
```

```java
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which file?");
        String fileName = scanner.nextLine();

        try (Scanner fileScanner = new Scanner(Paths.get(fileName))) {
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
```

**Input**

```text
shopping.txt
```

**Output**

```text
Which file?
apples
bread
coffee
```

- `scanner` reads the keyboard, and `fileScanner` reads the file. Mixing them up is an easy slip: `scanner.nextLine()` inside the loop would read the keyboard, not the file.
- `Paths.get(fileName)` takes any String, here the name the user typed.
- A name that doesn't exist, such as `shoping.txt`, ends up in the `catch` block, and the program prints `Error: shoping.txt`.
- The keyboard Scanner isn't put in a `try (...)`. Closing it would close the keyboard input as well, and nothing more could be read from it.

---

Source: [A file chosen by the user](https://javaarena.com/learn/reading-files/a-file-chosen-by-the-user/) in the module [Reading files](https://javaarena.com/learn/reading-files/) on Java Arena.

This module follows sections [4.3 Files and reading data](https://java-programming.mooc.fi/part-4/3-files-and-reading-data), [4.4 Summary](https://java-programming.mooc.fi/part-4/4-summary) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
