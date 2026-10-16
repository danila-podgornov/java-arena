> [!info] AI-Generated

# Looping over a list

To go through every value in a list, loop over the indexes, from 0 to the last one. With a `while` loop:

```java
ArrayList<String> chores = new ArrayList<>();
chores.add("sweep");
chores.add("dust");
chores.add("mop");

int index = 0;
while (index < chores.size()) {
    System.out.println(chores.get(index));
    index++;
}
```

**Output**

```text
sweep
dust
mop
```

A `for` loop does the same with the counter in one line, and it's the usual way to write it:

```java
ArrayList<String> chores = new ArrayList<>();
chores.add("sweep");
chores.add("dust");
chores.add("mop");

for (int i = 0; i < chores.size(); i++) {
    System.out.println((i + 1) + ". " + chores.get(i));
}
```

**Output**

```text
1. sweep
2. dust
3. mop
```

- The condition is `i < chores.size()`, with `<`, because the last index is `size() - 1`. With `<=`, the loop would ask for one index too many and crash.
- With `size()` instead of a fixed number, the loop works for a list of any length. For an empty list it doesn't run at all.
- `i` is the index, so `chores.get(i)` is this round's value, and `i + 1` its place as people count it.

## Other ranges

The loop's three parts can pick any part of the list. Starting at 1 skips the first value, `i += 2` takes every second one, and starting at the last index and counting down goes through the list backwards:

```java
ArrayList<Integer> numbers = new ArrayList<>();
numbers.add(10);
numbers.add(20);
numbers.add(30);
numbers.add(40);
numbers.add(50);

for (int i = 1; i < numbers.size(); i += 2) {
    System.out.print(numbers.get(i) + " ");
}
System.out.println();

for (int i = numbers.size() - 1; i >= 0; i--) {
    System.out.print(numbers.get(i) + " ");
}
System.out.println();
```

**Output**

```text
20 40
50 40 30 20 10
```

Going backwards, the loop starts at `size() - 1`, the last index, and runs as long as `i >= 0`, so index 0 is included.

The next module shows the for-each loop: a shorter way to visit every value, for when you don't need the index.

---

Source: [Looping over a list](https://javaarena.com/learn/lists/looping-over-a-list/) in the module [Lists](https://javaarena.com/learn/lists/) on Java Arena.

This module follows section [3.2 Lists](https://java-programming.mooc.fi/part-3/2-lists) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
