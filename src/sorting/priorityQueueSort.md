## priorityQueueSort

```
Algorithm PQ-sort(S, C)
  Input: list S, comparator C for the elements of S
  Output: list S sorted in increasing order according to C
  P <-- priority queue with comparator C
  while !S.isEmpty()
    e <-- S.remove(S.first())
    P.insert(e, null)
  while !P.isEmpty()
    e <-- P.removeMin().getKey()
    S.addLast(e)
    
```

### Selection Sort

Selection sort is the variation of PQ-sort where the pq is implemented with an `unsorted` sequence.

Basic idea: <br/>
  Inserting the elements into sorted order from the PQ with n insert operations takes O(N) time.
  Removeing the elements in sorted order from the PQ with n removeMin operations takes time propotional to 1 + 2 + ... + n.
  Total time is O(n^2) time.
  
### Insertion Sort

Insertion sort is the variation of PQ sort where the PQ is implemented with a `sorted` sequence

Basic idea:

  Inserting the elements into the PQ with n insert operations takes time propotional to 1 + 2 + ... + n
  
  Removing the elements in `sorted order` from the PQ with a series of n removeMin operations takes O(N) time
  
To do this in place:

  A portion of the input sequence itself serves as the PQ
  
  we keep sorted the initial portion of the sequence
  
  we can use swaps instead of modifying the sequence
  
  Total time is O(n^2) time.
 
