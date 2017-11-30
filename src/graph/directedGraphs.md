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

### Transitive Closure
-	G(star) has the same vertices as G
-	G(star) has a directed edge u -> v
### Computing the TC
-	We can perform DFS starting at each vertex
-	O(n(n+m))
### Floyd-Warshall Transitive Closure
-	
###	DAGs and Topological Ordering
-	A `directed acyclic` graph is a digraph that has
no directed cycles.
-	A `topological ordering` of a digraph is a numbering
V1, ... ,Vn of the vertices such that for every edge (v[i], v[j]),
We have i < j
-	a digraph admits a topological ordering iff it is a DAG

###	Topological Sorting
-	Running time: O(n+m) time 
```
Algorithm TopologicalSort(G)
	H <-- G
	n <-- G.numVertices()
	while H is not empty do
		let v be a vertex with no outgoing edges
		label v <-- n
		n <-- n-1
		remove v from H
```
```
Algorithm topologicalDFS(G)
	Input: DAG G
	Output: topological ordering of G
	n <-- G.numVertices()
	for all u is within G.vertices()
		setLabel(u, UNEXP)
	for all s is within G.vertices()
		if getLabel(s) = UNEXP
			topologicalDFS(G, s)
```
```
procedure topologicalDFS(G,v)
	Input: DAG G and a start vertex v
	Output: labelling of the vertices of G in the DFS
	setLabel(v, VISITED)
	for all e is within G.outEdges(v)
		# outgoing edges
		w <-- opposite(v,e)
		if getLabel(w) = UNEXP
			# e is a discovery edge
			topologicalDFS(G, w)
		else
			# e is a forward or cross edge
	Label v with topological number n
	n <-- n-1
```






















