> [!info] AI-Generated

# Going through a hash map

So far, every lookup started from a key. To do something with all the pairs, such as print them or add up the values, go through the map's keys. `keySet()` gives all the keys, and a for-each loop goes through them. `get` gives each key's value:

```java
HashMap<String, String> airports = new HashMap<>();
airports.put("YVR", "Vancouver");
airports.put("HEL", "Helsinki");
airports.put("LIS", "Lisbon");
airports.put("CPT", "Cape Town");

for (String code : airports.keySet()) {
    System.out.println(code + ": " + airports.get(code));
}
```

**Output**

```text
YVR: Vancouver
CPT: Cape Town
LIS: Lisbon
HEL: Helsinki
```

Look at the order. It isn't the order the codes were added in, and it isn't alphabetical either. A hash map keeps each key where its hash code sends it, and the loop goes through the keys in that order. With these four String keys, the order happens to be the same every time the program runs. But Java makes no promise about it: other keys, or more of them, can come out in a completely different order. **Never write a program that depends on the order of a HashMap.** (Printing a whole map, `System.out.println(airports)`, shows its pairs as `{YVR=Vancouver, CPT=Cape Town, ...}`, in the same order.)

## The values

When the keys don't matter, `values()` gives just the values. The order of the values is the map's order again, but a total doesn't depend on order:

```java
HashMap<String, Integer> jars = new HashMap<>();
jars.put("marmalade", 3);
jars.put("plum jam", 5);
jars.put("pickles", 1);

int total = 0;
for (int count : jars.values()) {
    total += count;
}
System.out.println("Jars in all: " + total);
```

**Output**

```text
Jars in all: 9
```

## In an order you choose

To print the pairs in a fixed order, copy the keys into a list, and sort the list with `Collections.sort` (module 28). Then go through the list, and get each value from the map:

```java
HashMap<String, String> airports = new HashMap<>();
airports.put("YVR", "Vancouver");
airports.put("HEL", "Helsinki");
airports.put("LIS", "Lisbon");
airports.put("CPT", "Cape Town");

ArrayList<String> codes = new ArrayList<>(airports.keySet());
Collections.sort(codes);
for (String code : codes) {
    System.out.println(code + ": " + airports.get(code));
}
```

**Output**

```text
CPT: Cape Town
HEL: Helsinki
LIS: Lisbon
YVR: Vancouver
```

- `new ArrayList<>(...)` makes a new list with the same values (module 14), and it works with a key set too. A loop that adds each key to an empty list does the same.
- Sorting the list changes only the list. The map stays as it was.
- Java also has maps that keep an order of their own: `TreeMap` keeps its keys sorted, and `LinkedHashMap` keeps the order they were added in. This course uses `HashMap`, and sorts the keys whenever the order matters.

## Picking some of the pairs

To pick pairs by their values, go through the keys and check each value. Collect the keys you want in a list, and sort it before printing. Here the pantry makes a shopping list of the foods with fewer than 2 jars left:

```java
HashMap<String, Integer> jars = new HashMap<>();
jars.put("marmalade", 3);
jars.put("plum jam", 1);
jars.put("pickles", 1);
jars.put("mustard", 4);

ArrayList<String> toBuy = new ArrayList<>();
for (String food : jars.keySet()) {
    if (jars.get(food) < 2) {
        toBuy.add(food);
    }
}
Collections.sort(toBuy);
System.out.println("To buy: " + toBuy);
```

**Output**

```text
To buy: [pickles, plum jam]
```

As with a list (module 14), don't add or remove keys while a for-each goes through the same map. To remove pairs, collect their keys in a list first, and remove them after the loop.

---

Source: [Going through a hash map](https://javaarena.com/learn/hash-maps/going-through/) in the module [Hash maps](https://javaarena.com/learn/hash-maps/) on Java Arena.

This module follows section [8.2 Hash Map](https://java-programming.mooc.fi/part-8/2-hash-map) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
