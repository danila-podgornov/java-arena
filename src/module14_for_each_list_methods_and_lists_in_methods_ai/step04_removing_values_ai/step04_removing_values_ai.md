> [!info] AI-Generated

# Removing values

`remove` takes a value out of a list. It comes in two kinds:

- `list.remove(index)` removes the value at that index.
- `list.remove(value)` removes the first copy of that value. If the value isn't in the list, nothing happens.

When a value is removed, the list gets one shorter, and every value after it moves down one place: its index goes down by 1.

```java
ArrayList<String> queue = new ArrayList<>();
queue.add("Ana");
queue.add("Ben");
queue.add("Cai");
queue.add("Dee");

queue.remove(0);
System.out.println(queue);
System.out.println("First now: " + queue.get(0));

queue.remove("Dee");
System.out.println(queue);
System.out.println("Size: " + queue.size());
```

**Output**

```text
[Ben, Cai, Dee]
First now: Ben
[Ben, Cai]
Size: 2
```

## The trap in number lists

In a list of numbers, `numbers.remove(3)` could mean "remove index 3" or "remove the value 3". Java always picks the index: an `int` in the parentheses is an index. To remove a value, give `remove` an `Integer`, with `Integer.valueOf`:

```java
ArrayList<Integer> numbers = new ArrayList<>();
numbers.add(8);
numbers.add(3);
numbers.add(5);
numbers.add(9);

numbers.remove(3);
System.out.println(numbers);

numbers.remove(Integer.valueOf(3));
System.out.println(numbers);
```

**Output**

```text
[8, 3, 5]
[8, 5]
```

`numbers.remove(3)` removed the value at index 3, the 9. `Integer.valueOf(3)` is the number 3 as an `Integer`, the type of the list's values, so the second call looks for the value 3. (You've used `Integer.valueOf` on typed text; given an `int`, it works too.) `contains` and `indexOf` have no index kind, so `numbers.contains(3)` always looks for the value.

## Don't remove inside a for-each

A for-each loop doesn't allow its list to grow or shrink while it runs. When it moves on to the next value, it notices that the size changed and stops the program:

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> readings = new ArrayList<>();
        readings.add(12);
        readings.add(-1);
        readings.add(15);
        readings.add(9);

        for (int reading : readings) {
            if (reading < 0) {
                readings.remove(Integer.valueOf(reading));
            }
        }
        System.out.println(readings);
    }
}
```

**The program crashes with**

```text
Exception in thread "main" java.util.ConcurrentModificationException
	at Main.main(Main.java:11)
```

Line 11 is the for-each line: "concurrent modification" means the list was changed while the loop was going through it. (Adding to the list inside the loop does the same. A removal in the second-to-last round goes unnoticed: the loop just ends early and never looks at the last value, which is no better.)

To remove values while going through a list, use an index loop that goes **backwards**:

```java
ArrayList<Integer> readings = new ArrayList<>();
readings.add(12);
readings.add(-1);
readings.add(-4);
readings.add(9);

for (int i = readings.size() - 1; i >= 0; i--) {
    if (readings.get(i) < 0) {
        readings.remove(i);
    }
}
System.out.println(readings);
```

**Output**

```text
[12, 9]
```

Going from the end, a removal only moves values you've already checked. Going forwards with `i++`, the value after a removed one would move into its place, and the loop would step right past it: here the -4 would be skipped.

---

Source: [Removing values](https://javaarena.com/learn/list-methods/removing-values/) in the module [For-each, list methods and lists in methods](https://javaarena.com/learn/list-methods/) on Java Arena.

This module follows section [3.2 Lists](https://java-programming.mooc.fi/part-3/2-lists) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
