package Map;

import java.util.ArrayList;

public class ProbeHashMap<K,V> extends AbstractHashMap<K,V>
{
    private MapEntry<K,V>[] table;                                  //a fixed array of entries
    private MapEntry<K,V> DEFUNCT = new MapEntry<K, V>(null,null);  //sentinel

    public ProbeHashMap(){super();}
    public ProbeHashMap(int cap){super(cap);}
    public ProbeHashMap(int cap, int p){super(cap,p);}

    @Override
    protected void createTable()
    {
        table = (MapEntry<K,V>[]) new MapEntry[capacity];   // safe cast
    }

    private boolean isAvailable(int j)
    {
        return (table[j] == null || table[j] == DEFUNCT);
    }

    private int findSlot(int h, K k)
    {
        int avail = -1;                         // no slot available
        int j = h;                              // index while scanning table
        do
        {
            if(isAvailable(j))                  // may be either empty or defunct
            {                                   // this is the first available slot
                if(avail == -1) avail = j;      // if empty, search fails immediately
                if(table[j] == null) break;
            }
            else if(table[j].getKey().equals(k))
                return j;                       // successful match
            j = (j+1) % capacity;               // keep looking
        } while (j != h);                       // stop if we return to the start
        return -(avail + 1);                    // search has failed.
    }


    @Override
    protected V bucketGet(int h, K k)
    {
        int j = findSlot(h, k);
        if(j < 0) return null;
        return table[j].getValue();
    }

    @Override
    protected V bucketPut(int h, K k, V v)
    {
        int j = findSlot(h,k);
        if(j >= 0)
            return table[j].setValue(v);
        table[-(j+1)] = new MapEntry<K, V>(k,v);
        n++;
        return null;
    }

    @Override
    protected V bucketRemove(int h, K k)
    {
        int j = findSlot(h,k);
        if(j < 0) return null;
        V ans = table[j].getValue();
        table[j] = DEFUNCT;
        n--;
        return ans;
    }

    @Override
    public Iterable<Entry<K, V>> entrySet()
    {
        ArrayList<Entry<K,V>> buffer = new ArrayList<>();
        for(int h=0; h < capacity;h++)
            if(!isAvailable(h)) buffer.add(table[h]);
        return buffer;
    }
}
