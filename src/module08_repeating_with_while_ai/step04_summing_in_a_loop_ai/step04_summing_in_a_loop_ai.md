> [!info] AI-Generated

# Summing in a loop

Summing works like counting, but instead of adding one each time, the loop adds the value it read. The sum starts at 0 before the loop:

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = 0;
        while (true) {
            int price = Integer.valueOf(scanner.nextLine());
            if (price == 0) {
                break;
            }
            total += price;
        }
        System.out.println("To pay: " + total);
    }
}
```

**Input**

```text
4
12
3
0
```

**Output**

```text
To pay: 19
```

`total += price` is shorthand for `total = total + price`. The other operators have one too: `-=`, `*=` and `/=`.

A loop can keep several of these at once, such as a count and a sum, each in its own variable made before the loop.

---

Source: [Summing in a loop](https://javaarena.com/learn/loops/summing/) in the module [Repeating with while](https://javaarena.com/learn/loops/) on Java Arena.

This module follows section [2.2 Repeating functionality](https://java-programming.mooc.fi/part-2/2-repeating) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
