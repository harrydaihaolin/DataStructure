package priorityQueue;

import positionalList.LinkedPositionalList;
import positionalList.Position;
import positionalList.PositionalList;

import java.util.Comparator;

public class UnsortedPriorityQueue<K, V> extends AbstractPriorityQueue<K, V>
{
    private PositionalList<Entry<K, V>> list = new LinkedPositionalList<>();

    public UnsortedPriorityQueue() {super();}
    public UnsortedPriorityQueue(Comparator<K> comparator) {super(comparator);}

    /** Returns the Position of an entry having minimal key.*/
    private Position<Entry<K, V>> findMin()
    {
        Position<Entry<K, V>> small = list.first();         // only called when nonempty
        Position<Entry<K, V>> walk = list.after(small);
        while (walk != null)
        {
            if(compare(walk.getElement(), small.getElement()) < 0)
                small = walk;
            walk = list.after(walk);
        }
        return small;
    }

    @Override
    public int size()
    {
        return list.size();
    }

    @Override
    public Entry<K, V> insert(K key, V value) throws IllegalArgumentException
    {
        checkKey(key);
        Entry<K, V> newest = new PQEntry<>(key, value);
        list.addLast(newest);
        return newest;
    }

    @Override
    public Entry<K, V> min()
    {
        if(list.isEmpty()) return null;
        return findMin().getElement();
    }

    @Override
    public Entry<K, V> removeMin() {
        if(list.isEmpty())  return null;
        return list.remove(findMin());
    }
}
