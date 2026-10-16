> [!info] AI-Generated

# Saving and loading

## save and load

A program that writes its data when it ends, and reads it back when it starts, remembers the data from one run to the next. The data usually lives in an object, so that object's class gets two methods: `save` writes everything the object holds into a file, and `load` reads such a file back into the object. The two must agree on the format: `load` has to understand whatever `save` writes.

Here's a to-do list. It keeps its tasks in a list of Strings, and its file has one task per line:

**Main.java**

```java
public class Main {
    public static void main(String[] args) throws Exception {
        TodoList monday = new TodoList();
        monday.add("Water the ferns");
        monday.add("Pay the phone bill");
        monday.save("todo.txt");

        TodoList tuesday = new TodoList();
        tuesday.load("todo.txt");
        tuesday.add("Return the library books");
        tuesday.print();
    }
}
```

**TodoList.java**

```java
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class TodoList {
    private ArrayList<String> tasks;

    public TodoList() {
        this.tasks = new ArrayList<>();
    }

    public void add(String task) {
        this.tasks.add(task);
    }

    public void print() {
        for (int i = 0; i < this.tasks.size(); i++) {
            System.out.println((i + 1) + ". " + this.tasks.get(i));
        }
    }

    public void save(String fileName) throws Exception {
        try (PrintWriter writer = new PrintWriter(fileName)) {
            for (String task : this.tasks) {
                writer.println(task);
            }
        }
    }

    public void load(String fileName) throws Exception {
        try (Scanner reader = new Scanner(Paths.get(fileName))) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                if (!line.isEmpty()) {
                    this.tasks.add(line);
                }
            }
        }
    }
}
```

**Output**

```text
1. Water the ferns
2. Pay the phone bill
3. Return the library books
```

- `tuesday` is a new object, and its list starts empty. Its first two tasks come from the file, as they would in a program started again the next day.
- `save` writes the whole list every time, with a PrintWriter that replaces what the file held, so the file always matches the list. Appending would put every old task into the file a second time.
- `load` adds each line of the file to the list. It skips empty lines, which a person who edits the file by hand may leave behind.
- Both methods pass their exceptions on with `throws Exception`. The class can't know what a program wants to do when its file can't be read or written, so the code that calls them decides, as module 42 said.

## The first run

The very first time the program runs, there's no `todo.txt` yet, and `load`'s Scanner throws a NoSuchFileException. For a to-do app that isn't a problem: it just starts with an empty list. So the program catches the exception around `load`, and goes on:

```java
TodoList list = new TodoList();
try {
    list.load("todo.txt");
} catch (Exception e) {
    System.out.println("No saved tasks yet");
}
```

## Load when it starts, save when it ends

Put together with a loop that reads commands (module 25), this gives a to-do app that remembers its tasks. `main` loads the list, the loop runs the commands, and after `quit`, `main` saves the list:

**The file todo.txt**

```text
Water the ferns
Pay the phone bill
```

**Main.java**

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TodoList list = new TodoList();
        try {
            list.load("todo.txt");
        } catch (Exception e) {
            System.out.println("No saved tasks yet");
        }

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            if (command.equals("quit")) {
                break;
            }
            if (command.equals("add")) {
                list.add(scanner.nextLine());
            } else if (command.equals("list")) {
                list.print();
            } else {
                System.out.println("Unknown command: " + command);
            }
        }

        try {
            list.save("todo.txt");
            System.out.println("Saved");
        } catch (Exception e) {
            System.out.println("Could not save: " + e.getMessage());
        }
    }
}
```

**TodoList.java**

```java
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class TodoList {
    private ArrayList<String> tasks;

    public TodoList() {
        this.tasks = new ArrayList<>();
    }

    public void add(String task) {
        this.tasks.add(task);
    }

    public void print() {
        for (int i = 0; i < this.tasks.size(); i++) {
            System.out.println((i + 1) + ". " + this.tasks.get(i));
        }
    }

    public void save(String fileName) throws Exception {
        try (PrintWriter writer = new PrintWriter(fileName)) {
            for (String task : this.tasks) {
                writer.println(task);
            }
        }
    }

    public void load(String fileName) throws Exception {
        try (Scanner reader = new Scanner(Paths.get(fileName))) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                if (!line.isEmpty()) {
                    this.tasks.add(line);
                }
            }
        }
    }
}
```

**Input**

```text
add
Buy birdseed
list
quit
```

**Output**

```text
1. Water the ferns
2. Pay the phone bill
3. Buy birdseed
Saved
```

After the run, `todo.txt` holds the three tasks, and the next time the program starts, it has them all. In a larger program the command loop would be in a user interface class of its own, as in module 25, and `main` would still load at the start and save at the end.

---

Source: [Saving and loading](https://javaarena.com/learn/writing-files/saving-and-loading/) in the module [Writing files](https://javaarena.com/learn/writing-files/) on Java Arena.

This module follows sections [11.4 Processing files](https://java-programming.mooc.fi/part-11/4-processing-files), [11.5 Conclusion](https://java-programming.mooc.fi/part-11/5-conclusion) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
