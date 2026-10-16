> [!info] AI-Generated

# Drawing shapes with methods

Text shapes are a good workout for loops and methods together. The trick is to look at a shape one row at a time, and write down what each row is made of. Here's a pyramid of height 3:

```text
  ^
 ^^^
^^^^^
```

| Row | Spaces | Symbols |
|---|---|---|
| 1 | 2 | 1 |
| 2 | 1 | 3 |
| 3 | 0 | 5 |

The spaces go down by one per row: for a height `h`, row `r` has `h - r` of them. The symbols go up by two: `2 * r - 1`. With a method that returns repeated text, each row is then one line of code:

```java
public class Main {
    public static void main(String[] args) {
        printPyramid(3);
    }

    public static void printPyramid(int height) {
        for (int row = 1; row <= height; row++) {
            System.out.println(repeat(" ", height - row) + repeat("^", 2 * row - 1));
        }
    }

    public static String repeat(String text, int times) {
        String result = "";
        for (int i = 0; i < times; i++) {
            result += text;
        }
        return result;
    }
}
```

**Output**

```text
  ^
 ^^^
^^^^^
```

Spaces at the start of a line count, so the checks compare them exactly. (Spaces at the end of a line are ignored.)

## The end of part 2

This step ends the material of the MOOC's second part. Looking back, most of it was about two tools. A loop runs the same lines as often as needed, so a program never has to repeat itself. A method gives a piece of code a name, so a long program becomes a set of small parts that can each be read and checked on its own. The shapes above use both. The MOOC closes the part with [a short self-reflection questionnaire](https://java-programming.mooc.fi/part-2/5-end-questionnaire) on its own site.

---

Source: [Drawing shapes with methods](https://javaarena.com/learn/return-values/drawing-shapes/) in the module [Return values and the call stack](https://javaarena.com/learn/return-values/) on Java Arena.

This module follows sections [2.4 Methods and dividing the program into smaller parts](https://java-programming.mooc.fi/part-2/4-methods), [2.5 End questionnaire](https://java-programming.mooc.fi/part-2/5-end-questionnaire) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
