> [!info] AI-Generated

# instanceof with a pattern

This module is an extra: the MOOC doesn't cover it. It's about two features that work together. **Patterns** test what kind of object you have and give you its parts in the same step, and **sealed types** fix the list of classes that may implement an interface. With both, a method can handle each kind of object in its own way, and javac checks that no kind was forgotten. They came to Java in stages, from Java 16 to Java 21, and newer Java code uses them often, so they're worth being able to read and write. The module uses records (module 56) and switch expressions (module 57).

## instanceof, then a cast

In module 36, a program asked an object for its type with `instanceof`, and then cast it to get a variable of that type. A chat app has text messages and photo messages, which are both ChatMessages. Printing the photos the old way:

```java
for (ChatMessage message : chat) {
    if (message instanceof PhotoMessage) {
        PhotoMessage photo = (PhotoMessage) message;
        System.out.println(photo.sender() + " sent " + photo.file());
    }
}
```

The type `PhotoMessage` is written three times in two lines, and the cast can't even fail, since the line before it has just checked the type.

## A type pattern

Since Java 16, `instanceof` can be followed by a type and a new variable's name. `message instanceof PhotoMessage photo` checks the type, and when it matches, it declares the variable `photo`, which refers to the same object, as a PhotoMessage. `PhotoMessage photo` is a **type pattern**, and `photo` is a **pattern variable**.

**Main.java**

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<ChatMessage> chat = new ArrayList<>();
        chat.add(new TextMessage("Aino", "Lunch at noon?"));
        chat.add(new PhotoMessage("Ben", "menu.jpg", 840));
        chat.add(new TextMessage("Ben", "Sure, see you there"));

        for (ChatMessage message : chat) {
            if (message instanceof TextMessage typed) {
                System.out.println(typed.sender() + ": " + typed.text());
            } else if (message instanceof PhotoMessage photo) {
                System.out.println(photo.sender() + " sent " + photo.file() + ", " + photo.kilobytes() + " kB");
            }
        }
    }
}
```

**ChatMessage.java**

```java
public interface ChatMessage {
    String sender();
}
```

**TextMessage.java**

```java
public record TextMessage(String sender, String text) implements ChatMessage {
}
```

**PhotoMessage.java**

```java
public record PhotoMessage(String sender, String file, int kilobytes) implements ChatMessage {
}
```

**Output**

```text
Aino: Lunch at noon?
Ben sent menu.jpg, 840 kB
Ben: Sure, see you there
```

- The messages are records. Each record's accessor `sender()` is the method that the interface ChatMessage asks for.
- When the object isn't a TextMessage, the test is false and nothing is declared: there's no cast that could throw a ClassCastException.
- `instanceof` is false for `null`, so a pattern variable is never `null`.

## Where the pattern variable exists

A pattern variable exists only where Java knows that the test was true. In the if's own block it can be used; in the else block it can't:

```java
public class Main {
    public static void main(String[] args) {
        Object value = "Lunch at noon?";
        if (value instanceof String text) {
            System.out.println(text.length());
        } else {
            System.out.println(text);
        }
    }
}
```

**What javac prints**

```text
Main.java:7: error: cannot find symbol
            System.out.println(text);
                               ^
  symbol:   variable text
  location: class Main
1 error
```

After `&&`, the variable can be used in the same condition, since the right side of `&&` is only evaluated when the left side is true:

```java
Object[] values = {"Lunch at noon?", 42, "ok"};
for (Object value : values) {
    if (value instanceof String text && text.length() > 5) {
        System.out.println("long text: " + text);
    }
}
```

**Output**

```text
long text: Lunch at noon?
```

With `||` it doesn't work: the right side of `||` runs exactly when the test was false, and then there's no variable.

The test can also be turned around with `!`. When the method returns as soon as the object isn't of the type, the pattern variable can be used in the rest of the method:

```java
public class Main {
    public static void main(String[] args) {
        System.out.println(shout("see you there"));
        System.out.println(shout(42));
    }

    public static String shout(Object value) {
        if (!(value instanceof String text)) {
            return "not text";
        }
        return text.toUpperCase() + "!";
    }
}
```

**Output**

```text
SEE YOU THERE!
not text
```

---

Source: [instanceof with a pattern](https://javaarena.com/learn/sealed-and-patterns/instanceof-patterns/) in the module [Pattern matching and sealed types](https://javaarena.com/learn/sealed-and-patterns/) on Java Arena.

An extra module, not part of the University of Helsinki's course. Lesson text: [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/).
