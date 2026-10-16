> [!info] AI-Generated

# Designing a class

Writing a class starts before the code. From a description of the problem, you decide what the class holds and what it can do. Take this one:

> A train has a name and a number of cars. Every car seats 60 people. Cars can be added to the train and taken off it, but a train always keeps at least one car. We want to know how many seats a train has, and to print it like `Coast Line: 3 cars, 180 seats`.

Four questions lead from a description like this to a class.

**1. What must each object remember?** The answer gives the instance variables. A train must remember its name and its number of cars. They differ from train to train, and the cars can change: `private String name;` and `private int cars;`.

The seats are different: they follow from the number of cars. If the class kept them in a variable of their own, every method that changes the cars would also have to update the seats, and a single forgotten line would leave a train with 3 cars and 240 seats. A value that can be worked out from the others is best worked out by a method, each time it's needed. The 60 seats of a car are the same for every train, so that method can simply use the number 60.

**2. What does a new object need?** The answer gives the constructor's parameters. A new train needs its name. The description doesn't say how many cars a train starts with, so let it start with one: `public Train(String name)`.

**3. What can be done with it, and what do we want to know?** The answers give the methods. The things that are done, adding cars and taking them off, become methods that change the object: `addCar()` and `removeCar()`. The rule "at least one car" goes into `removeCar`, the only place where the cars go down. The question "how many seats?" becomes a method that returns a value: `seats()`.

**4. How should it look as text?** The answer goes in `toString`, which can call `seats()` instead of multiplying again.

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Train train = new Train("Coast Line");
        train.addCar();
        train.addCar();
        System.out.println(train);
        train.removeCar();
        train.removeCar();
        train.removeCar();
        System.out.println(train.seats());
    }
}
```

**Train.java**

```java
public class Train {
    private String name;
    private int cars;

    public Train(String name) {
        this.name = name;
        this.cars = 1;
    }

    public void addCar() {
        this.cars = this.cars + 1;
    }

    public void removeCar() {
        if (this.cars > 1) {
            this.cars = this.cars - 1;
        }
    }

    public int seats() {
        return this.cars * 60;
    }

    public String toString() {
        return this.name + ": " + this.cars + " cars, " + this.seats() + " seats";
    }
}
```

**Output**

```text
Coast Line: 3 cars, 180 seats
60
```

- `main` doesn't need to know that the seats are worked out rather than stored: it just asks `seats()`.
- `toString` calls the object's own `seats()`, so "60 seats a car" is written in one place only.
- `removeCar` keeps the train at one car at least, whatever `main` does. The third `removeCar()` above changes nothing.

Designs can differ. Another program might need a constructor that also takes the number of cars, or a method that tells whether a group fits on the train. Start with what the description asks for: a method that nothing calls is only more code to read.

---

Source: [Designing a class](https://javaarena.com/learn/class-design/designing-a-class/) in the module [Designing classes and overloading](https://javaarena.com/learn/class-design/) on Java Arena.

This module follows sections [5.1 Learning object-oriented programming](https://java-programming.mooc.fi/part-5/1-learning-object-oriented-programming), [5.2 Removing repetitive code (overloading methods and constructors)](https://java-programming.mooc.fi/part-5/2-method-and-constructor-overloading) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
