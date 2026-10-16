> [!info] AI-Generated

# Enums: a fixed set of values

Some values can only be one of a few: a traffic light is red, yellow or green, a cup of coffee is small, medium or large. Module 17's TrafficLight challenge kept its color in a String, `private String color;`, and compared it with `equals`. That works as long as every String is spelled exactly right, but nothing stops a typo:

```java
String light = "Green";
if (light.equals("green")) {
    System.out.println("Go");
} else {
    System.out.println("Stop");
}
```

**Output**

```text
Stop
```

The capital G makes it another String, and neither javac nor the program notices anything wrong. An **enum** (short for *enumerated type*) is a type that lists every value it can have:

```java
public enum Light {
    RED, YELLOW, GREEN
}
```

- It's written like a class, with the word `enum` in place of `class`, in a file of its own, `Light.java`.
- The values are called **constants**. They're separated by commas, and by custom written in capital letters.
- A variable of type Light can hold one of these three, and nothing else (or `null`, like any object variable).

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Light light = Light.GREEN;
        System.out.println(light);
        if (light == Light.GREEN) {
            System.out.println("Go");
        }
        light = Light.RED;
        System.out.println(light == Light.GREEN);
    }
}
```

**Light.java**

```java
public enum Light {
    RED, YELLOW, GREEN
}
```

**Output**

```text
GREEN
Go
false
```

- A constant is written with the enum's name and a dot: `Light.GREEN`.
- Printing a constant prints its name.
- Constants are compared with `==`. Each constant is one object, made once, the first time the program uses the enum, so there's never a second GREEN, and `==` is right here, unlike for Strings. (`equals` gives the same answers.)

A typo is now javac's problem, not the user's:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Light light = Light.GREN;
        System.out.println(light);
    }
}
```

**Light.java**

```java
public enum Light {
    RED, YELLOW, GREEN
}
```

**What javac prints**

```text
Main.java:3: error: cannot find symbol
        Light light = Light.GREN;
                           ^
  symbol:   variable GREN
  location: class Light
1 error
```

## values(), name() and ordinal()

- `Light.values()` returns an array of all the constants, in the order they're written in the enum. A for-each loop goes through it.
- `name()` returns a constant's name as a String, such as `"RED"`.
- `ordinal()` returns a constant's position in the enum, counted from 0.

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        for (Light light : Light.values()) {
            System.out.println(light.ordinal() + ": " + light.name().toLowerCase());
        }
        System.out.println(Light.values().length + " lights");
    }
}
```

**Light.java**

```java
public enum Light {
    RED, YELLOW, GREEN
}
```

**Output**

```text
0: red
1: yellow
2: green
3 lights
```

## An enum is a type

An enum can be the type of a variable, a parameter, a return value, an instance variable or a list's elements, like any class. A method can check which constant it got:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        System.out.println(canCross(Light.GREEN));
        System.out.println(canCross(Light.YELLOW));
    }

    public static boolean canCross(Light light) {
        return light == Light.GREEN;
    }
}
```

**Light.java**

```java
public enum Light {
    RED, YELLOW, GREEN
}
```

**Output**

```text
true
false
```

Java also has `Light.valueOf("RED")`, which gives the constant with that name. For a text that isn't a constant's name, it stops the program with an error, and part 11 covers handling errors like that.

---

Source: [Enums: a fixed set of values](https://javaarena.com/learn/useful-techniques/enums/) in the module [StringBuilder, regular expressions, enums and iterators](https://javaarena.com/learn/useful-techniques/) on Java Arena.

This module follows sections [10.3 Other useful techniques](https://java-programming.mooc.fi/part-10/3-other-useful-techniques), [10.4 Summary](https://java-programming.mooc.fi/part-10/4-summary) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
