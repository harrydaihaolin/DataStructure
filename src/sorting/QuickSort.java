package sorting;


import Map.Comparator;

import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class QuickSort<K>
{
    public static void main(String[] args)
    {
        Comparator<Integer> comp = new Comparator<Integer>();

        Queue<Integer> S = new LinkedBlockingQueue<>();
        S.add(1);
        S.add(4);
        S.add(3);
        S.add(2);
        S.add(5);
        quickSort(S, comp);
        Integer[] S2 = {1,4,3,2,5};
        System.out.println(Arrays.toString(S.toArray()));
        System.out.println(Arrays.toString(S2));
        quickSortInPlace(S2, comp, 0, S2.length-1);
        System.out.println(Arrays.toString(S2));
    }

    public static <K> void quickSort(Queue<K> S, Comparator<K> comp)
    {
        int n = S.size();           // queue is trivially sorted
        if(n < 2) return;
        // divide
        K pivot = S.peek();
        System.out.println(Arrays.toString(S.toArray()));
        Queue<K> L = new LinkedBlockingQueue<>();
        Queue<K> E = new LinkedBlockingQueue<>();
        Queue<K> G = new LinkedBlockingQueue<>();
        while (!S.isEmpty())
        {
            K ele = S.poll();
            int c = comp.compare(ele, pivot);
            if(c < 0)               // ele < pivot
                L.add(ele);
            else if(c == 0)         // ele = pivot
                E.add(ele);
            else                    // ele > pivot
                G.add(ele);
        }
        quickSort(L, comp);
        quickSort(G, comp);
        while (!L.isEmpty())
            S.add(L.poll());
        while (!E.isEmpty())
            S.add(E.poll());
        while (!G.isEmpty())
            S.add(G.poll());
    }

    private static <K> void quickSortInPlace(K[] S, Comparator<K> comp, int a, int b)
    {
        if(a >= b) return;
        int left = a;
        int right = b-1;
        K pivot = S[b];
        K temp;
        while (left <= right)
        {
            while (left <= right && comp.compare(S[left],pivot) < 0) left++;
            while (left <= right && comp.compare(S[right],pivot) > 0) right--;
            if (left <= right)
            {
                temp = S[left];
                S[left] = S[right];
                S[right] = temp;
                left++;
                right--;
            }
        }
        temp = S[left];
        S[left] = S[b];
        S[b] = temp;
        quickSortInPlace(S, comp, a, left-1);
        quickSortInPlace(S, comp, left+1, b);
    }


}
