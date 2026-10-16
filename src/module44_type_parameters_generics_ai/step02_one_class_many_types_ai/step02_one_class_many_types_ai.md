> [!info] AI-Generated

# One class, many types

Step 1's Box is one class, and every box chooses its own type. This step shows boxes of more types, a shorter way to create them, and the one kind of type that can't go in the angle brackets.

## Parameter and argument

In `public class Box<T>`, T is the **type parameter**. In `Box<String>`, String is the **type argument**: the type that T stands for in that box. It's the same pair of words as for methods: a method has a parameter, and each call gives it an argument. A class has a type parameter, and each use of it gives a type argument.

## The diamond

`Box<String> pegs = new Box<String>("tent pegs");` names String twice. Java can work out the second one from the variable's type, so you can leave it out and keep only the angle brackets:

```java
Box<String> pegs = new Box<>("tent pegs");
```

The empty `<>` is called the **diamond**, after its shape. You've written it since module 13, in `new ArrayList<>()`. It works wherever Java can see which type is needed: in a variable's declaration, as here, and also in `return new Box<>(...)` in a method whose return type is, say, `Box<String>`. From here on, this module writes the diamond.

Leave out the angle brackets completely, as in `new Box("tent pegs")`, and you get an old form from before Java had type parameters. javac compiles it, but it adds a note that the program "uses unchecked or unsafe operations", because it can no longer check the types. Write at least the `<>`.

## Any class or interface will do

A type argument can be any class or interface: one of Java's own, one of yours, even a type with a type argument of its own:

**Main.java**

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Box<Double> paint = new Box<>(2.5);
        Box<PowerTool> drill = new Box<>(new PowerTool("cordless drill", 1.8));
        Box<ArrayList<String>> camping = new Box<>(new ArrayList<>());
        camping.getContent().add("tent");
        camping.getContent().add("lantern");

        System.out.println(paint.getContent() * 2 + " liters of paint");
        System.out.println(drill.getContent().getName() + ", " + drill.getContent().getKilos() + " kg");
        System.out.println(camping.getContent().size() + " things: " + camping.getContent());
    }
}
```

**Box.java**

```java
public class Box<T> {
    private T content;

    public Box(T content) {
        this.content = content;
    }

    public T getContent() {
        return this.content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}
```

**PowerTool.java**

```java
public class PowerTool {
    private String name;
    private double kilos;

    public PowerTool(String name, double kilos) {
        this.name = name;
        this.kilos = kilos;
    }

    public String getName() {
        return this.name;
    }

    public double getKilos() {
        return this.kilos;
    }
}
```

**Output**

```text
5.0 liters of paint
cordless drill, 1.8 kg
2 things: [tent, lantern]
```

- For `drill`, a `Box<PowerTool>`, `getContent()` returns a PowerTool, so the PowerTool's own methods can be called on it.
- `Box<ArrayList<String>>` is a box whose T is `ArrayList<String>`. Its `getContent()` returns the list itself, not a copy, so `add` puts the tent and the lantern into the list in the box. Module 33's `HashMap<String, ArrayList<String>>` nested types the same way.
- In `new Box<>(new ArrayList<>())`, both diamonds are worked out from the variable's type.

## Integer, not int

Module 13 showed that a list can't hold `int`s. A type argument can't be a primitive type at all, for your classes or Java's:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Box<int> chairs = new Box<>(12);
        System.out.println(chairs.getContent());
    }
}
```

**Box.java**

```java
public class Box<T> {
    private T content;

    public Box(T content) {
        this.content = content;
    }

    public T getContent() {
        return this.content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}
```

**What javac prints**

```text
Main.java:3: error: unexpected type
        Box<int> chairs = new Box<>(12);
            ^
  required: reference
  found:    int
1 error
```

A type argument must be a reference type (module 22): a class, an interface, even an array type, never a primitive type. That's what javac's `required: reference` means. For a primitive type, use its object partner, its **wrapper class**:

| primitive type | type argument |
| --- | --- |
| `int` | `Integer` |
| `double` | `Double` |
| `boolean` | `Boolean` |
| `char` | `Character` |

That's why it's `List<Integer>`, never `List<int>`. Java converts between the two by itself, as it does with lists: `new Box<>(12)` for a `Box<Integer>` turns 12 into an Integer, and `int chairs = box.getContent();` turns it back into an int. It converts only between a primitive type and its own partner, though: a `Box<Double>` takes `2.0`, but not `2`.

---

Source: [One class, many types](https://javaarena.com/learn/generics/type-arguments/) in the module [Type parameters (generics)](https://javaarena.com/learn/generics/) on Java Arena.

This module follows section [12.1 Type parameters](https://java-programming.mooc.fi/part-12/1-type-parameters) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
