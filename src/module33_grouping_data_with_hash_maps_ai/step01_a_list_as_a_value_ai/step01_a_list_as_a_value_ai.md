> [!info] AI-Generated

# A list as a value

In module 31, each key of a hash map had one value, and a `put` with a key that was already there replaced the old value. But often one key has many things: a school club has many members, an album has many songs, a table in a restaurant orders many dishes. For those, the value can be a list. This module groups data that way, and then ends part 8 with a look at why a hash map finds its keys so fast.

## A map whose values are lists

A school keeps track of its clubs and their members. The club's name is the key, and the value is the list of its members:

```java
HashMap<String, ArrayList<String>> clubs = new HashMap<>();
clubs.put("Debate", new ArrayList<>());
clubs.put("Robotics", new ArrayList<>());

clubs.get("Debate").add("Amira");
clubs.get("Debate").add("Jonas");
clubs.get("Robotics").add("Priya");

System.out.println(clubs.get("Debate"));
System.out.println(clubs.get("Robotics").size());
```

**Output**

```text
[Amira, Jonas]
1
```

- The type tells the whole story: `HashMap<String, ArrayList<String>>` maps a String (the club) to a list of Strings (its members). The diamond in `new HashMap<>()` fills in both types.
- `clubs.put("Debate", new ArrayList<>())` puts a new, empty list in the map under the key `"Debate"`.
- `clubs.get("Debate")` gives back that list itself, not a copy: a reference to the same list object that's in the map (module 22). So `clubs.get("Debate").add("Amira")` adds Amira to the list in the map, and there's no need to put the list back.

## A club's first member

Before a club gets its first member, the map has no list for it. `get` returns `null` for a key that isn't in the map, and `null` has no methods:

```java
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> clubs = new HashMap<>();
        clubs.get("Drama").add("Leo");
    }
}
```

**The program crashes with**

```text
Exception in thread "main" java.lang.NullPointerException: Cannot invoke "java.util.ArrayList.add(Object)" because the return value of "java.util.HashMap.get(Object)" is null
	at Main.main(Main.java:7)
```

So adding takes two parts: create the list the first time the key is seen, and then add to the list that's in the map. As a method:

```java
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> clubs = new HashMap<>();
        join(clubs, "Debate", "Amira");
        join(clubs, "Drama", "Leo");
        join(clubs, "Debate", "Jonas");
        join(clubs, "Drama", "Sofia");
        join(clubs, "Debate", "Mei");
        System.out.println(clubs.get("Debate"));
        System.out.println(clubs.get("Drama"));
    }

    public static void join(HashMap<String, ArrayList<String>> clubs, String club, String name) {
        if (!clubs.containsKey(club)) {
            clubs.put(club, new ArrayList<>());
        }
        clubs.get(club).add(name);
    }
}
```

**Output**

```text
[Amira, Jonas, Mei]
[Leo, Sofia]
```

- The `if` runs only for a club's first member, and puts a new, empty list in the map for that club. Each club gets a list of its own.
- After the `if`, the club always has a list, so `clubs.get(club).add(name)` is safe.
- Each list is an ordinary ArrayList, so the members stay in the order they joined.
- `join` gets a reference to the caller's map, so the lists it adds and fills are in the caller's map too.

The same can be written with `getOrDefault(key, other)`, which returns the key's value, or `other` when the key isn't in the map:

```java
ArrayList<String> members = clubs.getOrDefault(club, new ArrayList<>());
members.add(name);
clubs.put(club, members);
```

Here the last line matters. For a new club, the new list is only in the variable `members` until `put` stores it in the map. Without the `put`, the club's first member would be lost. For a club that already has a list, `put` stores the same list again, which changes nothing. Both ways work. For adding, this module uses the one with `containsKey`.

## Getting a group back

A method that gives a club's members returns the club's list. For a club nobody has joined, it should return an **empty list**, not `null`:

```java
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> clubs = new HashMap<>();
        join(clubs, "Debate", "Amira");
        join(clubs, "Debate", "Jonas");
        for (String name : membersOf(clubs, "Debate")) {
            System.out.println("Debate: " + name);
        }
        for (String name : membersOf(clubs, "Astronomy")) {
            System.out.println("Astronomy: " + name);
        }
        System.out.println(membersOf(clubs, "Astronomy").size() + " in Astronomy");
    }

    public static void join(HashMap<String, ArrayList<String>> clubs, String club, String name) {
        if (!clubs.containsKey(club)) {
            clubs.put(club, new ArrayList<>());
        }
        clubs.get(club).add(name);
    }

    public static ArrayList<String> membersOf(HashMap<String, ArrayList<String>> clubs, String club) {
        return clubs.getOrDefault(club, new ArrayList<>());
    }
}
```

**Output**

```text
Debate: Amira
Debate: Jonas
0 in Astronomy
```

- With an empty list, the code that asks needs no special case: the for-each loop over Astronomy runs zero times, and `size()` is 0. With `null`, both would crash with a NullPointerException, so every caller would have to check for `null` first.
- The empty list for Astronomy is a new list that isn't in the map. That's fine for reading. To add a member, use `join`.

---

Source: [A list as a value](https://javaarena.com/learn/grouping/list-as-value/) in the module [Grouping data with hash maps](https://javaarena.com/learn/grouping/) on Java Arena.

This module follows sections [8.4 Grouping data using hash maps](https://java-programming.mooc.fi/part-8/4-grouping-data-using-hash-maps), [8.5 Fast data fetching and grouping information](https://java-programming.mooc.fi/part-8/5-fast-data-fetching-and-grouping-information) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
