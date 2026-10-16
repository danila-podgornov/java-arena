> [!info] AI-Generated

# Packages by responsibility

Module 25 split a program into a user interface and its logic, each in a class of its own. Packages make that split visible in the folders. A common layout has three packages, each with one responsibility, inside a package named after the program:

- `quiz.domain`: the classes of the things the program is about, such as a question. They hold their data and the rules about themselves, such as whether a reply is right.
- `quiz.logic`: what the program does with them. Here, a class `Quiz` keeps the questions, checks the answers and counts the score. The logic doesn't read input and doesn't print.
- `quiz.ui`: the user interface. `TextUI` reads what the user types, asks the logic to do the work, and prints the results.

`Main` stays at the top and puts the pieces together:

**Main.java**

```java
import java.util.Scanner;
import quiz.domain.Question;
import quiz.logic.Quiz;
import quiz.ui.TextUI;

public class Main {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        quiz.add(new Question("Which planet is the largest?", "Jupiter", 2));
        quiz.add(new Question("What is the chemical symbol for gold?", "Au", 3));
        quiz.add(new Question("How many legs does a spider have?", "8", 2));
        TextUI ui = new TextUI(new Scanner(System.in), quiz);
        ui.start();
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

**quiz/logic/Quiz.java**

```java
package quiz.logic;

import java.util.ArrayList;
import quiz.domain.Question;

public class Quiz {
    private ArrayList<Question> questions;
    private int score;

    public Quiz() {
        this.questions = new ArrayList<>();
        this.score = 0;
    }

    public void add(Question question) {
        this.questions.add(question);
    }

    public ArrayList<Question> getQuestions() {
        return this.questions;
    }

    public boolean answer(Question question, String reply) {
        if (question.isRight(reply)) {
            this.score += question.getPoints();
            return true;
        }
        return false;
    }

    public int getScore() {
        return this.score;
    }
}
```

**quiz/ui/TextUI.java**

```java
package quiz.ui;

import java.util.Scanner;
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
        for (Question question : this.quiz.getQuestions()) {
            System.out.println(question);
            System.out.print("> ");
            String reply = this.scanner.nextLine();
            if (this.quiz.answer(question, reply)) {
                System.out.println("Right!");
            } else {
                System.out.println("Not quite.");
            }
        }
        System.out.println("Your score: " + this.quiz.getScore());
    }
}
```

**Input**

```text
jupiter
Ag
8
```

**Output**

```text
Which planet is the largest? (2 points)
> Right!
What is the chemical symbol for gold? (3 points)
> Not quite.
How many legs does a spider have? (2 points)
> Right!
Your score: 4
```

Quiz never prints: `answer` returns `true` or `false`, and TextUI decides what to show. TextUI never counts points: it asks Quiz. And Question knows nothing of either of them.

## Which may use which

The three packages use each other in one direction only:

- `ui` uses `logic`, and `domain` too: TextUI shows the questions.
- `logic` uses `domain`.
- `domain` uses neither of the others.

The imports at the top of each file show this at a glance. TextUI imports from `quiz.logic` and `quiz.domain`, Quiz from `quiz.domain`, and Question from nothing of the program. An import of `quiz.ui` in a file of `quiz.logic` or `quiz.domain` would mean that the direction is wrong.

Why one direction?

- The logic and the domain work with any user interface. The same Quiz could get a graphical one, like the programs with windows later in this course, or be run by tests, without a change to its code.
- A change in how the program looks touches only `ui`, and a change in its rules touches only `logic` or `domain`.
- Each package is small enough to read on its own. To see how the score is counted, open `logic`.

## Where does a change go?

| The change | The package, and where in it |
| --- | --- |
| A question gets a category, such as Science | `domain`: an instance variable and a getter in Question |
| A wrong answer costs one point | `logic`: the `answer` method of Quiz |
| The score is shown after every question | `ui`: the loop in TextUI's `start` |

---

Source: [Packages by responsibility](https://javaarena.com/learn/packages/layers/) in the module [Packages and imports](https://javaarena.com/learn/packages/) on Java Arena.

This module follows section [11.2 Packages](https://java-programming.mooc.fi/part-11/2-packages) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
