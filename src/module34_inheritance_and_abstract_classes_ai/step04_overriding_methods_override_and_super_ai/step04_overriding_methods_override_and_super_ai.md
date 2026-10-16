> [!info] AI-Generated

# Overriding methods: @Override and super

A subclass gets its superclass's methods, but sometimes one of them doesn't fit. A library lends most items for 21 days, but films for only 7. A film is one of the library's items, so `Film` extends `LibraryItem`, and it **overrides** the method that gives the loan period: it writes its own version, with the same header.

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        LibraryItem novel = new LibraryItem("The Quiet Harbor", 2019);
        Film film = new Film("Night Train", 2021, 104);
        System.out.println(novel);
        System.out.println(novel.loanDays());
        System.out.println(film);
        System.out.println(film.loanDays());
        System.out.println(film.getTitle());
    }
}
```

**LibraryItem.java**

```java
public class LibraryItem {
    private String title;
    private int year;

    public LibraryItem(String title, int year) {
        this.title = title;
        this.year = year;
    }

    public String getTitle() {
        return this.title;
    }

    public int loanDays() {
        return 21;
    }

    @Override
    public String toString() {
        return this.title + " (" + this.year + ")";
    }
}
```

**Film.java**

```java
public class Film extends LibraryItem {
    private int minutes;

    public Film(String title, int year, int minutes) {
        super(title, year);
        this.minutes = minutes;
    }

    @Override
    public int loanDays() {
        return 7;
    }

    @Override
    public String toString() {
        return super.toString() + ", film, " + this.minutes + " min";
    }
}
```

**Output**

```text
The Quiet Harbor (2019)
21
Night Train (2021), film, 104 min
7
Night Train
```

- Film's `loanDays` has the same name, the same parameters (none) and the same return type as LibraryItem's. For a Film object, Film's version runs. For a plain LibraryItem, LibraryItem's version runs.
- Film doesn't override `getTitle`, so a film uses the one it inherits.
- LibraryItem's `toString` overrides Object's, as in step 1, and Film's `toString` overrides LibraryItem's. Java runs the version nearest to the object's own class: a Film looks in Film first, then in LibraryItem, then in Object.

## @Override

The line `@Override` above a method is an **annotation**, a note for the compiler: "this method overrides a method of a superclass". It doesn't change what the program does. It adds a check: if no superclass has a method with that header, javac stops with an error. Here `toString` is misspelled with a small `s`:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Poster poster = new Poster("Night Train");
        System.out.println(poster);
    }
}
```

**Poster.java**

```java
public class Poster {
    private String title;

    public Poster(String title) {
        this.title = title;
    }

    @Override
    public String tostring() {
        return "Poster: " + this.title;
    }
}
```

**What javac prints**

```text
Poster.java:8: error: method does not override or implement a method from a supertype
    @Override
    ^
1 error
```

Without `@Override`, this compiles. `tostring` is then just a new method that nobody calls, and `println` uses Object's `toString`, with its class name and hash code. With `@Override`, the mistake shows up right away. From here on, this course writes `@Override` above every method that overrides another, `toString`, `equals` and `hashCode` included. The editors that generate those methods (module 32) add it too.

## super.method()

Film's `toString` starts with `super.toString()`. That calls LibraryItem's version of `toString`, on this same film, and Film adds its own part to the text. `super.` reaches the superclass's version of a method, even though Film overrides it.

- It saves repeating LibraryItem's code in Film. And Film couldn't repeat it anyway: `title` and `year` are private to LibraryItem, and there's no getter for the year.
- Without `super.`, the `toString()` inside Film's `toString` would be Film's own method again, which would call itself again, and so on, until the program crashes with a `StackOverflowError`.
- A subclass can call `super.someMethod()` in any of its methods, and at any point in the method, not only on the first line. (That rule is for `super(...)` in a constructor.)

## Overriding or overloading?

Module 21's overloading was two methods with the same name but different parameters, side by side in one class. Overriding is a method with the same name *and* the same parameters, in a subclass: for the subclass's objects, it takes the place of the superclass's version.

That's the trap step 1 warned about. `equals(Object compared)` overrides Object's `equals`. `equals(Exhibit compared)` has different parameters, so it overloads it: lists and maps never call it. `@Override` catches this mistake too, since the second one doesn't override anything.

---

Source: [Overriding methods: @Override and super](https://javaarena.com/learn/inheritance/overriding/) in the module [Inheritance and abstract classes](https://javaarena.com/learn/inheritance/) on Java Arena.

This module follows section [9.1 Class inheritance](https://java-programming.mooc.fi/part-9/1-inheritance) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
