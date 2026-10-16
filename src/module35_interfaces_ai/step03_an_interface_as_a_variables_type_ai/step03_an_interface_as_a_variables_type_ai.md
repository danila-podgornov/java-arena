> [!info] AI-Generated

# An interface as a variable's type

An interface is a type, just like a class. It can be the type of a variable, and such a variable can refer to an object of any class that implements the interface:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Switchable device = new Heater("hall", 21);
        device.turnOn();
        System.out.println(device);

        device = new GardenLight("patio");
        System.out.println(device.isOn());
        device.turnOn();
        System.out.println(device);
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

**GardenLight.java**

```java
public class GardenLight implements Switchable {
    private String place;
    private boolean on;
    private int switchOns;

    public GardenLight(String place) {
        this.place = place;
        this.on = false;
        this.switchOns = 0;
    }

    @Override
    public void turnOn() {
        if (!this.on) {
            this.on = true;
            this.switchOns++;
        }
    }

    @Override
    public void turnOff() {
        this.on = false;
    }

    @Override
    public boolean isOn() {
        return this.on;
    }

    @Override
    public String toString() {
        return "Garden light (" + this.place + "): " + this.switchOns + " switch-ons";
    }
}
```

**Output**

```text
Heater in the hall: on, 21 degrees
false
Garden light (patio): 1 switch-ons
```

- `Switchable device = new Heater("hall", 21);` compiles because Heater implements Switchable: a Heater is a Switchable. It's the same idea as module 34's `Adventurer hero = new Knight("Oren");`, with an interface in place of the superclass.
- Calls on `device` run the object's own methods: Heater's while `device` refers to the heater, and GardenLight's after the assignment.
- `println(device)` calls the object's own `toString`. Every object has Object's methods, so a variable of an interface type can use them too, even though Switchable doesn't list them.

## The variable's type decides what you may call

While `device` refers to the heater, the heater has a `getDegrees()`. Still, this doesn't compile:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Switchable device = new Heater("hall", 21);
        System.out.println(device.getDegrees());
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
}
```

**What javac prints**

```text
Main.java:4: error: cannot find symbol
        System.out.println(device.getDegrees());
                                 ^
  symbol:   method getDegrees()
  location: variable device of type Switchable
1 error
```

javac knows only that `device` holds some Switchable, and a garden light or a sprinkler has no degrees. These are module 34's two rules again:

- The **variable's type** decides which methods you may call. Through a Switchable variable, that's Switchable's three methods (and Object's).
- The **object's class** decides which version of a method runs.

So pick the type that fits what the code needs. Code that only switches devices on and off can use Switchable, and then it works with every device. Code that sets the heater's temperature needs a Heater variable.

## No objects of an interface

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Switchable device = new Switchable();
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

**What javac prints**

```text
Main.java:3: error: Switchable is abstract; cannot be instantiated
        Switchable device = new Switchable();
                            ^
1 error
```

An interface has no code to run, so there are no Switchable objects as such. Every object comes from a class, and a Switchable variable refers to an object of some class that implements Switchable, or to nothing (`null`).

An object whose class implements several interfaces fits in a variable of each of them: step 2's robot vacuum can be a Switchable and a Chargeable. Module 36 looks more closely at one object seen through each of its types.

---

Source: [An interface as a variable's type](https://javaarena.com/learn/interfaces/variable-type/) in the module [Interfaces](https://javaarena.com/learn/interfaces/) on Java Arena.

This module follows section [9.2 Interfaces](https://java-programming.mooc.fi/part-9/2-interface) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
