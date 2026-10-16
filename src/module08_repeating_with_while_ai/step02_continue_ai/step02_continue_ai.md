> [!info] AI-Generated

# continue

`break` leaves the loop. Its partner `continue` only skips the rest of this round: the loop goes straight back to its start and carries on. It's handy for skipping input that shouldn't be handled:

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int number = Integer.valueOf(scanner.nextLine());
            if (number == 0) {
                break;
            }
            if (number % 2 != 0) {
                System.out.println(number + " is odd, skipped");
                continue;
            }
            System.out.println("Half of " + number + " is " + number / 2);
        }
    }
}
```

**Input**

```text
8
5
12
0
```

**Output**

```text
Half of 8 is 4
5 is odd, skipped
Half of 12 is 6
```

For 5 the `continue` runs, so the "Half of" line is skipped for that round only. The loop then reads 12 as usual.

A loop often starts with its checks, each ending in `break` or `continue`, and then does the real work for the input that got through them.

---

Source: [continue](https://javaarena.com/learn/loops/continue/) in the module [Repeating with while](https://javaarena.com/learn/loops/) on Java Arena.

This module follows section [2.2 Repeating functionality](https://java-programming.mooc.fi/part-2/2-repeating) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
