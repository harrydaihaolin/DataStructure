# Maps

-	A map models a searchable collection of key-value entries
-	The main operations of a map are for searching, inserting and deleting entries
-	Multiple entries with the same key are not allowed.

### ADT
-	get(k) if the map has key k then return its value else null
-	put(k,v) insert entry (k,v) into the map M; if key k is not in M then return null
else return old value associated with k
-	remove(k) if the map has key k then remove it from M and return its value else null
-	entrySet() return an iterable collection of entries in M
-	keySet() return an iterable collection of keys in M
-	values() return an iterator of the values in M
-	size()
-	isEmpty()

### list-based map
-	Implement a map using an unsorted list
	- store the items of the map in a list S (doubly linked list), in arbitrary order

```
Algorithm get(k)
	B <-- M.positions()						# B is an iterator of the positions in M
	while B.hasNext() do
		p <-- B.next()						# the next position in B
		if p.element().getKey() = k then
			return p.element().getValue()
	return null								# there is no entry with key equal to k
```
```
Algorithm put(k,v)
	B <-- M.positions()
	while B.hasNext() do
		p <-- B.next()
		if p.element().getKey(0 = k then
			t <-- p.element().getValue()
			M.set(p, <k,v>)
			return t						# return the old value
	M.addLast(<k,v>)
	n++
	return null								# there was no entry with key equal to k
```
```
Algorithm remove(k)
	B <-- M.positions()
	while B.hasNext() do
		p <-- B.next()
		if p.element().getKey() = k then
			t <-- p.element().getValue()
			M.remove(p)
			n--
			return t
	return null
```

### Performance
-	put, get and remove takes O(n) time in the worst case
-	the unsorted list implementation is effective only for maps of small size
where puts are most common operations, searches and removals are rarely performed.


### Hash Tables
-	A `hash function h` maps keys of a given type to integers in a fixed interval [0, N-1]
-	The integer h(k) is called the hash value of key k
-	A `hash table` for a given key type consists of 
	-	hash function h
	-	array of size N
-	the goal of implementing is to store item (k,v) at index i = h(k)
-	functions
	-	hash code
		-	h1: keys -> integers
	- 	compression function
		-	h2: integers -> [0, N-1]
-	the hash code is applied first, then compression function
is applied next on the result. h(x) = h2(h1(x))
-	The goal is to disperse the key in a random way.
### Hash codes
-	memory address
	-	reinterpret the memory address of key object as
	an integer
-	integer cast
	-	reinterpret the bits of the key as an integer
- 	Component sum
	-	partition the bits of the key into components
	of fixed length and we sum the components
-	Polynomial accumulation
	-	partition the bits of the key into a sequence 
	of components of fixed length
	-	p(z) = a[0] + a[1]z + a[2]z^2 + ... + a[n-1]z^n-1
	-	eg. for strings.
- 	Compression function
	-	Division
		-	h2(y) = y mod N
		-	size N of the hash table is `prime`
### Collision Handling
-	it occurs when different elements are mapped to the same cell
-	seperate chaining
	-	linked list of entries
-	Open addressing: Linear Probing
	-	the colliding item is placed in a different cell of the table
	- 	`Linear Probing` handles collisions by placing the colliding item
	in the next available table cell
	-	each cell inspected is called `probe`
	-	colliding items lump together to cause a longer sequence of probes
-	searching 
	-	get(k)
		- 	start at cell h(k)
		-	probe consecutive locations until
			-	an item with key k is found
			-	empty cell is found
			-	N cells have been successfully probed.
```
Algorithm get(k)
	i <-- h(k)
	p <-- 0
	repeat
		c <-- A[i]
		if c = NULL return null
		else if c.getKey() = k
			return c.getValue()
		else
			i <-- (i+1) mod N
			p <-- p+1
	until p = N
	return null
```
-	Updates
	-	To handle insertions and deletions, we introduce a `DEFUNCT` which replaces deleted elements
	-	remove(k)
		-	search for an entry with key k
		-	if entry is found, replace it with DEFUNCT and return value
			else null
	-	put(k,v)
		-	throw an exception if the table is full
		-	start at cell h(k)
		-	probe consecutive cells 
-	Double Hashing	(optional)
-	Performance
	-	O(n) worst case time for `search insert remove`
	-	the load facter a = n/N affects performance
	-	assuming the hash values are random
		-	expected time is 1/(1-a)
		-	O(1) expected time of all the dictionary operations
		-	in practice, hashing is very fast provided the load factor
		is not clost to 100%
### Skip Lists
-	`skip list` for a set S of distinct (key,value) items is 
a series of lists S0,S1... Sn such that
	-	each list Si contains the special key -infinity and +infinity
	-	list S0 contains the keys of S in non-decreasing order
	-	Each list is a subsequence of the previous one
	-	list Sh contains only the 2 special keys
