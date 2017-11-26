package sorting;

import Map.Comparator;

import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class MergeSort<K>
{
    /*--------------- LinkedList based merge sort -----------------------------*/
    private static <K> void merge(Queue<K> S1, Queue<K> S2, Queue<K> S, Comparator<K> comp)
    {
        while (!S1.isEmpty() && !S2.isEmpty())
        {
            if (comp.compare(S1.peek(), S2.peek()) < 0)
                S.add(S1.poll());           // take next element from S1
            else
                S.add(S2.poll());           // take next element from S2
        }

        while (!S1.isEmpty())
            S.add(S1.poll());               // move any elements that remain in S1
        while (!S2.isEmpty())
            S.add(S2.poll());               // move any elements that remain in S2
    }

    private static <K> void mergeSort(Queue<K> S, Comparator<K> comp)
    {
        int n = S.size();
        if (n<2) return;            // queue is trivially sorted.
        // divide
        Queue<K> S1 = new LinkedBlockingQueue<>();
        Queue<K> S2 = new LinkedBlockingQueue<>();
        while (S1.size() < n/2)
            S1.add(S.poll());          // move the first n/2 elements to S1
        while (!S.isEmpty())
            S2.add(S.poll());          // move remaining elements to S2
        // conquer (with recursion)
        mergeSort(S1, comp);           // sort first half
        mergeSort(S2, comp);           // sort second half
        // merge results
        merge(S1, S2, S, comp);        // merge sorted halves back into original
    }

    /*--------------- array based merge sort -----------------------------*/
    private static <K> void merge(K[] S1, K[] S2, K[] S, Comparator<K> comp)
    {
        int i = 0, j = 0;
        while (i + j < S.length)
        {
            if (j == S2.length || (i < S1.length && comp.compare(S1[i], S2[j]) < 0))
            {
                S[i+j] = S1[i++];           // copy ith element of S1 and increment i
            }
            else
            {
                S[i+j] = S2[j++];           // copy jth element of S2 and increment j
            }
        }
    }

    private static <K> void mergeSort(K[] S, Comparator<K> comp)
    {
        int n = S.length;
        if(n < 2) return;;          // array is trivially sorted
        // divide
        int mid = n/2;
        K[] S1 = Arrays.copyOfRange(S, 0, mid);         // copy of first half
        K[] S2 = Arrays.copyOfRange(S, mid, n);               // copy of second half
        // conquer
        mergeSort(S1, comp);
        mergeSort(S2, comp);
        // merge results
        merge(S1, S2, S, comp);
    }
    /*--------------- non-recursive merge sort -----------------------------*/
    private static <K> void merge(K[] in, K[] out, Comparator<K> comp, int start, int inc)
    {
        int end1 = Math.min(start + inc, in.length);            // boundary for run 1
        int end2 = Math.min(start + 2 * inc, in.length);        // boundary for run 2
        int x=start;                                            // index into run 1
        int y=start+inc;                                        // index into run 2
        int z=start;                                            // index into output
        while (x < end1 && y < end2)
        {
            if (comp.compare(in[x], in[y]) < 0)
                out[z++] = in[x++];                             // take next from run 1
            else
                out[z++] = in[y++];                             // take next from run 2
        }
        if (x < end1) System.arraycopy(in, x, out, z, end1-x);          // copy rest of run 1
        else if (y < end2) System.arraycopy(in, y, out, z, end2-y);     // copy rest of run 2
    }

    private static <K> void mergeSortBottomUp(K[] original, Comparator<K> comp)
    {
        int n = original.length;
        K[] src = original;                     // alias for the original
        K[] dest = (K[]) new Object[n];         // safe cast and make a new temp array
        K[] temp;                               // referenced used only for swapping
        for(int i=1; i < n; i *= 2)             // each iteration sorts all runs of length i
        {
            for(int j = 0; j < n; j += 2*i)     // each pass merges two runs of length i
                merge(src,dest,comp,j,i);
            temp = src;                         // swap roles of arrays
            src = dest;
            dest = temp;
        }
        if (original != src)
            System.arraycopy(src, 0, original, 0, n);
    }
}
