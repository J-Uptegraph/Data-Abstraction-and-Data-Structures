import java.awt.Graphics;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Graph {
	public static boolean useDistCost = true;
	public static boolean returnAddress = false;
	
	public static HashMap<String, Vertex> vertices;
	public static ArrayList<Edge> edges;
	
	public Graph(String fileName, int xOffset, int yOffset) {
		vertices = new HashMap<String, Vertex>();
		edges = new ArrayList<Edge>();
		String[] parts;
		
		try(Scanner fin = new Scanner(new File(fileName))){
			while(fin.hasNextLine()) {
				parts = fin.nextLine().split("\t");
				if (parts[0].equals("<Nodes>")) {
					fin.nextLine();
					// Name and Address
					while(true) {
						parts = fin.nextLine().split("\t");
						if (parts[0].equals("</Nodes>")) break;
						// Modified
						vertices.put(parts[0], new Vertex(
								parts[0],
								parts[1],
								Integer.parseInt(parts[2])+ xOffset,
								Integer.parseInt(parts[3])+ yOffset));
					}
				} else if (parts[0].equals("<Edges>")) {
					fin.nextLine();
					while(true) {
						parts = fin.nextLine().split("\t");
						if (parts[0].equals("</Edges>")) break;
						edges.add(new Edge(
								vertices.get(parts[0]),
								vertices.get(parts[1]),
								Integer.parseInt(parts[2]),
								Integer.parseInt(parts[3]),
								Integer.parseInt(parts[4])
							));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Workhorse constructor
	public Graph(String fileName) {
		this(fileName, 0, 0);
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Edge> getChildren(String vertex) {
		ArrayList<Edge> children = new ArrayList<>();
		for(Edge e : edges)
			if(e.fromVertex.symbol.equals(vertex)) {
				children.add(e);
			}
		return children;
	}

	public Vertex getVertexAddress(String key) {
		return vertices.get(key);
	}
	
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (Edge e: edges)
		s.append(e).append("\n");
		return s.toString();
	}
	
	// New Code
	public void draw(Graphics g) {
		for (Edge e : edges) {
			e.draw(g);
		}
	}

	public ArrayList<Vertex> vertices() {
		ArrayList<Vertex> vertexValues = new ArrayList<Vertex>();
		vertices.forEach((key, value) -> {
			vertexValues.add(value);
		});
		return vertexValues;
	}
}
