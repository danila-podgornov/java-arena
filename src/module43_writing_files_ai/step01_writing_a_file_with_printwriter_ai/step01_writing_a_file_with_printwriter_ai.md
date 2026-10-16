> [!info] AI-Generated

# Writing a file with PrintWriter

Module 20 read files that were already there. This module writes them. Everything a program keeps in its variables is gone when it ends, so a program that should remember something until the next time it runs, such as a shopping list, a high-score table or a to-do list, saves it in a file and reads it back when it starts again.

## PrintWriter

The class `PrintWriter`, in the package `java.io`, writes text into a file. Its methods are named like those of `System.out`, so you know them already:

```java
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        PrintWriter writer = new PrintWriter("shopping.txt");
        writer.println("oat milk");
        writer.println("rye bread");
        writer.print("apples");
        writer.println(", 6");
        writer.close();
        System.out.println("List saved");
    }
}
```

**Output**

```text
List saved
```

Only `List saved` appears in the output: it's the only text printed with `System.out`. The rest went into a file. After the run, the program's working folder has a file called `shopping.txt`, and it holds:

```text
oat milk
rye bread
apples, 6
```

- `new PrintWriter("shopping.txt")` opens the file `shopping.txt` for writing. A name alone means a file in the working folder, as in module 20. When there's no file by that name, it's created. When there is one, it's emptied first, so what the program writes replaces what the file held. (The next step shows how to add to a file instead.)
- `writer.println(...)` writes the text and a line break into the file, as `System.out.println` does on the screen. `writer.print(...)` writes the text without a line break, so whatever comes next goes on the same line: `apples` and `, 6` make one line.
- `writer.close()` closes the file once the program is done with it. Don't leave it out: the next section shows why.
- `throws Exception` in `main`'s header is there because creating a PrintWriter may throw an exception. The last section of this step is about it.

On Java Arena, **Run with my input** shows the files your program created or changed below its output, each under its name. The checks of this module look at those files too. Each test runs your program in a folder of its own, which holds only the files the task gives, and then compares the files your program should have written with the ones the model solution wrote, the same way it compares the output: line endings, spaces at the ends of lines and blank lines at the end don't matter; everything else does.

## Close the file

A PrintWriter doesn't send each `println` to the file right away. It gathers the text in memory and writes it to the file in larger pieces, which is much faster than writing every line on its own. `close()` writes whatever is still waiting, and then gives the file back to the operating system: an open file is a resource, as module 42 said. When the program ends, the operating system takes the file back, as it does with everything a program has open, but nothing calls the PrintWriter's `close()`, so the text still waiting in memory never reaches the file. A program that never calls `close()` can leave the file empty.

This program forgets to close its writer, and then reads the file back with a Scanner, as module 20 did:

```java
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        PrintWriter writer = new PrintWriter("reminders.txt");
        writer.println("Call the dentist");
        writer.println("Buy stamps");

        int lines = 0;
        try (Scanner reader = new Scanner(Paths.get("reminders.txt"))) {
            while (reader.hasNextLine()) {
                System.out.println("Read: " + reader.nextLine());
                lines++;
            }
        }
        System.out.println("Lines read: " + lines);
    }
}
```

**Output**

```text
Lines read: 0
```

Creating the PrintWriter created the file, but the two lines were still waiting in memory, so the file was empty when the Scanner read it. With `writer.close();` right after the second `println`, the same program prints `Read: Call the dentist`, `Read: Buy stamps` and `Lines read: 2`.

(The try-with-resources that reads the file has no `catch` block: `main` passes exceptions on with `throws Exception`, which module 42 said is enough.)

## The exception

Opening a file for writing can fail. The name might belong to a folder, the folder the file should go in might not exist, or the program might not be allowed to write there. PrintWriter's constructor then throws a `FileNotFoundException`. That's a kind of IOException, and so a checked exception (module 42): the program must catch it or declare it. With neither, javac refuses the program:

```java
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        PrintWriter writer = new PrintWriter("shopping.txt");
        writer.println("oat milk");
        writer.close();
    }
}
```

**What javac prints**

```text
Main.java:5: error: unreported exception FileNotFoundException; must be caught or declared to be thrown
        PrintWriter writer = new PrintWriter("shopping.txt");
                             ^
1 error
```

You have module 42's two choices.

**Declare it.** `throws Exception` in `main`'s header passes the exception on to Java, which stops the program with a report when it happens. That's what the examples above do, and the MOOC's examples do the same. Here the file should go into a folder called `backup`, which doesn't exist:

```java
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        PrintWriter writer = new PrintWriter("backup/shopping.txt");
        writer.println("oat milk");
        writer.close();
    }
}
```

**The program crashes with**

```text
Exception in thread "main" java.io.FileNotFoundException: backup/shopping.txt (No such file or directory)
	at Main.main(Main.java:5)
```

A PrintWriter creates the file, but not the folders on the way to it. A method of your own that writes a file can declare the exception in the same way, such as `public static void saveList(String fileName) throws Exception`, and then the code that calls it has the same two choices.

**Catch it.** A `try` around the writing lets the program go on, and tell the user what went wrong:

```java
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        String[] names = {"shopping.txt", "backup/shopping.txt"};
        for (String name : names) {
            try {
                PrintWriter writer = new PrintWriter(name);
                writer.println("oat milk");
                writer.close();
                System.out.println("Saved " + name);
            } catch (FileNotFoundException e) {
                System.out.println("Could not save " + name);
            }
        }
    }
}
```

**Output**

```text
Saved shopping.txt
Could not save backup/shopping.txt
```

---

Source: [Writing a file with PrintWriter](https://javaarena.com/learn/writing-files/printwriter/) in the module [Writing files](https://javaarena.com/learn/writing-files/) on Java Arena.

This module follows sections [11.4 Processing files](https://java-programming.mooc.fi/part-11/4-processing-files), [11.5 Conclusion](https://java-programming.mooc.fi/part-11/5-conclusion) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
