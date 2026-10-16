> [!info] AI-Generated

# One list, two names

Module 10 showed that a method gets a copy of an `int` argument, so changing the parameter doesn't change the caller's variable. Lists behave differently, and here's why.

A list variable doesn't hold the list's values. It holds a **reference**: a note of where the list is in the computer's memory. `new ArrayList<>()` makes the list, and the variable remembers where it is. Copying the variable copies the note, not the list:

```java
ArrayList<String> mine = new ArrayList<>();
mine.add("tea");
ArrayList<String> yours = mine;
yours.add("coffee");
System.out.println(mine);
System.out.println(yours);
```

**Output**

```text
[tea, coffee]
[tea, coffee]
```

There's only one list here, with two names. Adding through `yours` changes the list `mine` refers to, because it's the same list.

## A method can change the caller's list

A list parameter works the same way. The method gets a copy of the reference, and it leads to the caller's own list. Whatever the method does to that list, the caller sees:

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> prices = new ArrayList<>();
        prices.add(10);
        prices.add(25);
        raiseAll(prices, 2);
        System.out.println(prices);
    }

    public static void raiseAll(ArrayList<Integer> list, int amount) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i) + amount);
        }
    }
}
```

**Output**

```text
[12, 27]
```

`list.set(index, value)` puts a new value at an index, in place of the old one. `raiseAll` returns nothing, and still `main`'s list changed. That's handy when changing the list is the method's job. When it isn't, it's a nasty surprise, so a method that only needs to read a list (like `groupPrice` in the last step) should leave it alone.

## A real copy

For a second, separate list, make a new list from the old one: `new ArrayList<>(original)` creates a new list with the same values in the same order.

```java
ArrayList<String> original = new ArrayList<>();
original.add("tea");
ArrayList<String> copy = new ArrayList<>(original);
copy.add("coffee");
System.out.println(original);
System.out.println(copy);
```

**Output**

```text
[tea]
[tea, coffee]
```

Now there are two lists, and changing one leaves the other as it was.

---

Source: [One list, two names](https://javaarena.com/learn/list-methods/same-list-two-names/) in the module [For-each, list methods and lists in methods](https://javaarena.com/learn/list-methods/) on Java Arena.

This module follows section [3.2 Lists](https://java-programming.mooc.fi/part-3/2-lists) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
