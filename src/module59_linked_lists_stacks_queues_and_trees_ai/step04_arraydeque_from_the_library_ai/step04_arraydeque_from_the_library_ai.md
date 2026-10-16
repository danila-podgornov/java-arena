> [!info] AI-Generated

# ArrayDeque from the library

Java has a ready-made class for stacks and queues: `ArrayDeque`, in `java.util`. A **deque** (said "deck", short for double-ended queue) can add and remove at both of its ends, so it can be a stack or a queue. Unlike the classes this module has built so far, an ArrayDeque keeps its values in an array, not in nodes: an array that it replaces with a bigger one when it's full, like an ArrayList. Unlike an ArrayList, it doesn't shift the other values along when you add or remove at the front. Java's documentation says that most of its operations run in amortized constant time: the same few steps whatever the size, apart from the occasional copy into a bigger array.

## As a stack

`push`, `pop` and `peek` work at the front of the deque, which is the stack's top. A painter puts coats of paint on a wall; the last coat is the one you see:

```java
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) {
        ArrayDeque<String> coats = new ArrayDeque<>();
        coats.push("primer");
        coats.push("white");
        coats.push("sea blue");
        System.out.println(coats);
        System.out.println("Scraped off: " + coats.pop());
        System.out.println("Now showing: " + coats.peek());
        System.out.println(coats + ", " + coats.size() + " coats");
    }
}
```

**Output**

```text
[sea blue, white, primer]
Scraped off: sea blue
Now showing: white
[white, primer], 2 coats
```

Printing a deque, or going through it with a for-each loop, goes from the front to the back. For a stack, that's top first.

Java also has an old class called `Stack`. Its own documentation recommends using a Deque such as ArrayDeque in preference to it.

## As a queue

`offer` adds at the back, and `poll` removes from the front and returns what it removed. `peek` looks at the front. A juice bar makes the drinks in the order they were ordered:

```java
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) {
        ArrayDeque<String> orders = new ArrayDeque<>();
        orders.offer("orange");
        orders.offer("mango");
        orders.offer("beet and apple");
        System.out.println("Making " + orders.poll());
        System.out.println("Next up: " + orders.peek());
        System.out.println("Waiting: " + orders);
        orders.poll();
        orders.poll();
        System.out.println(orders.poll());
        System.out.println(orders.isEmpty());
    }
}
```

**Output**

```text
Making orange
Next up: mango
Waiting: [mango, beet and apple]
null
true
```

On an empty deque, `poll` and `peek` return `null`, while `pop` throws a NoSuchElementException. An ArrayDeque doesn't accept `null` as a value (adding one throws a NullPointerException), so a `null` from `poll` always means that the deque was empty.

## Both ends

Each end has its own methods too: `addFirst` and `addLast`, `offerFirst` and `offerLast`, `removeFirst` and `removeLast`, `peekFirst` and `peekLast`, `pollFirst` and `pollLast`. `push` is the same as `addFirst`, `pop` as `removeFirst`, `offer` as `offerLast` and `poll` as `pollFirst`. A deque used as a stack at its back end (`addLast` and `removeLast`) keeps its values in the order they were added, which is handy when you print them. `clear()` empties a deque.

The variable can have the interface's type, as with `List` and ArrayList: `Deque<String> coats = new ArrayDeque<>();` (with `import java.util.Deque;`). With `var` (module 57), `var coats = new ArrayDeque<String>();` works too.

---

Source: [ArrayDeque from the library](https://javaarena.com/learn/linked-structures/array-deque/) in the module [Linked lists, stacks, queues and trees](https://javaarena.com/learn/linked-structures/) on Java Arena.

An extra module, not part of the University of Helsinki's course. Lesson text: [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/).
