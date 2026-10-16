> [!info] AI-Generated

# while (true) and break

A **loop** runs the same lines again and again. The simplest loop in Java is `while (true)`: the block after it repeats forever, until a `break` inside it ends the loop.

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Type a word (end stops):");
            String word = scanner.nextLine();
            if (word.equals("end")) {
                break;
            }
            System.out.println("You typed " + word);
        }
        System.out.println("Bye!");
    }
}
```

**Input**

```text
cat
dog
end
```

**Output**

```text
Type a word (end stops):
You typed cat
Type a word (end stops):
You typed dog
Type a word (end stops):
Bye!
```

Each time round, the loop asks, reads a word and checks it. For `cat` and `dog` it prints the word and starts again from the top. For `end`, `break` jumps straight out of the loop, to the first line after its closing `}`.

A `while (true)` loop needs a way out. Here the input is the way out: if it never contains `end`, the loop keeps reading until the input runs out, and the program crashes with a `NoSuchElementException` ("No line found"): it asked for more input than it was given. A loop that doesn't read anything and has no `break` would never stop at all; on this site such a program is stopped after 10 seconds, with a note that it probably has an endless loop.

---

Source: [while (true) and break](https://javaarena.com/learn/loops/while-and-break/) in the module [Repeating with while](https://javaarena.com/learn/loops/) on Java Arena.

This module follows section [2.2 Repeating functionality](https://java-programming.mooc.fi/part-2/2-repeating) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
