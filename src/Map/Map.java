package Map;

public interface Map<K,V>
{
    int size();
    boolean isEmpty();
    Iterable<V> values();
    Iterable<Entry<K,V>> entrySet();
}
