package Cache;

import java.util.*;
//Updated Code: LRU Cache with Access Counter
class LRUCacheWithAccessCount<K, V> {
    private final int capacity;
    private final LinkedHashMap<K, V> cache;
    private final Map<K, Integer> accessCount; // Store how many times a key is accessed

    public LRUCacheWithAccessCount(int capacity) {
        this.capacity = capacity;
        this.accessCount = new HashMap<>();

        this.cache = new LinkedHashMap<>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > capacity;
            }
        };
    }

    public void put(K key, V value) {
        cache.put(key, value);
        accessCount.put(key, accessCount.getOrDefault(key, 0) + 1);
    }

    public V get(K key) {
        if (!cache.containsKey(key)) return null;

        // Increment access count when key is accessed
        accessCount.put(key, accessCount.getOrDefault(key, 0) + 1);
        return cache.get(key);
    }

    public void printCache() {
        System.out.println("Cache: " + cache.keySet());
        System.out.println("Access Counts: " + accessCount);
    }

    public static void main(String[] args) {
        LRUCache<Character, Character> lru = new LRUCache<>(4);

        // Initial Cache: {A, B, C, D}
        lru.put('A', 'A');
        lru.put('B', 'B');
        lru.put('C', 'C');
        lru.put('D', 'D');

        System.out.println("Initial Cache:");
        lru.printCache(); // Output: [A, B, C, D]

        // Access Sequence: {A, C, B, A, E}
        lru.get('A'); // A = 2
        lru.get('C'); // C = 2
        lru.get('B'); // B = 2
        lru.get('A'); // A = 3

        // Adding 'E' (removes 'D' due to LRU)
        lru.put('E', 'E'); // Removes 'D' (least recently used)

        System.out.println("\nCache after accessing {A, C, B, A} and inserting E:");
        lru.printCache(); // Expected Output: [C, B, A, E]
    }
}
