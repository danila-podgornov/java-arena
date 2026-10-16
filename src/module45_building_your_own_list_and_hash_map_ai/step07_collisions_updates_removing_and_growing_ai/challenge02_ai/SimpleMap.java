// AI-Generated
package module45_building_your_own_list_and_hash_map_ai.step07_collisions_updates_removing_and_growing_ai.challenge02_ai;

import java.util.ArrayList;

public class SimpleMap<K, V> {
    private ArrayList<KeyValue<K, V>>[] buckets;
    private int size;

    @SuppressWarnings("unchecked")
    public SimpleMap(int bucketCount) {
        this.buckets = new ArrayList[bucketCount];
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
