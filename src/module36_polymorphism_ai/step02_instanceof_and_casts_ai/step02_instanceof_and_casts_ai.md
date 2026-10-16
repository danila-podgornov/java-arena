> [!info] AI-Generated

# instanceof and casts

In a game, an `ArrayList<Enemy>` holds goblins, trolls and bats, and a loop over it can call anything every Enemy has. But some enemies have more. A troll can regenerate, and a bat flies at some altitude, which the hero's weapon may or may not reach. Through an Enemy variable, those methods can't be called: the variable's type decides what you may call, and not every Enemy is a troll or a bat. This step shows how a program asks an object what it is, and then gets a variable of the more specific type.

Here's the game's hierarchy. Enemy is abstract, since every enemy is some particular kind of enemy (module 34), and `Flying` is an interface with one method, `altitude()`:

```text
Object
  Enemy        (abstract)
    Goblin
    Troll
    Bat        implements Flying
```

## instanceof

`instanceof` asks whether an object has a type:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Enemy squeak = new Bat("Squeak", 3);
        System.out.println(squeak instanceof Bat);
        System.out.println(squeak instanceof Enemy);
        System.out.println(squeak instanceof Flying);
        System.out.println(squeak instanceof Object);
        System.out.println(squeak instanceof Troll);

        Enemy nobody = null;
        System.out.println(nobody instanceof Enemy);
    }
}
```

**Enemy.java**

```java
public abstract class Enemy {
    private String name;
    private int health;

    public Enemy(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public String getName() {
        return this.name;
    }

    public int getHealth() {
        return this.health;
    }

    public void heal(int amount) {
        this.health += amount;
    }

    @Override
    public String toString() {
        return this.name + " (" + this.health + ")";
    }
}
```

**Troll.java**

```java
public class Troll extends Enemy {
    public Troll(String name, int health) {
        super(name, health);
    }

    public void regenerate() {
        this.heal(5);
    }
}
```

**Bat.java**

```java
public class Bat extends Enemy implements Flying {
    private int altitude;

    public Bat(String name, int altitude) {
        super(name, 8);
        this.altitude = altitude;
    }

    @Override
    public int altitude() {
        return this.altitude;
    }
}
```

**Flying.java**

```java
public interface Flying {
    int altitude();
}
```

**Output**

```text
true
true
true
true
false
false
```

- `value instanceof Type` is `true` when the object that `value` refers to has that type. That's any of its types from step 1, not only its own class: a Bat is a Bat, an Enemy, a Flying and an Object.
- It looks at the object, not at the variable. `squeak` is an Enemy variable, and `squeak instanceof Flying` is still `true`.
- It's `false` for `null`, which isn't an object at all. So `instanceof` never crashes.
- Module 23's `equals` used it in the same way, to check that the compared object is of the right class.

## Casts

When `instanceof` says yes, a **cast** gets a variable of that type. Here the flying enemies report their altitude, and the troll regenerates:

**Main.java**

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Enemy> enemies = new ArrayList<>();
        enemies.add(new Troll("Grak", 30));
        enemies.add(new Bat("Squeak", 3));
        enemies.add(new Goblin("Snip", 20));
        enemies.add(new Bat("Flit", 12));

        for (Enemy enemy : enemies) {
            if (enemy instanceof Flying) {
                Flying flyer = (Flying) enemy;
                System.out.println(enemy.getName() + " flies at " + flyer.altitude() + " meters");
            } else {
                System.out.println(enemy.getName() + " is on the ground");
            }
        }

        Enemy first = enemies.get(0);
        if (first instanceof Troll) {
            Troll troll = (Troll) first;
            troll.regenerate();
        }
        System.out.println(first);
    }
}
```

**Enemy.java**

```java
public abstract class Enemy {
    private String name;
    private int health;

    public Enemy(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public String getName() {
        return this.name;
    }

    public int getHealth() {
        return this.health;
    }

    public void heal(int amount) {
        this.health += amount;
    }

    @Override
    public String toString() {
        return this.name + " (" + this.health + ")";
    }
}
```

**Goblin.java**

```java
public class Goblin extends Enemy {
    public Goblin(String name, int health) {
        super(name, health);
    }
}
```

**Troll.java**

```java
public class Troll extends Enemy {
    public Troll(String name, int health) {
        super(name, health);
    }

    public void regenerate() {
        this.heal(5);
    }
}
```

**Bat.java**

```java
public class Bat extends Enemy implements Flying {
    private int altitude;

    public Bat(String name, int altitude) {
        super(name, 8);
        this.altitude = altitude;
    }

    @Override
    public int altitude() {
        return this.altitude;
    }
}
```

**Flying.java**

```java
public interface Flying {
    int altitude();
}
```

**Output**

```text
Grak is on the ground
Squeak flies at 3 meters
Snip is on the ground
Flit flies at 12 meters
Grak (35)
```

- `(Flying) enemy` is a cast, as in module 23's `equals`. It doesn't create an object, and it doesn't change one. It gives a reference to the same object, with the type Flying, so javac lets `flyer.altitude()` through.
- `enemy` and `flyer` refer to the same bat. Through `enemy` the loop calls Enemy's `getName()`. Through `flyer` it calls the `altitude()` that Flying lists, and the bat's own version runs.
- The `if` makes the cast safe: it runs only for objects that are Flying.
- A cast to a class works the same way. `(Troll) first` gives a reference of type Troll to the troll at index 0. `troll` and `first` refer to the same object, the one in the list, so after `regenerate()`, printing `first` shows 35.

## A wrong cast crashes

javac accepts a cast whenever it *could* work. Whether it does is only known when the program runs:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Enemy snip = new Goblin("Snip", 20);
        Troll troll = (Troll) snip;
        troll.regenerate();
    }
}
```

**Enemy.java**

```java
public abstract class Enemy {
    private String name;
    private int health;

