> [!info] AI-Generated

# Methods that go through the list

An object's methods can do anything with its list that code in `main` could: go through it with a loop, look for a value, count things. Here the recipe gets two more methods:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Recipe soup = new Recipe("Tomato soup");
        soup.addIngredient("tomatoes");
        soup.addIngredient("onion");
        soup.addIngredient("salt");
        soup.printIngredients();
        System.out.println(soup.needs("onion"));
        System.out.println(soup.needs("milk"));
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

    public void printIngredients() {
        System.out.println(this.name + ":");
        for (String ingredient : this.ingredients) {
            System.out.println("- " + ingredient);
        }
    }

    public boolean needs(String ingredient) {
        return this.ingredients.contains(ingredient);
    }
}
```

**Output**

```text
Tomato soup:
- tomatoes
- onion
- salt
true
false
```

- `for (String ingredient : this.ingredients)` goes through the recipe's own list. It's the loop you know from `main`; only the list is now `this.ingredients`.
- `printIngredients` is `void`: it prints, and returns nothing. It prints the recipe's name first, because a method can use all of its object's instance variables together.
- `needs` passes the question on to the list. `contains` goes through the list for you and compares with `equals` (module 23), so it finds `"onion"` however the String was made.

A method with its own name, such as `needs`, also says what the question means for a recipe. `soup.needs("onion")` reads better than a list call in `main`, and `main` doesn't need to know that the ingredients are kept in a list at all.

## A loop of your own

`contains` answers one question: is this exact value on the list? For any other question, write the loop yourself. This method tells whether any ingredient has a word in it, so that `needsAny("cheese")` is true for a recipe with `goat cheese`:

```java
public boolean needsAny(String word) {
    for (String ingredient : this.ingredients) {
        if (ingredient.contains(word)) {
            return true;
        }
    }
    return false;
}
```

Here `ingredient.contains(word)` is the String method from module 16: it looks for the word inside one ingredient's name. For a pie with `goat cheese` and `spinach`, `needsAny("cheese")` is `true`, while `needs("cheese")` is `false`, since no ingredient is exactly `cheese`. The `return true` in the loop ends the method as soon as one ingredient matches, and `return false` after the loop runs only when none did (module 11).

---

Source: [Methods that go through the list](https://javaarena.com/learn/objects-with-lists/going-through-the-list/) in the module [Lists inside objects](https://javaarena.com/learn/objects-with-lists/) on Java Arena.

This module follows section [6.1 Objects on a list and a list as part of an object](https://java-programming.mooc.fi/part-6/1-objects-within-objects) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
