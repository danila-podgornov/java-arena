> [!info] AI-Generated

# A loop or a stream?

You now have two ways to go through a collection. Neither is the "right" one: both are everyday Java, and one program often uses both. This step compares them, so you can pick the one that reads better for each job.

## Where a stream reads well

A question of the form "from these values, keep some, change them, and count, add up or collect them" is what streams were made for. A bookshop's list has one entry for each copy sold. Which titles sold today, each once, in alphabetical order? With a loop:

```java
ArrayList<String> sold = new ArrayList<>();
sold.add("Kindred");
sold.add("Beloved");
sold.add("Kindred");
sold.add("Emma");
ArrayList<String> titles = new ArrayList<>();
for (String title : sold) {
    if (!titles.contains(title)) {
        titles.add(title);
    }
}
Collections.sort(titles);
System.out.println(titles);
```

**Output**

```text
[Beloved, Emma, Kindred]
```

With a stream, the same steps have names:

```java
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> sold = new ArrayList<>();
        sold.add("Kindred");
        sold.add("Beloved");
        sold.add("Kindred");
        sold.add("Emma");
        List<String> titles = sold.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(titles);
    }
}
```

**Output**

```text
[Beloved, Emma, Kindred]
```

The loop version needs a new list, a loop, an `if` and a sort, and the reader has to put them together to see the idea. The stream says the idea in its step names: distinct, sorted, collect.

## Where a loop reads well

- **Stopping early.** A loop can `return` or `break` as soon as it has its answer, such as the first day the shop sold more than 100 books. A `return` inside a lambda only ends that one call of the lambda, not the stream. (Java has stream operations that stop at the first match, such as `findFirst`, but this course doesn't use them, and a loop that stops says so plainly.)
- **Several results in one go.** One loop can update a count, a sum and a largest value at the same time. A lambda can't change the variables of its method (step 2), so with streams, each result is a stream of its own. For the lists in this course, going through a list three times is no problem: choose by what's easier to read.
- **Reading input.** A Scanner gives one line at a time, and a `while` loop reads them. Step 5's programs read with a loop and then answer with streams.
- **When the position matters.** Comparing each value with the one before it is natural in a loop with an index. `IntStream.range` can do it too, but the loop is often plainer.
- **Changing the list while going through it.** The stream steps of this module never change the list they read. To remove values while going through a list, use an index loop that goes backwards (module 14) or module 39's iterator. (Module 39 also shows `removeIf`, which does that loop for you.)

Here's a question of the "stopping early" kind: was there a day when the shop sold no books at all? As soon as the loop finds one such day, the answer is known, and the method returns it without looking at the rest:

```java
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> booksSold = new ArrayList<>();
        booksSold.add(64);
        booksSold.add(0);
        booksSold.add(89);
        booksSold.add(130);
        System.out.println(hadEmptyDay(booksSold));
    }

    public static boolean hadEmptyDay(List<Integer> booksSold) {
        for (int sold : booksSold) {
            if (sold == 0) {
                return true;
            }
        }
        return false;
    }
}
```

**Output**

```text
true
```

`filter(sold -> sold == 0).count() > 0` gives the same answer, but it counts every empty day to answer a yes-or-no question, and the reader has to work out why it compares with 0.

## A rule of thumb

- If you can say the question as "keep these, turn them into that, then count, add up or collect", try a stream.
- If you need to stop early, remember something from the round before, or change several variables as you go, a loop is usually plainer.
- If a lambda grows to many lines, the code is telling you something: move that work into a method of its own, and call it from the lambda (or with a method reference), or write a loop.

---

Source: [A loop or a stream?](https://javaarena.com/learn/streams/loop-or-stream/) in the module [Streams and lambdas](https://javaarena.com/learn/streams/) on Java Arena.

This module follows section [10.1 Handling collections as streams](https://java-programming.mooc.fi/part-10/1-handling-collections-as-streams) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
