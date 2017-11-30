# DepthFirstSearch

-	DFS is a general graph traversal techinque
-	DFS(G)
	-	Visits all the vertices and edges of G
	-	Determines whether G is connected
	-	Computes the connected componenets of G
	-	Computes a spanning forest of G
	-	DFS on a graph with n vertices and m edges
	takes O(n+m) time
	-	DFS can be further extended to solve other graph 
	problems
		-	Find and report a path between 2 given vertices
		-	Find a cycle in the graph
```
Algorithm DFS(G,u):
	Input: A graph G and a vertex u of G
	Output: a collection of vertices reachable form u, with their discovery 
	edges
	Mark vertex u as visited.
	for each of u's outgoing edges, e = (u,v) do
		if vertex v has not been visited then
			Record edge e as the discovery edge for vertex v.
			Recursively call DFS(G, v)
```

### Maze Traversal
-	DFS is similar to a classic strategy for exploring a maze.

### Properties
-	DFS(G, v) visits all the vertices and edges in the connected components
of v
-	The discovery edges labeled by DFS(G,v) form a spanning tree of the connected
components of v

### Analysis
-	Setting/getting a vertex/edge takes O(1);
-	each vertex is labeled twice
	-	once as unexplored
	-	once as visited
-	Each edge is labeled twice 
	-	once as unexplored
	-	once as `discovery` or `back`
-	Method `incidentEdges` is called once for each vertex.
-	DFS runs in O(n+m) time provided the graph os represented by the adjacency list
structure

### Path Finding

```
Algorithm pathDFS(G,x,v)
	setLabel(x, VISITED)
	S.push(x)		# stack
	if x = v return S.elements()
	for all e is within G.incidentEdges(x)
		if getLabel(e) = UNEXPLORED
		w <-- opposite(x,e)
		if getLabel(w) = UNEXPLORED
			setLabel(e, DISCOVERY)
			S.push(e)
			pathDFS(G,w,v)
			S.pop(e)
	else
		setLabel(e, BACK)
```
### Cycle Finding
-	This is to find a simple cycle.
-	Using stack to keep track of the path 
-	As soon as the edge is encountered, 
return the cycle as the portion of stack from
the top vertex v to vertex w.
```
Algorithm cycleDFS(G,v)
	setLabel(v, VISITED)
	S.push(v)
	for all e is within G.incidentEdges(v)
		if getLabel(e) = UNEXPLORED
			w <-- opposite(v,e)
			S.push(e)
			if getLabel(w) = UNEXPLORED
				setLabel(e, DISCOVERY)
				cycleDFS(G,w)
				S.pop(e)
			else
				T <-- new empty stack
				repeat
					o <-- S.pop()
					T.push(o)
				until o = w
				return T.elements()
```
### Entire Graph
```
Algorithm DFS(G)
	Input: Graph G
	Output: labelling of the edges of G
	as discovery edges and back edges
	for all u is within G.vertices()
		setLabel(u, UNEXPLORED)
	for all e is within G.edges()
		setLanel(e, UNEXPLORED)
	for all v is within G.vertices()
		if getLabel(v) = UNEXPLORED
			DFS(G,v)
```
```
procedure DFS(G,v)
	Input: graph G and a start vertex v of G
	Output: labelling of the edges of G in the 
	connected component of v as discovery edges 
	and back edges
	setLabel(v, VISITED)
	for all e is within G.incidentEdges(v)
		w <-- opposite(v,e)
		if getLabel(w) = UNEXPLORED
			setLabel(e, DISCOVERY)
			DFS(G,w)
		else
			setLabel(e, BACK)
```














