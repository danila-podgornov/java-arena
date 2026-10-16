> [!info] AI-Generated

# A hash map inside a class

A map can be an instance variable, like a list (module 24). The class creates the map in its constructor, and its methods use it. The rest of the program calls the methods, and doesn't need to know that there's a map inside.

A radio station logs how many times each song was played:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        PlayLog log = new PlayLog();
        log.record("Night Bus");
        log.record("Paper Lanterns");
        log.record("Night Bus");
        System.out.println(log.timesPlayed("Night Bus"));
        System.out.println(log.timesPlayed("Paper Lanterns"));
        System.out.println(log.timesPlayed("Slow River"));
    }
}
```

**PlayLog.java**

```java
import java.util.HashMap;

public class PlayLog {
    private HashMap<String, Integer> plays;

    public PlayLog() {
        this.plays = new HashMap<>();
    }

    public void record(String title) {
        int before = this.plays.getOrDefault(title, 0);
        this.plays.put(title, before + 1);
    }

    public int timesPlayed(String title) {
        return this.plays.getOrDefault(title, 0);
    }
}
```

**Output**

```text
2
1
0
```

- The constructor creates the map. Without `this.plays = new HashMap<>();`, the instance variable would be `null` (module 22), and the first `record` would crash with a NullPointerException.
- `record` is the way to **count** with a map: get the count so far, with 0 for a song that hasn't been played yet, and put back one more. The `put` replaces the old count, since a key has only one value.
- `timesPlayed` gives 0 for a song that was never played, not `null`, so the caller can use the answer as a number right away.

The count can also be written with `containsKey`. It does the same:

```java
if (this.plays.containsKey(title)) {
    this.plays.put(title, this.plays.get(title) + 1);
} else {
    this.plays.put(title, 1);
}
```

## Tidy the keys in one place

When the keys come from people, the class can tidy every key itself. A private method keeps the tidying in one place, and every method that uses a key calls it, so a title is tidied the same way whether it's recorded or looked up:

```java
public void record(String title) {
    String key = tidy(title);
    this.plays.put(key, this.plays.getOrDefault(key, 0) + 1);
}

public int timesPlayed(String title) {
    return this.plays.getOrDefault(tidy(title), 0);
}

private String tidy(String title) {
    return title.trim().toLowerCase();
}
```

Now `record("Night Bus")` and `record(" night bus")` count the same song, and `timesPlayed("NIGHT BUS")` finds it. A method that forgot to call `tidy` would look for another key, and find nothing.

---

Source: [A hash map inside a class](https://javaarena.com/learn/hash-maps/map-in-a-class/) in the module [Hash maps](https://javaarena.com/learn/hash-maps/) on Java Arena.

This module follows section [8.2 Hash Map](https://java-programming.mooc.fi/part-8/2-hash-map) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
