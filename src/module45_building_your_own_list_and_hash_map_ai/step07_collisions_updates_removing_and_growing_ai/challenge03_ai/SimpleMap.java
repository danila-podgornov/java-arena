// AI-Generated
package module45_building_your_own_list_and_hash_map_ai.step07_collisions_updates_removing_and_growing_ai.challenge03_ai;

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

    @SuppressWarnings("unchecked")
    private void grow() {

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

    public int bucketCount() {
        return this.buckets.length;
    }
}
