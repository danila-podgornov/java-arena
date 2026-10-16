> [!info] AI-Generated

# Several criteria, and sorted streams

The conference has grown: it now runs talks in three rooms at once, so several talks start at the same hour. The printed program lists them by hour, and the talks of the same hour by room, in alphabetical order. The room is a **second criterion**: it's only asked when the first one, the hour, is a tie.

## Two criteria in compareTo

`compareTo` compares the hours first. When they differ, that settles it. Only when they're the same does it go on to the rooms:

**Main.java**

```java
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<Talk> talks = new ArrayList<>();
        talks.add(new Talk("Clean code in practice", 11, "Room B"));
        talks.add(new Talk("Opening keynote", 9, "Main hall"));
        talks.add(new Talk("Testing with JUnit", 14, "Room A"));
        talks.add(new Talk("Accessible web forms", 11, "Room A"));
        talks.add(new Talk("Streams in depth", 14, "Main hall"));
        talks.add(new Talk("Game jams for beginners", 11, "Main hall"));
        Collections.sort(talks);
        for (Talk talk : talks) {
            System.out.println(talk);
        }
    }
}
```

**Talk.java**

```java
public class Talk implements Comparable<Talk> {
    private String title;
    private int hour;
    private String room;

    public Talk(String title, int hour, String room) {
        this.title = title;
        this.hour = hour;
        this.room = room;
    }

    public String getTitle() {
        return this.title;
    }

    public int getHour() {
        return this.hour;
    }

    public String getRoom() {
        return this.room;
    }

    @Override
    public int compareTo(Talk other) {
        int byHour = Integer.compare(this.hour, other.hour);
        if (byHour != 0) {
            return byHour;
        }
        return this.room.compareTo(other.room);
    }

    @Override
    public String toString() {
        return this.hour + ":00 " + this.room + ": " + this.title;
    }
}
```

**Output**

```text
9:00 Main hall: Opening keynote
11:00 Main hall: Game jams for beginners
11:00 Room A: Accessible web forms
11:00 Room B: Clean code in practice
14:00 Main hall: Streams in depth
14:00 Room A: Testing with JUnit
```

`byHour` is not 0 when the hours differ, and then it's the answer. The rooms are compared only for talks at the same hour. A third criterion would follow the same pattern: compare the rooms into a variable, return it if it's not 0, and compare the third value last.

## thenComparing

A comparator does the same with `thenComparing`. `Comparator.comparing(Talk::getHour).thenComparing(Talk::getRoom)` compares the hours, and for a tie, the rooms: the order above. Each room's door gets a sign with that room's talks, which is another order, by room first and then by hour:

**Main.java**

```java
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Talk> talks = new ArrayList<>();
        talks.add(new Talk("Clean code in practice", 11, "Room B"));
        talks.add(new Talk("Opening keynote", 9, "Main hall"));
        talks.add(new Talk("Testing with JUnit", 14, "Room A"));
        talks.add(new Talk("Accessible web forms", 11, "Room A"));
        talks.add(new Talk("Streams in depth", 14, "Main hall"));
        talks.add(new Talk("Game jams for beginners", 11, "Main hall"));
        talks.sort(Comparator.comparing(Talk::getRoom).thenComparing(Talk::getHour));
        for (Talk talk : talks) {
            System.out.println(talk);
        }
    }
}
```

**Talk.java**

```java
public class Talk implements Comparable<Talk> {
    private String title;
    private int hour;
    private String room;

    public Talk(String title, int hour, String room) {
        this.title = title;
        this.hour = hour;
        this.room = room;
    }

    public String getTitle() {
        return this.title;
    }

    public int getHour() {
        return this.hour;
    }

    public String getRoom() {
        return this.room;
    }

    @Override
    public int compareTo(Talk other) {
        int byHour = Integer.compare(this.hour, other.hour);
        if (byHour != 0) {
            return byHour;
        }
        return this.room.compareTo(other.room);
    }

    @Override
    public String toString() {
        return this.hour + ":00 " + this.room + ": " + this.title;
    }
}
```

**Output**

```text
9:00 Main hall: Opening keynote
11:00 Main hall: Game jams for beginners
14:00 Main hall: Streams in depth
11:00 Room A: Accessible web forms
14:00 Room A: Testing with JUnit
11:00 Room B: Clean code in practice
```

