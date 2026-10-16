> [!info] AI-Generated

# From a description to a plan

The MOOC's section 7.3 is a set of larger programming exercises. Larger doesn't mean new tools: every program in this module uses things you've already learned. What changes is the size. A program of a hundred lines can't be written from top to bottom and then run for the first time. It needs a plan, and it's built one small piece at a time, with a run after every piece. This module does that for three kinds of programs that come up again and again, and then looks back at the whole of Java Programming I.

## From a description to its parts

Programs usually start as a description in plain words. Here's one:

> A board-game club meets once a week. At the end of the evening, someone types in the games that were played, one per line, like `Azul,35`: the game's name and how many minutes it took. An empty line ends the list. The program then prints how many games were played, how many minutes they took in all, and the longest game.

Read it and look for three kinds of things:

| Look for | In this description | It becomes |
| --- | --- | --- |
| A thing with values of its own | a game, with a name and minutes | a class for the data: `Game` |
| Questions about all of them together | how many, how long in all, the longest | a class for the logic: `GameNight`, with a list of games and a method for each question |
| What's typed and what's printed | lines like `Azul,35`, the empty line, the results | the part that reads input and prints: here, `main` |

This is the split of module 25. The logic class doesn't read or print anything: its methods take values as parameters and give answers back as return values, and only the input part talks with the user. Module 25 put that part in a `UserInterface` class. A program that reads once and then prints once can keep it in `main`.

## One piece at a time

Build the parts in the order they depend on each other: the data first, then the logic, and the reading and printing last. Run the program after each piece.

1. `Game`: a constructor, getters and a toString. Try it with `System.out.println(new Game("Azul", 35));`.
2. `GameNight`: the list, `add` and `count` first. Try them with a few calls in `main`, then add `totalMinutes` and `longest`, one at a time.
3. The input part: a loop that reads lines until an empty one, splits each line and adds a Game.

While `GameNight` is being written, `main` is a **test drive**: a few calls whose answers you can check by hand.

```java
GameNight night = new GameNight();
night.add(new Game("Azul", 35));
night.add(new Game("Carcassonne", 50));
System.out.println(night.count() + " " + night.totalMinutes());
System.out.println(night.longest());
```

A method you haven't written yet can get a **placeholder**: a body that only returns something of the right type, such as `return 0;` or `return null;`. Then the class compiles, and the methods that are ready can be tried. (A method that returns a value can't be left empty: javac says `missing return statement`.) Come back to every placeholder, though: its answer is wrong.

When each piece works on its own, `main` gets its real job. Here's the finished program:

**Main.java**

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameNight night = new GameNight();
        while (true) {
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                break;
            }
            String[] parts = line.split(",");
            night.add(new Game(parts[0], Integer.valueOf(parts[1])));
        }
        System.out.println("Games played: " + night.count());
        System.out.println("Minutes in all: " + night.totalMinutes());
        System.out.println("Longest: " + night.longest());
    }
}
```

**Game.java**

```java
public class Game {
    private String name;
    private int minutes;

    public Game(String name, int minutes) {
        this.name = name;
        this.minutes = minutes;
    }

    public String getName() {
        return this.name;
    }

    public int getMinutes() {
        return this.minutes;
    }

    public String toString() {
        return this.name + " (" + this.minutes + " min)";
    }
}
```

**GameNight.java**

```java
import java.util.ArrayList;

public class GameNight {
    private ArrayList<Game> games;

    public GameNight() {
        this.games = new ArrayList<>();
    }

    public void add(Game game) {
        this.games.add(game);
    }

    public int count() {
        return this.games.size();
    }

    public int totalMinutes() {
        int total = 0;
        for (Game game : this.games) {
            total += game.getMinutes();
        }
        return total;
    }

    public Game longest() {
        Game longest = null;
        for (Game game : this.games) {
            if (longest == null || game.getMinutes() > longest.getMinutes()) {
                longest = game;
            }
        }
        return longest;
    }
}
```

**Input**

```text
Azul,35
Carcassonne,50
Hanabi,25
Codenames,20
(an empty line)
```

**Output**

```text
Games played: 4
Minutes in all: 130
Longest: Carcassonne (50 min)
```

- Each class is small, and each has one job. `Game` knows one game, `GameNight` answers questions about all of them, and `main` reads and prints.
- `longest` starts from `null`, which means "no game yet", so the first game always becomes the longest so far. With no games at all, it returns `null`.
- If the program misbehaves now, the classes are already known to work from their test drives, so the mistake is most likely in the part written last.

---

Source: [From a description to a plan](https://javaarena.com/learn/larger-programs/planning/) in the module [Larger programs](https://javaarena.com/learn/larger-programs/) on Java Arena.

This module follows sections [7.3 Larger programming exercises](https://java-programming.mooc.fi/part-7/3-larger-exercises), [7.4 Conclusion](https://java-programming.mooc.fi/part-7/4-java-programming) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
