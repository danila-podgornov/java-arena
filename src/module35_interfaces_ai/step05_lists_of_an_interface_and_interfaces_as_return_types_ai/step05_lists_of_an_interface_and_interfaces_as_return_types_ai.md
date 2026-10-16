> [!info] AI-Generated

# Lists of an interface, and interfaces as return types

A phone's media player plays voice memos and radio shows. From every item in its queue, it needs a title, a length in seconds, and a way to play it:

```java
public interface Playable {
    String title();
    int seconds();
    void play();
}
```

## A list of Playables

A list's element type can be an interface too. Then the list holds objects of any class that implements it:

**Main.java**

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Playable> queue = new ArrayList<>();
        queue.add(new VoiceMemo("Groceries", 45));
        queue.add(new RadioShow("Morning News", 5));
        queue.add(new VoiceMemo("Door code", 12));

        int total = 0;
        for (Playable item : queue) {
            item.play();
            total += item.seconds();
        }
        System.out.println("In the queue: " + total + " seconds");

        Playable longest = longest(queue);
        System.out.println("Longest: " + longest.title());
    }

    public static Playable longest(ArrayList<Playable> queue) {
        Playable longest = queue.get(0);
        for (Playable item : queue) {
            if (item.seconds() > longest.seconds()) {
                longest = item;
            }
        }
        return longest;
    }
}
```

**Playable.java**

```java
public interface Playable {
    String title();
    int seconds();
    void play();
}
```

**VoiceMemo.java**

```java
public class VoiceMemo implements Playable {
    private String title;
    private int seconds;

    public VoiceMemo(String title, int seconds) {
        this.title = title;
        this.seconds = seconds;
    }

    @Override
    public String title() {
        return this.title;
    }

    @Override
    public int seconds() {
        return this.seconds;
    }

    @Override
    public void play() {
        System.out.println("Memo: " + this.title);
    }
}
```

**RadioShow.java**

```java
public class RadioShow implements Playable {
    private String name;
    private int minutes;

    public RadioShow(String name, int minutes) {
        this.name = name;
        this.minutes = minutes;
    }

    @Override
    public String title() {
        return this.name;
    }

    @Override
    public int seconds() {
        return 60 * this.minutes;
    }

    @Override
    public void play() {
        System.out.println("On air: " + this.name);
    }
}
```

**Output**

```text
Memo: Groceries
On air: Morning News
Memo: Door code
In the queue: 357 seconds
Longest: Morning News
```

- `ArrayList<Playable>` holds memos and shows side by side. `add` accepts a VoiceMemo because a VoiceMemo is a Playable.
- The loop variable `item` has the type Playable. Each time round, it refers to one object, and that object's `play` runs: a memo's prints `Memo:`, a show's prints `On air:`. The loop doesn't know or care which kind each item is.
- A new kind of item, such as a chapter of an audiobook, would be one more class that implements Playable. The loop wouldn't change.
- The class names VoiceMemo and RadioShow appear only where the objects are made. Everything after that works with Playable.

## Returning a Playable

`longest` has the return type Playable. It returns whichever object in the queue has the most seconds, and the caller keeps it in a Playable variable, so the caller may use Playable's methods on it.

- The object that comes back is still what it was: the radio show. `longest(queue).play()` would print `On air: Morning News`.
- A method can also create an object and return it as a Playable. The caller then doesn't even need to know which class it got. The last challenge of this step does that.

---

Source: [Lists of an interface, and interfaces as return types](https://javaarena.com/learn/interfaces/return-and-lists/) in the module [Interfaces](https://javaarena.com/learn/interfaces/) on Java Arena.

This module follows section [9.2 Interfaces](https://java-programming.mooc.fi/part-9/2-interface) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
