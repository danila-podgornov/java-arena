> [!info] AI-Generated

# Linear search

The second problem of this module is searching: where in the array is a given value, if it's there at all? The simplest algorithm looks at the elements one at a time, from the first to the last, and stops at the first match. It's called **linear search**, since it goes through the elements in a line. You've written it before (module 15). Here it is as a method that returns the index of the value, or -1 when the value isn't there. -1 is never an index, so the caller can tell the two answers apart.

A raffle keeps the numbers of the tickets it has sold in an array:

```java
public class Main {
    public static void main(String[] args) {
        int[] tickets = {512, 87, 340, 19, 777, 203};
        System.out.println(positionOf(tickets, 340));
        System.out.println(positionOf(tickets, 5));
    }

    public static int positionOf(int[] tickets, int wanted) {
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i] == wanted) {
                return i;
            }
        }
        return -1;
    }
}
```

**Output**

```text
2
-1
```

- `return i;` ends the method at the first match, loop and all. There's no need to look further.
- `return -1;` comes *after* the loop. Only when every element has been looked at, and none matched, is it clear that the value isn't there.
- The array doesn't need to be in any order. Linear search works on any array or list.

## How much work is it?

Count the values the search looks at. Each look is one comparison, `tickets[i] == wanted`. Finding 340 at index 2 took 3 looks, at indexes 0, 1 and 2. A value at index `i` takes `i + 1` looks. A value that isn't there takes a look at every element, since the search can't stop early.

| Array size | Values looked at, at most |
| --- | --- |
| 6 | 6 |
| 1,000 | 1,000 |
| 1,000,000 | 1,000,000 |

The work grows in step with the array: twice the values, twice the looks at worst. A value that is there is found, on average, about halfway through. That's fine for most programs, but one that searches a million values over and over has a lot to do. The next step shows how sorted data makes searching much faster.

The list methods `indexOf` and `contains` (module 14) do a linear search for you: they go through the list from the start, and compare each element with the value using `equals`.

## Searching a list of objects

Often the values are objects, and the search compares one of their instance variables. Here a music library finds an album by its title:

**Main.java**

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Album> albums = new ArrayList<>();
        albums.add(new Album("Kind of Blue", 1959));
        albums.add(new Album("Abbey Road", 1969));
        albums.add(new Album("Rumours", 1977));

        int index = indexOfTitle(albums, "Abbey Road");
        System.out.println(index + ": " + albums.get(index));
        System.out.println(indexOfTitle(albums, "Thriller"));
    }

    public static int indexOfTitle(ArrayList<Album> albums, String title) {
        for (int i = 0; i < albums.size(); i++) {
            if (albums.get(i).getTitle().equals(title)) {
                return i;
            }
        }
        return -1;
    }
}
```

**Album.java**

```java
public class Album {
    private String title;
    private int year;

    public Album(String title, int year) {
        this.title = title;
        this.year = year;
    }

    public String getTitle() {
        return this.title;
    }

    public int getYear() {
        return this.year;
    }

    public String toString() {
        return this.title + " (" + this.year + ")";
    }
}
```

**Output**

```text
1: Abbey Road (1969)
-1
```

- The loop goes over the indexes, so that it has an index to return. `albums.get(i)` is the album at index `i`, and `getTitle()` gives its title.
- Titles are Strings, so they're compared with `equals`, not `==` (module 16).
- `albums.indexOf` can't do this search: it would need an Album object equal to the one on the list, and all the program has is a title.

---

Source: [Linear search](https://javaarena.com/learn/sorting-searching/linear-search/) in the module [Sorting and searching](https://javaarena.com/learn/sorting-searching/) on Java Arena.

This module follows section [7.2 Algorithms](https://java-programming.mooc.fi/part-7/2-algorithms) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