- The criteria are read from left to right. `thenComparing` is asked only when everything before it says "tie".
- More criteria mean more `thenComparing`s: `.thenComparing(Talk::getTitle)` after the hour would sort talks in the same room at the same hour by title.
- Talk still has its `compareTo`, but a sort that's given a comparator uses the comparator. The natural order is for the sorts that aren't given one.

## reversed in a chain

The hackathon's scoreboard from step 1's second challenge gets a rule for ties: the highest score first, and teams with the same score in alphabetical order. The score goes from high to low, but the names go from A to Z, so only the first criterion is reversed. Where `reversed()` stands makes the difference:

**Main.java**

```java
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Entry> entries = new ArrayList<>();
        entries.add(new Entry("Byte Club", 72));
        entries.add(new Entry("Null Pointers", 88));
        entries.add(new Entry("Stack Stars", 72));
        entries.add(new Entry("Loop Troop", 95));
        entries.add(new Entry("Array Aces", 88));

        entries.sort(Comparator.comparing(Entry::getScore).reversed().thenComparing(Entry::getTeam));
        System.out.println(entries);

        entries.sort(Comparator.comparing(Entry::getScore).thenComparing(Entry::getTeam).reversed());
        System.out.println(entries);
    }
}
```

**Entry.java**

```java
public class Entry {
    private String team;
    private int score;

    public Entry(String team, int score) {
        this.team = team;
        this.score = score;
    }

    public String getTeam() {
        return this.team;
    }

    public int getScore() {
        return this.score;
    }

    @Override
    public String toString() {
        return this.team + " " + this.score;
    }
}
```

**Output**

```text
[Loop Troop 95, Array Aces 88, Null Pointers 88, Byte Club 72, Stack Stars 72]
[Loop Troop 95, Null Pointers 88, Array Aces 88, Stack Stars 72, Byte Club 72]
```

`reversed()` turns around the whole comparator it's called on, which is everything to its left. In the first sort, that's just the score, and `thenComparing` after it adds the names, from A to Z. In the second, `reversed()` comes last and turns both criteria around, so the names of a tie go from Z to A. The first one is the scoreboard's rule.

## sorted with a comparator

A stream's `sorted()` takes a comparator too. `sorted()` with nothing in the parentheses uses the natural order (step 1), and `sorted(comparator)` uses the comparator. The scoreboard's top three, as a list of team names:

**Main.java**

```java
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Entry> entries = new ArrayList<>();
        entries.add(new Entry("Byte Club", 72));
        entries.add(new Entry("Null Pointers", 88));
        entries.add(new Entry("Stack Stars", 72));
        entries.add(new Entry("Loop Troop", 95));
        entries.add(new Entry("Array Aces", 88));

        Comparator<Entry> ranking = Comparator.comparing(Entry::getScore).reversed()
                .thenComparing(Entry::getTeam);
        List<String> podium = entries.stream()
                .sorted(ranking)
                .limit(3)
                .map(Entry::getTeam)
                .collect(Collectors.toList());
        System.out.println(podium);
        System.out.println("First handed in: " + entries.get(0));
    }
}
```

**Entry.java**

```java
public class Entry {
    private String team;
    private int score;

    public Entry(String team, int score) {
        this.team = team;
        this.score = score;
    }

    public String getTeam() {
        return this.team;
    }

    public int getScore() {
        return this.score;
    }

    @Override
    public String toString() {
        return this.team + " " + this.score;
    }
}
```

**Output**

```text
[Loop Troop, Array Aces, Null Pointers]
First handed in: Byte Club 72
```

- The comparator is kept in a variable, `ranking`, which gives the rule a name. A long chain may go on the next line, like the steps of a stream.
- `sorted(ranking)` comes before `limit(3)`, so the stream keeps the three best, not the first three handed in (module 37 showed that the order of the steps matters).
- The stream sorts only what passes through it. The list `entries` keeps the order in which the teams handed in their projects.

---

Source: [Several criteria, and sorted streams](https://javaarena.com/learn/sorting-objects/several-criteria/) in the module [Ordering objects: Comparable and Comparator](https://javaarena.com/learn/sorting-objects/) on Java Arena.

This module follows section [10.2 The Comparable Interface](https://java-programming.mooc.fi/part-10/2-interface-comparable) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
