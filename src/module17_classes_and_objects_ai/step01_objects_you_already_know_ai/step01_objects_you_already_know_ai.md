> [!info] AI-Generated

# Objects you already know

You've been using **objects** since module 2. A Scanner is an object, every String is an object, and so is every ArrayList. An object holds some data, and it has methods, which you call with a dot after it: `scanner.nextLine()`, `word.length()`, `list.add("tea")`.

Two objects of the same kind each have their own data:

```java
String city = "Lima";
String river = "Mississippi";
System.out.println(city.length());
System.out.println(river.length());

ArrayList<String> groceries = new ArrayList<>();
ArrayList<String> chores = new ArrayList<>();
groceries.add("milk");
groceries.add("eggs");
chores.add("dishes");
System.out.println(groceries.size());
System.out.println(chores.size());
```

**Output**

```text
4
11
2
1
```

`city.length()` and `river.length()` run the same method, but each answers for its own text. `groceries` and `chores` are two separate lists: adding to one doesn't touch the other.

## Classes and new

Every object is made from a **class**. The class is the blueprint: it says what data each object holds and which methods it has. One class can make as many objects as you like, just as one blueprint can be used for a whole street of houses. Each house is built to the same plan, and painting one front door doesn't paint the others.

- `ArrayList` is a class. `new ArrayList<>()` builds a new, empty list object from it.
- `Scanner` is a class too, and `new Scanner(System.in)` builds a scanner that reads what the user types. The value in the parentheses is given to the new object as it's built.
- `String` is a class. Strings are usually made by writing text in quotes, without `new`, but each one is still an object.

The type of a variable that holds an object is the name of its class: `Scanner scanner` is a variable that holds a Scanner.

## A class in its own file

Java comes with a large library of ready-made classes, and a program can also have classes of its own. Each one is written in a file of its own, named after the class: the class `Lamp` is in the file `Lamp.java`. Here's a program of two files. You don't need to read `Lamp.java` closely yet: the next steps show how a class like it is written, line by line.

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Lamp desk = new Lamp("desk");
        Lamp porch = new Lamp("porch");
        desk.turnOn();
        desk.printState();
        porch.printState();
    }
}
```

**Lamp.java**

```java
public class Lamp {
    private String place;
    private boolean on;

    public Lamp(String place) {
        this.place = place;
        this.on = false;
    }

    public void turnOn() {
        this.on = true;
    }

    public void turnOff() {
        this.on = false;
    }

    public void printState() {
        if (this.on) {
            System.out.println("The " + this.place + " lamp is on");
        } else {
            System.out.println("The " + this.place + " lamp is off");
        }
    }
}
```

**Output**

```text
The desk lamp is on
The porch lamp is off
```

- `new Lamp("desk")` builds a new Lamp object and gives it the text `"desk"`. `Lamp desk` is a variable that holds a Lamp.
- `desk.turnOn()` calls `turnOn` on the desk lamp only. The porch lamp is a separate object, so it's still off.
- To use a class, you only need to know its methods and what they do, the same way you use an ArrayList without ever seeing its code.

In a challenge with several files, the editor shows a tab for each file, and **Check** compiles them all together.

---

Source: [Objects you already know](https://javaarena.com/learn/classes/objects-you-know/) in the module [Classes and objects](https://javaarena.com/learn/classes/) on Java Arena.

This module follows section [4.1 Introduction to object-oriented programming](https://java-programming.mooc.fi/part-4/1-introduction-to-object-oriented-programming) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
