> [!info] AI-Generated

# Objects as values

The values of a map can be objects of your own class. Then the map finds a whole object by its key. A museum's audio guide works this way: each exhibit has a number on a small sign, and visitors type the number into the guide to hear about the exhibit. The keys are the numbers, and the values are `GuideStop` objects.

**Main.java**

```java
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, GuideStop> stops = new HashMap<>();
        GuideStop harbor = new GuideStop(12, "The Harbor at Dawn", 3);
        GuideStop horse = new GuideStop(27, "Bronze Horse", 5);
        stops.put(harbor.getNumber(), harbor);
        stops.put(horse.getNumber(), horse);

        GuideStop stop = stops.get(27);
        System.out.println(stop.getTitle() + " is in room " + stop.getRoom());
        stop.listen();
        stops.get(27).listen();
        stops.get(12).listen();
        System.out.println(stops.get(27));
        System.out.println(stops.get(12));
    }
}
```

**GuideStop.java**

```java
public class GuideStop {
    private int number;
    private String title;
    private int room;
    private int listens;

    public GuideStop(int number, String title, int room) {
        this.number = number;
        this.title = title;
        this.room = room;
        this.listens = 0;
    }

    public int getNumber() {
        return this.number;
    }

    public String getTitle() {
        return this.title;
    }

    public int getRoom() {
        return this.room;
    }

    public void listen() {
        this.listens++;
    }

    public String toString() {
        return this.title + " (room " + this.room + "), listens: " + this.listens;
    }
}
```

**Output**

```text
Bronze Horse is in room 5
Bronze Horse (room 5), listens: 2
The Harbor at Dawn (room 3), listens: 1
```

- The key comes from the object itself: `stops.put(harbor.getNumber(), harbor)`. That's common: a product found by its code, a user by their username. The key is then kept twice, in the object and in the map, and the two should match.
- A map keeps references to its objects, as a list does (module 22). `stops.get(27)` gives a reference to the Bronze Horse object in the map, not a copy of it. So `stop.listen()` changes the object in the map, and there's no need to put it back.
- `stops.get(27).listen()` finds the object and calls its method in one go. It's the same object again, so it now has 2 listens.

## A number with no stop

A visitor types 72 instead of 27. The map has no such key, `get` gives `null`, and calling a method on `null` crashes:

**Main.java**

```java
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, GuideStop> stops = new HashMap<>();
        GuideStop horse = new GuideStop(27, "Bronze Horse", 5);
        stops.put(horse.getNumber(), horse);
        stops.get(72).listen();
    }
}
```

**GuideStop.java**

```java
public class GuideStop {
    private int number;
    private String title;
    private int room;
    private int listens;

    public GuideStop(int number, String title, int room) {
        this.number = number;
        this.title = title;
        this.room = room;
        this.listens = 0;
    }

    public int getNumber() {
        return this.number;
    }

    public void listen() {
        this.listens++;
    }
}
```

**The program crashes with**

```text
Exception in thread "main" java.lang.NullPointerException: Cannot invoke "GuideStop.listen()" because the return value of "java.util.HashMap.get(Object)" is null
	at Main.main(Main.java:8)
```

When a key may be missing, keep what `get` gives in a variable, and check it before calling anything on it:

```java
GuideStop stop = stops.get(number);
if (stop == null) {
    System.out.println("No stop with the number " + number);
} else {
    stop.listen();
    System.out.println(stop);
}
```

---

Source: [Objects as values](https://javaarena.com/learn/hash-maps/objects-as-values/) in the module [Hash maps](https://javaarena.com/learn/hash-maps/) on Java Arena.

This module follows section [8.2 Hash Map](https://java-programming.mooc.fi/part-8/2-hash-map) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
