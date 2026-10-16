> [!info] AI-Generated

# Simulations, and checking random results

This last step puts random numbers to work in whole programs: simulations that answer questions about chance, checks that a random result is right, and a word on where Random doesn't belong.

## Simulations

Some questions about chance are hard to work out by hand but easy to try: play the game many times, and count. That's a **simulation**. How many rolls of a die does it take, on average, to get the first six?

```java
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random(1);
        int games = 10000;
        int totalRolls = 0;
        for (int i = 0; i < games; i++) {
            totalRolls += rollsUntilSix(random);
        }
        System.out.println("Average rolls: " + (double) totalRolls / games);
    }

    public static int rollsUntilSix(Random random) {
        int rolls = 0;
        int roll = 0;
        while (roll != 6) {
            roll = random.nextInt(6) + 1;
            rolls++;
        }
        return rolls;
    }
}
```

**Output**

```text
Average rolls: 5.9766
```

Close to 6, which is also what probability math says: with a chance of 1 in 6 on each roll, it takes 6 rolls on average. In a single game it can take 1 roll, or 20. Simulations earn their keep when the math gets hard: a whole board game with several players, special squares and cards is much easier to simulate than to calculate.

- The more games a simulation plays, the closer its answer usually is to the true one. Try 100 games instead of 10000, with a few different seeds, and the averages are much further apart.
- The seed makes the whole simulation repeatable. Anyone who runs it gets exactly the same average, and can check your work.

## Checking random results

A test of a program with random numbers has two tools. With a seed, it can compare the exact output, as this module's checks do. Without one, it can still check what must be true of **every** run, however the numbers fall. Such facts are called **properties**:

- every value is in its range: a die roll is from 1 to 6
- every possible value comes up, given enough tries: in 6000 rolls, all six faces
- a draw without repeats has no repeats, and a shuffled list has the same elements as before
- a share is close to its chance: of 100000 tries with a 30% chance, between 28% and 32% hit

The last one needs a margin, since random results wobble. With enough tries, a wide margin is practically never crossed by chance: when such a check fails, look for the mistake in the code. The hidden tests of this module's challenges check properties like these.

Here's a property of a shuffle. However the list is shuffled, sorting it gives back the sorted original:

```java
ArrayList<String> guests = new ArrayList<>();
guests.add("Noor");
guests.add("Emil");
guests.add("Sade");
guests.add("Luca");
ArrayList<String> sorted = new ArrayList<>(guests);
Collections.sort(sorted);
Random random = new Random();
boolean same = true;
for (int i = 0; i < 1000; i++) {
    ArrayList<String> shuffled = new ArrayList<>(guests);
    Collections.shuffle(shuffled, random);
    Collections.sort(shuffled);
    if (!shuffled.equals(sorted)) {
        same = false;
    }
}
System.out.println("The same guests after 1000 shuffles: " + same);
```

**Output**

```text
The same guests after 1000 shuffles: true
```

## Not for secrets

Random is fine for games, simulations and tests, but not for passwords, secret codes or anything else that someone would like to guess. Its formula is public, and someone who sees enough of its numbers can work out the ones that come next. Java has a separate class for secrets, `SecureRandom` in the package `java.security`, which is built so that its numbers can't be worked out that way.

---

Source: [Simulations, and checking random results](https://javaarena.com/learn/randomness/simulations-and-checks/) in the module [Random numbers](https://javaarena.com/learn/randomness/) on Java Arena.

This module follows section [12.3 Randomness](https://java-programming.mooc.fi/part-12/3-randomness) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
