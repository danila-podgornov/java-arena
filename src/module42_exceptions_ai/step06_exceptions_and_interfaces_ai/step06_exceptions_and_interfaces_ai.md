> [!info] AI-Generated

# Exceptions and interfaces

An interface lists the headers of methods (module 35), and a header can include `throws`. Then it says, for every class that implements the interface, which checked exceptions that method may throw.

## Door codes

The doors of an office building open with a code typed on a keypad. Some doors have one fixed code; others check a file of codes that the office manager keeps up to date. The keypad doesn't care which: it needs something that can answer "is this code valid?". Reading a file can fail, and the interface says so:

```java
import java.io.IOException;

public interface DoorCodes {
    boolean isValid(String code) throws IOException;
}
```

Here are two classes that implement it, and three doors:

**The file staff.txt**

```text
4711
2580
```

**Main.java**

```java
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        open("Bike shed", new FixedCode("1234"), "2580");
        open("Staff entrance", new CodeFile("staff.txt"), "2580");
        open("Guest entrance", new CodeFile("guests.txt"), "2580");
    }

    public static void open(String door, DoorCodes codes, String typed) {
        try {
            if (codes.isValid(typed)) {
                System.out.println(door + ": the door opens");
            } else {
                System.out.println(door + ": wrong code");
            }
        } catch (IOException e) {
            System.out.println(door + ": out of order, can't read " + e.getMessage());
        }
    }
}
```

**DoorCodes.java**

```java
import java.io.IOException;

public interface DoorCodes {
    boolean isValid(String code) throws IOException;
}
```

**FixedCode.java**

```java
public class FixedCode implements DoorCodes {
    private String code;

    public FixedCode(String code) {
        this.code = code;
    }

    @Override
    public boolean isValid(String code) {
        return this.code.equals(code);
    }
}
```

**CodeFile.java**

```java
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CodeFile implements DoorCodes {
    private String fileName;

    public CodeFile(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public boolean isValid(String code) throws IOException {
        return Files.readAllLines(Paths.get(this.fileName)).contains(code);
    }
}
```

**Output**

```text
Bike shed: wrong code
Staff entrance: the door opens
Guest entrance: out of order, can't read guests.txt
```

- CodeFile reads a file, which can throw an IOException, and its `isValid` passes it on with `throws IOException`, as the interface allows.
- FixedCode can't fail, and its `isValid` has no `throws` at all. That's allowed: an implementation may throw fewer checked exceptions than the interface says, or none.
- `open` gets a DoorCodes. All it knows is the interface's header, so it must be ready for the IOException, even when the object behind it happens to be a FixedCode.

## What an implementation may throw

The interface is a promise to the code that uses it: `open` catches IOException because the interface says that's what can come. If an implementation could throw some other checked exception, `open` wouldn't be ready for it. So javac refuses an implementation that declares a checked exception the interface doesn't list, or a broader one:

**Main.java**

```java
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        DoorCodes codes = new CodeFile("staff.txt");
        try {
            System.out.println(codes.isValid("2580"));
        } catch (IOException e) {
            System.out.println("Out of order");
        }
    }
}
```

**DoorCodes.java**

```java
import java.io.IOException;

public interface DoorCodes {
    boolean isValid(String code) throws IOException;
}
```

**CodeFile.java**

```java
import java.nio.file.Files;
import java.nio.file.Paths;

public class CodeFile implements DoorCodes {
    private String fileName;

    public CodeFile(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public boolean isValid(String code) throws Exception {
        return Files.readAllLines(Paths.get(this.fileName)).contains(code);
    }
}
```

**What javac prints**

```text
CodeFile.java:12: error: isValid(String) in CodeFile cannot implement isValid(String) in DoorCodes
    public boolean isValid(String code) throws Exception {
                   ^
  overridden method does not throw Exception
1 error
```

`Exception` is broader than `IOException`: it includes checked exceptions that `open` doesn't catch. In short:

- An implementation may declare the interface's checked exceptions, or classes below them (such as `NoSuchFileException`), or leave them out.
- It may not add other checked exceptions.
- Unchecked exceptions are always allowed, since nobody has to declare or catch them. FixedCode's `isValid` could throw an IllegalArgumentException when the typed code is empty, and it still needs no `throws`.

The same rule holds for a method that overrides a method of a superclass (module 34).

## The variable's type decides

Whether a call needs a `try` depends on the header javac sees, and that's the header in the variable's type. Through a FixedCode variable, `isValid` throws nothing checked, so no `try` is needed:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        FixedCode shed = new FixedCode("1234");
        System.out.println(shed.isValid("1234"));
    }
}
```

**DoorCodes.java**

```java
import java.io.IOException;

public interface DoorCodes {
    boolean isValid(String code) throws IOException;
}
```

**FixedCode.java**

```java
public class FixedCode implements DoorCodes {
    private String code;

    public FixedCode(String code) {
        this.code = code;
    }

    @Override
    public boolean isValid(String code) {
        return this.code.equals(code);
    }
}
```

**Output**

```text
true
```

Through a DoorCodes variable, the same call on the same object doesn't compile without one:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        DoorCodes shed = new FixedCode("1234");
        System.out.println(shed.isValid("1234"));
    }
}
```

**DoorCodes.java**

```java
import java.io.IOException;

public interface DoorCodes {
    boolean isValid(String code) throws IOException;
}
```

**FixedCode.java**

```java
public class FixedCode implements DoorCodes {
    private String code;

    public FixedCode(String code) {
        this.code = code;
    }

    @Override
    public boolean isValid(String code) {
        return this.code.equals(code);
    }
}
```

**What javac prints**

```text
Main.java:4: error: unreported exception IOException; must be caught or declared to be thrown
        System.out.println(shed.isValid("1234"));
                                       ^
1 error
```

## throws Exception, and AutoCloseable

Interfaces often declare `throws Exception`, the widest promise: then each implementation may throw whatever it needs to. Java's own AutoCloseable from step 4 is one of them: its method is `void close() throws Exception`. The Faucet's `close()` left the `throws` out, since turning off a faucet can't fail. That's why its try-with-resources didn't need a `catch (Exception e)`: javac knew from the Faucet's own header that closing it throws nothing checked.

---

Source: [Exceptions and interfaces](https://javaarena.com/learn/exceptions/exceptions-and-interfaces/) in the module [Exceptions](https://javaarena.com/learn/exceptions/) on Java Arena.

This module follows section [11.3 Exceptions](https://java-programming.mooc.fi/part-11/3-exceptions) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
