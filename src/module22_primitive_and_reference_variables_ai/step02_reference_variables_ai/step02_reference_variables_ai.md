> [!info] AI-Generated

# Reference variables

Module 14 showed that a list variable doesn't hold the list itself, but a **reference** to it: where the list is in the computer's memory. That's true of every variable whose type is a class, not only of lists. A `Bike` variable doesn't hold a bike. It holds a reference that leads to a Bike object, and the object itself is somewhere else in memory.

`new` creates the object and gives back a reference to it, and `=` stores that reference in the variable. Picture the variable holding an arrow that points at the object.

## Two variables, one object

Assigning one reference variable to another copies the reference (the arrow), not the object. Both variables then point at the same object, and a change made through one of them shows through the other:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Bike mine = new Bike("blue", 120);
        Bike borrowed = mine;
        borrowed.ride(35);
        System.out.println(mine);
        System.out.println(borrowed);
    }
}
```

**Bike.java**

```java
public class Bike {
    private String color;
    private int km;

    public Bike(String color, int km) {
        this.color = color;
        this.km = km;
    }

    public void ride(int km) {
        this.km = this.km + km;
    }

    public String toString() {
        return "The " + this.color + " bike, " + this.km + " km";
    }
}
```

**Output**

```text
The blue bike, 155 km
The blue bike, 155 km
```

- There's only one `new`, so there's only one bike. `Bike borrowed = mine;` gives it a second name. It's like lending your bike to a friend: they don't get a bike of their own, they ride yours.
- `borrowed.ride(35)` changes that one bike, and `mine` shows the new kilometers too.

For two separate bikes you need two `new`s. `Bike borrowed = new Bike("blue", 120);` builds a second bike that only looks the same, and riding it leaves yours alone.

## Pointing somewhere else, and ==

For objects, `==` compares the references: it's `true` when both sides point at the very same object. And assigning a new reference to a variable changes where that variable points, while the object it pointed at before stays as it was:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Bike mine = new Bike("blue", 120);
        Bike borrowed = mine;
        System.out.println(mine == borrowed);
        borrowed = new Bike("blue", 120);
        System.out.println(mine == borrowed);
        borrowed.ride(10);
        System.out.println(mine);
        System.out.println(borrowed);
    }
}
```

**Bike.java**

```java
public class Bike {
    private String color;
    private int km;

    public Bike(String color, int km) {
        this.color = color;
        this.km = km;
    }

    public void ride(int km) {
        this.km = this.km + km;
    }

    public String toString() {
        return "The " + this.color + " bike, " + this.km + " km";
    }
}
```

**Output**

```text
true
false
The blue bike, 120 km
The blue bike, 130 km
```

- At first both variables point at the same bike, so `mine == borrowed` is `true`.
- `borrowed = new Bike("blue", 120);` points `borrowed` at a new bike. The two bikes have the same color and kilometers, but they're two objects, so now `mine == borrowed` is `false`.
- `borrowed.ride(10)` rides the new bike, and `mine` still points at the old one, unchanged.

Keep the two apart: `borrowed.ride(10)` changes the object that `borrowed` points at, while `borrowed = ...` changes the variable, and no object changes. An object that nothing refers to any more (no variable, no list, no other object) can't be reached by the program. Java's **garbage collector** may free its memory later, though it may also never get around to it before the program ends.

Whether two different objects hold the same values is a question for a method called `equals`, which your own classes get in module 23. It's the same reason Strings are compared with `equals`, not with `==`.

## Strings are objects too

A String variable holds a reference as well. But a String can never be changed once it exists: `toUpperCase()` and `trim()` return their result, and `+` makes a new String, while the String you started with stays as it was. So two variables that share one String never notice each other:

```java
String first = "tea";
String second = first;
second = second + " with milk";
System.out.println(first);
System.out.println(second);
```

**Output**

```text
tea
tea with milk
```

`second + " with milk"` makes a new String, and `second` is pointed at it. `first` still points at `"tea"`.

---

Source: [Reference variables](https://javaarena.com/learn/references/reference-variables/) in the module [Primitive and reference variables](https://javaarena.com/learn/references/) on Java Arena.

This module follows sections [5.3 Primitive and reference variables](https://java-programming.mooc.fi/part-5/3-primitive-and-reference-variables), [5.4 Objects and references](https://java-programming.mooc.fi/part-5/4-objects-and-references) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
