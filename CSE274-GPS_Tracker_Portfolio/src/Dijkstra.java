//========================================= In Class Notes =================================================
	
		// * (A, A: 0)
		// * (from, to, : timeCost || distCost)
		
		// Visited Vertices = "A E F B D "
		
		// STEP 1 - PULL OUT THE PUMP
		// STEP 2 - DETERMINE IF WE HAVE REACHED OUR "to" Vertex
		// STEP 3 - ELSE LOOP THROUGH RETURN THE CHILDREN
		// STEP 4 - IF IT IS... RETURN... THE COST OF THE PATH
		
		
		// priorityQueue notes: 
		// Take out... check if your at the end
		// if you aren't clone yourself with the children
		// repeat
		// check if it has children
		// repeat...

		// * (A, E : 1)
		// * (A, E, F: 3)
		// * (A, E, F, C : 12)
		// * (A, E, F, D : 4)
		// * (A, D : 8)
		// * (A, B : 3)
		
		// Treat the priority Queue like stack that ranks the best path options
		// Keep the top 3 best options... use as potential (alternative paths_ functionality.
		// * (A, E : 1)
		// * (A, E, F: 3)
		// * (A, E, F, C : 12)
		// * (A, E, F, D : 4)
		// * (A, D : 8)
		// * (A, B : 3)
		// }
		
		// class Path 
		// ArrayList<Vertex>
		// totalCost
		
		
		// class Vertex {
		// symbol
		// address
		// private ArrayList<Edge> edges;
		// HashMap <String: B, int cost: 1>
		// }
		
		// class Graph
		// getChildren(String, Key){
		// }
		
		// findShortestPath(Graph g, Vertex from, Vertex to) {
		// Process... take item out and replace with children
		// 1.) Prime Pump
		// 2.) While (!PQ.isEmpty) { 
		// 		
		//  }
//------------------------------------------------------------------------------------------------------------------

