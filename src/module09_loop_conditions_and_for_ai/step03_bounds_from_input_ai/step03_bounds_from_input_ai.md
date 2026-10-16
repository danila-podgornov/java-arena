> [!info] AI-Generated

# Bounds from input

Both ends of a loop can come from the input. The loop then runs as many rounds as the numbers say:

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int from = Integer.valueOf(scanner.nextLine());
        int to = Integer.valueOf(scanner.nextLine());
        for (int i = from; i <= to; i++) {
            System.out.println(i);
        }
        System.out.println("End");
    }
}
```

**Input**

```text
-2
1
```

**Output**

```text
-2
-1
0
1
End
```

What if the start is bigger than the end, say from 5 to 3? The condition `5 <= 3` is false before the first round, so the loop's block doesn't run at all, and the program goes straight on to `End`. A loop that runs zero times is normal, and a program should still print something sensible when it happens.

---

Source: [Bounds from input](https://javaarena.com/learn/for-loops/bounds-from-input/) in the module [Loop conditions and for](https://javaarena.com/learn/for-loops/) on Java Arena.

This module follows section [2.3 More loops](https://java-programming.mooc.fi/part-2/3-more-loops) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
