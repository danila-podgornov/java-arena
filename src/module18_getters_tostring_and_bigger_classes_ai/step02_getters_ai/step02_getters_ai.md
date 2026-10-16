> [!info] AI-Generated

# Getters

## Private variables

Module 17 kept every instance variable `private`, so that only the class's own code can change it. Private also means code outside the class can't even read it: `basil.height` in `main` doesn't compile (`height has private access in Plant`). But `main` often has a good reason to read a value, for example to compare two plants.

## Getters

The way in is a method of the class that returns the value. A method whose only job is to return an instance variable is called a **getter**. It's named `get` followed by the variable's name with a capital letter: `getHeight()` for `height`.

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Plant basil = new Plant("basil", 12);
        Plant fern = new Plant("fern", 30);
        basil.grow(5);
        System.out.println("The " + basil.getName() + " is " + basil.getHeight() + " cm");
        if (fern.getHeight() > basil.getHeight()) {
            System.out.println("The " + fern.getName() + " is taller");
        }
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

    public void grow(int cm) {
        this.height = this.height + cm;
    }

    public String getName() {
        return this.name;
    }

    public int getHeight() {
        return this.height;
    }
}
```

**Output**

```text
The basil is 17 cm
The fern is taller
```

- Code outside the class can now **read** the height, but it still can't **set** it. The height changes only through the class's own methods, such as `grow`, so the class stays in charge of its data.
- A getter is an ordinary method that returns a value, so `basil.getHeight()` can go in a print line, a comparison or a calculation.
- The getter of a `boolean` variable is usually named with `is`: a variable `private boolean ripe` gets `public boolean isRipe()`.

## Setters

A method that gives a variable a new value is a **setter**:

```java
public void setName(String name) {
    this.name = name;
}
```

Write a setter only when other code really needs to change that value freely. A method with a meaning, such as `grow(5)`, is often better than `setHeight(...)`: it says what happens, and the class can check the value, as `cut` did in module 17. A class doesn't need a getter and a setter for every variable either, only for the ones its users need.

---

Source: [Getters](https://javaarena.com/learn/object-methods/getters/) in the module [Getters, toString and bigger classes](https://javaarena.com/learn/object-methods/) on Java Arena.

This module follows section [4.1 Introduction to object-oriented programming](https://java-programming.mooc.fi/part-4/1-introduction-to-object-oriented-programming) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
