import java.util.ArrayList;

public class Path implements Comparable<Path>{
	public Vertex to;
	public Vertex from;
	public String vertex;
	public String pathStr;
	public int cost;

//	public Path(String vertex, int cost, String pathStr) { 
//		this.vertex = vertex;
//		this.cost = cost;
//		this.pathStr = pathStr;
//	}

	public Path (String vertex, int totalCost, String pathStr) {
		this.cost = totalCost;
		this.from = from;
		this.pathStr = pathStr + vertex;
		this.vertex = vertex;

		Vertex[] visited = {};
	}

	public int compareTo(Path other) {
		return cost - other.cost;    // lower cost goes first
	}

	public static String path = "";
	
	public String getLast() {
		return (path.length() == 0) ? "" : path.charAt(path.length() - 1) + "";
	}

	@Override
		public String toString() {
			return Dijkstra.pathStr;
		}
		//return paths;


}