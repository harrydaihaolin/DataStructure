# Heaps
-	A heap is a binary tree storing keys at its nodes and 
satisfying the following properties.
-	Heap-order: for every internal node v other than the root,
	K(v) >= K(parent(v))
-	Complete Binary-Tree:
	Let h be the height of the heap
	-	there are 2^i nodes of depth i
	-	at depth h, the internal nodes are to
	the left of the external nodes.
-	The `last internal nodes` of a heap is the rightmost
node of the maximum depth
-	A heap storing n keys has height O(logN)
### Heaps and Priority Queues.
-	We can use a heap to implement a PQ
-	We store an item at each internal node.
-	We keep track of the position of the last internal node.
-	`Insertion`
	-	Method `insertItem` of the PQ ADT corresponds to the 
	insertion of a key k to the heap
-	The insertion algorithm consists of 3 steps
	-	Find the insertion node z 
	-	Store k at z
	-	restore the heap-order property
### Upheap
-	After the insertion of a new key k, the heap-order property
may be violated.
-	Algorithm `upheap` restores the heap-order by swapping k along an upward path form the insertion node.
-	`upheap` terminates when the key k reaches the root or a node whose parent has a key smaller than 
or equal to k.
-	Since a heap has height O(logN), `upheap` runs in O(logN) time
### Removal from heap
-	Method `removeMin` for the PQ ADT 
-	algorithm consists of 3 steps.
	-	replace the roots
	- 	remove the w
	-	restore the heap-order
### Downheap
-	After replacing the root key with the key k of the last node
the heap-order property may be violated.
-	`downheap` restores the heap-order property by swapping downpath
-	`downheap` terminates when it reaches a leaf or a node whose children has keys 
greater than or equal to k
-	Since heap height is O(logN), `downheap` runs in O(logN) time

### Updating the last node
-	insertion node can be found by traversing a path of O(logN) node.
	-	go up until a left child or the root is reached.
	-	if a left child is reached, go to the right child.
	-	go down left until a leaf is reached.
### Heap-Sort
-	Consider a PQ with n items implemented by means of a heap.
	-	space used is O(n)
	-	methods `insert` and `removeMin` takes O(logN) time
	-	size() isEmpty() min() takes O(1) time
-	Using a heap-based priority queue, we can sort a sequence of 
n elements in O(NlogN) time
-	it's called `heap-sort`
-	much faster than selection sort or insertion sort.
### Array-based heap implementation
-	represent a heap with n keys by an array of length n
-	for the node at rank i
	-	the left child is at rank 2i+1
	-	the right child is at rank 2i+2
	-	the parent is at rank floor((i-1)/2)
-	links are not stored.
-	Operation `add` corresponds to inserting at rank n+1
-	Operation `remove_min` corresponds to removing at rank n
### Merging two heaps
-	Give 2 heaps and a key k
-	create a new heap with the root node storing k and with 
the two heaps as its subtrees.
-	we perform `downheap` to restore the heap-order property.
### Bottom-up heap construction
-	Construct a heap storing n given keys
using a bottom-up process, doing downheap on nodes "backwards" by rank
-	Phase view: do phases : i = 1.. height
	-	In phase i, apply the merge process to each node r at height i
	-	these nodes have node-disjoint subtrees of size <= 2^i-1 that have
	been turned into heaps in previous phases.
-	recursive view:
	-	downheap in post-order.
### Analysis
-	the worst-case time of a `downheap` with a `proxy path` that 
goes first right and then repeatedly goes left until the bottom of the heap
-	Since each node is traversed by at most 2 proxy paths, the total 
number of nodes of the proxy paths is <= 2n, which is O(n)
-	Thus, bottom-up heap construction runs in O(n) time
-	it's faster than n successive insertions ( which could take O(logN) time
and speeds up the first phase of the heap sort.
### Adaptable Priority Queue
-	An `entry` stores a (key,value) pair
-	getKey(), getValue()
-	insert(k,v) removeMin() min() size() isEmpty()
-	new methods
	-	remove(e): remove and return entry e from PQ
	-	replaceKey(e,k): Replace the key of entry e in PQ with k and return e's old key
	-	replaceValue(e,v): Replace the value of entry e in PQ with v and return e's old value.
### Locating-aware entries
-	A location-aware entry identifies and tracks the location of its (key,value) object within a data 
structure
-	Since entries are created and returned from the data structure itself, it can
return location-aware entries, thereby making future updates easier.
-	List implementation
	-	A location-aware list entry is an object storing 
		-	key
		-	value
		-	position
	-	the position stores the entry
	-	back pointers are updated during swaps.
-	heap implementation
	-	A location-aware heap entry is an object storing 
		-	key
		-	value
		- 	position of entry in the underlying heap
	-	each heap position stores an entry
	-	back pointers are updated during entry swaps.






























