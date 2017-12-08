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
-	We can use

