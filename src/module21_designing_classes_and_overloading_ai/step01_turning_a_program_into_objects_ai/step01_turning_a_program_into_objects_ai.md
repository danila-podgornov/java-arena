> [!info] AI-Generated

# Turning a program into objects

This module is about designing classes: deciding what a class should hold and do, and giving it several constructors, or several methods of the same name. It starts with why a class of your own is worth writing at all.

## A program of plain variables

Here's a program that follows two people's steps for a day, written the way you'd have written it before module 17. The goal is 10000 steps a day.

```java
String firstName = "Noor";
int firstSteps = 0;
String secondName = "Theo";
int secondSteps = 0;

firstSteps = firstSteps + 6200;
secondSteps = secondSteps + 3100;
firstSteps = firstSteps + 4500;

if (firstSteps >= 10000) {
    System.out.println(firstName + ": " + firstSteps + " steps, goal reached");
} else {
    System.out.println(firstName + ": " + firstSteps + " steps");
}
if (secondSteps >= 10000) {
    System.out.println(secondName + ": " + secondSteps + " steps, goal reached");
} else {
    System.out.println(secondName + ": " + secondSteps + " steps");
}
```

**Output**

```text
Noor: 10700 steps, goal reached
Theo: 3100 steps
```

It works, but look at what it takes:

- Four variables, and only their names say that `firstName` and `firstSteps` belong together.
- The goal check is written twice. To change the goal, you have to find and change both copies.
- A third person means two more variables and a copy of every line that uses them. Write `firstSteps` in one of the copies where you meant `secondSteps`, and the program adds the steps to the wrong person, without any error message.

## The same program with objects

Each person has a name and a number of steps, and the same goal applies to everyone. That's a class: a `StepCounter` holds one person's name and steps, and knows the goal.

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        StepCounter noor = new StepCounter("Noor");
        StepCounter theo = new StepCounter("Theo");

        noor.walk(6200);
        theo.walk(3100);
        noor.walk(4500);

        System.out.println(noor);
        System.out.println(theo);
    }
}
```

**StepCounter.java**

```java
public class StepCounter {
    private String name;
    private int steps;

    public StepCounter(String name) {
        this.name = name;
        this.steps = 0;
    }

    public void walk(int steps) {
        this.steps = this.steps + steps;
    }

    public String toString() {
        if (this.steps >= 10000) {
            return this.name + ": " + this.steps + " steps, goal reached";
        }
        return this.name + ": " + this.steps + " steps";
    }
}
```

**Output**

```text
Noor: 10700 steps, goal reached
Theo: 3100 steps
```

The output is the same, but the program reads differently:

- `main` tells what happens in the words of the problem: Noor walks 6200 steps, Theo walks 3100. How the steps are added up is the class's business.
- Each person's name and steps travel together in one object, so they can't get mixed up with someone else's.
- The goal is written once, in `toString`. Change it there, and it changes for everyone.
- A third person is one more line: `StepCounter maya = new StepCounter("Maya");`.

This is the idea behind **object-oriented programming**: a program is built from objects, and each object looks after its own data and the rules that go with it. A class stands for one idea of the problem (here, a step counter), its instance variables are what each object must remember, and its methods are what can be done with it. The rest of the program only calls the methods, just as it uses an ArrayList without knowing how it works inside.

A class is worth it even when there's only one object. A program about a single person is still easier to read with a `StepCounter`, because the names of the class and its methods say what the variables are for.

---

Source: [Turning a program into objects](https://javaarena.com/learn/class-design/from-variables-to-objects/) in the module [Designing classes and overloading](https://javaarena.com/learn/class-design/) on Java Arena.

This module follows sections [5.1 Learning object-oriented programming](https://java-programming.mooc.fi/part-5/1-learning-object-oriented-programming), [5.2 Removing repetitive code (overloading methods and constructors)](https://java-programming.mooc.fi/part-5/2-method-and-constructor-overloading) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
