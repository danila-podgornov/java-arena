> [!info] AI-Generated

# The list toolbox

Here are the list methods from this module and the last one. Three of them are new: `add(index, value)`, `isEmpty()` and `clear()`.

| Method | What it does |
|---|---|
| `add(value)` | Adds the value to the end of the list. |
| `add(index, value)` | Puts the value at the index. The values from there on move up one place. |
| `get(index)` | Gives the value at the index. |
| `set(index, value)` | Replaces the value at the index. |
| `size()` | Gives the number of values. |
| `remove(index)` | Removes the value at the index. Later values move down one place. |
| `remove(value)` | Removes the first copy of the value, if there is one. For numbers: `remove(Integer.valueOf(n))`. |
| `contains(value)` | `true` when the value is in the list. |
| `indexOf(value)` | The index of the first copy of the value, or -1. |
| `isEmpty()` | `true` when the list has no values. |
| `clear()` | Removes every value. |

The methods that take an index crash with an `IndexOutOfBoundsException` when there's no such index. `add(index, value)` also accepts `size()` as the index, which adds to the end.

The three new ones at work:

```java
ArrayList<String> line = new ArrayList<>();
System.out.println(line.isEmpty());
line.add("Bea");
line.add("Carl");
line.add(0, "Abe");
line.add(2, "Bill");
System.out.println(line);
line.clear();
System.out.println(line.isEmpty());
System.out.println(line.size());
```

**Output**

```text
true
[Abe, Bea, Bill, Carl]
true
0
```

`isEmpty()` says the same as `size() == 0`, but reads more like what you mean.

## A program driven by commands

Many programs are a loop that reads a command, does what it says, and goes round again until the user quits. A list makes a good memory for such a program: the last challenge of this module is a shopping list you run by typing commands.

That's the end of the MOOC's section on lists. Next come arrays: another way to keep many values, with a size that's fixed when the array is made.

---

Source: [The list toolbox](https://javaarena.com/learn/list-methods/list-toolbox/) in the module [For-each, list methods and lists in methods](https://javaarena.com/learn/list-methods/) on Java Arena.

This module follows section [3.2 Lists](https://java-programming.mooc.fi/part-3/2-lists) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
