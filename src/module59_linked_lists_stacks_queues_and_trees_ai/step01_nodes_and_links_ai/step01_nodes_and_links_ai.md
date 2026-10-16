> [!info] AI-Generated

# Nodes and links

This module is an extra: the MOOC doesn't cover it. It's about data structures built from small objects that refer to each other: linked lists, stacks, queues and trees. They're worth knowing for three reasons. Java's own collections use them (LinkedList is a chain of such objects, and TreeMap and TreeSet keep their values in a tree). They explain why some operations of a collection take the same few steps however big it is, while others go through every value. And they come up in programming interviews. The module uses recursion (module 55) and `var` (module 57).

## A node

Module 45 built a list on an array: the values sit side by side, and `get(7)` goes straight to place 7 of the array. A **linked list** keeps each value in an object of its own, a **node**, and each node holds a reference to the next node.

A scavenger hunt works the same way. Each clue is at a place, is worth some points, and tells you where the next clue is. Here's a class for one clue:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Clue first = new Clue("the mailbox", 10);
        Clue second = new Clue("the old oak", 20);
        Clue third = new Clue("the bike shed", 30);
        first.next = second;
        second.next = third;

        System.out.println(first.place);
        System.out.println(first.next.place);
        System.out.println(first.next.next.place);
        System.out.println(third.next);
    }
}
```

**Clue.java**

```java
public class Clue {
    String place;
    int points;
    Clue next;

    public Clue(String place, int points) {
        this.place = place;
        this.points = points;
        this.next = null;
    }
}
```

**Output**

```text
the mailbox
the old oak
the bike shed
null
```

- The instance variable `next` has the type `Clue`, the class's own type. A Clue doesn't hold another Clue inside it: `next` holds a reference to one (module 22), or `null` when there's no next clue.
- `first.next.place` follows one link: `first.next` is the second clue, and `.place` is its place. `first.next.next.place` follows two.
- The variables of Clue have no access modifier, so they're package-private (module 41): Main, in the same package, reads and sets them directly. Clue is a small helper whose only job is to hold a value and a link. Step 2 hides nodes like it inside a list class, where nothing else can reach them.

The three clues and their links look like this, with an arrow for each reference:

```text
first             second            third
[the mailbox] --> [the old oak] --> [the bike shed] --> null
```

## Walking along the chain

To go through the hunt, a variable `current` starts at the first clue and moves on with `current = current.next`, until it's `null`:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Clue first = new Clue("the mailbox", 10);
        first.next = new Clue("the old oak", 20);
        first.next.next = new Clue("the bike shed", 30);

        int total = 0;
        Clue current = first;
        while (current != null) {
            total += current.points;
            current = current.next;
        }
        System.out.println("The hunt is worth " + total + " points");
        System.out.println("It starts at " + first.place);
    }
}
```

**Clue.java**

```java
public class Clue {
    String place;
    int points;
    Clue next;

    public Clue(String place, int points) {
        this.place = place;
        this.points = points;
        this.next = null;
    }
}
```

**Output**

```text
The hunt is worth 60 points
It starts at the mailbox
```

`current` is only a reference that moves along the chain. Moving it changes no link, so `first` still refers to the first clue after the loop. The loop stops after the last clue, whose `next` is `null`.

## One step too far

A hunt with no clues at all has no first clue: the variable for it is `null`. This method looks for the place of the last clue, and works for a hunt of one clue, but not for an empty one:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Clue gate = new Clue("the gate", 5);
        System.out.println(lastPlace(gate));
        System.out.println(lastPlace(null));
    }

    public static String lastPlace(Clue first) {
        Clue current = first;
        while (current.next != null) {
            current = current.next;
        }
        return current.place;
    }
}
```

**Clue.java**

```java
public class Clue {
    String place;
    int points;
    Clue next;

    public Clue(String place, int points) {
        this.place = place;
        this.points = points;
        this.next = null;
    }
}
```

**Output**

```text
the gate
```

**The program crashes with**

```text
Exception in thread "main" java.lang.NullPointerException: Cannot read field "next" because "<local1>" is null
	at Main.lastPlace(Main.java:10)
	at Main.main(Main.java:5)
```

The second call gets `null`, so `current` is `null`, and `current.next` asks a missing object for its `next`. Java's message names the field it tried to read, and the variable that was `null`. Java numbers a method's parameters and variables from 0, here `first` 0 and `current` 1, and when a class is compiled without their names kept, as here, the message gives the number: `<local1>` is `current`. The fix is a check before the loop: `if (first == null) { return "no clues"; }`.

Every loop over nodes has two edges to think about: an empty chain, where the first reference is already `null`, and the last node, whose `next` is `null`.

---

Source: [Nodes and links](https://javaarena.com/learn/linked-structures/nodes-and-links/) in the module [Linked lists, stacks, queues and trees](https://javaarena.com/learn/linked-structures/) on Java Arena.

An extra module, not part of the University of Helsinki's course. Lesson text: [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/).
