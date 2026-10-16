> [!info] AI-Generated

# Returning text built in a loop

A method can build a String in a loop and return it. Start from the empty String `""`, and add a piece in each round with `+=`:

```java
public class Main {
    public static void main(String[] args) {
        System.out.println(dashes(5));
        System.out.println("[" + dashes(3) + "]");
        System.out.println("[" + dashes(0) + "]");
    }

    public static String dashes(int count) {
        String line = "";
        for (int i = 0; i < count; i++) {
            line += "-";
        }
        return line;
    }
}
```

**Output**

```text
-----
[---]
[]
```

Returning the text, instead of printing it, means the caller can put it anywhere: on a line of its own, between brackets, or in front of other text on the same line. The next step uses exactly that to draw shapes.

(Java has a ready-made way to do this, `"-".repeat(5)`. Here the point is the loop, so the challenges ask you to write it yourself.)

---

Source: [Returning text built in a loop](https://javaarena.com/learn/return-values/returning-text/) in the module [Return values and the call stack](https://javaarena.com/learn/return-values/) on Java Arena.

This module follows sections [2.4 Methods and dividing the program into smaller parts](https://java-programming.mooc.fi/part-2/4-methods), [2.5 End questionnaire](https://java-programming.mooc.fi/part-2/5-end-questionnaire) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
