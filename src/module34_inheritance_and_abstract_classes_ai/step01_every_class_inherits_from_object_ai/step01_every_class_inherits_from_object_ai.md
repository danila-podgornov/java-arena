> [!info] AI-Generated

# Every class inherits from Object

Since module 17 you've written classes of your own, and some things worked without your writing them. Module 18 noted that `println` can print an object whose class has no `toString`, module 23 called `equals` on objects whose class had no `equals` yet, and module 32 said that every object has a `hashCode`. Where do those methods come from?

Java has a class called `Object`. It's in `java.lang`, like `String`, so it needs no import. Every class **inherits** from Object: it gets Object's methods, as if they were written in the class itself. This module is about inheritance, and a class of yours can inherit from another class of yours too, not only from Object.

## What Object gives every class

A museum keeps a record of each exhibit: its name and the year it was made. This `Exhibit` class has a constructor and nothing else, yet the program calls four methods on it:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Exhibit vase = new Exhibit("Blue vase", 1720);
        Exhibit copy = new Exhibit("Blue vase", 1720);
        System.out.println(vase.getClass().getName());
        System.out.println(vase.equals(copy));
        System.out.println(vase.equals(vase));
        System.out.println(vase.hashCode() == vase.hashCode());
        String text = vase.toString();
        System.out.println(text.startsWith("Exhibit@"));
    }
}
```

**Exhibit.java**

```java
public class Exhibit {
    private String name;
    private int year;

    public Exhibit(String name, int year) {
        this.name = name;
        this.year = year;
    }
}
```

**Output**

```text
Exhibit
false
true
true
true
```

All four methods come from Object:

- `getClass().getName()` gives the name of the object's class. It's the same on every run.
- Object's `equals` does the same as `==`: it's `true` only for the very same object (module 23). `vase` and `copy` have the same values, but they're two objects.
- Object's `hashCode` gives a number for the object. It stays the same while the program runs, but it can change from one run to the next (module 32).
- Object's `toString` gives the class name, an `@` and the hash code written in hexadecimal (base 16, with the digits 0 to 9 and the letters a to f), something like `Exhibit@1b6d3586`. The hash code changes from run to run, so this course never prints that text: the program above only checks how it starts.

## Your own methods replace Object's

When a class writes a method with the same header as one of Object's, the class's own method is used instead of Object's. That's what your `toString` (module 18), `equals` (module 23) and `hashCode` (module 32) have done all along: each one replaced Object's version. Step 4 gives this a name, **overriding**.

**Main.java**

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Exhibit vase = new Exhibit("Blue vase", 1720);
        Exhibit copy = new Exhibit("Blue vase", 1720);
        System.out.println(vase);
        System.out.println(vase.equals(copy));

        ArrayList<Exhibit> hall = new ArrayList<>();
        hall.add(vase);
        hall.add(new Exhibit("Iron helmet", 1450));
        System.out.println(hall);
        System.out.println("Next up: " + hall.get(1));
        System.out.println(hall.contains(new Exhibit("Iron helmet", 1450)));
    }
}
```

**Exhibit.java**

```java
import java.util.Objects;

public class Exhibit {
    private String name;
    private int year;

    public Exhibit(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public boolean equals(Object compared) {
        if (this == compared) {
            return true;
        }
        if (!(compared instanceof Exhibit)) {
            return false;
        }
        Exhibit other = (Exhibit) compared;
        return this.name.equals(other.name) && this.year == other.year;
    }

    public int hashCode() {
        return Objects.hash(this.name, this.year);
    }

    public String toString() {
        return this.name + " (" + this.year + ")";
    }
}
```

**Output**

```text
Blue vase (1720)
true
[Blue vase (1720), Iron helmet (1450)]
Next up: Iron helmet (1450)
true
```

- `println(vase)`, the way a list prints itself, and `+` with a String all call the object's `toString`, and now that's Exhibit's own.
- The list's `contains` calls `equals`, and now that's Exhibit's own too.
- The name, the parameter types and the return type must be Object's, and the method must stay public: `public String toString()`, `public boolean equals(Object compared)` and `public int hashCode()`. (The parameter's name can be anything, as module 23 said; Object's own is `obj`.) That's why `equals` takes an `Object`: Object's `equals` takes one, since any object may be compared with any other. A method `equals(Exhibit compared)` would be a second method next to Object's (overloading, module 21), and lists and maps would go on calling Object's.
- Object's other methods, such as `getClass`, stay as they are.

## Inheriting, in one word

A class that doesn't say which class it inherits from inherits from Object. So these two headers mean the same:

```java
public class Exhibit {
```

```java
public class Exhibit extends Object {
```

You'll hardly ever see the second one written out, but it shows the word that the next step is about: `extends`.

---

Source: [Every class inherits from Object](https://javaarena.com/learn/inheritance/object/) in the module [Inheritance and abstract classes](https://javaarena.com/learn/inheritance/) on Java Arena.

This module follows section [9.1 Class inheritance](https://java-programming.mooc.fi/part-9/1-inheritance) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
