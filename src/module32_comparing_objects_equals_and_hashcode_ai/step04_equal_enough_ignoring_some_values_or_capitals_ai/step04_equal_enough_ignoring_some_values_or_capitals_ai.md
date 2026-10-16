> [!info] AI-Generated

# Equal enough: ignoring some values or capitals

What counts as equal is up to the class (module 23). In this module so far, equal has meant that every value matched. But module 30's ClimbingRoute already left the grade and the ascents out of `equals`, and Role, in the same module, left out the student. When such objects are hash map keys, `hashCode` must leave the same values out. The same goes for text that should count as equal whatever its capital letters: `hashCode` has to follow the same idea of equal as `equals`.

## Comparing only some values

A paint shop mixes colors from red, green and blue values, and each mix has a name. Customers call the same color by different names: "Sky" and "Sky blue" are both 135, 206, 235. For the shop that's one color, so `equals` compares the three numbers and leaves the name out, and so does `hashCode`:

**Main.java**

```java
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<Color, Integer> cans = new HashMap<>();
        cans.put(new Color("Sky", 135, 206, 235), 4);

        Color asked = new Color("Sky blue", 135, 206, 235);
        System.out.println(asked.equals(new Color("Sky", 135, 206, 235)));
        System.out.println(cans.get(asked));
        System.out.println(cans.containsKey(new Color("Sky", 135, 206, 200)));
    }
}
```

**Color.java**

```java
import java.util.Objects;

public class Color {
    private String name;
    private int red;
    private int green;
    private int blue;

    public Color(String name, int red, int green, int blue) {
        this.name = name;
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public boolean equals(Object compared) {
        if (this == compared) {
            return true;
        }
        if (!(compared instanceof Color)) {
            return false;
        }
        Color other = (Color) compared;
        return this.red == other.red && this.green == other.green && this.blue == other.blue;
    }

    public int hashCode() {
        return Objects.hash(this.red, this.green, this.blue);
    }

    public String toString() {
        return this.name + " (" + this.red + ", " + this.green + ", " + this.blue + ")";
    }
}
```

**Output**

```text
true
4
false
```

- `equals` leaves the name out, and so does `hashCode`. If `Objects.hash` got the name too, "Sky" and "Sky blue" would be equal but have different hash codes, and the map wouldn't find the cans. That's what happened to the used stamp in the last challenge of step 3.
- In short: `hashCode` may use only what `equals` compares.

## Ignoring capital letters

A stamp collector types countries as they come: `Chile`, `chile`, `CHILE`. To count them as the same country, compare the countries in lower case (`toLowerCase`, module 16), and give `hashCode` the lower-case country too:

**Main.java**

```java
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<Stamp, String> album = new HashMap<>();
        album.put(new Stamp("Chile", 1970), "page 4");
        System.out.println(album.get(new Stamp("CHILE", 1970)));
        System.out.println(album.containsKey(new Stamp("chile", 1971)));
        System.out.println("Chile".hashCode() == "CHILE".hashCode());
    }
}
```

**Stamp.java**

```java
import java.util.Objects;

public class Stamp {
    private String country;
    private int year;

    public Stamp(String country, int year) {
        this.country = country;
        this.year = year;
    }

    public boolean equals(Object compared) {
        if (this == compared) {
            return true;
        }
        if (!(compared instanceof Stamp)) {
            return false;
        }
        Stamp other = (Stamp) compared;
        return this.country.toLowerCase().equals(other.country.toLowerCase()) && this.year == other.year;
    }

    public int hashCode() {
        return Objects.hash(this.country.toLowerCase(), this.year);
    }

    public String toString() {
        return this.country + " " + this.year;
    }
}
```

**Output**

```text
page 4
false
false
```

- `"Chile"` and `"CHILE"` are different Strings with different hash codes, as the last line shows. With `this.country` in `Objects.hash`, two stamps that `equals` calls equal would get different hash codes. `toLowerCase()` turns both into `"chile"` first, so their hash codes are the same.
- Both methods use the same lower-case text, so they can't disagree. `equalsIgnoreCase` (module 16) would give the same answers in `equals` for letters like these, but `hashCode` still needs the lower-case text.
- The stamp keeps the country as it was typed, so `toString` shows it that way.

## Or tidied String keys

When the key is one piece of text, there's a simpler way, which module 31 used: tidy the text with `trim()` and `toLowerCase()` (or `toUpperCase()`) before every `put` and every `get`. Then the keys are ordinary Strings, which already have `equals` and `hashCode`, and no key class is needed. The map keeps the keys in their tidied form, so if the spelling as typed matters for printing, keep it in the value.

Which to choose? When the key is one piece of text, tidied String keys are the simplest. When the key is several values that belong together, such as a stamp's country and year, or when some values shouldn't count, such as the name of a paint color, a class with `equals` and `hashCode` keeps the values together and says in one place what equal means.

---

Source: [Equal enough: ignoring some values or capitals](https://javaarena.com/learn/equals-hashcode/equal-enough/) in the module [Comparing objects: equals and hashCode](https://javaarena.com/learn/equals-hashcode/) on Java Arena.

This module follows section [8.3 Similarity of objects](https://java-programming.mooc.fi/part-8/3-similarity-of-objects) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
