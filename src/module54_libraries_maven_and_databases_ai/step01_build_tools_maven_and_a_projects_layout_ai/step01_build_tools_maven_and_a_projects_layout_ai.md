> [!info] AI-Generated

# Build tools: Maven and a project's layout

Every program in this course so far was a few files that Java Arena compiled and ran for you. Real projects are bigger, and they almost never start from nothing: they use **libraries**, code that other people wrote, tested and packaged for anyone to use. You've used two already. JUnit (module 26) is a library for unit tests, and JavaFX (modules 48 to 53) is a library for windows. On this site they were simply there: Java Arena puts JUnit and its practice version of JavaFX on the class path for you.

On your own computer, someone has to download the right version of each library, put it where javac and java can find it, compile the files in the right order, run the tests and pack the result. A **build tool** does all of that from a description of the project. The MOOC's exercise templates use **Maven**, one of the two build tools most Java projects use (the other is Gradle).

This module is about the tools that sit around a program. Maven, libraries and databases need your own computer: nothing on this page runs Maven or opens a database. The programs you write here use only the JDK, and the "database" in them is a data access object that keeps its data in memory, in a list or a map. Each step says what you'd do on your own computer.

## A Maven project's folders

Maven expects every project to have the same folders, so anyone who knows Maven finds their way around a new project at once:

```text
repair-queue/
    pom.xml
    src/
        main/
            java/
                com/example/repairs/
                    Main.java
                    RepairJob.java
        test/
            java/
                com/example/repairs/
                    RepairJobTest.java
    target/
```

- `pom.xml` describes the project. It's at the top, in the project's own folder.
- `src/main/java` holds the program's own classes, in the folders of their packages (module 41): the class `com.example.repairs.Main` is in `src/main/java/com/example/repairs/Main.java`.
- `src/test/java` holds the test classes, in the same packages, so a test can use the classes it tests without imports, package-private parts included. They're compiled and run for the tests, and they aren't part of the finished program.
- `target` is where Maven puts what it makes: compiled classes, test reports and the finished jar. Maven creates it, and you can delete it any time: the next build makes it again.

## pom.xml

POM stands for Project Object Model. The file is written in XML, a text format of nested **elements**: `<version>1.0-SNAPSHOT</version>` is an element named `version` whose content is `1.0-SNAPSHOT`, and an element can hold other elements. A small `pom.xml` looks like this:

**pom.xml**

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.example</groupId>
    <artifactId>repair-queue</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.release>21</maven.compiler.release>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.13.2</version>
            <scope>test</scope>
        </dependency>
    </dependencies>
</project>
```

The first lines are the same in every pom.xml: they say which kind of XML file this is. The rest is about this project:

- **groupId, artifactId and version** name the project. The groupId is usually a domain name turned around, like a package name (`com.example`); the artifactId is the project's own name (`repair-queue`); the version is its version. `SNAPSHOT` at the end means "still being worked on": a finished release drops it (`1.0`).
- **properties** are settings. `maven.compiler.release` is the Java version to compile for, and the source encoding says the files are UTF-8.
- **dependencies** lists the libraries the project uses.

## A dependency

Every library is named the same three ways as the project itself. Those three names are a library's **coordinates**, often written on one line with colons between them: `junit:junit:4.13.2`, or `com.h2database:h2:2.2.224` for the database library of step 4. To use a library, you add a `dependency` element with its coordinates inside `dependencies`:

```xml
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <version>2.2.224</version>
</dependency>
```

A dependency can also have a **scope**. JUnit's above is `<scope>test</scope>`: the library is there when the tests are compiled and run, and not in the program itself, since the program never uses JUnit. A dependency without a scope is there everywhere.

## Where libraries come from

Maven downloads libraries from **Maven Central**, a large public repository of Java libraries. You can search it at [central.sonatype.com](https://central.sonatype.com) or through [mvnrepository.com](https://mvnrepository.com), which the MOOC mentions; each library's page shows the `dependency` element to copy, with its newest version.

Maven keeps what it downloads on your computer, in a **local repository**: a folder named `.m2/repository` in your home folder. A jar's place there comes from its coordinates. The dots of the groupId become folders, then come a folder for the artifactId and one for the version, and the jar is named after the artifactId and the version. So `com.h2database:h2:2.2.224` is kept as:

```text
.m2/repository/com/h2database/h2/2.2.224/h2-2.2.224.jar
```

The next build finds it there and downloads nothing. A library can need libraries of its own: JUnit 4.13.2 needs Hamcrest Core 1.3, so Maven downloads that too, without a line about it in your pom.xml. These are called **transitive dependencies**.

## On your own computer

To build a Maven project on your own computer, install a JDK (version 21, as on this site) and Maven 3.9 or newer, or an editor that comes with Maven, such as IntelliJ IDEA, NetBeans (which the MOOC uses) or VS Code with its Java extensions. These editors open a folder with a pom.xml as a project and run Maven for you from their menus. In a terminal, in the project's folder:

**Commands for your own computer**

```text
mvn compile
mvn test
mvn package
mvn compile exec:java -Dexec.mainClass=com.example.repairs.Main
```

- `mvn compile` downloads what's missing and compiles `src/main/java` into `target/classes`.
- `mvn test` compiles the tests too and runs them, with a report of what passed.
- `mvn package` does both and packs the program into a jar in `target` (step 5).
- The last line runs the program's `main` with the exec plugin, which Maven downloads the first time.

The first build takes a while, since Maven downloads its own plugins too; later ones are fast. The MOOC's [section 14.4](https://java-programming.mooc.fi/part-14/4-maven-and-third-party-libraries) shows how its exercise templates use Maven.

## And here

Java Arena runs no Maven. It compiles your files with javac, and JUnit and its practice JavaFX are already on the class path. The folders of packages still work the same way here as on your own computer, and the files of a challenge are what would go in `src/main/java`.

---

Source: [Build tools: Maven and a project's layout](https://javaarena.com/learn/libraries-and-tools/build-tools/) in the module [Libraries, Maven and databases](https://javaarena.com/learn/libraries-and-tools/) on Java Arena.

This module follows sections [14.4 Maven and third-party libraries](https://java-programming.mooc.fi/part-14/4-maven-and-third-party-libraries), [14.5 Conclusion](https://java-programming.mooc.fi/part-14/5-conclusion) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
