> [!info] AI-Generated

# Seeds: the same numbers every time

Random numbers make a program hard to test. If the output changes on every run, what should a test expect? It turns out that a Random's numbers aren't as unpredictable as they look.

## A seed

Give `new Random` a whole number, and it hands out the same numbers on every run:

```java
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random(42);
        for (int i = 0; i < 5; i++) {
            System.out.println(random.nextInt(10));
        }
    }
}
```

**Output**

```text
0
3
8
4
0
```

Run it as often as you like: it prints these five numbers every time, on any computer. The 42 is the generator's **seed**.

A Random doesn't roll anything. It works out its numbers one after the other with a fixed formula, starting from its seed. The numbers look random: they're spread evenly, and you can't easily guess the next one from the ones before it. But the same seed always leads to the same series. Numbers made this way are called **pseudorandom**.

`new Random()` without a seed makes up a seed of its own, from the computer's clock and a counter, so it's different on every run. That's why the programs in the previous step printed new numbers each time.

## Same seed, same numbers

Two generators with the same seed give the same numbers:

```java
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random first = new Random(2024);
        Random second = new Random(2024);
        for (int i = 0; i < 5; i++) {
            int a = first.nextInt(6) + 1;
            int b = second.nextInt(6) + 1;
            System.out.println(a + " " + b);
        }
    }
}
```

**Output**

```text
1 1
3 3
1 1
5 5
6 6
```

A seed fixes the series only for the same calls in the same order. Ask one of them for one extra number in between, and from there on the two series are out of step: one runs a number ahead of the other.

Java's documentation spells out the exact formula that Random uses, so a seed gives the same numbers on every computer and every version of Java. That's what makes seeds useful:

- **Tests.** A program with a seeded Random prints the same output on every run, so a test can compare it with the output written down from an earlier run. The checks in this module do exactly that.
- **Games.** A game that builds its map from random numbers can let players share a seed: the same seed builds the same map. A daily puzzle can use the date as its seed, so that everyone gets the same puzzle that day.
- **Simulations and bug hunts.** When a run with random numbers does something strange, running it again with the same seed repeats it exactly, so you can look at it step by step.

## A class that takes its Random

The dice cup of a board game holds several dice and rolls them all at once. Where should its Random come from? If the class makes its own `new Random()`, nobody can test it: its rolls change on every run. So it takes a Random as a constructor parameter, and whoever creates the cup decides which:

**Main.java**

```java
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        DiceCup cup = new DiceCup(3, new Random(7));
        for (int i = 0; i < 4; i++) {
            System.out.println("Rolled " + cup.roll());
        }
    }
}
```

**DiceCup.java**

```java
import java.util.Random;

public class DiceCup {
    private int dice;
    private Random random;

    public DiceCup(int dice, Random random) {
        this.dice = dice;
        this.random = random;
    }

    public int roll() {
        int total = 0;
        for (int i = 0; i < this.dice; i++) {
            total += this.random.nextInt(6) + 1;
        }
        return total;
    }
}
```

**Output**

```text
Rolled 12
Rolled 15
Rolled 12
Rolled 3
```

- The game creates its cup with `new DiceCup(3, new Random())`, and gets new rolls every game.
- A test creates it with a seed, as this `main` does, and gets the same rolls every time, so it can check them.
- The class is the same in both cases. It doesn't care where its numbers come from, just as a class that reads with a Scanner doesn't care whether the Scanner reads the keyboard or a String. Module 26 tested methods by giving them `new Scanner("12\n8\n15\n")`; a seeded Random is the same idea.

Keep the Random in an instance variable and use it for every roll. A method that creates a `new Random(7)` each time it's called starts the same series over on every call, and gets the same first number every time.

---

Source: [Seeds: the same numbers every time](https://javaarena.com/learn/randomness/seeds/) in the module [Random numbers](https://javaarena.com/learn/randomness/) on Java Arena.

This module follows section [12.3 Randomness](https://java-programming.mooc.fi/part-12/3-randomness) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
