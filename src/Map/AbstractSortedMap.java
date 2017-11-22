package Map;

import priorityQueue.DefaultComparator;

import java.util.Comparator;
import java.util.Iterator;

public abstract class AbstractSortedMap<K,V> implements Map<K,V>
{
    private Comparator<K> comp;

    public AbstractSortedMap(Comparator<K> c){comp = c;};
    protected AbstractSortedMap() {this(new DefaultComparator<>());}

    protected int compare(Entry<K, V> a, Entry<K, V> b)
    {
        return comp.compare(a.getKey(), b.getKey());
    }

    protected boolean checkKey(K key) throws IllegalArgumentException
    {
        try
        {
            return (comp.compare(key, key) == 0);               // see if key can be compared to itself.
        }
        catch (ClassCastException e)
        {
            throw new IllegalArgumentException("Incompatible key.");
        }
    }


    public boolean isEmpty(){return size() == 0;}

    protected static class MapEntry<K,V> implements Entry<K,V>
    {
        private K k;
        private V v;
        public MapEntry(K key, V value)
        {
            k = key;
            v = value;
        }
        @Override
        public K getKey() {
            return k;
        }

        @Override
        public V getValue() {
            return v;
        }

        protected void setKey(K key){k = key;}
        protected V setValue(V value)
        {
            V old = v;
            v = value;
            return old;
        }
    }

    private class KeyIterator implements Iterator<K>
    {
        private Iterator<Entry<K,V>> entries = entrySet().iterator();

        @Override
        public boolean hasNext() {
            return entries.hasNext();
        }

        @Override
        public K next() {
            return entries.next().getKey();
        }

        public void remove() {throw new UnsupportedOperationException();}

    }

    private class ValueIterator implements Iterator<V>
    {
        private Iterator<Entry<K,V>> entries = entrySet().iterator();

        @Override
        public boolean hasNext() {
            return entries.hasNext();
        }

        @Override
        public V next() {
            return entries.next().getValue();
        }

        public void remove(){throw new UnsupportedOperationException();}
    }

    private class ValueIterable implements Iterable<V>
    {
        @Override
        public Iterator<V> iterator() {
            return new ValueIterator();
        }
    }

    public Iterable<V> values(){return new ValueIterable();}
}
