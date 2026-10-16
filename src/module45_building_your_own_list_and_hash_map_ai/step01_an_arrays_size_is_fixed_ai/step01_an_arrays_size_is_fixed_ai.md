> [!info] AI-Generated

# An array's size is fixed

Since module 13 you've added to lists without a thought about room: `add` always works, however many elements the list holds already. Since module 31, a HashMap has found a value by its key in a moment. This module opens both of them up. You'll build your own list and your own hash map, on top of plain arrays, and see why `add` never runs out of room and why a lookup in a map stays fast. Java's own ArrayList and HashMap are more refined, and you'll go on using them, but they work on the same ideas.

## Arrays, a quick recap

Module 15's arrays hold a fixed number of values of one type. `new String[3]` makes room for three Strings at the indexes 0 to 2, and each place starts out as `null`. `length` tells how many places there are:

```java
String[] playlist = new String[3];
playlist[0] = "Morning Rain";
playlist[1] = "Night Train";
System.out.println(playlist.length);
System.out.println(playlist[1]);
System.out.println(playlist[2]);
```

**Output**

```text
3
Night Train
null
```

An array keeps the size it was created with for as long as it exists. There's no way to add a fourth place to this one:

```java
public class Main {
    public static void main(String[] args) {
        String[] playlist = new String[3];
        playlist[0] = "Morning Rain";
        playlist[1] = "Night Train";
        playlist[2] = "Paper Boats";
        playlist[3] = "Slow River";
        System.out.println("Four songs added");
    }
}
```

**The program crashes with**

```text
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
	at Main.main(Main.java:7)
```

A list can't work like that: it has to take a new element whenever you call `add`. Two tricks make that possible.

## Room to spare, and a count

The first trick: make the array bigger than you need, and keep count of how many places are in use. Places 0 to count - 1 hold values, and the rest wait for more:

```java
String[] songs = new String[5];
int count = 0;

songs[count] = "Morning Rain";
count++;
songs[count] = "Night Train";
count++;

System.out.println(count + " songs, room for " + songs.length);
for (int i = 0; i < count; i++) {
    System.out.println(i + ": " + songs[i]);
}
```

**Output**

```text
2 songs, room for 5
0: Morning Rain
1: Night Train
```

- `songs[count] = ...;` followed by `count++;` puts a value in the first free place and moves the count on. The count is two things at once: the number of songs, and the index of the next free place.
- The loop stops at `count`, not at `songs.length`. Places 2 to 4 hold `null`, not songs.

So there are two different numbers to keep apart: how many places the array has (its length, 5), and how many of them are in use (the count, 2). The rest of the module depends on both.

## Making room: a bigger array

Spare room runs out too. When the array is full, the way out is a new, bigger array: create it, copy each value to the same index in the new one, and from then on use the new array:

```java
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] songs = {"Morning Rain", "Night Train", "Paper Boats"};
        System.out.println(Arrays.toString(songs));

        String[] bigger = new String[songs.length * 2];
        for (int i = 0; i < songs.length; i++) {
            bigger[i] = songs[i];
        }
        songs = bigger;

        songs[3] = "Slow River";
        System.out.println(Arrays.toString(songs));
    }
}
```

**Output**

```text
[Morning Rain, Night Train, Paper Boats]
[Morning Rain, Night Train, Paper Boats, Slow River, null, null]
```

- `songs = bigger;` makes the variable `songs` refer to the new array. Nothing refers to the old array of three any more, so the program can't reach it, and Java's garbage collector may free its memory (module 22).
- The new array is twice as long as the old one: room for three more songs before the next copy is needed.
- Java has a ready-made method that does the same: `Arrays.copyOf(songs, 6)` creates the new array and copies the values for you. This module writes the loop out, to show the work it does.

Copying takes one assignment per value: an array of a million values means a million assignments. Keep that in mind; the next step shows how a list keeps that cost down.

Room to spare, a count, and a bigger array when the room runs out: that's all a list needs. The next step puts the three into a class.

---

Source: [An array's size is fixed](https://javaarena.com/learn/list-and-map-internals/fixed-size/) in the module [Building your own list and hash map](https://javaarena.com/learn/list-and-map-internals/) on Java Arena.

This module follows section [12.2 ArrayList and hash table](https://java-programming.mooc.fi/part-12/2-arraylist-and-hashtable) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
