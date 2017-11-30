# Directed Graphs
-	A `digragh` is a gragh whose edges are all directed

### Digraph Properties
-	A graph G=(V,E) such that
	- 	Each edge goes in one direction
	-	Edge (a,b) goes from a to b, but not b to a
-	If G is simple, m <= n(n-1)

### Digraph Application
-	Scheduling: edge (a,b) means task a must be 
completed before task b can be started.

### Directed DFS
-	We can specialize the traversal algorithms
to digraphs by traversing edges only along their
direction
-	In the directed DFS we have 4 types of edges
	-	discovery edges
	-	back edges
	-	forward edges
	-	cross edges
-	A directed DFS starting at a vertex s 
determines the vertices reachable from s

### Reachability
-	DFS tree rooted at v:
	-	vertices reachable from v via directed paths
-	Strong Connectivity
	- 	Each vertex can reach all other vertices

