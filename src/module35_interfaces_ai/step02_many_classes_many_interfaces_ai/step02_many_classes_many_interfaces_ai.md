> [!info] AI-Generated

# Many classes, many interfaces

## One interface, many classes

Step 1's heater isn't the only switchable device in the app. Every kind of device can implement Switchable, and each one keeps the promise in its own way. A garden light counts how many times it has been switched on, since its bulb wears out:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Heater heater = new Heater("hall", 21);
        GardenLight light = new GardenLight("patio");
        heater.turnOn();
        light.turnOn();
        light.turnOn();
        light.turnOff();
        light.turnOn();
        System.out.println(heater);
        System.out.println(light);
        System.out.println(heater.isOn() + " " + light.isOn());
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
Garden light (patio): 2 switch-ons
true true
```

- Both classes have the three methods that Switchable lists, with the same headers. What the methods do is up to each class: the light's `turnOn` counts, but only when the light was off.
- Heater and GardenLight share no code and no superclass (other than Object). The interface is all they have in common, and that's all the app's buttons need, as the next steps show.

## One class, many interfaces

Some devices run on a battery. What the app needs from them is another interface:

```java
public interface Chargeable {
    int batteryPercent();
    void charge(int minutes);
}
```

A robot vacuum can be switched on, and it has a battery. A class can implement several interfaces: list them after `implements`, separated by commas.

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        RobotVacuum vacuum = new RobotVacuum();
        vacuum.clean(10);
        System.out.println(vacuum.batteryPercent());
        vacuum.turnOn();
        vacuum.clean(10);
        System.out.println(vacuum.batteryPercent());
        vacuum.turnOff();
        vacuum.charge(45);
        System.out.println(vacuum.batteryPercent() + "%, on: " + vacuum.isOn());
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

**Chargeable.java**

```java
public interface Chargeable {
    int batteryPercent();
    void charge(int minutes);
}
```

**RobotVacuum.java**

```java
public class RobotVacuum implements Switchable, Chargeable {
    private boolean on;
    private int battery;

    public RobotVacuum() {
        this.on = false;
        this.battery = 50;
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

    @Override
    public int batteryPercent() {
        return this.battery;
    }

    @Override
    public void charge(int minutes) {
        this.battery += minutes;
        if (this.battery > 100) {
            this.battery = 100;
        }
    }

    public void clean(int minutes) {
        if (this.on) {
            this.battery -= 2 * minutes;
            if (this.battery < 0) {
                this.battery = 0;
            }
        }
    }
}
```

**Output**

```text
50
30
75%, on: false
```

- `implements Switchable, Chargeable` makes two promises, and RobotVacuum keeps both: it has all five methods. Leave one out, and javac says which one is missing, and from which interface.
- `clean` is RobotVacuum's own. Neither interface knows about it.
- The vacuum's battery isn't in either interface. The interfaces only say that there's a `batteryPercent()` to ask, and the class decides how to keep the number.

## extends and implements together

A class can extend only one class, but it can implement any number of interfaces, and it can do both at once. `extends` comes first. If the app had an abstract class `Appliance` for the name and the power of every device (module 34), the vacuum's header could be:

```java
public class RobotVacuum extends Appliance implements Switchable, Chargeable {
```

Then a RobotVacuum would get Appliance's code, and still promise the methods of both interfaces. Step 9 comes back to when to use which.

---

Source: [Many classes, many interfaces](https://javaarena.com/learn/interfaces/several/) in the module [Interfaces](https://javaarena.com/learn/interfaces/) on Java Arena.

This module follows section [9.2 Interfaces](https://java-programming.mooc.fi/part-9/2-interface) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
