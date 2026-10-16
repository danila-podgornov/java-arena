> [!info] AI-Generated

# Stacks and queues on linked nodes

Many programs don't need a list's `get(index)` at all. They only add and remove at the ends, and two ways of doing that have names of their own.

## A stack: last in, first out

A **stack** adds and removes at one end only, its **top**, like a pile of plates: the plate you put on last is the first you take off. Its operations are usually called `push` (put on top), `pop` (take the top one off and return it), `peek` (look at the top one without taking it) and `isEmpty`. The call stack (module 11, and module 55's recursion) is one: the newest call is on top, and it's the first to finish.

On linked nodes the top is the head: `push` is `addFirst`, and `pop` is `removeFirst`. Both take a few steps whatever the size. This stack of whole numbers gives back 1, 2, 3 and 4 in the opposite order:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        NumberStack stack = new NumberStack();
        for (int digit = 1; digit <= 4; digit++) {
            stack.push(digit);
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }
}
```

**NumberStack.java**

```java
public class NumberStack {
    private NumberNode top;

    public void push(int value) {
        this.top = new NumberNode(value, this.top);
    }

    public int pop() {
        int value = this.top.value;
        this.top = this.top.next;
        return value;
    }

    public boolean isEmpty() {
        return this.top == null;
    }
}
```

**NumberNode.java**

```java
public class NumberNode {
    int value;
    NumberNode next;

    public NumberNode(int value, NumberNode next) {
        this.value = value;
        this.next = next;
    }
}
```

**Output**

```text
4 3 2 1
```

NumberStack has no constructor of its own, so Java gives it a default constructor that takes no parameters, and `top` starts as `null`, the default value of a reference variable. This `pop` crashes on an empty stack with a NullPointerException; a better one checks first and throws an exception with a clear message.

## A queue: first in, first out

A **queue** adds at one end, its back, and removes at the other, its front, like a line at a counter: whoever came first is served first. Its operations are often called `enqueue` (join at the back) and `dequeue` (leave from the front).

On linked nodes, the front is the head and the back is the tail, with the links pointing from front to back:

```text
head                                   tail
[report.pdf] --> [map.png] --> [menu.txt] --> null
```

- `enqueue` is step 2's `addLast`: link the new node after `tail`, and move `tail` to it.
- `dequeue` is `removeFirst`: take the head's value, and move `head` to `head.next`. When the queue becomes empty, set `tail` to `null` as well.

Why not the other way round, adding at the head and removing at the tail? To remove the last node, a list must set the `next` of the node before it to `null`, and the only way to find that node is to walk from the head. With the links pointing front to back, both operations take a few steps.

## Checking brackets with a stack

Brackets in a formula must close in the opposite order to the one they opened in: `([])` is fine, `([)]` isn't. A stack checks this. Go through the characters one by one:

- an opening bracket, `(`, `[` or `{`, is pushed;
- a closing bracket must match the opening bracket on top of the stack, which is popped. If the stack is empty, or the top is the wrong kind, the brackets aren't balanced;
- other characters are skipped.

At the end, the stack must be empty: anything left on it was never closed.

---

Source: [Stacks and queues on linked nodes](https://javaarena.com/learn/linked-structures/stacks-and-queues/) in the module [Linked lists, stacks, queues and trees](https://javaarena.com/learn/linked-structures/) on Java Arena.

An extra module, not part of the University of Helsinki's course. Lesson text: [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/).
