> [!info] AI-Generated

# Packages: classes in folders

Every program so far kept its files side by side: `Main.java`, `Heater.java`, `BankAccount.java`, all at the top. That's fine for five classes. A real program can have hundreds, and Java sorts them into **packages**: named groups of classes that belong together, each package in a folder of its own.

You've used packages since module 2. `import java.util.Scanner;` names the class `Scanner` of the package `java.util`, which holds Scanner, the lists, the maps and many other tools of Java's library. This module puts your own classes in packages.

## The package line

A quiz app has questions, and each question checks the player's reply. Here's the start of the class `Question`, in the package `quiz.domain`:

```java
package quiz.domain;

public class Question {
    ...
}
```

- The first line of code says which package the class is in: `package quiz.domain;`. Only comments may come before it.
- The file's folders match the package. Each part of the name is a folder, and the dot goes one folder deeper: `Question.java` is in the folder `domain`, which is in the folder `quiz`. The file's path in the program is `quiz/domain/Question.java`.
- Package names are written in small letters, by custom everywhere, and this site requires it. On this site, a folder name is a Java name that starts with a small letter, followed by small letters, digits or `_`, and it can't be a word Java reserves, such as `class` or `new`.
- The word *domain* is often used for the classes of the things a program is about, here the questions. Step 4 comes back to it.

## A class's full name

Here's the whole program. `Main.java` stays where it has always been, at the top, with no package line:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        quiz.domain.Question question = new quiz.domain.Question("Which planet is the largest?", "Jupiter", 2);
        System.out.println(question);
        System.out.println(question.isRight(" jupiter"));
        System.out.println(question.isRight("Saturn"));
        System.out.println(question.getClass().getName());
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

**Output**

```text
Which planet is the largest? (2 points)
true
false
quiz.domain.Question
```

- A class's **full name** is its package, a dot and its own name: `quiz.domain.Question`. Main is in another package, so here it writes the full name, both as the variable's type and after `new`. Step 2 shows a shorter way.
- `getClass().getName()` (module 34) gives the object's class by its full name.
- Inside its package, Question is written like every class you've written: instance variables, a constructor and methods. Only the first line is new.
- `isRight` removes spaces around the reply with `trim()` and ignores capital letters, so ` jupiter` counts.
- Question, its constructor and its methods are `public`, so Main, in another package, can use them. Step 3 explains why that matters.

A full name tells apart classes that share a simple name. A survey app could have its own class `Question` in a package `survey`: `survey.Question` and `quiz.domain.Question` are two different classes, and one program can use both. Java's own library has two types called `List`, for example: the interface `java.util.List` of module 35, and the class `java.awt.List`, a list shown in a window.

## The default package

Every class you wrote before this module had no package line. A class without one is in the **default package**, a package without a name, and its full name is just its own name: `Heater`, `Main`. On this site, `Main` always stays there, at the top of the program, because the site starts every program from the class `Main`.

Classes of the same package use each other by their simple names, with nothing more. That's why your classes could always use each other: they were all in the default package. Inside `quiz.domain` it's the same: a class `Round` in that package could simply write `Question`.

## Files in folders on this site

In a challenge, each file has a tab of its own, and a file in a folder shows its folders above its name, in small letters: `quiz/domain/` over `Question.java`. javac's messages name a file by its path, such as `quiz/domain/Question.java`.

---

Source: [Packages: classes in folders](https://javaarena.com/learn/packages/package-line/) in the module [Packages and imports](https://javaarena.com/learn/packages/) on Java Arena.

This module follows section [11.2 Packages](https://java-programming.mooc.fi/part-11/2-packages) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
