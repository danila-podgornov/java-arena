> [!info] AI-Generated

# Checked exceptions and throws

In module 20, a program that opened a file without a `try` didn't compile: javac said `unreported exception IOException; must be caught or declared to be thrown`. A program that calls `Integer.parseInt` gets no such message, though `parseInt` can throw too. Java treats the two kinds of exceptions differently.

## Checked and unchecked

- **Unchecked exceptions** are RuntimeException and every class below it: NumberFormatException, ArithmeticException, the index exceptions, NullPointerException and the rest. They usually come from a mistake in the program, or from a value it could have checked first. javac leaves them to you: you catch them where you expect them, like text that isn't a number.
- **Checked exceptions** are all the other Exceptions, such as IOException. They come from things outside the program's control: a file that isn't there, a full disk, a network that's down. However careful the code is, they can happen. So when javac compiles the program, it **checks** that every checked exception is either caught or declared. That's where the name comes from.

A method's documentation lists the checked exceptions it can throw, and javac tells you when you've forgotten one.

`Files.readAllLines` is another way to read a file: it reads all the lines at once and returns them in a `List<String>`. `Files` is in `java.nio.file`, next to `Paths`. This method reads a settings file, with one setting per line, a name and a value with `=` between them, and looks up one setting. It doesn't compile:

```java
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Volume: " + readSetting("settings.txt", "volume"));
    }

    public static String readSetting(String fileName, String name) {
        List<String> lines = Files.readAllLines(Paths.get(fileName));
        for (String line : lines) {
            String[] parts = line.split("=");
            if (parts[0].equals(name)) {
                return parts[1];
            }
        }
        return "";
    }
}
```

**What javac prints**

```text
Main.java:11: error: unreported exception IOException; must be caught or declared to be thrown
        List<String> lines = Files.readAllLines(Paths.get(fileName));
                                               ^
1 error
```

## Declaring it: throws

"Caught" you know: a `try` and a `catch` around the line. "Declared" is the other choice. The method writes `throws IOException` in its header, after the parameters:

```java
public static String readSetting(String fileName, String name) throws IOException {
```

It says: this method may throw an IOException, and it doesn't handle it itself; whoever calls it must. The method's code stays as it was. If `readAllLines` throws, `readSetting` stops right there, and the exception goes on to the caller, which then has the same two choices: catch it, or declare it too. Here `main` catches it:

**The file settings.txt**

```text
volume=7
theme=dark
```

```java
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] files = {"settings.txt", "backup.txt"};
        for (String file : files) {
            try {
                System.out.println("Volume in " + file + ": " + readSetting(file, "volume"));
            } catch (IOException e) {
                System.out.println("Could not read " + file);
            }
        }
    }

    public static String readSetting(String fileName, String name) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(fileName));
        for (String line : lines) {
            String[] parts = line.split("=");
            if (parts[0].equals(name)) {
                return parts[1];
            }
        }
        return "";
    }
}
```

**Output**

```text
Volume in settings.txt: 7
Could not read backup.txt
```

- `IOException` is in the package `java.io`, so it needs an import: `import java.io.IOException;`.
- There's no `backup.txt`, so `readAllLines` throws, `readSetting` passes the exception on, and `main`'s `catch` block handles it.
- Who should catch it? The method that knows what to do about it. `readSetting` can't know whether a missing file is an error or just means "use the defaults", so it passes the exception on, and `main` decides.

`throws Exception` declares any exception at all. It's shorter, and you'll see it often in small programs, but it tells the caller less, and the caller then has to catch `Exception`, or declare it too.

## An exception travels up

An exception that isn't caught leaves the method it was thrown in, then the method that called that one, and so on up the call stack, until it reaches a `catch` block that matches. The stack trace of a crash lists exactly those methods. Unchecked exceptions travel the same way, only without any `throws`: javac checks the checked ones alone. So every method a checked exception can pass through must declare it. A method that calls `readSetting` and doesn't catch the IOException needs `throws IOException` in its own header too.

## main throws Exception

`main` can declare exceptions too:

```java
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        List<String> lines = Files.readAllLines(Paths.get("settings.txt"));
        System.out.println(lines.size() + " settings");
    }
}
```

**The program crashes with**

```text
Exception in thread "main" java.nio.file.NoSuchFileException: settings.txt
	at Main.main(Main.java:7)
```

`public static void main(String[] args) throws Exception` passes every exception on to whoever called `main`: Java itself. Java handles it the only way it can: the program stops, with the report. Here there's no `settings.txt`, so that's what happens. With the file above, the program would print `2 settings`.

That's fine for a quick program, or an example where a missing file would be a mistake anyway, and you'll see `main` written this way in many examples, the MOOC's among them. A program for other people should catch the exception and tell them something useful instead.

---

Source: [Checked exceptions and throws](https://javaarena.com/learn/exceptions/checked-exceptions/) in the module [Exceptions](https://javaarena.com/learn/exceptions/) on Java Arena.

This module follows section [11.3 Exceptions](https://java-programming.mooc.fi/part-11/3-exceptions) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
