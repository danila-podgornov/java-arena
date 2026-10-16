> [!info] AI-Generated

# Several objects working together

Programs are usually made of several classes, each with a job of its own, and their objects use each other. Here's a small football tournament:

- A `Team` keeps its own name and points.
- A `Match` knows its two teams and the goals they scored, and the rule for giving points: 3 to the winner, and 1 to each team for a draw.
- `main` only sets things up and prints.

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Team owls = new Team("Owls");
        Team foxes = new Team("Foxes");
        Team bears = new Team("Bears");

        Match first = new Match(owls, foxes, 2, 1);
        Match second = new Match(foxes, bears, 0, 0);
        Match third = new Match(bears, owls, 3, 1);
        first.givePoints();
        second.givePoints();
        third.givePoints();

        System.out.println(first);
        System.out.println(second);
        System.out.println(third);
        System.out.println(owls);
        System.out.println(foxes);
        System.out.println(bears);
    }
}
```

**Match.java**

```java
public class Match {
    private Team home;
    private Team away;
    private int homeGoals;
    private int awayGoals;

    public Match(Team home, Team away, int homeGoals, int awayGoals) {
        this.home = home;
        this.away = away;
        this.homeGoals = homeGoals;
        this.awayGoals = awayGoals;
    }

    public void givePoints() {
        if (this.homeGoals > this.awayGoals) {
            this.home.addPoints(3);
        } else if (this.awayGoals > this.homeGoals) {
            this.away.addPoints(3);
        } else {
            this.home.addPoints(1);
            this.away.addPoints(1);
        }
    }

    public String toString() {
        return this.home.getName() + " " + this.homeGoals + "-" + this.awayGoals + " " + this.away.getName();
    }
}
```

**Team.java**

```java
public class Team {
    private String name;
    private int points;

    public Team(String name) {
        this.name = name;
        this.points = 0;
    }

    public void addPoints(int points) {
        this.points = this.points + points;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return this.name + ", points: " + this.points;
    }
}
```

**Output**

```text
Owls 2-1 Foxes
Foxes 0-0 Bears
Bears 3-1 Owls
Owls, points: 3
Foxes, points: 1
Bears, points: 4
```

- A Match has two Team objects as instance variables (step 2). They aren't copies: `first` and `third` both refer to the one Owls object that `owls` refers to, so the points from both matches add up in the same team.
- `givePoints` changes the teams through their own method, `addPoints` (step 1). It can't touch a team's `points` directly, and it doesn't need to.
- The match's `toString` asks the teams for their names with `getName()`, because the result line should show only the names, not the points.

Each class does one job. Team doesn't know the rules of football, and Match doesn't keep a table. A tournament that gave 2 points for a win would change only `givePoints`.

## Planning a program of several classes

When you plan a program like this, go through its data and its rules. For each piece of data, ask which object it belongs to: the points belong to a team, the goals to a match. For each rule, ask which class knows enough to apply it: giving points needs both teams and both scores, and only a Match has all four. The class that has the data is usually the one that gets the method.

---

Source: [Several objects working together](https://javaarena.com/learn/object-interaction/objects-working-together/) in the module [Objects working together](https://javaarena.com/learn/object-interaction/) on Java Arena.

This module follows sections [5.4 Objects and references](https://java-programming.mooc.fi/part-5/4-objects-and-references), [5.5 Conclusion](https://java-programming.mooc.fi/part-5/5-conclusion) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