import java.util.ArrayList;
import java.util.PriorityQueue;
	
	public class Dijkstra {


//		public Vertex to;
//		public Vertex from;
//		public int timeCost;
//		public int distCost;
//		public Vertex vertex;
//		public ArrayList<Path> paths;
		
	
//	public ArrayList Path (Vertex from, int totalCost, Vertex to, String pathStr) {
//			this.totalCost = totalCost;
//			this.from = from;
//			this.to = to;
//			Vertex[] visited = {};
//			this.pathStr = pathStr.toString();
//			return paths;
//		}

		public static int totalCost;
		public Path p;
		public static String pathStr = "";
		public static ArrayList<String> rankedPath;
		
		// Walking cost? 

		public static Path shortestPath(Graph graph, String from, String endVertex) {
			totalCost = 0;
			PriorityQueue<Path> queue = new PriorityQueue<Path>();
			ArrayList<String> vertices = new ArrayList<String>();

			queue.add(new Path(from, 0, ""));
			
			while (!queue.isEmpty()) {
				int curr = 0;
				Path p = queue.remove();
				if (p.vertex.equals(endVertex)) {
					pathStr = p.pathStr;
					// arankedPath.add(totalCost, endVertex);
					// change to an arraylist
					return p;
				}
				
//				System.out.println("Leave from: " + p.pathStr.charAt(0) + " -> Final Destination:  " + p.pathStr.charAt(p.pathStr.length()-1)  + " for approx. " + p.cost);
	
				if (!vertices.contains(p.vertex)) {
					vertices.add(p.vertex);
					ArrayList<Edge> children = graph.getChildren(p.vertex);
					for (Edge e : children) {
						if (!vertices.contains(e.toVertex.symbol)) {
							queue.add(new Path(e.toVertex.symbol,
									p.cost + (Graph.useDistCost ? e.distCost : e.timeCost),
									p.pathStr));
						}
						
					}

				}
				
			}
			return null;
		}

		public static Path shortestTimePath(Graph graph, String from, String endVertex) {
			totalCost = 0;
			PriorityQueue<Path> queue = new PriorityQueue<Path>();
			ArrayList<String> vertices = new ArrayList<String>();

			queue.add(new Path(from, 0, ""));
			
			while (!queue.isEmpty()) {
				int curr = 0;
				Path p = queue.remove();
				if (p.vertex.equals(endVertex)) {
					pathStr = p.pathStr;
					// arankedPath.add(totalCost, endVertex);
					// change to an arraylist
					return p;
				}
				
//				System.out.println("Leave from: " + p.pathStr.charAt(0) + " -> Final Destination:  " + p.pathStr.charAt(p.pathStr.length()-1)  + " for approx. " + p.cost);
	
				if (!vertices.contains(p.vertex)) {
					vertices.add(p.vertex);
					ArrayList<Edge> children = graph.getChildren(p.vertex);
					for (Edge e : children) {
						if (!vertices.contains(e.toVertex.symbol)) {
							queue.add(new Path(e.toVertex.symbol,
									p.cost + (Graph.useDistCost ? e.timeCost: e.distCost ),
									p.pathStr));
						}
						
					}

				}
				
			}
			return null;
		}
		
		public static Path leastAmountOfStops(Graph graph, String from, String endVertex) {
			totalCost = 0;
			PriorityQueue<Path> queue = new PriorityQueue<Path>();
			ArrayList<String> vertices = new ArrayList<String>();

			queue.add(new Path(from, 0, ""));
			
			while (!queue.isEmpty()) {
				int curr = 0;
				Path p = queue.remove();
				if (p.vertex.equals(endVertex)) {
					pathStr = p.pathStr;
					// arankedPath.add(totalCost, endVertex);
					// change to an arraylist
					return p;
				}
				
//				System.out.println("Leave from: " + p.pathStr.charAt(0) + " -> Final Destination:  " + p.pathStr.charAt(p.pathStr.length()-1)  + " for approx. " + p.cost);
	
				if (!vertices.contains(p.vertex)) {
					vertices.add(p.vertex);
					ArrayList<Edge> children = graph.getChildren(p.vertex);
					for (Edge e : children) {
						if (!vertices.contains(e.toVertex.symbol)) {
							queue.add(new Path(e.toVertex.symbol,
									p.cost + (Graph.useDistCost ? e.timeCost: e.leastAmountOfStops ),
									p.pathStr));
						}
						
					}

				}
				
			}
			return null;
		}


		@Override
		public String toString() {
			return "Dijkstra [p=" + p + "]";
		}
		
	}
	
	

//				if (p.to == null) {
//					System.out.println("Leave from: " + p.pathStr.charAt(0) + " -> Final Destination:  " + endVertex);
//				}
				
//					
//				 System.out.println("Leave from: " + p.from + " "  + p.from.address + " -> To: " + p.to + " "  + p.to.address + " for approx. " + p.cost);
				
//				int currentSymbolFrom =  p.pathStr.charAt(0);
//				int currentSymbolTo =   p.pathStr.charAt(p.pathStr.length()-1);
//				
//				
//				System.out.println("Leave from: " + currentSymbolFrom + " -> Final Destination:  " + currentSymbolFrom  + " for approx. " + p.cost);
//				
				
				// Steps
				// System.out.println("Path: " + p.pathStr + " " + "Path: " + p.cost );

			
