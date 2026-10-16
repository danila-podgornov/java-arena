> [!info] AI-Generated

# Collisions, updates, removing and growing

The map from step 6 can put and get. This step makes it a map you could really use: one that handles keys that share a bucket, gives each key only one value, removes keys, and grows as it fills up.

## Two keys, one bucket

In step 6, Amara and Elif both went to bucket 4. Their hash codes are different, 63372932 and 2162724, but the remainders after dividing by 8 are the same. Two different keys can even have the very same hash code: module 32 showed that `"Aa"` and `"BB"` both have 2112. When two keys land in one bucket, that's called a **collision**.

Collisions are why each bucket is a list and not a single place. A collision costs no data: both pairs are in the bucket, and `get` compares the keys with `equals` to find the right one. It only costs time, since `get` may have to look at more than one pair.

## The same key twice

Step 6's `put` always adds a new pair. Put Bo's extension in again, as 109, and bucket 5 ends up with two pairs for Bo: `size()` says 6 for five people, and `get("Bo")` still finds the old pair first and returns 102. A map has one value per key, and a new `put` replaces the old value (module 31).

So `put` looks for the key in its bucket first. If it's there, the pair gets the new value, with KeyValue's `setValue`, and that's all. Only a new key adds a pair and grows the size:

```java
public void put(K key, V value) {
    ArrayList<KeyValue<K, V>> bucket = bucketFor(key);
    for (KeyValue<K, V> pair : bucket) {
        if (pair.getKey().equals(key)) {
            pair.setValue(value);
            return;
        }
    }
    bucket.add(new KeyValue<>(key, value));
    this.size++;
}
```

## Removing a key

`remove` finds the key's pair in its bucket, takes it out of the bucket, and returns its value, or `null` when the key isn't there, as HashMap's `remove` does:

```java
public V remove(K key) {
    ArrayList<KeyValue<K, V>> bucket = bucketFor(key);
    for (int i = 0; i < bucket.size(); i++) {
        if (bucket.get(i).getKey().equals(key)) {
            this.size--;
            return bucket.remove(i).getValue();
        }
    }
    return null;
}
```

- The loop goes by index, so that `bucket.remove(i)` can remove the pair at that index. It returns the removed pair, and `getValue()` gives its value.
- The bucket's own `remove` moves the pairs after the removed one, as in step 4. A bucket holds only a few pairs, so that's quick.

## Growing

The map has 8 buckets. With 800 keys in it, each bucket would hold about 100 pairs, and `get` would compare with up to 100 keys: a linear search again, only a bit shorter. A map stays fast only while its buckets stay short, so it adds buckets as it fills up.

The rule here: when the map has more than 0.75 pairs per bucket, that is when `size > 0.75 * buckets.length`, the array of buckets becomes twice as long. Java's HashMap uses the same limit, 0.75, unless you give it another one, and it doubles its buckets too.

Growing can't just copy bucket 5 to bucket 5 of the new array. A key's bucket depends on the number of buckets: Bo's hash code is 2157, and 2157 % 8 is 5, but 2157 % 16 is 13. After growing, `get("Bo")` looks in bucket 13, so Bo's pair must be there. So every pair is put again, into the bucket its hash code picks in the new array:

```java
@SuppressWarnings("unchecked")
private void grow() {
    ArrayList<KeyValue<K, V>>[] old = this.buckets;
    this.buckets = new ArrayList[old.length * 2];
    for (int i = 0; i < this.buckets.length; i++) {
        this.buckets[i] = new ArrayList<>();
    }
    for (ArrayList<KeyValue<K, V>> bucket : old) {
        for (KeyValue<K, V> pair : bucket) {
            bucketFor(pair.getKey()).add(pair);
        }
    }
}
```

- `old` keeps the old array while `this.buckets` gets the new one, with an empty list in each place.
- `bucketFor` divides by `this.buckets.length`, which is now 16, so it picks the bucket in the new array.
- The pairs themselves move, not copies of them, and the size stays the same.

Like the list's `grow`, this takes time, one step for each pair. But it doubles the buckets each time, so it happens rarely, and `put` stays fast on average.

## The whole map at work

Here's the map with all of this, counting the words of a short poem. `bucketCount()` is there only to watch the map grow:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        String[] poem = {
            "the rain on the roof",
            "the rain in the street",
            "a song for the rain",
            "and a song for the feet"
        };
        SimpleMap<String, Integer> counts = new SimpleMap<>();
        for (String line : poem) {
            for (String word : line.split(" ")) {
                Integer count = counts.get(word);
                if (count == null) {
                    counts.put(word, 1);
                } else {
                    counts.put(word, count + 1);
                }
            }
        }
        System.out.println(counts.size() + " different words in " + counts.bucketCount() + " buckets");
        String[] wanted = {"the", "rain", "song", "feet", "sun"};
        for (String word : wanted) {
            System.out.println(word + ": " + counts.get(word));
        }
        System.out.println("removed the: " + counts.remove("the") + ", " + counts.size() + " words left");
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
        ArrayList<KeyValue<K, V>> bucket = bucketFor(key);
        for (KeyValue<K, V> pair : bucket) {
            if (pair.getKey().equals(key)) {
                pair.setValue(value);
                return;
            }
        }
        bucket.add(new KeyValue<>(key, value));
        this.size++;
        if (this.size > 0.75 * this.buckets.length) {
            grow();
        }
    }

    public V get(K key) {
        for (KeyValue<K, V> pair : bucketFor(key)) {
            if (pair.getKey().equals(key)) {
                return pair.getValue();
            }
        }
        return null;
    }

    public V remove(K key) {
        ArrayList<KeyValue<K, V>> bucket = bucketFor(key);
        for (int i = 0; i < bucket.size(); i++) {
            if (bucket.get(i).getKey().equals(key)) {
                this.size--;
                return bucket.remove(i).getValue();
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    private void grow() {
        ArrayList<KeyValue<K, V>>[] old = this.buckets;
        this.buckets = new ArrayList[old.length * 2];
        for (int i = 0; i < this.buckets.length; i++) {
            this.buckets[i] = new ArrayList<>();
        }
        for (ArrayList<KeyValue<K, V>> bucket : old) {
            for (KeyValue<K, V> pair : bucket) {
                bucketFor(pair.getKey()).add(pair);
            }
        }
    }

    public int size() {
        return this.size;
    }

    public int bucketCount() {
        return this.buckets.length;
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
11 different words in 16 buckets
the: 6
rain: 3
song: 2
feet: 1
sun: null
removed the: 6, 10 words left
```

- The poem has 21 words, but 11 different ones. Each word after the first time only changes its count, so the size counts each word once.
- The seventh new word took the size to 7, more than 0.75 * 8 = 6, and the map grew to 16 buckets. With 11 words it's still below 0.75 * 16 = 12.
- `counts.get(word)` returns an Integer, which is `null` for a word not counted yet. That's why `count` is an `Integer`, not an `int`.

---

Source: [Collisions, updates, removing and growing](https://javaarena.com/learn/list-and-map-internals/collisions-and-growing/) in the module [Building your own list and hash map](https://javaarena.com/learn/list-and-map-internals/) on Java Arena.

This module follows section [12.2 ArrayList and hash table](https://java-programming.mooc.fi/part-12/2-arraylist-and-hashtable) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
