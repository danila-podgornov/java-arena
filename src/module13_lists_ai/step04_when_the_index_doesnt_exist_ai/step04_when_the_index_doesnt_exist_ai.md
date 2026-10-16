> [!info] AI-Generated

# When the index doesn't exist

A list with three values has the indexes 0, 1 and 2, and no others. Asking for any other index stops the program with an error:

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> chores = new ArrayList<>();
        chores.add("do the dishes");
        chores.add("water the plants");
        chores.add("take out the trash");
        System.out.println(chores.get(0));
        System.out.println(chores.get(3));
        System.out.println("All done");
    }
}
```

**Output**

```text
do the dishes
```

**The program crashes with**

```text
Exception in thread "main" java.lang.IndexOutOfBoundsException: Index 3 out of bounds for length 3
	at Main.main(Main.java:10)
```

The program compiled without a complaint: javac can't know how many values a list will hold when the program runs. The error comes while it runs, as an **exception**, and the program stops on the spot. That's why `All done` is never printed. Java's message says what went wrong and where:

- `IndexOutOfBoundsException` is the kind of error: an index outside the list.
- `Index 3 out of bounds for length 3` gives the index that was asked for, and how many values the list had.
- `at Main.main(Main.java:10)` is where it happened: line 10, in the method `main`.

In a real run, Java also prints a few `at` lines from inside its own classes, where the index was checked. The one to look for is the `at Main` line: that's your code.

A negative index crashes the same way (`Index -1 out of bounds for length 3`), and so does every index on an empty list (`Index 0 out of bounds for length 0`).

## Avoiding it

The largest index is always one less than the number of values. A common cause of this crash is counting from 1, as people do, instead of from 0: `get(3)` for the third value, or a loop that runs one round too far. When the index in the message equals the length, as in `Index 3 out of bounds for length 3`, look for exactly that mistake.

The next step shows how to ask a list how many values it holds, so a program can check an index before it uses it.

---

Source: [When the index doesn't exist](https://javaarena.com/learn/lists/index-out-of-bounds/) in the module [Lists](https://javaarena.com/learn/lists/) on Java Arena.

This module follows section [3.2 Lists](https://java-programming.mooc.fi/part-3/2-lists) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
