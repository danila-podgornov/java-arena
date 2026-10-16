> [!info] AI-Generated

# Several values for each object

Most objects hold more than one value, and their constructors take several parameters. To create them from the user's input, the loop reads the values one after the other. The name comes first, because the empty line that ends the input comes where a name would:

**Main.java**

```java
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Pet> pets = new ArrayList<>();

        while (true) {
            String name = scanner.nextLine();
            if (name.isEmpty()) {
                break;
            }
            int age = Integer.valueOf(scanner.nextLine());
            pets.add(new Pet(name, age));
        }

        for (Pet pet : pets) {
            System.out.println(pet);
        }
    }
}
```

**Pet.java**

```java
public class Pet {
    private String name;
    private int age;

    public Pet(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String toString() {
        return this.name + ", " + this.age + " years old";
    }
}
```

**Input**

```text
Rex
4
Misty
2
Kiwi
11
(an empty line)
```

**Output**

```text
Rex, 4 years old
Misty, 2 years old
Kiwi, 11 years old
```

- Each round reads a name and checks it first. Only when there is a pet does the program read its age, with `Integer.valueOf(scanner.nextLine())`.
- `new Pet(name, age)` gives the values in the order of the constructor's parameters, `Pet(String name, int age)`. `new Pet(age, name)` doesn't compile, since the first parameter must be a String.
- The values are needed only to create the object, so they can live in variables that last one round.

## Several values on one line

Data often comes with all of an object's values on one line, like `Rex,4`. Then each round reads one line and splits it, as in module 16:

```java
while (true) {
    String line = scanner.nextLine();
    if (line.isEmpty()) {
        break;
    }
    String[] parts = line.split(",");
    pets.add(new Pet(parts[0], Integer.valueOf(parts[1])));
}
```

The constructor doesn't care where its values come from: typed on lines of their own, split from one line, or written in the program.

---

Source: [Several values for each object](https://javaarena.com/learn/lists-of-objects/several-values-each/) in the module [Objects in a list](https://javaarena.com/learn/lists-of-objects/) on Java Arena.

This module follows section [4.2 Objects in a list](https://java-programming.mooc.fi/part-4/2-objects-in-a-list) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
