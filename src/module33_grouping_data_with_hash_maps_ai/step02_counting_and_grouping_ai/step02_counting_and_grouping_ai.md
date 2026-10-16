> [!info] AI-Generated

# Counting and grouping

Step 1 added to the lists one call at a time. Often the data comes all at once, in a list, an array or a file, and a loop sorts it into groups. This step does that, first with counts and then with lists.

## Counting with a map

Module 31 counted with a map: a `HashMap<String, Integer>`, where each thing adds one to its count, with `getOrDefault(key, 0)` for a key that hasn't come up yet. Here the same counts how many words start with each letter:

```java
String[] words = {"sun", "moon", "sea", "star", "mist"};
HashMap<String, Integer> counts = new HashMap<>();
for (String word : words) {
    String first = word.substring(0, 1);
    int count = counts.getOrDefault(first, 0);
    counts.put(first, count + 1);
}
System.out.println(counts.get("s"));
System.out.println(counts.get("m"));
System.out.println(counts.getOrDefault("x", 0));
```

**Output**

```text
3
2
0
```

`word.substring(0, 1)` is the word's first letter, as a String (module 16). The counts say how many words start with each letter, but not which words.

## Grouping: a list for each key

Instead of counting the words of each letter, the program can keep them. The value becomes a list, and each word goes on the list of its first letter. It's step 1's `join`, in a loop:

```java
String[] words = {"sun", "moon", "sea", "star", "mist"};
HashMap<String, ArrayList<String>> byLetter = new HashMap<>();
for (String word : words) {
    String first = word.substring(0, 1);
    if (!byLetter.containsKey(first)) {
        byLetter.put(first, new ArrayList<>());
    }
    byLetter.get(first).add(word);
}
System.out.println(byLetter.get("s"));
System.out.println(byLetter.get("m"));
System.out.println(byLetter.get("s").size());
```

**Output**

```text
[sun, sea, star]
[moon, mist]
3
```

Counting and grouping go together: the size of a group is its count.

## Every group, in a fixed order

To print every group, go through the keys. But a HashMap goes through its keys in an order of its own, set by the keys' hash codes, and not in the order they were added. For String keys that order is the same on every run, but it's hard to predict, and adding more keys can change it. So it can't be relied on. When the order matters, sort the keys first, as module 31 did: copy them into a list, and sort the list with `Collections.sort`.

```java
String[] words = {"tulip", "iris", "rose", "tansy", "ivy", "rue", "aster"};
HashMap<String, ArrayList<String>> byLetter = new HashMap<>();
for (String word : words) {
    String first = word.substring(0, 1);
    if (!byLetter.containsKey(first)) {
        byLetter.put(first, new ArrayList<>());
    }
    byLetter.get(first).add(word);
}

ArrayList<String> letters = new ArrayList<>(byLetter.keySet());
Collections.sort(letters);
for (String letter : letters) {
    System.out.println(letter + ": " + byLetter.get(letter));
}
```

**Output**

```text
a: [aster]
i: [iris, ivy]
r: [rose, rue]
t: [tulip, tansy]
```

- `new ArrayList<>(byLetter.keySet())` makes a new list that holds the map's keys. It's the same as creating an empty list and adding each key in a for-each loop over `keySet()`.
- Sorting that list doesn't change the map. The loop then goes through the letters in alphabetical order, and gets each letter's group with `get`.
- Within each group, the words keep the order they were added in. Only the order of the keys needed fixing.

## Grouping objects by one of their values

The same pattern groups objects. Each Plant knows its name and the garden bed it grows in, and grouping the plants by bed gives a map from a bed to the list of its plants:

**Main.java**

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        ArrayList<Plant> plants = new ArrayList<>();
        plants.add(new Plant("kale", "North"));
        plants.add(new Plant("basil", "Herb"));
        plants.add(new Plant("leeks", "North"));
        plants.add(new Plant("thyme", "Herb"));
        plants.add(new Plant("beans", "South"));

        HashMap<String, ArrayList<Plant>> byBed = groupByBed(plants);
        ArrayList<String> beds = new ArrayList<>(byBed.keySet());
        Collections.sort(beds);
        for (String bed : beds) {
            System.out.println(bed + ": " + byBed.get(bed));
        }
    }

    public static HashMap<String, ArrayList<Plant>> groupByBed(ArrayList<Plant> plants) {
        HashMap<String, ArrayList<Plant>> byBed = new HashMap<>();
        for (Plant plant : plants) {
            String bed = plant.getBed();
            if (!byBed.containsKey(bed)) {
                byBed.put(bed, new ArrayList<>());
            }
            byBed.get(bed).add(plant);
        }
        return byBed;
    }
}
```

**Plant.java**

```java
public class Plant {
    private String name;
    private String bed;

    public Plant(String name, String bed) {
        this.name = name;
        this.bed = bed;
    }

    public String getName() {
        return this.name;
    }

    public String getBed() {
        return this.bed;
    }

    public String toString() {
        return this.name;
    }
}
```

**Output**

```text
Herb: [basil, thyme]
North: [kale, leeks]
South: [beans]
```

- The values are lists of Plant objects, `ArrayList<Plant>`. Printing a list prints each plant with its `toString`.
- The key is one of the object's values, `plant.getBed()`. The lists hold the objects themselves, so everything about each plant is still at hand, not only its name.
- `groupByBed` builds a new map and returns it. The list of plants doesn't change.

---

Source: [Counting and grouping](https://javaarena.com/learn/grouping/counting-and-grouping/) in the module [Grouping data with hash maps](https://javaarena.com/learn/grouping/) on Java Arena.

This module follows sections [8.4 Grouping data using hash maps](https://java-programming.mooc.fi/part-8/4-grouping-data-using-hash-maps), [8.5 Fast data fetching and grouping information](https://java-programming.mooc.fi/part-8/5-fast-data-fetching-and-grouping-information) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
