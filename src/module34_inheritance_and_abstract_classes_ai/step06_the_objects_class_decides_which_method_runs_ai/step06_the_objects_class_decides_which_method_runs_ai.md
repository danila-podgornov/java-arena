> [!info] AI-Generated

# The object's class decides which method runs

A Film is a LibraryItem, and a SavingsAccount is a BankAccount. Java takes that literally: a variable whose type is the superclass can refer to an object of a subclass. Then which version of an overridden method runs, the one of the variable's type or the one of the object's class?

## A variable of the superclass's type

In a small game, every adventurer attacks, but knights hit harder than archers:

**Main.java**

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Adventurer hero = new Knight("Oren");
        System.out.println(hero.attack());
        System.out.println(hero.describe());

        ArrayList<Adventurer> party = new ArrayList<>();
        party.add(hero);
        party.add(new Archer("Lyra"));
        party.add(new Adventurer("Pip"));
        int total = 0;
        for (Adventurer member : party) {
            System.out.println(member.describe());
            total += member.attack();
        }
        System.out.println("Party total: " + total);
    }
}
```

**Adventurer.java**

```java
public class Adventurer {
    private String name;

    public Adventurer(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int attack() {
        return 2;
    }

    public String describe() {
        return this.name + " attacks for " + this.attack();
    }
}
```

**Knight.java**

```java
public class Knight extends Adventurer {
    public Knight(String name) {
        super(name);
    }

    @Override
    public int attack() {
        return 9;
    }

    public void raiseShield() {
        System.out.println(this.getName() + " raises a shield");
    }
}
```

**Archer.java**

```java
public class Archer extends Adventurer {
    public Archer(String name) {
        super(name);
    }

    @Override
    public int attack() {
        return 6;
    }
}
```

**Output**

```text
9
Oren attacks for 9
Oren attacks for 9
Lyra attacks for 6
Pip attacks for 2
Party total: 17
```

- `Adventurer hero = new Knight("Oren");` compiles, because every Knight is an Adventurer: it has every method an Adventurer has.
- `hero.attack()` gives 9, Knight's number. Java doesn't look at the variable's type to pick the version. It looks at the object the variable refers to, and that object is a Knight.
- That holds even inside Adventurer's own code. `describe` is written in Adventurer, and calls `this.attack()`. For Oren, `this` is a Knight object, so Knight's `attack` runs. For Pip, a plain Adventurer, Adventurer's runs.
- So one list can hold every kind of adventurer, and one loop handles them all. The loop doesn't know or care which kind each member is: each object brings its own `attack`.

## The variable's type decides what you may call

`hero` refers to a Knight, and a Knight can raise a shield. Still, this doesn't compile:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Adventurer hero = new Knight("Oren");
        hero.raiseShield();
    }
}
```

**Adventurer.java**

```java
public class Adventurer {
    private String name;

    public Adventurer(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
```

**Knight.java**

```java
public class Knight extends Adventurer {
    public Knight(String name) {
        super(name);
    }

    public void raiseShield() {
        System.out.println(this.getName() + " raises a shield");
    }
}
```

**What javac prints**

```text
Main.java:4: error: cannot find symbol
        hero.raiseShield();
            ^
  symbol:   method raiseShield()
  location: variable hero of type Adventurer
1 error
```

javac checks each call against the variable's type. It doesn't run the program, so it doesn't know which object will be in `hero` when the call happens: some other line could put an Archer there. It only knows that `hero` holds some Adventurer, and not every Adventurer has `raiseShield`. With `Knight hero = new Knight("Oren");` the call compiles. (Module 36 shows how to get back to the Knight when a program needs to.)

The two rules, side by side:

- The **variable's type** decides which methods you may call. javac checks it before the program runs.
- The **object's class** decides which version of a method runs. That's settled while the program runs.

The other way around doesn't work at all: `Knight knight = new Adventurer("Pip");` doesn't compile (`incompatible types: Adventurer cannot be converted to Knight`), since an adventurer isn't necessarily a knight.

## Every object is an Object

Every class inherits from Object, so a variable of type Object can refer to any object at all. Its methods are Object's, but the versions that run are the object's own:

```java
Object first = "a String";
Object second = new ArrayList<String>();
String start = "Oak";
Object third = start + "dale";
System.out.println(first);
System.out.println(second);
System.out.println(third.equals("Oakdale"));
```

**Output**

```text
a String
[]
true
```

- `println` can print any object because it takes an Object and calls its `toString`, and each object runs its own: String's gives the text, ArrayList's gives the brackets.
- `third.equals(...)` runs String's `equals`, which compares the characters. Object's `equals` would compare with `==`, and `third` is a String built while the program runs, a different object from `"Oakdale"`.
- `first.length()` wouldn't compile: `first` is an Object variable, and Object has no `length()`.

---

Source: [The object's class decides which method runs](https://javaarena.com/learn/inheritance/actual-type/) in the module [Inheritance and abstract classes](https://javaarena.com/learn/inheritance/) on Java Arena.

This module follows section [9.1 Class inheritance](https://java-programming.mooc.fi/part-9/1-inheritance) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
