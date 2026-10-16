> [!info] AI-Generated

# A text UI over a DAO

A DAO stores data; a user interface lets a person work with it. In module 25 a text UI read commands and called the program's logic. Here, the logic it calls is a DAO.

## The UI gets its DAO

The UI class keeps the DAO in an instance variable whose type is the **interface**, and gets it, like the Scanner, through its constructor:

**Main.java**

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RecipeDao recipes = new InMemoryRecipeDao();
        RecipeUi ui = new RecipeUi(recipes, new Scanner(System.in));
        ui.start();
    }
}
```

**RecipeUi.java**

```java
import java.util.List;
import java.util.Scanner;

public class RecipeUi {
    private RecipeDao recipes;
    private Scanner scanner;

    public RecipeUi(RecipeDao recipes, Scanner scanner) {
        this.recipes = recipes;
        this.scanner = scanner;
    }

    public void start() {
        while (true) {
            System.out.print("> ");
            String command = this.scanner.nextLine();
            if (command.equals("quit")) {
                System.out.println("Bye");
                break;
            }
            if (command.equals("list")) {
                list();
            } else if (command.equals("add")) {
                add();
            } else {
                System.out.println("Unknown command: " + command);
            }
        }
    }

    private void list() {
        List<Recipe> all = this.recipes.list();
        if (all.isEmpty()) {
            System.out.println("No recipes yet");
        }
        for (Recipe recipe : all) {
            System.out.println(recipe);
        }
    }

    private void add() {
        String name = this.scanner.nextLine();
        int minutes = Integer.valueOf(this.scanner.nextLine());
        int id = this.recipes.add(name, minutes);
        System.out.println("Saved as recipe " + id);
    }
}
```

**RecipeDao.java**

```java
import java.util.List;

public interface RecipeDao {
    List<Recipe> list();
    int add(String name, int minutes);
    Recipe findById(int id);
}
```

**InMemoryRecipeDao.java**

```java
import java.util.ArrayList;
import java.util.List;

public class InMemoryRecipeDao implements RecipeDao {
    private List<Recipe> recipes;
    private int nextId;

    public InMemoryRecipeDao() {
        this.recipes = new ArrayList<>();
        this.nextId = 1;
    }

    @Override
    public List<Recipe> list() {
        return new ArrayList<>(this.recipes);
    }

    @Override
    public int add(String name, int minutes) {
        int id = this.nextId;
        this.nextId++;
        this.recipes.add(new Recipe(id, name, minutes));
        return id;
    }

    @Override
    public Recipe findById(int id) {
        for (Recipe recipe : this.recipes) {
            if (recipe.getId() == id) {
                return recipe;
            }
        }
        return null;
    }
}
```

**Recipe.java**

```java
public class Recipe {
    private int id;
    private String name;
    private int minutes;

    public Recipe(int id, String name, int minutes) {
        this.id = id;
        this.name = name;
        this.minutes = minutes;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getMinutes() {
        return this.minutes;
    }

    @Override
    public String toString() {
        return "#" + this.id + " " + this.name + ", " + this.minutes + " min";
    }
}
```

**Input**

```text
list
add
Chickpea curry
40
add
Herb flatbread
20
list
curry
quit
```

**Output**

```text
> No recipes yet
> Saved as recipe 1
> Saved as recipe 2
> #1 Chickpea curry, 40 min
#2 Herb flatbread, 20 min
> Unknown command: curry
> Bye
```

As in module 25, the program prints `> ` before reading each command, and the output doesn't show what was typed. A command that needs more, such as `add`, reads it from the next lines, without prompts of its own.

## Who knows what

- **The UI** reads commands and prints answers. It doesn't know whether the recipes are in a list, a file or a database: it only calls the methods of `RecipeDao`.
- **The DAO** stores and finds recipes. It never reads input or prints anything.
- **`main`** is the only place that names `InMemoryRecipeDao`. It picks the DAO and the Scanner and hands both to the UI.

That last point is what makes the split pay off. On your own computer, `main` could create a DAO that uses a database (step 4) and pass that one instead: `RecipeUi` wouldn't change a line. A test can do the opposite: fill a DAO in memory with exactly the recipes it needs, and give the UI a Scanner that reads a String (module 26):

```java
RecipeDao recipes = new InMemoryRecipeDao();
recipes.add("Chickpea curry", 40);
RecipeUi ui = new RecipeUi(recipes, new Scanner("list\nquit\n"));
ui.start();
```

Passing an object the parts it needs, instead of letting it create them, is called **dependency injection**. Big frameworks do it automatically, but a constructor parameter is all it takes.

---

Source: [A text UI over a DAO](https://javaarena.com/learn/libraries-and-tools/text-ui-over-a-dao/) in the module [Libraries, Maven and databases](https://javaarena.com/learn/libraries-and-tools/) on Java Arena.

This module follows sections [14.4 Maven and third-party libraries](https://java-programming.mooc.fi/part-14/4-maven-and-third-party-libraries), [14.5 Conclusion](https://java-programming.mooc.fi/part-14/5-conclusion) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
