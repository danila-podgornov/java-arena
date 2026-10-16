> [!info] AI-Generated

# Values and references as parameters

Module 10's rule is still the whole story: a parameter gets a copy of the argument. What gets copied depends on the kind of variable. For a primitive it's the value, and for an object it's the reference.

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        int km = 120;
        Bike bike = new Bike("blue", 120);
        addToNumber(km);
        addToBike(bike);
        System.out.println(km);
        System.out.println(bike);
    }

    public static void addToNumber(int km) {
        km = km + 50;
    }

    public static void addToBike(Bike bike) {
        bike.ride(50);
    }
}
```

**Bike.java**

```java
public class Bike {
    private String color;
    private int km;

    public Bike(String color, int km) {
        this.color = color;
        this.km = km;
    }

    public void ride(int km) {
        this.km = this.km + km;
    }

    public String toString() {
        return "The " + this.color + " bike, " + this.km + " km";
    }
}
```

**Output**

```text
120
The blue bike, 170 km
```

- `addToNumber` gets a copy of the number 120. It changes its own copy, and `main`'s `km` stays 120.
- `addToBike` gets a copy of the reference. The copy points at the same bike as `main`'s variable, so `bike.ride(50)` rides `main`'s bike. That's also why a method can change a list or an array it's given, as in modules 14 and 15.

## A new object for the parameter

A method can change the object its parameter points at, but it can't change which object the caller's variable points at. Giving the parameter a new object only moves the parameter's own arrow:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Bike bike = new Bike("blue", 120);
        replace(bike);
        System.out.println(bike);
    }

    public static void replace(Bike bike) {
        bike = new Bike("green", 0);
        bike.ride(5);
        System.out.println("In the method: " + bike);
    }
}
```

**Bike.java**

```java
public class Bike {
    private String color;
    private int km;

    public Bike(String color, int km) {
        this.color = color;
        this.km = km;
    }

    public void ride(int km) {
        this.km = this.km + km;
    }

    public String toString() {
        return "The " + this.color + " bike, " + this.km + " km";
    }
}
```

**Output**

```text
In the method: The green bike, 5 km
The blue bike, 120 km
```

After `bike = new Bike("green", 0);` the parameter points at a new green bike, and `ride(5)` rides that one. `main`'s variable was never touched, so it still points at the blue bike. When the caller should end up with a different object, the method returns it and the caller assigns it to its variable: `bike = newBike();`. A method can return an object, as `findOldest` did in module 19.

In short:

| The parameter's type | The method gets | What the method can change |
|---|---|---|
| primitive (`int`, `double`, `boolean`, `char`, ...) | a copy of the value | only its own copy |
| a class (an object) | a copy of the reference | the object's state, through its methods, but not which object the caller's variable points at |

---

Source: [Values and references as parameters](https://javaarena.com/learn/references/values-and-references-as-parameters/) in the module [Primitive and reference variables](https://javaarena.com/learn/references/) on Java Arena.

This module follows sections [5.3 Primitive and reference variables](https://java-programming.mooc.fi/part-5/3-primitive-and-reference-variables), [5.4 Objects and references](https://java-programming.mooc.fi/part-5/4-objects-and-references) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
