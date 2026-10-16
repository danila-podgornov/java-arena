> [!info] AI-Generated

# Multiplying in a loop

A product is built up like a sum, with one difference: it starts at **1**, not 0. Starting at 0 would make every product 0.

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int doublings = Integer.valueOf(scanner.nextLine());
        int value = 1;
        for (int i = 0; i < doublings; i++) {
            value *= 2;
        }
        System.out.println("1 doubled " + doublings + " times is " + value);
    }
}
```

**Input**

```text
10
```

**Output**

```text
1 doubled 10 times is 1024
```

With `0` as the input the loop doesn't run, and the value stays 1, which is right: doubling zero times changes nothing. (The same loop calculates 2 to the power of the input.)

Products grow fast. An `int` holds values up to 2147483647 (module 4), so these programs only work for fairly small inputs. The tests here stay inside that limit.

---

Source: [Multiplying in a loop](https://javaarena.com/learn/for-loops/multiplying/) in the module [Loop conditions and for](https://javaarena.com/learn/for-loops/) on Java Arena.

This module follows section [2.3 More loops](https://java-programming.mooc.fi/part-2/3-more-loops) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
