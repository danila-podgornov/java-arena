> [!info] AI-Generated

# get, indexOf and contains

A list you can only add to isn't much use. This step gives Playlist the methods that read it: `get` for the song at an index, `indexOf` to find where a song is, and `contains` to ask whether it's there at all.

## get, with a check on the index

The first idea is one line:

```java
public String get(int index) {
    return this.songs[index];
}
```

With a good index, it works. But take a playlist of 3 songs, whose array has 4 places. `get(3)` returns `null` from the empty place, without a word of warning, though the list has no song at index 3. And `get(7)` crashes with an ArrayIndexOutOfBoundsException that talks about an array of length 4, which the code using the list has never heard of.

So `get` checks the index against the size itself, and refuses a bad one by throwing an exception, as module 42 did with IllegalArgumentException. The right class here is **IndexOutOfBoundsException**, the parent of ArrayIndexOutOfBoundsException in module 42's family of exceptions. ArrayList's own `get` throws one too.

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        playlist.add("Morning Rain");
        playlist.add("Night Train");
        playlist.add("Paper Boats");
        System.out.println(playlist.get(2));
        System.out.println(playlist.get(3));
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

    public String get(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + this.size);
        }
        return this.songs[index];
    }
}
```

**Output**

```text
Paper Boats
```

**The program crashes with**

```text
Exception in thread "main" java.lang.IndexOutOfBoundsException: Index 3 out of bounds for size 3
	at Playlist.get(Playlist.java:28)
	at Main.main(Main.java:8)
```

- The good indexes are 0 to `size - 1`. Anything below 0, or at `size` or above, is refused, even when the array happens to have a place there.
- The message says what went wrong in the list's own terms: its size, not the length of an array nobody can see.
- The stack trace shows both methods: the exception was thrown in `Playlist.get`, on line 28 of Playlist.java, which `main` called on line 8.

## indexOf and contains

`indexOf` is module 28's linear search: it looks at the songs one at a time, from index 0, and returns the index of the first song that equals the one it's given, or -1 when none does. `contains` then needs only one line:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        playlist.add("Morning Rain");
        playlist.add("Night Train");
        playlist.add("Paper Boats");
        playlist.add("Night Train");
        playlist.add("Copper Sky");

        System.out.println(playlist.indexOf("Night Train"));
        System.out.println(playlist.indexOf("Slow River"));
        System.out.println(playlist.contains("Copper Sky"));
        for (int i = 0; i < playlist.size(); i++) {
            System.out.println((i + 1) + ". " + playlist.get(i));
        }
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

    public boolean contains(String song) {
        return indexOf(song) >= 0;
    }
}
```

**Output**

```text
1
-1
true
1. Morning Rain
2. Night Train
3. Paper Boats
4. Night Train
5. Copper Sky
```

- `indexOf` compares with `equals`, not `==`. A title the user types is a String object of its own, and `equals` compares the characters (modules 23 and 32). `Night Train` is in the list twice; `indexOf` returns as soon as it finds the first one.
- The loop stops at `this.size`. After it, the array holds `null`, and `this.songs[i].equals(song)` on a `null` place would throw a NullPointerException: there's no object there to call `equals` on. (This list expects nobody to add `null` itself. Java's ArrayList allows it, and its code checks for it.)
- `contains` asks `indexOf` and checks for -1, so the search is written only once.
- With `size()` and `get`, a for loop goes through the list just like an ArrayList. A for-each loop over a Playlist doesn't compile: for-each works on arrays and on classes that implement Java's interface Iterable, and Playlist doesn't.

---

Source: [get, indexOf and contains](https://javaarena.com/learn/list-and-map-internals/get-and-search/) in the module [Building your own list and hash map](https://javaarena.com/learn/list-and-map-internals/) on Java Arena.

This module follows section [12.2 ArrayList and hash table](https://java-programming.mooc.fi/part-12/2-arraylist-and-hashtable) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
