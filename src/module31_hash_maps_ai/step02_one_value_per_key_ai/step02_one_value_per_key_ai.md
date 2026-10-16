> [!info] AI-Generated

# One value per key

A key is linked to **at most one value**. Putting a key that's already in the map doesn't add a second pair: the new value takes the place of the old one.

The front desk of a small hotel keeps the name of the guest in each room, with the room numbers as keys. Keys can be numbers too, and like values, they're `Integer`, not `int`. `put(204, "Okafor")` turns the 204 into an Integer by itself.

```java
HashMap<Integer, String> guests = new HashMap<>();
guests.put(204, "Okafor");
guests.put(310, "Lindqvist");
System.out.println(guests.get(204) + ", " + guests.size() + " rooms taken");

guests.put(204, "Tanaka");
System.out.println(guests.get(204) + ", " + guests.size() + " rooms taken");
```

**Output**

```text
Okafor, 2 rooms taken
Tanaka, 2 rooms taken
```

- `size()` is the number of keys in the map, which is also the number of pairs.
- The second `put(204, ...)` replaced Okafor with Tanaka. The map still has two pairs, and Okafor isn't in it anymore.
- Values have no such rule. Two rooms can have guests with the same name, since the rooms are different keys.

(When a key needs several values, such as all the guests of a room, the value can be a list. Module 33 does that.)

## Checking and removing

| Method | What it does |
| --- | --- |
| `containsKey(key)` | `true` if the key is in the map, otherwise `false` |
| `remove(key)` | removes the key and its value; a key that isn't there changes nothing |
| `size()` | the number of keys |
| `isEmpty()` | `true` when the map has no keys at all |

```java
HashMap<Integer, String> guests = new HashMap<>();
guests.put(204, "Tanaka");
guests.put(310, "Lindqvist");

System.out.println(guests.containsKey(310));
guests.remove(310);
System.out.println(guests.containsKey(310) + " " + guests.get(310));
guests.remove(512);
System.out.println(guests.size() + " " + guests.isEmpty());
guests.remove(204);
System.out.println(guests.size() + " " + guests.isEmpty());
```

**Output**

```text
true
false null
1 false
0 true
```

Since `put` replaces, a program that must not lose a value checks first. Here a new guest gets a room only if nobody is in it:

```java
if (guests.containsKey(room)) {
    System.out.println("Room " + room + " is taken");
} else {
    guests.put(room, guest);
}
```

## Keys must match exactly

`get`, `containsKey` and `remove` find a key only if it's equal to a key in the map. The map works out the key's hash code, looks only at the keys with that same hash code, and uses `equals` to tell whether one of them is equal. (Module 32 shows why both of those matter.) For Strings, equal means that every character is the same: `"lis"` and `"LIS "` are different keys from `"LIS"`. Keys that people type often come with small letters or extra spaces, so tidy them into the map's form first:

```java
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> airports = new HashMap<>();
        airports.put("HEL", "Helsinki");
        airports.put("LIS", "Lisbon");

        String typed = scanner.nextLine();
        System.out.println("As typed: " + airports.get(typed));
        String code = typed.trim().toUpperCase();
        System.out.println("Tidied: " + airports.get(code));
    }
}
```

**Input**

```text
  lis
```

**Output**

```text
As typed: null
Tidied: Lisbon
```

- `trim()` removes the spaces at the start and the end, and `toUpperCase()` turns the letters into capitals (module 16). The map's codes are in capitals, so the tidied code matches.
- Choose one form for the keys, such as capitals for codes or small letters for words and titles, and tidy every key into it: when you `put` it, and when you look it up.

---

Source: [One value per key](https://javaarena.com/learn/hash-maps/one-value-per-key/) in the module [Hash maps](https://javaarena.com/learn/hash-maps/) on Java Arena.

This module follows section [8.2 Hash Map](https://java-programming.mooc.fi/part-8/2-hash-map) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
