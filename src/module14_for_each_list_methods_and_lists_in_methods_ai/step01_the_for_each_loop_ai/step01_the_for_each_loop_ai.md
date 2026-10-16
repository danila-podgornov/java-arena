> [!info] AI-Generated

# The for-each loop

The last module went through lists with an index: `for (int i = 0; i < list.size(); i++)` and `list.get(i)`. When you just want every value, from the first to the last, Java has a shorter loop, the **for-each** loop:

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> planets = new ArrayList<>();
        planets.add("Mercury");
        planets.add("Venus");
        planets.add("Earth");

        for (String planet : planets) {
            System.out.println(planet + " orbits the Sun");
        }
    }
}
```

**Output**

```text
Mercury orbits the Sun
Venus orbits the Sun
Earth orbits the Sun
```

Read `for (String planet : planets)` as "for each String `planet` in `planets`".

- The loop runs once for each value in the list. In each round, `planet` holds the next value: first `"Mercury"`, then `"Venus"`, then `"Earth"`.
- The type before the name is the type of the list's values. For an `ArrayList<Integer>`, write `for (int number : numbers)`: each `Integer` comes out as a plain `int`.
- You pick the name. The singular of the list's name, like `planet` for `planets`, reads well.

The same loop with an index needs a counter, a condition, `size()` and `get`:

```java
for (int i = 0; i < planets.size(); i++) {
    String planet = planets.get(i);
    System.out.println(planet + " orbits the Sun");
}
```

## When the index loop is still the right tool

A for-each loop gives you the values, but not their places in the list. Use a loop with an index when:

- you need the index itself, for example to print `1. Mercury`, or to compare a value with the one next to it;
- you go through the list in another order, such as backwards from the last value;
- you remove values from the list while going through it (step 4 shows why).

For everything else, such as printing, adding up or counting, the for-each loop is shorter, and there's no index to get wrong.

A quick way to see a whole list at once: `System.out.println(planets)` prints `[Mercury, Venus, Earth]`, the values in square brackets. It's handy for checking your work.

---

Source: [The for-each loop](https://javaarena.com/learn/list-methods/for-each/) in the module [For-each, list methods and lists in methods](https://javaarena.com/learn/list-methods/) on Java Arena.

This module follows section [3.2 Lists](https://java-programming.mooc.fi/part-3/2-lists) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
