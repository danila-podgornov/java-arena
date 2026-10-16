> [!info] AI-Generated

# Lambda expressions and method references

`km -> km > 50` in step 1 is a **lambda expression**, or a lambda for short: a small method without a name, written right where it's used. `filter` calls it once for each value in the stream. The value goes into the parameter `km`, and the lambda's answer, `true` or `false`, says whether the value gets through.

## The parts of a lambda

A lambda has a parameter list, an arrow `->`, and a body:

- With one parameter, the parentheses around it may be left out: `km -> km > 50` is the same as `(km) -> km > 50`.
- The parameter's name is yours to pick, with one limit: no variable of that name may exist at that point of the method around the lambda. After `int km = 50;`, the lambda `km -> km > 50` gives `error: variable km is already defined in method main(String[])`. A variable made inside a loop is gone once the loop ends, so after a loop that read into `String line`, the lambda `line -> !line.isEmpty()` is fine. `x -> x > 50` does the same thing as `km -> km > 50`, but a name like `km` or `title` says what the value is.
- There's no need to write the parameter's type. Java knows that a stream made from an `ArrayList<Integer>` holds Integers. `(Integer km) -> km > 50` works too, but it's rarely written.
- Two parameters need parentheses, with a comma between them: `(a, b) -> a + b`. Step 7 uses this kind.
- A short body is one expression, with no `return` and no semicolon: its value is the lambda's answer.

A bookshop keeps the titles on its "staff picks" table. The short titles, with `forEach`, which runs a lambda for each value that reaches it:

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> titles = new ArrayList<>();
        titles.add("Beloved");
        titles.add("Emma");
        titles.add("Middlemarch");
        titles.add("Dune");
        titles.add("Persuasion");

        titles.stream()
                .filter(title -> title.length() <= 5)
                .forEach(title -> System.out.println("Short title: " + title));
    }
}
```

**Output**

```text
Short title: Emma
Short title: Dune
```

`forEach` ends the stream, like `count`, but it gives back no value: its lambda does the work, here printing. So the statement isn't stored in a variable.

## A body in braces

When a lambda needs more than one expression, its body goes in braces, as in a method: statements with semicolons, and a `return` for the answer, when the lambda must give one:

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> titles = new ArrayList<>();
        titles.add("Beloved");
        titles.add("Emma");
        titles.add("Middlemarch");
        titles.add("Dune");
        titles.add("Persuasion");

        titles.stream().filter(title -> {
            String first = title.substring(0, 1);
            return first.equals("D") || first.equals("E");
        }).forEach(title -> {
            System.out.println(title);
            System.out.println("  " + title.length() + " letters");
        });
    }
}
```

**Output**

```text
Emma
  4 letters
Dune
  4 letters
```

The lambda given to `filter` must answer `true` or `false`, so its block ends with `return`. The one given to `forEach` answers nothing, so it has no `return`, just like a `void` method. The `}` that closes a lambda's body is followed by the `)` that closes the method call, which makes `})` a common sight in stream code.

## Method references

The lambda `title -> System.out.println(title)` only hands its value to another method. For that case Java has a shorter form, a **method reference**: `System.out::println`. Two colons stand between where the method is and its name, and there are no parentheses or parameters, since the stream gives the value:

```java
ArrayList<String> titles = new ArrayList<>();
titles.add("Beloved");
titles.add("Emma");
titles.add("Dune");
titles.stream()
        .filter(title -> title.length() == 4)
        .forEach(System.out::println);
```

**Output**

```text
Emma
Dune
```

Three method references you'll use in this module, and the lambdas they're short for:

- `System.out::println` is `value -> System.out.println(value)`.
- `Integer::valueOf` is `text -> Integer.valueOf(text)`: it turns a String such as `"42"` into a number.
- `String::toUpperCase` is `text -> text.toUpperCase()`: a method of the value itself, named by its class.

Step 4 puts `String::toUpperCase` to work, and step 5 `Integer::valueOf`. A method reference is never required: the lambda always works too. Use the reference when it reads more easily.

## Variables from outside the lambda

A lambda can use the variables of the method it's in, such as a limit:

```java
ArrayList<String> titles = new ArrayList<>();
titles.add("Beloved");
titles.add("Emma");
titles.add("Middlemarch");
int maxLength = 7;
titles.stream()
        .filter(title -> title.length() <= maxLength)
        .forEach(System.out::println);
```

**Output**

```text
Beloved
Emma
```

But it can't change them. Counting with a variable of your own inside `forEach` doesn't compile:

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> titles = new ArrayList<>();
        titles.add("Beloved");
        titles.add("Emma");
        int count = 0;
        titles.stream().forEach(title -> count++);
        System.out.println(count);
    }
}
```

**What javac prints**

```text
Main.java:9: error: local variables referenced from a lambda expression must be final or effectively final
        titles.stream().forEach(title -> count++);
                                         ^
1 error
```

*Effectively final* means a variable that's never changed after it gets its value, such as `maxLength` above. A lambda may use only such variables of its method. That's no loss: the stream's way to count is `filter` and `count`, as in step 1, with no variable of your own.

---

Source: [Lambda expressions and method references](https://javaarena.com/learn/streams/lambdas/) in the module [Streams and lambdas](https://javaarena.com/learn/streams/) on Java Arena.

This module follows section [10.1 Handling collections as streams](https://java-programming.mooc.fi/part-10/1-handling-collections-as-streams) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
