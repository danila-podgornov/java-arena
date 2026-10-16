> [!info] AI-Generated

# Access across packages

Module 34 listed four levels of access: `private`, nothing, `protected` and `public`. While every class was in the default package, only `private` made a difference. Writing nothing, or `protected`, let in the whole package, and the whole program was one package. With packages, the other levels start to matter.

## public and package-private

A class, or a class's constructor, method or variable, with no word in front of it is **package-private**: only the classes of its own package can use it. From another package, only what's `public` can be used. A constructor without `public` is an easy mistake to make, since until now it changed nothing:

**Main.java**

```java
import quiz.domain.Question;

public class Main {
    public static void main(String[] args) {
        Question planet = new Question("Which planet is the largest?", "Jupiter", 2);
        System.out.println(planet);
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

    Question(String prompt, String answer, int points) {
        this.prompt = prompt;
        this.answer = answer;
        this.points = points;
    }

    @Override
    public String toString() {
        return this.prompt + " (" + this.points + " points)";
    }
}
```

**What javac prints**

```text
Main.java:5: error: Question(String,String,int) is not public in Question; cannot be accessed from outside package
        Question planet = new Question("Which planet is the largest?", "Jupiter", 2);
                          ^
1 error
```

The message names the constructor by its parameter types, and the fix is `public Question(...)`. The same rule holds for the rest of a class:

- A method without `public` gives `getPoints() is not public in Question; cannot be accessed from outside package`.
- A class written `class Question`, without `public`, can't be used outside its package at all, not even named in an import: `Question is not public in quiz.domain; cannot be accessed from outside package`.

So a class that other packages use is `public`, and so are the constructors and methods they call. Instance variables stay `private`, as always.

## Package-private on purpose

Sometimes a class is meant only for its own package. The quiz's Scorer now also finds the best streak, the most right answers in a row. It leaves the counting to a small helper class, `Streak`, which has no `public` anywhere:

**Main.java**

```java
import quiz.domain.Question;
import quiz.logic.Scorer;

public class Main {
    public static void main(String[] args) {
        Question planet = new Question("Which planet is the largest?", "Jupiter", 2);
        Question gold = new Question("What is the chemical symbol for gold?", "Au", 3);
        Question spider = new Question("How many legs does a spider have?", "8", 2);
        Scorer scorer = new Scorer();
        scorer.answer(planet, "Jupiter");
        scorer.answer(gold, "Au");
        scorer.answer(spider, "6");
        scorer.answer(planet, "jupiter");
        System.out.println("Score: " + scorer.getScore());
        System.out.println("Best streak: " + scorer.getBestStreak());
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
}
```

**quiz/logic/Scorer.java**

```java
package quiz.logic;

import quiz.domain.Question;

public class Scorer {
    private int score;
    private Streak streak;

    public Scorer() {
        this.score = 0;
        this.streak = new Streak();
    }

    public boolean answer(Question question, String reply) {
        if (question.isRight(reply)) {
            this.score += question.getPoints();
            this.streak.right();
            return true;
        }
        this.streak.wrong();
        return false;
    }

    public int getScore() {
        return this.score;
    }

    public int getBestStreak() {
        return this.streak.getBest();
    }
}
```

**quiz/logic/Streak.java**

```java
package quiz.logic;

class Streak {
    private int current;
    private int best;

    void right() {
        this.current++;
        if (this.current > this.best) {
            this.best = this.current;
        }
    }

    void wrong() {
        this.current = 0;
    }

    int getBest() {
        return this.best;
    }
}
```

**Output**

```text
Score: 7
Best streak: 2
```

- Scorer and Streak are in the same package, `quiz.logic`, so Scorer uses everything Streak has.
- Main can't import Streak or write `quiz.logic.Streak`: javac would say `Streak is not public in quiz.logic; cannot be accessed from outside package`. Main works through Scorer's public methods.
- A package's public classes are what the rest of the program uses. Its package-private classes are details: the package can change or remove them, and nothing outside can break, since nothing outside can use them. It's the idea of `private`, one level up: from a class to a package.

## protected across packages

`protected` lets in the classes of its package, and also the subclasses, even those in other packages. Say a question's `getAnswer()` is `protected`: most classes shouldn't peek at the answer, but a subclass may need it. A question with a hint, in a package `quiz.hints` of its own, gives the answer's first letter:

**Main.java**

```java
import quiz.hints.HintedQuestion;

public class Main {
    public static void main(String[] args) {
        HintedQuestion planet = new HintedQuestion("Which planet is the largest?", "Jupiter", 2);
        System.out.println(planet.hint());
        System.out.println(planet.isRight("jupiter"));
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

    protected String getAnswer() {
        return this.answer;
    }
}
```

**quiz/hints/HintedQuestion.java**

```java
package quiz.hints;

import quiz.domain.Question;

public class HintedQuestion extends Question {
    public HintedQuestion(String prompt, String answer, int points) {
        super(prompt, answer, points);
    }

    public String hint() {
        return "It starts with " + this.getAnswer().charAt(0);
    }
}
```

**Output**

```text
It starts with J
true
```

HintedQuestion is in another package, but it's a subclass of Question, so it may call `getAnswer()`. Main is neither in `quiz.domain` nor a subclass: if it called `planet.getAnswer()`, javac would say `getAnswer() has protected access in Question`. Subclasses in other packages are common: a class of your own that extends a class of a library is one.

There's one limit. From another package, a subclass may use an object's protected method or variable only through its own type: for example on `this`, or on a variable whose type is `HintedQuestion` (or a class that extends it). On a variable of type `Question`, such as a parameter `Question other`, javac gives the same `getAnswer() has protected access in Question` that Main gets, even when the object in it is a HintedQuestion.

## The four levels, with packages

| Written in front | Its own class | Its package | Subclasses in other packages | Everyone else |
| --- | --- | --- | --- | --- |
| `private` | yes | no | no | no |
| nothing | yes | yes | no | no |
| `protected` | yes | yes | yes, through their own type | no |
| `public` | yes | yes | yes | yes |

The table is for classes and their members. A method an interface lists is public even with nothing written in front (module 35).

One more thing: `quiz` and `quiz.domain` are two separate packages. The folder `domain` is inside the folder `quiz`, but for access that means nothing: a class of the package `quiz` can't use what `quiz.domain` keeps package-private.

---

Source: [Access across packages](https://javaarena.com/learn/packages/access/) in the module [Packages and imports](https://javaarena.com/learn/packages/) on Java Arena.

This module follows section [11.2 Packages](https://java-programming.mooc.fi/part-11/2-packages) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
