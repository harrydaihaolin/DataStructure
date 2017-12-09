# Search Tree
-	Binary Search Tree
	-	Ordered Maps
		-	keys are assumed to come from a total order 
		-	items are stored in order
		-	ordered maps support nearest neighbor queries:
			-	item with largest key less than or equal to k
			-	item with smallest key greater than or equal to k
			-	hash tables cannot perform such ordered map operations.
-	Binary Search
	-	Binary Search can perform nearest neighbor queries on an ordered map that 
	is implemented with an array, sorted by key
		-	each step the number of candidate items are halved.
		-	terminates after O(logN) steps.
	-	Search Tables
		-	A search table is an ordered map implemented by means 
		of a sorted sequence
			-	store the items in an array-based sequence, sorted by key
			-	use an external comparator
		-	Performance
			-	searches takes O(logN) time ( binary search )
			-	inserting takes O(n) time, since in the worst case we have 
			to shift n times to make room for the item.
			-	removeing takes O(n) time, since in the worst case we have 
			to shift n times to compact the item after the removal
-	Binary Search Tree
	-	a BST is a binary tree:
		-	internal nodes
		-	external nodes
		-	search property
			-	the key at any node is 
				-	all keys in the left tree
				-	all keys in the right tree
	-	inorder traversal can visit its `keys` in increasing order
-	Search 
	-	to search for a key k we trace a downward path starting at root
	-	the next node visited depends on the comparison of k with the key
	of current node
	-	if we searc an external node, the key is not found.
```
Algorithm TreeSearch(k, node)
	if isExternal(node) return node						# failed
	if k = key(node) return node						# found
	if k < key(node) return TreeSearch(k, left(node))	# search left subtree
	if k > key(node) return TreeSearch(k, right(node))	# search right subtree
```
-	Insertion
	-	to perform operation put(k,v)
	we search for key k
	-	assume k is not in the tree,
	ket w be the external node reached 
	by the tree
	-	expand w into an internal node
	-	insert (k,v) in it.
-	Deletion
	-	remove(k)
	-	assume key k is in the tree, let 
	k be the node storing k
	-	if x has an external child y, we
	remove x and y from the tree with the
	operation `removeExternal(y)`, which
	removes y and its parent x
	-	suppose both children of node x are 
	internal 
		-	find the internal node w that follows
		x in the inorder traversal
		-	copy key(w) into node x
		-	remove node w and its left child z
-	Performance
	-	Consider an ordered map with n items
	implemented by a BST of height h
		-	the space used is O(n)
		-	`get put remove` takes O(h) time
	-	h is O(n) in the worst case
	-	O(logN) in the best case
### AVL Trees
-	AVL trees are height balanced BSTs
-	height balance property: heights of siblings 
can differ by at most 1
-	The height of an AVL tree storing n keys is O(logN)
-	Dictionary operations Overview
	-	`Search` remain in the same as in BSTs
	-	The worst case time is O(logN)
	-	`insert` `Delete` start off as in BSTs,
	but may alter the AVL tree structure. Hence they
	may affect the height balance property and require
	further restructuring of the tree to restore that
	property.
	-	all dictionary operations can be done in O(logN) 
	time in the worst case.
-	AVLTree Class
	-	`AVLTree` class extends the `TreeMap` class which 
	nests the BalancableBinaryTree class
	-	The latter uses an added aux field per node with 
	getAux() & setAux(). These extensions are dormant in Treemap
	-	`aux` is used as node height in AVLTree
	-	TreeMap provides hooks for the following operations 
	that are overrided to specific use by AVLTree
		-	rebalanceAccess()
		-	rebalanceInsert()
		-	rebalanceDelete()
	-	insert
		-	(top-down) insert item as in BST insert:
			-	follow the search path of insertion key down the tree.
			-	if insertion key is found then return
			-	else expand the external node w you reached at 
			into the node and store the new item (key,value) in it.
		-	(bottom-up) repair balance
			-	move up along the ancestral path of w update node
			heights; and repair any unbalanced node on that path.
	-	Rotation
		-	rotation properties
			-	preserves the `search property`
			-	may affect the `height balance property`
			-	local restructuring takes O(1) time and can be applied
			to any accessed internal link of the BST
			-	`heights` of nodes x and y may change, and are updated too.
	-	Insert: Rebalancing strategy
		-	probe upward
			-	starting at the inserted node, traverse towards the
			root until an imbalance is found.
		-	repair
			-	the repair is called `trinode restructuring`




























































