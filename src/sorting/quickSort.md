## QuickSort

### Quick Sort is a randomized sorting algorithm based on the divide and conquer paradigm
#### Divide pick a random element x (called pivot) and partition S into:
      1. L: elements less than x
      2. E: elements equal x
      3. G: elemetns greater than x
#### Recur: sort L and G
#### Conquer: join L, E and G.
#### The worst case here is when the pivot is the unique minimum or maximum element, then it would be O(n^2).

```
Algorithm partition(S, p)
  Input: sequence S, position p of pivot
  Output: subsequences L,E,G of the elements of S less than, equal to or greater than the pivot, resp.
  L,E,G <-- empty queue sequences
  X <-- S.remove(p)
  while !S.isEmpty(p)
    y <-- S.deque
    if y < x
      L.enque(y)
    else if y = x
      E.enque(y)
    else
      G.enque(y)
  return L,E,G    // concatenate queues.
```
```
Algorithm inPlaceQuickSort(S, l, r)
  Input: sequence S, ranks l and r
  Output: sequence S with the elements of rank between l and r
          rearranged in increasing order
  if l >= r return
  i <-- a random integer between l and r
  x <-- S[i]                                        // pivot that we chose
  <h, k> <--  Partition(S, x)                       
  inPlaceQuickSort(S, l, h-1)
  inPlaceQuickSort(S, k+1, r)
```
