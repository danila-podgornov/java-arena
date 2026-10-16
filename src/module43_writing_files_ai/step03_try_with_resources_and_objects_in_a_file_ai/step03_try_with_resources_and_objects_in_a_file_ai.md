> [!info] AI-Generated

# try-with-resources, and objects in a file

## Closed however the block ends

A PrintWriter is a resource like the Scanner that reads a file: its class implements AutoCloseable, so it can go in the parentheses of a try-with-resources (module 42), which closes it as soon as the block ends. That matters when something goes wrong halfway. Here a game saves its players' points from text, and one of them isn't a number:

```java
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        String[] points = {"120", "95", "x", "80"};
        try (PrintWriter writer = new PrintWriter("points.txt")) {
            for (String point : points) {
                writer.println(Integer.parseInt(point));
            }
        } catch (NumberFormatException e) {
            System.out.println("Stopped: " + e.getMessage());
        }

        try (Scanner reader = new Scanner(Paths.get("points.txt"))) {
            while (reader.hasNextLine()) {
                System.out.println("Saved: " + reader.nextLine());
            }
        }
    }
}
```

**Output**

```text
Stopped: For input string: "x"
Saved: 120
Saved: 95
```

- `parseInt("x")` throws, and the loop stops there. The writer is closed on the way out of the `try` block, before the `catch` block runs, so the two lines written before the problem reach the file.
- Written as in step 1, with `writer.close()` as the last line of the `try` block, the exception would skip `close()`, and the file would stay empty.
- In a method that passes exceptions on with `throws Exception`, a try-with-resources needs no `catch`: the writer is closed, and then the exception goes on to the caller.

try-with-resources is shorter than calling `close()` yourself, and there's nothing to forget, so from here on this module writes files that way.

## A list of objects, one per line

A game keeps a high-score table: a list of HighScore objects, each with a player and points. To save it, the program writes one line per object, with the values separated by commas, like the CSV files module 20 read:

**Main.java**

```java
import java.io.PrintWriter;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<HighScore> scores = new ArrayList<>();
        scores.add(new HighScore("Mia", 4200));
        scores.add(new HighScore("Leo", 3950));
        scores.add(new HighScore("Ana", 3100));

        try (PrintWriter writer = new PrintWriter("highscores.csv")) {
            for (HighScore score : scores) {
                writer.println(score.toCsv());
            }
        }
        System.out.println("Saved " + scores.size() + " scores");
        System.out.println(scores.get(0));
    }
}
```

**HighScore.java**

```java
public class HighScore {
    private String player;
    private int points;

    public HighScore(String player, int points) {
        this.player = player;
        this.points = points;
    }

    public String getPlayer() {
        return this.player;
    }

    public int getPoints() {
        return this.points;
    }

    public String toCsv() {
        return this.player + "," + this.points;
    }

    @Override
    public String toString() {
        return this.player + ": " + this.points;
    }
}
```

**Output**

```text
Saved 3 scores
Mia: 4200
```

After the run, `highscores.csv` holds:

```text
Mia,4200
Leo,3950
Ana,3100
```

- The loop writes one line per object, in the list's order.
- `toCsv()` says how one HighScore looks as a line of the file. The format is then written in one place: the class knows its own values, and every program that saves HighScores writes the same lines.
- `toString()` is for people: it's what `println(scores.get(0))` showed on the screen. `toCsv()` is for the program that reads the file back. `writer.println(score)` would write `Mia: 4200` into the file, which is harder to take apart again. `Mia,4200` splits with module 20's `split(",")` into the player and the points, and `Integer.valueOf` turns the points back into a number. Step 4 does exactly that.

## Headers and commas

- A file meant for a spreadsheet often starts with a header line that names the columns, such as `player,points` (module 20 skipped such a line when reading). Write it once, before the loop.
- A value with a comma of its own, such as the player `Lee, Jr.`, would split into too many parts when the file is read back. Choose a separator that doesn't occur in the data (`;` is common, as module 20 said), or refuse such values when an object is created (module 42).

---

Source: [try-with-resources, and objects in a file](https://javaarena.com/learn/writing-files/lists-of-objects/) in the module [Writing files](https://javaarena.com/learn/writing-files/) on Java Arena.

This module follows sections [11.4 Processing files](https://java-programming.mooc.fi/part-11/4-processing-files), [11.5 Conclusion](https://java-programming.mooc.fi/part-11/5-conclusion) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
