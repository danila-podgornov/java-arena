> [!info] AI-Generated

# contains and indexOf

The last module searched a list with a loop. Two list methods do that searching for you:

- `list.contains(value)` is `true` when the value is in the list, and `false` when it isn't.
- `list.indexOf(value)` gives the index of the value, or `-1` when it isn't in the list. If the value is there more than once, you get the first index.

```java
ArrayList<String> colors = new ArrayList<>();
colors.add("red");
colors.add("green");
colors.add("blue");
colors.add("green");

System.out.println(colors.contains("blue"));
System.out.println(colors.contains("pink"));
System.out.println(colors.indexOf("green"));
System.out.println(colors.indexOf("pink"));
```

**Output**

```text
true
false
1
-1
```

Both compare with `equals`, the way you compare Strings yourself, so they also find text the user typed in. The comparison is exact: `"Green"` with a capital G is not in this list.

They work on number lists too: `numbers.contains(7)` and `numbers.indexOf(7)` look for the value 7.

## Searching in an if

`contains` gives a `boolean`, so the call can be the condition of an `if`. With `indexOf`, check for -1 before you use the index:

```java
ArrayList<String> queue = new ArrayList<>();
queue.add("Ines");
queue.add("Tomas");
queue.add("Yuki");

if (queue.contains("Tomas")) {
    System.out.println("Tomas is in the queue");
}

String name = "Yuki";
int index = queue.indexOf(name);
if (index == -1) {
    System.out.println(name + " is not in the queue");
} else {
    System.out.println(name + " has " + index + " people ahead");
}
```

**Output**

```text
Tomas is in the queue
Yuki has 2 people ahead
```

Yuki is at index 2, and the index is exactly the number of people before her.

---

Source: [contains and indexOf](https://javaarena.com/learn/list-methods/contains-and-index-of/) in the module [For-each, list methods and lists in methods](https://javaarena.com/learn/list-methods/) on Java Arena.

This module follows section [3.2 Lists](https://java-programming.mooc.fi/part-3/2-lists) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
