> [!info] AI-Generated

# Decimal numbers and chances

`nextInt` gives whole numbers. For decimal numbers, and for things that should happen with a given chance, there's `nextDouble`.

## nextDouble

`random.nextDouble()` returns a random `double` from 0.0 up to, but not including, 1.0. Every value in between is as likely as any other:

```java
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random(3);
        for (int i = 0; i < 4; i++) {
            System.out.println(random.nextDouble());
        }
    }
}
```

**Output**

```text
0.731057369148862
0.07099203475193139
0.06712000939049956
0.768156984078079
```

To get a decimal number in another range, stretch it and move it, as with `nextInt`. Multiplying by 3.0 spreads the numbers out from 0.0 up to 3.0, and adding 2.0 moves them to 2.0 up to 5.0. A reaction game that waits a random time before it shows its signal, so that players can't count along:

```java
double waitSeconds = 2.0 + random.nextDouble() * 3.0;
```

For a range from `low` up to `high`, multiply by `high - low` and add `low`.

## A chance

How do you make something happen 30% of the time? Draw a `nextDouble()` and compare it with 0.3. The numbers are spread evenly from 0.0 to 1.0, so 30% of them are below 0.3:

```java
if (random.nextDouble() < 0.3) {
    System.out.println("You found a treasure!");
}
```

With a seed, you can see how close it gets:

```java
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random(5);
        int treasures = 0;
        for (int i = 0; i < 10000; i++) {
            if (random.nextDouble() < 0.3) {
                treasures++;
            }
        }
        System.out.println(treasures + " treasures on 10000 squares");
    }
}
```

**Output**

```text
3014 treasures on 10000 squares
```

About 3000, but not exactly: random results wobble around what you expect. The more tries, the smaller the wobble is compared with the whole.

- `random.nextDouble() < 0.05` is true 5% of the time, and `random.nextDouble() < 1.0` always.
- Whole numbers work too: `random.nextInt(100) < 30` is true for 0 to 29, which is 30 of the 100 numbers.
- For a 50-50 choice, such as a coin flip, `random.nextBoolean()` returns `true` or `false`, each half the time.

## Several outcomes

A board game's chance square sends you 2 squares ahead half the time, gives you another roll 30% of the time, and makes you miss a turn the other 20%. To choose between several outcomes, draw **one** number and split the range from 0.0 to 1.0 into parts:

```java
public static String chanceSquare(Random random) {
    double draw = random.nextDouble();
    if (draw < 0.5) {
        return "move 2 squares ahead";
    } else if (draw < 0.8) {
        return "roll again";
    } else {
        return "miss a turn";
    }
}
```

- 0.0 to 0.5 is half of the range: 50% for moving ahead.
- 0.5 to 0.8 is 0.3 of it: 30% for another roll. The `else if` is only reached when the draw is 0.5 or more, so its test is `< 0.8`, which is 0.5 + 0.3, not `< 0.3`.
- The rest, 0.8 to 1.0, is 20% for missing a turn.

Draw the number once, before the `if`. With a new `random.nextDouble()` in each test, the second test would only be reached half the time, and then be true 80% of that time: another roll 40% of the time instead of 30%.

## Math.random()

`Math.random()` returns a random double from 0.0 up to 1.0, just like `nextDouble()`. It needs no import and no object, which makes it handy in a quick program:

```java
if (Math.random() < 0.3) {
    System.out.println("You found a treasure!");
}
```

Behind the scenes, Java creates one Random for `Math.random()` the first time it's called, without a seed, and you can't give it one. So a program built on `Math.random()` can't repeat its numbers, and its exact output can't be tested. For anything you want to test, pass a Random around instead.

To get a whole number from `Math.random()`, multiply it and cast the result to `int`. A cast to `int` drops the decimals: `(int) 5.83` is 5. So a die roll is:

```java
int roll = (int) (Math.random() * 6) + 1;
```

`Math.random() * 6` is from 0.0 up to 6.0, the cast turns it into a whole number from 0 to 5, and adding 1 makes it 1 to 6. The parentheses around `Math.random() * 6` matter. Like the cast to `double` in module 4, a cast applies to the value right after it: `(int) Math.random() * 6` casts `Math.random()` alone, which is below 1.0 and so always becomes 0, and 0 * 6 is 0.

---

Source: [Decimal numbers and chances](https://javaarena.com/learn/randomness/decimals-and-chances/) in the module [Random numbers](https://javaarena.com/learn/randomness/) on Java Arena.

This module follows section [12.3 Randomness](https://java-programming.mooc.fi/part-12/3-randomness) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
