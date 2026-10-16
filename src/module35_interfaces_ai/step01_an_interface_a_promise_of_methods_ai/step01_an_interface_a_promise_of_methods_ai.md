> [!info] AI-Generated

# An interface: a promise of methods

Module 34's abstract classes listed methods that every subclass must write, such as the instruments' `sound()`. An **interface** is that idea on its own: a list of methods, with no code, that a class can promise to have. A class doesn't extend an interface. It **implements** it.

## Switchable

A smart home app controls all kinds of devices: heaters, fans, garden lights, sprinklers. For the app's on and off buttons, what a device does doesn't matter. What matters is that it can be turned on and off, and that it can say whether it's on. Here's that as an interface:

```java
public interface Switchable {
    void turnOn();
    void turnOff();
    boolean isOn();
}
```

- It's written like a class, with the word `interface` in place of `class`, and it goes in a file of its own, `Switchable.java`.
- Each method is a header followed by a semicolon, with no body, just like an abstract method. The interface says *what* a Switchable can do, and leaves *how* to each class.
- A method an interface lists (a header with no body) is always public, so there's no need to write `public` in front of it.
- An interface has no instance variables and no constructor. It isn't a recipe for objects, only a list of promises.

## implements

Here's a heater that keeps the promise:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Heater heater = new Heater("hall", 21);
        System.out.println(heater);
        heater.turnOn();
        System.out.println(heater.isOn());
        System.out.println(heater);
        heater.turnOff();
        System.out.println(heater.getDegrees());
    }
}
```

**Switchable.java**

```java
public interface Switchable {
    void turnOn();
    void turnOff();
    boolean isOn();
}
```

**Heater.java**

```java
public class Heater implements Switchable {
    private String room;
    private int degrees;
    private boolean on;

    public Heater(String room, int degrees) {
        this.room = room;
        this.degrees = degrees;
        this.on = false;
    }

    @Override
    public void turnOn() {
        this.on = true;
    }

    @Override
    public void turnOff() {
        this.on = false;
    }

    @Override
    public boolean isOn() {
        return this.on;
    }

    public int getDegrees() {
        return this.degrees;
    }

    @Override
    public String toString() {
        if (this.on) {
            return "Heater in the " + this.room + ": on, " + this.degrees + " degrees";
        }
        return "Heater in the " + this.room + ": off";
    }
}
```

**Output**

```text
Heater in the hall: off
true
Heater in the hall: on, 21 degrees
21
```

- `public class Heater implements Switchable` promises that Heater has every method that Switchable lists.
- Heater writes each of them with the same header, and with `public` in front.
- `@Override` works here too. Above a method that implements an interface's method, it checks that the interface really has a method with that header, so a misspelled `turnon` is caught. This course writes it above every such method, as it does above `toString`.
- A class may have more than the interface asks for: Heater has instance variables, a constructor, `getDegrees` and a `toString`. The interface only sets the minimum.

## javac holds the class to its promise

A garden light that forgot `isOn` doesn't compile:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        GardenLight light = new GardenLight();
        light.turnOn();
    }
}
```

**Switchable.java**

```java
public interface Switchable {
    void turnOn();
    void turnOff();
    boolean isOn();
}
```

**GardenLight.java**

```java
public class GardenLight implements Switchable {
    private boolean on;

    @Override
    public void turnOn() {
        this.on = true;
    }

    @Override
    public void turnOff() {
        this.on = false;
    }
}
```

**What javac prints**

```text
GardenLight.java:1: error: GardenLight is not abstract and does not override abstract method isOn() in Switchable
public class GardenLight implements Switchable {
       ^
1 error
```

It's the same message as for module 34's harp without a `sound()`. To javac, the methods an interface lists are abstract methods, and a class that implements the interface must write every one of them.

They must also be `public`. Without a word in front, a method can be used only by the classes of its own package (module 34), which is less than the interface promised:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        GardenLight light = new GardenLight();
        light.turnOn();
    }
}
```

**Switchable.java**

```java
public interface Switchable {
    void turnOn();
    void turnOff();
    boolean isOn();
}
```

**GardenLight.java**

```java
public class GardenLight implements Switchable {
    private boolean on;

    @Override
    void turnOn() {
        this.on = true;
    }

    @Override
    public void turnOff() {
        this.on = false;
    }

    @Override
    public boolean isOn() {
        return this.on;
    }
}
```

**What javac prints**

```text
GardenLight.java:5: error: turnOn() in GardenLight cannot implement turnOn() in Switchable
    void turnOn() {
         ^
  attempting to assign weaker access privileges; was public
1 error
```

It's the rule module 34 gave for a `toString` that isn't public: a method can't be less visible than the method it overrides or implements. Switchable's `turnOn` is public, so GardenLight's must be public too.

---

Source: [An interface: a promise of methods](https://javaarena.com/learn/interfaces/promise/) in the module [Interfaces](https://javaarena.com/learn/interfaces/) on Java Arena.

This module follows section [9.2 Interfaces](https://java-programming.mooc.fi/part-9/2-interface) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
