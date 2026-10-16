// AI-Generated
package module45_building_your_own_list_and_hash_map_ai.step06_a_hash_map_of_your_own_ai.challenge01_ai;

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
        return null;
    }

    public int size() {
        return this.size;
    }
}
