> [!info] AI-Generated

# Putting it together

Lists, arrays and strings often work together. The program below reads quiz results as `name,score` lines until an empty line, and then prints everyone who scored above the average. The average is known only after the last line, so the program has to remember every name and score until then: that's what the two lists are for.

```java
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<>();
        ArrayList<Integer> scores = new ArrayList<>();
        while (true) {
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                break;
            }
            String[] parts = line.split(",");
            names.add(parts[0]);
            scores.add(Integer.valueOf(parts[1].trim()));
        }

        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        double average = (double) sum / scores.size();
        System.out.println("Average: " + average);

        System.out.println("Above the average:");
        for (int i = 0; i < names.size(); i++) {
            if (scores.get(i) > average) {
                System.out.println(names.get(i) + " (" + scores.get(i) + ")");
            }
        }
    }
}
```

**Input**

```text
Aino,72
Kai, 55
Lumi,90
Noor,61
(an empty line)
```

**Output**

```text
Average: 69.5
Above the average:
Aino (72)
Lumi (90)
```

- Each line is split into an array of two parts. The name goes into one list and the score into the other, so the same index points to the same person in both lists.
- `trim()` lets the program accept `Kai, 55` as well as `Kai,55`.
- The last loop goes through the indexes, so it can look up the name and the score of the same person.

## The end of part 3

This step ends the material of the MOOC's third part. Part 3 was about handling more data than a few variables can hold. It started with finding bugs, and then brought lists, which grow as values are added, and arrays, whose size is fixed when they're made. A loop goes through either of them one element at a time. This module added the tools for taking text apart: its characters, its pieces and `split`. Together they let a program read any amount of input and make sense of it. The MOOC closes the part with [a summary page](https://java-programming.mooc.fi/part-3/5-increasing-amounts-of-data) on its own site, for reading only.

---

Source: [Putting it together](https://javaarena.com/learn/strings/putting-it-together/) in the module [Working with strings](https://javaarena.com/learn/strings/) on Java Arena.

This module follows sections [3.4 Using strings](https://java-programming.mooc.fi/part-3/4-using-strings), [3.5 Summary](https://java-programming.mooc.fi/part-3/5-increasing-amounts-of-data) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
