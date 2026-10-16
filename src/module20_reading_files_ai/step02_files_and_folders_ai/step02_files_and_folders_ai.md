> [!info] AI-Generated

# Files and folders

Everything a program keeps in its variables is gone when it ends. Data that has to last, such as contacts, high scores or a year of measurements, is kept in **files**.

- A **file** is a piece of data stored under a name: a photo, a song, a document, a program. This module reads **text files**, which hold plain text in lines. Any text editor can open and change them, and your `.java` files are text files too.
- The end of a file's name, such as `.txt`, `.csv` or `.java`, is its **extension**. It tells what kind of data the file holds, and it's part of the name: `scores` and `scores.txt` are two different names. Windows and macOS can hide extensions when they list files, but the extension is still there.
- A **folder** (also called a directory) holds files and other folders. A file's **path** names the folders on the way to it: `school/biology/cells.txt` is the file `cells.txt` in the folder `biology`, which is in the folder `school`. Windows writes paths with `\` instead of `/`.

## Where does the program look?

When a program opens a file by its name alone, such as `plants.txt`, Java looks for it in the program's **working folder** (or working directory): the folder the program runs in.

- **On your own computer**, when you run a project from an editor such as NetBeans, IntelliJ IDEA or VS Code, the working folder is usually the project's main folder, the one that holds the `src` folder. A file your program reads goes there, next to `src`, not inside it.
- **On Java Arena** there's no project folder of your own. Instead, each challenge that reads files provides them: the task shows each file with its name and contents, and the check puts the files in your program's working folder before it runs, just like files next to a program on a computer. **Run with my input** gets the same files. Hidden tests give files with other contents, so the program has to really read them.

## A first look

This program reads the file `plants.txt` and prints a line for each plant in it:

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
                System.out.println("Water the " + line);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
```

**Output**

```text
Water the basil
Water the mint
Water the rosemary
```

The next steps go through this program part by part. For now, find the file's name in `Paths.get("plants.txt")`: that's where the program says which file to read. Put another name there, and the same program reads another file.

---

Source: [Files and folders](https://javaarena.com/learn/reading-files/files-and-folders/) in the module [Reading files](https://javaarena.com/learn/reading-files/) on Java Arena.

This module follows sections [4.3 Files and reading data](https://java-programming.mooc.fi/part-4/3-files-and-reading-data), [4.4 Summary](https://java-programming.mooc.fi/part-4/4-summary) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
