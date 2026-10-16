> [!info] AI-Generated

# Packaging, other tools, and the end of the course

A finished program should run on computers that have no editor and no Maven, only Java. The last bits of section 14.4 are how to pack a program for that, and a few more tools worth knowing.

## A jar

A **jar** (Java archive) is a zip file of compiled classes, with a small text file inside, the **manifest**, that can name the class whose `main` starts the program. The JDK can make one on its own, with no Maven:

**Commands for your own computer**

```text
javac -d classes src/main/java/com/example/repairs/*.java
jar --create --file repairs.jar --main-class com.example.repairs.Main -C classes .
java -jar repairs.jar
```

The first line compiles the classes into the folder `classes`, the second packs that folder into `repairs.jar` with `Main` as its start, and the third runs it on any computer with Java installed.

In a Maven project, `mvn package` makes `target/repair-queue-1.0-SNAPSHOT.jar` (the artifactId and the version). To name the main class in its manifest, pom.xml gets a `build` section that configures the plugin that makes the jar:

```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-jar-plugin</artifactId>
            <version>3.3.0</version>
            <configuration>
                <archive>
                    <manifest>
                        <mainClass>com.example.repairs.Main</mainClass>
                    </manifest>
                </archive>
            </configuration>
        </plugin>
    </plugins>
</build>
```

That jar holds only the project's own classes. A program with libraries, such as H2, also needs their jars when it runs: plugins such as the Maven Shade Plugin or the Maven Assembly Plugin make one bigger jar with the libraries inside. And the JDK's `jpackage` tool makes an installer for the system you run it on (Windows, macOS or Linux) that brings its own Java along, so the person installing it doesn't need Java at all. The MOOC's [section 14.4](https://java-programming.mooc.fi/part-14/4-maven-and-third-party-libraries) points to more packaging tools.

## Other tools, in a sentence each

- **Gradle** does what Maven does, with build files written as code instead of XML; Android apps are built with it.
- **An IDE** (IntelliJ IDEA, NetBeans, Eclipse, VS Code with Java extensions) compiles as you type, runs and debugs programs step by step, and runs Maven or Gradle for you.
- **Git** keeps every version of a project's files, so you can go back to any of them and work on a project together with others.
- **JUnit** (module 26) runs a project's tests; with Maven, `mvn test` runs them all.
- **JavaFX** on your own computer is a library like any other: the dependency `org.openjfx:javafx-controls`, with the `javafx-maven-plugin` to run it with `mvn javafx:run` (module 48 links to the MOOC's instructions).
- **Libraries for almost everything**: reading JSON, talking to web services, writing web servers, making games (the MOOC mentions FXGL, a game library built on JavaFX). Search Maven Central, read the library's guide, and start with its smallest example.

## The end of the course

This was the last section of the MOOC's material, and the last module of the course here. Looking back over the 54 modules:

- **Parts 1 to 3**: printing, reading input, variables and calculations, decisions, loops, methods and return values, finding bugs, lists, arrays and strings. The tools every program is made of.
- **Parts 4 to 7**: classes and objects, constructors, getters and `toString`, objects in lists, files, references and `null`, objects working together, a user interface kept apart from the logic, unit tests, sorting and searching, and planning larger programs.
- **Parts 8 to 10**: hash maps, `equals` and `hashCode`, inheritance, abstract classes, interfaces and polymorphism, streams and lambdas, `Comparable` and `Comparator`, StringBuilder, regular expressions and enums.
- **Parts 11 and 12**: class diagrams, packages, exceptions, writing files, type parameters, a list and a hash map of your own, random numbers and two-dimensional arrays.
- **Parts 13 and 14**: windows with JavaFX, events and views, charts, drawing and images, a game with shapes, keys and a game loop, and, in this module, build tools, libraries, DAOs and databases.

## What next

The best next step is a small project of your own, in a Maven project on your own computer: a tracker for something you collect, a game you'd like to play, a tool that tidies a file you use. You'll get stuck, look things up and get unstuck, and that's most of what programming is. Then, depending on what you liked:

- **Databases and SQL**, to go further than this module's peek: designing tables and writing queries.
- **Data structures and algorithms**: how lists, hash maps and trees work inside, and how fast a program is as its data grows.
- **Web programming**: servers written in Java (or another language), and pages that talk to them.
- **Newer Java**: records, `switch` expressions, `var`, text blocks and sealed types. This site's course plan lists extra modules on these after this one, beyond the MOOC's material.

The MOOC ends with its own [conclusion](https://java-programming.mooc.fi/part-14/5-conclusion), a short page to read on its site. Thank you for working through the course here.

---

Source: [Packaging, other tools, and the end of the course](https://javaarena.com/learn/libraries-and-tools/packaging-and-the-end/) in the module [Libraries, Maven and databases](https://javaarena.com/learn/libraries-and-tools/) on Java Arena.

This module follows sections [14.4 Maven and third-party libraries](https://java-programming.mooc.fi/part-14/4-maven-and-third-party-libraries), [14.5 Conclusion](https://java-programming.mooc.fi/part-14/5-conclusion) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
