> [!info] AI-Generated

# Abstract classes and abstract methods

Step 2's program made `new Instrument()`, a "shaker". But a music school has no instruments that are just instruments: each one is a flute, a drum, a violin. And some methods can't be written for "an instrument" at all. What sound does an instrument make?

Java has a way to say this: an **abstract class**. It's a class made only to be extended. You can't create an object of it with `new`, and it can leave methods for its subclasses to write.

**Main.java**

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Instrument> band = new ArrayList<>();
        band.add(new Flute("Silver flute"));
        band.add(new Drum("Snare drum"));
        for (Instrument instrument : band) {
            instrument.play();
        }
    }
}
```

**Instrument.java**

```java
public abstract class Instrument {
    private String name;

    public Instrument(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public abstract String sound();

    public void play() {
        System.out.println(this.name + ": " + this.sound());
    }
}
```

**Flute.java**

```java
public class Flute extends Instrument {
    public Flute(String name) {
        super(name);
    }

    @Override
    public String sound() {
        return "fweee";
    }
}
```

**Drum.java**

```java
public class Drum extends Instrument {
    public Drum(String name) {
        super(name);
    }

    @Override
    public String sound() {
        return "boom boom";
    }
}
```

**Output**

```text
Silver flute: fweee
Snare drum: boom boom
```

- `public abstract class Instrument` makes Instrument abstract.
- `public abstract String sound();` is an **abstract method**: a header followed by a semicolon, with no body. It says that every instrument has a `sound()` that returns a String, and leaves the code to the subclasses.
- Everything else is as in any class: an instance variable, a constructor, which the subclasses call with `super(name)`, and ordinary methods such as `getName` and `play`.
- `play` is written once, in Instrument, and calls `sound()`. As in step 6, the version that runs is the object's own: the flute's, then the drum's.
- Variables and lists of the abstract type are fine: `ArrayList<Instrument>` holds flutes and drums. It just can never hold an object that is only an Instrument.

## No new

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Instrument mystery = new Instrument("Mystery");
        mystery.play();
    }
}
```

**Instrument.java**

```java
public abstract class Instrument {
    private String name;

    public Instrument(String name) {
        this.name = name;
    }

    public abstract String sound();

    public void play() {
        System.out.println(this.name + ": " + this.sound());
    }
}
```

**What javac prints**

```text
Main.java:3: error: Instrument is abstract; cannot be instantiated
        Instrument mystery = new Instrument("Mystery");
                             ^
1 error
```

Think about what `mystery.play()` would have to do: call `sound()`, which has no code to run. So Java doesn't let an abstract class's object exist on its own. Instrument's constructor still runs, but only as the first part of building a Flute or a Drum.

## A subclass must write the missing methods

A class that extends Instrument must write every abstract method, or it doesn't compile. Here a harp forgot its sound:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Harp harp = new Harp("Concert harp");
        harp.play();
    }
}
```

**Instrument.java**

```java
public abstract class Instrument {
    private String name;

    public Instrument(String name) {
        this.name = name;
    }

    public abstract String sound();

    public void play() {
        System.out.println(this.name + ": " + this.sound());
    }
}
```

**Harp.java**

```java
public class Harp extends Instrument {
    public Harp(String name) {
        super(name);
    }
}
```

**What javac prints**

```text
Harp.java:1: error: Harp is not abstract and does not override abstract method sound() in Instrument
public class Harp extends Instrument {
       ^
1 error
```

- The fix is to write Harp's `sound()`. javac's other way out, making Harp abstract too, means no harps could be made either. That fits only for a group of instruments, such as a `StringInstrument` between Instrument and Harp that leaves `sound()` to each of its own subclasses.
- Only an abstract class may have abstract methods. A plain class with an abstract method doesn't compile.
- A class can be abstract without any abstract methods. Then `abstract` just forbids `new`.

## Why not an ordinary class?

Instrument could be a plain class, with `sound()` returning `""` as a placeholder. Then `new Instrument(...)` would make an instrument without a sound, and a subclass that forgot to override `sound()` would quietly play nothing. The abstract method turns both mistakes into errors that javac catches, and it tells anyone reading the class what a subclass must provide.

Module 35's interfaces take this idea further: they list methods that a class promises to have, without being its superclass.

---

Source: [Abstract classes and abstract methods](https://javaarena.com/learn/inheritance/abstract-classes/) in the module [Inheritance and abstract classes](https://javaarena.com/learn/inheritance/) on Java Arena.

This module follows section [9.1 Class inheritance](https://java-programming.mooc.fi/part-9/1-inheritance) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
