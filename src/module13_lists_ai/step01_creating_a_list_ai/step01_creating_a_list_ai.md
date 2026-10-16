> [!info] AI-Generated

# Creating a list

Say a program reads the names of everyone coming to a party. With one variable per name, you'd need `name1`, `name2`, `name3` and so on, and you'd have to know in advance how many guests there will be. A **list** solves both problems: it's one variable that holds any number of values, in order.

Java's list is called `ArrayList`:

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> planets = new ArrayList<>();
        planets.add("Mercury");
        planets.add("Venus");
        planets.add("Earth");
        System.out.println(planets);
    }
}
```

**Output**

```text
[Mercury, Venus, Earth]
```

- `import java.util.ArrayList;` goes at the very top, like the import for `Scanner`. Without it, Java doesn't know the name `ArrayList`.
- `ArrayList<String> planets` declares a variable for a list of Strings. The type between `<` and `>` says what kind of values the list holds.
- `new ArrayList<>()` creates a new, empty list, and `=` stores it in the variable.
- `planets.add("Mercury")` adds a value at the end of the list. The list grows by one each time; there's no size to set in advance.
- Printing a list prints all its values in square brackets, separated by commas, in the order they were added. An empty list prints `[]`.

A list can hold the same value more than once. And `+` joins a list to text, just as it does a number: `"Planets: " + planets` gives `Planets: [Mercury, Venus, Earth]`.

---

Source: [Creating a list](https://javaarena.com/learn/lists/creating-a-list/) in the module [Lists](https://javaarena.com/learn/lists/) on Java Arena.

This module follows section [3.2 Lists](https://java-programming.mooc.fi/part-3/2-lists) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
