> [!info] AI-Generated

# Checking values with a compact constructor

The constructor Java writes for a record stores whatever it's given. Often some values make no sense: a temperature colder than absolute zero, a percentage of 140, a name with spaces around it. A record can check and tidy its values in a constructor of its own.

## A compact constructor

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Reading oulu = new Reading("  Oulu ", -4.5);
        System.out.println(oulu);
        Reading wrong = new Reading("Kemi", -300.0);
        System.out.println(wrong);
    }
}
```

**Reading.java**

```java
public record Reading(String station, double celsius) {
    public Reading {
        if (celsius < -273.15) {
            throw new IllegalArgumentException("colder than absolute zero: " + celsius);
        }
        station = station.trim();
    }
}
```

**Output**

```text
Reading[station=Oulu, celsius=-4.5]
```

**The program crashes with**

```text
Exception in thread "main" java.lang.IllegalArgumentException: colder than absolute zero: -300.0
	at Reading.<init>(Reading.java:4)
	at Main.main(Main.java:5)
```

`public Reading { ... }` is a **compact constructor**: the record's name with no parameter list at all. Its parameters are the components, `station` and `celsius`, and Java runs the code in the braces first and then stores the parameters in the instance variables by itself. So inside it you can:

- check a value and throw an exception (module 42) when it's wrong, so that no Reading with an impossible temperature can ever exist;
- change a parameter before it's stored: `station = station.trim();` gives the parameter a tidied value, and that's the value the record keeps. That's why `"  Oulu "` comes out as `Oulu`.

Note that it says `station = ...`, not `this.station = ...`. The parameter is what gets stored at the end; the instance variable itself is `final`, and only Java's own assignment after your code may set it:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        System.out.println(new Reading(" Oulu", -4.5));
    }
}
```

**Reading.java**

```java
public record Reading(String station, double celsius) {
    public Reading {
        this.station = station.trim();
    }
}
```

**What javac prints**

```text
Reading.java:3: error: cannot assign a value to final variable station
        this.station = station.trim();
            ^
1 error
```

## The long form

The constructor that takes all the components is the record's **canonical constructor**. The compact form is a short way to write it. Here is the same one written in full, with the parameter list repeated and every `this.x = x` assignment written out:

```java
public Reading(String station, double celsius) {
    if (celsius < -273.15) {
        throw new IllegalArgumentException("colder than absolute zero: " + celsius);
    }
    this.station = station.trim();
    this.celsius = celsius;
}
```

Both forms declare the same constructor, so a record can have only one of them. The compact form is what you'll usually see, since its whole point is to leave out what Java can write for you.

A tidied value matters for equality too: since the records keep `Oulu` either way, `new Reading("  Oulu ", -4.5)` equals `new Reading("Oulu", -4.5)`.

---

Source: [Checking values with a compact constructor](https://javaarena.com/learn/records/compact-constructors/) in the module [Records](https://javaarena.com/learn/records/) on Java Arena.

An extra module, not part of the University of Helsinki's course. Lesson text: [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/).
