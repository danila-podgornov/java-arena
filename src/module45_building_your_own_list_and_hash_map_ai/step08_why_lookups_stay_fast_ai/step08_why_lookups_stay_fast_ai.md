> [!info] AI-Generated

# Why lookups stay fast

Module 33 counted the comparisons of an ArrayList's `contains` and a HashMap's `containsKey`, by counting the calls to a key's `equals`. Now that the list and the map are your own, the counting can go inside them. For this experiment only, SimpleList and SimpleMap count every comparison they make, `contains` in the list and `get` in the map. Both classes keep only the methods the experiment needs:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        int[] sizes = {100, 1000, 10000, 100000};
        for (int size : sizes) {
            SimpleList<Integer> list = new SimpleList<>();
            SimpleMap<Integer, Integer> map = new SimpleMap<>();
            for (int i = 1; i <= size; i++) {
                list.add(i);
                map.put(i, i);
            }
            list.contains(size);
            map.get(size);
            System.out.println(size + " values: list " + list.getComparisons() + ", map " + map.getComparisons());
        }
    }
}
```

**SimpleList.java**

```java
public class SimpleList<T> {
    private T[] values;
    private int size;
    private int comparisons;

    @SuppressWarnings("unchecked")
    public SimpleList() {
        this.values = (T[]) new Object[4];
        this.size = 0;
        this.comparisons = 0;
    }

    @SuppressWarnings("unchecked")
    public void add(T value) {
        if (this.size == this.values.length) {
            T[] bigger = (T[]) new Object[this.values.length * 2];
            for (int i = 0; i < this.size; i++) {
                bigger[i] = this.values[i];
            }
            this.values = bigger;
        }
        this.values[this.size] = value;
        this.size++;
    }

    public boolean contains(T value) {
        for (int i = 0; i < this.size; i++) {
            this.comparisons++;
            if (this.values[i].equals(value)) {
                return true;
            }
        }
        return false;
    }

    public int getComparisons() {
        return this.comparisons;
    }
}
```

**SimpleMap.java**

```java
import java.util.ArrayList;

public class SimpleMap<K, V> {
    private ArrayList<KeyValue<K, V>>[] buckets;
    private int size;
    private int comparisons;

    @SuppressWarnings("unchecked")
    public SimpleMap() {
        this.buckets = new ArrayList[8];
        for (int i = 0; i < this.buckets.length; i++) {
            this.buckets[i] = new ArrayList<>();
        }
        this.size = 0;
        this.comparisons = 0;
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
            this.comparisons++;
            if (pair.getKey().equals(key)) {
                return pair.getValue();
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

    public int getComparisons() {
        return this.comparisons;
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
100 values: list 100, map 1
1000 values: list 1000, map 1
10000 values: list 10000, map 1
100000 values: list 100000, map 1
```

- The list's `contains` compared the wanted value with every value before it found it at the end. Ten times the values, ten times the comparisons.
- The map's `get` went straight to the bucket of its key, and compared once, at every size. The map had grown along with its keys, so that bucket held just that one key.
- A value that isn't there is the worst case for the list: `contains` compares with every value before it can say `false`. The map looks in one bucket and is done.

Comparisons aren't the whole cost. Working out a hash code takes a moment too (a String's goes through all its characters, module 32), but that work depends on the key, not on how many keys the map holds.

## What keeps the map fast

Three things you built work together:

1. **The hash code picks the bucket.** `get` never looks at the other buckets at all.
2. **Growing keeps the buckets short.** There are never more than 0.75 pairs per bucket on average, however many keys go in. Without `grow`, 100,000 keys in 8 buckets would mean about 12,500 per bucket.
3. **Good hash codes spread the keys out.** If every key had the same hash code, they'd all share one bucket, and `get` would compare with key after key: a list again, in a slower form. That's why module 32's `hashCode` combined all the values `equals` compares, multiplying by 31 along the way. Java's String and Integer already have hash codes that spread well.

The map pays for its speed in other ways. It needs more memory: an array of buckets, a list for each bucket and an object for each pair. Now and then a `put` has to grow the map and put every pair again. And its keys come out bucket by bucket, not in the order they went in.

## The two, side by side

| | Your list, and ArrayList | Your map, and HashMap |
| --- | --- | --- |
| Adding | at the end, quick; now and then the array is copied into a bigger one | quick; now and then every pair is put again into twice as many buckets |
| By position | `get(index)` goes straight to the place in the array | no positions |
| Finding | `contains` and `indexOf` compare with one element after another | `get` and `containsKey` look in one short bucket |
| Removing | moves every element after the removed one | removes from one short bucket |
| Order | the order of adding | bucket by bucket |

Java's own ArrayList and HashMap are built on these same ideas, with refinements. HashMap starts with 16 buckets by default. In OpenJDK, ArrayList's array grows by half its length rather than doubling, and HashMap mixes the bits of each hash code before it picks a bucket, so that keys spread out better, and turns a bucket that gets very long into a tree, which is quicker to search. These are implementation details, not promises: another Java could do them differently. You'll go on using Java's versions; now you know what they do when you call `add`, `get` and `put`.

---

Source: [Why lookups stay fast](https://javaarena.com/learn/list-and-map-internals/why-lookups-are-fast/) in the module [Building your own list and hash map](https://javaarena.com/learn/list-and-map-internals/) on Java Arena.

This module follows section [12.2 ArrayList and hash table](https://java-programming.mooc.fi/part-12/2-arraylist-and-hashtable) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
