> [!info] AI-Generated

# Parameters and this

Module 17's constructors all used lines like `this.name = name;`, where `this.name` is the object's variable and `name` the parameter. The point behind it: a parameter with the same name as an instance variable **hides** that variable. Inside the constructor or method, a plain `name` always means the parameter, and `this.name` is the only way to reach the object's own variable.

## Without this

Leave out `this.`, and both sides of `name = name;` mean the parameter. The line copies the parameter into itself, and the instance variable is never set. It keeps the value every instance variable starts with: 0 for a number, `false` for a boolean, and `null` for a String, which means *no String at all*:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Guest guest = new Guest("Amara", 3);
        System.out.println(guest);
    }
}
```

**Guest.java**

```java
public class Guest {
    private String name;
    private int nights;

    public Guest(String name, int nights) {
        name = name;
        nights = nights;
    }

    public String toString() {
        return this.name + ", " + this.nights + " nights";
    }
}
```

**Output**

```text
null, 0 nights
```

Java doesn't complain: `name = name;` is allowed, it just does nothing useful. When an object shows `null` or 0 where you expected a value, a missing `this.` is the first thing to look for.

## Methods with parameters

The same goes for every method whose parameter has the name of an instance variable. Methods that change an object often get the new value as a parameter:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Guest guest = new Guest("Amara", 3);
        guest.extend(2);
        guest.rename("Amara Obi");
        System.out.println(guest);
    }
}
```

**Guest.java**

```java
public class Guest {
    private String name;
    private int nights;

    public Guest(String name, int nights) {
        this.name = name;
        this.nights = nights;
    }

    public void extend(int nights) {
        this.nights = this.nights + nights;
    }

    public void rename(String newName) {
        name = newName;
    }

    public String toString() {
        return this.name + ", " + this.nights + " nights";
    }
}
```

**Output**

```text
Amara Obi, 5 nights
```

- In `extend`, `this.nights` is the guest's nights so far, and `nights` is the parameter: the nights to add.
- In `rename` the parameter has another name, so `name` can only mean the instance variable, and `this.` isn't needed. Many programmers write it anyway, and so does this course: with `this.` in front, it's always clear which variables belong to the object.

---

Source: [Parameters and this](https://javaarena.com/learn/object-methods/this-and-parameters/) in the module [Getters, toString and bigger classes](https://javaarena.com/learn/object-methods/) on Java Arena.

This module follows section [4.1 Introduction to object-oriented programming](https://java-programming.mooc.fi/part-4/1-introduction-to-object-oriented-programming) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
