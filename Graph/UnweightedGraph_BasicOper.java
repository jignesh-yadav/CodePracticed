// Java program to implement Graph
// with the help of Generics

import java.util.*;

class Graph<T>{
	Map<T, List<T>> map = new HashMap<>();
	
	public void addVertex(T vertex) {
		map.put(vertex, new ArrayList<T>());
	}
	
	public void addEdge(T source, T destination, boolean isBirdirectional) {
		if(!map.containsKey(source))
			addVertex(source);
		if(!map.containsKey(destination))
			addVertex(destination);
		
		(map.get(source)).add(destination);
		if(isBirdirectional)
			(map.get(destination)).add(source);
	}

	public void getVertexCount() {
		System.out.println("Total vertex count: " + map.keySet().size());
	}
	
	public void getEdgesCount(boolean isBidirectional) {
		int totalEdgeCnt = 0;
		Set<T> keySet = map.keySet();
		for(Iterator<T> itr=keySet.iterator(); itr.hasNext(); ) {
			totalEdgeCnt += map.get(itr.next()).size();
		}
		if(isBidirectional) {
			totalEdgeCnt /= 2;
		}
		
		System.out.println("Total edge count: " + totalEdgeCnt);
	}
	
	public void hasEdge(T source, T destination) {
		System.out.println("Edge " + source + ", " + destination + " : " +
				(map.containsKey(source) ?
										  (map.containsKey(destination) ? map.get(source).contains(destination) 
																	  : false) 
										 : false)); 
	}
	
	public void hasVertex(T source) {
		System.out.println("Vertex " + source + " exists : " + map.containsKey(source));
	}
}

// Driver Code
public class Hw {

	public static void main(String args[])
	{
		// Object of graph is created.
		Graph<Integer> g = new Graph<Integer>();

		// Graph
		// edges are added.
		// Since the graph is bidirectional,
		// so boolean bidirectional is passed as true.
		g.addEdge(0, 1, true);
		g.addEdge(0, 4, true);
		g.addEdge(1, 2, true);
		g.addEdge(1, 3, true);
		g.addEdge(1, 4, true);
		g.addEdge(2, 3, true);
		g.addEdge(3, 4, true);

		// Printing the graph
		System.out.println("Graph:\n"
						+ g.toString());

		// Gives the no of vertices in the graph.
		g.getVertexCount();

		// Gives the no of edges in the graph.
		g.getEdgesCount(true);

		// Tells whether the edge is present or not.
		g.hasEdge(3, 4);
		g.hasEdge(2, 1);
		g.hasEdge(5, -1);
		g.hasEdge(34, -45);
		
		// Tells whether vertex is present or not
		g.hasVertex(5);
		g.hasVertex(7);
		g.hasVertex(0);
		g.hasVertex(1);
	}
}
