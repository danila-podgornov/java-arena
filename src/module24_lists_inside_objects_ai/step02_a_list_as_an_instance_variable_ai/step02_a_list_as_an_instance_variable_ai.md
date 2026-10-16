> [!info] AI-Generated

# A list as an instance variable

A class can keep a list in an instance variable, just as it keeps a String or an int. Here a recipe has a name and a list of ingredients:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Recipe pancakes = new Recipe("Pancakes");
        pancakes.addIngredient("flour");
        pancakes.addIngredient("milk");
        pancakes.addIngredient("eggs");

        Recipe toast = new Recipe("Toast");
        toast.addIngredient("bread");
        toast.addIngredient("butter");

        System.out.println(pancakes.getName() + " needs " + pancakes.ingredientCount() + " ingredients");
        System.out.println(toast.getName() + " needs " + toast.ingredientCount() + " ingredients");
    }
}
```

**Recipe.java**

```java
import java.util.ArrayList;

public class Recipe {
    private String name;
    private ArrayList<String> ingredients;

    public Recipe(String name) {
        this.name = name;
        this.ingredients = new ArrayList<>();
    }

    public void addIngredient(String ingredient) {
        this.ingredients.add(ingredient);
    }

    public int ingredientCount() {
        return this.ingredients.size();
    }

    public String getName() {
        return this.name;
    }
}
```

**Output**

```text
Pancakes needs 3 ingredients
Toast needs 2 ingredients
```

- `import java.util.ArrayList;` is at the top of `Recipe.java`, because Recipe uses ArrayList. Each file imports what it uses. `Main.java` needs no import here: `main` never writes `ArrayList`.
- `private ArrayList<String> ingredients;` declares the instance variable. Like the others, it's private, so code outside Recipe can't reach the list.
- The constructor makes the list: `this.ingredients = new ArrayList<>();`. The constructor runs once for each new Recipe, so each recipe gets a new, empty list of its own. The pancakes' three ingredients never mix with the toast's two.
- The methods use the list through `this.ingredients`, like any other instance variable. `addIngredient` passes the ingredient on to the list's `add`, and `ingredientCount` returns the list's `size()`.

`main` never touches the list itself: it asks the recipe. So the recipe's methods decide what can be done with its ingredients. This Recipe can add and count them, and nothing else. There's no way to remove an ingredient, because Recipe has no method for that.

## Forgetting to make the list

Declaring the instance variable doesn't make a list. `private ArrayList<String> ingredients;` only says what the variable can refer to, and an instance variable of a class type is `null` until something gives it an object (module 22). If the constructor leaves out `new ArrayList<>()`, the first `add` crashes:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Recipe salad = new Recipe("Salad");
        salad.addIngredient("lettuce");
        System.out.println(salad.ingredientCount());
    }
}
```

**Recipe.java**

```java
import java.util.ArrayList;

public class Recipe {
    private String name;
    private ArrayList<String> ingredients;

    public Recipe(String name) {
        this.name = name;
    }

    public void addIngredient(String ingredient) {
        this.ingredients.add(ingredient);
    }

    public int ingredientCount() {
        return this.ingredients.size();
    }
}
```

**The program crashes with**

```text
Exception in thread "main" java.lang.NullPointerException: Cannot invoke "java.util.ArrayList.add(Object)" because "this.ingredients" is null
	at Recipe.addIngredient(Recipe.java:12)
	at Main.main(Main.java:4)
```

The message names the instance variable that was null, `this.ingredients`. The first `at` line says where it happened: in `addIngredient`, line 12 of `Recipe.java`. The line below says who called it: `main`, on line 4. The fix is in neither place, though. It's the missing line in the constructor, where the recipe should have gotten its list.

---

Source: [A list as an instance variable](https://javaarena.com/learn/objects-with-lists/list-as-instance-variable/) in the module [Lists inside objects](https://javaarena.com/learn/objects-with-lists/) on Java Arena.

This module follows section [6.1 Objects on a list and a list as part of an object](https://java-programming.mooc.fi/part-6/1-objects-within-objects) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
