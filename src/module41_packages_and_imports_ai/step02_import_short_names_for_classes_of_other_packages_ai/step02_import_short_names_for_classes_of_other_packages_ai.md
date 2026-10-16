> [!info] AI-Generated

# import: short names for classes of other packages

Writing `quiz.domain.Question` every time gets long. An **import** line at the top of a file lets the file's code use a class of another package by its simple name.

## import

The quiz gets a second package, `quiz.logic`, with a class `Scorer` that adds up the points of the right answers. Main uses both classes, and imports both:

**Main.java**

```java
import quiz.domain.Question;
import quiz.logic.Scorer;

public class Main {
    public static void main(String[] args) {
        Question planet = new Question("Which planet is the largest?", "Jupiter", 2);
        Question gold = new Question("What is the chemical symbol for gold?", "Au", 3);
        Scorer scorer = new Scorer();
        System.out.println(scorer.answer(planet, "Jupiter"));
        System.out.println(scorer.answer(gold, "Ag"));
        System.out.println("Score: " + scorer.getScore());
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

**quiz/logic/Scorer.java**

```java
package quiz.logic;

import quiz.domain.Question;

public class Scorer {
    private int score;

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

**Output**

```text
true
false
Score: 2
```

- `import quiz.domain.Question;` names a class by its full name. From then on, the file's code says just `Question`.
- An import counts only in its own file. Main imports Question for itself, and `Scorer.java` imports it again, since Scorer uses it too. Each file lists what it uses from other packages.
- In a file with a package line, the order is fixed: the package line, then the imports, then the class.
- An import copies nothing into the program and makes it no bigger. It only tells javac which class a simple name means.
- A class of the file's own package needs no import.

## A forgotten import

Without `import quiz.logic.Scorer;`, javac looks for a Scorer in Main's own package and in the imports, and finds none:

**Main.java**

```java
import quiz.domain.Question;

public class Main {
    public static void main(String[] args) {
        Question planet = new Question("Which planet is the largest?", "Jupiter", 2);
        Scorer scorer = new Scorer();
        System.out.println(scorer.answer(planet, "Jupiter"));
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

    public boolean answer(Question question, String reply) {
        if (question.isRight(reply)) {
            this.score += question.getPoints();
            return true;
        }
        return false;
    }
}
```

**What javac prints**

```text
Main.java:6: error: cannot find symbol
        Scorer scorer = new Scorer();
        ^
  symbol:   class Scorer
  location: class Main
Main.java:6: error: cannot find symbol
        Scorer scorer = new Scorer();
                            ^
  symbol:   class Scorer
  location: class Main
2 errors
```

`cannot find symbol` with `symbol: class Scorer` is the message for a class that javac doesn't know by that name. For a class of your own program, the fix is usually an import (or the full name).

## A whole package with *

`import quiz.domain.*;` imports every class of the package `quiz.domain` at once: the file can then use any of them by its simple name. Two things to know:

- The `*` covers the classes of that one package, not the packages in its folders. `import quiz.*;` doesn't import `quiz.domain.Question`. The quiz has no classes in the package `quiz` itself, so javac even says `package quiz does not exist`.
- Many programmers prefer one import per class, so that the top of a file lists exactly what the file uses. Programming editors write these lines for you. Both ways work the same.

## java.util was a package all along

`import java.util.Scanner;` and `import java.util.ArrayList;` are imports of classes of Java's package `java.util`, just like the imports above. `import java.util.*;` works too. And the classes you've used without any import, such as `String`, `Math`, `Integer` and `System`, are in the package `java.lang`, which every Java file imports automatically.

## Full names instead of an import

A full name works without any import, for Java's classes too:

```java
public class Main {
    public static void main(String[] args) {
        java.util.ArrayList<String> planets = new java.util.ArrayList<>();
        planets.add("Saturn");
        planets.add("Jupiter");
        planets.add("Mars");
        java.util.Collections.sort(planets);
        System.out.println(planets);
    }
}
```

**Output**

```text
[Jupiter, Mars, Saturn]
```

With imports this is easier to read, so full names are mostly used when two classes share a simple name. One file can't import both: after `import quiz.domain.Question;`, the name `Question` is taken, and `import survey.Question;` doesn't compile. javac says `a type with the same simple name is already defined by the single-type-import of Question`. The fix is to import one of them and write the other one's full name:

```java
import quiz.domain.Question;

...
Question planet = new Question("Which planet is the largest?", "Jupiter", 2);
survey.Question opinion = new survey.Question("Did you like the quiz?");
```

---

Source: [import: short names for classes of other packages](https://javaarena.com/learn/packages/import/) in the module [Packages and imports](https://javaarena.com/learn/packages/) on Java Arena.

This module follows section [11.2 Packages](https://java-programming.mooc.fi/part-11/2-packages) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
