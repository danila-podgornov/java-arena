> [!info] AI-Generated

# Several objects

One class can make as many objects as a program needs, and each object keeps its own state: calling a method on one of them never changes the others. The values for new objects often come from the user:

**Main.java**

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("First plant:");
        String first = scanner.nextLine();
        System.out.println("Second plant:");
        String second = scanner.nextLine();

        Plant left = new Plant(first, 10);
        Plant right = new Plant(second, 10);
        left.grow(8);
        right.grow(3);
        left.cut(12);
        left.printInfo();
        right.printInfo();
    }
}
```

**Plant.java**

```java
public class Plant {
    private String name;
    private int height;

    public Plant(String name, int height) {
        this.name = name;
        this.height = height;
    }

    public void printInfo() {
        System.out.println(this.name + ", " + this.height + " cm");
    }

    public void grow(int cm) {
        this.height = this.height + cm;
    }

    public void cut(int cm) {
        this.height = this.height - cm;
        if (this.height < 5) {
            this.height = 5;
        }
    }
}
```

**Input**

```text
mint
basil
```

**Output**

```text
First plant:
Second plant:
mint, 6 cm
basil, 13 cm
```

- `left` and `right` are built from the same class, with names read from the user, and each has its own `name` and `height`.
- `left.grow(8)` and `left.cut(12)` change only `left`: the variable in front of the dot decides which object a method works on. `right` only grew by 3.

A program can use as many classes as it needs, each in its own file next to `Main.java`, and `main` can make objects of all of them: a garden program could have a `Plant` class and a `Lamp` class, and create a few of each. Module 19 shows how to keep any number of objects in a list.

---

Source: [Several objects](https://javaarena.com/learn/classes/several-objects/) in the module [Classes and objects](https://javaarena.com/learn/classes/) on Java Arena.

This module follows section [4.1 Introduction to object-oriented programming](https://java-programming.mooc.fi/part-4/1-introduction-to-object-oriented-programming) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
