> [!info] AI-Generated

# A first window

Every program in this course so far has used the console: it printed lines of text and read the lines you typed, one after another. Most programs that people use every day look different. They open a **window** with text, buttons and fields to type in, and the user clicks and types wherever they like, in any order. That's a **graphical user interface**, or GUI for short. Part 13 builds them with **JavaFX**, a Java library for windows.

## JavaFX in Java Arena

JavaFX isn't part of Java itself: it's a library that a program uses, as the tests of module 26 used JUnit. The Java that runs inside this page can't run the real JavaFX, so Java Arena has a practice version of it, written for this site. It has the classes and methods that these lessons use, under JavaFX's own names, so the code you write here is ordinary JavaFX code. The page then draws the window your program shows. The drawing is approximate: the real JavaFX has its own fonts, colors and sizes.

You can click the buttons and type in the fields of a window drawn on this page. Each time you do, Java Arena runs your program again from the start, with all your earlier clicks and typing, and draws the window as it is after them. (In this module, clicking a button doesn't do anything yet. Module 49 makes buttons do things.)

On your own computer, the same code runs with the real JavaFX. Installing it is a separate step, which the MOOC describes in [its section 13.1](https://java-programming.mooc.fi/part-13/1-graphical-user-interfaces). A check runs every model solution of these lessons on the real JavaFX too, and confirms that it shows the same window contents there.

## A program with a window

A bus stop gets a small screen that shows the next bus:

```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Label next = new Label("Line 4 to Harbor Square: 7:15");
        stage.setScene(new Scene(next));
        stage.setTitle("Stop 14");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

The examples in these lessons show the window under the code, drawn as the program leaves it, with "The window as text" under the drawing (step 2 explains it). Here's the program, part by part:

- `public class Main extends Application`: `Application` is JavaFX's class for a program with windows, and Main inherits from it (module 34). Application is abstract, and its one abstract method is `start`, so Main has to write that method.
- `public void start(Stage stage)`: a **Stage** is a window. JavaFX makes the program's main window and calls `start` with it. What happens next is up to `start`: this one puts a label into the window, gives the window a title and shows it.
- `new Label("Line 4 to Harbor Square: 7:15")`: a **label** is a piece of text in a window, for the user to read but not to change.
- `stage.setScene(new Scene(next))`: a window shows a **Scene**, which holds what's in the window. This scene holds just the label. Step 2 puts more into a scene.
- `stage.setTitle("Stop 14")` sets the text in the window's title bar.
- `stage.show()` shows the window. Until then it's hidden: a `start` that never calls `show()` runs to its end, and no window appears.
- `launch(Main.class)` in `main` starts JavaFX. `launch` is a static method of Application, so Main can call it by its name alone. `Main.class` names the class itself, not an object of it: `launch` creates the Main object, gets the main window ready and calls `start`.
- Every JavaFX class the program names needs its import. Application, Scene, Label and Stage are in four packages (module 41), all starting with `javafx.`.

JavaFX creates the Main object itself, with the constructor that takes no values. So the class must be `public`, and it must have such a constructor. A class without a constructor of its own has one: Java's default constructor.

## When the program ends

Where does the program go after `start`? Here each part prints a line, so you can follow it:

```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Label next = new Label("Line 4 to Harbor Square: 7:15");
        stage.setScene(new Scene(next));
        stage.setTitle("Stop 14");
        stage.show();
        System.out.println("start: the window is ready");
    }

    public static void main(String[] args) {
        System.out.println("main: before launch");
        launch(Main.class);
        System.out.println("main: after launch");
    }
}
```

**Output**

```text
main: before launch
start: the window is ready
main: after launch
```

`launch` calls `start`, and then it waits. On your own computer, the window stays open while the user reads, clicks and types, and `launch` returns only when the user closes the window. Then `main` goes on after the call, and the program ends. In Java Arena, a run ends after `start` and the clicks and typing it replays: Java Arena records the window as it is, then closes it for you, so `launch` returns and `main` goes on.

---

Source: [A first window](https://javaarena.com/learn/gui-basics/first-window/) in the module [GUI: windows, components and layouts](https://javaarena.com/learn/gui-basics/) on Java Arena.

This module follows sections [13.1 Graphical user interfaces](https://java-programming.mooc.fi/part-13/1-graphical-user-interfaces), [13.2 UI components and their layout](https://java-programming.mooc.fi/part-13/2-UI-components-and-layout) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
