> [!info] AI-Generated

# Keys and values

A list keeps its values in a row, and you find a value by its index: `get(0)`, `get(1)` and so on. Often, though, you want a value by something else. Tickets and luggage tags name airports by three-letter codes: `ACC` is Accra, `LIS` is Lisbon. With the codes in one list and the cities in another, finding the city of `LIS` takes a linear search (module 28): go through the codes until one matches, then take the city at the same index.

A **hash map** is made for this. It holds **pairs**: each **key** (here, a code) is linked to a **value** (here, a city), and you get a value by giving its key.

```java
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, String> airports = new HashMap<>();
        airports.put("ACC", "Accra");
        airports.put("LIS", "Lisbon");
        airports.put("YVR", "Vancouver");

        System.out.println(airports.get("LIS"));
        System.out.println(airports.get("YVR"));
        System.out.println(airports.get("XYZ"));
    }
}
```

**Output**

```text
Lisbon
Vancouver
null
```

- `HashMap` is in `java.util`, so it needs an import line, like `ArrayList`.
- `HashMap<String, String>` has two types in its angle brackets: first the type of the keys, then the type of the values.
- `put(key, value)` adds a pair to the map. `get(key)` gives the value linked to that key.
- When the key isn't in the map, `get` gives `null` (module 22): this map has no airport with the code `XYZ`. Nothing crashes, but the program has to be ready for that `null`.

Why "hash"? From each key, the map works out a number, the key's **hash code**, and uses it to decide where to keep the pair. To find the key again, `get` works out the same number and looks right there, instead of going through the pairs one by one. So finding a value by its key usually takes about the same short time whether the map holds ten pairs or a million. (Module 32 says more about hash codes, and part 12 of the course builds a small hash map to show how one works inside.)

## Numbers as values

Keys and values can be of other types, but as with the values of a list, they must be class types: `Integer`, not `int`. A pantry counts its jars:

```java
HashMap<String, Integer> jars = new HashMap<>();
jars.put("marmalade", 3);
jars.put("plum jam", 5);
jars.put("pickles", 4);

int jam = jars.get("plum jam");
System.out.println("Plum jam: " + jam);
System.out.println("Marmalade and pickles: " + (jars.get("marmalade") + jars.get("pickles")));
System.out.println("Salsa: " + jars.get("salsa"));
```

**Output**

```text
Plum jam: 5
Marmalade and pickles: 7
Salsa: null
```

An `Integer` from the map turns into an `int` by itself, as one from a list does. But `null` isn't a number, so the `null` of a missing key can't become an `int`. Storing it in an `int` variable crashes the program:

```java
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> jars = new HashMap<>();
        jars.put("marmalade", 3);
        int salsa = jars.get("salsa");
        System.out.println("Salsa: " + salsa);
    }
}
```

**The program crashes with**

```text
Exception in thread "main" java.lang.NullPointerException: Cannot invoke "java.lang.Integer.intValue()" because the return value of "java.util.HashMap.get(Object)" is null
	at Main.main(Main.java:7)
```

To turn an `Integer` into an `int`, Java calls the Integer's `intValue()` method, and `get` gave no Integer to call it on.

## A value for missing keys: getOrDefault

`getOrDefault(key, fallback)` gives the value of the key, or the fallback when the key isn't in the map. For counts, 0 is the natural fallback: no salsa in the map means no jars of salsa.

```java
HashMap<String, Integer> jars = new HashMap<>();
jars.put("marmalade", 3);
int marmalade = jars.getOrDefault("marmalade", 0);
int salsa = jars.getOrDefault("salsa", 0);
System.out.println(marmalade + " jars of marmalade, " + salsa + " jars of salsa");
```

**Output**

```text
3 jars of marmalade, 0 jars of salsa
```

- The fallback has the type of the values. For a `HashMap<String, String>`, it's a String, such as `"unknown"`.
- `getOrDefault` only reads. It doesn't add the key to the map: after it, the map still has no salsa.

---

Source: [Keys and values](https://javaarena.com/learn/hash-maps/keys-and-values/) in the module [Hash maps](https://javaarena.com/learn/hash-maps/) on Java Arena.

This module follows section [8.2 Hash Map](https://java-programming.mooc.fi/part-8/2-hash-map) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
