> [!info] AI-Generated

# Declaring a record

This module is an extra: the MOOC doesn't cover it. Many classes you've written only hold a few values that never change after the object is made: a place on a map, an amount of money, an entry in a timetable. For each, you wrote instance variables, a constructor, getters, a `toString`, and for HashMap keys an `equals` and a `hashCode` too. A **record**, part of Java since Java 16, declares such a class in one line, and Java writes all of those parts for you. Records are common in newer Java code, so they're worth being able to read and write.

## A timetable entry as a class

A station's departure board shows, for each train, its name, where it's going and its platform. As a class in the style of the course, that's:

```java
public class Departure {
    private final String train;
    private final String destination;
    private final int platform;

    public Departure(String train, String destination, int platform) {
        this.train = train;
        this.destination = destination;
        this.platform = platform;
    }

    public String getTrain() {
        return this.train;
    }

    public String getDestination() {
        return this.destination;
    }

    public int getPlatform() {
        return this.platform;
    }
}
```

Twenty-odd lines, and there's still no `toString`, `equals` or `hashCode`.

## The same as a record

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Departure express = new Departure("IC 27", "Tampere", 8);
        System.out.println(express.train() + " to " + express.destination() + ", platform " + express.platform());
        System.out.println(express);
    }
}
```

**Departure.java**

```java
public record Departure(String train, String destination, int platform) {
}
```

**Output**

```text
IC 27 to Tampere, platform 8
Departure[train=IC 27, destination=Tampere, platform=8]
```

The word `record` takes the place of `class`, and after the name, in parentheses, come the record's **components**: the values each Departure holds, written like a constructor's parameters. From that one line, Java makes a class with:

- a `private final` instance variable for each component;
- a constructor that takes the components in the same order, `new Departure("IC 27", "Tampere", 8)`, and stores them;
- an **accessor** method for each component, named exactly like the component: `train()`, `destination()`, `platform()`. There's no `get` in front;
- a `toString` that shows the record's name and each component with its value, in brackets: `Departure[train=IC 27, destination=Tampere, platform=8]`;
- an `equals` and a `hashCode` that use the components (the next step).

The braces after the header hold the record's body. It's empty here; step 4 puts methods in it. A public record goes in a file of its name, `Departure.java`, just like a public class.

## No getters, no setters

The accessors are named after the components, so a getter's name doesn't compile:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Departure express = new Departure("IC 27", "Tampere", 8);
        System.out.println(express.getPlatform());
    }
}
```

**Departure.java**

```java
public record Departure(String train, String destination, int platform) {
}
```

**What javac prints**

```text
Main.java:4: error: cannot find symbol
        System.out.println(express.getPlatform());
                                  ^
  symbol:   method getPlatform()
  location: variable express of type Departure
1 error
```

There are no setters either, and the instance variables are `final`: once a record is made, its values stay as they are, like a String's characters. When a train moves to another platform, the program makes a new Departure (step 4 shows a neat way to do that).

---

Source: [Declaring a record](https://javaarena.com/learn/records/declaring-a-record/) in the module [Records](https://javaarena.com/learn/records/) on Java Arena.

An extra module, not part of the University of Helsinki's course. Lesson text: [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/).
