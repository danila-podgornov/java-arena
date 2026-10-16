> [!info] AI-Generated

# A larger program across packages

Step 4's quiz asked a fixed set of questions once. This step's quiz is a whole small application: the user adds questions, players take turns, and the program remembers who did best. It has four classes in three packages, and Main:

- `quiz.domain`: Question, as before, and a new class Player, with a name and points.
- `quiz.logic`: Quiz, which keeps the questions and the players, checks the answers and finds the best player.
- `quiz.ui`: TextUI, which reads the commands.

The commands, each on a line of its own:

- `add`, then three lines: the question, its answer and its points; it prints how many questions there are
- `play`, then the player's name, then a reply to each question in turn
- `best`, for the player with the most points so far
- `quit`

**Main.java**

```java
import java.util.Scanner;
import quiz.logic.Quiz;
import quiz.ui.TextUI;

public class Main {
    public static void main(String[] args) {
        TextUI ui = new TextUI(new Scanner(System.in), new Quiz());
        ui.start();
    }
}
```

**quiz/ui/TextUI.java**

```java
package quiz.ui;

import java.util.Scanner;
import quiz.domain.Player;
import quiz.domain.Question;
import quiz.logic.Quiz;

public class TextUI {
    private Scanner scanner;
    private Quiz quiz;

    public TextUI(Scanner scanner, Quiz quiz) {
        this.scanner = scanner;
        this.quiz = quiz;
    }

    public void start() {
        while (true) {
            System.out.print("> ");
            String command = this.scanner.nextLine();
            if (command.equals("quit")) {
                System.out.println("Bye!");
                break;
            }
            if (command.equals("add")) {
                this.addQuestion();
            } else if (command.equals("play")) {
                this.play();
            } else if (command.equals("best")) {
                this.printBest();
            } else {
                System.out.println("Unknown command: " + command);
            }
        }
    }

    private void addQuestion() {
        String prompt = this.scanner.nextLine();
        String answer = this.scanner.nextLine();
        int points = Integer.valueOf(this.scanner.nextLine());
        this.quiz.addQuestion(new Question(prompt, answer, points));
        System.out.println("Questions: " + this.quiz.getQuestions().size());
    }

    private void play() {
        String name = this.scanner.nextLine();
        Player player = this.quiz.newPlayer(name);
        for (Question question : this.quiz.getQuestions()) {
            System.out.println(question);
            String reply = this.scanner.nextLine();
            if (this.quiz.answer(player, question, reply)) {
                System.out.println("Right!");
            } else {
                System.out.println("Not quite.");
            }
        }
        System.out.println(player);
    }

    private void printBest() {
        Player best = this.quiz.best();
        if (best == null) {
            System.out.println("No one has played yet");
        } else {
            System.out.println("Best: " + best);
        }
    }
}
```

**quiz/logic/Quiz.java**

```java
package quiz.logic;

import java.util.ArrayList;
import quiz.domain.Player;
import quiz.domain.Question;

public class Quiz {
    private ArrayList<Question> questions;
    private ArrayList<Player> players;

    public Quiz() {
        this.questions = new ArrayList<>();
        this.players = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        this.questions.add(question);
    }

    public ArrayList<Question> getQuestions() {
        return this.questions;
    }

    public Player newPlayer(String name) {
        Player player = new Player(name);
        this.players.add(player);
        return player;
    }

    public boolean answer(Player player, Question question, String reply) {
        if (question.isRight(reply)) {
            player.addPoints(question.getPoints());
            return true;
        }
        return false;
    }

    public Player best() {
        Player best = null;
        for (Player player : this.players) {
            if (best == null || player.getPoints() > best.getPoints()) {
                best = player;
            }
        }
        return best;
    }
}
```

**quiz/domain/Question.java**

```java
package quiz.domain;

public class Question {
    private String prompt;
    private String answer;
    private int points;

    public Question(String prompt, String answer, int points) {
        this.prompt = prompt;
        this.answer = answer;
        this.points = points;
    }

    public boolean isRight(String reply) {
        return reply.trim().equalsIgnoreCase(this.answer);
    }

    public int getPoints() {
        return this.points;
    }

    @Override
    public String toString() {
        return this.prompt + " (" + this.points + " points)";
    }
}
```

**quiz/domain/Player.java**

```java
package quiz.domain;

public class Player {
    private String name;
    private int points;

    public Player(String name) {
        this.name = name;
        this.points = 0;
    }

    public void addPoints(int points) {
        this.points += points;
    }

    public int getPoints() {
        return this.points;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.points + " points";
    }
}
```

**Input**

```text
best
add
Which planet is the largest?
Jupiter
2
add
What is the chemical symbol for gold?
Au
3
play
Ada
jupiter
Au
play
Ben
Saturn
au
best
quit
```

**Output**

```text
> No one has played yet
> Questions: 1
> Questions: 2
> Which planet is the largest? (2 points)
Right!
What is the chemical symbol for gold? (3 points)
Right!
Ada, 5 points
> Which planet is the largest? (2 points)
Not quite.
What is the chemical symbol for gold? (3 points)
Right!
Ben, 3 points
> Best: Ada, 5 points
> Bye!
```

## Following a command through the packages

Here's what happens for `play`, package by package:

1. TextUI reads the name and asks the logic for a new player: `this.quiz.newPlayer(name)`. Quiz creates the Player, a domain object, keeps it in its list of players, and returns it.
2. For each question, TextUI prints the question and reads the reply. `this.quiz.answer(player, question, reply)` decides: Quiz asks the Question whether the reply is right, and if it is, gives the Player the points.
3. TextUI prints `Right!` or `Not quite.`, and at the end the player.

Each package does its own part. The ui talks with the user, the logic decides, and the domain holds the data and knows its own rules. TextUI uses the domain objects only to show them and to pass them on: it never adds points itself.

Main is short again. It only makes the objects that the others need and starts the user interface. It imports only what it names itself: Scanner, Quiz and TextUI. Question and Player appear nowhere in `Main.java`, so they need no import there.

## Private helper methods

In TextUI, `start()` only reads a command and picks what to do. The work of each command is in a method of its own: `addQuestion()`, `play()` and `printBest()`. They're `private`, because nothing outside TextUI needs them, and they keep `start()` short enough to read at a glance, however many commands the program gets.

## Growing the program: find the package first

Before writing a new feature, decide where each part of it belongs. Say the quiz should list every player. The players are already kept by Quiz, so giving them out is the logic's part. Printing them is the user interface's part. That's your task.

---

Source: [A larger program across packages](https://javaarena.com/learn/packages/larger-program/) in the module [Packages and imports](https://javaarena.com/learn/packages/) on Java Arena.

This module follows section [11.2 Packages](https://java-programming.mooc.fi/part-11/2-packages) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
