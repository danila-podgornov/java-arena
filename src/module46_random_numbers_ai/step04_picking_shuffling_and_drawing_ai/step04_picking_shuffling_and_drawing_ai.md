> [!info] AI-Generated

# Picking, shuffling and drawing

Random numbers often choose among things: an exercise from a list, the order of a quiz's questions, who goes first.

## A random element

`nextInt(size)` gives a number from 0 to size - 1: exactly the indexes of a list of that size. So `list.get(random.nextInt(list.size()))` is a random element, each one as likely as the others. A workout app picks the exercise of the day this way:

```java
import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> exercises = new ArrayList<>();
        exercises.add("squats");
        exercises.add("push-ups");
        exercises.add("plank");
        exercises.add("lunges");
        Random random = new Random(8);
        for (int day = 1; day <= 4; day++) {
            String exercise = exercises.get(random.nextInt(exercises.size()));
            System.out.println("Day " + day + ": " + exercise);
        }
    }
}
```

**Output**

```text
Day 1: plank
Day 2: lunges
Day 3: plank
Day 4: squats
```

- With `exercises.size()` as the bound, the code stays right when the list changes: add a fifth exercise, and it can come up too.
- The same exercise can come up on several days. Each pick is a new draw that knows nothing about the earlier ones. Drawing without repeats comes later in this step.
- An array works the same way: `array[random.nextInt(array.length)]`.

An empty list has no element to pick, and `nextInt(0)` has no number to give: the bound must be positive, or `nextInt` throws an exception.

```java
import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> exercises = new ArrayList<>();
        Random random = new Random();
        String exercise = exercises.get(random.nextInt(exercises.size()));
        System.out.println("Today: " + exercise);
    }
}
```

**The program crashes with**

```text
Exception in thread "main" java.lang.IllegalArgumentException: bound must be positive
	at Main.main(Main.java:8)
```

When a list might be empty, check `isEmpty()` before you pick.

## Shuffling

`Collections.shuffle(list)` puts a list's elements in a random order, like shuffling a deck of cards. Give it a Random too, `Collections.shuffle(list, random)`, and it uses that one, so a seed gives the same order every time. A quiz app asks its questions in a new order every round:

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> questions = new ArrayList<>();
        questions.add("How many sides does a hexagon have?");
        questions.add("Which metal is liquid at room temperature?");
        questions.add("What is the capital of Canada?");
        questions.add("Which gas do plants take in?");
        Collections.shuffle(questions, new Random(3));
        for (int i = 0; i < questions.size(); i++) {
            System.out.println((i + 1) + ". " + questions.get(i));
        }
    }
}
```

**Output**

```text
1. Which metal is liquid at room temperature?
2. How many sides does a hexagon have?
3. Which gas do plants take in?
4. What is the capital of Canada?
```

- `shuffle` changes the list itself and returns nothing. Every element is still there, once; only the order is new.
- Every possible order has about the same chance of coming up.
- To keep the original order as well, shuffle a copy: `new ArrayList<>(questions)` makes one (module 14).
- `Collections` is in `java.util`, like Random. Module 28 used its `sort`.

## Drawing without repeats

Picking with `nextInt` can pick the same element twice. When each element may come up only once, like names drawn out of a hat, there are two easy ways.

**Shuffle, and take from the front.** To pick three different exercises for today, shuffle a copy of the list and take its first three elements.

**Remove what you draw.** Pick a random index, and remove the element there. `list.remove(index)` returns the element it removed, so one line does both. What's drawn is no longer in the list, so it can't come up again, and the next bound, `list.size()`, is one smaller. A class decides the order of its presentations by drawing names:

```java
import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> hat = new ArrayList<>();
        hat.add("Ines");
        hat.add("Tomasz");
        hat.add("Priya");
        hat.add("Kofi");
        Random random = new Random(21);
        int turn = 1;
        while (!hat.isEmpty()) {
            String name = hat.remove(random.nextInt(hat.size()));
            System.out.println(turn + ". " + name);
            turn++;
        }
    }
}
```

**Output**

```text
1. Priya
2. Ines
3. Tomasz
4. Kofi
```

A third way is to keep drawing, and throw away whatever was drawn before, checking with `contains`. It works too, but when most of the elements have been drawn, most of the draws are thrown away.

---

Source: [Picking, shuffling and drawing](https://javaarena.com/learn/randomness/picking-and-shuffling/) in the module [Random numbers](https://javaarena.com/learn/randomness/) on Java Arena.

This module follows section [12.3 Randomness](https://java-programming.mooc.fi/part-12/3-randomness) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
