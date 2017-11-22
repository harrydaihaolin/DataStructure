package heap;

import priorityQueue.AbstractPriorityQueue;
import priorityQueue.Entry;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;

public class HeapPriorityQueue<K, V> extends AbstractPriorityQueue<K, V>
{
    protected ArrayList<Entry<K, V>> heap = new ArrayList<>();

    public HeapPriorityQueue() {super();}
    public HeapPriorityQueue(Comparator<K> comparator){super(comparator);}

    protected int parent(int j){return (j-1) / 2;}
    protected int left(int j){return 2*j + 1;}
    protected int right(int j){return 2*j + 2;}
    protected boolean hasLeft(int j){return left(j) < heap.size();}
    protected boolean hasRight(int j){return right(j) < heap.size();}

    protected void swap(int i, int j)
    {
        Entry<K, V> temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    protected void upheap(int j)
    {
        while (j > 0)
        {
            int p = parent(j);
            if(compare(heap.get(j), heap.get(p)) >= 0) break;
            swap(j,p);
            j = p;
        }
    }

    protected void downheap(int j)
    {
        while (hasLeft(j))                                                  // continue to bottom
        {
            int leftIndex = left(j);
            int smallChildIndex = leftIndex;                                // although right may be smaller.
            if (hasRight(j))
            {
                int rightIndex = right(j);
                if(compare(heap.get(leftIndex), heap.get(rightIndex)) > 0)
                    smallChildIndex = rightIndex;                           // right child is smaller
            }
            if(compare((heap.get(smallChildIndex)), heap.get(j)) >= 0)      // heap property has been restored.
                break;
            swap(j, smallChildIndex);
            j = smallChildIndex;                                            // continue at position of the child.
        }
    }

    public int size(){return heap.size();}


    /**
     *
     * @return an entry with minial key.
     */
    @Override
    public Entry<K, V> min() {
        if(heap.isEmpty()) return null;
        return heap.get(0);
    }

    @Override
    public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
        checkKey(key);                                  // add to the end of the list
        Entry<K, V> newest = new PQEntry<>(key, value); // and remove it from the list
        heap.add(newest);                               // then fix new root
        upheap(heap.size() - 1);
        return newest;
    }

    @Override
    public Entry<K, V> removeMin() {
        if (heap.isEmpty()) return  null;
        Entry<K, V> ans = heap.get(0);
        swap(0, heap.size() - 1);                   // put minimum item at the end
        heap.remove(heap.size() - 1);              // and remove it from the list.
        downheap(0);                                  // then fix new root.
        return ans;
    }

    protected void heapify()
    {
        // scan internal nodes backwards.
        for(int r = parent(size() - 1); r >= 0; r--)
            downheap(r);
    }
}
