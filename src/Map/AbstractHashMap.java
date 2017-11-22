package Map;

import java.util.ArrayList;
import java.util.Random;

public abstract class AbstractHashMap<K, V>  extends AbstractSortedMap<K, V> {
    protected int n = 0;            // number of entries in the dictionary
    private int prime;              // prime factor
    protected int capacity;         // length of the table
    private long scale, shift;      // the shifting and scaling factors

    public AbstractHashMap(int cap, int p) {
        prime = p;
        capacity = cap;
        Random rand = new Random();
        scale = rand.nextInt(prime - 1) + 1;
        shift = rand.nextInt(prime);
        createTable();
    }

    public AbstractHashMap(int cap) {
        this(12, 109345121);
    }     // default prime

    public AbstractHashMap() {
        this(17);
    }                          // default capacity

    public int size() {
        return n;
    }

    public V put(K key, V value) {
        V ans = bucketPut(hashValue(key), key, value);
        if (n > capacity / 2)                                   // keep load factor <= 0.5
            resize(2 * capacity - 1);                  // or find a nearby prime
        return ans;
    }

    //  private utilities
    private int hashValue(K key) {
        return (int) ((Math.abs(key.hashCode() * scale + shift) % prime) % capacity);
    }

    private void resize(int newCap) {
        ArrayList<Entry<K, V>> buffer = new ArrayList<>(n);
        for (Entry<K, V> e : entrySet()) {
            buffer.add(e);
        }
        capacity = newCap;                  // based on the updated capacity
        createTable();                      // will be computed while reinserting entries.
        n = 0;
        for (Entry<K, V> e : buffer) {
            put(e.getKey(), e.getValue());
        }
    }

    protected abstract void createTable();

    protected abstract V bucketGet(int h, K k);

    protected abstract V bucketPut(int h, K k, V v);

    protected abstract V bucketRemove(int h, K k);

}