    public Enemy(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public void heal(int amount) {
        this.health += amount;
    }
}
```

**Goblin.java**

```java
public class Goblin extends Enemy {
    public Goblin(String name, int health) {
        super(name, health);
    }
}
```

**Troll.java**

```java
public class Troll extends Enemy {
    public Troll(String name, int health) {
        super(name, health);
    }

    public void regenerate() {
        this.heal(5);
    }
}
```

**The program crashes with**

```text
Exception in thread "main" java.lang.ClassCastException: class Goblin cannot be cast to class Troll (Goblin and Troll are in unnamed module of loader 'app')
	at Main.main(Main.java:4)
```

- `snip` is an Enemy variable, and an Enemy might be a troll, so javac lets `(Troll) snip` through. When the line runs, Java sees that the object is a goblin, and stops the program with a **ClassCastException**.
- A cast never turns an object into another class. A goblin stays a goblin. The cast works only when the object already has the type.
- So check with `instanceof` before a cast, unless the code can be sure of the type in some other way.
- A cast that could never work doesn't compile at all. `(String) snip` is an error, since no Enemy can be a String: javac says `incompatible types: Enemy cannot be converted to String`.

## instanceof, or a method of its own?

`instanceof` fits when only some objects have what the code needs: the flying enemies' altitude, or a troll's `regenerate()`. When every kind has its own answer to the same question, it's the wrong tool. Say each enemy is worth some points when it's defeated. This works:

```java
public static int points(Enemy enemy) {
    if (enemy instanceof Goblin) {
        return 10;
    } else if (enemy instanceof Troll) {
        return 50;
    } else if (enemy instanceof Bat) {
        return 5;
    }
    return 0;
}
```

But every new kind of enemy needs another `else if`, here and in every method written this way, and a forgotten one quietly gives 0 points. Instead, give Enemy an abstract method `points()`, and let each class write its own (module 34). Then the code asks `enemy.points()`, and javac makes every new kind of enemy say what it's worth. The next step builds a whole program in that way.

---

Source: [instanceof and casts](https://javaarena.com/learn/polymorphism/instanceof-and-casts/) in the module [Polymorphism](https://javaarena.com/learn/polymorphism/) on Java Arena.

This module follows sections [9.3 Object polymorphism](https://java-programming.mooc.fi/part-9/3-object-polymorphism), [9.4 Summary](https://java-programming.mooc.fi/part-9/4-summary) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
