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
		
		if(!map.get(source).contains(destination))
			(map.get(source)).add(destination);
		if(isBirdirectional && !map.get(destination).contains(source))
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
	
	public void printGraphList() {
		for(Iterator<T> itr = map.keySet().iterator(); itr.hasNext(); ) {
			T currVertex = itr.next();
			System.out.print(currVertex + " : ");
			for(Iterator<T> edgeItr = map.get(currVertex).iterator(); edgeItr.hasNext(); ) {
				T val = edgeItr.next();
				System.out.print(val + " ");
			}
			System.out.println();
		}
		
	}

	public void traverseDFS() {
		ArrayList<T> traversedBFS = new ArrayList<T>();
		Map<T, Boolean> visited = new HashMap<>();
		Set<T> keySets = map.keySet();
		
		// Set all visited to false
		for(Iterator<T> keySetItr = keySets.iterator(); keySetItr.hasNext(); ) {
			visited.put(keySetItr.next(), false);
		}
		
		if(keySets.size() > 0) {
			Stack<T> stack = new Stack<>();
			for(Iterator<T> keySetItr = keySets.iterator(); keySetItr.hasNext(); ) {
				T key = keySetItr.next();
				
				if(!visited.get(key)) {
					// Add elem in queue
					stack.add(key);
					visited.put(key, true);
					while(!stack.isEmpty()) {
						T currKey = stack.pop();
						traversedBFS.add(currKey);
						List<T> neighborVertexes = map.get(currKey);
						for(int i=0; i<neighborVertexes.size() ; i++) {
							if(!visited.get(neighborVertexes.get(i))) {
								stack.add(neighborVertexes.get(i));
								visited.put(neighborVertexes.get(i), true);
							}
						}
					}
				}
			}
		}
		
		System.out.print("Tree BFS: ");
		for(int i=0; i<traversedBFS.size() ; i++) {
			System.out.print(traversedBFS.get(i) + " ");
		}
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
		g.addEdge(1, 2, true);
		g.addEdge(2, 3, true);
		g.addEdge(2, 7, true);
		g.addEdge(2, 3, true);
		g.addEdge(7, 5, true);
		g.addEdge(3, 5, true);
		g.addEdge(4, 6, true);

		// Gives the no of vertices in the graph.
		g.getVertexCount();

		// Gives the no of edges in the graph.
		g.getEdgesCount(true);
		
		// Print graph
		g.printGraphList();
		
		// bfs traversal
		
		g.traverseDFS();

	}
}
