> [!info] AI-Generated

# Packages in practice

This last step looks at packages outside this site: how real projects arrange their folders, how packages are named, and the messages javac gives when something about packages goes wrong.

## The folders of a real project

On this site, a program's package folders start at the top, next to `Main.java`. A project on your own computer has a few more folders around them. Many Java projects are built with a build tool such as Maven or Gradle (a later module of this course sets up Maven), and both expect this layout:

- `src/main/java/quiz/domain/Question.java`
- `src/main/java/quiz/logic/Quiz.java`
- `src/main/java/quiz/ui/TextUI.java`
- `src/test/java/quiz/logic/QuizTest.java`

What the layout says:

- `src/main/java` holds the program's own classes, and the package folders start inside it. `Question.java` is still in `quiz/domain/`, and its package line is still `package quiz.domain;`.
- `src/test/java` holds the tests, in a folder tree of its own. A test class is in the same package as the class it tests: QuizTest is in `quiz.logic` too, so it can test Quiz's package-private parts as well.
- In a real program every class is in a package, `Main` too, often in the program's top package: `quiz.Main`. A class in a named package can't use a class of the default package at all, since no import can name it. The default package suits small programs, like the ones on this site, where nothing needs to use Main.
- A programming editor, such as NetBeans, IntelliJ IDEA or VS Code, shows the packages as a tree, and creates the folders and the package line when you make a class in a package.

## Naming packages

- Package names are all small letters, one short word for each part: `quiz.logic`, not `Quiz.Logic` or `quiz.gameLogic`.
- Many start with the internet domain of the organization that writes the code, turned around, so that the packages of two organizations never share a name. JUnit's classes, which module 26 imported, are in `org.junit`, and a company with the domain `example.com` would use packages like `com.example.quiz.logic`. Names that start with `java` belong to Java's own library.
- A package is named for what its classes do together. A small program splits into `domain`, `logic` and `ui`, as in this module. Bigger programs often have a package for each feature instead, such as `quiz.players` and `quiz.questions`. Either way, each package has one clear job.

## Messages you'll meet

| javac says | It usually means |
| --- | --- |
| `package quiz.domian does not exist` | a typo in an import or a full name |
| `cannot find symbol`, with `symbol: class Question` | an import is missing |
| `Question is not public in quiz.domain; cannot be accessed from outside package` | the class needs `public` |
| `getPoints() is not public in Question; cannot be accessed from outside package` | the method or constructor needs `public`, unless it's meant only for its own package |
| `getAnswer() has protected access in Question` | only its package and its subclasses may use it (a subclass only through its own type) |
| `file does not contain class quiz.domain.Question` | the file's package line doesn't match its folders |

The last one comes with more messages around it, such as `duplicate class` and `bad source file`. They all go away when the package line is right.

## This module in short

- A package line puts a class in a package, and the file's folders match it. A class's full name is its package and its own name. A class without a package line is in the default package.
- An import lets a file use a class of another package by its simple name, and `*` imports a whole package. `java.lang` is imported into every file.
- From another package, only public classes, constructors and methods can be used, and `protected` also lets in subclasses. What has no word in front in a class stays inside its package.
- A program splits into packages by responsibility, such as `domain`, `logic` and `ui`, which use each other in one direction.

---

Source: [Packages in practice](https://javaarena.com/learn/packages/in-practice/) in the module [Packages and imports](https://javaarena.com/learn/packages/) on Java Arena.

This module follows section [11.2 Packages](https://java-programming.mooc.fi/part-11/2-packages) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
