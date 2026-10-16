> [!info] AI-Generated

# extends: a class built on another

A music school lends instruments to its students and keeps track of how long each one has been played. Every instrument needs that, whatever kind it is. Violins need something more: now and then a string breaks and gets changed, and the school counts those too.

You could copy the code for the minutes into a Violin class, a Drum class and every other kind. With inheritance you write it once, in a class `Instrument`, and `Violin` **extends** it:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Violin violin = new Violin();
        violin.practice(30);
        violin.practice(45);
        violin.changeString();
        violin.changeString();
        System.out.println(violin.getMinutesPlayed());
        System.out.println(violin.getStringsChanged());
        System.out.println(violin.report());

        Instrument shaker = new Instrument();
        shaker.practice(10);
        System.out.println(shaker.getMinutesPlayed());
    }
}
```

**Instrument.java**

```java
public class Instrument {
    private int minutesPlayed;

    public void practice(int minutes) {
        this.minutesPlayed += minutes;
    }

    public int getMinutesPlayed() {
        return this.minutesPlayed;
    }
}
```

**Violin.java**

```java
public class Violin extends Instrument {
    private int stringsChanged;

    public void changeString() {
        this.stringsChanged++;
    }

    public int getStringsChanged() {
        return this.stringsChanged;
    }

    public String report() {
        return this.getMinutesPlayed() + " minutes, " + this.stringsChanged + " strings changed";
    }
}
```

**Output**

```text
75
2
75 minutes, 2 strings changed
10
```

- `public class Violin extends Instrument` makes Violin a **subclass** of Instrument, and Instrument the **superclass** of Violin. You'll also hear child class and parent class.
- A Violin object has everything an Instrument has: the variable `minutesPlayed` and the methods `practice` and `getMinutesPlayed`. On top of that it has what Violin adds: `stringsChanged`, `changeString`, `getStringsChanged` and `report`. So `violin.practice(30)` works, although Violin's code never mentions `practice`.
- Violin's own methods can call the methods it inherits, just like its own: `report` calls `this.getMinutesPlayed()`.
- `report` can't write `this.minutesPlayed`, though. That variable is `private` to Instrument, so only Instrument's code can use it by name. Every Violin object has it, and `practice` changes it, but Violin's code reaches it only through Instrument's public methods. Step 5 is about this.
- Neither class has a constructor, so each gets the default constructor from module 17, and the numbers start at 0. The next step adds constructors that take values.

## A plain Instrument has only Instrument's methods

`shaker` is an Instrument, not a Violin. Inheritance goes one way: the subclass gets the superclass's methods, never the other way around.

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Instrument shaker = new Instrument();
        shaker.changeString();
    }
}
```

**Instrument.java**

```java
public class Instrument {
    private int minutesPlayed;

    public void practice(int minutes) {
        this.minutesPlayed += minutes;
    }

    public int getMinutesPlayed() {
        return this.minutesPlayed;
    }
}
```

**What javac prints**

```text
Main.java:4: error: cannot find symbol
        shaker.changeString();
              ^
  symbol:   method changeString()
  location: variable shaker of type Instrument
1 error
```

## One superclass, many subclasses

A class can extend only one class. But one class can have many subclasses: the school's `Drum` can extend Instrument too, and count its broken drumsticks:

```java
public class Drum extends Instrument {
    private int sticksBroken;

    public void breakStick() {
        this.sticksBroken++;
    }
}
```

A Drum and a Violin share Instrument's part, and each adds its own. A Drum has no `changeString`, and a Violin has no `breakStick`.

Inheritance also goes up more than one level. Instrument doesn't say what it extends, so it extends Object (step 1). So a Violin has Object's methods as well: `violin.getClass().getName()` gives `Violin`.

---

Source: [extends: a class built on another](https://javaarena.com/learn/inheritance/extends/) in the module [Inheritance and abstract classes](https://javaarena.com/learn/inheritance/) on Java Arena.

This module follows section [9.1 Class inheritance](https://java-programming.mooc.fi/part-9/1-inheritance) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
