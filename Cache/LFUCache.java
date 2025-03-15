package Cache;

//  LFU (Least Frequently Used) Cache in Java
import java.util.*;

class LFUCache<K, V> {
    private final int capacity;
    private final Map<K, V> cache; // Stores key-value pairs
    private final Map<K, Integer> accessCount; // Stores key-access frequency
    private final PriorityQueue<K> minHeap; // Min-Heap to track LFU keys

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.accessCount = new HashMap<>();
        this.minHeap = new PriorityQueue<>(Comparator.comparingInt(accessCount::get));
    }

    public V get(K key) {
        if (!cache.containsKey(key)) return null;

        // Increase the access count for the key
        accessCount.put(key, accessCount.getOrDefault(key, 0) + 1);
        minHeap.remove(key); // Remove key to update its position in the heap
        minHeap.offer(key); // Re-insert key with updated frequency

        return cache.get(key);
    }

    public void put(K key, V value) {
        if (capacity == 0) return; // Edge case: no capacity

        if (cache.containsKey(key)) {
            // If key already exists, update the value and frequency
            cache.put(key, value);
            get(key); // This will update the access count
            return;
        }

        if (cache.size() >= capacity) {
            // Remove the LFU (Least Frequently Used) key
            K leastUsedKey = minHeap.poll(); // Get LFU key
            if (leastUsedKey != null) {
                cache.remove(leastUsedKey);
                accessCount.remove(leastUsedKey);
            }
        }

        // Add the new key-value pair
        cache.put(key, value);
        accessCount.put(key, 1); // First access count is 1
        minHeap.offer(key); // Insert key into heap
    }

    public void printCache() {
        System.out.println("Cache: " + cache.keySet());
        System.out.println("Access Counts: " + accessCount);
    }

    public static void main(String[] args) {
        LFUCache<Character, Character> lfu = new LFUCache<>(4);

        // Initial Cache: {A, B, C, D}
        lfu.put('A', 'A');
        lfu.put('B', 'B');
        lfu.put('C', 'C');
        lfu.put('D', 'D');

        System.out.println("Initial Cache:");
        lfu.printCache(); // Output: [A, B, C, D]

        // Access Sequence: {A, C, B, A, E}
        lfu.get('A'); // A = 2
        lfu.get('C'); // C = 2
        lfu.get('B'); // B = 2
        lfu.get('A'); // A = 3

        // Adding 'E' (removes 'D' because it's LFU)
        lfu.put('E', 'E'); // D has count 1, others have more, so remove D

        System.out.println("\nCache after accessing {A, C, B, A} and inserting E:");
        lfu.printCache(); // Expected Output: [C, B, A, E]
    }
}

