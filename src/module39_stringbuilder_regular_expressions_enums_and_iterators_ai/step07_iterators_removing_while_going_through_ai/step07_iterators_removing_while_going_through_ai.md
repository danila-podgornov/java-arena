> [!info] AI-Generated

# Iterators: removing while going through

Module 14 showed that removing from a list inside a for-each loop stops the program. Here it is once more, with a to-do list that should lose its finished tasks:

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> tasks = new ArrayList<>();
        tasks.add("buy stamps");
        tasks.add("DONE call the dentist");
        tasks.add("water the plants");
        tasks.add("DONE pay the rent");
        for (String task : tasks) {
            if (task.startsWith("DONE")) {
                tasks.remove(task);
            }
        }
        System.out.println(tasks);
    }
}
```

**The program crashes with**

```text
Exception in thread "main" java.util.ConcurrentModificationException
	at Main.main(Main.java:10)
```

Module 14's fix was an index loop that goes backwards. That works for a list, which has indexes. An **iterator** is Java's general tool for going through a collection one element at a time, and it can remove the element it's on:

```java
import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> tasks = new ArrayList<>();
        tasks.add("buy stamps");
        tasks.add("DONE call the dentist");
        tasks.add("water the plants");
        tasks.add("DONE pay the rent");

        Iterator<String> iterator = tasks.iterator();
        while (iterator.hasNext()) {
            String task = iterator.next();
            if (task.startsWith("DONE")) {
                iterator.remove();
            }
        }
        System.out.println(tasks);
    }
}
```

**Output**

```text
[buy stamps, water the plants]
```

- `tasks.iterator()` returns an `Iterator<String>`, which starts in front of the first element. Iterator is in `java.util`, so it needs `import java.util.Iterator;`.
- `hasNext()` returns `true` while there are elements left.
- `next()` moves on to the next element and returns it.
- `remove()` removes the element that `next()` returned last, from the list itself. The iterator knows about the removal, so it carries on correctly with the next element.

## The rules

- Call `next()` once in each round, after `hasNext()` has said there's an element. A second `next()` in the same round skips an element, and past the end, `next()` stops the program with a NoSuchElementException.
- Call `remove()` at most once after each `next()`. Before the first `next()`, or twice in a row, it stops the program with an IllegalStateException.
- Don't change the collection in any other way while the iterator goes through it: only through the iterator's own `remove()`.

## Why a for-each loop can't remove

A for-each loop uses an iterator too, one that you don't see. `tasks.remove(task)` removes behind that iterator's back: the list changes, but the loop's iterator isn't told. When the loop asks it for the next element, the iterator notices that the list has changed and stops the program with a ConcurrentModificationException ("concurrent" means at the same time: the list changed while it was being gone through). With the iterator in a variable of your own, you remove through it, and it keeps track.

## Collections without indexes

Every collection has `iterator()`: lists, sets, and a map's `keySet()` and `values()`. A set has no indexes, so module 14's backwards loop can't go through one, but an iterator can:

```java
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> coupons = new HashSet<>();
        coupons.add("SPRING-10");
        coupons.add("WINTER-15");
        coupons.add("SPRING-20");
        coupons.add("SUMMER-5");

        Iterator<String> iterator = coupons.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().startsWith("SPRING")) {
                iterator.remove();
            }
        }
        System.out.println(coupons.size() + " " + coupons.contains("SPRING-10") + " " + coupons.contains("SUMMER-5"));
    }
}
```

**Output**

```text
2 false true
```

Here `next()` is called right in the `if`'s condition. That's fine: it's still called once in each round.

Lists and sets also have `removeIf`, which takes a lambda, like module 37's `filter`: `tasks.removeIf(task -> task.startsWith("DONE"));` removes every finished task in one line. An iterator is the tool when the loop does more than remove, for example counts what it removes, adds up the removed values, or stops at the first match.

---

Source: [Iterators: removing while going through](https://javaarena.com/learn/useful-techniques/iterators/) in the module [StringBuilder, regular expressions, enums and iterators](https://javaarena.com/learn/useful-techniques/) on Java Arena.

This module follows sections [10.3 Other useful techniques](https://java-programming.mooc.fi/part-10/3-other-useful-techniques), [10.4 Summary](https://java-programming.mooc.fi/part-10/4-summary) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
