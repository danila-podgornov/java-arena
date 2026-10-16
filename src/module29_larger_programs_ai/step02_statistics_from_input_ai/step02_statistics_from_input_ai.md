> [!info] AI-Generated

# Statistics from input

A common kind of program reads a series of numbers and then reports on them: how many there were, their average, the largest, and what share of them passed some limit. Before writing any code, decide three things:

1. **What ends the input.** Here, a line with the word `end`.
2. **Which values count.** Real input has mistakes in it, so write down a rule for what's valid, and what happens to the rest. Here, a line that breaks the rule is skipped: it's only counted as skipped.
3. **What to print when nothing counts.** The average of no values would divide by zero, so that case gets a message of its own.

A bowling league types in the scores of the evening's games, one per line. A game of bowling scores from 0 to 300 points, so any other number is a typing mistake:

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int games = 0;
        int skipped = 0;
        int total = 0;
        int best = 0;
        int highGames = 0;
        while (true) {
            String line = scanner.nextLine();
            if (line.equals("end")) {
                break;
            }
            int score = Integer.valueOf(line);
            if (score < 0 || score > 300) {
                skipped++;
                continue;
            }
            games++;
            total += score;
            if (score > best) {
                best = score;
            }
            if (score >= 200) {
                highGames++;
            }
        }
        System.out.println("Games: " + games);
        System.out.println("Skipped: " + skipped);
        if (games == 0) {
            System.out.println("No games to report");
        } else {
            double average = (double) total / games;
            double highShare = 100.0 * highGames / games;
            System.out.println("Average: " + average);
            System.out.println("Best: " + best);
            System.out.println("200 or more: " + highShare + "%");
        }
    }
}
```

**Input**

```text
156
212
310
247
131
161
end
```

**Output**

```text
Games: 5
Skipped: 1
Average: 181.4
Best: 247
200 or more: 40.0%
```

- The loop reads each line as a String, so it can compare it with `end` before turning it into a number. The stop word is checked first, so it never becomes a score.
- The rule is a single `if` near the top of the loop. Its `continue` skips the rest of the round, so a skipped value can't reach any of the counts below it: 310 is only counted in `skipped`.
- Each result has its own variable, created before the loop: the number of games, the total (for the average), the best score, and the number of games of 200 or more (for the share).
- `best` starts at 0. That works because no valid score is below 0. For values that can be negative, such as temperatures, 0 could be larger than all of them. Then take the first valid value as the best so far: `if (games == 1 || score > best)`.
- With no valid games, `games` is 0, and the program says so instead of dividing by it.

## Shares as percentages

A share is the part divided by the whole, times 100. With two `int` values, the division drops the decimals (module 4), so the order matters. Start with `100.0`, a double, and the whole calculation keeps its decimals:

```java
int high = 2;
int games = 5;
System.out.println(high / games * 100);
System.out.println(100 * high / games);
System.out.println(100.0 * high / games);
```

**Output**

```text
0
40
40.0
```

`2 / 5` is 0 with `int` values, and 0 times 100 is still 0.

A double can print many decimals, and two calculations that are the same on paper don't always give the same last digit. A double holds a value such as one third only approximately. Each step's result is rounded to the nearest double, so doing the same steps in another order can change the last digit:

```java
System.out.println(100.0 * 1 / 3);
System.out.println((double) 1 / 3 * 100);
```

**Output**

```text
33.333333333333336
33.33333333333333
```

Both are one third of 100, and both are fine answers. But a check compares your output with the expected one character by character, so the tasks in this module say exactly which calculation to use. Use that one, and your output matches digit for digit.

## The plan, for statistics

Step 1's plan fits here too, in a smaller form. The data is plain numbers, so no data class is needed. The logic could be a class of its own that collects the numbers and answers the questions, like module 18's `TripLog`, which kept the count, the total and the longest of a series of bike trips. With a few questions, the variables in `main` are enough, as above. When the questions grow, move them into a class.

---

Source: [Statistics from input](https://javaarena.com/learn/larger-programs/statistics-from-input/) in the module [Larger programs](https://javaarena.com/learn/larger-programs/) on Java Arena.

This module follows sections [7.3 Larger programming exercises](https://java-programming.mooc.fi/part-7/3-larger-exercises), [7.4 Conclusion](https://java-programming.mooc.fi/part-7/4-java-programming) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
