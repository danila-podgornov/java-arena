> [!info] AI-Generated

# Adding to a file

## Writing replaces

A workout log gets a new line after every workout. Here's `workouts.txt` after two of them, and a program that should add Friday's yoga to it, written with what step 1 taught. It then reads the file back:

**The file workouts.txt**

```text
Mon: run, 5 km
Wed: swim, 40 min
```

```java
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        PrintWriter writer = new PrintWriter("workouts.txt");
        writer.println("Fri: yoga, 30 min");
        writer.close();

        try (Scanner reader = new Scanner(Paths.get("workouts.txt"))) {
            while (reader.hasNextLine()) {
                System.out.println(reader.nextLine());
            }
        }
    }
}
```

**Output**

```text
Fri: yoga, 30 min
```

Monday's run and Wednesday's swim are gone: creating the PrintWriter emptied the file before anything was written. That's right for a file the program writes from scratch, but a log should grow.

## FileWriter, which can append

`FileWriter`, also in `java.io`, writes into a file as well, and its constructor takes a second parameter: `new FileWriter("workouts.txt", true)`. `true` means **append**: the file keeps what it holds, and the new text goes after it. When the file doesn't exist yet, it's created, as before.

A FileWriter has no `print` or `println`. Its `write` methods write the text as it is, with no line break: `write("Fri: yoga, 30 min\n")` needs the `\n` at the end. Give the FileWriter to a PrintWriter's constructor instead, and you get `println` and `print`, which write through the FileWriter into the file:

**The file workouts.txt**

```text
Mon: run, 5 km
Wed: swim, 40 min
```

```java
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        PrintWriter writer = new PrintWriter(new FileWriter("workouts.txt", true));
        writer.println("Fri: yoga, 30 min");
        writer.close();

        try (Scanner reader = new Scanner(Paths.get("workouts.txt"))) {
            while (reader.hasNextLine()) {
                System.out.println(reader.nextLine());
            }
        }
    }
}
```

**Output**

```text
Mon: run, 5 km
Wed: swim, 40 min
Fri: yoga, 30 min
```

- `new PrintWriter(new FileWriter("workouts.txt", true))` makes two objects. The FileWriter opens the file for appending, and the PrintWriter writes into the FileWriter. Closing the PrintWriter closes the FileWriter too.
- Without the `true`, or with `false`, a FileWriter empties the file first, just as a PrintWriter does.
- FileWriter's constructor can throw an IOException (step 1's FileNotFoundException is one kind of it), so it needs `throws` or `catch` too. A `catch (IOException e)` block, with `import java.io.IOException;`, catches every kind.
- Every run adds one line. Run the program three times on your own computer, and the file ends with three yoga lines. Each check on Java Arena starts again from the files the test gives, so there each run adds exactly one.

## Append or replace?

- A log, a diary or a list of events grows: each run adds to it, so the program appends.
- A file that holds all of a program's data, such as a to-do list or a high-score table, is written again from the start each time, so it's replaced. Appending there would write the old contents into the file a second time. Step 4 is about such files.

---

Source: [Adding to a file](https://javaarena.com/learn/writing-files/adding-to-a-file/) in the module [Writing files](https://javaarena.com/learn/writing-files/) on Java Arena.

This module follows sections [11.4 Processing files](https://java-programming.mooc.fi/part-11/4-processing-files), [11.5 Conclusion](https://java-programming.mooc.fi/part-11/5-conclusion) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
