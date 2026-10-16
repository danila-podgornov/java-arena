> [!info] AI-Generated

# Writing a class

Now you write classes of your own. The example in this module is a class for the plants in a garden, where every plant has a name and a height in centimeters.

## The class and its file

A class starts with `public class` and its name, and everything in it goes between its braces:

```java
public class Plant {

}
```

- A `public class Plant` must be in a file called `Plant.java`: the same name, capitals and all, plus `.java`. That's why `Main` has always been in `Main.java`.
- Class names start with a capital letter, and so does each new word in them: `Plant`, `GardenBed`, `ArrayList`. Variables and methods start with a small letter.
- The files of a program go side by side: in the editor as tabs, on your own computer in the same folder.
- A class without `public` in front may share a file with another class. The practice drills show their small classes that way, after `Main` in the same file, but in the lessons every class has a file of its own.

## Instance variables

The data that every object carries is declared at the top of the class, inside its braces but outside any method:

```java
public class Plant {
    private String name;
    private int height;
}
```

These are **instance variables** (also called fields). An *instance* is an object made from a class, and each instance gets its own copy of every instance variable: one plant can be a 30 cm fern while another is a 12 cm cactus. An instance variable lives as long as its object does, while a method's own variables disappear when the method ends.

Everything inside a class is indented one level (4 spaces), just as the lines of a method are indented inside the method.

## private

`private` means that only the code inside the `Plant` class can use the variable. Code in `Main` can't read it or change it:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Plant fern = new Plant();
        fern.height = 30;
    }
}
```

**Plant.java**

```java
public class Plant {
    private String name;
    private int height;
}
```

**What javac prints**

```text
Main.java:4: error: height has private access in Plant
        fern.height = 30;
            ^
1 error
```

Why lock the data away? Because then the class decides what happens to it. When every change to `height` has to go through the class's own methods, the class can make sure that no plant ever gets a height of -20. Code outside the class uses a Plant through its methods, the way you use an ArrayList through `add` and `get` without touching its insides. Hiding the data like this is called **encapsulation**, and in this course instance variables are always `private`.

## A class that does nothing yet

The class above already works as a blueprint: `Plant fern = new Plant();` builds a Plant object. When a class has no constructor of its own (that's the next step), Java gives it an empty one, called the **default constructor**, and that's what the empty parentheses call. The instance variables then start at default values: 0 for numbers, `false` for a boolean, and `null` for a String or any other object (`null` means "no object at all"). But this plant can't do anything yet: it has no methods, and nothing outside it can set its name or height. The next steps give it a constructor and methods.

---

Source: [Writing a class](https://javaarena.com/learn/classes/writing-a-class/) in the module [Classes and objects](https://javaarena.com/learn/classes/) on Java Arena.

This module follows section [4.1 Introduction to object-oriented programming](https://java-programming.mooc.fi/part-4/1-introduction-to-object-oriented-programming) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
