> [!info] AI-Generated

# Averages after the loop

An average needs both a sum and a count: it's the sum divided by the count. The loop collects the two, and the average is calculated **after** the loop, once all the numbers are in:

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        int sum = 0;
        while (true) {
            int number = Integer.valueOf(scanner.nextLine());
            if (number == 0) {
                break;
            }
            count++;
            sum += number;
        }
        if (count == 0) {
            System.out.println("No numbers");
        } else {
            double average = (double) sum / count;
            System.out.println("Average: " + average);
        }
    }
}
```

**Input**

```text
4
5
8
0
```

**Output**

```text
Average: 5.666666666666667
```

Two details matter:

- `(double) sum / count` turns the sum into a `double` before dividing, so the decimals are kept (module 4 showed why).
- With no numbers at all, `count` is 0, and there's no average to show. The `if` checks for that before dividing.

---

Source: [Averages after the loop](https://javaarena.com/learn/loops/averages/) in the module [Repeating with while](https://javaarena.com/learn/loops/) on Java Arena.

This module follows section [2.2 Repeating functionality](https://java-programming.mooc.fi/part-2/2-repeating) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
