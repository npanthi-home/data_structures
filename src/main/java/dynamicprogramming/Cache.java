package dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class Cache<K, V> {
    private Map<K, V> cache = new HashMap<>();

    public void memoize(K key, V value) {
        cache.put(key, value);
    }

    public V fetch(K key) {
        return cache.get(key);
    }

    public boolean exists(K key) {
        return cache.get(key) != null;
    }
}