//			while (!queue.isEmpty()) {
//				Path p = queue.remove();
//				if (p.vertex.equals(endVertex)) {
//					//pathStr = p.pathStr;
//					rankedPath.add(totalCost, endVertex);
//					//change to an arraylist
//					return p;
//				}
				
				

	
//		public static ArrayList<Path> shortestPath(Graph g, Vertex to, Vertex from, String pathStr) {
//
//			PriorityQueue<Path> queue = new PriorityQueue<Path>();
//			ArrayList<Path> paths = new ArrayList<Path>();
//			ArrayList<Edge> edges = new ArrayList<Edge>();
//			ArrayList<Path> visited = new ArrayList<Path>();
//
//			queue.add(new Path (from, 0, to, pathStr));
//
//			while (!queue.isEmpty()) {
//				Path nextEntry = queue.remove();
//				if(visited.contains(nextEntry)) {
//					continue;
//				}
//
//				else {
//					// 	currVertex = nextVertex.vertex
//					//	currCost = nextVertex.cost
//					//	currPath = nextVertex.pathStr
//					//	for every unvisited neighbor to currVertex, V:
//					//	nextCost = currCost + edge cost of currVertex → V
//					//	nextPath = currPath with V appended
//					//	nextState = new State(V, nextCost, nextPath)
//					//	priorityQueue.add(nextState)
//				}
//			}
//			return visited;
//		}
			
	


	
// ----------------------------------------------------- Attempt 1 -----------------------------------------
//	import java.util.ArrayList;
//	import java.util.HashMap;
//	import java.util.List;


//public class Dijkstra {
//	
//	private static int totalCost;
//	// to --> start
//	public Vertex to;
//	
//	// from --> from
//	public Vertex from;
//	
//	public String pathStr;
//	public int timeCost;
//	public int distCost;
//	public Vertex vertex;
//
//	public static ArrayList<Path> shortestPath(Graph g, Vertex to, Vertex from, String pathStr) {
//		
//		PriorityQueue<Path> queue = new PriorityQueue<Path>();
//		ArrayList<Path> paths = new ArrayList<Path>();
//		ArrayList<Edge> edges = new ArrayList<Edge>();
//		ArrayList<Path> visited = new ArrayList<Path>();
//		
//		while (!queue.isEmpty()) {
//			queue.add(new Path(from, totalCost, to, pathStr));
//			
//			Path nextEntry = queue.remove();
//			if(visited.contains(nextEntry)) {
//				continue;
//			}
//			if (from == to) {
//				visited.add(new Path(from, totalCost, to, pathStr));
//		        return visited;
//			}
//			
//				else {
//					// 	currVertex = nextVertex.vertex
//					//	currCost = nextVertex.cost
//					//	currPath = nextVertex.pathStr
//					//	for every unvisited neighbor to currVertex, V:
//					//	nextCost = currCost + edge cost of currVertex → V
//					//	nextPath = currPath with V appended
//					//	nextState = new State(V, nextCost, nextPath)
//					//	priorityQueue.add(nextState)
//				}
//			}
//			return visited;
//		}
//	}

//---------------------------------------------------Attempt 2----------------------------------------------

	//import java.util.ArrayList;
	//import java.util.HashMap;
	//import java.util.List;
	//
	//public class Dijkstra {
	//	
	//	private int totalCost;
	//	public Vertex to;
	//	public Vertex from;
	//	public String pathStr;
	//	public int timeCost;
	//	public int distCost;
	//	public Vertex vertex;
	//	private ArrayList<Path> paths;
	//
	//	public ArrayList Path (Vertex from, int totalCost, Vertex to, String pathStr) {
	//		this.totalCost = totalCost;
	//		this.from = from;
	//		this.to = to;
	//		String fromStr = from.toString();
	//		String toStr = to.toString();
	//		Vertex[] visited = {};
	//		this.pathStr = pathStr.toString();
	//		return paths;
	//	}
	//
	//	public static List<Path> shortestPath(Graph g, Vertex to, Vertex from, String pathStr) {
	//		
	//		PriorityQueue<Path> queue = new PriorityQueue<Path>();
	//		ArrayList<Path> paths = new ArrayList<Path>();
	//		ArrayList<Edge> edges = new ArrayList<Edge>();
	//		ArrayList<Path> visited = new ArrayList<Path>();
	//		
	//		queue.add(new Path (from, 0, to, pathStr));
	//		
	//		while (!queue.isEmpty()) {
	//			Path nextEntry = queue.remove();
	//			if(visited.contains(nextEntry)) {
	//				continue;
	//			}
	//			visited.add(nextEntry);
	//			if(from.getLast() == to)
	//				return visited;
	//		}
	//	}
	//		
	//}
