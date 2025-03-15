package Cache;
import java.util.*;

class LRUCache<K, V> {
    private final int capacity;
    private final LinkedHashMap<K, V> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > capacity;
            }
        };
    }

    public void put(K key, V value) {
        cache.put(key, value);
    }

    public V get(K key) {
        return cache.getOrDefault(key, null);
    }

    public void printCache() {
        System.out.println(cache.keySet());
    }

    public static void main(String[] args) {
        LRUCache<Character, Character> lru = new LRUCache<>(4);

        // Initial Cache: {A, B, C, D}
        lru.put('A', 'A');
        lru.put('B', 'B');
        lru.put('C', 'C');
        lru.put('D', 'D');

        System.out.println("Initial Cache: ");
        lru.printCache(); // Output: [A, B, C, D]

        // Access Sequence: {A, C, B, A, E}
        lru.get('A'); // Access A
        lru.get('C'); // Access C
        lru.get('B'); // Access B
        lru.get('A'); // Access A again

        // Now add 'E', which should remove 'D' (least recently used)
        lru.put('E', 'E');

        System.out.println("Cache after accessing {A, C, B, A} and inserting E: ");
        lru.printCache(); // Expected Output: [C, B, A, E]
    }
}
