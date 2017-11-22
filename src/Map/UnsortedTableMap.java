package Map;

import java.util.ArrayList;
import java.util.Iterator;

public class UnsortedTableMap<K,V> extends AbstractSortedMap<K,V>
{
    private ArrayList<MapEntry<K,V>> table = new ArrayList<>();

    public UnsortedTableMap(){}

    /**
     * @param key key
     * @return the index of an entry with equal key or -1 if none found.
     */
    private int findIndex(K key)
    {
        int n = table.size();
        for(int j=0;j < n;j++)
        {
            if(table.get(j).getKey().equals(key))
                return j;
        }
        return -1;
    }

    @Override
    public int size()
    {
        return table.size();
    }

    public V get(K key)
    {
        int j = findIndex(key);
        if(j == -1) return null;
        return table.get(j).getValue();
    }

    public V put(K key, V value)
    {
        int j = findIndex(key);
        if(j == -1)     // if we cannot find it.
        {
            table.add(new MapEntry<K, V>(key,value));
            return null;
        }
        else
        {
            return table.get(j).setValue(value);
        }
    }

    public V remove(K key)
    {
        int j = findIndex(key);
        int n = size();
        if (j == -1) return null;
        V ans = table.get(j).getValue();
        if(j != n - 1)
            table.set(j, table.get(n-1));       // relocate last entry to 'hole' created by removal
        table.remove(n-1);                // remove last entry of table
        return ans;
    }


    @Override
    public Iterable<Entry<K, V>> entrySet() {
        return new EntryIterable();
    }


    private class EntryIterator implements Iterator<Entry<K,V>>
    {
        private int j=0;
        @Override
        public boolean hasNext()
        {
            return j < table.size();
        }

        @Override
        public Entry<K, V> next()
        {
            if(j == table.size()) throw new UnsupportedOperationException();
            return table.get(j++);
        }
    }

    private class EntryIterable implements Iterable<Entry<K,V>>
    {
        @Override
        public Iterator<Entry<K, V>> iterator() {
            return new EntryIterator();
        }
    }

 }
