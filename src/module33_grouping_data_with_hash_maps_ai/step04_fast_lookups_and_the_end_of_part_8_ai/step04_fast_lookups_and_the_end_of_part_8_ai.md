> [!info] AI-Generated

# Fast lookups, and the end of part 8

Before part 8, finding a value meant searching a list or an array. Module 28's linear search looks at the elements one at a time, and so do a list's `contains` and `indexOf`, which compare the value with each element using `equals`. To find a value near the end of a list of a million elements, or to find out that it isn't there at all, they make about a million comparisons. Binary search needs far fewer, but only on data that's kept sorted. A hash map needs neither: module 32 said that it finds a key about as fast among a million keys as among ten. This step shows that happen, and then ends part 8.

## Where the map looks

As module 32 showed, a hash map keeps its entries in many small groups, called **buckets**, and the key's hash code decides which bucket an entry goes into. `get` and `containsKey` work out the hash code of the key they're given, go straight to that bucket, and look only at the keys there. They call `equals` only when two hash codes are the same. The rest of the map isn't looked at.

What keeps this fast as the map grows is that Java's `HashMap` adds more buckets as it fills up, and spreads its entries out again, so that each bucket keeps only a few entries. Twice as many keys means about twice as many buckets, not twice as many keys in each bucket.

## Seeing the difference

A small experiment shows it. A `Card` is a student card with a number. Its `equals` compares the numbers, the way modules 23 and 32 wrote it, and its `hashCode` returns the number as it is, the way module 32's Seat used its seat number. For this experiment only, `equals` also counts how many times it's called. The program puts the same cards in a list and in a map, and then looks for the last card in both, each time with a new Card object that has its number:

**Main.java**

```java
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        experiment(100);
        experiment(1000);
        experiment(10000);
    }

    public static void experiment(int size) {
        ArrayList<Card> list = new ArrayList<>();
        HashMap<Card, Integer> map = new HashMap<>();
        for (int i = 1; i <= size; i++) {
            Card card = new Card(i);
            list.add(card);
            map.put(card, i);
        }

        Card wanted = new Card(size);
        Card again = new Card(size);
        if (list.contains(wanted) && map.containsKey(again)) {
            System.out.println(size + " cards: list " + wanted.getComparisons() + ", map " + again.getComparisons());
        }
    }
}
```

**Card.java**

```java
public class Card {
    private int number;
    private int comparisons;

    public Card(int number) {
        this.number = number;
        this.comparisons = 0;
    }

    public int getComparisons() {
        return this.comparisons;
    }

    public boolean equals(Object compared) {
        this.comparisons++;
        if (this == compared) {
            return true;
        }
        if (!(compared instanceof Card)) {
            return false;
        }
        Card other = (Card) compared;
        return this.number == other.number;
    }

    public int hashCode() {
        return this.number;
    }
}
```

**Output**

```text
100 cards: list 100, map 1
1000 cards: list 1000, map 1
10000 cards: list 10000, map 1
```

- Why do the counts end up in `wanted` and `again`? `contains` and `containsKey` call `equals` on the card you give them, with a card from the collection as the parameter. So every comparison adds one to the searched-for card's count.
- `list.contains(wanted)` compared the card with every card in the list before it reached the last one. Ten times the cards, ten times the comparisons.
- `map.containsKey(again)` went straight to the right bucket, and called `again.equals(...)` once, with the stored card that has the same number. Here that's one comparison at every size.
- Comparisons aren't the whole cost. Working out a hash code takes a moment too (a String's hash code goes through all its characters), but that work depends on the key, not on how many keys the map holds.

This relies on good hash codes. If many keys had the same hash code, they'd all land in the same bucket, and finding one of them would mean comparing it with many of the others: the map would lose much of its speed. That's why module 32's Seat multiplies the row's hash code by 31 before it adds the number: without the 31, B7, C6 and D5 would all share one hash code. Card's hash code is its number, so no two cards with different numbers share one. Java's own String and Integer already have good hash codes.

## A list or a map?

Speed isn't the only thing that matters. Each collection is good at different things:

| What the program needs | Use |
| --- | --- |
| Things in order, and each one by its place: the first, the last, the one at index 3 | a list |
| The same value more than once, like every card scanned at a desk during a day | a list |
| A thing found by a key, like a student by card number | a map |
| One value for each key, where a new value replaces the old one | a map |
| Counts or groups by a key | a map, with Integer or list values |

A map pays for its speed: it keeps each key only once, and it goes through its keys in an order of its own.

Often a program uses both. A list keeps the objects in the order they came, and a map finds them by a key. Building the map takes one loop over the list. After that, every lookup goes straight to its key, however many lookups there are.

## The end of part 8

This step ends the material of the MOOC's eighth part, the first part of Java Programming II. It started with a recap of parts 1 to 7, and then brought the hash map, which finds a value by its key. Module 32 showed how Java decides that two objects are the same, with `equals` and `hashCode`, so that objects of your own classes can be keys too. This module put lists in a map to group data, and showed why finding a key stays fast however big the map gets. Next, part 9 brings inheritance and interfaces. Part 8 closes with [the MOOC's page on fast data fetching and grouping information](https://java-programming.mooc.fi/part-8/5-fast-data-fetching-and-grouping-information) on its own site, for reading only.

---

Source: [Fast lookups, and the end of part 8](https://javaarena.com/learn/grouping/fast-lookups/) in the module [Grouping data with hash maps](https://javaarena.com/learn/grouping/) on Java Arena.

This module follows sections [8.4 Grouping data using hash maps](https://java-programming.mooc.fi/part-8/4-grouping-data-using-hash-maps), [8.5 Fast data fetching and grouping information](https://java-programming.mooc.fi/part-8/5-fast-data-fetching-and-grouping-information) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
