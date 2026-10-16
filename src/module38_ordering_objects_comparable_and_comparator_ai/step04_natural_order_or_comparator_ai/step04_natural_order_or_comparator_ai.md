> [!info] AI-Generated

# Natural order or comparator?

An order can live in two places: inside the class, as its `compareTo`, or outside it, as a comparator handed to a sort. This step is about choosing between them, and it ends the module with a challenge that uses both.

## An order that belongs to the class

An app store keeps the releases of an app. Each release has a version number of two parts, such as 2.9 or 2.10, and a download count. Kept as text, the versions sort wrongly:

```java
ArrayList<String> versions = new ArrayList<>();
versions.add("2.9");
versions.add("10.0");
versions.add("2.10");
Collections.sort(versions);
System.out.println(versions);
```

**Output**

```text
[10.0, 2.10, 2.9]
```

Text is compared character by character. The character 1 comes before 2, so "10.0" goes first, and "2.10" goes before "2.9" because 1 comes before 9. But 2.10 is the release after 2.9, and 10.0 came after both. Versions have one right order, the same everywhere and for everyone. That's what a natural order is for:

**Main.java**

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Release> releases = new ArrayList<>();
        releases.add(new Release(2, 9, 5400));
        releases.add(new Release(10, 0, 820));
        releases.add(new Release(2, 10, 7300));
        releases.add(new Release(1, 4, 12000));

        Collections.sort(releases);
        System.out.println("History: " + releases);

        releases.sort(Comparator.comparing(Release::getDownloads).reversed());
        System.out.println("Most downloaded: " + releases);
    }
}
```

**Release.java**

```java
public class Release implements Comparable<Release> {
    private int major;
    private int minor;
    private int downloads;

    public Release(int major, int minor, int downloads) {
        this.major = major;
        this.minor = minor;
        this.downloads = downloads;
    }

    public int getDownloads() {
        return this.downloads;
    }

    @Override
    public int compareTo(Release other) {
        int byMajor = Integer.compare(this.major, other.major);
        if (byMajor != 0) {
            return byMajor;
        }
        return Integer.compare(this.minor, other.minor);
    }

    @Override
    public String toString() {
        return this.major + "." + this.minor;
    }
}
```

**Output**

```text
History: [1.4, 2.9, 2.10, 10.0]
Most downloaded: [1.4, 2.10, 2.9, 10.0]
```

- The version numbers are ints, and `compareTo` compares them as step 3 did: the first part, and for a tie, the second.
- The download ranking is the order of one page of the store. It changes every day, and it isn't what anyone means by "the order of the versions". So it's a comparator, written where that page sorts its list.

## How to choose

- **In the class, with Comparable**, when the objects have one order that everyone expects, the same all over the program: versions, times of day, dates, sizes. Then `Collections.sort(list)` and `sorted()` work with nothing more, and so does anything else in Java that needs an order. A class has only one `compareTo`, so give it the obvious order, or none.
- **Where you sort, with a Comparator**, for every other order. There can be any number of them, and the class doesn't change: the flights by gate, the releases by downloads, the teas by price and then name. A rule that belongs to one page or one report goes next to the code of that page.
- **No natural order at all** is fine. Is a hackathon entry "smaller" than another when its score is lower, or when its team's name comes first? Neither is obvious, and the contest's ranking rules might change. Such a class is better off without `compareTo`, and every sort says which order it wants. Step 1's hackathon challenge gave Entry a `compareTo` only to show the two values swapped. Step 3's Entry has none, and that's the better design.
- **A class that isn't yours** keeps its natural order. String's `compareTo` is alphabetical, and you can't change the class String. A comparator can sort Strings in any other order, such as by length.
- **The natural order backwards** is `Comparator.reverseOrder()`. `releases.sort(Comparator.reverseOrder())` would put the newest version first.

The last two, on names:

```java
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Priya");
        names.add("Bo");
        names.add("Alexander");
        names.add("Ines");
        names.sort(Comparator.comparing(String::length));
        System.out.println(names);
        names.sort(Comparator.reverseOrder());
        System.out.println(names);
    }
}
```

**Output**

```text
[Bo, Ines, Priya, Alexander]
[Priya, Ines, Bo, Alexander]
```

`String::length` is a method of the value itself, like module 37's `String::toUpperCase`, so `Comparator.comparing(String::length)` compares two names by their lengths.

| You want | Use | Examples from this module |
| --- | --- | --- |
| The one order everybody expects of the class | `implements Comparable<...>` and `compareTo` | talks by start time, versions by number |
| Another order, for one list or one page | a lambda, or `Comparator.comparing(...)` | flights by gate, releases by downloads |
| A second criterion for ties | `thenComparing`, or a second comparison in `compareTo` | talks by hour, then room |
| The largest first | `reversed()`, or the two values swapped in `Integer.compare` | the hackathon's scoreboard |
| A sorted view that leaves the list as it is | `sorted()` or `sorted(comparator)` in a stream, or a sorted copy | the podium, the largest videos |

## What this module covered

A class gets a natural order by implementing `Comparable` and its `compareTo`, which answers negative, zero or positive, and `Integer.compare` and String's own `compareTo` do most of the work. `Collections.sort(list)` and a stream's `sorted()` use that order. Any other order is a `Comparator`: a lambda of two objects, or one built with `Comparator.comparing` from a getter, turned around with `reversed()` and given more criteria with `thenComparing`, for `list.sort`, `Collections.sort` and `sorted`. These are the topics of the MOOC's section 10.2. Module 39 finishes part 10 with StringBuilder, regular expressions, enums and iterators.

---

Source: [Natural order or comparator?](https://javaarena.com/learn/sorting-objects/choosing/) in the module [Ordering objects: Comparable and Comparator](https://javaarena.com/learn/sorting-objects/) on Java Arena.

This module follows section [10.2 The Comparable Interface](https://java-programming.mooc.fi/part-10/2-interface-comparable) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
