> [!info] AI-Generated

# The for loop again

Since module 14, you've gone through lists mostly with for-each loops, and module 37 added streams. Both hand you the values one at a time, which is often all a loop needs. The traditional `for` loop from module 9 is still the tool when the loop needs numbers of its own: counting down, jumping ahead by more than one, or knowing *where* each value is. The MOOC's section 10.3 names it first among its learning goals, so this module starts with it, as a recap.

## Three parts, any numbers

`for (start; condition; change)`: the start runs once, the condition is checked before every round, and the change runs at the end of every round. Nothing says that the change must be `i++`. The last seconds of a quiz round count down:

```java
for (int seconds = 5; seconds >= 1; seconds--) {
    System.out.println(seconds + "...");
}
System.out.println("Time's up!");
```

**Output**

```text
5...
4...
3...
2...
1...
Time's up!
```

Counting down, the condition turns around too: the loop goes on while `seconds >= 1`. Written as `seconds <= 1`, the condition would be false before the first round (5 isn't at most 1), and the loop would never run, without any error message.

To jump by more than one, write the change with `+=` or `-=`. Between 2024 and 2040, every fourth year is a leap year:

```java
for (int year = 2024; year <= 2040; year += 4) {
    System.out.println(year + " is a leap year");
}
```

**Output**

```text
2024 is a leap year
2028 is a leap year
2032 is a leap year
2036 is a leap year
2040 is a leap year
```

## Loops over indexes

A for-each loop gives you each value, but not its position. When the position matters, loop over the indexes instead, from 0 up to `size() - 1` for a list (`length - 1` for an array). You need the indexes:

- to compare a value with the one before it or after it
- to go through two lists side by side, with the same index in both
- to go through a list backwards, or to take only every second value

A school garden measures its sunflower every Monday. The growth in a week is a height minus the height of the week before:

```java
ArrayList<Integer> heights = new ArrayList<>();
heights.add(12);
heights.add(19);
heights.add(31);
heights.add(30);
heights.add(45);
for (int i = 1; i < heights.size(); i++) {
    int growth = heights.get(i) - heights.get(i - 1);
    System.out.println("Week " + i + ": " + growth + " cm");
}
```

**Output**

```text
Week 1: 7 cm
Week 2: 12 cm
Week 3: -1 cm
Week 4: 15 cm
```

- The loop starts from index 1, since the first height has no week before it. Starting from 0, the first round would ask for `heights.get(-1)`, and the program would stop with an IndexOutOfBoundsException.
- `i < heights.size()` makes the last round the last index, 4.
- `i` is also the week's number, which a for-each loop wouldn't know.

Module 14's way of removing values from a list, a loop that goes backwards with `for (int i = list.size() - 1; i >= 0; i--)`, is an index loop too. Step 7 shows another way to remove, the iterator.

| The loop needs | Use |
| --- | --- |
| each value, from the first to the last | a for-each loop (or a stream) |
| numbers that count down, or go up in steps | `for` with `--`, `+=` or `-=` |
| positions: neighbors, two lists at once, going backwards | `for` over the indexes |

---

Source: [The for loop again](https://javaarena.com/learn/useful-techniques/for-loop-again/) in the module [StringBuilder, regular expressions, enums and iterators](https://javaarena.com/learn/useful-techniques/) on Java Arena.

This module follows sections [10.3 Other useful techniques](https://java-programming.mooc.fi/part-10/3-other-useful-techniques), [10.4 Summary](https://java-programming.mooc.fi/part-10/4-summary) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
