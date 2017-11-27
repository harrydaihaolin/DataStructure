## Merge Sort

#### Divide: partition S into n/2 elements
#### Recur: recursively sort S1 and S2
#### Conquer: merge S1 and S2 into one sorted sequence.

``` 
Algorithm mergeSort(S)
  Input: sequence S with n elements
  Output: sequence S sorted
  if S.size() > 1
    <S1, S2> <-- partition(S, n/2)
    mergeSort(S1)
    mergeSort(S2)
    S <-- merge(S1,S2)
    
Algorithm merge(A,B)
  Input: sorted stack sequences A and B with total n elements
  Output: sorted queue sequence of S = A U B
  
  S <-- empty merged queue sequence 
  while !A.isEmpty() & !B.isEmpty()
    if A.top() < B.top()                  // min(A) < min(B)
    then S.enque(A.pop())                 // merge min(A) into S
    else S.enque(B.pop())                 // merge min(B) into S
  while !A.isEmpty() do S.enque(A.pop())  // merge the leftover
  while !B.isEmpty() do S.enque(B.pop())  // merge the leftover
  
```
