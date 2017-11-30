# Graph

A graph is a pair (V,E), where
  - V is a set of nodes called `vertices`
  - E is a collection of pairs of vertices, called `edges`
  - Vertices and edges are positions and store elements.
  
## Directories
- [Types](#Types)
- [Terminology](#Terminology)

### Types
- Directed Edge
  - ordered pair of vertices (u,v)
  - first vertex u is the origin
  - second vertex v is the destination
- Undirected Edge
  - unordered pair of vertices (u,v)
- Directed graph
  - all the edges are directed
- Undirected graph
  - all the edges are undirected
### Terminology
-  End vertices of an edge
-  Edges incident on a vertex (all the edges connected on one node)
-  Adjacent vertices
-  Degree of a vertex	(the number of edges incident on one node)
-  Parallel edges  ( two nodes connected both ways)
-  Self-loop ( self-connected)
 -  Path
    - sequence of alternating vertices and edges
    - begins with a vertex
    - ends with a vertex
    - each edge is preceded and followed by its endpoints.
 -	Simple Path
 		- path such that all its vertices and edges are distinct. ( no going back)
 - 	Cycle
 		- circular sequence of alternating vertices and edges.
		- each edge is preceded and followed by its endpoints.
 -	Simple Cycle
 		- ( no going back)
### Properties
-	sum of degree = 2 * number of edges
-	m <= n(n-1)/2
### Vertices and Edges
-	A `graph` is a colletion of vertices and edges
-	A `Vertex` is lightweight object that stores an arbitrary element 
provided by the user
-	An `Edge` stores an associated object, retrieved with the element 
method.
###	Graph	ADT
- numVertices()
-	vertices()
-	numEdges()
-	edges()
-	getEdge(u,v)
- endVertices(e)
-	opposite(v, e)
- outDegree(v)
-	inDegree(v)
- outgoingEdges(v)
-	incomingEdges(v)
-	insertVertex(x)
-	insertEdge(u, v, x)
-	removeVertex(v)
-	removeEdge(e)
### Edge List
-	Vertex object
	- element
	- reference to position in vertex sequence
- Edge object
	- element
	- origin vertex object
	-	destination vertex object
	-	reference to position in edge sequence
-	Vertex sequence
	- sequence of vertex objects
-	Edge sequence
	-	sequence of edge objects
### Adjacency Map Structure
-	Incidence sequence for each vertex
	-	sequence of references to adjacent vertices, each mapped to edge
	object of the incident edge
-	Augmented edge objects
	- references to associated positions in incidence sequences of end
	vertices
### Adjacency Matrix Structure
- Edge list structure
-	Augmented vertex objects
- 2D-array adjacency array
	-	Reference to edge object for adjacent vertices
	-	Null for non-adjacent vertices
### Subgraphs
-	A subgraph S of a graph G is a graph such that
	- The vertices of S are a subset of the vertices of G
	-	The edges of S are a subset of the edges of G
- A spanning subgraph of G is a subgraph that contains all the 
vertices of G
### Connectivity
- A graph is connected if there is a path between every pair of vertices
-	A connected componenet of a graph G is a maximal connected subgraph of G
### Trees and Forests
-	A tree is an undirected graph T such that	(different from binary tree)
	- T is connected
	-	T has no cycles
- A forest is an undirected graph without cycles
-	The connected components of a forest are trees 
### Spanning Trees and Forests
-	A spanning tree of a connected graph 






