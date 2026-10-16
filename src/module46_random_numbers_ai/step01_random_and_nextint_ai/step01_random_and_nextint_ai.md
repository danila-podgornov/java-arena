> [!info] AI-Generated

# Random and nextInt

Every program in this course so far does the same thing each time it runs with the same input. Plenty of programs shouldn't: a board game rolls dice, a quiz asks its questions in a new order, a workout app picks today's exercises, and a simulation tries out thousands of possible days. They need numbers that nobody can predict: **random numbers**. Java makes them with the class `Random`, from the package `java.util`.

## Asking for a number

```java
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            System.out.println(random.nextInt(10));
        }
    }
}
```

A run might print:

```text
5
2
7
0
0
```

Run it again, and you'll get other numbers.

- `import java.util.Random;` makes the class available, like the import line of a Scanner.
- `new Random()` creates a **random number generator**: an object whose job is to hand out random numbers.
- `random.nextInt(10)` returns a random whole number from 0 to 9. The number in the parentheses is the **bound**: the result is always at least 0 and always less than the bound. All ten numbers are equally likely, and each call is a new draw, so the same number can come up twice in a row, like the two zeros above.

Make one Random at the start, and ask it for as many numbers as you need, the way one Scanner reads all the input.

## From 0 to bound - 1

The bound itself never comes up. Since the numbers change from run to run, you can't check that by comparing them with a list written down earlier. But you can keep the smallest and the largest of many numbers:

```java
Random random = new Random();
int smallest = 100;
int largest = -100;
for (int i = 0; i < 10000; i++) {
    int number = random.nextInt(10);
    if (number < smallest) {
        smallest = number;
    }
    if (number > largest) {
        largest = number;
    }
}
System.out.println("smallest " + smallest + ", largest " + largest);
```

**Output**

```text
smallest 0, largest 9
```

In 10000 numbers, each of the ten values comes up about a thousand times, so 0 and 9 are there, and 10 never is. The numbers behind it differ on every run, but this output doesn't. Step 5 comes back to this way of checking random results.

`nextInt(10)` gives exactly the indexes of an array or a list of 10 elements, from 0 to 9. Step 4 uses that.

## Shifting the range

A die shows 1 to 6, not 0 to 5. `nextInt(6)` gives six different numbers, 0 to 5, and adding 1 to each moves them up to 1 to 6:

```java
int roll = random.nextInt(6) + 1;
```

The same works for any range. For the whole numbers from `low` to `high`, both included:

- there are `high - low + 1` of them, and that's the bound
- adding `low` moves the smallest one from 0 up to `low`

So a treasure chest with 10 to 20 coins in it is `random.nextInt(11) + 10`: 11 numbers, from 0 + 10 = 10 to 10 + 10 = 20. A change of -3 to 3 is `random.nextInt(7) - 3`.

Two easy slips: `random.nextInt(20) + 10` gives 10 to 29, since the bound is how many numbers there are, not the largest one. And `random.nextInt(10) + 10` stops at 19: when you count the numbers in a range, count both ends.

(Since Java 17, a Random can also do this in one call: `random.nextInt(1, 7)` gives 1 to 6, the first number included and the second not, like `substring`. This course shifts the range itself, which works in every version of Java.)

## Two dice

A board game moves a piece by the total of two dice. Each die is a call of its own:

```java
int first = random.nextInt(6) + 1;
int second = random.nextInt(6) + 1;
System.out.println("You rolled " + first + " and " + second + ": move " + (first + second) + " squares");
```

`random.nextInt(11) + 2` also gives a number from 2 to 12, but not the way two dice do. Of the 36 ways two dice can land, six make 7 (1 and 6, 2 and 5, 3 and 4, and the other way around), and just one makes 2 (1 and 1). So with two dice, a 7 comes up six times as often as a 2, while `nextInt(11) + 2` makes all eleven totals equally likely. When a program imitates something random, it should do what the real thing does: roll each die.

## A Random as a parameter

A method that needs random numbers can take the Random as a parameter, the way methods in earlier modules took the Scanner they read from:

```java
public static int rollDie(Random random) {
    return random.nextInt(6) + 1;
}
```

`main` creates one Random and passes it to every call. The next step shows why that's more than a habit.

---

Source: [Random and nextInt](https://javaarena.com/learn/randomness/next-int/) in the module [Random numbers](https://javaarena.com/learn/randomness/) on Java Arena.

This module follows section [12.3 Randomness](https://java-programming.mooc.fi/part-12/3-randomness) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
