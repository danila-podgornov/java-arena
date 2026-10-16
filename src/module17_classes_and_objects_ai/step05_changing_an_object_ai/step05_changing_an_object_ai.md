> [!info] AI-Generated

# Changing an object

An object remembers. Its instance variables keep their values from one method call to the next, and a method can change them. The values an object holds at a given moment are its **state**. Here the plant gets two methods that change its height:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Plant ivy = new Plant("ivy", 40);
        ivy.printInfo();
        ivy.grow(15);
        ivy.printInfo();
        ivy.cut(30);
        ivy.printInfo();
        ivy.cut(50);
        ivy.printInfo();
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

    public void grow(int cm) {
        this.height = this.height + cm;
    }

    public void cut(int cm) {
        this.height = this.height - cm;
        if (this.height < 5) {
            this.height = 5;
        }
    }
}
```

**Output**

```text
ivy, 40 cm
ivy, 55 cm
ivy, 25 cm
ivy, 5 cm
```

- `this.height = this.height + cm;` changes the object's own height. After `ivy.grow(15)` it stays 55 until another call changes it, and the next `printInfo()` prints the new value. (`this.height += cm;` does the same.)
- `cut` has a condition. The gardener always leaves at least 5 cm, so a plant never gets shorter than that: `ivy.cut(50)` would take the height to -25, and the `if` puts it back up to 5.
- Some methods change the state, like `grow` and `cut`. Others only look at it, like `printInfo`.

A method that changes the state doesn't need a parameter. The lamp's `turnOn()` from step 1 simply sets `this.on = true;`.

---

Source: [Changing an object](https://javaarena.com/learn/classes/changing-an-object/) in the module [Classes and objects](https://javaarena.com/learn/classes/) on Java Arena.

This module follows section [4.1 Introduction to object-oriented programming](https://java-programming.mooc.fi/part-4/1-introduction-to-object-oriented-programming) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
