> [!info] AI-Generated

# A method that calls itself

This module is an extra: the MOOC doesn't cover it. Recursion means solving a problem by solving a smaller copy of the same problem first. It's worth knowing because a lot of data is built from smaller copies of itself: folders inside folders, the two halves of a sorted array, the branches of a tree. Code for such data is often shortest and clearest when it's recursive, and recursive code turns up in other people's programs and in library code.

## A method can call itself

Since module 10, methods have called other methods. A method can also call itself. A set of nesting dolls is a doll with a smaller set of dolls inside it, so opening the whole set is: open this doll, then open the smaller set the same way.

```java
public class Main {
    public static void main(String[] args) {
        openDolls(3);
        System.out.println("All open");
    }

    public static void openDolls(int size) {
        if (size == 0) {
            return;
        }
        System.out.println("Opening the doll of size " + size);
        openDolls(size - 1);
    }
}
```

**Output**

```text
Opening the doll of size 3
Opening the doll of size 2
Opening the doll of size 1
All open
```

`openDolls(3)` prints its line and calls `openDolls(2)`, which prints its line and calls `openDolls(1)`, and so on. A method that calls itself is **recursive**, and the call is a **recursive call**. Two parts make it work:

- The **base case**: an input so small that the method answers it without calling itself. Here that's `size == 0`: no doll left, so the method just returns.
- The **recursive case**: everything else. The method does its own small part of the work and calls itself on a smaller input, `size - 1`, which brings it one step closer to the base case.

Without the base case, the calls would never end. Step 4 shows what happens then.

## Every call has its own variables

Each call of a method gets its own parameters and variables, so `openDolls(3)`, `openDolls(2)` and `openDolls(1)` each have a `size` of their own, and none of them changes another one's. While `openDolls(1)` runs, the calls for 3 and 2 aren't finished: each waits at its recursive call, to go on after it once that call returns. Java keeps the unfinished calls on the call stack (module 11), the newest on top. It's the same list of calls that a crash report prints, one `at` line per call. Here is the run, with each call indented under the one that made it:

```text
main calls openDolls(3)
    openDolls(3) prints its line, calls openDolls(2)
        openDolls(2) prints its line, calls openDolls(1)
            openDolls(1) prints its line, calls openDolls(0)
                openDolls(0) returns at once (the base case)
            openDolls(1) has nothing left to do, returns
        openDolls(2) returns
    openDolls(3) returns
main prints "All open"
```

## Recursion and loops

This method could just as well be a `while` loop that counts `size` down. A loop is simpler here, and it doesn't keep a call per round on the call stack. Recursion pays off when a problem splits into smaller problems of the same kind, as in steps 5 and 6. The first steps use small problems, so that you can follow every call.

---

Source: [A method that calls itself](https://javaarena.com/learn/recursion/calling-itself/) in the module [Recursion](https://javaarena.com/learn/recursion/) on Java Arena.

An extra module, not part of the University of Helsinki's course. Lesson text: [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/).
