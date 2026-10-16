> [!info] AI-Generated

# Reading a line with Scanner

So far the programs printed the same thing every time. Most programs also take **input**: something the user types. In Java, a **Scanner** reads it. Using one takes three pieces:

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write a message:");
        String message = scanner.nextLine();
        System.out.println(message);
    }
}
```

**Input**

```text
Hello there
```

**Output**

```text
Write a message:
Hello there
```

- `import java.util.Scanner;` at the very top tells the compiler where the Scanner comes from. Scanner is part of Java's standard library, in the package `java.util`, and a program has to import it before using it.
- `Scanner scanner = new Scanner(System.in);` creates a Scanner called `scanner` that reads from `System.in`, the program's input. One Scanner is enough for the whole program.
- `String message = scanner.nextLine();` waits until the user has typed a line and pressed Enter, then keeps that line in `message`. The next step explains what `String message` means.

## Input on this site

When you run a program in a terminal, you type the input while it runs, and your typing appears on the screen between the program's lines. The checks here give the program all of its input at the start instead, like a pre-typed answer sheet, so the expected output only contains what the program itself prints. That's why `Hello there` appears once in the output above, not twice.

---

Source: [Reading a line with Scanner](https://javaarena.com/learn/reading-input/reading-a-line/) in the module [Reading input and strings](https://javaarena.com/learn/reading-input/) on Java Arena.

This module follows section [1.3 Reading input](https://java-programming.mooc.fi/part-1/3-reading) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
