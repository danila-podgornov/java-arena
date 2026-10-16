> [!info] AI-Generated

# null and NullPointerException

A reference variable can also point at no object at all. Its value is then `null`:

```java
String nickname = null;
System.out.println(nickname);
System.out.println("Nickname: " + nickname);
```

**Output**

```text
null
Nickname: null
```

`null` is a value of its own, written without quotes. Printing it, or joining it to a String with `+`, shows the word `null`. Only reference variables can be `null`: `int count = null;` doesn't compile, because an `int` always holds a number.

## Calling a method on null

A method call needs an object to run on. When the variable is `null` there's none, and the program crashes with a **NullPointerException**:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Bike bike = null;
        System.out.println("Ready to ride");
        bike.ride(10);
        System.out.println(bike);
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
Ready to ride
```

**The program crashes with**

```text
Exception in thread "main" java.lang.NullPointerException: Cannot invoke "Bike.ride(int)" because "<local1>" is null
	at Main.main(Main.java:5)
```

The message says what the program tried to do, call `ride(int)` on a Bike, and what was null. `<local1>` is a local variable. The compiled program here keeps local variables by number, not by name: `<local0>` is `main`'s parameter `args`, so `<local1>` is `bike`. Many editors compile with the names kept (`javac -g`), and then the message says `"bike" is null`. For an instance variable, the message names it, as in `"this.owner" is null`. The line number tells you where to look.

Nobody writes `Bike bike = null;` and then calls a method on it on purpose. In real programs the null comes from somewhere less obvious:

- **A search that found nothing.** A method that looks for an object often returns `null` when nothing matches.
- **An instance variable that was never set.** An instance variable of a class type starts as `null` and stays that way until the constructor or a method gives it an object. A missing `this.` in the constructor (module 18) leaves it `null` too.
- **An array element that was never filled.** `new Bike[3]` makes an array of three `null`s, not three bikes.

The crash happens where the null is used, which can be far from where it came from. So after reading the message, ask where that variable was supposed to get its object.

## Checking for null

When a variable may be `null`, check it before calling its methods. `==` and `!=` tell whether a reference is `null`:

**Main.java**

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Bike> bikes = new ArrayList<>();
        bikes.add(new Bike("blue", 120));
        bikes.add(new Bike("red", 45));

        Bike found = find(bikes, "red");
        if (found != null) {
            found.ride(5);
            System.out.println(found);
        }

        Bike missing = find(bikes, "yellow");
        if (missing == null) {
            System.out.println("No yellow bike");
        }
    }

    public static Bike find(ArrayList<Bike> bikes, String color) {
        for (Bike bike : bikes) {
            if (bike.getColor().equals(color)) {
                return bike;
            }
        }
        return null;
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

    public String getColor() {
        return this.color;
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
The red bike, 50 km
No yellow bike
```

- `find` returns the first bike of the color, or `null` when the loop finds none. Returning `null` is a common way to say "not found", and then every caller has to check for it.
- `found` points at the red bike in the list, not at a copy of it, so `found.ride(5)` rides the bike in the list.

A null check can share a condition with a test on the object, because `&&` looks at its right side only when its left side is `true`. In `if (bike != null && bike.getColor().equals("red"))`, `getColor()` is never called on `null`. In the same way, `||` looks at its right side only when its left side is `false`.

---

Source: [null and NullPointerException](https://javaarena.com/learn/references/null-and-nullpointerexception/) in the module [Primitive and reference variables](https://javaarena.com/learn/references/) on Java Arena.

This module follows sections [5.3 Primitive and reference variables](https://java-programming.mooc.fi/part-5/3-primitive-and-reference-variables), [5.4 Objects and references](https://java-programming.mooc.fi/part-5/4-objects-and-references) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
