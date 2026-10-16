> [!info] AI-Generated

# Searching an array

Searching an array works just like searching a list with a loop: go through the indexes, and look at each element. This program reads a week of midday temperatures and does the three searches that come up most often:

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] temperatures = new int[7];
        for (int i = 0; i < temperatures.length; i++) {
            temperatures[i] = Integer.valueOf(scanner.nextLine());
        }

        int firstFrost = -1;
        for (int i = 0; i < temperatures.length; i++) {
            if (temperatures[i] < 0) {
                firstFrost = i;
                break;
            }
        }
        if (firstFrost == -1) {
            System.out.println("No frost this week");
        } else {
            System.out.println("First frost on day " + firstFrost);
        }

        int warmDays = 0;
        for (int temperature : temperatures) {
            if (temperature >= 10) {
                warmDays++;
            }
        }
        System.out.println("Warm days: " + warmDays);

        int warmest = temperatures[0];
        int warmestDay = 0;
        for (int i = 1; i < temperatures.length; i++) {
            if (temperatures[i] > warmest) {
                warmest = temperatures[i];
                warmestDay = i;
            }
        }
        System.out.println("Warmest: " + warmest + " on day " + warmestDay);
    }
}
```

**Input**

```text
8
12
3
-2
11
-4
5
```

**Output**

```text
First frost on day 3
Warm days: 2
Warmest: 12 on day 1
```

- **Finding an index.** `firstFrost` starts at -1, which is never an index, so it means "not found yet". At the first match, the loop stores the index and leaves with `break`. If nothing matched, it's still -1 after the loop.
- **Counting.** A counter and an `if`. The index isn't needed, so a for-each loop is enough.
- **The largest value and its index.** Start from the first element, not from 0: in a week where every day is below zero, 0 would beat them all, and the answer would be a temperature that never happened. Keep the index next to the value, and update both together.

With `>`, the first of two equal values wins, because a later one isn't bigger. With `>=`, the last one would win.

---

Source: [Searching an array](https://javaarena.com/learn/arrays/searching-an-array/) in the module [Arrays](https://javaarena.com/learn/arrays/) on Java Arena.

This module follows section [3.3 Arrays](https://java-programming.mooc.fi/part-3/3-arrays) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
