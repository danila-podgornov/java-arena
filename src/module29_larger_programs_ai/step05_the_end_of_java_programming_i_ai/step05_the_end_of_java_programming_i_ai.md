> [!info] AI-Generated

# The end of Java Programming I

This step ends the material of the MOOC's seventh part, and with it Java Programming I, the first half of the course. First, this module in one list. When a program is bigger than a screen:

1. Start from a description, and find its parts: a class for the data, a class for the logic, and the part that reads input and prints.
2. Write down the rules for input before writing code: what ends it, what's valid, and what to print when nothing is.
3. Build the data class first, then the logic, and the input part last. Try each piece with a test drive, and use placeholders for methods that aren't written yet.
4. Let the logic answer with return values, `null` and `false` included, and let the input part turn those answers into messages.
5. Read every line of a command before checking any of it, and answer bad input instead of crashing.

## What Java Programming I covered

Every program in this module was built from the tools of the earlier ones. Here they are, part by part:

- **Part 1:** printing, reading input with a Scanner, variables and their types, calculating, and choosing with `if`, `else if` and conditions joined with `&&`, `||` and `!`.
- **Part 2:** repeating with `while` and `for`, `break` and `continue`, and dividing a program into methods with parameters and return values.
- **Part 3:** finding bugs, lists and arrays, and taking text apart with the String methods and `split`.
- **Part 4:** classes and objects, with constructors, getters and `toString`, lists of objects, and reading files.
- **Part 5:** designing classes, overloading, primitive and reference variables, `null`, objects that use other objects, and `equals`.
- **Part 6:** lists inside objects, a user interface kept apart from the program's logic, and unit tests with JUnit.
- **Part 7:** procedural and object-oriented programs side by side, sorting and searching, and this module's larger programs.

## A final program

This step's challenges put many of those tools into one program. The board-game club of step 1 runs a league: after every game, each player gets 0 to 10 league points, and the club writes them into the file `league.csv`, one line per player and game, like `Mia,8`. The program reads the file (part 4), keeps the players in a list inside a logic object and each player's points in a list inside the player (part 6), finds players by name and picks the leader (parts 3 and 5), sorts their names (part 7), and answers commands, bad input included (part 6 and this module). The plan:

| Part | Class | Its job |
| --- | --- | --- |
| The data | `Player` | a player's name and their points from each game |
| The logic | `League` | the players: find one, add a game's points, the leader, the names in order |
| Input and output | `Main` and `UserInterface` | read the file, then answer the commands |

Here's `Player`, ready for both challenges:

```java
import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Integer> games;

    public Player(String name) {
        this.name = name;
        this.games = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void addGame(int points) {
        this.games.add(points);
    }

    public int total() {
        int total = 0;
        for (int points : this.games) {
            total += points;
        }
        return total;
    }

    public String toString() {
        return this.name + ", total " + this.total() + ", games " + this.games;
    }
}
```

## What comes next

Java Programming II continues from part 8. It opens with a short recap of parts 1 to 7, and then brings the **hash map**: a collection that finds a value by its key, such as a phone number by a person's name. After that, its parts go on to inheritance and interfaces, streams, exceptions, writing files and graphical user interfaces, among other things. This site will add those modules later. Part 7, and with it Java Programming I, closes with [the MOOC's conclusion page](https://java-programming.mooc.fi/part-7/4-java-programming) on its own site.

---

Source: [The end of Java Programming I](https://javaarena.com/learn/larger-programs/end-of-java-programming-1/) in the module [Larger programs](https://javaarena.com/learn/larger-programs/) on Java Arena.

This module follows sections [7.3 Larger programming exercises](https://java-programming.mooc.fi/part-7/3-larger-exercises), [7.4 Conclusion](https://java-programming.mooc.fi/part-7/4-java-programming) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