-	Search
	- 	start at the first position of the top list
	-	at the current position p, we compare x with y <-- key(next(p))
		-	x=y: return element(next(p))
		-	x>y: scan forward
		-	x<y: scan backward
	-	if we try to drop down past the bottom list, return null
-	Randomized Algorithm
	-	A randomized algorithm performs coin tosses to control its execution
	-	it contains statements of the type.
	-	its running time depends on the outcomes of the coin tosses.
	-	`expected running time` of a randomized algorithm based on
		-	coins are unbiased
		-	coin tosses are independent
	-	The worst case running time of a randomized algorithm is often large but 
	has very low probability
	-	We use a randomized algorithm to insert items into a skip list
### Insertion
-	To insert an entry (k,v) into a skip list, we use a randomized algorithm
	-	we repeatly toss coins until we get tails, we denote with i the number of times the 
	coin came up heads.
	-	if i >= h, we add to the skip list new lists, each containing only the two special keys.
	-	we search for k in the skip list and find the position of the items
	with the largest key less than k in each list
	-	for j <-- 0, ... ,i we insert item (k,v) into list S(j) after position p(j)
### Deletion
-	To remove an entry with key k from a skip list, we do:
	-	we search for k in the skip list and find the positions p0,p1,....pi
	of items with key k, where position p(j) is in list S(j)
	-	we remove positions from the list
	-	we remove all but one list containing only the two special keys
### Implementation
-	using `quad-nodes`
	-	entry
	-	link to the node prev
	-	link to the node next
	-	link to the node below
	-	link to the node above
	-	`PLUS_INF and MINUS_INF`
-	Space usage
	-	depends on the random bits used by each invocation of 
	the insertion algorithm
	-	use 2 facts
		-	the probability of getting i consecutive heads is 1/2
		-	if each of n entries is present in a set with probability p,
		the expected size of the set is np
		-	By fact1, we insert an entry in list S(i) with 1/2
		-	By fact2, the expected size of list S(i) is n/2^i
		- 	The expected space usage of a skip list with n items is O(n)
-	height
	-	running time of the search and insertion is affected by height h
	-	with high probability a skip list with n items has height O(logN)
	-	Consider a skip list with n entries
		-	By fact1, we insert an entry in list S(i)
		-	By fact2, the probability that list S(i) has as least one item
		is at most n/2^i
-	Search and update times
	-	the search time of a skip list is 
		-	number of drop-down steps + number of scan-forward steps.
	- 	drop-down steps are bounded by the height of skip list thus O(logN)
	-	scan forward steps is associated with former coin toss that gave tails, thus O(logN)
	-	The expected time for a search, insert or delete is O(logN)
### Set
-	A set is an unordered collection of elements, without duplicates
-	multiset is set-like container that allows duplicates
-	multimap is similar to a traditional map, in that it associates
values with keys (it can map to multiple values with the same key)
### ADT
-	add(e)
-	remove(e)
-	contains(e)		
-	iterator()		
-	addAll(T)		updates S to also include all elements of set T, effectively replacing S by S UNION T
-	retainAll(T)	updates S so that it only keeps those elements that are also elements of set T, effectively replacing S by S INTERSECTS T
-	removeAll(T)	updates S by removing any of its elements that also occur in set T, effectively replacing S by S - T
### Storing
-	implemented with a list
-	elements are stored sorted in canoical ordering
-	space used is O(n)
### Generic Merging
-	generalized merge of 2 sorted lists A and B
-	aux methods
	-	aIsLess
	-	bIsLess
	-	bothAreEqual
-	runs in O(n(a) + n(b)) time provided the aux methods runs in O(1) time
```
Algorithm genericMerge(A,B)
	S <-- Empty sequence
	while !A.isEmpty() & !B.isEmpty()
		a <-- A.first().element()
		b <-- B.first().element()
		if a < b
			aIsLess(a,S)
			A.remove(A,first())
		else if b < a
			bIsLess(b,S)
			B.remove(B.first())
		else
			bothAreEqual(a,b,S)
			A.remove(A.first())
			B.remove(B.first())
	while !A.isEmpty()
		aIsLess(a,S)
		A.remove(A.first())
	while !B.isEmpty()
		bIsLess(b,S)
		B.remove(B.first())
	return S
```

### Multimap
-	a multimap can store multiple entries with same key
-	implement a multimap by a map M'
	-	for every key k in M, let E(k) be the list of entries of M with key k
	-	the entries of M' are the pairs(k, E(k))
### ADT
-	get(k)
-	put(k,v)
-	remove(k,v)
-	removeAll(k)	remove an entry mapping key k to value v from the multimap
-	size()
-	entries()		all the entries
-	keys()			returns a collection of keys including duplicates
-	keySet()		returns a set of keys without duplicates
-	values()	


















