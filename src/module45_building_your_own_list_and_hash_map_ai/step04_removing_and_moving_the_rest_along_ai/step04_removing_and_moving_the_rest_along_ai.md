> [!info] AI-Generated

# Removing, and moving the rest along

When an ArrayList removes an element, it closes the gap: every element after it moves one place toward the front, and its index goes down by one. Your own list has to do that work itself.

## Why not just null?

Setting the removed place to `null` would leave a hole in the middle of the list. The songs after it would keep their old indexes, `get` would return `null` from the hole, and `indexOf` would crash on it. A list has no holes: its songs are always at the indexes 0 to `size - 1`.

So the songs after the removed one each move one place to the left. Here the song at index 1 (B) is removed from a list of five, in an array of 8 (a dash is an empty place):

```text
index:     0  1  2  3  4  5
before:    A  B  C  D  E  -    size 5
move C:    A  C  C  D  E  -
move D:    A  C  D  D  E  -
move E:    A  C  D  E  E  -
clear 4:   A  C  D  E  -  -    size 4
```

Each move copies a song from the next place, from the front to the back. After the last move, the old last place still holds a copy of E, so it's set to `null` before the size goes down. Nothing reads the places after the size anyway, but a leftover reference there could keep an object in memory after the list has let go of it: remove the last song, and the reference in its place would be the only one left. ArrayList clears that place too.

## remove in code

Like ArrayList, Playlist gets two `remove` methods: one by index, which returns the removed song, and one by value, which returns whether it found the song:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        playlist.add("Morning Rain");
        playlist.add("Night Train");
        playlist.add("Paper Boats");
        playlist.add("Slow River");
        playlist.add("Copper Sky");
        System.out.println(playlist);

        String removed = playlist.remove(1);
        System.out.println("Removed " + removed + ": " + playlist);
        System.out.println(playlist.remove("Copper Sky") + " " + playlist.remove("Lantern Light"));
        System.out.println(playlist + ", size " + playlist.size());
    }
}
```

**Playlist.java**

```java
public class Playlist {
    private String[] songs;
    private int size;

    public Playlist() {
        this.songs = new String[4];
        this.size = 0;
    }

    public void add(String song) {
        if (this.size == this.songs.length) {
            grow();
        }
        this.songs[this.size] = song;
        this.size++;
    }

    private void grow() {
        String[] bigger = new String[this.songs.length * 2];
        for (int i = 0; i < this.size; i++) {
            bigger[i] = this.songs[i];
        }
        this.songs = bigger;
    }

    public int size() {
        return this.size;
    }

    public String get(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + this.size);
        }
        return this.songs[index];
    }

    public int indexOf(String song) {
        for (int i = 0; i < this.size; i++) {
            if (this.songs[i].equals(song)) {
                return i;
            }
        }
        return -1;
    }

    public String remove(int index) {
        String removed = get(index);
        for (int i = index; i < this.size - 1; i++) {
            this.songs[i] = this.songs[i + 1];
        }
        this.songs[this.size - 1] = null;
        this.size--;
        return removed;
    }

    public boolean remove(String song) {
        int index = indexOf(song);
        if (index < 0) {
            return false;
        }
        remove(index);
        return true;
    }

    @Override
    public String toString() {
        String text = "[";
        for (int i = 0; i < this.size; i++) {
            if (i > 0) {
                text += ", ";
            }
            text += this.songs[i];
        }
        return text + "]";
    }
}
```

**Output**

```text
[Morning Rain, Night Train, Paper Boats, Slow River, Copper Sky]
Removed Night Train: [Morning Rain, Paper Boats, Slow River, Copper Sky]
true false
[Morning Rain, Paper Boats, Slow River], size 3
```

- `remove(int index)` calls `get(index)` first. That checks the index, throwing for a bad one, and it gives the song to return.
- The loop runs from the removed place up to the second-to-last song: each place takes the song from the place after it. The order matters. Going from the back to the front, E would be copied into D's place, then from there into C's, and so on, and every place would end up holding E.
- `remove(String song)` lets `indexOf` find the song, and then the other `remove` does the moving. Which of the two Java calls depends on the argument: a String goes to `remove(String song)`, an int to `remove(int index)`, just as with an ArrayList (module 14).

## Long lists, long waits

Removing at index `i` from a list of `n` songs moves the `n - 1 - i` songs after it. Removing the last song moves nothing; removing the first moves all the others. To see it, this smaller Playlist, with only what the experiment needs, counts its moves:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        int[] sizes = {10, 1000, 100000};
        for (int size : sizes) {
            Playlist playlist = new Playlist();
            for (int i = 1; i <= size; i++) {
                playlist.add("Song " + i);
            }
            playlist.remove(0);
            int first = playlist.getMoves();
            playlist.remove(playlist.size() - 1);
            int last = playlist.getMoves() - first;
            System.out.println(size + " songs: removing the first moved " + first + ", removing the last moved " + last);
        }
    }
}
```

**Playlist.java**

```java
public class Playlist {
    private String[] songs;
    private int size;
    private int moves;

    public Playlist() {
        this.songs = new String[4];
        this.size = 0;
        this.moves = 0;
    }

    public void add(String song) {
        if (this.size == this.songs.length) {
            String[] bigger = new String[this.songs.length * 2];
            for (int i = 0; i < this.size; i++) {
                bigger[i] = this.songs[i];
            }
            this.songs = bigger;
        }
        this.songs[this.size] = song;
        this.size++;
    }

    public int size() {
        return this.size;
    }

    public int getMoves() {
        return this.moves;
    }

    public String remove(int index) {
        String removed = this.songs[index];
        for (int i = index; i < this.size - 1; i++) {
            this.songs[i] = this.songs[i + 1];
            this.moves++;
        }
        this.songs[this.size - 1] = null;
        this.size--;
        return removed;
    }
}
```

**Output**

```text
10 songs: removing the first moved 9, removing the last moved 0
1000 songs: removing the first moved 999, removing the last moved 0
100000 songs: removing the first moved 99999, removing the last moved 0
```

Removing from the middle moves about half the list. Java's ArrayList moves its elements the same way. It uses a fast copying method of Java's own, but the work still grows with the number of elements after the gap. So a program that keeps removing the first element of a long ArrayList, like a line where people leave from the front, does a lot of moving; removing at the end costs nothing extra. Adding at the end moves nothing either (apart from the occasional `grow`), but adding in the middle, with ArrayList's `add(index, value)`, moves everything after it one place the other way. The last challenge of this step builds that.

---

Source: [Removing, and moving the rest along](https://javaarena.com/learn/list-and-map-internals/remove/) in the module [Building your own list and hash map](https://javaarena.com/learn/list-and-map-internals/) on Java Arena.

This module follows section [12.2 ArrayList and hash table](https://java-programming.mooc.fi/part-12/2-arraylist-and-hashtable) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
