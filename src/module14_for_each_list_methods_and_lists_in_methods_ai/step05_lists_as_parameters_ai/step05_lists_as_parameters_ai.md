> [!info] AI-Generated

# Lists as parameters

A list can be a method's parameter, like any other value. The parameter's type is the list's whole type, such as `ArrayList<String>`:

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> guests = new ArrayList<>();
        guests.add("Mira");
        guests.add("Oskar");
        printInvitations(guests);

        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(34);
        scores.add(52);
        scores.add(41);
        System.out.println("Best score: " + highest(scores));
    }

    public static void printInvitations(ArrayList<String> names) {
        for (String name : names) {
            System.out.println("Dear " + name + ", you're invited!");
        }
    }

    public static int highest(ArrayList<Integer> numbers) {
        int best = numbers.get(0);
        for (int number : numbers) {
            if (number > best) {
                best = number;
            }
        }
        return best;
    }
}
```

**Output**

```text
Dear Mira, you're invited!
Dear Oskar, you're invited!
Best score: 52
```

- The one `import java.util.ArrayList;` at the top of the file covers every method in it.
- The call gives the list by its name: `printInvitations(guests)`. As with any parameter, the names in the call and in the method don't have to match.
- A method can return something worked out from the list: a sum, a count, the largest value. (`highest` expects at least one value: on an empty list, `numbers.get(0)` crashes.)

A method can also build a new list and return it. Its return type is then the list's type:

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(7);
        scores.add(12);
        scores.add(9);
        System.out.println(withBonus(scores, 5));
        System.out.println(scores);
    }

    public static ArrayList<Integer> withBonus(ArrayList<Integer> scores, int bonus) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int score : scores) {
            result.add(score + bonus);
        }
        return result;
    }
}
```

**Output**

```text
[12, 17, 14]
[7, 12, 9]
```

The original list is left as it was: the method only read it, and put the new values in a list of its own.

## Challenges that pass a list

The checks in this step build a list, fill it, and call your method with it, just as `main` does above.

---

Source: [Lists as parameters](https://javaarena.com/learn/list-methods/lists-as-parameters/) in the module [For-each, list methods and lists in methods](https://javaarena.com/learn/list-methods/) on Java Arena.

This module follows section [3.2 Lists](https://java-programming.mooc.fi/part-3/2-lists) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
