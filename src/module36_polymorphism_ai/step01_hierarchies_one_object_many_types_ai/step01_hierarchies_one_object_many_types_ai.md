> [!info] AI-Generated

# Hierarchies: one object, many types

Modules 34 and 35 gave classes two ways to be related: a class extends one superclass, and it can implement any number of interfaces. Together, the classes and interfaces of a program form a **hierarchy**, a family tree of types. This module looks at what that means for one object, and for programs that handle many kinds of objects at once. The idea has a name, **polymorphism**, from the Greek for "many forms": one object can be used as several types, and one variable can refer to objects of many classes.

## A toll booth's vehicles

A toll booth charges every vehicle that goes through. A plain `Vehicle`, such as a motorbike, pays 3. A `Car` pays 6. A `Taxi` is a car, and pays 2 less than other cars. A `Truck` pays 5 for each axle. Taxis and trucks work for companies, which get a bill every month, so both implement an interface, `Commercial`, with one method: `company()`. Here's the hierarchy, with each class under the one it extends:

```text
Object
  Vehicle
    Car
      Taxi     implements Commercial
    Truck      implements Commercial
```

Vehicle doesn't say what it extends, so it extends Object (module 34). Here's the program, with one taxi in five variables:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Taxi taxi = new Taxi("TX-12", "Metro Cabs");
        Car car = taxi;
        Vehicle vehicle = taxi;
        Commercial customer = taxi;
        Object thing = taxi;

        System.out.println(taxi.toll() + " " + car.toll() + " " + vehicle.toll());
        System.out.println(customer.company());
        System.out.println(thing);
        System.out.println(thing == customer);
    }
}
```

**Vehicle.java**

```java
public class Vehicle {
    private String plate;

    public Vehicle(String plate) {
        this.plate = plate;
    }

    public String getPlate() {
        return this.plate;
    }

    public int toll() {
        return 3;
    }

    @Override
    public String toString() {
        return this.plate + " pays " + this.toll();
    }
}
```

**Car.java**

```java
public class Car extends Vehicle {
    public Car(String plate) {
        super(plate);
    }

    @Override
    public int toll() {
        return 6;
    }
}
```

**Taxi.java**

```java
public class Taxi extends Car implements Commercial {
    private String company;

    public Taxi(String plate, String company) {
        super(plate);
        this.company = company;
    }

    @Override
    public int toll() {
        return super.toll() - 2;
    }

    @Override
    public String company() {
        return this.company;
    }
}
```

**Truck.java**

```java
public class Truck extends Vehicle implements Commercial {
    private String company;
    private int axles;

    public Truck(String plate, String company, int axles) {
        super(plate);
        this.company = company;
        this.axles = axles;
    }

    @Override
    public int toll() {
        return 5 * this.axles;
    }

    @Override
    public String company() {
        return this.company;
    }
}
```

**Commercial.java**

```java
public interface Commercial {
    String company();
}
```

**Output**

```text
4 4 4
Metro Cabs
TX-12 pays 4
true
```

- There's one `new`, so there's one object, a Taxi. Five variables refer to it, and each has a different type.
- Each assignment compiles because a Taxi *is* each of those things: a Car, since Taxi extends Car; a Vehicle, since Car extends Vehicle; a Commercial, since Taxi implements it; and an Object, as every object is.
- Putting the object in another variable doesn't change it or copy it. `thing == customer` is `true`: both refer to the same Taxi.
- The toll is 4 through every variable. The object's class decides which version of a method runs (module 34), and this object is a Taxi, whatever the variable's type.

## Every type an object has

The taxi has five types. In general, an object's types are:

- its own class,
- every class above it, all the way up to Object,
- every interface that its class, or any class above it, implements,
- and every interface above those, all the way up, since an interface can extend another one, as Set extends Collection (module 35).

A variable of any of those types can refer to the object. The last two rules mean that interfaces are inherited, like methods: a class that extends Taxi is Commercial too, without writing `implements` again, and an ArrayList, which implements List, is a Collection too.

What changes from variable to variable is what you may call through it, since the variable's type decides that (modules 34 and 35):

| Through a variable of type | you may call |
| --- | --- |
| `Taxi` | `toll()`, `getPlate()` and `company()` |
| `Car` or `Vehicle` | `toll()` and `getPlate()` |
| `Commercial` | `company()` |
| `Object` | only Object's methods, such as `toString()` and `equals(...)` |

Object's methods can be called through all of them, since every object has those.

## Up the tree, never across

A variable can refer to objects of its own type and of every type below it in the tree. Other assignments don't compile:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Car car = new Truck("TR-88", "Nordic Freight", 3);
        Commercial customer = new Car("CR-55");
    }
}
```

**Vehicle.java**

```java
public class Vehicle {
    private String plate;

    public Vehicle(String plate) {
        this.plate = plate;
    }
}
```

**Car.java**

```java
public class Car extends Vehicle {
    public Car(String plate) {
        super(plate);
    }
}
```

**Truck.java**

```java
public class Truck extends Vehicle implements Commercial {
    private String company;
    private int axles;

    public Truck(String plate, String company, int axles) {
        super(plate);
        this.company = company;
        this.axles = axles;
    }

    @Override
    public String company() {
        return this.company;
    }
}
```

**Commercial.java**

```java
public interface Commercial {
    String company();
}
```

**What javac prints**

```text
Main.java:3: error: incompatible types: Truck cannot be converted to Car
        Car car = new Truck("TR-88", "Nordic Freight", 3);
                  ^
Main.java:4: error: incompatible types: Car cannot be converted to Commercial
        Commercial customer = new Car("CR-55");
                              ^
2 errors
```

- A Truck is a Vehicle, and so is a Car. But a Truck isn't a Car: classes side by side in the tree share only what's above them.
- A plain Car isn't Commercial, even though Taxi, a class below it, is. Types are passed down the tree, never up: a Car doesn't get what its subclasses add.

## Java's own classes

Java's own classes are built the same way. An ArrayList is a List and a Collection (module 35), and an Object:

```java
ArrayList<String> plates = new ArrayList<>();
plates.add("TX-12");
plates.add("TR-88");
List<String> list = plates;
Collection<String> collection = plates;
Object thing = plates;

list.add("CR-55");
System.out.println(collection.size());
System.out.println(thing);
System.out.println(thing == collection);
```

**Output**

```text
3
[TX-12, TR-88, CR-55]
true
```

Four variables, one list: `list.add` adds to the same list that `collection.size()` counts, and printing it through `thing` runs ArrayList's own `toString`. An ArrayList has a few more types, such as the abstract class AbstractList that module 35 mentioned. Java's documentation lists the superclasses and interfaces of each of its classes.

---

Source: [Hierarchies: one object, many types](https://javaarena.com/learn/polymorphism/many-types/) in the module [Polymorphism](https://javaarena.com/learn/polymorphism/) on Java Arena.

This module follows sections [9.3 Object polymorphism](https://java-programming.mooc.fi/part-9/3-object-polymorphism), [9.4 Summary](https://java-programming.mooc.fi/part-9/4-summary) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
