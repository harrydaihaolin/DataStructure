# Priority Queue

-	A priority queue stores a collection of entries
	-	Each entry is a pair (key, value)
	-	Main methods:
		-	insert(k,v)
			-	inserts an entry with key k and value v
		-	removeMin()
			-	rmeoves and returns the entry with smallest key
			or null if the pq is empty
		-	Min()
			-	returns, but does not remove, an entry with 
			smallest key, or null if the pq is empty.
		-	size() isEmpty()
	
### Total order relations
-	keys in a PQ can be objects which an order is defined.
-	Two distinct entries in a PQ can have the same key.
-	mathematical relations
	-	x <= y | y >= x
	-	x <= y & y >= x -> x = y
	-	x <= y & y <= z -> x <= z

### Entry ADT
-	An `entry` in a PQ is a key-value pair.
-	PQ store entries to allow for efficient insertion and removal
based on keys.
-	getKey()
	-	returns the key for the entry.
-	getValye()
	-	returns the value for the entry.
### Comparator ADT
-	A comparator encapsulates the actions of comparing 2 
objects according to a given order
-	A generic PQ uses an auxiliary relation
-	The comparator is external to the keys being compared.
-	Entry compares using comparator
-	compare(a,b)
	-	returns an integer i such that
		-	i < 0 if a < b
		-	i = 0 if a = b
		-	i > 0 if a > b
		- or errors if cannot be compared.
### Sequence-based priority Queue
-	Implementation using an unsorted list
-	`insert`
	-	takes O(1) time since we can insert the item 
	at the beginning or end of the sequence.
-	`removeMin` and `min` 
	-	takes O(n) time since we have to traverse the entire
	sequence to find the smallest key.
-	Implementation using a sorted list
-	`insert`
	-	takes O(n) time since we have to find the place where to store item.
-	`removeMin` and `min`
	-	takes O(1) time since the smallest key is at the beginning.
### Priority Queue Sorting
	-	We can use a PQ to sort a list of comparable elements.
		-	insert the elements one by one with a series of `insert` operations
		-	Remove the elements in sorted order with a series of `removeMin` operations.
	-	The running time depends on the PQ implementation. 
```
Algorithm PQ-Sort(S,C)
	Input: list S, Comparator C for the elements of S
	Output: list S sorted in increasing order according to C
	P <-- priority queue with comparator C
	while !S.isEmpty()
		e <-- S.remove(S.first())		# remove the first element
		P.insert(e, NULL)				
	while !P.isEmpty()
		e <-- P.removeMin().getKey()	# remove the minimum 
		S.addLast(e)					# add the last elements.
```

### Selection Sort
-	Selection sort is variation of PQ-Sort where the PQ is implemented with an unsorted sequence.
-	Running time
	-	Inserting the elements into the PQ with n operations takes O(n) time
	-	Removing the elements in sorted order from the PQ with n `removeMin` operations takes
	1 + 2 + ... + n
	-	O(n^2)
### Insertion Sort
-	Insertion sort is the variation of PQ-sort where 
the PQ is implemented with an sorted sequence.
-	Running time
	-	`insert` operation takes 1 + .. + n
	-	`removeMin` operation takes O(n) time
	-	InsertionSort takes O(n^2) time
### In-Place Insertion sort
-	instead of using an external data structure,
we can implement selection-sort and insertio-sort in-place.
-	a portion of the input sequence itself serves as the PQ
-	we keep sorted the initial portion of the sequence.
-	swap the value.


































































