# Breadth-First Search
-	BFS is a general graph traversal technique
-	A BFS traversal of a graph G
	- 	Visited all vertices and edges of G
	- 	Determines whether G is connected
	- 	Computes connected components of G
	- 	Computes a spanning forest of G
-	BFS takes O(n+m) time
-	BFS can be extended to solve other graph problems.
	-	Find a path with minimum number of edges between
	2 vertices
	-	Find a simple cycle if there is one

```
# UNEXPLORED = UNEXP
procedure BFS(G,s)
	i <-- 0
	L[i] <-- new empty queue
	L[i].enque(s)
	setLabel(s, VISITED)
	while !L[i].isEmpty()
		L[i+1] <-- new empty queue  # next level
		for all v is within L[i].elements()
			for all e is within G.incidentEdges()
				if getLabel(e) = UNEXP
					w <-- opposite(v,e)
					if getLabel(w) = UNEXP
						setLabel(e, DISCOVERY)
						setLabel(w, VISITED)
						L[i+1].enque(w)
					else
						setLabel(e, CROSS)
		i <-- i+1		# start next level
	end while
```
### Properties
-	G(s) = connected components of s
-	BFS(G, s) visits all the vertices and edges of G(s)
-	Discovery edges labeled by BFS(G,s) form a spanning tree T(s) of G(s)
-	For each vertex v in level L(i)
	-	The path of T(s) from s to v has i edges
	-	Every path from s to v in G(s) has at least i edges

### Analysis
-	Setting/Getting a vertex/edge label takes O(1) time
-	Each vertex is labeled twice
-	Each edge is label twice ( as DISCOVERY OR CROSS)
-	Each vertex is inserted once into a sequence L(i)
-	Method incidentEdges is called once for each vertex
-	BFS runs in O(n+m) time provided the graph is represented










