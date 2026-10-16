> [!info] AI-Generated

# A hash map of your own

A list finds a value by its index. A map finds it by its key, and module 32 told how a hash map does that: it keeps its entries in many small groups called **buckets**, and the key's hash code picks the bucket. This step builds one, `SimpleMap<K, V>`, with K for the type of the keys and V for the values, the names HashMap uses too.

## A key and its value

Each entry of the map is a key with its value, an object of a small generic class with two type parameters, like module 44's Duo:

```java
public class KeyValue<K, V> {
    private K key;
    private V value;

    public KeyValue(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
```

The value can change, which step 7 needs. The key can't: the bucket a pair sits in depends on its key.

## An array of buckets

Each bucket is a list of pairs, and the map keeps an array of buckets:

```java
private ArrayList<KeyValue<K, V>>[] buckets;
```

Read the type from the inside out: `KeyValue<K, V>` is one pair, `ArrayList<KeyValue<K, V>>` is a list of pairs, that is one bucket, and the `[]` at the end makes it an array of buckets. (The buckets could be SimpleLists from step 5 just as well; ArrayList keeps the code shorter.)

Creating the array runs into the wall from step 5: `new ArrayList<KeyValue<K, V>>[8]` is a generic array creation, and javac refuses it. Leave out the angle brackets, `new ArrayList[8]`, and it compiles, with the same unchecked note as before. The constructor gets `@SuppressWarnings("unchecked")` again, and puts an empty list in every place of the array:

```java
@SuppressWarnings("unchecked")
public SimpleMap() {
    this.buckets = new ArrayList[8];
    for (int i = 0; i < this.buckets.length; i++) {
        this.buckets[i] = new ArrayList<>();
    }
    this.size = 0;
}
```

## Picking the bucket

The key's bucket is the remainder of its hash code divided by the number of buckets, as in module 32's `bucketOf`:

```java
private ArrayList<KeyValue<K, V>> bucketFor(K key) {
    int index = Math.abs(key.hashCode() % this.buckets.length);
    return this.buckets[index];
}
```

- `key.hashCode()` works for any K, since every object has a `hashCode` (module 32).
- A hash code can be negative, and then so is the remainder: with 8 buckets it's anything from -7 to 7. `Math.abs` turns that into 0 to 7, always an index the array has. (Java's `Math.floorMod(key.hashCode(), this.buckets.length)` is another way to a remainder that's never negative. It can pick other buckets for negative hash codes, which works just as well, as long as the map always uses the same way.)
- Equal keys have equal hash codes, so a key always leads to the same bucket. That's how `put` and `get` meet: `get` looks in the bucket where `put` left the pair.

## put and get

Here's the whole map, a first version, as a phone book of the office's extension numbers. To show where each name goes, `main` works out the buckets itself, the same way `bucketFor` does:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        SimpleMap<String, Integer> extensions = new SimpleMap<>();
        String[] names = {"Amara", "Bo", "Carmen", "Dev", "Elif"};
        int[] numbers = {214, 102, 305, 118, 240};
        for (int i = 0; i < names.length; i++) {
            extensions.put(names[i], numbers[i]);
            System.out.println(names[i] + " goes to bucket " + Math.abs(names[i].hashCode() % 8));
        }
        System.out.println("Dev: " + extensions.get("Dev"));
        System.out.println("Frank: " + extensions.get("Frank"));
        System.out.println(extensions.size() + " extensions");
    }
}
```

**SimpleMap.java**

```java
import java.util.ArrayList;

public class SimpleMap<K, V> {
    private ArrayList<KeyValue<K, V>>[] buckets;
    private int size;

    @SuppressWarnings("unchecked")
    public SimpleMap() {
        this.buckets = new ArrayList[8];
        for (int i = 0; i < this.buckets.length; i++) {
            this.buckets[i] = new ArrayList<>();
        }
        this.size = 0;
    }

    private ArrayList<KeyValue<K, V>> bucketFor(K key) {
        int index = Math.abs(key.hashCode() % this.buckets.length);
        return this.buckets[index];
    }

    public void put(K key, V value) {
        bucketFor(key).add(new KeyValue<>(key, value));
        this.size++;
    }

    public V get(K key) {
        for (KeyValue<K, V> pair : bucketFor(key)) {
            if (pair.getKey().equals(key)) {
                return pair.getValue();
            }
        }
        return null;
    }

    public int size() {
        return this.size;
    }
}
```

**KeyValue.java**

```java
public class KeyValue<K, V> {
    private K key;
    private V value;

    public KeyValue(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
```

**Output**

```text
Amara goes to bucket 4
Bo goes to bucket 5
Carmen goes to bucket 2
Dev goes to bucket 5
Elif goes to bucket 4
Dev: 118
Frank: null
5 extensions
```

After the five `put` calls, the buckets look like this:

```text
bucket 0:  -
bucket 1:  -
bucket 2:  Carmen=305
bucket 3:  -
bucket 4:  Amara=214, Elif=240
bucket 5:  Bo=102, Dev=118
bucket 6:  -
bucket 7:  -
```

- `put` adds a new pair to the end of its key's bucket, and counts it.
- `get("Dev")` works out Dev's bucket, 5, and looks only there: it compares Dev with Bo, then with Dev, and returns 118. The other three names are never looked at.
- `get("Frank")` goes to bucket 2, finds only Carmen there, and returns `null`, as HashMap's `get` does for a missing key. To find out that Frank isn't there, it looked at one key, not five.
- The keys are compared with `equals`, never with `==`: a name the user types is a String object of its own (module 32).
- Five keys in 8 buckets, but only three buckets are used. Hash codes don't spread keys out perfectly, and some keys share a bucket. That's expected, and step 7 looks at it more closely.

This `put` has a flaw: it never checks whether the key is in the map already. Step 7 fixes that.

---

Source: [A hash map of your own](https://javaarena.com/learn/list-and-map-internals/own-hash-map/) in the module [Building your own list and hash map](https://javaarena.com/learn/list-and-map-internals/) on Java Arena.

This module follows section [12.2 ArrayList and hash table](https://java-programming.mooc.fi/part-12/2-arraylist-and-hashtable) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
