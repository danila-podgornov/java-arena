> [!info] AI-Generated

# Methods of an object

A Plant can be built now, but it can't do anything. What an object can do is given by its **methods**, written in the class after the constructor. Here's one that prints the plant's details:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Plant fern = new Plant("fern", 30);
        Plant cactus = new Plant("cactus", 12);
        fern.printInfo();
        cactus.printInfo();
        fern.printInfo();
    }
}
```

**Plant.java**

```java
public class Plant {
    private String name;
    private int height;

    public Plant(String name, int height) {
        this.name = name;
        this.height = height;
    }

    public void printInfo() {
        System.out.println(this.name + ", " + this.height + " cm");
    }
}
```

**Output**

```text
fern, 30 cm
cactus, 12 cm
fern, 30 cm
```

- The method has no `static`. The methods in modules 10 and 11 were `static`: they belong to the class as a whole, and you call them on their own, as in `printBanner();`. A method without `static` belongs to each object, and you call it on an object: `fern.printInfo();`.
- Inside the method, `this` is the object the method was called on. In `fern.printInfo()`, `this.name` is `"fern"`; in `cactus.printInfo()`, it's `"cactus"`. The method is written once, and every object runs it with its own variables.
- The method is `public`, so `Main` can call it, while the variables stay `private`. `void` means it returns nothing, as before.

A call needs an object in front of the dot. `printInfo();` alone in `main` looks for a method of `Main`, and `Plant.printInfo();` doesn't say which plant's info to print, so neither compiles.

## Parameters and conditions

A method of an object can take parameters, like any method, and use them together with the object's own variables. `printFits` tells whether the plant fits under a shelf of a given height:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Plant fern = new Plant("fern", 30);
        Plant cactus = new Plant("cactus", 12);
        fern.printFits(25);
        cactus.printFits(25);
    }
}
```

**Plant.java**

```java
public class Plant {
    private String name;
    private int height;

    public Plant(String name, int height) {
        this.name = name;
        this.height = height;
    }

    public void printInfo() {
        System.out.println(this.name + ", " + this.height + " cm");
    }

    public void printFits(int shelfHeight) {
        if (this.height < shelfHeight) {
            System.out.println("The " + this.name + " fits under the shelf");
        } else {
            System.out.println("The " + this.name + " is too tall for the shelf");
        }
    }
}
```

**Output**

```text
The fern is too tall for the shelf
The cactus fits under the shelf
```

`shelfHeight` comes from the call, and `this.height` from the object. A method of an object can hold anything a `static` method can: variables, conditions, loops and calls.

---

Source: [Methods of an object](https://javaarena.com/learn/classes/methods-of-an-object/) in the module [Classes and objects](https://javaarena.com/learn/classes/) on Java Arena.

This module follows section [4.1 Introduction to object-oriented programming](https://java-programming.mooc.fi/part-4/1-introduction-to-object-oriented-programming) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
