> [!info] AI-Generated

# Constructors

A new plant should get its name and height the moment it's created. That's the job of a **constructor**: code in the class that runs when an object is built with `new`, and gives the instance variables their first values.

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Start");
        Plant fern = new Plant("fern", 30);
        Plant cactus = new Plant("cactus", 12);
        System.out.println("End");
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
        System.out.println("Planted a " + this.name + ", " + this.height + " cm");
    }
}
```

**Output**

```text
Start
Planted a fern, 30 cm
Planted a cactus, 12 cm
End
```

(Constructors don't usually print anything. This one does, so that you can see when it runs: once for each `new`.)

- A constructor is written like a method, but it has the class's name and no return type, not even `void`: `public Plant(String name, int height)`.
- Its parameters work like a method's. `new Plant("fern", 30)` gives `"fern"` to `name` and 30 to `height`, in that order.
- `this` means the object being built. `this.name` is the object's instance variable `name`, while `name` on its own is the parameter. So `this.name = name;` copies the parameter's value into the object. A parameter with the same name as the instance variable it fills is the usual way to write a constructor; module 18 looks at `this` more closely.
- The parameters disappear when the constructor ends, but the values stored in the instance variables stay with the object for as long as it exists.

Not every instance variable needs a parameter. The `Lamp` in step 1 is built with only its place, and its constructor starts every lamp off with `this.on = false;`.

## When the values don't fit

A class without any constructor gets the default constructor from step 2, which takes no values, so it's built with empty parentheses. Once `Plant` has a constructor of its own that takes a name and a height, Java no longer adds the default one, and every `new Plant` must give both values, just as a method call must fit the method's parameters:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Plant basil = new Plant();
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
}
```

**What javac prints**

```text
Main.java:3: error: constructor Plant in class Plant cannot be applied to given types;
        Plant basil = new Plant();
                      ^
  required: String,int
  found:    no arguments
  reason: actual and formal argument lists differ in length
1 error
```

`required` lists the constructor's parameters, and `found` what the `new` gave. With the values the wrong way round, as in `new Plant(30, "basil")`, javac says `incompatible types: int cannot be converted to String`.

---

Source: [Constructors](https://javaarena.com/learn/classes/constructors/) in the module [Classes and objects](https://javaarena.com/learn/classes/) on Java Arena.

This module follows section [4.1 Introduction to object-oriented programming](https://java-programming.mooc.fi/part-4/1-introduction-to-object-oriented-programming) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
