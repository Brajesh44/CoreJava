package Cache;

import java.util.*;

class MFUCache<K, V> {
    private final int capacity;
    private final Map<K, V> cache; // Stores key-value pairs
    private final Map<K, Integer> accessCount; // Tracks access frequency
    private final PriorityQueue<K> maxHeap; // Max-Heap to track MFU keys

    public MFUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.accessCount = new HashMap<>();
        this.maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(accessCount.get(b), accessCount.get(a)));
    }

    public V get(K key) {
        if (!cache.containsKey(key)) return null;

        // Increase the access count
        accessCount.put(key, accessCount.getOrDefault(key, 0) + 1);
        maxHeap.remove(key); // Remove and reinsert to update heap position
        maxHeap.offer(key);

        return cache.get(key);
    }

    public void put(K key, V value) {
        if (capacity == 0) return;

        if (cache.containsKey(key)) {
            // If key exists, update value and frequency
            cache.put(key, value);
            get(key); // Update frequency
            return;
        }

        if (cache.size() >= capacity) {
            // Remove the MFU (Most Frequently Used) key
            K mostUsedKey = maxHeap.poll(); // Get MFU key
            if (mostUsedKey != null) {
                cache.remove(mostUsedKey);
                accessCount.remove(mostUsedKey);
            }
        }

        // Add new key-value pair
        cache.put(key, value);
        accessCount.put(key, 1); // Initial access count is 1
        maxHeap.offer(key);
    }

    public void printCache() {
        System.out.println("Cache: " + cache.keySet());
        System.out.println("Access Counts: " + accessCount);
    }

    public static void main(String[] args) {
        MFUCache<Character, Character> mfu = new MFUCache<>(4);

        // Initial Cache: {A, B, C, D}
        mfu.put('A', 'A');
        mfu.put('B', 'B');
        mfu.put('C', 'C');
        mfu.put('D', 'D');

        System.out.println("Initial Cache:");
        mfu.printCache(); // Output: [A, B, C, D]

        // Access Sequence: {A, C, B, A, E}
        mfu.get('A'); // A = 2
        mfu.get('C'); // C = 2
        mfu.get('B'); // B = 2
        mfu.get('A'); // A = 3

        // Adding 'E' (removes 'A' because it's MFU)
        mfu.put('E', 'E'); // A has the highest count, so remove A

        System.out.println("\nCache after accessing {A, C, B, A} and inserting E:");
        mfu.printCache(); // Expected Output: [C, B, D, E]
    }
}

