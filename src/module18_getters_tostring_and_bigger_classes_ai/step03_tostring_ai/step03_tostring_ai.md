> [!info] AI-Generated

# toString

## Printing an object

To show a plant, the `Plant` of module 17 had a method `printInfo()`. It works, but the text can only go straight to the screen, on a line of its own: it can't be part of a longer line, or be stored in a variable. What about printing the object itself, with `System.out.println(basil)`? It compiles, but for a class like `Plant` it prints the class name, an `@` and a code of letters and digits, something like `Plant@1b6d3586`. The code is an internal number that means nothing to a reader, and it may differ between runs and between computers. That's why no check in this course ever shows it.

## toString

A class decides how its objects look as text with a method called `toString`. It has no parameters and returns a String:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Ferry ferry = new Ferry("Aurora");
        System.out.println(ferry);
        ferry.board(12);
        System.out.println(ferry);
        String line = "Departing: " + ferry;
        System.out.println(line);
    }
}
```

**Ferry.java**

```java
public class Ferry {
    private String name;
    private int cars;

    public Ferry(String name) {
        this.name = name;
        this.cars = 0;
    }

    public void board(int count) {
        this.cars = this.cars + count;
    }

    public String toString() {
        return "Ferry " + this.name + ", " + this.cars + " cars on board";
    }
}
```

**Output**

```text
Ferry Aurora, 0 cars on board
Ferry Aurora, 12 cars on board
Departing: Ferry Aurora, 12 cars on board
```

- The header must be exactly `public String toString()`. With another name, or with a parameter, `println` won't use it.
- `System.out.println(ferry)` calls `ferry.toString()` for you and prints the text it returns.
- Joining an object to a String with `+` calls it too: `"Departing: " + ferry` is `"Departing: "` followed by what `toString` returns.
- The text is built each time the method is called, from the object's variables at that moment. After `board(12)` it shows the new number of cars.

`toString` **returns** the text; it doesn't print it. Printing is up to the code that calls it, so the same text can be printed, stored in a variable or joined into a longer line. Like any method that returns a String, `toString` can use `if` and build its text in steps.

---

Source: [toString](https://javaarena.com/learn/object-methods/tostring/) in the module [Getters, toString and bigger classes](https://javaarena.com/learn/object-methods/) on Java Arena.

This module follows section [4.1 Introduction to object-oriented programming](https://java-programming.mooc.fi/part-4/1-introduction-to-object-oriented-programming) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
